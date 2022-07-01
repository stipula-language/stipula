package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class IdNode implements Node {

	private String id;
	private STentry entry;
	private Node type;
	private int nestinglevel;
	
	public IdNode (String i) {
		id=i;
	}
  
	public String toPrint(String s) {
		return null;  
	}
  
  
	public Node typeCheck () {
		//a function identifier cannot be used without the round brackets
		/*
		if (entry.getType() instanceof ArrowTypeNode) {
			System.out.println("Wrong usage of function identifier");
			System.exit(0);
		}	 
		return entry.getType();*/
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