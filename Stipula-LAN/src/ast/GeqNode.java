package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import lib.StipulaLib;
import util.Environment;

public class GeqNode implements Node{

	private Node left;
	private Node right;
  
	public GeqNode (Node l, Node r) {
		left=l;
		right=r;
	}
  
	public String toPrint(String s) {
		return s+"Equal\n"  + left.toPrint(s+"  ")   
							+ right.toPrint(s+"  ") ; 
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
		return left.toVisit() + " >= " + right.toVisit();

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
