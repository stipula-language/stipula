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
	ArrayList<Asset> globalAssets = new ArrayList<>();
	ArrayList<Statement> statements = null;
	ArrayList<Expression> prec = null;
	ArrayList<Pair<Expression,ArrayList<Statement>>> ifThenElse = null;
	ArrayList<Party> globalParties = null;
	Event events = null;
	int index;

	public Contract(String name, ArrayList<Field> f, ArrayList<Asset> a, ArrayList<Party> d, ArrayList<String> s1, String s2, int i) {
		id = name;
		vars = f;
		assets = a;
		disputers = d;
		initState = s1;
		endState = s2;
		index = i;
	}

	public void addPrecondition(Expression cond) {
		if (prec == null) {
			prec = new ArrayList<>();
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
		if (statements == null) {
			statements = new ArrayList<>();
		}
		statements.add(stm);
	}

	public ArrayList<Party> getParty() {
		return disputers;
	}

	public ArrayList<Party> getGlobalParties() {
		return globalParties;
	}

	public void setGlobalParties(ArrayList<Party> gD) {
		globalParties = gD;
	}

	public ArrayList<Field> getVars() {
		return vars;
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public ArrayList<Pair<Expression, ArrayList<Statement>>> getIfThenElse() {
		return ifThenElse;
	}

	public void addIfThenElse(ArrayList<Pair<Expression, ArrayList<Statement>>> array) {
		if (ifThenElse == null) {
			ifThenElse = new ArrayList<>();
		}
		for (Pair<Expression, ArrayList<Statement>> pair : array) {
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

	public ArrayList<Field> getGlobalVars() {
		return globalVars;
	}

	public ArrayList<Asset> getGlobalAssets() {
		return globalAssets;
	}

	public ArrayList<Statement> getStatements() {
		return statements;
	}

	public int findVar(String expr, ArrayList<Field> array) {
		if (array == null) return -1;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getId().equals(expr)) {
				return i;
			}
		}
		return -1;
	}

	public int findParty(String expr) {
		if (globalParties == null) return -1;
		for (int i = 0; i < globalParties.size(); i++) {
			if (globalParties.get(i).getId().equals(expr)) {
				return i;
			}
		}
		return -1;
	}

	public int findAsset(String expr, ArrayList<Asset> array) {
		if (array == null) return -1;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getId().equals(expr)) {
				return i;
			}
		}
		return -1;
	}

	public void updateTypes(Map<Pair<String, Integer>, Type> typedVars) {
		if (vars == null) return;
		for (Field f : vars) {
			for (Pair<String, Integer> pair : typedVars.keySet()) {
				if (pair.getKey().equals(f.getId()) && pair.getValue() == index) {
					f.setType(typedVars.get(pair));
				}
			}
		}
	}

	public void setValuesConditions(Entity left, Entity right) {
		if (left != null) {
			int indexLeft = findAsset(left.getId(), assets);
			if (indexLeft != -1) {
				left.setValue((float) assets.get(indexLeft).getValue());
			} else {
				indexLeft = findAsset(left.getId(), globalAssets);
				if (indexLeft != -1) {
					left.setValue((float) globalAssets.get(indexLeft).getValue());
				} else {
					indexLeft = findVar(left.getId(), vars);
					if (indexLeft != -1) {
						if ((vars.get(indexLeft).getType() instanceof TimeType) || vars.get(indexLeft).getValueStr() == null) {
							left.setValue((float) vars.get(indexLeft).getValue());
						} else {
							left.setValueStr(vars.get(indexLeft).getValueStr());
						}
					} else {
						indexLeft = findVar(left.getId(), globalVars);
						if (indexLeft != -1) {
							if ((globalVars.get(indexLeft).getType() instanceof TimeType) || globalVars.get(indexLeft).getValueStr() == null) {
								left.setValue((float) globalVars.get(indexLeft).getValue());
							} else {
								left.setValueStr(globalVars.get(indexLeft).getValueStr());
							}
						} else {
							try {
								left.setValue((float) Double.parseDouble(left.getId()));
							} catch (NumberFormatException e) {
							}
						}
					}
				}
			}
		}
		if (right != null) {
			int indexRight = findAsset(right.getId(), assets);
			if (indexRight != -1) {
				right.setValue((float) assets.get(indexRight).getValue());
			} else {
				indexRight = findAsset(right.getId(), globalAssets);
				if (indexRight != -1) {
					right.setValue((float) globalAssets.get(indexRight).getValue());
				} else {
					indexRight = findVar(right.getId(), vars);
					if (indexRight != -1) {
						if ((vars.get(indexRight).getType() instanceof TimeType) || vars.get(indexRight).getValueStr() == null) {
							right.setValue((float) vars.get(indexRight).getValue());
						} else {
							right.setValueStr(vars.get(indexRight).getValueStr());
						}
					} else {
						indexRight = findVar(right.getId(), globalVars);
						if (indexRight != -1) {
							if ((globalVars.get(indexRight).getType() instanceof TimeType) || globalVars.get(indexRight).getValueStr() == null) {
								right.setValue((float) globalVars.get(indexRight).getValue());
							} else {
								right.setValueStr(globalVars.get(indexRight).getValueStr());
							}
						} else {
							try {
								right.setValue((float) Double.parseDouble(right.getId()));
							} catch (NumberFormatException e) {
							}
						}
					}
				}
			}
		}
	}

	public boolean runStatements(boolean valid, TypeInference tc, ArrayList<Statement> stms) {
		for (Statement s : stms) {

			if (s.getOperator().equals("FIELDUP")) {
				Field rightExpr = (Field) s.getRightExpr();
				String leftExprName = "";
				Entity sourceEntity = new Entity("");

				if (s.getLeftExpression() != null) {
					sourceEntity = evaluateExpression(s.getLeftExpression());
					if (sourceEntity != null) {
						leftExprName = sourceEntity.getId();
					}
				} else {
					Field leftExpr = (Field) s.getLeftExpr();
					leftExprName = leftExpr.getId();
					sourceEntity.setValue(findVariableValue(leftExprName));
				}

				int indexRight = findVar(rightExpr.getId(), vars);
				boolean globalRight = false;
				boolean partyRight = false;
				if (indexRight == -1) {
					indexRight = findVar(rightExpr.getId(), globalVars);
					if (indexRight != -1) {
						globalRight = true;
					} else {
						indexRight = findParty(rightExpr.getId());
						if (indexRight != -1) {
							partyRight = true;
						}
					}
				}

				if (sourceEntity != null && indexRight != -1) {
					if (partyRight) {
						if (sourceEntity.getValueStr() != null) {
							globalParties.get(indexRight).setValueStr(sourceEntity.getValueStr());
						} else {
							globalParties.get(indexRight).setValue(sourceEntity.getValue());
						}
					} else if (globalRight) {
						if (sourceEntity.getValueStr() != null) {
							globalVars.get(indexRight).setValueStr(sourceEntity.getValueStr());
						} else {
							globalVars.get(indexRight).setValue(sourceEntity.getValue());
						}
					} else {
						if (sourceEntity.getValueStr() != null) {
							vars.get(indexRight).setValueStr(sourceEntity.getValueStr());
						} else {
							vars.get(indexRight).setValue(sourceEntity.getValue());
						}
					}
				} else {
					System.err.println("Could not execute FIELDUP statement for source '" + leftExprName + "' and destination '" + rightExpr.getId() + "'");
				}
			} else if (s.getOperator().equals("ASSETUP")) {
				valid = true;
				Asset sourceExpr = (Asset) s.getLeftExpr();
				Asset targetExpr = (Asset) s.getRightExpr();

				int indexLeft = -1, indexRight = -1;
				boolean globalLeft = false, globalRight = false;
				boolean partyLeft = false, partyRight = false;

				String sourceId = sourceExpr.getId();
				if (sourceId.equals("_CALLER_")) {
					if (this.disputers != null && !this.disputers.isEmpty()) {
						indexLeft = findParty(this.disputers.get(0).getId());
						if (indexLeft != -1) {
							partyLeft = true;
						}
					}
				} else {
					indexLeft = findAsset(sourceId, assets);
					if (indexLeft == -1) {
						indexLeft = findAsset(sourceId, globalAssets);
						if (indexLeft != -1) {
							globalLeft = true;
						} else {
							indexLeft = findParty(sourceId);
							if (indexLeft != -1) {
								partyLeft = true;
							}
						}
					}
				}

				String targetId = targetExpr.getId();
				indexRight = findAsset(targetId, assets);
				if (indexRight == -1) {
					indexRight = findAsset(targetId, globalAssets);
					if (indexRight != -1) {
						globalRight = true;
					} else {
						indexRight = findParty(targetId);
						if (indexRight != -1) {
							partyRight = true;
						}
					}
				}

				float valFract = 0;
				String nameFract = s.getFractExpr();

				if (s.getFract() != 0) {
					valFract = (float) s.getFract();
				} else if (nameFract != null && (nameFract.contains("/") || nameFract.contains("*") || nameFract.contains("+") || nameFract.contains("-"))) {
					String cleanExpr = nameFract.replaceAll("[()]", "");
					String[] operands = cleanExpr.split("[/*+-]");
					if (operands.length == 2) {
						float leftVal = findVariableValue(operands[0].trim());
						float rightVal = findVariableValue(operands[1].trim());
						char operator = cleanExpr.replaceAll("[^/*+-]", "").charAt(0);
						switch (operator) {
							case '/': valFract = (rightVal == 0) ? 0 : leftVal / rightVal; break;
							case '*': valFract = leftVal * rightVal; break;
							case '+': valFract = leftVal + rightVal; break;
							case '-': valFract = leftVal - rightVal; break;
						}
					}
				} else if (nameFract != null) {
					valFract = findVariableValue(nameFract);
				} else {
					if (indexLeft != -1) {
						if (partyLeft) valFract = (float) globalParties.get(indexLeft).getValueAsset();
						else if (globalLeft) valFract = (float) globalAssets.get(indexLeft).getValue();
						else valFract = (float) assets.get(indexLeft).getValue();
					}
				}
				if (indexLeft != -1 && indexRight != -1) {
					if (partyLeft && partyRight) {
						globalParties.get(indexLeft).moveAsset(globalParties.get(indexRight), valFract);
					} else if (partyLeft && globalRight) {
						float currentValue = (float) globalAssets.get(indexRight).getValue();
						globalAssets.get(indexRight).setCalcValue(currentValue + valFract);
					} else if (!partyLeft && partyRight && globalLeft) {
						globalAssets.get(indexLeft).withdraw(globalParties.get(indexRight), valFract);
					} else if (!partyLeft && partyRight && !globalLeft) {
						assets.get(indexLeft).withdraw(globalParties.get(indexRight), valFract);
					} else if (!globalLeft && globalRight && !partyLeft) {
						assets.get(indexLeft).move(valFract, globalAssets.get(indexRight));
					} else if (globalLeft && !globalRight && !partyRight) {
						globalAssets.get(indexLeft).move(valFract, assets.get(indexRight));
					} else if (!globalLeft && !partyLeft && !partyRight && !globalRight) {
						assets.get(indexLeft).move(valFract, assets.get(indexRight));
					} else if (globalLeft && globalRight) {
						globalAssets.get(indexLeft).move(valFract, globalAssets.get(indexRight));
					}
				} else {
					System.out.println("ERROR: Execution skipped. Source or Target not found.");
				}
			}
		}
		return valid;
	}

	public boolean runContract(TypeInference tc, int index) {
		Map<Pair<String, Integer>, Type> typedVars = tc.getTypes();
		if (globalVars != null) {
			for (Field f : globalVars) {
				for (Pair<String, Integer> pair : typedVars.keySet()) {
					if (pair.getKey().equals(f.getId()) && pair.getValue() == 0) {
						f.setType(typedVars.get(pair));
					}
				}
			}
		}
		boolean valid = true;
		if (prec != null) {
			for (Expression c : prec) {
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
		if (!valid) {
			System.out.print("Preconditions do not hold (");
			for (Expression c : prec) {
				c.printExpression();
			}
			System.out.println(").");
			return valid;
		}
		if (statements != null && valid) {
			valid = runStatements(valid, tc, statements);
		}
		if (ifThenElse != null && valid) {
			boolean flag = false;
			for (Pair<Expression, ArrayList<Statement>> pair : ifThenElse) {
				if (pair.getKey() != null) {
					if ((pair.getKey().getLeftComplexExpr() == null && pair.getKey().getLeft().getId().equals("_")) || pair.getKey().isValidExpr(pair.getKey())) {
						if (!flag) {
							valid = runStatements(valid, tc, pair.getValue());
							flag = true;
							break;
						}
					}
				}
			}
		}
		return valid;
	}

	private Entity evaluateExpression(Expression expr) {
		if (expr == null) return null;
		if (expr.getLeftComplexExpr() == null && expr.getRightComplexExpr() == null) {
			Entity simpleEntity = expr.getLeft();
			if (simpleEntity == null) return null;
			setValuesConditions(simpleEntity, null);
			return simpleEntity;
		}
		Entity leftValue = evaluateExpression(expr.getLeftComplexExpr());
		Entity rightValue = evaluateExpression(expr.getRightComplexExpr());
		if (leftValue == null || rightValue == null) {
			return null;
		}
		Entity result = new Entity("result");
		String op = expr.getOp();
		switch (op) {
			case "*": result.setValue(leftValue.getValue() * rightValue.getValue()); break;
			case "/": result.setValue(leftValue.getValue() == 0 ? 0 : leftValue.getValue() / rightValue.getValue()); break;
			case "+": result.setValue(leftValue.getValue() + rightValue.getValue()); break;
			case "-": result.setValue(leftValue.getValue() - rightValue.getValue()); break;
			default: return null;
		}
		return result;
	}

	private float findVariableValue(String varName) {
		if (vars != null) {
			int index = findVar(varName, vars);
			if (index != -1) {
				return vars.get(index).getValue();
			}
		}
		if (assets != null) {
			int index = findAsset(varName, assets);
			if (index != -1) {
				return (float) assets.get(index).getValue();
			}
		}
		if (globalVars != null) {
			int index = findVar(varName, globalVars);
			if (index != -1) {
				return globalVars.get(index).getValue();
			}
		}
		if (globalAssets != null) {
			int index = findAsset(varName, globalAssets);
			if (index != -1) {
				return (float) globalAssets.get(index).getValue();
			}
		}
		System.err.println("RUNTIME ERROR: Variable '" + varName + "' could not be found.");
		return 0;
	}
}
