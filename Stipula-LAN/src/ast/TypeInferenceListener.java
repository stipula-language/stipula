package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import javafx.util.Pair;
import parser.StipulaBaseListener;
import parser.StipulaParser.AssetdecContext;
import parser.StipulaParser.DeclistContext;
import parser.StipulaParser.DisputerContext;
import parser.StipulaParser.EventsContext;
import parser.StipulaParser.ExprContext;
import parser.StipulaParser.FunContext;
import parser.StipulaParser.PrecContext;
import parser.StipulaParser.ProgContext;
import parser.StipulaParser.StatContext;
import parser.StipulaParser.ValueContext;
import parser.StipulaParser.VardecContext;

public class TypeInferenceListener extends StipulaBaseListener {

	public Stack<HashMap<Node,Node>>  envs = new Stack<HashMap<Node,Node>>();
	public Stack<HashMap<Node,Node>>  pairs = new Stack<HashMap<Node,Node>>();

	public Stack<HashMap<Node,Node>> getEnvironments() {
		return envs;
	}

	public Stack<HashMap<Node,Node>> getPairs() {
		return pairs;
	}

	public HashMap<Node,Node> putElement(HashMap<Node,Node> h, Node n1, Node type){
		boolean flag = false;
		for (Node name: h.keySet()) {
			String key = name.toVisit();
			if(key.equals(n1.toVisit())) {
				flag = true;
				Node tmp = h.get(name);
				if(tmp==null && type!=null) {
					h.put(name,type);
				}
			}
		}
		if(!flag) {
			h.put(n1,type);
		}
		return h;
	}

	@Override
	public void enterProg(ProgContext ctx) {
		envs = new Stack<>();
		pairs = new Stack<>();

		HashMap<Node,Node> toAdd = new HashMap<Node, Node>();
		HashMap<Node,Node> couples = new HashMap<Node, Node>();

		envs.push(toAdd);
		pairs.push(couples);
	}
	
	@Override
	public void enterPrec(PrecContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		HashMap<Node,Node> couples = pairs.pop();

		Node type = null ;
		Node value = new VarNode(ctx.expr().left.left.left.getText(),type);
		toAdd = putElement(toAdd,value,type);
		if(ctx.expr().left.left.right!=null) {
			Node type2 = null ;
			Node value2 = new VarNode(ctx.expr().left.left.right.getText(),type2);
			toAdd = putElement(toAdd,value2,type2);
			couples.put(value,value2);
		}
		
		envs.push(toAdd);
		pairs.push(couples);
	}

	@Override
	public void enterDeclist(DeclistContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		Node type = null ;
		Node value = null;
		if(ctx.type().PARTY()!=null) {
			type = new DisputerTypeNode();
			value = new DisputerNode(ctx.strings().getText());
		}
		if(ctx.type().FIELD()!=null) {
			type = null;
			value = new VarNode(ctx.strings().getText(),type);
		}
		if(ctx.type().ASSET()!=null) {
			type = new AssetTypeNode();
			value = new AssetNode(ctx.strings().getText(),type);
		}
		if(ctx.type().INIT()!=null) {
			type = new StateTypeNode();
			value = new StateNode(ctx.strings().getText());
		}
		toAdd = putElement(toAdd,value,type);
		envs.push(toAdd);

	}
	@Override
	public void enterFun(FunContext ctx) {
		HashMap<Node,Node> toAdd = new HashMap<Node, Node>();
		HashMap<Node,Node> couples = new HashMap<Node, Node>();

		envs.push(toAdd);
		pairs.push(couples);

	}

	@Override
	public void enterDisputer(DisputerContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		Node type = new DisputerTypeNode();
		Node value = new DisputerNode(ctx.strings().getText());
		toAdd = putElement(toAdd,value,type);
		envs.push(toAdd);
	}

	@Override
	public void enterVardec(VardecContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		Node type = null;
		Node value = new VarNode(ctx.strings().getText(),type);
		toAdd = putElement(toAdd,value,type);
		envs.push(toAdd);
	}

