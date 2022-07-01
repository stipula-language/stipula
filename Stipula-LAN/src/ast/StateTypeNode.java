package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class StateTypeNode implements Node {
  
	public StateTypeNode () {
	}
  
	public String toPrint(String s) {
		return s+"IntType\n";  
	}
  
	//non utilizzato
	public Node typeCheck() {
		return null;
	}

	//non utilizzato
	public String codeGeneration() {
		return "";
	}
  
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return new ArrayList<SemanticError>();
	}

	@Override
	public String toVisit() {
		// TODO Auto-generated method stub
		return "init";
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