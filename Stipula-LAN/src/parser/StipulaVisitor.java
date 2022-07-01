// Generated from Stipula.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StipulaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StipulaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull StipulaParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreement(@NotNull StipulaParser.AgreementContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(@NotNull StipulaParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull StipulaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#disputer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisputer(@NotNull StipulaParser.DisputerContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull StipulaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#declist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclist(@NotNull StipulaParser.DeclistContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(@NotNull StipulaParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull StipulaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(@NotNull StipulaParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetdec(@NotNull StipulaParser.AssetdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrings(@NotNull StipulaParser.StringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrec(@NotNull StipulaParser.PrecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull StipulaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull StipulaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull StipulaParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(@NotNull StipulaParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarasm(@NotNull StipulaParser.VarasmContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull StipulaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull StipulaParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(@NotNull StipulaParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvents(@NotNull StipulaParser.EventsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull StipulaParser.AssignContext ctx);
}