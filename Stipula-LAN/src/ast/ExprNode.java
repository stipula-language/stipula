package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class ExprNode implements Node{

	String id;
	int val ;
	double doubleVal;
	
	String lhs;
	String rhs;
	String op;
	
	public ExprNode() {
	}
	
	public ExprNode(String i) {
		id = i;
	}
	
	public ExprNode(int i) {
		val = i;
		id = String.valueOf(val);
	}
	
	public ExprNode(double i) {
		doubleVal = i;
		id = String.valueOf(doubleVal);
	}
	
	public ExprNode(String l, String r, String o) {
		lhs = l;
		rhs = r;
		op = o;
	}
	public ExprNode(String l, String r) {
		lhs = l;
		rhs = r;
		op = null;
	}
	
	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toVisit() {
		String str = "";
		
		if(id!=null) {
			str = str + id;
		}
		else {
			str = lhs + " " + op + " " + rhs;
		}
		return str;
	}



	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTableStack genTypes(int scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(Node t) {
		// TODO Auto-generated method stub
		
	}

}
