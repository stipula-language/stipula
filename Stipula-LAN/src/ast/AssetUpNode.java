package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;

public class AssetUpNode implements Node{
	Node assUp1;
	Node assUp2;
	Node assUp3;


	public AssetUpNode(Node asset1, Node asset2) {
		assUp1 = asset1;
		assUp2 = asset2;

	}
	
	public AssetUpNode(Node asset1, Node asset2, Node asset3) {
		assUp1 = asset1;
		assUp2 = asset2;
		assUp3 = asset3;

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
		String str = assUp1.toVisit() + " -o " + assUp2.toVisit();
		if(assUp3!=null) {
			str = str + ", " + assUp3.toVisit();
		}
		return str;
	}

	/*@Override
	public ArrayList<Pair<Node, Node>> genTypes() {
		System.out.println( assUp1.getType());

		ArrayList<Pair<Node,Node>> ret = new ArrayList<Pair<Node,Node>>();
		if(assUp1.getType() == assUp2.getType() ) {
			Pair<Node,Node> tmp = new Pair<Node,Node>(this,assUp1.getType());
			ret.add(tmp);
		}
		else {
			ret = null;
		}
		return ret;
	}*/

	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return new AssetTypeNode();
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
