package ast;

import java.util.ArrayList;
import java.util.Collection;

import lib.Pair;
import parser.StipulaBaseVisitor;
import parser.StipulaParser;

public class Interpreter extends StipulaBaseVisitor {
	Program program = null;
	int index = 0;

	public Program getProgram() {
		return program;
	}

	@Override
	public Program visitProg(StipulaParser.ProgContext ctx) {
		Agreement agr = null;
		if(ctx.agreement()!=null) {
			agr = (Agreement) visitAgreement(ctx.agreement());
		}

		String progId = ctx.contract_id.getText();
		ArrayList<Field> progFields = new ArrayList<Field>();
		ArrayList<Asset> progAssets = new ArrayList<Asset>();

		String tmpState = null;
		if(ctx.assetdecl()!=null) {
			progAssets = (ArrayList<Asset>) visitAssetdecl(ctx.assetdecl());
		}
		if(ctx.fielddecl()!=null) {
			progFields = (ArrayList<Field>) visitFielddecl(ctx.fielddecl());
		}

		if(progAssets.size()==0) {
			progAssets = null;
		}

		if(progFields.size()==0) {
			progFields = null;
		}

		if(ctx.agreement()!=null) {
			tmpState = ctx.agreement().state().getText();
		}

		// FIXED: Initialize program first, then discover ALL parties.
		program = new Program(progId, progFields, progAssets, new ArrayList<Party>(), tmpState);

		if(ctx.agreement()!=null) {
			program.addAgreement(agr);
			if (agr.getParties() != null) {
				for(Party disp : agr.getParties()){
					addPartyIfNotExists(disp);
				}
			}
		}

		// FIXED: Iterate through all functions to find every party (like B and C).
		for(StipulaParser.FunContext f : ctx.fun()) {
			Contract cnt = (Contract) visitFun(f);
			if (cnt.getParty() != null) {
				for (Party p : cnt.getParty()) {
					addPartyIfNotExists(p);
				}
			}
			program.addContract(cnt);
		}

		// FIXED: After finding all parties, update the global party list for each contract.
		for (Contract cnt : program.getContracts()) {
			cnt.setGlobalParties(program.getParties());
			if(cnt.getParty()==null) {
				cnt.setParties(program.getParties());
			}
		}

		return program ;
	}

	// Helper function to avoid duplicate parties.
	private void addPartyIfNotExists(Party partyToAdd) {
		if (program.getParties() == null) {
			program.addParties(new ArrayList<>());
		}
		boolean found = false;
		for (Party existingParty : program.getParties()) {
			if (existingParty.getId().equals(partyToAdd.getId())) {
				found = true;
				break;
			}
		}
		if (!found) {
			program.addParty(partyToAdd);
		}
	}


	@Override
	public ArrayList<Asset> visitAssetdecl(StipulaParser.AssetdeclContext ctx) {
		ArrayList<Asset> retAssets = new ArrayList<Asset>();
		for(int i=0; i<ctx.idAsset.size(); i++) {
			Asset tmpAsset = new Asset(ctx.idAsset.get(i).getText());
			retAssets.add(tmpAsset);
		}
		return retAssets;
	}

	@Override
	public ArrayList<Field> visitFielddecl(StipulaParser.FielddeclContext ctx) {
		ArrayList<Field> retFields = new ArrayList<Field>();
		for(int i=0; i<ctx.idField.size(); i++) {
			Field tmpField = new Field(ctx.idField.get(i).getText());
			retFields.add(tmpField);
		}
		return retFields;
	}

