// Generated from E:/michiel/Documents/GitHub/PP-Final-Project/src/main/java/pp/finalproject\Grammar.g4 by ANTLR 4.5
package pp.finalproject;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sharedDeclStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharedDeclStat(@NotNull GrammarParser.SharedDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStat(@NotNull GrammarParser.DeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(@NotNull GrammarParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull GrammarParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull GrammarParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code procedureStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureStat(@NotNull GrammarParser.ProcedureStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(@NotNull GrammarParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(@NotNull GrammarParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noParamProcedure}
	 * labeled alternative in {@link GrammarParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoParamProcedure(@NotNull GrammarParser.NoParamProcedureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramProcedure}
	 * labeled alternative in {@link GrammarParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamProcedure(@NotNull GrammarParser.ParamProcedureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull GrammarParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timesDivideExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull GrammarParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(@NotNull GrammarParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(@NotNull GrammarParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(@NotNull GrammarParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(@NotNull GrammarParser.CmpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull GrammarParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull GrammarParser.TypeContext ctx);
}