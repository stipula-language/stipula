package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import lib.Pair;
import parser.StipulaBaseListener;
import parser.StipulaBaseVisitor;
import parser.StipulaParser;
import parser.StipulaParser.PartyContext;
import parser.StipulaParser.*;

public class Interpreter extends StipulaBaseVisitor {
	Program program = null;
	int index = 0;

	public Program getProgram() {
		return program;
	}

	@Override
	public Program visitProg(ProgContext ctx) {
		Agreement agr = null;
		if(ctx.agreement()!=null) {
			agr = visitAgreement(ctx.agreement());
		}

		String progId = ctx.contract_id.getText();
		ArrayList<Field> progFields = new ArrayList<Field>();
		ArrayList<Asset> progAssets = new ArrayList<Asset>();
		ArrayList<Party> progParties = new ArrayList<Party>();
		ArrayList<String> progStates = new ArrayList<String>();
		String tmpState = null;
		if(ctx.assetdecl()!=null) {
			progAssets = visitAssetdecl(ctx.assetdecl());
		}
		if(ctx.fielddecl()!=null) {
			progFields = visitFielddecl(ctx.fielddecl());
		}


		tmpState = ctx.init_state.getText();

		if(progAssets.size()==0) {
			progAssets = null;
		}
		if(progParties.size()==0) {
			progParties = null;
		}
		if(progFields.size()==0) {
			progFields = null;
		}
		if(progStates.size()==0) {
			progStates = null;
		}
		program = new Program(progId, progFields, progAssets, progParties, tmpState);
		if(ctx.agreement()!=null) {
			program.addAgreement(agr);
			for(Party disp : agr.getParties()){
				boolean flag = false;
				if(program.getParties()!=null) {
					for(Party disp2 : program.getParties()) {
						if(disp2.getId().equals(disp.getId())) {
							flag = true;
						}
					}
					if(!flag) {
						program.addParty(disp);
					}
				}

			}
			if(program.getParties()==null) {
				program.addParties(agr.getParties());
			}
		}
		for(FunContext f : ctx.fun()) {
			Contract cnt = visitFun(f);
			if(cnt.getParty()==null) {
				cnt.setParties(program.getParties());
			}
			cnt.setGlobalParties(program.getParties());
			program.addContract(cnt);

		}
		return program ;
	}


	@Override
	public ArrayList<Asset> visitAssetdecl(AssetdeclContext ctx) {
		ArrayList<Asset> retAssets = new ArrayList<Asset>();
		for(int i=0; i<ctx.idAsset.size(); i++) {
			Asset tmpAsset = new Asset(ctx.idAsset.get(i).getText());
			retAssets.add(tmpAsset);
		}
		return retAssets;
	}

	@Override
	public ArrayList<Field> visitFielddecl(FielddeclContext ctx) {
		ArrayList<Field> retFields = new ArrayList<Field>();
		for(int i=0; i<ctx.idField.size(); i++) {
			Field tmpField = new Field(ctx.idField.get(i).getText());
			retFields.add(tmpField);
		}
		return retFields;
	}