	@Override
	public void enterAssetdec(AssetdecContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		Node type = new AssetTypeNode();
		Node value = new VarNode(ctx.strings().getText(),type);
		toAdd = putElement(toAdd,value,type);
		envs.push(toAdd);
	}

	@Override
	public void enterStat(StatContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		HashMap<Node,Node> couples = pairs.pop();
		if(ctx.EMPTY()==null && ctx.ifelse()==null) {
			Node n1;
			if(ctx.left.NOW()!=null) {
				n1 = new NowNode();
				toAdd = putElement(toAdd,n1,new TimeTypeNode());
			}
			else {
				n1 = new VarNode(ctx.left.getText(),null);
				if(ctx.left.expr()==null) {
					toAdd = putElement(toAdd,n1,null);
				}
			}
			Node n2 = new VarNode(ctx.right.getText(),null);
			if(ctx.FIELDUP()!=null) {
				n2 = new VarNode(ctx.right.getText(),new RealTypeNode());
				toAdd = putElement(toAdd,n2,new RealTypeNode());
			}
			if(ctx.right.EMPTY()==null) {
				toAdd = putElement(toAdd,n2,null);
			}
			
			couples.put(n1,n2);
		}
		envs.push(toAdd);
		pairs.push(couples);
	}
	@Override
	public void enterValue(ValueContext ctx) {
		if(ctx.EMPTY()==null) {
			HashMap<Node,Node> toAdd = envs.pop();
			envs.push(toAdd);
		}
	}
	
