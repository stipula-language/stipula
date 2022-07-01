package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class EventNode implements Node{

	ArrayList<Node> stats ;
	Node expr;
	String initState;
	String endState;

	public EventNode() {
		expr = null;
		stats = null;
		initState = null;
		endState = null;
	}

	public EventNode(Node s, ArrayList<Node> nodes, String init, String end) {
		expr = s;
		stats = new ArrayList<Node>();
		for(int i=0; i<nodes.size(); i++) {
			stats.add(nodes.get(i));
		}
		initState = init;
		endState = end;
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
		String str = "";
		if(initState!=null) {
			str = str + "\t"+ expr.toVisit() + " >> @" + initState+ " \n";
			for(int i=0; i<stats.size(); i++) {
				str = str + "\t \t " + stats.get(i).toVisit();
				str = str +"\n";
			}
			str = str + "\t} ==> @" + endState;
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
