package ast;


import parser.StipulaParser.AgreementContext;
import parser.StipulaParser.AssetdecContext;
import parser.StipulaParser.AssignContext;
import parser.StipulaParser.DeclistContext;
import parser.StipulaParser.DisputerContext;
import parser.StipulaParser.EventsContext;
import parser.StipulaParser.ExprContext;
import parser.StipulaParser.IfelseContext;
import parser.StipulaParser.NumberContext;
import parser.StipulaParser.PrecContext;
import parser.StipulaParser.ProgContext;
import parser.StipulaParser.StatContext;
import parser.StipulaParser.StateContext;
import parser.StipulaParser.StringsContext;
import parser.StipulaParser.VardecContext;
import parser.StipulaBaseVisitor;
import parser.StipulaParser;
import parser.StipulaParser.FactorContext;
import parser.StipulaParser.FunContext;
import parser.StipulaParser.IdContext;
import parser.StipulaParser.TermContext;
import parser.StipulaParser.TypeContext;
import parser.StipulaParser.ValueContext;

import java.util.ArrayList;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;


public class StipulaVisitorImpl extends StipulaBaseVisitor<Node> {

	
	public Node visitProg(ProgContext ctx) {
		Node agree = null;
		if(ctx.agreement()!=null) {
			agree = visitAgreement(ctx.agreement());
		}
		ArrayList<Node> funcs = new ArrayList<Node>();
		for(int i=0; i<ctx.fun().size(); i++) {
			funcs.add(visitFun(ctx.fun().get(i)));
		}
		if(ctx.declist()!=null) {
			ArrayList<Node> decs = new ArrayList<Node>();
			ArrayList<Node> types = new ArrayList<Node>();

			for(int i=0; i<ctx.declist().size(); i++) {
				decs.add(visitDeclist(ctx.declist().get(i)));
				types.add(visitType(ctx.declist().get(i).type()));
			}
			return new ProgNode(visitId(ctx.id()),decs,types,funcs,agree);
		}
		return new ProgNode(visitId(ctx.id()),funcs,agree);

	}

	public Node visitDeclist(DeclistContext ctx) {
		if(ctx.type().FIELD()!=null) {
			return new VarNode(visitStrings(ctx.strings()),visitType(ctx.type()));
		}
		else if(ctx.type().ASSET()!=null) {
			return new AssetNode(visitStrings(ctx.strings()),visitType(ctx.type()));

		}
		else if(ctx.type().PARTY()!=null) {
			return new DisputerNode(visitStrings(ctx.strings()),visitType(ctx.type()));

		}
		else if(ctx.type().INIT()!=null) {
			return new StateNode(visitStrings(ctx.strings()),visitType(ctx.type()));
		}
		return null;
	}

	public Node visitStrings(StringsContext ctx) {

		if(ctx.ID()!=null) {
			return new IdNode(ctx.ID().getText());
		}
		return null;
	}

	public Node visitType(TypeContext ctx) {
		if(ctx.FIELD()!=null) {
			return new FieldTypeNode();
		}
		else if(ctx.BOOLEAN()!=null) {
			return new BoolTypeNode();
		}
		else if(ctx.INTEGER()!=null) {
			return new IntTypeNode();
		}
		else if(ctx.DOUBLE()!=null) {
			return new RealTypeNode();
		}
		else if(ctx.ASSET()!=null) {
			return new AssetTypeNode();
		}
		else if(ctx.PARTY()!=null) {
			return new DisputerTypeNode();
		}
		return new StateTypeNode();
	}

	public Node visitAgreement(AgreementContext ctx) {
		ArrayList<Node> disp = new ArrayList<Node>();
		ArrayList<Node> vars = new ArrayList<Node>();
		ArrayList<Node> ass = new ArrayList<Node>();

		for(DisputerContext vc : ctx.disputer()) {
			disp.add(visitDisputer(vc));
		}
		for(VardecContext vc : ctx.vardec()) {
			vars.add(visitVardec(vc));
		}
		for(AssignContext vc : ctx.assign()) {
			ass.add(visitAssign(vc));
		}
		return new AgreementNode(disp,vars,ass);
	}

	public Node visitAssign(AssignContext ctx) {
		ArrayList<Node> disp = new ArrayList<Node>();
		ArrayList<Node> vars = new ArrayList<Node>();
		for(DisputerContext vc : ctx.disputer()) {
			disp.add(visitDisputer(vc));
		}
		for(VardecContext vc : ctx.vardec()) {
			vars.add(visitVardec(vc));
		}
		return new AssignNode(disp,vars);
	}

