package ast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import lib.Pair;

public class Event  {

	final int SECS = 60;
	final int MINS = 1; // now + 1 : 60 seconds, change in case you want to express in hours

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

	private long evalTextualDelay(Program program) {
		DateUtils d = new DateUtils();
		long total = 0L;
		String text = expr.getTextExpression();
		if (text == null) return 0L;
		text = text.replaceAll("\\s+", " ").trim();
		String[] parts = text.split("\\+");
		for (String raw : parts) {
			String term = raw.trim();
			if (term.equals("now")) continue;
			if (term.matches("-?\\d+(?:\\.\\d+)?")) {
				total += (long)(Float.parseFloat(term) * SECS * MINS);
				continue;
			}
			int idx = contract.findVar(term, program.getFields());
			if (idx >= 0) {
				String vstr = program.getFields().get(idx).getValueStr();
				if (vstr != null && !vstr.equals("")) {
					total += d.calculateSeconds(vstr);
				} else {
					total += (long)(program.getFields().get(idx).getValue() * SECS * MINS);
				}
			}
		}
		return total;
	}

	public long evaluateEvent(Program program) {
		long seconds = 0;
		DateUtils d = new DateUtils();

		if (expr.getTextExpression() != null && expr.getTextExpression().contains("+")) {
			String text = expr.getTextExpression().replaceAll("\\s+", " ").trim();
			String[] parts = text.split("\\+");

			long totalSecs = 0L;

			Entity firstTerm = null;
			Entity secondTerm = null;

			for (String raw : parts) {
				String term = raw.trim();
				if (term.isEmpty() || term.equals("now")) continue;

				if (firstTerm == null) {
					firstTerm = new Entity(term);
				} else if (secondTerm == null) {
					secondTerm = new Entity(term);
				}

				if (term.matches("-?\\d+(?:\\.\\d+)?")) {
					double minutes = Double.parseDouble(term);
					totalSecs += Math.round(minutes * SECS * MINS);
					continue;
				}

				int idx = contract.findVar(term, program.getFields());
				if (idx >= 0) {
					program.getFields().get(idx).setType(new TimeType());

					float minutes = program.getFields().get(idx).getValue();
					totalSecs += Math.round(minutes * SECS * MINS);
				}
			}

			if (firstTerm != null && secondTerm != null) {
				contract.setValuesConditions(firstTerm, secondTerm);
			} else if (firstTerm != null) {
				contract.setValuesConditions(firstTerm, null);
			} else {
				contract.setValuesConditions(null, null);
			}

			return totalSecs;
		}


		if (expr.getOp() == null && !expr.getTextExpression().equals("now")) {
			Entity left = expr.getLeft();
			int indexVar = contract.findVar(left.getId(), program.getFields());

			if (program.getFields().get(indexVar).getValueStr() == null) {
				left.setValue(program.getFields().get(indexVar).getValue());
			} else {
				left.setValueStr(program.getFields().get(indexVar).getValueStr());
			}

			program.getFields().get(indexVar).setType(new TimeType());
			contract.setValuesConditions(left, null);

			if (!left.getValueStr().equals("")) {
				seconds = d.calculateSeconds(left.getValueStr());
			} else {
				seconds = (int) (left.getValue() * SECS * MINS);
			}
		}
		else if (expr.getLeftComplexExpr() != null) {
			Entity left = expr.getLeftComplexExpr().getLeft();
			if (left == null) {
				left = new Entity(expr.getLeftComplexExpr().getTextExpression());
			}
			Entity right = null;

			expr.printExpression();

			if (expr.getRightComplexExpr() != null) {
				right = expr.getRightComplexExpr().getLeft();
			} else if (expr.getLeftComplexExpr() != null) {
				right = expr.getLeftComplexExpr().getRight();
			}

			String op = expr.getOp();
			int indexVarLeft;
			int indexVarRight;

			if (left != null && "now".equals(left.getId())) {
				left.setValue(0);

				if (right != null) {
					indexVarRight = contract.findVar(right.getId(), program.getFields());
					if (indexVarRight == -1) {
						if (right.getId() != null && right.getId().matches("-?\\d+(\\.\\d+)?")) {
							right.setValue(Float.parseFloat(right.getId()));
						}
					} else {
						right.setValue(program.getFields().get(indexVarRight).getValue());
						program.getFields().get(indexVarRight).setType(new TimeType());
					}
				}

				contract.setValuesConditions(null, right);
			}
			else if (right != null && "now".equals(right.getId())) {
				right.setValue(0);
				indexVarLeft = contract.findVar(left.getId(), program.getFields());
				program.getFields().get(indexVarLeft).setType(new TimeType());
				left.setValue(program.getFields().get(indexVarLeft).getValue());
				contract.setValuesConditions(left, null);
			}
			else {
				if (left != null) {
					indexVarLeft = contract.findVar(left.getId(), program.getFields());
					program.getFields().get(indexVarLeft).setType(new TimeType());
					left.setValue(program.getFields().get(indexVarLeft).getValue());
				}
				if (right != null) {
					indexVarRight = contract.findVar(right.getId(), program.getFields());
					program.getFields().get(indexVarRight).setType(new TimeType());
					right.setValue(program.getFields().get(indexVarRight).getValue());
				}
				contract.setValuesConditions(left, right);
			}

			if ("+".equals(op)) {
				if (left != null && left.getValueStr() != null && !left.getValueStr().equals("")) {
					seconds = (int) (d.calculateSeconds(left.getValueStr())
							+ (right != null ? right.getValue() * SECS * MINS : 0));
				}
				else if (right != null && right.getValueStr() != null && !right.getValueStr().equals("")) {
					seconds = (int) ((left != null ? left.getValue() * SECS * MINS : 0)
							+ d.calculateSeconds(right.getValueStr()));
				}
				else {
					seconds = (int) ((left != null ? left.getValue() * SECS * MINS : 0)
							+ (right != null ? right.getValue() * SECS * MINS : 0));
				}
			}
		}
		else if (expr.getTextExpression().equals("now")) {
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
