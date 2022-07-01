package ast;

public class Statement {
	
	
	private double fract=1;
	private Entity leftExpr;
	private Entity rightExpr;
	private Entity fractExpr;

	private String operator;
	
	public Statement(Entity lE, Entity rE, String op) {
		leftExpr = lE;
		rightExpr = rE;
		operator = op;
	}
	
	public Statement(Entity lE, Entity rE, String op, double f) {
		leftExpr = lE;
		fract = f;
		rightExpr = rE;
		operator = op;
		
	}
	
	public Statement(Entity lE, Entity rE, String op, Entity f) {
		leftExpr = lE;
		fractExpr = f;
		rightExpr = rE;
		operator = op;
		fract = 0;
	}
	
	
	public String getOperator() {
		return operator;
	}
	
	public Entity getLeftExpr() {
		return leftExpr;
	}
	
	public double getFract() {
		return fract;
	}
	
	public String getFractExpr() {
		return fractExpr.getId();
	}
	
	public Entity getRightExpr() {
		return rightExpr;
	}
	
	public void printStatement() {
		if(operator.equals("FIELDUP")){
			System.out.println(leftExpr.getId()+" -> "+rightExpr.getId());
		}
		else {
			if(fract!=1) {
				System.out.println(fract+"*"+leftExpr.getId()+" -○ "+rightExpr.getId());
			}
			else {
				System.out.println(leftExpr.getId()+" -○ "+rightExpr.getId());
			}
		}
	}
	public String getTextStatement() {
		String ret = "";
		if(operator.equals("FIELDUP")){
			ret = ret + leftExpr.getId()+" -> "+rightExpr.getId();
		}
		else {
			if(fract!=1) {
				ret = ret + fract+"*"+leftExpr.getId()+" -○ "+rightExpr.getId();
			}
			else {
				ret = ret + leftExpr.getId()+" -○ "+rightExpr.getId();
			}
		}
		return ret;
	}
}
