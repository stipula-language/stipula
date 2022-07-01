package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class FieldUpNode implements Node{
	Node fieldUp1;
	Node fieldUp2;
	Node fieldUp3;


	public FieldUpNode(Node field1, Node field2) {
		fieldUp1 = field1;
		fieldUp2 = field2;

	}
	
	public FieldUpNode(Node field1, Node field2, Node field3) {
		fieldUp1 = field1;
		fieldUp2 = field2;
		fieldUp3 = field3;

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
		String str = fieldUp1.toVisit() + " -> " + fieldUp2.toVisit();
		if(fieldUp3!=null) {
			str = str + ", " + fieldUp3.toVisit();
		}
		return str;
	}

	/*
	@Override
	public ArrayList<Pair<Node, Node>> genTypes() {
		ArrayList<Pair<Node,Node>> ret = new ArrayList<Pair<Node,Node>>();
		if(fieldUp1.getType() == fieldUp2.getType() ) {
			Pair<Node,Node> tmp = new Pair<Node,Node>(this,fieldUp1.getType());
			ret.add(tmp);
		}
		else {
			ret = null;
		}
		return ret;
	}*/

	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return new FieldTypeNode();
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
