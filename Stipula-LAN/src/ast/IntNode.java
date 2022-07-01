package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class IntNode implements Node {

	private Integer val;
  
	public IntNode (Integer n) {
		val=n;
	}
  
	public String toPrint(String s) {
		return s+"Int:" + Integer.toString(val) +"\n";  
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
		return Integer.toString(val);
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