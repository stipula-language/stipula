package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import lib.StipulaLib;
import util.Environment;
import util.SemanticError;

public class MultNode implements Node {

	private Node left;
	private Node right;
  
	public MultNode (Node l, Node r) {
		left=l;
		right=r;
	}
  
	public String toPrint(String s) {
		return 	s+"Mult\n"  + left.toPrint(s+"  ")  
							+ right.toPrint(s+"  ") ; 
	}
  
	public Node typeCheck() {
		//check that operands are numbers
		if ((! ( StipulaLib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
				StipulaLib.isSubtype(right.typeCheck(),new IntTypeNode()) ) )
			|| ! ( StipulaLib.isSubtype(left.typeCheck(),new RealTypeNode()) &&
					StipulaLib.isSubtype(right.typeCheck(),new RealTypeNode()) )) {
			System.out.println("Non valid type in multiplication");
			System.exit(0);
		}
		if(( StipulaLib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
				StipulaLib.isSubtype(right.typeCheck(),new IntTypeNode()))) {
			return new IntTypeNode();
		}
		return new RealTypeNode();
	}  

	@Override
	public String toVisit() {
		// TODO Auto-generated method stub
		return left.toVisit()+"*"+right.toVisit();
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