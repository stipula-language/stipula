package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class StateNode implements Node{

	private String id;
	private Node type;
	
	public StateNode(String i) {
		id = i;
	}
	
	public StateNode(Node t, Node i) {
		id = i.toVisit();
		type = t;
	}
	
	public StateNode(Node i) {
		id = i.toVisit();
		type = new StateTypeNode();
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
		return id.toString();
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
