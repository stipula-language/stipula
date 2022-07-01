package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class LowerNode implements Node {

	private String id;
	private STentry entry;
	private Node type;
	private int nestinglevel;



	public LowerNode (String i) {
		id=i;
	}

	public String toPrint(String s) {
		return null;  
	}

	public void setType(Node t) {
		type = t;
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
/*
	@Override
	public HashMap<String, STentry> genTypes(Environment env) {
		//create result list
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();

		//search the id entry in the symbol tables
		int j=env.nestingLevel;
		STentry tmp=null; 
		while (j>=0 && tmp==null)
			tmp=(env.symTable.get(j--)).get(id);

		if (tmp==null) {
			res.add(new SemanticError("Id "+id+" not declared"));
		}
		else{
			entry = tmp;
			nestinglevel = env.nestingLevel;
			type = entry.getType();

		}

		return env.symTable.get(nestinglevel);
	}*/

	@Override
	public Node getType() {

		return null;
	}

	@Override
	public SymbolTableStack genTypes(int scope) {
		// TODO Auto-generated method stub
		return null;
	}


}  
