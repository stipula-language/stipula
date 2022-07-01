package ast;

import parser.StipulaBaseListener;
import parser.StipulaParser.AgreementContext;
import parser.StipulaParser.AssetdecContext;
import parser.StipulaParser.DeclistContext;
import parser.StipulaParser.DisputerContext;
import parser.StipulaParser.FunContext;
import parser.StipulaParser.ProgContext;
import parser.StipulaParser.StatContext;
import parser.StipulaParser.VardecContext;

public class StipulaWalker extends StipulaBaseListener{

	public void enterProg(ProgContext ctx) {
		{SymbolTableStack.createScope(0);}
		if(ctx.declist()!=null){
			for(DeclistContext vc : ctx.declist()){
				if(vc.strings()!=null) {
					SymbolTableStack.add(vc.type().getText(), vc.strings().getText());
				}
				else {
					SymbolTableStack.add(vc.type().getText(), vc.strings().getText());
				}
			}
		}
		SymbolTableStack.stack.peek().printSymbolTable();
	}
	
	/*
	public void enterFun(FunContext ctx) {
		SymbolTableStack.createScope(1); 
		if(ctx.vardec()!=null) {
			for(VardecContext vc : ctx.vardec()) {
				if(vc.ID()!=null) {
					SymbolTableStack.add("field", vc.ID().getText());
				}
				else if(vc.LOWER()!=null) {
					SymbolTableStack.add("field", vc.LOWER().getText());
				}
				else if(vc.ID()!=null) {
					SymbolTableStack.add("field", vc.STRING().getText());
				}
			}
		}
		if(ctx.assetdec()!=null) {
			for(AssetdecContext vc : ctx.assetdec()) {
				if(vc.ID()!=null) {
					SymbolTableStack.add("asset", vc.ID().getText());
				}
				else if(vc.LOWER()!=null) {
					SymbolTableStack.add("asset", vc.LOWER().getText());
				}
				else if(vc.ID()!=null) {
					SymbolTableStack.add("asset", vc.STRING().getText());
				}
			}
		}
		
		SymbolTableStack.stack.peek().printSymbolTable();
	}
	
	
	*/
}
