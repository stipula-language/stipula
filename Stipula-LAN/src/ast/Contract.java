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
						if(!(vars.get(indexLeft).getType() instanceof TimeType) || vars.get(indexLeft).getValueStr()==null) {
							left.setValue((float) vars.get(indexLeft).getValue());
						}
						else {
							left.setValueStr(vars.get(indexLeft).getValueStr());
						}
					}
					else {
						indexLeft = findVar( left.getId(), globalVars) ;

						if(indexLeft!=-1) {
							if(!(globalVars.get(indexLeft).getType() instanceof TimeType) || globalVars.get(indexLeft).getValueStr()==null) {
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
						if(!(vars.get(indexRight).getType() instanceof TimeType) || vars.get(indexRight).getValueStr()==null) {
							right.setValue((float) vars.get(indexRight).getValue());
						}
						else {
							right.setValueStr(vars.get(indexRight).getValueStr());
						}
					}
					else {

						indexRight = findVar( right.getId(), globalVars) ;

						if(indexRight!=-1) {
							if(!(globalVars.get(indexRight).getType() instanceof TimeType) || globalVars.get(indexRight).getValueStr()==null) {
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
				Field rightExpr = (Field) s.getRightExpr();
				Field leftExpr2 = null;
				boolean everyParty = false;
				if(rightExpr.getId().equals("_")) {
					everyParty = true;
				}
				else if(isComplexExpr(leftExpr)) {
					ArrayList<Field> entities = divideComplexExpr(leftExpr);
					if(entities.size()==2) {
						leftExpr = entities.get(0);
						leftExpr2 = entities.get(1);
					}
				}

				int indexLeft = findVar(leftExpr.getId(),vars);
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
					indexLeft = findVar(leftExpr.getId(),globalVars);
					if(indexLeft == -1) {
						indexLeft = findParty(leftExpr.getId());
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
							globalVars.get(indexRight).setValue((float)Double.parseDouble(leftExpr.getId()));
						}
						catch(NumberFormatException e)
						{
							globalVars.get(indexRight).setValueStr(String.format(leftExpr.getId()));
						}
					}
					else if(extLeft && partyRight) {
						try 
						{ 
							globalParties.get(indexRight).setValue(((float)Double.parseDouble(leftExpr.getId())));
						}
						catch(NumberFormatException e)
						{
							globalParties.get(indexRight).setValueStr(String.format(leftExpr.getId()));
						}
					}
					else if(extLeft && !globalRight) {

						try 
						{ 

							vars.get(indexRight).setValue((float)Double.parseDouble(leftExpr.getId()));
						}
						catch(NumberFormatException e)
						{
							vars.get(indexRight).setValueStr(String.format(leftExpr.getId()));
						}
					}
					else if(extLeft && everyParty) {
						try 
						{ 
							for(Party p : globalParties) {
								p.setValue(((float)Double.parseDouble(leftExpr.getId())));
							}
						}
						catch(NumberFormatException e)
						{
							for(Party p : globalParties) {
								p.setValueStr(String.format(leftExpr.getId()));
							}
						}
					}
					else if(!partyLeft && partyRight && globalLeft) {
						Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);

						if(!(t1 instanceof StringType)) {
							globalParties.get(indexRight).setValue(((float) (globalParties.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue())));
						}
						else {
							globalParties.get(indexRight).setValueStr(globalParties.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
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
								p.setValueStr(p.getValueStr()+globalVars.get(indexLeft).getValueStr());
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
							globalParties.get(indexRight).setValueStr(globalParties.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
						}
						vars.get(indexRight).setType(t1);
					}
					else if(!partyLeft && !globalLeft && everyParty) {

						for(Party p : globalParties) {
							Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
							if(!(t1 instanceof StringType)) {
								p.setValue(((float) (p.getValue()+(float) vars.get(indexLeft).getValue())));
							}
							else {
								p.setValueStr(p.getValueStr()+vars.get(indexLeft).getValueStr());
							}
							vars.get(indexLeft).setType(t1);
						}
					}
					else if(!globalLeft && !globalRight) {
						valid = tc.isTypeCorrect(vars.get(indexRight),vars.get(indexLeft),index);


						if(valid) {
							Type t1 = tc.getCorrectType(vars.get(indexRight),index);
							Type t2 = tc.getCorrectType(vars.get(indexLeft),index);
							if(!(t1 instanceof StringType)) {
								vars.get(indexRight).setValue((float) (vars.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue()));
							}
							else {
								vars.get(indexRight).setValueStr(vars.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
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
							if(!(t1 instanceof StringType)) {
								vars.get(indexRight).setValue((float) (vars.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue()));
							}
							else {
								vars.get(indexRight).setValueStr(vars.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
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
							if(!(t1 instanceof StringType)) {
								globalVars.get(indexRight).setValue((float) (globalVars.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue()));	
							}
							else {
								globalVars.get(indexRight).setValueStr(globalVars.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
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
							if(!(t1 instanceof StringType)) {
								globalVars.get(indexRight).setValue((float) (globalVars.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue()));
							}
							else {
								globalVars.get(indexRight).setValueStr(globalVars.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
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
								result.setValue((float)Double.parseDouble(leftExpr.getId())+(float)Double.parseDouble(leftExpr2.getId()));
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExpr.getId())+String.format(leftExpr2.getId()));
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
								result.setValue((float)Double.parseDouble(leftExpr.getId())+globalVars.get(indexLeft2).getValue());
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExpr.getId())+globalVars.get(indexLeft2).getValueStr());
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
								result.setValue((float)Double.parseDouble(leftExpr.getId())+vars.get(indexLeft2).getValue());
							}
							catch(NumberFormatException e)
							{
								result.setValueStr(String.format(leftExpr.getId())+vars.get(indexLeft2).getValueStr());
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
					}
					else {
						globalLeft = true;
					}
				}
				if(indexRight==-1) {
					indexRight = findAsset(rightExpr.getId(),globalAssets);

					if(indexRight == -1) {
						indexRight = findParty(rightExpr.getId());

						partyRight =  true;
					}
					else {
						globalRight = true;
					}
				}

				if(partyLeft && partyRight) {
					if(s.getFract()!=0) {

						globalParties.get(indexLeft).moveAsset(globalParties.get(indexRight),((float)(s.getFract())*globalParties.get(indexLeft).getValueAsset()));

					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalParties.get(indexLeft).moveAsset(globalParties.get(indexRight),((float)(valFract)*globalParties.get(indexLeft).getValueAsset()));

					}

				}
				else if(!partyLeft && partyRight && globalLeft) {
					if(s.getFract()!=0) {
						globalAssets.get(indexLeft).withdraw(globalParties.get(indexRight),((float)s.getFract())*globalAssets.get(indexLeft).getValue()); 

					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();
						globalAssets.get(indexLeft).withdraw(globalParties.get(indexRight),((float)valFract)*globalAssets.get(indexLeft).getValue()); 

					}

				}
				else if(!partyLeft && partyRight && !globalLeft) {
					if(s.getFract()!=0) {
						assets.get(indexLeft).withdraw(globalParties.get(indexRight),((float)s.getFract())*assets.get(indexLeft).getValue()); 
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();
						assets.get(indexLeft).withdraw(globalParties.get(indexRight),((float)valFract)*assets.get(indexLeft).getValue()); 

					}
				}
				else if(!globalLeft && !globalRight) {
					if(s.getFract()!=0) {
						assets.get(indexLeft).move(((float)s.getFract())*assets.get(indexLeft).getValue(),assets.get(indexRight));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						assets.get(indexLeft).move(((float)valFract)*assets.get(indexLeft).getValue(),assets.get(indexRight));
					}
				}
				else if(globalLeft && !globalRight) {
					if(s.getFract()!=0) {
						globalAssets.get(indexLeft).move(((float)s.getFract())*globalAssets.get(indexLeft).getValue(),assets.get(indexRight));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalAssets.get(indexLeft).move(((float)valFract)*globalAssets.get(indexLeft).getValue(),assets.get(indexRight));
					}
				}
				else if(!globalLeft && globalRight) {
					System.out.println(globalAssets.get(indexRight).getId() + " = " + globalAssets.get(indexRight).getValue() );
					System.out.println(assets.get(indexLeft).getId() + " = " + assets.get(indexLeft).getValue() );

					if(s.getFract()!=0) {
						assets.get(indexLeft).move(((float)s.getFract())*assets.get(indexLeft).getValue(),globalAssets.get(indexRight));
						//assets.get(indexLeft).setValue((float) (((float)(-s.getFract())))*assets.get(indexLeft).getValue());
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();
						assets.get(indexLeft).move(((float)valFract)*assets.get(indexLeft).getValue(),globalAssets.get(indexRight));
						//assets.get(indexLeft).setValue(((float)(-valFract))*assets.get(indexLeft).getValue());
					}
				}
				else if(globalLeft && globalRight) {
					if(s.getFract()!=0) {

						globalAssets.get(indexLeft).move(((float)s.getFract())*globalAssets.get(indexLeft).getValue(),globalAssets.get(indexRight));
						//globalAssets.get(indexLeft).setValue((float)((-s.getFract()))*globalAssets.get(indexLeft).getValue());
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalAssets.get(indexLeft).move(((float)valFract)*globalAssets.get(indexLeft).getValue(),globalAssets.get(indexRight));
						//globalAssets.get(indexLeft).setValue(((float)(-valFract))*globalAssets.get(indexLeft).getValue());
					}
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

				if(c.getLeftComplexExpr()!=null && c.getRightComplexExpr()!=null) {
					boolean validLeft = true;
					boolean validRight = true;
					Entity leftBigL = c.getLeftComplexExpr().getLeft();
					Entity leftBigR = c.getLeftComplexExpr().getRight();
					Entity rightBigL = c.getRightComplexExpr().getLeft();
					Entity rightBigR = c.getRightComplexExpr().getRight();

					setValuesConditions(leftBigL,leftBigR);
					setValuesConditions(rightBigL,rightBigR);

					if(!c.isValid(leftBigL,leftBigR,c.getLeftComplexExpr().getOp())) {
						validLeft = false;
					}
					if(!c.isValid(rightBigL,rightBigR,c.getRightComplexExpr().getOp())) {
						validRight = false;
					}
					if(c.getOp().equals("&&")) {
						valid = validLeft && validRight;
					}
					else if(c.getOp().equals("||")) {
						valid = validLeft || validRight;
					}
				}
				else {
					Entity left = c.getLeft();
					Entity right = c.getRight();

					setValuesConditions(left,right);

					if(!c.isValid(left,right,c.getOp())) {
						valid = false;
					}
				}
			}


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

						if(!pair.getKey().isValid(leftBigL,leftBigR,pair.getKey().getLeftComplexExpr().getOp())) {
							validLeft = false;
						}
						if(!pair.getKey().isValid(rightBigL,rightBigR,pair.getKey().getRightComplexExpr().getOp())) {
							validRight = false;
						}
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
						}
					}
					else if((pair.getKey().getLeftComplexExpr()==null && pair.getKey().getLeft().getId().equals("_"))  || pair.getKey().isValidExpr(pair.getKey()) ) {
						if(!flag) {

							valid = runStatements(valid,tc,pair.getValue());
							flag = true;
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
		if(!valid) {
			System.out.print("Preconditions do not hold (");
			for(Expression c : prec) {
				c.printExpression();
			}
			System.out.println(").");
		}
		return valid;
	}



}