	@Override
	public Agreement visitAgreement(StipulaParser.AgreementContext ctx) {
		ArrayList<Party> disp = new ArrayList<Party>();
		for(StipulaParser.PartyContext n : ctx.party()) {
			Party tmp = new Party(n.getText());
			disp.add(tmp);
		}

		ArrayList<Pair<Party,ArrayList<Field>>> vals = new ArrayList<Pair<Party,ArrayList<Field>>>();
		for(StipulaParser.AssignContext ac : ctx.assign()) {
			vals.addAll((Collection<? extends Pair<Party, ArrayList<Field>>>) visitAssign(ac));
		}
		ArrayList<Pair<Party,ArrayList<Field>>> valsToRet = new ArrayList<Pair<Party,ArrayList<Field>>>();
		Pair<Party,ArrayList<Field>> tmp = null;
		boolean found = false;
		ArrayList<String> tmpDisp = new ArrayList<String>();
		ArrayList<Field> tmpArray = new ArrayList<Field>();
		for(int i=0; i<vals.size(); i++) {
			found = false;
			tmpArray = new ArrayList<Field>();
			for(int j=i+1; j<vals.size()+1; j++) {
				if(j==vals.size() && !tmpDisp.contains(vals.get(i).getKey().getId()) &&  !found) {
					valsToRet.add(vals.get(i));
					tmpDisp.add(vals.get(i).getKey().getId());

				}
				else if(!tmpDisp.contains(vals.get(i).getKey().getId()) && vals.get(i).getKey().getId().equals(vals.get(j).getKey().getId())) {
					tmpDisp.add(vals.get(i).getKey().getId());
					found = true;
					for(Field f : vals.get(i).getValue()) {
						tmpArray.add(f);
					}
					for(Field f : vals.get(j).getValue()) {
						tmpArray.add(f);
					}
					tmp = new Pair(vals.get(i).getKey(),tmpArray);
					valsToRet.add(tmp);
				}


			}

		}



		Agreement agreement = new Agreement(disp,valsToRet);
		return agreement;
	}

	@Override
	public ArrayList<Pair<Party,ArrayList<Field>>> visitAssign(StipulaParser.AssignContext ctx) {
		ArrayList<Pair<Party,ArrayList<Field>>> toRet = new ArrayList<Pair<Party,ArrayList<Field>>> ();
		Pair<Party,ArrayList<Field>> pair = null;
		ArrayList<Field> fields = new ArrayList<Field>();
		for(StipulaParser.VardecContext d : ctx.vardec()) {
			Field tmp = new Field(d.getText());
			fields.add(tmp);
		}

		for(StipulaParser.PartyContext d : ctx.party()) {

			Party nd = new Party(d.getText());
			pair = new Pair(nd,fields);
			toRet.add(pair);
		}

		return toRet;
	}

	@Override
	public Contract visitFun(StipulaParser.FunContext ctx) {
		index++;
		ArrayList<Party> disp = new ArrayList<Party>();
		if(ctx.TILDE()!=null) {
			disp = null;
		}
		else {
			for(StipulaParser.PartyContext n : ctx.party()) {
				Party tmp = new Party(n.getText());
				disp.add(tmp);
			}
		}

		ArrayList<Field> fields = new ArrayList<Field>();
		if(ctx.vardec()!=null) {
			for(StipulaParser.VardecContext n : ctx.vardec()) {
				Field tmp = new Field(n.getText());
				fields.add(tmp);
			}
		}
		else {fields = null;}

		ArrayList<Asset> assets = new ArrayList<Asset>();
		if(ctx.assetdec()!=null) {
			for(StipulaParser.AssetdecContext n : ctx.assetdec()) {
				Asset tmp = new Asset(n.getText());
				assets.add(tmp);
			}
		}
		else {assets = null;}

		ArrayList<String> state1 = new ArrayList<String>();
		String state2 = null;
		if(ctx.state()!=null) {
			for(int i = 0; i<ctx.state().size(); i++) {
				String tmp = ctx.state().get(i).getText();
				if(i==ctx.state().size()-1) {state2 = tmp;}
				else {
					state1.add(tmp);
				}
			}
		}

		Contract newContract = new Contract(ctx.funId.getText(), fields, assets, disp, state1, state2, index);
		newContract.addFields(program.getFields());
		newContract.addAssets(program.getAssets());

		if(ctx.prec()!=null) {
			Expression conds = (Expression) visitPrec(ctx.prec());
			newContract.addPrecondition(conds);
		}

		for(StipulaParser.StatContext sc : ctx.stat()) {
			ArrayList<Pair<Expression,ArrayList<Statement>>>  ret = (ArrayList<Pair<Expression, ArrayList<Statement>>>) visitStat(sc);
			if(ret!=null) {
				for(Pair<Expression,ArrayList<Statement>> pair : ret) {
					if(pair.getKey()==null) {
						for(Statement stm : pair.getValue()) {
							newContract.addStatement(stm);
						}
					}
					else {
						newContract.addIfThenElse(ret);
					}
				}
			}
		}

		if(ctx.event()!=null) {
			for(StipulaParser.EventContext evn : ctx.event()) {
				Event event = (Event) visitEvent(evn);
				if(event != null) {
					event.addContract(newContract);
					program.addEvent(event);
				}
			}
		}

		return newContract;
	}


