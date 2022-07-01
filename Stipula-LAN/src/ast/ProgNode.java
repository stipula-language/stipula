package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javafx.util.Pair;
import util.Environment;

public class ProgNode implements Node{

	Node id ;
	ArrayList<Node> declist = new ArrayList<Node>();
	ArrayList<Node> typelist = new ArrayList<Node>();

	ArrayList<Node> funcs = new ArrayList<Node>();
	Node agree ;

	public ProgNode(Node id, ArrayList<Node> dec, ArrayList<Node> types, ArrayList<Node> f, Node a) {
		this.id = id;
		for (Node vc : dec) {
			declist.add(vc);
		}
		for (Node vc : types) {
			typelist.add(vc);
		}
		agree = a;
		for (Node vc : f) {
			funcs.add(vc);
		}
	}

	public ProgNode(Node id,ArrayList<Node> f, Node a) {
		this.id = id;
		declist = null;
		agree = a;
		for (Node vc : f) {
			funcs.add(vc);
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
		String str = "stipula " + id.toVisit() + "{\n";
		if(declist!=null) {
			for(int i=0; i<declist.size(); i++) {
				str = str + "\t" + typelist.get(i).toVisit() + " " + declist.get(i).toVisit() + "\n";
			}
		}
		str = str + "\t" ;
		if(agree!=null) {
			str = str + agree.toVisit();
		}
		for(Node vc : funcs) {
			str = str + "\t" + vc.toVisit() + "\n";
		}
		str = str + "}";
		return str;
	}

	public SymbolTableStack genTypes(int scope){
		SymbolTableStack ret = new SymbolTableStack();
		ret.createScope(scope);
		ArrayList<SymbolTable> tmp = new ArrayList<SymbolTable>();
		if(declist!=null){
			for(Node vc : declist) {
				tmp.add(vc.genTypes(scope).stack.pop());
				ret.add(tmp.get(tmp.size()-1));
			}

		}

		if(funcs!=null) {
			scope = scope+1;
			for(Node vc : funcs) {
				ret.createScope(scope);
				tmp.add(vc.genTypes(scope).stack.pop());
				ret.add(tmp.get(tmp.size()-1));
			}
			

		}
		ret.toVisit();
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
