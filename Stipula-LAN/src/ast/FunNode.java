package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class FunNode implements Node {

	private Node id;
	private ArrayList<Node> varlist = null; 
	private ArrayList<Node> assetlist  = null; 
	private ArrayList<Node> disputers  = null; 
	private Node preconditions  = null; 
	private ArrayList<Node> statements  = null; 
	private ArrayList<Node> states  = null; 
	private ArrayList<Node> events  = null; 
	private Node initState; 
	private Node endState; 

	public FunNode (Node i,Node init, Node end) {
		id=i;
		initState = init;
		endState = end;
	}

	public FunNode (Node i, Node init) {
		id=i;
		initState = init;

	}

	public void addDisputers(ArrayList<Node> d) {
		disputers = new ArrayList<Node>();
		for(int i=0; i<d.size(); i++) {
			disputers.add(d.get(i));
		}
	}

	public void addVarlist(ArrayList<Node> v) {
		varlist = new ArrayList<Node>();

		for(int i=0; i<v.size(); i++) {
			varlist.add(v.get(i));
		}
	}

	public void addAssetlist(ArrayList<Node> a) {
		assetlist = new ArrayList<Node>();

		for(int i=0; i<a.size(); i++) {
			assetlist.add(a.get(i));
		}
	}

	public void addPreconditions(Node p) {
		preconditions = p;
	}

	public void addStatements(ArrayList<Node> s) {
		statements = new ArrayList<Node>();

		for(int i=0; i<s.size(); i++) {
			statements.add(s.get(i));
		}
	}

	public void addEvents(ArrayList<Node> e) {
		events = new ArrayList<Node>();

		for(int i=0; i<e.size(); i++) {
			events.add(e.get(i));
		}
	}

	public void addStates(ArrayList<Node> s) {
		states = new ArrayList<Node>();

		for(int i=0; i<s.size(); i++) {
			states.add(s.get(i));
		}
	}


	public String getFunctionId () {
		return id.toVisit();
	}

	public Node getInitState () {
		return initState;
	}

	public Node getEndState () {
		return endState;
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
		String str = "@";
		str = str+initState.toVisit()+ " ";
		for(int i = 0; i<disputers.size(); i++) {
			str = str + disputers.get(i).toVisit();
			if(i!=disputers.size()-1) {
				str = str + ", ";
			}
		}
		str = str + ": " + id.toVisit() ;
		if(varlist!=null){
			str = str + "(";
			for(int i = 0; i<varlist.size(); i++) {
				str = str + varlist.get(i).toVisit();
				if(i!=varlist.size()-1) {
					str = str + ", ";
				}
			}
			str = str + ")";
		}

		if(assetlist!=null){
			str = str + "[";
			for(int i = 0; i<assetlist.size(); i++) {

				str = str + assetlist.get(i).toVisit();
				if(i!=assetlist.size()-1) {
					str = str + ", ";
				}
			}
			str = str + "]";
		}

		if(preconditions!=null) {
			str = str + "(" + preconditions.toVisit() + ")";
		}		

		str = str + "{\n";

		if(statements!=null) {
			for(int i = 0; i<statements.size(); i++) {
				str = str + "\t\t"+statements.get(i).toVisit() + "\n";
			}
		}

		if(events!=null) {
			for(int i = 0; i<events.size(); i++) {
				str = str + "\t" + events.get(i).toVisit() + "\n";
			}
		}
		str = str + "\n\t" + "} ==> @" + endState.toVisit() + "\n";

		return str;
	}

	@Override
	public SymbolTableStack genTypes(int scope) {
		SymbolTableStack ret = new SymbolTableStack();
		ret.createScope(scope);
		ArrayList<SymbolTable> tmp = new ArrayList<SymbolTable>();
		if(varlist!=null){
			for(Node vc : varlist) {
				SymbolTable toAdd = vc.genTypes(scope).stack.pop();
				tmp.add(toAdd);
			}
			for(int i=0; i<tmp.size(); i++) {
				ret.add(tmp.get(i));
			}
		}
		int size = tmp.size();

		if(assetlist!=null){
			for(Node vc : assetlist) {
				tmp.add(vc.genTypes(scope).stack.pop());

			}
			for(int i=size; i<tmp.size(); i++) {
				ret.add(tmp.get(i));
			}
		}
		
		return ret;
	}

	@Override
	public Node getType() {
		// TODO Auto-generated method stub

		return null;
	}

	

	@Override
	public void setType(Node t) {
		// TODO Auto-generated method stub
		
	}




}  