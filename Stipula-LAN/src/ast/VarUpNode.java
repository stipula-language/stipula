package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class VarUpNode implements Node {

	String varUp1;
	String varUp2;
	String varUp3;


	public VarUpNode(String var1, String var2) {
		varUp1 = var1;
		varUp2 = var2;

	}
	
	public VarUpNode(String var1, String var2, String var3) {
		varUp1 = var1;
		varUp2 = var2;
		varUp3 = var3;

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
		String str = varUp1 + " -> " + varUp2;
		if(varUp3!=null) {
			str = str + ", " + varUp3;
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