	@Override
	public void enterEvents(EventsContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		if(ctx.TRIGGER()!=null && ctx.expr()!=null) {

			Node n1 = new VarNode(ctx.expr().left.getText(),new TimeTypeNode());
			toAdd = putElement(toAdd,n1,new TimeTypeNode());

			if(ctx.expr().right!=null) {
				Node n2 = new VarNode(ctx.expr().right.getText(),new TimeTypeNode());
				toAdd = putElement(toAdd,n2,new TimeTypeNode());
			}

		}
		
		envs.push(toAdd);

	}
	/*
	@Override
	public void enterProg(ProgContext ctx) {
		termMappings = new HashMap<>();
		workingElems = new Stack<>();
		HashMap<Node,Node> toAdd = new HashMap<Node, Node>();
		HashMap<Node,Node> couples = new HashMap<Node, Node>();

		if(ctx.declist()!=null){
			for(DeclistContext vc : ctx.declist()){
				Node value;
				if(vc.type().FIELD()!=null) {
					value = new RealTypeNode();
					Node term = new VarNode(vc.vardec().getText(), new RealTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);
				}
				else {
					value = new AssetTypeNode();
					Node term = new AssetNode(vc.vardec().getText(), new AssetTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);

				}
			}
		}
		envs.push(toAdd);
		pairs.push(couples);


	}

	public void enterFun(FunContext ctx) {
		HashMap<Node,Node> toAdd = new HashMap<Node, Node>();
		HashMap<Node,Node> couples = new HashMap<Node, Node>();

		if(ctx.vardec()!=null) {
			for(VardecContext vc : ctx.vardec()) {
				Node value = new RealTypeNode();
				if(vc.ID()!=null) {
					Node term = new VarNode(vc.ID().getText(), new RealTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
				else if(vc.LOWER()!=null) {
					Node term = new VarNode(vc.LOWER().getText(), new RealTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
				else if(vc.STRING()!=null) {
					Node term = new VarNode(vc.STRING().getText(), new RealTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
			}
		}
		if(ctx.assetdec()!=null) {
			for(AssetdecContext vc : ctx.assetdec()) {
				//Object value;
				Node value = new AssetTypeNode();
				//value = tmp.toVisit();
				if(vc.ID()!=null) {
					Node term = new AssetNode(vc.ID().getText(), new AssetTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
				else if(vc.LOWER()!=null) {
					Node term = new AssetNode(vc.LOWER().getText(), new AssetTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
				else if(vc.STRING()!=null) {
					Node term = new AssetNode(vc.STRING().getText(), new AssetTypeNode());
					termMappings.put(term, value);
					putElement(toAdd,term,value);


				}
			}
		}
		envs.push(toAdd);
		pairs.push(couples);

	}


	public void enterStat(StatContext ctx) {

		HashMap<Node,Node> toAdd = envs.pop();
		HashMap<Node,Node> couple = pairs.pop();
		if(ctx.ASSETUP()!=null) {
			Node n1 = null;
			if(ctx.left.ID()!=null) {
				n1 = new VarNode(ctx.left.ID().getText(), null);
			}
			else if(ctx.left.LOWER()!=null) {
				n1 = new VarNode(ctx.left.LOWER().getText(), null);
			}
			else if(ctx.left.STRING()!=null) {
				n1 = new VarNode(ctx.left.STRING().getText(), null);
			}
			else if(ctx.left.EMPTY()!=null) {
				n1 = new EmptyNode();
			}
			else {
				n1 = new EmptyNode();
			}
			Node n2 = null;
			if(ctx.right.ID()!=null) {
				n2 = new VarNode(ctx.right.ID().getText(), null);
				if(ctx.COMMA()!=null) {

					Node n3 ;
					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);	
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());

				}
			}
			else if(ctx.right.LOWER()!=null) {
				n2 = new VarNode(ctx.right.LOWER().getText(), null);
				if(ctx.COMMA()!=null) {
					Node n3 ;
					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());


				}
			}
			else if(ctx.right.STRING()!=null) {
				n2 = new VarNode(ctx.right.STRING().getText(), null);
				if(ctx.COMMA()!=null) {
					Node n3 ;
					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());


				}
			}
			else if(ctx.right.EMPTY()!=null) {
				n2 = new EmptyNode();
			}
			if(!(n1 instanceof EmptyNode) && !(n2 instanceof EmptyNode)) {
				putElement(toAdd,n1,n1.getType());
				putElement(toAdd,n2,n2.getType());
			}
			else if(!(n1 instanceof EmptyNode)){
				putElement(toAdd,n1,n1.getType());
			}
			else{
				putElement(toAdd,n2,n2.getType());
			}


			Pair<Node,Node> nodes = new Pair<Node,Node>(n1,n2);
			toCheck.add(nodes);
			putElement(couple,nodes.getKey(),nodes.getValue());

		}
		else if(ctx.FIELDUP()!=null) {

			Node n1 = null;
			if(ctx.left.ID()!=null) {
				n1 = new VarNode(ctx.left.ID().getText(), null);
			}
			else if(ctx.left.LOWER()!=null) {
				n1 = new VarNode(ctx.left.LOWER().getText(), null);
			}
			else if(ctx.left.STRING()!=null) {
				n1 = new VarNode(ctx.left.STRING().getText(), null);
			}
			else if(ctx.left.EMPTY()!=null) {
				n1 = new EmptyNode();
			}
			else {
				n1 = new EmptyNode();
			}
			Node n2 = null;
			if(ctx.right.ID()!=null) {
				n2 = new VarNode(ctx.right.ID().getText(), null);
				if(ctx.COMMA()!=null) {
					Node n3 ;

					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);		
					putElement(toAdd,n3,n3.getType());
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());

				}
			}
			else if(ctx.right.LOWER()!=null) {
				n2 = new VarNode(ctx.right.LOWER().getText(), null);
				if(ctx.COMMA()!=null) {
					Node n3 ;

					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);
					putElement(toAdd,n3,n3.getType());
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());


				}
			}
			else if(ctx.right.STRING()!=null) {
				n2 = new VarNode(ctx.right.STRING().getText(), null);
				if(ctx.COMMA()!=null) {
					Node n3 ;
					n3 = new VarNode(ctx.expr().left.getText(), null);
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n2,n3);
					toCheck.add(nodesTmp);
					putElement(toAdd,n3,n3.getType());
					putElement(couple,nodesTmp.getKey(),nodesTmp.getValue());

				}
			}
			else if(ctx.right.EMPTY()!=null) {
				n2 = new EmptyNode();
			}
			if(!(n1 instanceof EmptyNode) && !(n2 instanceof EmptyNode)) {
				putElement(toAdd,n1,n1.getType());
				putElement(toAdd,n2,n2.getType());
			}
			else if(!(n1 instanceof EmptyNode)){
				putElement(toAdd,n1,n1.getType());
			}
			else{
				putElement(toAdd,n2,n2.getType());
			}

			Pair<Node,Node> nodes = new Pair<Node,Node>(n1,n2);
			toCheck.add(nodes);
			putElement(couple,nodes.getKey(),nodes.getValue());


		}
		envs.push(toAdd);
		pairs.push(couple);


	}

	public void enterExpr(ExprContext ctx) {
		HashMap<Node,Node> toAdd = envs.pop();
		HashMap<Node,Node> couples = pairs.pop();

		Node n1 = null;
		Node n2 = null;
		if(ctx.PLUS()!=null || ctx.MINUS()!=null || ctx.OR()!=null) {

			if(!ctx.left.getText().equals("now")) {
				n1 = new AssetNode(ctx.right.getText(), new AssetTypeNode());
				n2 = new AssetNode(ctx.left.getText(), new AssetTypeNode());
			}
			else {
				n1 = new NowNode();
				n2 = new NowNode(ctx.right.getText());
			}
		}
		else if(ctx.left.TIMES()!=null || ctx.left.DIV()!=null || ctx.left.AND()!=null) {

			if(ctx.left.AND()!=null) {
				n1 = new VarNode(ctx.left.left.getText(), new BoolTypeNode());
				n2 = new VarNode(ctx.left.right.getText(), new BoolTypeNode());
				if(ctx.left.left.operator!=null) {
					Node n4, n6;
					if(ctx.left.left.right.number()!=null) {
						n4 = new VarNode(ctx.left.left.right.getText(),new RealTypeNode());
					}
					else {
						n4 = new VarNode(ctx.left.left.right.getText(),null);
						putElement(toAdd,n4,n4.getType());
					}
					Node n3 = new VarNode(ctx.left.left.left.getText(),null);
					putElement(toAdd,n3,n3.getType());
					Pair<Node,Node> nodesTmp = new Pair<Node,Node>(n3,n4);
					toCheck.add(nodesTmp);
					if(ctx.left.left.right.number()!=null) {
						n6 = new VarNode(ctx.left.right.left.right.getText(),new RealTypeNode());

					}
					else {
						n6 = new VarNode(ctx.left.right.left.right.getText(),null);
						putElement(toAdd,n6,n6.getType());

					}
					Node n5 = new VarNode(ctx.left.right.left.left.getText(),null);
					putElement(toAdd,n5,n5.getType());


					Pair<Node,Node> nodesTmp2 = new Pair<Node,Node>(n5,n6);
					toCheck.add(nodesTmp2);
					putElement(couples,nodesTmp2.getKey(),nodesTmp2.getValue());


				}

			}
			else {
				n1 = new AssetNode(ctx.left.left.getText(), new AssetTypeNode());
				n2 = new AssetNode(ctx.left.right.getText(), new AssetTypeNode());	
			}

		}
		else if(ctx.left.left.EQ()!=null || ctx.left.left.NEQ()!=null || ctx.left.left.LE()!=null || ctx.left.left.GE()!=null || ctx.left.left.LEQ()!=null || ctx.left.left.GEQ()!=null) {

			n1 = new VarNode(ctx.left.left.left.getText(),null);
			if(ctx.left.left.right.number()!=null) {
				n2 = new VarNode(ctx.left.left.right.getText(), new RealTypeNode());
			}
			else {
				n2 = new VarNode(ctx.left.left.right.getText(), null);
			}
		}
		else {
			n1 = new EmptyNode();
			n2 = new EmptyNode();

		}

		Pair<Node,Node> nodes = new Pair<Node,Node>(n1,n2);
		toCheck.add(nodes);
		putElement(couples,nodes.getKey(),nodes.getValue());
		pairs.push(couples);
		envs.push(toAdd);
	}
	 */
}


