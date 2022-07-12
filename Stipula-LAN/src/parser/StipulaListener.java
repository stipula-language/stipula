package parser;

// Generated from Stipula.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StipulaParser}.
 */
public interface StipulaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull StipulaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull StipulaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 */
	void enterAgreement(@NotNull StipulaParser.AgreementContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 */
	void exitAgreement(@NotNull StipulaParser.AgreementContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 */
	void enterReal(@NotNull StipulaParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 */
	void exitReal(@NotNull StipulaParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull StipulaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull StipulaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#disputer}.
	 * @param ctx the parse tree
	 */
	void enterDisputer(@NotNull StipulaParser.DisputerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#disputer}.
	 * @param ctx the parse tree
	 */
	void exitDisputer(@NotNull StipulaParser.DisputerContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull StipulaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull StipulaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#declist}.
	 * @param ctx the parse tree
	 */
	void enterDeclist(@NotNull StipulaParser.DeclistContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#declist}.
	 * @param ctx the parse tree
	 */
	void exitDeclist(@NotNull StipulaParser.DeclistContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(@NotNull StipulaParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(@NotNull StipulaParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull StipulaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull StipulaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(@NotNull StipulaParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(@NotNull StipulaParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 */
	void enterAssetdec(@NotNull StipulaParser.AssetdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 */
	void exitAssetdec(@NotNull StipulaParser.AssetdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 */
	void enterPrec(@NotNull StipulaParser.PrecContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 */
	void exitPrec(@NotNull StipulaParser.PrecContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#strings}.
	 * @param ctx the parse tree
	 */
	void enterStrings(@NotNull StipulaParser.StringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#strings}.
	 * @param ctx the parse tree
	 */
	void exitStrings(@NotNull StipulaParser.StringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull StipulaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull StipulaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull StipulaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull StipulaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull StipulaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull StipulaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(@NotNull StipulaParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(@NotNull StipulaParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterVarasm(@NotNull StipulaParser.VarasmContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitVarasm(@NotNull StipulaParser.VarasmContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull StipulaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull StipulaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull StipulaParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull StipulaParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(@NotNull StipulaParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(@NotNull StipulaParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 */
	void enterEvents(@NotNull StipulaParser.EventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 */
	void exitEvents(@NotNull StipulaParser.EventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull StipulaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull StipulaParser.AssignContext ctx);
}