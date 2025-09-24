import org.antlr.v4.runtime.*;
import parser.StipulaBaseListener;
import parser.StipulaParser;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    static class ContractIR {
        String name;
        String initState;
        List<String> parties = new ArrayList<>();
        List<String> assets = new ArrayList<>();
        Map<String, String> assetTypes = new HashMap<>();
        List<String> fields = new ArrayList<>();
        List<FunctionIR> functions = new ArrayList<>();
        List<EventIR> events = new ArrayList<>();
        List<Scenario> scenarios = new ArrayList<>();
    }

    static class Statement {
        String text;
        boolean isConditional = false;
        boolean isEvent = false;
        Conditional conditional;
        EventIR event;
    }

    static class Conditional {
        String condition;
        List<Statement> body = new ArrayList<>();
    }

    static class FunctionIR {
        String startState;
        String party;
        String name;
        String originalName;
        String param;
        String assetInput;
        String condition;
        String nextState;
        List<Statement> stmts = new ArrayList<>();
    }

    static class EventIR {
        String name;
        List<Statement> stmts = new ArrayList<>();
    }

    static class Scenario {
        String name;
        List<FunctionIR> path = new ArrayList<>();
        List<FunctionIR> cycle = new ArrayList<>();
    }

    static class HarvestListener extends StipulaBaseListener {
        private final TokenStream tokens;
        final ContractIR ir = new ContractIR();
        private final Map<String, Integer> functionNameCounts = new HashMap<>();

        HarvestListener(StipulaParser parser, TokenStream tokens) { this.tokens = tokens; }
        @Override public void enterContract_name(StipulaParser.Contract_nameContext ctx) { ir.name = ctx.getText(); }
        @Override public void enterInit_state(StipulaParser.Init_stateContext ctx) { ir.initState = ctx.getText(); }
        @Override public void enterAsset_variables(StipulaParser.Asset_variablesContext ctx) { addCSV(idList(ctx.getText()), ir.assets); }
        @Override public void enterField_variables(StipulaParser.Field_variablesContext ctx) { addCSV(idList(ctx.getText()), ir.fields); }
        @Override public void enterAgreement_definiton(StipulaParser.Agreement_definitonContext ctx) { addCSV(idList(tokens.getText(ctx.contractParties)), ir.parties); }

        @Override
        public void enterMethod_definition(StipulaParser.Method_definitionContext ctx) {
            FunctionIR f = new FunctionIR();
            f.startState = ctx.state(0).getText().substring(1);
            f.party = ctx.party().getText();
            f.originalName = ctx.method_name().getText();
            int count = functionNameCounts.getOrDefault(f.originalName, 0);
            f.name = count == 0 ? f.originalName : f.originalName + count;
            functionNameCounts.put(f.originalName, count + 1);
            if (ctx.params() != null) f.param = ctx.params().getText();
            if (ctx.asset_input() != null) f.assetInput = ctx.asset_input().getText();
            if (ctx.condition() != null) f.condition = stripParens(ctx.condition().getText());
            f.nextState = ctx.next_state().getText().substring(1);
            if (ctx.method_body() != null) f.stmts.addAll(ctx.method_body().operation().stream().map(this::parseOperation).collect(Collectors.toList()));
            if (ctx.logical_expression() != null) f.stmts.addAll(ctx.logical_expression().stream().map(this::parseEvent).collect(Collectors.toList()));
            ir.functions.add(f);
        }
        private Statement parseOperation(StipulaParser.OperationContext opCtx) {
            Statement stmt = new Statement();
            if (opCtx.conditional_function() != null) {
                stmt.isConditional = true;
                stmt.conditional = new Conditional();
                StipulaParser.Conditional_functionContext clause = opCtx.conditional_function();
                stmt.text = tokens.getText(clause);
                if (clause.condition() != null) stmt.conditional.condition = stripParens(clause.condition().getText());
                stmt.conditional.body = clause.operation().stream().map(this::parseOperation).collect(Collectors.toList());
            } else {
                stmt.text = tokens.getText(opCtx).trim();
            }
            return stmt;
        }
        private Statement parseEvent(StipulaParser.Logical_expressionContext eventCtx) {
            Statement stmt = new Statement();
            stmt.isEvent = true;
            EventIR ev = new EventIR();
            ev.name = "event" + (ir.events.size() + 1);
            ev.stmts = eventCtx.operation().stream().map(this::parseOperation).collect(Collectors.toList());
            ir.events.add(ev);
            stmt.event = ev;
            return stmt;
        }
    }

    private static String cap(String s) { if (s == null || s.isEmpty()) return s; return s.substring(0,1).toUpperCase() + s.substring(1); }
    private static List<String> idList(String t) { List<String> o = new ArrayList<>(); Matcher m = Pattern.compile("\\b([A-Za-z_][A-Za-z0-9_]*)\\b").matcher(t); while (m.find()) o.add(m.group(1)); return o; }
    private static void addCSV(List<String> s, List<String> d) { for (String str : s) if (!d.contains(str)) d.add(str); }
    private static String stripParens(String s) { return s.startsWith("(") && s.endsWith(")") ? s.substring(1, s.length() - 1) : s; }
    private static String findAssetFromContext(String quantityVar, ContractIR ir, List<String> assets) {
        if (quantityVar == null) return "unknownAsset";
        if (assets != null) {
            for (String asset : assets) { if (quantityVar.equalsIgnoreCase(asset)) return asset; }
            for (String asset : assets) { if (quantityVar.toLowerCase().contains(asset.toLowerCase().replaceAll("\\d", ""))) return asset; }
            if (!assets.isEmpty()) return assets.get(0);
        }
        return "unknownAsset";
    }

    private static void inferAssetTypes(ContractIR ir) {
        for (FunctionIR f : ir.functions) {
            for (Statement stmt : f.stmts) {
                if (stmt.text == null) continue;
                Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(stmt.text);
                if (mTransfer.find()) {
                    String q = mTransfer.group(1).trim();
                    String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
                    if (targets.length > 1 && ir.assets != null) {
                        String assetName = targets[0].trim();
                        if (ir.assets.contains(assetName)) {
                            ir.assetTypes.put(assetName, "divisible");
                        }
                    }
                    if (q.contains("/") || q.contains("*") || q.contains("+") || q.contains("-")) {
                        String assetName = findAssetFromContext(q, ir, ir.assets);
                        if(ir.assets != null && ir.assets.contains(assetName)){
                            ir.assetTypes.put(assetName, "divisible");
                        }
                    }
                }
            }
        }
        if (ir.assets != null) {
            for (String asset : ir.assets) {
                ir.assetTypes.putIfAbsent(asset, "indivisible");
            }
        }
    }

    private static Map<String, String> analyzeStatementEffect(Statement stmt, ContractIR c, String actingParty, String paramPrefix) {
        Map<String, String> effects = new HashMap<>();
        if (stmt.isConditional) {
            stmt.conditional.body.forEach(s -> {
                effects.putAll(analyzeStatementEffect(s, c, actingParty, paramPrefix));
            });
            return effects;
        }

        if (stmt.isEvent || stmt.text == null) return effects;
        String text = stmt.text;

        Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(text);
        if (mAssign.find()) {
            String source = mAssign.group(1).trim();
            String target = mAssign.group(2);
            if (c.fields != null && c.fields.contains(target)) {
                effects.put(target, "set(" + paramPrefix + source + ")");
            } else if (c.parties != null && c.parties.contains(target) && c.fields != null && c.fields.contains(source)) {
                effects.put(target + cap(source), "set(" + paramPrefix + source + ")");
            }
            return effects;
        }

        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(text);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim();
            String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
            String param_q = paramPrefix + q;

            if (targets.length > 1) { // quantity -o asset, party
                String asset = targets[0].trim(); String party = targets[1].trim();
                effects.put(asset, " - " + param_q);
                effects.put(party + cap(asset), " + " + param_q);
            } else { // quantity_or_asset -o target
                String toTarget = targets[0].trim();
                String assetNameForTypeLookup = (c.assets != null && c.assets.contains(q)) ? q : toTarget;
                String assetType = c.assetTypes.getOrDefault(assetNameForTypeLookup, "indivisible");

                if (c.assets != null && c.assets.contains(q)) { // asset -o party
                    String assetName = q;
                    effects.put(assetName, "set(false)");
                    effects.put(toTarget + cap(assetName), "set(true)");
                } else if (c.assets != null && c.assets.contains(toTarget)) { // party to escrow
                    String assetName = toTarget;
                    if (assetType.equals("divisible")) {
                        effects.put(assetName, " + " + param_q);
                        if (actingParty != null) effects.put(actingParty + cap(assetName), " - " + param_q);
                    } else { // indivisible
                        effects.put(assetName, "set(true)");
                        if (actingParty != null) effects.put(actingParty + cap(assetName), "set(false)");
                    }
                } else if (c.parties.contains(toTarget)) { // payment
                    effects.put(toTarget, " + " + param_q);
                    if (actingParty != null) effects.put(actingParty, " - " + param_q);
                }
            }
        }
        return effects;
    }

    private static String buildEnsuresClauseForStatements(List<Statement> stmts, ContractIR c, String actingParty, String paramPrefix) {
        Map<String, String> simpleEffects = new LinkedHashMap<>();
        StringBuilder conditionalJml = new StringBuilder();

        List<Conditional> conditionalChain = new ArrayList<>();
        for (int i = 0; i < stmts.size(); i++) {
            Statement stmt = stmts.get(i);
            if (stmt.isConditional) {
                conditionalChain.add(stmt.conditional);
                for (int j = i + 1; j < stmts.size(); j++) {
                    Statement nextStmt = stmts.get(j);
                    if (nextStmt.isConditional && (nextStmt.text.startsWith("else if") || nextStmt.text.startsWith("else"))) {
                        conditionalChain.add(nextStmt.conditional);
                        i = j;
                    } else {
                        break;
                    }
                }

                List<String> branchClauses = new ArrayList<>();
                List<String> inverseConditions = new ArrayList<>();
                for (Conditional cond : conditionalChain) {
                    String branchBodyJml = buildEnsuresClauseForStatements(cond.body, c, actingParty, paramPrefix);
                    if (cond.condition != null) {
                        String currentCondition = cond.condition;
                        for(String p : inverseConditions) {
                            currentCondition = "(" + p + ") && " + currentCondition;
                        }
                        if (!branchBodyJml.isEmpty()) {
                            branchClauses.add("(" + currentCondition + " && " + branchBodyJml + ")");
                        }
                        inverseConditions.add("!(" + cond.condition + ")");
                    } else {
                        if (!branchBodyJml.isEmpty()) {
                            branchClauses.add("(" + String.join(" && ", inverseConditions) + " && " + branchBodyJml + ")");
                        }
                    }
                }
                if (conditionalJml.length() > 0) conditionalJml.append(" && ");
                conditionalJml.append("(").append(String.join(" || ", branchClauses)).append(")");
                conditionalChain.clear();
            } else {
                analyzeStatementEffect(stmt, c, actingParty, paramPrefix).forEach((var, change) -> {
                    String existing = simpleEffects.getOrDefault(var, "");
                    simpleEffects.put(var, existing + " " + change);
                });
            }
        }

        List<String> ensuresClauses = new ArrayList<>();
        simpleEffects.forEach((var, change) -> {
            String trimmedChange = change.trim();
            if (trimmedChange.startsWith("set(")) {
                String val = trimmedChange.substring(trimmedChange.indexOf('(') + 1, trimmedChange.indexOf(')'));
                ensuresClauses.add(var + (val.equals("true") || val.equals("false") ? " == " + val : " == " + val));
            } else {
                ensuresClauses.add(var + " == \\old(" + var + ")" + (trimmedChange.startsWith("+") || trimmedChange.startsWith("-") ? "" : " +") + change);
            }
        });

        if (conditionalJml.length() > 0) {
            ensuresClauses.add(conditionalJml.toString());
        }

        return String.join(" && ", ensuresClauses);
    }

    private static Set<String> getAssignedVars(Statement stmt, ContractIR c, String actingParty) {
        Set<String> vars = new HashSet<>();
        if (stmt.isConditional) { stmt.conditional.body.forEach(s -> vars.addAll(getAssignedVars(s, c, actingParty))); return vars; }
        if (stmt.isEvent || stmt.text == null) return vars;

        Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(stmt.text);
        if (mAssign.find()) {
            String source = mAssign.group(1).trim();
            String target = mAssign.group(2);
            if (c.fields != null && c.fields.contains(target)) {
                vars.add(target);
            }
            else if (c.parties != null && c.parties.contains(target) && c.fields != null && c.fields.contains(source)) {
                vars.add(target + cap(source));
            }
            return vars;
        }

        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(stmt.text);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim();
            String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
            if (targets.length > 1) {
                vars.add(targets[0].trim());
                vars.add(targets[1].trim() + cap(targets[0].trim()));
            } else {
                String toTarget = targets[0].trim();
                if (c.assets != null && c.assets.contains(q)) {
                    vars.add(q);
                    vars.add(toTarget + cap(q));
                }
                else if (c.assets != null && c.assets.contains(toTarget)) {
                    vars.add(toTarget);
                    if (actingParty != null) vars.add(actingParty + cap(toTarget));
                }
                else if (c.parties.contains(toTarget)) {
                    vars.add(toTarget);
                    if(actingParty != null) vars.add(actingParty);
                }
            }
        }
        return vars;
    }

    private static void analyzeControlFlow(ContractIR ir) { if (ir.initState == null) return; findPaths(ir.initState, new HashSet<>(), new ArrayList<>(), ir); }
    private static void findPaths(String currentState, Set<String> visitedStates, List<FunctionIR> currentPath, ContractIR ir) {
        visitedStates.add(currentState);
        List<FunctionIR> nextFunctions = ir.functions.stream().filter(f -> f.startState.equals(currentState)).collect(Collectors.toList());
        if (nextFunctions.isEmpty()) { if(!currentPath.isEmpty()){ Scenario sc = new Scenario(); sc.name = "seq" + (ir.scenarios.size() + 1); sc.path = new ArrayList<>(currentPath); ir.scenarios.add(sc); }
        } else {
            for (FunctionIR func : nextFunctions) {
                currentPath.add(func);
                if (visitedStates.contains(func.nextState)) {
                    int cycleStartIndex = -1;
                    for(int i = 0; i < currentPath.size(); i++) { if (currentPath.get(i).startState.equals(func.nextState)) { cycleStartIndex = i; break; } }
                    if (cycleStartIndex != -1) { Scenario sc = new Scenario(); sc.name = "seq" + (ir.scenarios.size() + 1); sc.path = new ArrayList<>(currentPath.subList(0, cycleStartIndex)); sc.cycle = new ArrayList<>(currentPath.subList(cycleStartIndex, currentPath.size())); ir.scenarios.add(sc); }
                } else { findPaths(func.nextState, visitedStates, currentPath, ir); }
                currentPath.remove(currentPath.size() - 1);
            }
        }
        visitedStates.remove(currentState);
    }

    static String emitJava(ContractIR c) {
        inferAssetTypes(c);
        analyzeControlFlow(c);
        StringBuilder sb = new StringBuilder();
        sb.append("public final class ").append(c.name).append(" {\n\n");
        emitVariables(sb, c);
        for (FunctionIR f : c.functions) emitFunction(sb, c, f);
        for (EventIR e : c.events) emitEvent(sb, c, e);
        for (Scenario s : c.scenarios) emitScenario(sb, c, s);
        sb.append("}\n");
        return sb.toString();
    }

    private static void emitFunction(StringBuilder sb, ContractIR c, FunctionIR f) {
        sb.append("    /*@ public normal_behavior\n");
        if (f.condition != null && !f.condition.isEmpty()) sb.append("      @ requires    ").append(f.condition).append(";\n");

        String ensuresClause = buildEnsuresClauseForStatements(f.stmts, c, f.party, "");
        if (!ensuresClause.isEmpty()) {
            sb.append("      @ ensures     ").append(ensuresClause).append(";\n");
        }

        Set<String> assigned = new TreeSet<>();
        f.stmts.forEach(s -> assigned.addAll(getAssignedVars(s, c, f.party)));
        if (!assigned.isEmpty()) sb.append("      @ assignable  ").append(String.join(", ", assigned)).append(";\n");
        sb.append("      @*/\n");
        String assetParamType = c.assetTypes.getOrDefault(findAssetFromContext(f.assetInput, c, c.assets), "indivisible").equals("divisible") ? "int" : "boolean";
        List<String> paramsList = new ArrayList<>();
        if (f.param != null) {
            if (f.param.contains(",")) { for (String p : f.param.split(",")) paramsList.add("int " + p.trim()); }
            else { paramsList.add("int " + f.param); }
        }
        if (f.assetInput != null) {
            String type = c.assetTypes.getOrDefault(f.assetInput, "indivisible").equals("divisible") ? "int" : "boolean";
            paramsList.add(type + " " + f.assetInput);
        }
        sb.append("    public final static void ").append(f.name).append("(").append(String.join(", ", paramsList)).append(") {\n");
        boolean isInsideConditional = false;
        for (Statement s : f.stmts) isInsideConditional = emitStatement(sb, c, f.party, s, 2, isInsideConditional);
        if (isInsideConditional) sb.append("    }\n");
        sb.append("    }\n\n");
    }

    private static void emitScenario(StringBuilder sb, ContractIR c, Scenario s) {
        sb.append("    /*@ public normal_behavior\n");
        Set<String> requires = new LinkedHashSet<>();
        s.path.stream()
                .filter(f -> f.condition != null && !f.condition.isEmpty())
                .forEach(f -> requires.add(f.condition));
        if (!s.cycle.isEmpty()) {
            requires.add("counter >= 0");
        }
        if (!requires.isEmpty()) {
            sb.append("      @ requires ").append(String.join(" &&\n      @          ", requires)).append(";\n");
        }

        boolean hasEvents = s.path.stream().anyMatch(f -> f.stmts.stream().anyMatch(st -> st.isEvent));

        if (hasEvents && s.cycle.isEmpty()) {
            List<String> outcomeClauses = new ArrayList<>();
            Map<String, String> cumulativeChanges = new LinkedHashMap<>();
            List<String> pathConditions = new ArrayList<>();

            for (FunctionIR f : s.path) {
                f.stmts.forEach(stmt -> {
                    analyzeStatementEffect(stmt, c, f.party, "").forEach((var, change) -> {
                        cumulativeChanges.put(var, cumulativeChanges.getOrDefault(var, "") + " " + change);
                    });
                });

                Optional<Statement> eventStmt = f.stmts.stream().filter(st -> st.isEvent).findFirst();
                if (eventStmt.isPresent()) {
                    String eventName = "ev_" + eventStmt.get().event.name;

                    List<String> ensuresForThisOutcome = new ArrayList<>();
                    cumulativeChanges.forEach((var, change) -> {
                        String trimmedChange = change.trim();
                        if (trimmedChange.startsWith("set(")) {
                            String val = trimmedChange.substring(trimmedChange.indexOf('(') + 1, trimmedChange.indexOf(')'));
                            ensuresForThisOutcome.add(var + " == " + val);
                        } else if (!trimmedChange.isEmpty()) {
                            ensuresForThisOutcome.add(var + " == \\old(" + var + ")" + (trimmedChange.startsWith("+") || trimmedChange.startsWith("-") ? "" : " +") + change);
                        }
                    });

                    List<String> currentConditions = new ArrayList<>(pathConditions);
                    currentConditions.add(eventName);

                    outcomeClauses.add("(" + String.join(" && ", currentConditions) + " && " + String.join(" && ", ensuresForThisOutcome) + ")");
                    pathConditions.add("!" + eventName);
                }
            }

            List<String> finalEnsures = new ArrayList<>();
            cumulativeChanges.forEach((var, change) -> {
                String trimmedChange = change.trim();
                if (trimmedChange.startsWith("set(")) {
                    String val = trimmedChange.substring(trimmedChange.indexOf('(') + 1, trimmedChange.indexOf(')'));
                    finalEnsures.add(var + " == " + val);
                } else if (!trimmedChange.isEmpty()) {
                    finalEnsures.add(var + " == \\old(" + var + ")" + (trimmedChange.startsWith("+") || trimmedChange.startsWith("-") ? "" : " +") + change);
                }
            });
            outcomeClauses.add("(" + String.join(" && ", pathConditions) + " && " + String.join(" && ", finalEnsures) + ")");

            sb.append("      @ ensures (\n      @   ").append(String.join("\n      @   || ", outcomeClauses)).append("\n      @ );\n");

        } else {
            Map<String, String> netChanges = new LinkedHashMap<>();
            Set<String> allVars = new HashSet<>();

            s.path.forEach(f -> f.stmts.forEach(stmt -> {
                analyzeStatementEffect(stmt, c, f.party, "").forEach((var, change) -> {
                    netChanges.put(var, netChanges.getOrDefault(var, "") + " " + change);
                    allVars.add(var);
                });
            }));

            if (!s.cycle.isEmpty()) {
                Map<String, String> cycleChanges = new LinkedHashMap<>();
                s.cycle.forEach(f -> f.stmts.forEach(stmt -> {
                    analyzeStatementEffect(stmt, c, f.party, "c_").forEach((var, change) -> {
                        cycleChanges.put(var, cycleChanges.getOrDefault(var, "") + " " + change);
                        allVars.add(var);
                    });
                }));

                cycleChanges.forEach((var, change) -> {
                    String existingChange = netChanges.getOrDefault(var, "");
                    String cycleEffect = change.trim().replaceAll("c_", "");
                    if (!cycleEffect.isEmpty()) {
                        netChanges.put(var, existingChange + " + counter * (" + cycleEffect + ")");
                    }
                });
            }

            List<String> ensuresClauses = new ArrayList<>();
            allVars.stream().sorted().forEach(var -> {
                String totalChange = netChanges.getOrDefault(var, "").trim();
                if (totalChange.contains("set(")) {
                    String val = totalChange.substring(totalChange.indexOf('(') + 1, totalChange.indexOf(')'));
                    ensuresClauses.add(var + " == " + val);
                } else if (!totalChange.isEmpty()) {
                    ensuresClauses.add(var + " == \\old(" + var + ")" + (totalChange.startsWith("+") || totalChange.startsWith("-") ? "" : " +") + totalChange);
                }
            });
            if (!ensuresClauses.isEmpty()) sb.append("      @ ensures ").append(String.join(" &&\n      @         ", ensuresClauses)).append(";\n");
        }

        sb.append("      @*/\n");
        sb.append("    public final static void ").append(s.name).append("() {\n");
        for (FunctionIR f : s.path) emitFunctionCall(sb, f, false);

        if (!s.cycle.isEmpty()) {
            sb.append("        int i=0;\n");
            sb.append("        /*@ loop_invariant 0 <= i && i <= counter;\n");

            Set<String> cycleParams = new HashSet<>();
            s.cycle.forEach(func -> {
                if(func.param != null) for(String p : func.param.split(",")) cycleParams.add(p.trim());
                if(func.assetInput != null) cycleParams.add(func.assetInput.trim());
            });
            s.cycle.stream()
                    .filter(f -> f.condition != null && !f.condition.isEmpty())
                    .forEach(f -> {
                        String finalCondition = f.condition;
                        for (String p : cycleParams) {
                            finalCondition = finalCondition.replaceAll("\\b"+p+"\\b", "c_"+p);
                        }
                        sb.append("          @ loop_invariant ").append(finalCondition).append(";\n");
                    });

            Map<String, String> loopIterationChanges = new LinkedHashMap<>();
            s.cycle.forEach(f -> {
                f.stmts.forEach(stmt -> {
                    Map<String, String> effects = analyzeStatementEffect(stmt, c, f.party, "c_");
                    effects.forEach((var, change) -> {
                        loopIterationChanges.put(var, loopIterationChanges.getOrDefault(var, "") + " " + change);
                    });
                });
            });
            loopIterationChanges.forEach((var, change) -> {
                if (!change.trim().isEmpty()) sb.append("          @ loop_invariant ").append(var).append(" == \\old(").append(var).append(") + i * (").append(change.trim()).append(");\n");
            });

            Set<String> loopAssignable = new TreeSet<>(); loopAssignable.add("i");
            s.cycle.forEach(f -> f.stmts.forEach(stmt -> loopAssignable.addAll(getAssignedVars(stmt, c, f.party))));
            if(!loopAssignable.isEmpty()) sb.append("          @ assignable ").append(String.join(", ", loopAssignable)).append(";\n");
            sb.append("          @ decreases counter - i;\n");
            sb.append("         @*/\n");
            sb.append("        while(i < counter) {\n");
            for (FunctionIR f : s.cycle) emitFunctionCall(sb, f, true);
            sb.append("            i++;\n");
            sb.append("        }\n");
        }
        sb.append("    }\n\n");
    }

    private static void emitEvent(StringBuilder sb, ContractIR c, EventIR e) {
        sb.append("    /*@ public normal_behavior\n");

        String ensuresClause = buildEnsuresClauseForStatements(e.stmts, c, null, "");
        if (!ensuresClause.isEmpty()) {
            sb.append("      @ ensures     ").append(ensuresClause).append(";\n");
        }

        Set<String> assigned = new TreeSet<>();
        e.stmts.forEach(s -> assigned.addAll(getAssignedVars(s, c, null)));
        if (!assigned.isEmpty()) sb.append("      @ assignable ").append(String.join(", ", assigned)).append(";\n");
        sb.append("      @*/\n");
        sb.append("    public final static void ").append(e.name).append("() {\n");
        boolean isInsideConditional = false;
        for (Statement s : e.stmts) isInsideConditional = emitStatement(sb, c, null, s, 2, isInsideConditional);
        if (isInsideConditional) sb.append("    }\n");
        sb.append("    }\n\n");
    }

    private static void emitVariables(StringBuilder sb, ContractIR c) {
        if (c.parties != null) {
            for (String p : c.parties) sb.append("    public static int ").append(p).append(";\n");
        }
        if (c.assets != null) {
            for (String a : c.assets) {
                String type = c.assetTypes.getOrDefault(a, "indivisible").equals("divisible") ? "int" : "boolean";
                if (c.parties != null) {
                    for (String p : c.parties) sb.append("    public static ").append(type).append(" ").append(p).append(cap(a)).append(";\n");
                }
                sb.append("    public static ").append(type).append(" ").append(a).append(";\n");
            }
        }
        if (c.fields != null) {
            for (String f : c.fields) sb.append("    public static int ").append(f).append(";\n");
        }

        Set<String> partyOwnedFields = new HashSet<>();
        for (FunctionIR f : c.functions) {
            for (Statement stmt : f.stmts) {
                if (stmt.text != null) {
                    Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(stmt.text);
                    if (mAssign.find()) {
                        String source = mAssign.group(1).trim();
                        String target = mAssign.group(2);
                        if (c.parties.contains(target) && c.fields.contains(source)) {
                            partyOwnedFields.add(target + cap(source));
                        }
                    }
                }
            }
        }
        for (String pof : partyOwnedFields) {
            sb.append("    public static int ").append(pof).append(";\n");
        }

        Set<String> allParams = new HashSet<>();
        for (Scenario s : c.scenarios) {
            s.path.forEach(f -> {
                if(f.param != null) { for(String p : f.param.split(",")) if (!p.trim().isEmpty()) allParams.add(p.trim()); }
                if(f.assetInput != null) allParams.add(f.assetInput);
            });
            s.cycle.forEach(f -> {
                if(f.param != null) { for(String p : f.param.split(",")) if (!p.trim().isEmpty()) allParams.add("c_" + p.trim()); }
                if(f.assetInput != null) allParams.add("c_" + f.assetInput);
            });
        }
        allParams.forEach(p -> sb.append("    public static int ").append(p).append(";\n"));
        if(c.scenarios.stream().anyMatch(s -> !s.cycle.isEmpty())) sb.append("    public static int counter;\n");
        for (int i = 1; i <= c.events.size(); i++) sb.append("    public static boolean ev_event").append(i).append(";\n");
        sb.append("\n");
    }

    private static void emitFunctionCall(StringBuilder sb, FunctionIR f, boolean isCyclic) {
        String indent = isCyclic ? "            " : "        ";
        List<String> args = new ArrayList<>();
        String prefix = isCyclic ? "c_" : "";
        if (f.param != null) {
            for(String p : f.param.split(",")) if(!p.trim().isEmpty()) args.add(prefix + p.trim());
        }
        if (f.assetInput != null) args.add(prefix + f.assetInput);
        sb.append(indent).append(f.name).append("(").append(String.join(", ", args)).append(");\n");
        f.stmts.stream().filter(st -> st.isEvent).forEach(st -> {
            sb.append(indent).append("if(ev_").append(st.event.name).append("){\n");
            sb.append(indent).append("    ").append(st.event.name).append("();\n");
            sb.append(indent).append("    return;\n");
            sb.append(indent).append("}\n");
        });
    }

    private static boolean emitStatement(StringBuilder sb, ContractIR c, String actingParty, Statement stmt, int indentLevel, boolean isContinuingConditional) {
        String indent = "    ".repeat(indentLevel);
        if (stmt.isConditional) {
            Conditional cond = stmt.conditional; String rawText = stmt.text;
            if (rawText.startsWith("if")) {
                if(isContinuingConditional) sb.append(indent.substring(4)).append("}\n");
                sb.append(indent).append("if (").append(cond.condition).append(") {\n");
            } else if (rawText.startsWith("else if")) { sb.append(indent.substring(4)).append("} else if (").append(cond.condition).append(") {\n");
            } else { sb.append(indent.substring(4)).append("} else {\n"); }
            boolean isInside = false;
            for(Statement s : cond.body) isInside = emitStatement(sb, c, actingParty, s, indentLevel + 1, isInside);
            if(isInside) sb.append(indent).append("    }\n");
            return true;
        }
        if (isContinuingConditional) sb.append(indent.substring(4)).append("}\n");
        String s = stmt.text; if (s == null || s.equals("_")) return false;

        Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(s);
        if (mAssign.find()) {
            String source = mAssign.group(1).trim();
            String target = mAssign.group(2);
            if (c.fields != null && c.fields.contains(target)) {
                sb.append(indent).append(target).append(" = ").append(source).append(";\n");
            }
            else if (c.parties != null && c.parties.contains(target) && c.fields != null && c.fields.contains(source)) {
                sb.append(indent).append(target).append(cap(source)).append(" = ").append(source).append(";\n");
            }
            return false;
        }

        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(s);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim();
            String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");

            if (targets.length > 1) {
                String assetName = targets[0].trim();
                String partyName = targets[1].trim();
                String assetType = c.assetTypes.getOrDefault(assetName, "indivisible");
                String sourceVar = assetName;
                String destVar = partyName + cap(assetName);
                String quantity = q.replace("/", "*1 / ");

                if (assetType.equals("divisible")) {
                    sb.append(indent).append(destVar).append(" += ").append(quantity).append(";\n");
                    sb.append(indent).append(sourceVar).append(" -= ").append(quantity).append(";\n");
                } else {
                    sb.append(indent).append(destVar).append(" = true;\n");
                    sb.append(indent).append(sourceVar).append(" = false;\n");
                }
            } else {
                String target = targets[0].trim();
                if (c.assets != null && c.assets.contains(q)) {
                    String assetName = q;
                    String partyName = target;
                    String assetType = c.assetTypes.getOrDefault(assetName, "indivisible");
                    String sourceVar = assetName;
                    String destVar = partyName + cap(assetName);

                    if (assetType.equals("divisible")) {
                        sb.append(indent).append(destVar).append(" += ").append(sourceVar).append(";\n");
                        sb.append(indent).append(sourceVar).append(" = 0;\n");
                    } else {
                        sb.append(indent).append(destVar).append(" = true;\n");
                        sb.append(indent).append(sourceVar).append(" = false;\n");
                    }
                }
                else if (c.assets != null && c.assets.contains(target)) {
                    String assetName = target;
                    String assetType = c.assetTypes.getOrDefault(assetName, "indivisible");
                    String sourceVar = actingParty + cap(assetName);
                    String destVar = assetName;

                    if (assetType.equals("divisible")) {
                        sb.append(indent).append(destVar).append(" += ").append(q).append(";\n");
                        sb.append(indent).append(sourceVar).append(" -= ").append(q).append(";\n");
                    } else {
                        sb.append(indent).append(destVar).append(" = true;\n");
                        sb.append(indent).append(sourceVar).append(" = false;\n");
                    }
                }
                else {
                    if (actingParty != null) {
                        sb.append(indent).append(target).append(" += ").append(q).append(";\n");
                        sb.append(indent).append(actingParty).append(" -= ").append(q).append(";\n");
                    }
                }
            }
        }
        return false;
    }
}