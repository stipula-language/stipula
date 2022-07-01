package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import lib.StipulaLib;
import util.Environment;

public class GeNode implements Node{

	private Node left;
	private Node right;
  
	public GeNode (Node l, Node r) {
		left=l;
		right=r;
	}
  
  
  
	public Node typeCheck() {

		Node l = left.typeCheck();
		Node r = right.typeCheck();
		//check that operand types are compatible
		if (! ( StipulaLib.isSubtype(l,r) || StipulaLib.isSubtype(r,l) ) ) {
			System.out.println("Incompatible types in equal");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	@Override
	public String toVisit() {
		// TODO Auto-generated method stub
		return left.toVisit() + " > " + right.toVisit();

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



	@Override
	public void setType(Node t) {
		// TODO Auto-generated method stub
		
	}  
  
}