	public Node visitId(IdContext ctx) {

		return new IdNode(ctx.ID().getText());

	}

	public Node visitFun(FunContext ctx) {
		ArrayList<Node> fields = new ArrayList<Node>();
		ArrayList<Node> assets = new ArrayList<Node>();
		ArrayList<Node> prec = new ArrayList<Node>();
		ArrayList<Node> stats = new ArrayList<Node>();
		ArrayList<Node> event = new ArrayList<Node>();
		ArrayList<Node> disp = new ArrayList<Node>();

		FunNode res;
		if(ctx.state().size()==1) {
			res = new FunNode(visitId(ctx.id()), visitState(ctx.state(0))); // Mettere lo stato di inizio e fine, mettere i disputer e le varie variabili
		}
		else {
			res = new FunNode(visitId(ctx.id()), visitState(ctx.state(0)), visitState(ctx.state(1)));
		}
		// 	Aggiungo disputer
		for(DisputerContext vc : ctx.disputer()) {
			disp.add(visitDisputer(vc));
		}
		res.addDisputers(disp);


		// Aggiungo fields
		if(ctx.vardec().size()>0) {

			for(VardecContext vc : ctx.vardec()) {
				fields.add(visitVardec(vc));
			}
			res.addVarlist(fields);
		}

		if(ctx.assetdec().size()>0) {
			for(AssetdecContext vc : ctx.assetdec()) {
				assets.add(visitAssetdec(vc));

			}
			res.addAssetlist(assets);
		}

		if(ctx.prec()!=null) {
			res.addPreconditions(visitPrec(ctx.prec()));
		}

		// Aggiungo statements
		if(ctx.stat().size()>0) {
			for(StatContext vc : ctx.stat()) {
				stats.add(visitStat(vc));

			}
			res.addStatements(stats);
		}

		if(ctx.events().size()>0) {
			// Aggiungo events
			for(EventsContext vc : ctx.events()) {
				event.add(visitEvents(vc));
			}
			res.addEvents(event);
		}

		return res;		

	}

	public Node visitState(StateContext ctx) {

		return new StateNode(visitStrings(ctx.strings()));

	}

	public Node visitDisputer(DisputerContext ctx) {
		return new DisputerNode(visitStrings(ctx.strings()));
	}

	public Node visitVardec(VardecContext ctx) {	
		return new VarNode(visitStrings(ctx.strings()), new RealTypeNode());
	}

	public Node visitAssetdec(AssetdecContext ctx) {	
		return new VarNode(visitStrings(ctx.strings()), new AssetTypeNode());

	}

	public Node visitStat(StatContext ctx) {	
		if(ctx.ASSETUP()!=null) {
			if(ctx.COMMA()!=null) {
				return new AssetUpNode(visit(ctx.left), visit(ctx.right), visit(ctx.rightPlus));
			}
			return new AssetUpNode(visit(ctx.left), visit(ctx.right));

		}
		else if(ctx.FIELDUP()!=null) {
			if(ctx.COMMA()!=null) {
				return new FieldUpNode(visit(ctx.left), visit(ctx.right), visit(ctx.rightPlus));
			}
			return new FieldUpNode(visit(ctx.left), visit(ctx.right));

		}
		else if(ctx.EMPTY()!=null) {
			return new EmptyNode();
		}
		else {
			return visitIfelse(ctx.ifelse());
		}
	}