	@Override
	public Agreement visitAgreement(AgreementContext ctx) {
		ArrayList<Party> disp = new ArrayList<Party>();
		for(PartyContext n : ctx.party()) {
			Party tmp = new Party(n.getText());
			disp.add(tmp);			
		}
		ArrayList<Field> fields = new ArrayList<Field>();
		for(VardecContext n : ctx.vardec()) {
			Field tmp = new Field(n.getText());
			fields.add(tmp);
		}
		ArrayList<Pair<Party,ArrayList<Field>>> vals = new ArrayList<Pair<Party,ArrayList<Field>>>();
		for(AssignContext ac : ctx.assign()) {
			vals.addAll(visitAssign(ac));
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



		Agreement agreement = new Agreement(disp,fields,valsToRet);
		return agreement;
	}

	@Override
	public ArrayList<Pair<Party,ArrayList<Field>>> visitAssign(AssignContext ctx) {
		ArrayList<Pair<Party,ArrayList<Field>>> toRet = new ArrayList<Pair<Party,ArrayList<Field>>> ();
		Pair<Party,ArrayList<Field>> pair = null;
		ArrayList<Field> fields = new ArrayList<Field>();
		for(VardecContext d : ctx.vardec()) {
			Field tmp = new Field(d.getText());
			fields.add(tmp);
		}

		for(PartyContext d : ctx.party()) {

			Party nd = new Party(d.getText());
			pair = new Pair(nd,fields);
			toRet.add(pair);
		}

		return toRet;
	}

	@Override
	public Contract visitFun(FunContext ctx) {
		index++;
		ArrayList<Party> disp = new ArrayList<Party>();
		if(ctx.TILDE()!=null) {
			disp = null;
		}
		else {
			for(PartyContext n : ctx.party()) {
				Party tmp = new Party(n.getText());
				disp.add(tmp);
			}
		}

		ArrayList<Field> fields = new ArrayList<Field>();
		if(ctx.vardec()!=null) {
			for(VardecContext n : ctx.vardec()) {
				Field tmp = new Field(n.getText());
				fields.add(tmp);
			}
		}
		else {fields = null;}

		ArrayList<Asset> assets = new ArrayList<Asset>();
		if(ctx.assetdec()!=null) {
			for(AssetdecContext n : ctx.assetdec()) {
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
			Expression conds = visitPrec(ctx.prec()); 
			newContract.addPrecondition(conds);
		}

		for(StatContext sc : ctx.stat()) {
			ArrayList<Pair<Expression,ArrayList<Statement>>>  ret = visitStat(sc);
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

		if(ctx.events()!=null) {
			for(EventsContext evn : ctx.events()) {
				Event event = visitEvents(evn);
				if(event != null) {
					event.addContract(newContract);
					program.addEvent(event);
				}
			}
		}

		return newContract;
	}


	@Override
	public Event visitEvents(EventsContext ctx) {
		if(ctx.EMPTY()==null) {
			String init = ctx.ID(0).toString();
			String end = ctx.ID(ctx.ID().size()-1).toString();
			ArrayList<Pair<Expression,ArrayList<Statement>>> eventStat = new ArrayList<Pair<Expression,ArrayList<Statement>>>();

			for(StatContext stm : ctx.stat()) {
				eventStat.addAll(visitStat(stm));
			}

			Expression expr = visitExpr(ctx.expr());
			Event eventToRet = new Event(init,end,eventStat,expr);
			return eventToRet;

		}
		else{
			return null;
		}
	}

	@Override
	public ArrayList<Pair<Expression,ArrayList<Statement>>>  visitStat(StatContext ctx) {
		ArrayList<Pair<Expression,ArrayList<Statement>>> ret = null;
		if(ctx.ASSETUP()!=null) {

			Asset left = null;
			Asset right = null;

			if(ctx.COMMA()!=null) {
				if(ctx.left.expr()!=null) {

					Expression expr = visitExpr(ctx.left.expr());

					double fract = 0;
					Entity fractExpr = null;
					if(expr.getRight() != null) {
						left = new Asset(expr.getRight().getId());
						right = new Asset(ctx.right.getText());
						try{
							fract = Double.parseDouble(expr.getLeft().getId());
						}
						catch(NumberFormatException e){
							fractExpr = new Entity(expr.getLeft().getId());
						}
					}
					else {
						left = new Asset(expr.getRLeftId());
						right = new Asset(ctx.rightPlus.getText());
						try{
							fract = Double.parseDouble(expr.getLLeftId());
						}
						catch(NumberFormatException e){
							fractExpr = new Entity((expr.getLLeftId()));
						}
					}

					ArrayList<Statement> tmpArray = new ArrayList<Statement>();
					if(fractExpr == null) {
						tmpArray.add(new Statement(left,right,"ASSETUP",fract));
					}
					else {
						tmpArray.add(new Statement(left,right,"ASSETUP",fractExpr));
					}
					Pair<Expression,ArrayList<Statement>> tmpPair =  new Pair<Expression,ArrayList<Statement>>(null,tmpArray);
					ret = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
					ret.add(tmpPair);
				}
				else{
					left = new Asset(ctx.right.getText());
					right = new Asset(ctx.rightPlus.getText());
					ArrayList<Statement> tmpArray = new ArrayList<Statement>();
					tmpArray.add(new Statement(left,right,"ASSETUP"));
					Pair<Expression,ArrayList<Statement>> tmpPair =  new Pair<Expression,ArrayList<Statement>>(null,tmpArray);
					ret = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
					ret.add(tmpPair);
				}

			}
			else if(ctx.left.expr()!=null) {

				Expression expr = visitExpr(ctx.left.expr());
				expr.printExpression();
				double fract = 0;
				Entity fractExpr = null;

				if(expr.getRight() != null) {
					left = new Asset(expr.getRight().getId());
					right = new Asset(ctx.right.getText());
					try{
						fract = Double.parseDouble(expr.getLeft().getId());
					}
					catch(NumberFormatException e){
						fractExpr = new Entity(expr.getLeft().getId());
					}
				}
				else {
					left = new Asset(expr.getRightComplexExpr().getRLeftId());
					right = new Asset(ctx.right.getText());
					try{
						fract = Double.parseDouble(expr.getLeftComplexExpr().getLLeftId());
					}
					catch(NumberFormatException e){
						fractExpr = new Entity((expr.getLeftComplexExpr().getLLeftId()));
					}
				}
				ArrayList<Statement> tmpArray = new ArrayList<Statement>();
				if(fractExpr == null) {
					tmpArray.add(new Statement(left,right,"ASSETUP",fract));
				}
				else {
					tmpArray.add(new Statement(left,right,"ASSETUP",fractExpr));
				}
				Pair<Expression,ArrayList<Statement>> tmpPair =  new Pair<Expression,ArrayList<Statement>>(null,tmpArray);
				ret = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
				ret.add(tmpPair);				
			}
			else {
				left = new Asset(ctx.left.getText());
				right = new Asset(ctx.right.getText());
				ArrayList<Statement> tmpArray = new ArrayList<Statement>();
				tmpArray.add(new Statement(left,right,"ASSETUP"));
				Pair<Expression,ArrayList<Statement>> tmpPair =  new Pair<Expression,ArrayList<Statement>>(null,tmpArray);
				ret = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
				ret.add(tmpPair);			
			}
		}
		else if(ctx.FIELDUP()!=null) {
			ArrayList<Statement> tmpArray = new ArrayList<Statement>();
			Field right = new Field(ctx.right.getText());
			if(ctx.left.expr()!=null ) {
				Expression expr = visitExpr(ctx.left.expr());
				tmpArray.add(new Statement(expr,right,"FIELDUP"));
			}
			else {
				Field left = new Field(ctx.left.getText());
				tmpArray.add(new Statement(left,right,"FIELDUP"));
			}
			Pair<Expression,ArrayList<Statement>> tmpPair =  new Pair<Expression,ArrayList<Statement>>(null,tmpArray);
			ret = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
			ret.add(tmpPair);
		}
		else if(ctx.ifelse()!=null) {
			ret = visitIfelse(ctx.ifelse());
		}
		return ret;
	}

	public ArrayList<Pair<Expression,ArrayList<Statement>>> visitIfelse(IfelseContext ctx) {
		Expression condIf = visitExpr(ctx.cond);
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
			for(ExprContext expr : ctx.condElseIf) {
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

				tmp = new Pair<Expression,ArrayList<Statement>>(visitExpr(expr),tmpStat);
				toRet.add(tmp);
			}
		}
		if(ctx.elseBranch!=null) {
			tmpStat = new ArrayList<Statement>();
			for(StatContext stm : ctx.elseBranch) {
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

	public Expression visitPrec(PrecContext ctx) {

		Expression cond = visitExpr(ctx.expr());

		return cond;
	}

	public Expression visitExpr(ExprContext ctx) {
		Entity left = null;
		Entity right = null;

		if(ctx.right == null){
			if(ctx.left.right == null) {

				if(ctx.left.left.right == null) {

					Expression leftToRet = visitValue(ctx.left.left.left);
					return leftToRet;
				}
				else {

					left = visitValue(ctx.left.left.left).getLeft();
					right = visitValue(ctx.left.left.right).getLeft();
					String op = ctx.left.left.operator.getText();
					Expression toRet = new Expression(left,right,op);

					return toRet;
				}
			}
			else {
				Expression expr = visitFactor(ctx.left.left);
				Expression expr2 = visitTerm(ctx.left.right);
				
				String op = ctx.left.operator.getText();
				Expression toRet = new Expression(expr,expr2,op);
				

				return toRet;
			}
		}

		else {

			Expression leftExpr = visitTerm(ctx.left);
			Expression rightExpr = visitExpr(ctx.right);
			String op = ctx.operator.getText();
			Expression toRet = new Expression(leftExpr,rightExpr,op);
			return toRet;
		}
	}




	@Override
	public Expression visitTerm(StipulaParser.TermContext ctx) {

		if(ctx.right!=null) {
			Entity left = (Entity) visit( ctx.left );
			Entity right = (Entity) visit( ctx.right );
			return new Expression(left,right,ctx.operator.getText());

		}
		else {
			return visitFactor(ctx.left);
		}
	}

	@Override
	public Expression visitFactor(StipulaParser.FactorContext ctx) {

		if(ctx.right!=null) {

			Entity left = visitValue( ctx.left ).getLeft();
			Entity right = visitValue( ctx.right ).getLeft();
			Expression toRet = new Expression(left,right,ctx.operator.getText());
			return toRet;
		}
		else if(ctx.operator!=null){

			return new Expression(visitValue(ctx.left).getLeft(),ctx.operator.getText());
		}
		else {
			return new Expression(visitValue(ctx.left),null,null);
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