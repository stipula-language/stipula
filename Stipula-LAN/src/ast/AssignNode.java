package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class AssignNode implements Node{

	ArrayList<Node> disputers = new ArrayList<Node>();
	ArrayList<Node> vars = new ArrayList<Node>();

	public AssignNode(ArrayList<Node> d, ArrayList<Node> v) {
		for(Node vc : d) {
			disputers.add(vc);
		}
		for(Node vc : v) {
			vars.add(vc);
		}
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
		for(int i=0; i<disputers.size(); i++) {
			str = str + disputers.get(i).toVisit() ;
			if(i!=disputers.size()-1) {
				str = str + ", ";
			}
		}
		str = str + " : ";
		for(int i=0; i<vars.size(); i++) {
			str = str + vars.get(i).toVisit() ;
			if(i!=vars.size()-1) {
				str = str + ", ";
			}
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
