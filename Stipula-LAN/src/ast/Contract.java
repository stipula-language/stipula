package ast;

import java.util.ArrayList;
import java.util.Map;

import lib.Pair;

public class Contract {

	ArrayList<Party> disputers = null;
	String id;
	ArrayList<Field> vars = null;
	ArrayList<Asset> assets = null;
	ArrayList<String> initState = null;
	String endState = null;
	ArrayList<Field> globalVars = null;
	ArrayList<Asset> globalAssets = null;
	ArrayList<Statement> statements = null;
	ArrayList<Expression> prec = null;
	ArrayList<Pair<Expression,ArrayList<Statement>>> ifThenElse = null;
	ArrayList<Party> globalParties = null;

	Event events = null;
	int index ;

	public Contract(String name, ArrayList<Field> f, ArrayList<Asset> a, ArrayList<Party> d, ArrayList<String> s1, String s2, int i){
		id = name;
		vars = f;
		assets = a;
		disputers = d;
		initState = s1;
		endState = s2;
		index = i;
	}

	public void addPrecondition(Expression cond) {
		if(prec==null) {
			prec = new ArrayList<Expression>();
		}
		prec.add(cond);
	}

	public int getIndex() {
		return index;
	}

	public void setParties(ArrayList<Party> parties) {
		disputers = parties;
	}

	public void addEvent(Event e) {
		events = e;
	}

	public Event getEvent() {
		return events;
	}

	public void addStatement(Statement stm) {
		if(statements==null) {
			statements = new ArrayList<Statement>();
		}
		statements.add(stm);
	}

	public ArrayList<Party> getParty(){
		return disputers;
	}
	public ArrayList<Party> getGlobalParties(){
		return globalParties;
	}
	public void setGlobalParties( ArrayList<Party> gD) {
		globalParties = gD;
	}
	public ArrayList<Field> getVars(){
		return vars;
	}

	public ArrayList<Asset> getAssets(){
		return assets;
	}

	public ArrayList<Pair<Expression,ArrayList<Statement>>> getIfThenElse(){
		return ifThenElse;
	}

	public void addIfThenElse(ArrayList<Pair<Expression,ArrayList<Statement>>> array) {
		if(ifThenElse==null) {
			ifThenElse = new ArrayList<Pair<Expression,ArrayList<Statement>>>();
		}
		for(Pair<Expression,ArrayList<Statement>> pair : array) {
			ifThenElse.add(pair);
		}
	}

	public String getId() {
		return id;
	}

	public ArrayList<String> getInitState() {
		return initState;
	}

	public String getEndState() {
		return endState;
	}

	public void addFields(ArrayList<Field> f) {
		globalVars = f;
	}

	public void addAssets(ArrayList<Asset> a) {
		globalAssets = a;
	}

	public ArrayList<Field> getGlobalVars(){
		return globalVars;
	}

	public ArrayList<Asset> getGlobalAssets(){
		return globalAssets;
	}

	public ArrayList<Statement> getStatements(){
		return statements;
	}

