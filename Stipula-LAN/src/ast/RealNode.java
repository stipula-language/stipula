package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class RealNode implements Node {

	private double val;
  
	public RealNode (double n) {
		val=n;
	}
  
	public String toPrint(String s) {
		return s+"Int:" + Double.toString(val) +"\n";  
	}
  
	public Node typeCheck() {
		return new IntTypeNode();
	} 
  
	public String codeGeneration() {
		return "push "+val+"\n";
	}

	@Override
	public String toVisit() {
		// TODO Auto-generated method stub
		return Double.toString(val);
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