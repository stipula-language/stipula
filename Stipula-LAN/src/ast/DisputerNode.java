package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class DisputerNode implements Node {
	
	private String id ;
	private Node type ;
	
	//var declaration without initialization
	public DisputerNode (String name) {
		id = name;
	}
 
	public DisputerNode (Node t, Node i) {
		id=i.toVisit();
		type = t;
	}
	
	public DisputerNode (Node i) {
		id=i.toVisit();
		type = new DisputerTypeNode();
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
		return id;
	}



	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return new DisputerTypeNode();
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