	public int findVar(String expr, ArrayList<Field> array) {
		int indexRet = -1;
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).getId().equals(expr)) {
				indexRet = i;
			}
		}
		return indexRet;
	}

	public int findParty(String expr) {
		int index = -1;
		for(int i = 0; i<globalParties.size(); i++) {
			if(globalParties.get(i).getId().equals(expr)) {
				index = i;
			}
		}
		return index;
	}

	public int findAsset(String expr, ArrayList<Asset> array) {
		int indexRet = -1;
		for(int i=0; i<array.size(); i++) {

			if(array.get(i).getId().equals(expr)) {
				indexRet = i;
			}
		}
		return indexRet;
	}

	public void updateTypes(Map<Pair<String, Integer>, Type> typedVars) {
		for(Field f : vars) {
			for(Pair<String,Integer> pair : typedVars.keySet()) {
				if(pair.getKey().equals(f.getId()) && pair.getValue()==index) {
					f.setType(typedVars.get(pair));
				}
			}
		}
	}

	public void setValuesConditions(Entity left, Entity right) {

		if(left!=null) {
			int indexLeft = findAsset( left.getId(), assets) ;

			if(indexLeft!=-1) {
				left.setValue((float) assets.get(indexLeft).getValue());
			}
			else {
				indexLeft = findAsset( left.getId(), globalAssets) ;

				if(indexLeft!=-1) {
					left.setValue((float) globalAssets.get(indexLeft).getValue());
				}
				else {
					indexLeft = findVar( left.getId(), vars) ;

					if(indexLeft!=-1) {

						if((vars.get(indexLeft).getType() instanceof TimeType) || vars.get(indexLeft).getValueStr()==null) {
							left.setValue((float) vars.get(indexLeft).getValue());
						}
						else {
							left.setValueStr(vars.get(indexLeft).getValueStr());
						}
					}
					else {
						indexLeft = findVar( left.getId(), globalVars) ;

						if(indexLeft!=-1) {
							if((globalVars.get(indexLeft).getType() instanceof TimeType) || globalVars.get(indexLeft).getValueStr()==null) {
								left.setValue((float) globalVars.get(indexLeft).getValue());
							}
							else {
								left.setValueStr(globalVars.get(indexLeft).getValueStr());
							}
						}
						else {
							try 
							{ 
								left.setValue((float)Double.parseDouble(left.getId()));
							}
							catch(NumberFormatException e)
							{

							}
						}
					}
				}
			}
		}
		if(right!=null) {

			int indexRight = findAsset( right.getId(), assets) ;
			if(indexRight!=-1) {

				right.setValue((float) assets.get(indexRight).getValue());
			}
			else {

				indexRight = findAsset( right.getId(), globalAssets) ;

				if(indexRight!=-1) {
					right.setValue((float) globalAssets.get(indexRight).getValue());
				}
				else {

					indexRight = findVar( right.getId(), vars) ;

					if(indexRight!=-1) {
						if((vars.get(indexRight).getType() instanceof TimeType) || vars.get(indexRight).getValueStr()==null) {
							right.setValue((float) vars.get(indexRight).getValue());
						}
						else {
							right.setValueStr(vars.get(indexRight).getValueStr());
						}
					}
					else {

						indexRight = findVar( right.getId(), globalVars) ;

						if(indexRight!=-1) {
							if((globalVars.get(indexRight).getType() instanceof TimeType) || globalVars.get(indexRight).getValueStr()==null) {
								right.setValue((float) globalVars.get(indexRight).getValue());
							}
							else {
								right.setValueStr(globalVars.get(indexRight).getValueStr());
							}
						}
						else {

							try 
							{ 
								right.setValue((float)Double.parseDouble(right.getId()));
							}
							catch(NumberFormatException e)
							{

							}
						}
					}
				}
			}


		}

	}

	public boolean isComplexExpr(Entity expr) {
		if(expr.getId().contains("+")||expr.getId().contains("-")||expr.getId().contains("*")||expr.getId().contains("/")) {
			return true;
		}
		return false;
	}

	public ArrayList<Field> divideComplexExpr(Entity expr){
		ArrayList<Field> toRet = new ArrayList<Field>();
		String[] split = null;
		String exprId = expr.getId().replaceAll("[()]", "");
		if(exprId.contains("+")) {
			split = exprId.split("\\+");
		}
		else if(exprId.contains("-")) {
			split = exprId.split("\\-");
		}
		else if(exprId.contains("*")) {
			split = exprId.split("\\*");
		}
		else {
			split = exprId.split("/");
		}
		for(int i=0; i<split.length; i++) {
			Field toAdd = new Field(split[i]);
			toRet.add(toAdd);
		}
		return toRet;
	}

	public boolean runStatements(boolean valid, TypeInference tc, ArrayList<Statement> stms) {

		for(Statement s : stms) {

			if(s.getOperator().equals("FIELDUP")) {

				Field leftExpr = (Field) s.getLeftExpr();
				Expression left = null;
				if(leftExpr==null) {
					left = s.getLeftExpression();
					left.printExpression();
				}
				Field rightExpr = (Field) s.getRightExpr();
				Field leftExpr2 = null;
				boolean everyParty = false;
				if(rightExpr.getId().equals("_")) {
					everyParty = true;
				}
				else if(leftExpr!=null && isComplexExpr(leftExpr)) {
					ArrayList<Field> entities = divideComplexExpr(leftExpr);
					if(entities.size()==2) {
						leftExpr = entities.get(0);
						leftExpr2 = entities.get(1);
					}
				}
				String leftExprName = "";

				if(leftExpr==null) {
					leftExprName = "";
				}
				else {
					leftExprName = leftExpr.getId();
				}
				int indexLeft = findVar(leftExprName,vars);
				int indexLeft2 = -1;
				if(leftExpr2!=null) {
					indexLeft2 = findVar(leftExpr2.getId(),vars);
				}
				int indexRight = findVar(rightExpr.getId(),vars);
				boolean globalLeft = false;
				boolean globalLeft2 = false;
				boolean globalRight = false;
				boolean partyLeft = false;
				boolean partyLeft2 = false;
				boolean partyRight = false;
				boolean extLeft = false;
				boolean extLeft2 = false;
				boolean extRight = false;

				if(indexLeft==-1) {
					indexLeft = findVar(leftExprName,globalVars);
					if(indexLeft == -1) {
						indexLeft = findParty(leftExprName);
						if(indexLeft==-1) {
							extLeft = true;
						}
						else{
							partyLeft =  true;
						}
					}
					else {
						globalLeft = true;
					}

				}
				if(leftExpr2!=null) {
					if(indexLeft2==-1) {
						indexLeft2 = findVar(leftExpr2.getId(),globalVars);
						if(indexLeft2 == -1) {
							indexLeft2 = findParty(leftExpr2.getId());
							if(indexLeft2==-1) {
								extLeft2 = true;
							}
							else{
								partyLeft2 =  true;
							}
						}
						else {
							globalLeft2 = true;
						}

					}
				}
				if(indexRight==-1) {
					indexRight = findVar(rightExpr.getId(),globalVars);
					if(indexRight == -1) {
						indexRight = findParty(rightExpr.getId());
						if(indexRight==-1) {
							extRight = true;
						}
						else{
							partyRight =  true;
						}
					}
					else {
						if(!everyParty) {
							globalRight = true;
						}
					}
				}
				if(leftExpr2==null) {
					if(extLeft && globalRight) {
						try 
						{ 
							globalVars.get(indexRight).setValue((float)Double.parseDouble(leftExprName));
						}
						catch(NumberFormatException e)
						{
							globalVars.get(indexRight).setValueStr(String.format(leftExprName));
						}
					}
					else if(extLeft && partyRight) {
						try 
						{ 
							globalParties.get(indexRight).setValue(((float)Double.parseDouble(leftExprName)));
						}
						catch(NumberFormatException e)
						{
							globalParties.get(indexRight).setValueStr(String.format(leftExprName));
						}
					}
					else if(extLeft && !globalRight) {

						try 
						{ 

							vars.get(indexRight).setValue((float)Double.parseDouble(leftExprName));
						}
						catch(NumberFormatException e)
						{
							vars.get(indexRight).setValueStr(String.format(leftExprName));
						}
					}
					else if(extLeft && everyParty) {
						try 
						{ 
							for(Party p : globalParties) {
								p.setValue(((float)Double.parseDouble(leftExprName)));
							}
						}
						catch(NumberFormatException e)
						{
							for(Party p : globalParties) {
								p.setValueStr(String.format(leftExprName));
							}
						}
					}
					else if(!partyLeft && partyRight && globalLeft) {
						Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);

						if(!(t1 instanceof StringType)) {
							globalParties.get(indexRight).setValue(((float) (globalParties.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue())));
						}
						else {
							if(globalParties.get(indexRight).getValueStr()==null) {
								globalParties.get(indexRight).setValueStr(globalVars.get(indexLeft).getValueStr());
							}
							else {
								globalParties.get(indexRight).setValueStr(globalParties.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
							}
						}
						globalVars.get(indexRight).setType(t1);

					}
					else if(!partyLeft && everyParty && globalLeft) {
						for(Party p : globalParties) {
							Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);
							if(!(t1 instanceof StringType)) {
								p.setValue(((float) (p.getValue()+(float) globalVars.get(indexLeft).getValue())));
							}
							else {
								if(p.getValueStr()==null) {
									p.setValueStr(globalVars.get(indexLeft).getValueStr());
								}
								else {
									p.setValueStr(p.getValueStr()+globalVars.get(indexLeft).getValueStr());
								}
							}
							globalVars.get(indexRight).setType(t1);
						}

					}
					else if(!partyLeft && partyRight && !globalLeft) {
						Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
						if(!(t1 instanceof StringType)) {
							globalParties.get(indexRight).setValue(((float) (globalParties.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue())));
						}
						else {
							if(globalParties.get(indexRight).getValueStr()==null) {
								globalParties.get(indexRight).setValueStr(vars.get(indexLeft).getValueStr());
							}
							else {
								globalParties.get(indexRight).setValueStr(globalParties.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
							}
						}
						vars.get(indexLeft).setType(t1);
					}
					else if(!partyLeft && !globalLeft && everyParty) {

						for(Party p : globalParties) {
							Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
							if(!(t1 instanceof StringType)) {
								p.setValue(((float) (p.getValue()+(float) vars.get(indexLeft).getValue())));
							}
							else {
								if(p.getValueStr()==null) {
									p.setValueStr(vars.get(indexLeft).getValueStr());
								}
								else {
									p.setValueStr(p.getValueStr()+vars.get(indexLeft).getValueStr());
								}
							}
							vars.get(indexLeft).setType(t1);
						}
					}
					else if(!globalLeft && !globalRight) {
						valid = tc.isTypeCorrect(vars.get(indexRight),vars.get(indexLeft),index);


						if(valid) {
							Type t1 = tc.getCorrectType(vars.get(indexRight),index);
							Type t2 = tc.getCorrectType(vars.get(indexLeft),index);
							if(!(t2 instanceof StringType)) {
								vars.get(indexRight).setValue((float) (vars.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue()));
							}
							else {
								if(vars.get(indexRight).getValueStr()==null) {
									vars.get(indexRight).setValueStr(vars.get(indexLeft).getValueStr());

								}
								else {
									vars.get(indexRight).setValueStr(vars.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
								}
							}
							vars.get(indexRight).setType(t1);
							vars.get(indexLeft).setType(t2);

						}
					}
					else if(globalLeft && !globalRight) {
						valid = tc.isTypeCorrect(vars.get(indexRight),globalVars.get(indexLeft),index);

						if(valid) {
							Type t1 = tc.getCorrectType(vars.get(indexRight),index);
							Type t2 = tc.getCorrectType(globalVars.get(indexLeft),index);
							if(!(t2 instanceof StringType)) {
								vars.get(indexRight).setValue((float) (vars.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue()));
							}
							else {
								if(vars.get(indexRight).getValueStr()==null) {
									vars.get(indexRight).setValueStr(globalVars.get(indexLeft).getValueStr());
								}
								else {
									vars.get(indexRight).setValueStr(vars.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
								}
							}
							vars.get(indexRight).setType(t1);
							globalVars.get(indexLeft).setType(t2);
						}
					}
					else if(!globalLeft && globalRight) {
						valid = tc.isTypeCorrect(globalVars.get(indexRight),vars.get(indexLeft),index);

						if(valid) {
							Type t1 = tc.getCorrectType(globalVars.get(indexRight),index);
							Type t2 = tc.getCorrectType(vars.get(indexLeft),index);

							if(!(t2 instanceof StringType)) {
								globalVars.get(indexRight).setValue((float) (globalVars.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue()));	
							}
							else {
								if(globalVars.get(indexRight).getValueStr()==null) {
									globalVars.get(indexRight).setValueStr(vars.get(indexLeft).getValueStr());

								}
								else {
									globalVars.get(indexRight).setValueStr(globalVars.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
								}
							}
							globalVars.get(indexRight).setType(t2);
							vars.get(indexLeft).setType(t2);

						}
					}
					else if(globalLeft && globalRight) {
						valid = tc.isTypeCorrect(globalVars.get(indexRight),globalVars.get(indexLeft),index);

						if(valid) {
							Type t1 = tc.getCorrectType(globalVars.get(indexRight),index);
							Type t2 = tc.getCorrectType(globalVars.get(indexLeft),index);
							if(!(t2 instanceof StringType)) {
								globalVars.get(indexRight).setValue((float) (globalVars.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue()));
							}
							else {
								if(globalVars.get(indexRight).getValueStr()==null) {
									globalVars.get(indexRight).setValueStr(globalVars.get(indexLeft).getValueStr());

								}
								else {
									globalVars.get(indexRight).setValueStr(globalVars.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
								}
							}
							globalVars.get(indexRight).setType(t1);
							globalVars.get(indexLeft).setType(t2);
						}
					}
					if(!valid) {
						System.out.println("Typing error.");
					}
				}
				else if(leftExpr2!=null) {
					Entity result = new Entity();
					if(extLeft2) {
						if(extLeft) {
							try 
							{ 
								result.setValue((float)Double.parseDouble(leftExprName)+(float)Double.parseDouble(leftExpr2.getId()));
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExprName)+String.format(leftExpr2.getId()));
							}
						}
						else if(globalLeft) {
							try 
							{ 
								result.setValue(globalVars.get(indexLeft).getValue()+(float)Double.parseDouble(leftExpr2.getId()));
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(globalVars.get(indexLeft).getValueStr()+String.format(leftExpr2.getId()));
							}
						}
						else {
							try 
							{ 
								result.setValue(vars.get(indexLeft).getValue()+(float)Double.parseDouble(leftExpr2.getId()));
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(vars.get(indexLeft).getValueStr()+String.format(leftExpr2.getId()));
							}
						}
					}
					else if(globalLeft2) {
						if(extLeft) {
							try 
							{ 
								result.setValue((float)Double.parseDouble(leftExprName)+globalVars.get(indexLeft2).getValue());
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExprName)+globalVars.get(indexLeft2).getValueStr());
							}
						}
						else if(globalLeft) {
							valid = tc.isTypeCorrect(globalVars.get(indexLeft),globalVars.get(indexLeft2),index);

							if(valid) {
								Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);
								Type t2 = tc.getCorrectType(globalVars.get(indexLeft2),index);
								if(!(t1 instanceof StringType)) {
									result.setValue((float) (globalVars.get(indexLeft).getValue()+(float) globalVars.get(indexLeft2).getValue()));
								}
								else {
									result.setValueStr(globalVars.get(indexLeft).getValueStr()+globalVars.get(indexLeft2).getValueStr());
								}
								globalVars.get(indexLeft).setType(t1);
								globalVars.get(indexLeft2).setType(t2);
							}
						}
						else {
							valid = tc.isTypeCorrect(vars.get(indexLeft),globalVars.get(indexLeft2),index);

							if(valid) {
								Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
								Type t2 = tc.getCorrectType(globalVars.get(indexLeft2),index);
								if(!(t1 instanceof StringType)) {
									result.setValue((float) (vars.get(indexLeft).getValue()+(float) globalVars.get(indexLeft2).getValue()));
								}
								else {
									result.setValueStr(vars.get(indexLeft).getValueStr()+globalVars.get(indexLeft2).getValueStr());
								}
								vars.get(indexLeft).setType(t1);
								globalVars.get(indexLeft2).setType(t2);
							}
						}
					}
					else {
						if(extLeft) {
							try 
							{ 
								result.setValue((float)Double.parseDouble(leftExprName)+vars.get(indexLeft2).getValue());
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExprName)+vars.get(indexLeft2).getValueStr());
							}
						}
						else if(globalLeft) {
							valid = tc.isTypeCorrect(globalVars.get(indexLeft),vars.get(indexLeft2),index);

							if(valid) {
								Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);
								Type t2 = tc.getCorrectType(vars.get(indexLeft2),index);
								if(!(t1 instanceof StringType)) {
									result.setValue((float) (globalVars.get(indexLeft).getValue()+(float) vars.get(indexLeft2).getValue()));
								}
								else {
									result.setValueStr(globalVars.get(indexLeft).getValueStr()+vars.get(indexLeft2).getValueStr());
								}
								globalVars.get(indexLeft).setType(t1);
								vars.get(indexLeft2).setType(t2);
							}
						}
						else {
							valid = tc.isTypeCorrect(vars.get(indexLeft),vars.get(indexLeft2),index);

							if(valid) {
								Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
								Type t2 = tc.getCorrectType(vars.get(indexLeft2),index);
								if(!(t1 instanceof StringType)) {
									result.setValue((float) (vars.get(indexLeft).getValue()+(float) vars.get(indexLeft2).getValue()));
								}
								else {
									result.setValueStr(vars.get(indexLeft).getValueStr()+vars.get(indexLeft2).getValueStr());
								}
								vars.get(indexLeft).setType(t1);
								vars.get(indexLeft2).setType(t2);
							}
						}
					}

					if(globalRight) {
						Type t1 = tc.getCorrectType(globalVars.get(indexRight),index);
						Type t2 = null;
						if(globalLeft) {
							t2 = tc.getCorrectType(globalVars.get(indexLeft),index);
						}
						else if(!globalLeft && globalLeft2) {
							t2 = tc.getCorrectType(globalVars.get(indexLeft2),index);
						}
						else if(!globalLeft && !globalLeft2 && !extLeft) {
							t2 = tc.getCorrectType(vars.get(indexLeft),index);
						}
						else if(!globalLeft && !globalLeft2 && !extLeft2) {
							t2 = tc.getCorrectType(vars.get(indexLeft2),index);
						}					
						if(!(t2 instanceof StringType)) {
							if((indexRight==indexLeft && globalLeft) || (globalLeft2 && indexRight==indexLeft2)) {
								globalVars.get(indexRight).setValue((float) ((float) result.getValue()));	
							}
							else{
								globalVars.get(indexRight).setValue((float) (globalVars.get(indexRight).getValue()+(float) result.getValue()));	
							}
						}
						else {
							if((indexRight==indexLeft && globalLeft) || (globalLeft2 && indexRight==indexLeft2)) {
								globalVars.get(indexRight).setValueStr(result.getValueStr());
							}
							else {
								globalVars.get(indexRight).setValueStr(globalVars.get(indexRight).getValueStr()+result.getValueStr());
							}
						}
						globalVars.get(indexRight).setType(t2);
					}
					else if(!globalRight) {
						Type t1 = tc.getCorrectType(vars.get(indexRight),index);
						Type t2 = null;
						if(globalLeft) {
							t2 = tc.getCorrectType(globalVars.get(indexLeft),index);
						}
						else if(!globalLeft && globalLeft2) {
							t2 = tc.getCorrectType(globalVars.get(indexLeft2),index);
						}
						else if(!globalLeft && !globalLeft2 && !extLeft) {
							t2 = tc.getCorrectType(vars.get(indexLeft),index);
						}
						else if(!globalLeft && !globalLeft2 && !extLeft2) {
							t2 = tc.getCorrectType(vars.get(indexLeft2),index);
						}
						if(!(t2 instanceof StringType)) {
							if((indexRight==indexLeft && !globalLeft) || (!globalLeft2 && indexRight==indexLeft2)) {
								vars.get(indexRight).setValue((float) ((float) result.getValue()));	
							}
							else {
								vars.get(indexRight).setValue((float) (vars.get(indexRight).getValue()+(float) result.getValue()));	
							}
						}
						else {
							if((indexRight==indexLeft && !globalLeft) || (!globalLeft2 && indexRight==indexLeft2)) {
								vars.get(indexRight).setValueStr(result.getValueStr());
							}
							else {
								vars.get(indexRight).setValueStr(vars.get(indexRight).getValueStr()+result.getValueStr());
							}
						}
						vars.get(indexRight).setType(t2);
					}
				}
			}

			else if(s.getOperator().equals("ASSETUP")) {
				valid = true;
				Asset leftExpr = (Asset) s.getLeftExpr();
				Asset rightExpr = (Asset) s.getRightExpr();

				int indexLeft = findAsset(leftExpr.getId(),assets);
				int indexRight = findAsset(rightExpr.getId(),assets);
				boolean globalLeft = false;
				boolean globalRight = false;
				boolean partyLeft = false;
				boolean partyRight = false;

				if(indexLeft==-1) {
					indexLeft = findAsset(leftExpr.getId(),globalAssets);
					if(indexLeft == -1) {
						indexLeft = findParty(leftExpr.getId());
						partyLeft =  true;
					} else {
						globalLeft = true;
					}
				}
				if(indexRight==-1) {
					indexRight = findAsset(rightExpr.getId(),globalAssets);
					if(indexRight == -1) {
						indexRight = findParty(rightExpr.getId());
						partyRight =  true;
					} else {
						globalRight = true;
					}
				}

				float valFract = 0;
				if (s.getFract() != 0) {
					valFract = (float)s.getFract();
				} else {
					String nameFract = s.getFractExpr();

					if (nameFract.contains("/") || nameFract.contains("*") || nameFract.contains("+") || nameFract.contains("-")) {
						String[] operands;
						String operator = "";

						if (nameFract.contains("/")) { operands = nameFract.split("/"); operator = "/"; }
						else if (nameFract.contains("*")) { operands = nameFract.split("\\*"); operator = "*"; }
						else if (nameFract.contains("+")) { operands = nameFract.split("\\+"); operator = "+"; }
						else { operands = nameFract.split("-"); operator = "-"; }

						if (operands.length == 2) {
							float leftVal = findVariableValue(operands[0].trim());
							float rightVal = findVariableValue(operands[1].trim());

							switch (operator) {
								case "/": valFract = (rightVal == 0) ? 0 : leftVal / rightVal; break;
								case "*": valFract = leftVal * rightVal; break;
								case "+": valFract = leftVal + rightVal; break;
								case "-": valFract = leftVal - rightVal; break;
							}
						}
					} else {
						valFract = findVariableValue(nameFract);
					}
				}

				if(partyLeft && partyRight) {
					globalParties.get(indexLeft).moveAsset(globalParties.get(indexRight), valFract * globalParties.get(indexLeft).getValueAsset());
				}
				else if(!partyLeft && partyRight && globalLeft) {
					globalAssets.get(indexLeft).withdraw(globalParties.get(indexRight), valFract);
				}
				else if(!partyLeft && partyRight && !globalLeft) {
					assets.get(indexLeft).withdraw(globalParties.get(indexRight), valFract);
				}
				else if(!globalLeft && !globalRight) {
					assets.get(indexLeft).move(valFract, assets.get(indexRight));
				}
				else if(globalLeft && !globalRight) {
					globalAssets.get(indexLeft).move(valFract, assets.get(indexRight));
				}
				else if(!globalLeft && globalRight) {
					assets.get(indexLeft).move(valFract, globalAssets.get(indexRight));
				}
				else if(globalLeft && globalRight) {
					globalAssets.get(indexLeft).move(valFract, globalAssets.get(indexRight));
				}
			}
		}
		return valid;
	}

	public boolean runContract(TypeInference tc, int index) {
		Map<Pair<String,Integer>,Type> typedVars = tc.getTypes();
		for(Field f : globalVars) {
			for(Pair<String,Integer> pair : typedVars.keySet()) {
				if(pair.getKey().equals(f.getId()) && pair.getValue()==0) {
					f.setType(typedVars.get(pair));
				}
			}
		}

		boolean valid = true;
		if(prec!=null) {

				for(Expression c : prec) {
					Entity leftResult = evaluateExpression(c.getLeftComplexExpr());
					Entity rightResult = evaluateExpression(c.getRightComplexExpr());

					if (leftResult == null || rightResult == null) {
						System.out.println("Not possible to evaluate the precondition.");
						valid = false;
						break;
					}

					if (!c.isValid(leftResult, rightResult, c.getOp())) {
						valid = false;
					}

			}
		}
		if(!valid) {
			System.out.print("Preconditions do not hold (");
			for(Expression c : prec) {
				c.printExpression();
			}
			System.out.println(").");
			return valid;
		}
		if(statements!=null && valid) {
			valid = runStatements(valid,tc,statements);
		}
		if(ifThenElse!=null && valid) {
			boolean flag = false;
			for(Pair<Expression,ArrayList<Statement>> pair : ifThenElse) {
				
				if(pair.getKey()!=null ){
					if(pair.getKey().getLeftComplexExpr()!=null && pair.getKey().getRightComplexExpr()!=null) {
						boolean validLeft = true;
						boolean validRight = true;
						Entity leftBigL = pair.getKey().getLeftComplexExpr().getLeft();
						Entity leftBigR = pair.getKey().getLeftComplexExpr().getRight();
						Entity rightBigL = pair.getKey().getRightComplexExpr().getLeft();
						Entity rightBigR = pair.getKey().getRightComplexExpr().getRight();

						setValuesConditions(leftBigL,leftBigR);
						setValuesConditions(rightBigL,rightBigR);

						validLeft = pair.getKey().isValid(leftBigL,leftBigR,pair.getKey().getLeftComplexExpr().getOp());
						validRight = pair.getKey().isValid(rightBigL,rightBigR,pair.getKey().getRightComplexExpr().getOp());

						if(pair.getKey().getOp().equals("&&")) {
							valid = validLeft && validRight;
						}
						else if(pair.getKey().getOp().equals("||")) {
							valid = validLeft || validRight;
						}


					}
					else if(pair.getKey().getLeftComplexExpr()!=null) {
						setValuesConditions(pair.getKey().getLeftComplexExpr().getLeft(),pair.getKey().getLeftComplexExpr().getRight());
						setValuesConditions(pair.getKey().getRightComplexExpr().getLeft(),pair.getKey().getRightComplexExpr().getRight());

					}
					else {
						if( !pair.getKey().getLeft().getId().equals("_")) {
							setValuesConditions(pair.getKey().getLeft(),pair.getKey().getRight());
						}

					}
					if(pair.getKey().getLeftComplexExpr()!=null && pair.getKey().getRightComplexExpr()!=null && valid) {
						if(!flag) {
							valid = runStatements(valid,tc,pair.getValue());
							flag = true;

							break;

						}

					}
					else if((pair.getKey().getLeftComplexExpr()==null && pair.getKey().getLeft().getId().equals("_"))  || pair.getKey().isValidExpr(pair.getKey()) ) {

						if(!flag) {
							valid = runStatements(valid,tc,pair.getValue());
							flag = true;
							break;
						}



					}
				}

			}

		}
		for(Field f : globalVars) {
			for(Pair<String,Integer> pair : typedVars.keySet()) {
				if(pair.getKey().equals(f.getId()) && pair.getValue()==0) {
					if(!(typedVars.get(pair) instanceof GeneralType)) {
						f.setType(typedVars.get(pair));
					}
				}
			}
		}

		return valid;
	}

	private Entity evaluateExpression(Expression expr) {
		if (expr.getLeftComplexExpr() == null && expr.getRightComplexExpr() == null) {
			Entity simpleEntity = expr.getLeft();
			if (simpleEntity == null) return null;

			setValuesConditions(simpleEntity, null);
			return simpleEntity;
		}

		Entity leftValue = evaluateExpression(expr.getLeftComplexExpr());
		Entity rightValue = evaluateExpression(expr.getRightComplexExpr());

		if (leftValue == null || rightValue == null) {
			System.out.println("Error in the evaluation of a subexpression.");
			return null;
		}

		Entity result = new Entity("result");
		String op = expr.getOp();

		switch (op) {
			case "*":
				result.setValue(leftValue.getValue() * rightValue.getValue());
				break;
			case "/":
				result.setValue(leftValue.getValue() / rightValue.getValue());
				break;
			case "+":
				result.setValue(leftValue.getValue() + rightValue.getValue());
				break;
			case "-":
				result.setValue(leftValue.getValue() - rightValue.getValue());
				break;
			default:
				return null;
		}

		return result;
	}

	private float findVariableValue(String varName) {
		// 1. Search in local fields (vars)
		int index = findVar(varName, vars);
		if (index != -1) {
			return vars.get(index).getValue();
		}
		// 2. Search in local assets
		index = findAsset(varName, assets);
		if (index != -1) {
			return (float) assets.get(index).getValue();
		}
		// 3. Search in global fields (globalVars)
		index = findVar(varName, globalVars);
		if (index != -1) {
			return globalVars.get(index).getValue();
		}
		// 4. Search in global assets (globalAssets)
		index = findAsset(varName, globalAssets);
		if (index != -1) {
			return (float) globalAssets.get(index).getValue();
		}
		System.err.println("RUNTIME ERROR: Variable '" + varName + "' could not be found during statement execution.");
		return 0;
	}

}
