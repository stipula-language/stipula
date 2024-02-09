package ast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import lib.Pair;

public class Event  {

	final int SECS = 60;
	final int MINS = 60;

	String init = null;
	String end = null;
	ArrayList<Pair<Expression,ArrayList<Statement>>> statements = null;
	Expression expr = null;
	Timer timer;
	Contract contract;

	public Event(String i, String f, ArrayList<Pair<Expression,ArrayList<Statement>>> stms, Expression e) {
		init = i;
		end = f;
		statements = stms;
		expr = e;
	}

	public void addContract(Contract c) {
		contract = c;
	}

	public Contract getContract() {
		return contract;
	}

	public long evaluateEvent(Program program) {
		long seconds = 0;
		DateUtils d = new DateUtils();

		if(expr.getOp()==null){
			Entity left = expr.getLeft();
			int indexVar = contract.findVar(left.getId(), program.getFields()) ;
			
			if(program.getFields().get(indexVar).getValueStr()==null) {
				left.setValue(program.getFields().get(indexVar).getValue());

			}
			else {
				left.setValueStr(program.getFields().get(indexVar).getValueStr());

			}
			
			program.getFields().get(indexVar).setType(new TimeType());
			contract.setValuesConditions(left,null);
			if(!left.getValueStr().equals("")) {
				seconds = d.calculateSeconds(left.getValueStr());
			}
			else {
				seconds = (int) (left.getValue()*SECS*MINS);
			}

		}
		else if(expr.getLeftComplexExpr()!=null){

			Entity left = expr.getLeftComplexExpr().getLeft();
			if(left==null) {
				left = new Entity(expr.getLeftComplexExpr().getTextExpression());
			}
			Entity right = null;

			if(expr.getRightComplexExpr()!=null) {
				right = expr.getRightComplexExpr().getLeft();
			}
			else {
				right = expr.getLeftComplexExpr().getRight();
			}


			String op = expr.getOp();
			int indexVarLeft;
			int indexVarRight;
			if(left!=null && left.getId().equals("now")) {
				left.setValue(0);
				System.out.println(right.getId());
				indexVarRight = contract.findVar(right.getId(), program.getFields()) ;
				if(indexVarRight == -1) {
					if(right.getId().matches("-?\\d+(\\.\\d+)?")) {
						right.setValue(Float.parseFloat(right.getId()));
					}
				}
				else {
					right.setValue(program.getFields().get(indexVarRight).getValue());
					program.getFields().get(indexVarRight).setType(new TimeType());

				}


				contract.setValuesConditions(null,right);
			}
			else if(right.getId().equals("now")) {
				right.setValue(0);
				indexVarLeft = contract.findVar(left.getId(), program.getFields()) ;
				program.getFields().get(indexVarLeft).setType(new TimeType());
				left.setValue(program.getFields().get(indexVarLeft).getValue());
				contract.setValuesConditions(left,null);
			}
			else {

				indexVarLeft = contract.findVar(left.getId(), program.getFields()) ;
				program.getFields().get(indexVarLeft).setType(new TimeType());
				left.setValue(program.getFields().get(indexVarLeft).getValue());

				indexVarRight = contract.findVar(right.getId(), program.getFields()) ;
				program.getFields().get(indexVarRight).setType(new TimeType());
				right.setValue(program.getFields().get(indexVarRight).getValue());

				contract.setValuesConditions(left,right);
			}
			if(op.equals("+")) {

				if(!left.getValueStr().equals("")) {
					seconds = (int) (d.calculateSeconds(left.getValueStr())+right.getValue()*SECS*MINS);
				}
				else if(!right.getValueStr().equals("")){
					seconds = (int) (left.getValue()*SECS*MINS+d.calculateSeconds(right.getValueStr()));
				}
				else {

					seconds = (int) (left.getValue()+right.getValue()*SECS*MINS);
				}
			}

		}

		else if(expr.getTextExpression().equals("now")) {
			seconds = 0; 
		}

		return seconds;
	}

	public void setTimer(int seconds) {
		Object lock = new Object();

		timer = new Timer();
		timer.schedule(new DelayEvent(lock), seconds*1000);
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException ex) {
			}
		}
	}

	class DelayEvent extends TimerTask {

		private Object lock;

		public DelayEvent(Object lock) {
			this.lock = lock;
		}
		public void run() {
			synchronized (lock) {
				lock.notifyAll();
			}
			timer.cancel(); 
		}
	}


	public String getInitState() {
		return init;
	}

	public String getEndState() {
		return end;
	}

	public ArrayList<Pair<Expression,ArrayList<Statement>>> getStatements(){
		return statements;
	}

	public Expression getExpression() {
		return expr;
	}

	public String printEvent() {
		String ret = expr.getTextExpression()+" >> @" +init +"{\n\t";
		for(Pair<Expression,ArrayList<Statement>> pair : statements) {
			if(pair.getKey()!=null) {
				ret = ret + pair.getKey().getTextExpression();
			}
			for(Statement stm : pair.getValue()) {
				ret = ret + stm.getTextStatement();
				ret = ret + "\n\t";
			}
		}
		ret = ret + " } ==> @"+end;
		return ret;
	}
}
