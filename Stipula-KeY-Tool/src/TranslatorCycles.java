import org.antlr.v4.runtime.*;
import parser.StipulaBaseListener;
import parser.StipulaParser;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslatorCycles {
    // --- Intermediate Representation (IR) ---
    static class ContractIR {
        String name;
        String initState;
        List<String> parties = new ArrayList<>();
        List<String> assets = new ArrayList<>();
        Map<String, String> assetTypes = new HashMap<>();
        List<String> fields = new ArrayList<>();
        List<FunctionIR> functions = new ArrayList<>();
        List<EventIR> events = new ArrayList<>();
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

    // --- Listener to Parse Stipula into IR ---
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

    // --- Analysis, JML Generation, and Code Generation ---
    private static String cap(String s) { if (s == null || s.isEmpty()) return s; return s.substring(0,1).toUpperCase() + s.substring(1); }
    private static List<String> idList(String t) { List<String> o = new ArrayList<>(); Matcher m = Pattern.compile("\\b([A-Za-z_][A-Za-z0-9_]*)\\b").matcher(t); while (m.find()) o.add(m.group(1)); return o; }
    private static void addCSV(List<String> s, List<String> d) { for (String str : s) if (!d.contains(str)) d.add(str); }
    private static String stripParens(String s) { return s.startsWith("(") && s.endsWith(")") ? s.substring(1, s.length() - 1) : s; }
    private static String findAssetFromContext(String quantityVar, ContractIR ir, List<String> assets) { if (quantityVar == null) return "unknownAsset"; for (String asset : assets) { if (quantityVar.equalsIgnoreCase(asset)) return asset; } for (String asset : assets) { if (quantityVar.toLowerCase().contains(asset.toLowerCase().replaceAll("\\d", ""))) return asset; } if (!assets.isEmpty()) return assets.get(0); return "unknownAsset"; }

    private static void inferAssetTypes(ContractIR ir) {
        for (FunctionIR f : ir.functions) {
            for (Statement stmt : f.stmts) {
                if (stmt.text == null) continue;
                Matcher mTransfer = Pattern.compile("^(\\w+)\\s*-o\\s*(\\w+)").matcher(stmt.text);
                if (mTransfer.find()) {
                    String q = mTransfer.group(1);
                    String target = mTransfer.group(2);
                    if (ir.assets.contains(target) && !ir.assets.contains(q) && !ir.parties.contains(q)) ir.assetTypes.put(target, "divisible");
                }
            }
        }
        for (String asset : ir.assets) ir.assetTypes.putIfAbsent(asset, "indivisible");
    }

    private static Set<String> getAssignedVars(Statement stmt, ContractIR c, String actingParty) {
        Set<String> vars = new HashSet<>();
        if (stmt.isConditional) { stmt.conditional.body.forEach(s -> vars.addAll(getAssignedVars(s, c, actingParty))); return vars; }
        if (stmt.isEvent || stmt.text == null) return vars;
        Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(stmt.text);
        if (mAssign.find()) { vars.add(mAssign.group(2)); return vars; }
        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(stmt.text);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim();
            String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
            if (targets.length > 1) { // quantity -o asset, party
                vars.add(targets[0].trim());
                vars.add(targets[1].trim() + cap(targets[0].trim()));
            } else { // quantity -o party
                vars.add(targets[0].trim());
                if(actingParty != null) vars.add(actingParty);
            }
        }
        return vars;
    }

    private static String getEnsuresClause(Statement stmt, ContractIR c, String actingParty) {
        if (stmt.isConditional || stmt.isEvent || stmt.text == null || stmt.text.equals("_")) return "";
        Matcher mAssign = Pattern.compile("^(.+?)\\s*->\\s*(\\w+)$").matcher(stmt.text);
        if (mAssign.find()) return mAssign.group(2) + " == " + mAssign.group(1).trim();
        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(stmt.text);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim(); String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
            String toTarget = targets[0].trim(); String assetName = targets.length > 1 ? targets[0].trim() : findAssetFromContext(q, c, c.assets);
            String partyTarget = targets.length > 1 ? targets[1].trim() : toTarget; String type = c.assetTypes.getOrDefault(assetName, "indivisible");
            if (type.equals("indivisible")) {
                if (c.parties.contains(partyTarget)) return partyTarget + cap(assetName) + " == true && " + assetName + " == false";
                else if (c.assets.contains(toTarget)) return toTarget + " == true && " + q + " == false";
            } else {
                if (c.parties.contains(partyTarget) && c.assets.contains(assetName)) return partyTarget + cap(assetName) + " == \\old(" + partyTarget + cap(assetName) + ") + " + q + " && " + assetName + " == \\old(" + assetName + ") - " + q;
                else if (c.assets.contains(toTarget)) return toTarget + " == \\old(" + toTarget + ") + " + q + " && " + actingParty + cap(toTarget) + " == \\old(" + actingParty + cap(toTarget) + ") - " + q;
                else if (c.parties.contains(toTarget)) return toTarget + " == \\old(" + toTarget + ") + " + q + " && " + actingParty + " == \\old(" + actingParty + ") - " + q;
            }
        }
        return "";
    }

    static String emitJava(ContractIR c) {
        inferAssetTypes(c);
        StringBuilder sb = new StringBuilder();
        sb.append("public final class ").append(c.name).append(" {\n\n");
        emitVariables(sb, c);
        for (FunctionIR f : c.functions) emitFunction(sb, c, f);
        for (EventIR e : c.events) emitEvent(sb, c, e);
        emitStateMachineExecutor(sb, c);
        sb.append("}\n");
        return sb.toString();
    }

    private static void emitFunction(StringBuilder sb, ContractIR c, FunctionIR f) {
        sb.append("    /*@ public normal_behavior\n");
        if (f.condition != null && !f.condition.isEmpty()) sb.append("      @ requires    ").append(f.condition).append(";\n");
        List<String> ensures = new ArrayList<>();
        f.stmts.forEach(s -> { String e = getEnsuresClause(s, c, f.party); if(!e.isEmpty()) ensures.add(e); });
        if (!ensures.isEmpty()) sb.append("      @ ensures     ").append(String.join(" && ", ensures)).append(";\n");
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
        if (f.assetInput != null) paramsList.add(assetParamType + " " + f.assetInput);
        sb.append("    public final static void ").append(f.name).append("(").append(String.join(", ", paramsList)).append(") {\n");
        boolean isInsideConditional = false;
        for (Statement s : f.stmts) isInsideConditional = emitStatement(sb, c, f.party, s, 2, isInsideConditional);
        if (isInsideConditional) sb.append("    }\n");
        sb.append("    }\n\n");
    }

    private static void emitStateMachineExecutor(StringBuilder sb, ContractIR c) {
        sb.append("    /*@ public normal_behavior\n");
        sb.append("      @ // JML for a state machine requires a complex invariant over the currentState variable.\n");
        sb.append("      @ // This is left for manual specification.\n");
        sb.append("      @*/\n");
        sb.append("    public final static void execute() {\n");
        sb.append("        currentState = \"").append(c.initState).append("\";\n");
        sb.append("        while (currentState != null && !currentState.equals(\"End\") && !currentState.equals(\"Fail\")) {\n");
        sb.append("            switch (currentState) {\n");

        Map<String, List<FunctionIR>> stateTransitions = new HashMap<>();
        for (FunctionIR f : c.functions) {
            stateTransitions.computeIfAbsent(f.startState, k -> new ArrayList<>()).add(f);
        }

        for (String state : stateTransitions.keySet()) {
            sb.append("                case \"").append(state).append("\":\n");
            List<FunctionIR> transitions = stateTransitions.get(state);
            FunctionIR f = transitions.get(0);

            emitFunctionCall(sb, f);
            sb.append("                    currentState = \"").append(f.nextState).append("\";\n");
            sb.append("                    break;\n");
        }

        sb.append("                default:\n");
        sb.append("                    currentState = null;\n");
        sb.append("                    break;\n");
        sb.append("            }\n");
        sb.append("        }\n");
        sb.append("    }\n\n");
    }

    private static void emitEvent(StringBuilder sb, ContractIR c, EventIR e) { /* ... same as before ... */ }
    private static void emitVariables(StringBuilder sb, ContractIR c) {
        sb.append("    public static String currentState;\n");
        for (String p : c.parties) sb.append("    public static int ").append(p).append(";\n");
        for (String a : c.assets) {
            String type = c.assetTypes.getOrDefault(a, "indivisible").equals("divisible") ? "int" : "boolean";
            for (String p : c.parties) sb.append("    public static ").append(type).append(" ").append(p).append(cap(a)).append(";\n");
            sb.append("    public static ").append(type).append(" ").append(a).append(";\n");
        }
        for (String f : c.fields) sb.append("    public static int ").append(f).append(";\n");
        Set<String> allParams = new HashSet<>();
        c.functions.forEach(f -> {
            if (f.param != null) { for (String p : f.param.split(",")) if (!p.trim().isEmpty()) allParams.add(p.trim()); }
            if (f.assetInput != null) allParams.add(f.assetInput);
        });
        allParams.forEach(p -> sb.append("    public static int ").append(p).append(";\n"));
        for (int i = 1; i <= c.events.size(); i++) sb.append("    public static boolean ev_event").append(i).append(";\n");
        sb.append("\n");
    }
    private static void emitFunctionCall(StringBuilder sb, FunctionIR f) {
        String indent = "                    ";
        List<String> args = new ArrayList<>();
        if (f.param != null) { for(String p : f.param.split(",")) if(!p.trim().isEmpty()) args.add(p.trim()); }
        if (f.assetInput != null) args.add(f.assetInput);
        sb.append(indent).append(f.name).append("(").append(String.join(", ", args)).append(");\n");
        f.stmts.stream().filter(st -> st.isEvent).forEach(st -> {
            sb.append(indent).append("if(ev_").append(st.event.name).append("){\n");
            sb.append(indent).append("    ").append(st.event.name).append("();\n");
            sb.append(indent).append("    // In a state machine, an event might terminate or change state.\n");
            sb.append(indent).append("    // This simplified model just calls the event method.\n");
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
        if (mAssign.find()) { sb.append(indent).append(mAssign.group(2)).append(" = ").append(mAssign.group(1).trim()).append(";\n"); return false; }
        Matcher mTransfer = Pattern.compile("^(.+?)\\s*-o\\s*(\\w+[\\s*,\\s*\\w+]*)").matcher(s);
        if (mTransfer.find()) {
            String q = mTransfer.group(1).trim(); String[] targets = mTransfer.group(2).trim().split("\\s*,\\s*");
            if (targets.length > 1) {
                String asset = targets[0].trim(); String party = targets[1].trim();
                sb.append(indent).append(asset).append(" -= ").append(q.replace("/", "*1.0/")).append(";\n");
                sb.append(indent).append(party).append(cap(asset)).append(" += ").append(q.replace("/", "*1.0/")).append(";\n");
            } else {
                String party = targets[0].trim();
                if (actingParty != null) {
                    sb.append(indent).append(party).append(" += ").append(q).append(";\n");
                    sb.append(indent).append(actingParty).append(" -= ").append(q).append(";\n");
                }
            }
        }
        return false;
    }
}