	@Override
	public Event visitEvent(StipulaParser.EventContext ctx) {
		String init = ctx.ID(0).toString();
		String end = ctx.ID(ctx.ID().size()-1).toString();
		ArrayList<Pair<Expression,ArrayList<Statement>>> eventStat = new ArrayList<Pair<Expression,ArrayList<Statement>>>();

		for(StipulaParser.StatContext stm : ctx.stat()) {
			eventStat.addAll((Collection<? extends Pair<Expression, ArrayList<Statement>>>) visitStat(stm));
		}

		Expression expr = (Expression) visitExpr(ctx.expr());
		Event eventToRet = new Event(init,end,eventStat,expr);
		return eventToRet;

	}

	@Override
	public ArrayList<Pair<Expression,ArrayList<Statement>>> visitStat(StipulaParser.StatContext ctx) {
		if (ctx.EMPTY() != null) {
			return null;
		}

		ArrayList<Pair<Expression,ArrayList<Statement>>> ret = new ArrayList<>();
		ArrayList<Statement> statements = new ArrayList<>();

		if (ctx.ASSETUP() != null) {
			Asset source;
			Asset target;
			Entity amountEntity;

			if (ctx.rightPlus != null) {
				source = new Asset(ctx.right.getText());
				target = new Asset(ctx.rightPlus.getText());
				amountEntity = new Entity(ctx.left.getText());
			} else {
				source = new Asset(ctx.left.getText());
				target = new Asset(ctx.right.getText());
				amountEntity = new Entity(ctx.left.getText());
			}

			Statement statement = new Statement(source, target, "ASSETUP", amountEntity);
			statements.add(statement);
			ret.add(new Pair<>(null, statements));

		} else if (ctx.FIELDUP() != null) {
			Field right = new Field(ctx.right.getText());
			if (ctx.left.expr() != null) {
				Expression expr = visitExpr(ctx.left.expr());
				statements.add(new Statement(expr, right, "FIELDUP"));
			} else {
				Field left = new Field(ctx.left.getText());
				statements.add(new Statement(left, right, "FIELDUP"));
			}
			ret.add(new Pair<>(null, statements));

		} else if (ctx.ifelse() != null) {
			return visitIfelse(ctx.ifelse());
		}

		return ret;
	}
	public ArrayList<Pair<Expression,ArrayList<Statement>>> visitIfelse(StipulaParser.IfelseContext ctx) {
		Expression condIf = (Expression) visitExpr(ctx.cond);
		ArrayList<Pair<Expression,ArrayList<Statement>>> toRet = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
		ArrayList<Statement> tmpStat = new ArrayList<Statement>();
		int start = 0;
		boolean flag = false;
		for(int i=start; i<ctx.ifBranch.size() && !flag; i++) {
			if(ctx.ifBranch.get(i).getText().equals("_")) {
				flag = true;
				//start = i+1;
			}
			else {
				ArrayList<Pair<Expression,ArrayList<Statement>>> tmpRet = visitStat(ctx.ifBranch.get(i));
				for(Pair<Expression,ArrayList<Statement>> pair : tmpRet) {
					if(pair.getKey()==null) {
						for(Statement stm : pair.getValue()) {
							tmpStat.add(stm);
						}
					}
				}

			}
		}
		Pair<Expression,ArrayList<Statement>> tmp = new Pair<Expression,ArrayList<Statement>>(condIf,tmpStat);
		toRet.add(tmp);
		if(ctx.condElseIf!=null) {
			for(StipulaParser.ExprContext expr : ctx.condElseIf) {
				flag = false;
				tmpStat = new ArrayList<Statement>();

				for(int i=start; i<ctx.elseIfBranch.size() && !flag; i++) {
					if(ctx.elseIfBranch.get(i).getText().equals("_")) {
						flag = true;
						start = i+1;
					}
					else {
						ArrayList<Pair<Expression,ArrayList<Statement>>> tmpRet = visitStat(ctx.elseIfBranch.get(i));
						for(Pair<Expression,ArrayList<Statement>> pair : tmpRet) {
							if(pair.getKey()==null) {
								for(Statement stm : pair.getValue()) {
									tmpStat.add(stm);
								}
							}
						}
					}
				}

				tmp = new Pair<Expression,ArrayList<Statement>>((Expression) visitExpr(expr),tmpStat);
				toRet.add(tmp);
			}
		}
		if(ctx.elseBranch!=null) {
			tmpStat = new ArrayList<Statement>();
			for(StipulaParser.StatContext stm : ctx.elseBranch) {
				ArrayList<Pair<Expression,ArrayList<Statement>>> tmpRet = visitStat(stm);
				for(Pair<Expression,ArrayList<Statement>> pair : tmpRet) {
					if(pair.getKey()==null) {
						for(Statement stm2 : pair.getValue()) {
							tmpStat.add(stm2);
						}
					}
				}
			}
			tmp = new Pair<Expression,ArrayList<Statement>>(new Expression(new Entity("_")),tmpStat);
			toRet.add(tmp);
		}

		return toRet;
	}

