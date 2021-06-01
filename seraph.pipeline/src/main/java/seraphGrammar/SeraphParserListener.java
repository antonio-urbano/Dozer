// Generated from SeraphParser.g4 by ANTLR 4.9.2
package seraphGrammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SeraphParser}.
 */
public interface SeraphParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_Seraph}.
	 * @param ctx the parse tree
	 */
	void enterOS_Seraph(SeraphParser.OS_SeraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_Seraph}.
	 * @param ctx the parse tree
	 */
	void exitOS_Seraph(SeraphParser.OS_SeraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_RegisterQuery}.
	 * @param ctx the parse tree
	 */
	void enterOS_RegisterQuery(SeraphParser.OS_RegisterQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_RegisterQuery}.
	 * @param ctx the parse tree
	 */
	void exitOS_RegisterQuery(SeraphParser.OS_RegisterQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_QueryName}.
	 * @param ctx the parse tree
	 */
	void enterOS_QueryName(SeraphParser.OS_QueryNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_QueryName}.
	 * @param ctx the parse tree
	 */
	void exitOS_QueryName(SeraphParser.OS_QueryNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_QueryCypher}.
	 * @param ctx the parse tree
	 */
	void enterOS_QueryCypher(SeraphParser.OS_QueryCypherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_QueryCypher}.
	 * @param ctx the parse tree
	 */
	void exitOS_QueryCypher(SeraphParser.OS_QueryCypherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_QueryInput}.
	 * @param ctx the parse tree
	 */
	void enterOS_QueryInput(SeraphParser.OS_QueryInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_QueryInput}.
	 * @param ctx the parse tree
	 */
	void exitOS_QueryInput(SeraphParser.OS_QueryInputContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_InputStream}.
	 * @param ctx the parse tree
	 */
	void enterOS_InputStream(SeraphParser.OS_InputStreamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_InputStream}.
	 * @param ctx the parse tree
	 */
	void exitOS_InputStream(SeraphParser.OS_InputStreamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_TimeInstant}.
	 * @param ctx the parse tree
	 */
	void enterOS_TimeInstant(SeraphParser.OS_TimeInstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_TimeInstant}.
	 * @param ctx the parse tree
	 */
	void exitOS_TimeInstant(SeraphParser.OS_TimeInstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_ISO_8601_Datetime}.
	 * @param ctx the parse tree
	 */
	void enterOS_ISO_8601_Datetime(SeraphParser.OS_ISO_8601_DatetimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_ISO_8601_Datetime}.
	 * @param ctx the parse tree
	 */
	void exitOS_ISO_8601_Datetime(SeraphParser.OS_ISO_8601_DatetimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_WindowRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_WindowRange(SeraphParser.OS_WindowRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_WindowRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_WindowRange(SeraphParser.OS_WindowRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_WindowEventRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_WindowEventRange(SeraphParser.OS_WindowEventRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_WindowEventRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_WindowEventRange(SeraphParser.OS_WindowEventRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_WindowTimeRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_WindowTimeRange(SeraphParser.OS_WindowTimeRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_WindowTimeRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_WindowTimeRange(SeraphParser.OS_WindowTimeRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_QueryOutput}.
	 * @param ctx the parse tree
	 */
	void enterOS_QueryOutput(SeraphParser.OS_QueryOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_QueryOutput}.
	 * @param ctx the parse tree
	 */
	void exitOS_QueryOutput(SeraphParser.OS_QueryOutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_Emit}.
	 * @param ctx the parse tree
	 */
	void enterOS_Emit(SeraphParser.OS_EmitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_Emit}.
	 * @param ctx the parse tree
	 */
	void exitOS_Emit(SeraphParser.OS_EmitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_OutputStream}.
	 * @param ctx the parse tree
	 */
	void enterOS_OutputStream(SeraphParser.OS_OutputStreamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_OutputStream}.
	 * @param ctx the parse tree
	 */
	void exitOS_OutputStream(SeraphParser.OS_OutputStreamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_EmitRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_EmitRange(SeraphParser.OS_EmitRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_EmitRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_EmitRange(SeraphParser.OS_EmitRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_EmitEventRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_EmitEventRange(SeraphParser.OS_EmitEventRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_EmitEventRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_EmitEventRange(SeraphParser.OS_EmitEventRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeraphParser#oS_EmitTimeRange}.
	 * @param ctx the parse tree
	 */
	void enterOS_EmitTimeRange(SeraphParser.OS_EmitTimeRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeraphParser#oS_EmitTimeRange}.
	 * @param ctx the parse tree
	 */
	void exitOS_EmitTimeRange(SeraphParser.OS_EmitTimeRangeContext ctx);
}