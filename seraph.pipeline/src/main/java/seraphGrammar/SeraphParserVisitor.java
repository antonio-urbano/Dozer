package seraphGrammar;

// Generated from SeraphParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SeraphParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SeraphParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_Seraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_Seraph(SeraphParser.OS_SeraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_RegisterQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_RegisterQuery(SeraphParser.OS_RegisterQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_QueryName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_QueryName(SeraphParser.OS_QueryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_QueryCypher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_QueryCypher(SeraphParser.OS_QueryCypherContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_QueryInput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_QueryInput(SeraphParser.OS_QueryInputContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_InputStream}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_InputStream(SeraphParser.OS_InputStreamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_TimeInstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_TimeInstant(SeraphParser.OS_TimeInstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_ISO_8601_Datetime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_ISO_8601_Datetime(SeraphParser.OS_ISO_8601_DatetimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_WindowRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_WindowRange(SeraphParser.OS_WindowRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_WindowEventRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_WindowEventRange(SeraphParser.OS_WindowEventRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_WindowTimeRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_WindowTimeRange(SeraphParser.OS_WindowTimeRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_QueryOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_QueryOutput(SeraphParser.OS_QueryOutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_Emit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_Emit(SeraphParser.OS_EmitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_OutputStream}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_OutputStream(SeraphParser.OS_OutputStreamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_EmitRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_EmitRange(SeraphParser.OS_EmitRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_EmitEventRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_EmitEventRange(SeraphParser.OS_EmitEventRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeraphParser#oS_EmitTimeRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOS_EmitTimeRange(SeraphParser.OS_EmitTimeRangeContext ctx);
}