	public Expression visitPrec(StipulaParser.PrecContext ctx) {

		Expression cond = (Expression) visitExpr(ctx.expr());

		return cond;
	}

	@Override
	public Expression visitExpr(StipulaParser.ExprContext ctx) {
		if (ctx.right == null) {
			return visitTerm(ctx.left);
		}
		else {
			Expression leftExpr = visitTerm(ctx.left);
			Expression rightExpr = visitExpr(ctx.right);
			String op = ctx.operator.getText();
			return new Expression(leftExpr, rightExpr, op);
		}
	}

	@Override
	public Expression visitTerm(StipulaParser.TermContext ctx) {
		if (ctx.right == null) {
			return visitFactor(ctx.left);
		}
		else {
			Expression leftExpr = visitFactor(ctx.left);
			Expression rightExpr = visitTerm(ctx.right);
			String op = ctx.operator.getText();
			return new Expression(leftExpr, rightExpr, op);
		}
	}

	@Override
	public Expression visitFactor(StipulaParser.FactorContext ctx) {
		if (ctx.right == null) {
			return visitValue(ctx.left);
		}
		else {
			Expression leftExpr = visitValue(ctx.left);
			Expression rightExpr = visitValue(ctx.right);
			String op = ctx.operator.getText();
			return new Expression(leftExpr, rightExpr, op);
		}
	}

	public Expression visitValue(StipulaParser.ValueContext ctx) {
		Expression ret = null;
		if(ctx.NOW()!=null) {

			ret = new Expression(new Entity(ctx.NOW().getText()),null);
		}
		else if (ctx.TRUE()!=null ) {

			ret = new Expression(new Entity(ctx.TRUE().getText()),null);
		}
		else if (ctx.FALSE()!=null ) {

			ret = new Expression(new Entity(ctx.FALSE().getText()),null);
		}
		else if (ctx.EMPTY()!=null) {

			ret = new Expression(new Entity(""),null);
		}
		else if (ctx.RAWSTRING()!=null) {
			ret = new Expression(new Entity(ctx.RAWSTRING().getText()),null);
		}
		else if (ctx.ID()!=null) {
			ret = new Expression(new Entity(ctx.ID().getText()),null);
		}
		else if(ctx.number()!=null) {

			ret = new Expression(new Entity(ctx.number().getText()),null);
		}
		else if(ctx.expr()!=null){
			ret = visitExpr(ctx.expr());
		}
		return ret;
	}

}
