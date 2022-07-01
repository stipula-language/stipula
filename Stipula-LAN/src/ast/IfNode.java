package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import lib.StipulaLib;
import util.Environment;
import util.SemanticError;

public class IfNode implements Node {

	private Node cond;
	private ArrayList<Node> ifNodes = new ArrayList<Node>();
	private ArrayList<Node> condNodes = new ArrayList<Node>();
	private ArrayList<ArrayList<Node>> elseIfNodes = new ArrayList<ArrayList<Node>>();
	private ArrayList<Node> elseNodes = new ArrayList<Node>();

	public IfNode (Node c, ArrayList<Node> i) {
		cond=c;
		for(Node n : i) {
			ifNodes.add(n);
		}
		elseIfNodes = null;
		elseNodes = null;
	}

	public IfNode (Node c, ArrayList<Node> i, ArrayList<Node> ec, ArrayList<ArrayList<Node>> ei) {
		cond=c;
		for(Node n : i) {
			ifNodes.add(n);
		}
		for(Node n : ec) {
			condNodes.add(n);
		}
		for(ArrayList<Node> n : ei) {
			elseIfNodes.add(n);
		}
		elseNodes = null;
	}

	public IfNode (Node c, ArrayList<Node> i, ArrayList<Node> ec, ArrayList<ArrayList<Node>> ei, ArrayList<Node> e) {
		cond=c;
		for(Node n : i) {
			ifNodes.add(n);
		}
		for(Node n : ec) {
			condNodes.add(n);
		}
		for(ArrayList<Node> n : ei) {
			elseIfNodes.add(n);
		}
		for(Node n : e) {
			elseNodes.add(n);
		}
	}

	public IfNode (Node c, ArrayList<Node> i, ArrayList<Node> e) {
		cond=c;
		for(Node n : i) {
			ifNodes.add(n);
		}
		for(Node n : e) {
			elseNodes.add(n);
		}
		elseIfNodes = null;
		elseNodes = null;
	}

	public String toPrint(String s) {
		return null;
	}


	public Node typeCheck() {
		
		//check that condition is a boolean expression
		if (!(StipulaLib.isSubtype(cond.typeCheck(),new BoolTypeNode()))) {
			System.out.println("non boolean condition in if");
			System.exit(0);
		}
		for(int i=0; i<condNodes.size(); i++) {
			if (!(StipulaLib.isSubtype(condNodes.get(i).typeCheck(),new BoolTypeNode()))) {
				System.out.println("non boolean condition in an else if");
				System.exit(0);
			}
		}

		//check that the type of two branches are compatible
		/*Node t = th.typeCheck();
		Node e = el.typeCheck();
		if (StipulaLib.isSubtype(t,e)) 
			return e;
		if (StipulaLib.isSubtype(e,t))
			return t;
		System.out.println("Incompatible types in then else branches");
		System.exit(0);
*/
		return null;
		//not use, the method exit with a correct type or with a message error
	}


	@Override
	public String toVisit() {
		String str = "if ("+cond.toVisit()+") {\n" ;
		for(Node n : ifNodes) {
			str = str + "\t\t\t" + n.toVisit() + "\n";
		}
		str = str + "\t\t}";
		if(elseIfNodes!=null) {
			for(int i = 0; i<condNodes.size(); i++) {
				str = str + "else if (" ;
				str = str + condNodes.get(i).toVisit() + ") {\n";
				for(Node m : elseIfNodes.get(i)) {
					str = str + "\t\t\t" + m.toVisit() + "\n";
				}
				str = str + "\t\t}";
			}
		}
		if(elseNodes!=null) {
			str = str + "else {\n";
			for(Node n: elseNodes) {
				str = str + "\t\t\t" + n.toVisit() + "\n";
			}
			str = str + "\n\t\t}";
		}
		return str;
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