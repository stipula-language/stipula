package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class LiquidityTypeNode implements Node {
  
	public LiquidityTypeNode () {
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
		return "liquidity type";
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
  
	
	public boolean equals(Object obj)   
	{  
		if (obj == null)   
			return false;  
		if (obj == this)  
			return true;  
		else
			return false;
	}


	@Override
	public void setType(Node t) {
		// TODO Auto-generated method stub
		
	} 
}  