package ast;

public class Expression {

	private Entity leftExpr = null;
	private Entity rightExpr = null;
	private Expression leftComplexExpr = null;
	private Expression rightComplexExpr = null;
	private String op ;

	public Expression(Entity lE, Entity rE, String o) {
		leftExpr = lE;
		rightExpr = rE;
		op = o;
	}

	public Expression(Expression lE, Expression rE, String o) {
		leftComplexExpr = lE;
		rightComplexExpr = rE;
		op = o;
	}
	
	public Expression(Entity lE, String o) {
		leftExpr = lE;
		op = o;
	}
	
	public void setOp(String ops) {
		op = ops;
	}
	
	public Expression(Entity lE) {
		leftExpr = lE;
		op = null;
	}

	public Entity getLeft() {
		return leftExpr;
	}

	public Entity getRight() {
		return rightExpr;
	}
	
	public String getOp() {
		return op;
	}


	public boolean isValid(Entity left, Entity right, String op) {

		if(op.equals("==")) {
			if(left.getValueStr()!="") {
				return left.getValueStr().equals(right.getValueStr());
			}
			return left.getValue()==right.getValue();
		}
		else if(op.equals("!=")) {
			if(left.getValueStr()!="") {
				return !left.getValueStr().equals(right.getValueStr());
			}
			return left.getValue()!=right.getValue();
		}
		else if(op.equals(">")) {
			return left.getValue()>right.getValue();
		}
		else if(op.equals(">=")) {
			return left.getValue()>=right.getValue();
		}
		else if(op.equals("<=")) {
			return left.getValue()<=right.getValue();
		}
		else if(op.equals("<")) {
			return left.getValue()<right.getValue();
		}
		return false;

	}
	
	public boolean isValidExpr(Expression expr) {

		if(expr.getLeftComplexExpr()!=null && expr.getRightComplexExpr()!=null) {
			boolean leftExpr = isValid(expr.getLeftComplexExpr().getLeft(),expr.getLeftComplexExpr().getRight(),expr.getLeftComplexExpr().getOp());
			boolean rightExpr = isValid(expr.getRightComplexExpr().getLeft(),expr.getRightComplexExpr().getRight(),expr.getRightComplexExpr().getOp());
			
			if(expr.getOp().equals("||")) {
				return leftExpr || rightExpr;
			}
			else {
				return leftExpr && rightExpr;
			}
		}
		else {
			return isValid(expr.getLeft(),expr.getRight(),expr.getOp());
		}
		

	}
	
	public Expression getLeftComplexExpr() {
		return leftComplexExpr;
	}
	
	public Expression getRightComplexExpr() {
		return rightComplexExpr;
	}

	public void printExpression() {
		if(leftComplexExpr!=null) {
			if(rightComplexExpr!=null) {
				leftComplexExpr.printExpression();
				System.out.print(" "+op+" ");
				rightComplexExpr.printExpression();
			}
			else {
				leftComplexExpr.printExpression();

			}
		}
		else if(rightExpr!=null && op!=null) {
			System.out.print(leftExpr.getId()+" "+op+" "+rightExpr.getId());
		}
		else if(op!=null) {
			System.out.print(leftExpr.getId()+" "+op);
		}
		else {
			System.out.print(leftExpr.getId());
		}

	}

	public String getTextExpression() {
		String ret = "";
		if(leftComplexExpr!=null) {
			if(rightComplexExpr!=null) {
				ret = ret + leftComplexExpr.getTextExpression();
				ret = ret + (" "+op+" ");
				ret = ret + rightComplexExpr.getTextExpression();
			}
			else {
				ret = ret + leftComplexExpr.getTextExpression();

			}
		}
		else if(rightExpr!=null && op!=null) {
			ret = ret + leftExpr.getId()+" "+op+" "+rightExpr.getId();
		}
		else if(op!=null) {
			ret = ret + leftExpr.getId()+" "+op;
		}
		else {
			ret = ret + leftExpr.getId();
		}
		return ret;
	}
	
}
