package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class StringNode implements Node {

	private String id;
  
	public StringNode (String i) {
		id=i;
	}
  
	public String toPrint(String s) {
		return null;  
	}
  
  
	public Node typeCheck () {
		return null;
	}

	@Override
	public String toVisit() {
		return id;
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