	@Override
	public Node visitIfelse(IfelseContext ctx) {

		IfNode res;

		Node condExp = visitExpr (ctx.cond); 
		ArrayList<Node> ifNodes = new ArrayList<Node>();

		for (StatContext vc : ctx.ifBranch) {
			ifNodes.add(visit(vc));
		}

		ArrayList<Node> elseifConds = new ArrayList<Node>();
		ArrayList<ArrayList<Node>> elseifNodes = new ArrayList<ArrayList<Node>>();

		ArrayList<Node> elseNodes = new ArrayList<Node>();

		if(ctx.ELSEIF()!=null) {
			int k = 0;
			int j = 0;
			for(int i = 1; i < ctx.expr().size(); i++) {
				
				elseifConds.add(visit(ctx.expr().get(i)));
				ArrayList<Node> tmp = new ArrayList<Node>();
				boolean flag = false;
				Node nullNode = new EmptyNode();
				for(j=k; i<ctx.elseIfBranch.size() && !flag; j++) {

					if(!ctx.elseIfBranch.get(j).getText().equals(nullNode.toVisit())) {
						tmp.add(visit(ctx.elseIfBranch.get(j)));
					}
					else {
						flag = true;
						k = j+1;
					}
				}
				elseifNodes.add(tmp);
			}
		}
		if(ctx.ELSE()!=null) {
			for (StatContext vc : ctx.elseBranch) {
				elseNodes.add(visit(vc));
			}
		}


		if(ctx.ELSEIF()!=null && ctx.ELSE()!=null) {
			res = new IfNode(condExp, ifNodes, elseifConds, elseifNodes, elseNodes);
		}
		else if(ctx.ELSEIF()==null && ctx.ELSE()!=null) {
			res = new IfNode(condExp, ifNodes, elseNodes);
		}
		else if(ctx.ELSEIF()!=null && ctx.ELSE()==null) {
			res = new IfNode(condExp, ifNodes, elseifConds, elseifNodes);
		}
		else {
			res = new IfNode(condExp, ifNodes);
		}
		return res;
	}

	public Node visitEvents(EventsContext ctx) {
		if(ctx.EMPTY()==null) {
			ArrayList<Node> nodes = new ArrayList<Node>();
			for(int i=0; i<ctx.stat().size(); i++) {
				nodes.add(visitStat(ctx.stat().get(i)));
			}
			return new EventNode(visitExpr(ctx.expr()),nodes, ctx.ID(0).getText(), ctx.ID(1).getText());
		}
		else {
			return new EventNode();
		}
	}

	public Node visitPrec(PrecContext ctx) {

		return visitExpr(ctx.expr());
	}

	@Override
	public Node visitValue(ValueContext ctx) {
		if (ctx.TRUE()!=null || ctx.FALSE()!=null) {
			return new BoolNode(Boolean.parseBoolean(ctx.getText())); 
		}
		else if (ctx.EMPTY()!=null) {
			return new EmptyNode(); 
		}
		else if (ctx.NOW()!=null) {
			return new NowNode(ctx.getText()); 
		}
		else if (ctx.strings()!=null) {
			return visitStrings(ctx.strings()); 
		}
		else if(ctx.number()!=null) {
			return visitNumber(ctx.number());
		}
		else if(ctx.expr()!=null) {
			return visitExpr(ctx.expr());
		}	
		return visit(ctx);
	}

	public Node visitNumber(NumberContext ctx) {
		if(ctx.INT()!=null) {
			return new IntNode(Integer.parseInt(ctx.INT().getText()));
		}
		else {
			return new RealNode(Double.parseDouble(ctx.REAL().getText()));
		}
	}



	public Node visitExpr(ExprContext ctx) {

		if(ctx.right == null){
			return visit( ctx.left );
		}
		else{
			if(ctx.PLUS() != null)
				return new PlusNode(visit(ctx.left), visit(ctx.right));
			else if(ctx.OR() != null)
				return new OrNode(visit(ctx.left), visit(ctx.right));
			return new MinusNode(visit(ctx.left), visit(ctx.right));
		}
	}

	@Override
	public Node visitTerm(StipulaParser.TermContext ctx) {
		if(ctx.right == null){
			return visit( ctx.left );
		}else{
			if(ctx.TIMES() != null)
				return new MultNode(visit(ctx.left), visit(ctx.right));
			if(ctx.AND() != null)
				return new AndNode(visit(ctx.left), visit(ctx.right));
			else return new DivNode(visit(ctx.left), visit(ctx.right));
		}
	}

	@Override
	public Node visitFactor(StipulaParser.FactorContext ctx) {
		if(ctx.right == null){
			return visit( ctx.left );
		}else{
			if(ctx.GEQ() != null)
				return new GeqNode(visit(ctx.left), visit(ctx.right));
			else if(ctx.GE() != null)
				return new GeNode(visit(ctx.left), visit(ctx.right));
			else if(ctx.NEQ() != null)
				return new NeqNode(visit(ctx.left), visit(ctx.right));
			else if(ctx.LEQ() != null)
				return new LeqNode(visit(ctx.left), visit(ctx.right));
			else if(ctx.LE() != null)
				return new LeNode(visit(ctx.left), visit(ctx.right));
			return new EqNode(visit(ctx.left), visit(ctx.right));
		}
	}

}
