package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import lib.StipulaLib;
import util.Environment;
import util.SemanticError;

public class AndNode implements Node {

	private Node left;
	private Node right;
  
	public AndNode (Node l, Node r) {
		left=l;
		right=r;
	}
  
	public String toPrint(String s) {
		return s+"And\n" + left.toPrint(s+"  ")   
						 + right.toPrint(s+"  ") ; 
	}
  
	public Node typeCheck() {
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		
		if (! ( StipulaLib.isSubtype(l, new BoolTypeNode()) && StipulaLib.isSubtype(r, new BoolTypeNode() ) ) ) {
			System.out.println("Non booleans in and");
			System.exit(0);
		}
		return new BoolTypeNode();
	}  

	@Override
	public String toVisit() {
		// TODO Auto-generated method stub
		return left.toVisit() + " && " + right.toVisit();
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