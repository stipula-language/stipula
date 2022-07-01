package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class StatNode implements Node {

	Node prec ;
	Node stat;
	
	public StatNode(Node p, Node s) {
		prec = p;
		stat = s;
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
		str = "(" + prec.toVisit() + ")" + "{\n\t\t" + stat.toVisit() + "\n\t}";
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
