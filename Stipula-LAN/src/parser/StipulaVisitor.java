// Generated from java-escape by ANTLR 4.11.1
package parser;

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
	 * Visit a parse tree produced by {@link StipulaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(StipulaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#agreement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreement(StipulaParser.AgreementContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#assetdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetdecl(StipulaParser.AssetdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#fielddecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFielddecl(StipulaParser.FielddeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(StipulaParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(StipulaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(StipulaParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(StipulaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(StipulaParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#party}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParty(StipulaParser.PartyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(StipulaParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#assetdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetdec(StipulaParser.AssetdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarasm(StipulaParser.VarasmContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(StipulaParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#ifelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(StipulaParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#events}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvents(StipulaParser.EventsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#prec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrec(StipulaParser.PrecContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(StipulaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(StipulaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(StipulaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(StipulaParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(StipulaParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by {@link StipulaParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(StipulaParser.NumberContext ctx);
}