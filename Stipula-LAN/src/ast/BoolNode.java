package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;


public class BoolNode implements Node {

	private boolean val;
	  
	public BoolNode (boolean n) {
		val=n;
	}
  
  
	public Node typeCheck() {
		return new BoolTypeNode();
	}    
  
	public String codeGeneration() {
		return "push "+(val?1:0)+"\n";
	}

	@Override
	public String toVisit() {
		String str;
		if(val) {
			str = "true";
		}
		else {
			str = "false";
		}
		return str;
	}


	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
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