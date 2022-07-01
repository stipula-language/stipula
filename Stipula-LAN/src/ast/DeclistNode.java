package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class DeclistNode implements Node{

	Node type ;
	Node id ;

	public DeclistNode(Node t, Node v) {
		type = t;
		id = v;
	}

	public Node getType() {
		return type;
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
		return type.toVisit() + " " + id.toVisit();
	}


	@Override
	public SymbolTableStack genTypes(int scope) {
		SymbolTableStack ret = new SymbolTableStack();
		ret.createScope(scope);
		ret.add(type.toVisit(), id.toVisit());
		return ret;
	}

	@Override
	public void setType(Node t) {
		// TODO Auto-generated method stub
		
	}



}
