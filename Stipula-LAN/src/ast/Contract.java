package ast;

import java.util.ArrayList;
import java.util.Map;

import javafx.util.Pair;

public class Contract {

	ArrayList<Disputer> disputers = null;
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
	ArrayList<Disputer> globalDisputers = null;

	Event events = null;
	int index ;

	public Contract(String name, ArrayList<Field> f, ArrayList<Asset> a, ArrayList<Disputer> d, ArrayList<String> s1, String s2, int i){
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

	public ArrayList<Disputer> getDisputer(){
		return disputers;
	}
	public ArrayList<Disputer> getGlobalDisputers(){
		return globalDisputers;
	}
	public void setGlobalDisputers( ArrayList<Disputer> gD) {
		globalDisputers = gD;
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

	public int findDisputer(String expr) {
		int index = -1;
		for(int i = 0; i<globalDisputers.size(); i++) {
			if(globalDisputers.get(i).getId().equals(expr)) {
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

	}

	public boolean runStatements(boolean valid, TypeInference tc, ArrayList<Statement> stms) {

		for(Statement s : stms) {
			if(s.getOperator().equals("FIELDUP")) {

				Field leftExpr = (Field) s.getLeftExpr();
				Field rightExpr = (Field) s.getRightExpr();
				if(leftExpr.getId().equals("_")||rightExpr.getId().equals("_")) {
					break;
				}
				int indexLeft = findVar(leftExpr.getId(),vars);
				int indexRight = findVar(rightExpr.getId(),vars);

				boolean globalLeft = false;
				boolean globalRight = false;
				boolean partyLeft = false;
				boolean partyRight = false;
				boolean extLeft = false;
				boolean extRight = false;

				if(indexLeft==-1) {
					indexLeft = findVar(leftExpr.getId(),globalVars);
					if(indexLeft == -1) {
						indexLeft = findDisputer(leftExpr.getId());
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
				if(indexRight==-1) {
					indexRight = findVar(rightExpr.getId(),globalVars);
					if(indexRight == -1) {
						indexRight = findDisputer(rightExpr.getId());
						if(indexRight==-1) {
							extRight = true;
						}
						else{
							partyRight =  true;
						}
					}
					else {
						globalRight = true;
					}
				}
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
						globalDisputers.get(indexRight).setValue((float)Double.parseDouble(leftExpr.getId()));
					}
					catch(NumberFormatException e)
					{
						globalDisputers.get(indexRight).setValueStr(String.format(leftExpr.getId()));
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
				else if(!partyLeft && partyRight && globalLeft) {
					Type t1 = tc.getCorrectType(globalVars.get(indexLeft),index);

					if(!(t1 instanceof StringType)) {
						globalDisputers.get(indexRight).setValue((float) (globalDisputers.get(indexRight).getValue()+(float) globalVars.get(indexLeft).getValue()));
					}
					else {
						globalDisputers.get(indexRight).setValueStr(globalDisputers.get(indexRight).getValueStr()+globalVars.get(indexLeft).getValueStr());
					}
					globalVars.get(indexRight).setType(t1);

				}
				else if(!partyLeft && partyRight && !globalLeft) {
					Type t1 = tc.getCorrectType(vars.get(indexLeft),index);
					if(!(t1 instanceof StringType)) {
						globalDisputers.get(indexRight).setValue((float) (globalDisputers.get(indexRight).getValue()+(float) vars.get(indexLeft).getValue()));
					}
					else {
						globalDisputers.get(indexRight).setValueStr(globalDisputers.get(indexRight).getValueStr()+vars.get(indexLeft).getValueStr());
					}
					vars.get(indexRight).setType(t1);
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
						indexLeft = findDisputer(leftExpr.getId());
						partyLeft =  true;
					}
					else {
						globalLeft = true;
					}
				}
				if(indexRight==-1) {
					indexRight = findAsset(rightExpr.getId(),globalAssets);

					if(indexRight == -1) {
						indexRight = findDisputer(rightExpr.getId());

						partyRight =  true;
					}
					else {
						globalRight = true;
					}
				}

				if(partyLeft && partyRight) {
					if(s.getFract()!=0) {
						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)s.getFract())*globalDisputers.get(indexLeft).getValueAsset());
						globalDisputers.get(indexLeft).setValueAsset((float) ((float) globalDisputers.get(indexLeft).getValueAsset()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)valFract)*globalDisputers.get(indexLeft).getValueAsset());
						globalDisputers.get(indexLeft).setValueAsset((float) ((float) globalDisputers.get(indexLeft).getValueAsset()*((float)(1-valFract))));
					}

				}
				else if(!partyLeft && partyRight && globalLeft) {
					if(s.getFract()!=0) {
						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)s.getFract())*globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)valFract)*globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*((float)(1-valFract))));
					}

				}
				else if(!partyLeft && partyRight && !globalLeft) {
					if(s.getFract()!=0) {
						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)s.getFract())*assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalDisputers.get(indexRight).setValueAsset(globalDisputers.get(indexRight).getValueAsset()+((float)valFract)*assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-valFract))));
					}
				}
				else if(!globalLeft && !globalRight) {
					if(s.getFract()!=0) {
						assets.get(indexRight).setValue(assets.get(indexRight).getValue()+((float)s.getFract())*assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						assets.get(indexRight).setValue(assets.get(indexRight).getValue()+((float)valFract)*assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-valFract))));
					}
				}
				else if(globalLeft && !globalRight) {
					if(s.getFract()!=0) {
						assets.get(indexRight).setValue(assets.get(indexRight).getValue()+((float)s.getFract())*globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						assets.get(indexRight).setValue(assets.get(indexRight).getValue()+((float)valFract)*globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*((float)(1-valFract))));
					}
				}
				else if(!globalLeft && globalRight) {
					if(s.getFract()!=0) {

						globalAssets.get(indexRight).setValue(globalAssets.get(indexRight).getValue()+((float)s.getFract())* assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalAssets.get(indexRight).setValue(globalAssets.get(indexRight).getValue()+((float)valFract)*assets.get(indexLeft).getValue());
						assets.get(indexLeft).setValue((float) ((float) assets.get(indexLeft).getValue()*((float)(1-valFract))));
					}
				}
				else if(globalLeft && globalRight) {
					if(s.getFract()!=0) {

						globalAssets.get(indexRight).setValue(globalAssets.get(indexRight).getValue()+((float)s.getFract())* globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*(float)((1-s.getFract()))));
					}
					else {
						String nameFract = s.getFractExpr();
						int indexFract = findVar(nameFract,vars);
						float valFract = vars.get(indexFract).getValue();

						globalAssets.get(indexRight).setValue(globalAssets.get(indexRight).getValue()+((float)valFract)*globalAssets.get(indexLeft).getValue());
						globalAssets.get(indexLeft).setValue((float) ((float) globalAssets.get(indexLeft).getValue()*((float)(1-valFract))));
					}
				}
			}
		}
		return valid;
	}

	public boolean runContract(TypeInference tc, int index) {
		Map<Pair<String,Integer>,Type> typedVars = tc.getTypes();
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
