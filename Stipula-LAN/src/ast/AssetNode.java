package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class AssetNode implements Node {

	private String id;
	private Node exp;
	private Node type;
  
	//var declaration without initialization
	public AssetNode (Node i, Node t) {
		id=i.toVisit();
		exp=null;
		type = t;
	}
	
	public AssetNode (String i, Node t) {
		id=i;
		exp=null;
		type = t;
	}
  
	public AssetNode (String i, Node v, Node t) {
		id=i;
		exp=v;
		type = t;
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
		// TODO Auto-generated method stub
		return id;
	}


	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return type;
	}


	@Override
	public SymbolTableStack genTypes(int scope) {
		SymbolTableStack ret = new SymbolTableStack();
		ret.createScope(scope);
		if(exp==null) {
			ret.add(this.type.toVisit(), this.id);
		}
		else {
			ret.add(this.id,this.type.toVisit(),this.exp.toVisit()); // SISTEMARE
		}
		return ret;
	}

	@Override
	public void setType(Node t) {
		this.type = t;
	}
  
}