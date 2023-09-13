// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StipulaParser}.
 */
public interface StipulaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(StipulaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(StipulaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 */
	void enterAgreement(StipulaParser.AgreementContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 */
	void exitAgreement(StipulaParser.AgreementContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#assetdecl}.
	 * @param ctx the parse tree
	 */
	void enterAssetdecl(StipulaParser.AssetdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#assetdecl}.
	 * @param ctx the parse tree
	 */
	void exitAssetdecl(StipulaParser.AssetdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#fielddecl}.
	 * @param ctx the parse tree
	 */
	void enterFielddecl(StipulaParser.FielddeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#fielddecl}.
	 * @param ctx the parse tree
	 */
	void exitFielddecl(StipulaParser.FielddeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(StipulaParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(StipulaParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(StipulaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(StipulaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(StipulaParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(StipulaParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(StipulaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(StipulaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(StipulaParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(StipulaParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#party}.
	 * @param ctx the parse tree
	 */
	void enterParty(StipulaParser.PartyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#party}.
	 * @param ctx the parse tree
	 */
	void exitParty(StipulaParser.PartyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(StipulaParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(StipulaParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 */
	void enterAssetdec(StipulaParser.AssetdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 */
	void exitAssetdec(StipulaParser.AssetdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterVarasm(StipulaParser.VarasmContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitVarasm(StipulaParser.VarasmContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(StipulaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(StipulaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(StipulaParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(StipulaParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 */
	void enterEvents(StipulaParser.EventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 */
	void exitEvents(StipulaParser.EventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 */
	void enterPrec(StipulaParser.PrecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 */
	void exitPrec(StipulaParser.PrecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(StipulaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(StipulaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(StipulaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(StipulaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(StipulaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(StipulaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(StipulaParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(StipulaParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 */
	void enterReal(StipulaParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 */
	void exitReal(StipulaParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(StipulaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(StipulaParser.NumberContext ctx);
}