// Generated from org/openseraph/antrl4/Seraph.g4 by ANTLR 4.7.1
package org.openseraph.antrl4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SeraphParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		REGISTER=46, UNREGISTER=47, QUERY=48, FROM=49, INTO=50, STREAM=51, WINDOW=52, 
		EMIT=53, GRAPH=54, RANGE=55, EVERY=56, CONSTRUCT=57, STARTING=58, ENTERING=59, 
		SNAPSHOT=60, EXIT=61, IRIREF=62, ISO8601_Duration=63, ISO8601_UTC_Datetime=64, 
		EVENTS=65, EARLIEST=66, LATEST=67, UNION=68, ALL=69, OPTIONAL=70, MATCH=71, 
		UNWIND=72, AS=73, MERGE=74, ON=75, CREATE=76, SET=77, DETACH=78, DELETE=79, 
		REMOVE=80, CALL=81, YIELD=82, WITH=83, RETURN=84, DISTINCT=85, ORDER=86, 
		BY=87, L_SKIP=88, LIMIT=89, ASCENDING=90, ASC=91, DESCENDING=92, DESC=93, 
		WHERE=94, OR=95, XOR=96, AND=97, NOT=98, IN=99, STARTS=100, ENDS=101, 
		CONTAINS=102, IS=103, NULL=104, COUNT=105, ANY=106, NONE=107, SINGLE=108, 
		TRUE=109, FALSE=110, EXISTS=111, CASE=112, ELSE=113, END=114, WHEN=115, 
		THEN=116, StringLiteral=117, EscapedChar=118, HexInteger=119, DecimalInteger=120, 
		OctalInteger=121, HexLetter=122, HexDigit=123, Digit=124, NonZeroDigit=125, 
		NonZeroOctDigit=126, OctDigit=127, ZeroDigit=128, ExponentDecimalReal=129, 
		RegularDecimalReal=130, CONSTRAINT=131, DO=132, FOR=133, REQUIRE=134, 
		UNIQUE=135, MANDATORY=136, SCALAR=137, OF=138, ADD=139, DROP=140, FILTER=141, 
		EXTRACT=142, UnescapedSymbolicName=143, IdentifierStart=144, IdentifierPart=145, 
		EscapedSymbolicName=146, SP=147, WHITESPACE=148, Comment=149;
	public static final int
		RULE_oS_Seraph = 0, RULE_oS_RegisterQuery = 1, RULE_oS_UnregisterQuery = 2, 
		RULE_oS_QueryID = 3, RULE_oS_S2R = 4, RULE_oS_S2R_InputStream = 5, RULE_oS_S2R_Range = 6, 
		RULE_oS_S2R_EventRange = 7, RULE_oS_S2R_TimeRange = 8, RULE_oS_R2S = 9, 
		RULE_oS_R2S_OutputStream = 10, RULE_oS_Stream = 11, RULE_oS_R2S_Range = 12, 
		RULE_oS_R2S_EventRange = 13, RULE_oS_R2S_TimeRange = 14, RULE_oS_R2S_Report = 15, 
		RULE_oS_R2S_ReportOnEntering = 16, RULE_oS_R2S_ReportOnExit = 17, RULE_oS_R2S_ReportSnapshot = 18, 
		RULE_oS_TimeRange = 19, RULE_oS_EventRange = 20, RULE_oS_S2R_Start = 21, 
		RULE_oS_S2R_StartLatest = 22, RULE_oS_S2R_StartEarliest = 23, RULE_oS_S2R_StartTimeInstant = 24, 
		RULE_oC_Cypher = 25, RULE_oS_R2R = 26, RULE_oC_Statement = 27, RULE_oC_Query = 28, 
		RULE_oC_RegularQuery = 29, RULE_oC_Union = 30, RULE_oC_SingleQuery = 31, 
		RULE_oC_SinglePartQuery = 32, RULE_oC_MultiPartQuery = 33, RULE_oC_UpdatingClause = 34, 
		RULE_oC_ReadingClause = 35, RULE_oC_Match = 36, RULE_oC_Unwind = 37, RULE_oC_Merge = 38, 
		RULE_oC_MergeAction = 39, RULE_oC_Create = 40, RULE_oC_Set = 41, RULE_oC_SetItem = 42, 
		RULE_oC_Delete = 43, RULE_oC_Remove = 44, RULE_oC_RemoveItem = 45, RULE_oC_InQueryCall = 46, 
		RULE_oC_StandaloneCall = 47, RULE_oC_YieldItems = 48, RULE_oC_YieldItem = 49, 
		RULE_oC_With = 50, RULE_oC_Return = 51, RULE_oC_ProjectionBody = 52, RULE_oC_ProjectionItems = 53, 
		RULE_oC_ProjectionItem = 54, RULE_oC_Order = 55, RULE_oC_Skip = 56, RULE_oC_Limit = 57, 
		RULE_oC_SortItem = 58, RULE_oC_Where = 59, RULE_oC_Pattern = 60, RULE_oC_PatternPart = 61, 
		RULE_oC_AnonymousPatternPart = 62, RULE_oC_PatternElement = 63, RULE_oC_NodePattern = 64, 
		RULE_oC_PatternElementChain = 65, RULE_oC_RelationshipPattern = 66, RULE_oC_RelationshipDetail = 67, 
		RULE_oC_Properties = 68, RULE_oC_RelationshipTypes = 69, RULE_oC_NodeLabels = 70, 
		RULE_oC_NodeLabel = 71, RULE_oC_RangeLiteral = 72, RULE_oC_LabelName = 73, 
		RULE_oC_RelTypeName = 74, RULE_oC_Expression = 75, RULE_oC_OrExpression = 76, 
		RULE_oC_XorExpression = 77, RULE_oC_AndExpression = 78, RULE_oC_NotExpression = 79, 
		RULE_oC_ComparisonExpression = 80, RULE_oC_AddOrSubtractExpression = 81, 
		RULE_oC_MultiplyDivideModuloExpression = 82, RULE_oC_PowerOfExpression = 83, 
		RULE_oC_UnaryAddOrSubtractExpression = 84, RULE_oC_StringListNullOperatorExpression = 85, 
		RULE_oC_ListOperatorExpression = 86, RULE_oC_StringOperatorExpression = 87, 
		RULE_oC_NullOperatorExpression = 88, RULE_oC_PropertyOrLabelsExpression = 89, 
		RULE_oC_Atom = 90, RULE_oC_Literal = 91, RULE_oC_BooleanLiteral = 92, 
		RULE_oC_ListLiteral = 93, RULE_oC_PartialComparisonExpression = 94, RULE_oC_ParenthesizedExpression = 95, 
		RULE_oC_RelationshipsPattern = 96, RULE_oC_FilterExpression = 97, RULE_oC_IdInColl = 98, 
		RULE_oC_FunctionInvocation = 99, RULE_oC_FunctionName = 100, RULE_oC_ExplicitProcedureInvocation = 101, 
		RULE_oC_ImplicitProcedureInvocation = 102, RULE_oC_ProcedureResultField = 103, 
		RULE_oC_ProcedureName = 104, RULE_oC_Namespace = 105, RULE_oC_ListComprehension = 106, 
		RULE_oC_PatternComprehension = 107, RULE_oC_PropertyLookup = 108, RULE_oC_CaseExpression = 109, 
		RULE_oC_CaseAlternatives = 110, RULE_oC_Variable = 111, RULE_oC_NumberLiteral = 112, 
		RULE_oC_MapLiteral = 113, RULE_oC_Parameter = 114, RULE_oC_PropertyExpression = 115, 
		RULE_oC_PropertyKeyName = 116, RULE_oC_IntegerLiteral = 117, RULE_oC_DoubleLiteral = 118, 
		RULE_oC_SchemaName = 119, RULE_oC_ReservedWord = 120, RULE_oC_SymbolicName = 121, 
		RULE_oC_LeftArrowHead = 122, RULE_oC_RightArrowHead = 123, RULE_oC_Dash = 124;
	public static final String[] ruleNames = {
		"oS_Seraph", "oS_RegisterQuery", "oS_UnregisterQuery", "oS_QueryID", "oS_S2R", 
		"oS_S2R_InputStream", "oS_S2R_Range", "oS_S2R_EventRange", "oS_S2R_TimeRange", 
		"oS_R2S", "oS_R2S_OutputStream", "oS_Stream", "oS_R2S_Range", "oS_R2S_EventRange", 
		"oS_R2S_TimeRange", "oS_R2S_Report", "oS_R2S_ReportOnEntering", "oS_R2S_ReportOnExit", 
		"oS_R2S_ReportSnapshot", "oS_TimeRange", "oS_EventRange", "oS_S2R_Start", 
		"oS_S2R_StartLatest", "oS_S2R_StartEarliest", "oS_S2R_StartTimeInstant", 
		"oC_Cypher", "oS_R2R", "oC_Statement", "oC_Query", "oC_RegularQuery", 
		"oC_Union", "oC_SingleQuery", "oC_SinglePartQuery", "oC_MultiPartQuery", 
		"oC_UpdatingClause", "oC_ReadingClause", "oC_Match", "oC_Unwind", "oC_Merge", 
		"oC_MergeAction", "oC_Create", "oC_Set", "oC_SetItem", "oC_Delete", "oC_Remove", 
		"oC_RemoveItem", "oC_InQueryCall", "oC_StandaloneCall", "oC_YieldItems", 
		"oC_YieldItem", "oC_With", "oC_Return", "oC_ProjectionBody", "oC_ProjectionItems", 
		"oC_ProjectionItem", "oC_Order", "oC_Skip", "oC_Limit", "oC_SortItem", 
		"oC_Where", "oC_Pattern", "oC_PatternPart", "oC_AnonymousPatternPart", 
		"oC_PatternElement", "oC_NodePattern", "oC_PatternElementChain", "oC_RelationshipPattern", 
		"oC_RelationshipDetail", "oC_Properties", "oC_RelationshipTypes", "oC_NodeLabels", 
		"oC_NodeLabel", "oC_RangeLiteral", "oC_LabelName", "oC_RelTypeName", "oC_Expression", 
		"oC_OrExpression", "oC_XorExpression", "oC_AndExpression", "oC_NotExpression", 
		"oC_ComparisonExpression", "oC_AddOrSubtractExpression", "oC_MultiplyDivideModuloExpression", 
		"oC_PowerOfExpression", "oC_UnaryAddOrSubtractExpression", "oC_StringListNullOperatorExpression", 
		"oC_ListOperatorExpression", "oC_StringOperatorExpression", "oC_NullOperatorExpression", 
		"oC_PropertyOrLabelsExpression", "oC_Atom", "oC_Literal", "oC_BooleanLiteral", 
		"oC_ListLiteral", "oC_PartialComparisonExpression", "oC_ParenthesizedExpression", 
		"oC_RelationshipsPattern", "oC_FilterExpression", "oC_IdInColl", "oC_FunctionInvocation", 
		"oC_FunctionName", "oC_ExplicitProcedureInvocation", "oC_ImplicitProcedureInvocation", 
		"oC_ProcedureResultField", "oC_ProcedureName", "oC_Namespace", "oC_ListComprehension", 
		"oC_PatternComprehension", "oC_PropertyLookup", "oC_CaseExpression", "oC_CaseAlternatives", 
		"oC_Variable", "oC_NumberLiteral", "oC_MapLiteral", "oC_Parameter", "oC_PropertyExpression", 
		"oC_PropertyKeyName", "oC_IntegerLiteral", "oC_DoubleLiteral", "oC_SchemaName", 
		"oC_ReservedWord", "oC_SymbolicName", "oC_LeftArrowHead", "oC_RightArrowHead", 
		"oC_Dash"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "';'", "','", "'='", "'+='", "'*'", "':'", "'('", 
		"')'", "'['", "']'", "'|'", "'..'", "'+'", "'-'", "'/'", "'%'", "'^'", 
		"'<>'", "'<'", "'>'", "'<='", "'>='", "'.'", "'$'", "'\u27E8'", "'\u3008'", 
		"'\uFE64'", "'\uFF1C'", "'\u27E9'", "'\u3009'", "'\uFE65'", "'\uFF1E'", 
		"'\u00AD'", "'\u2010'", "'\u2011'", "'\u2012'", "'\u2013'", "'\u2014'", 
		"'\u2015'", "'\u2212'", "'\uFE58'", "'\uFE63'", "'\uFF0D'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "REGISTER", 
		"UNREGISTER", "QUERY", "FROM", "INTO", "STREAM", "WINDOW", "EMIT", "GRAPH", 
		"RANGE", "EVERY", "CONSTRUCT", "STARTING", "ENTERING", "SNAPSHOT", "EXIT", 
		"IRIREF", "ISO8601_Duration", "ISO8601_UTC_Datetime", "EVENTS", "EARLIEST", 
		"LATEST", "UNION", "ALL", "OPTIONAL", "MATCH", "UNWIND", "AS", "MERGE", 
		"ON", "CREATE", "SET", "DETACH", "DELETE", "REMOVE", "CALL", "YIELD", 
		"WITH", "RETURN", "DISTINCT", "ORDER", "BY", "L_SKIP", "LIMIT", "ASCENDING", 
		"ASC", "DESCENDING", "DESC", "WHERE", "OR", "XOR", "AND", "NOT", "IN", 
		"STARTS", "ENDS", "CONTAINS", "IS", "NULL", "COUNT", "ANY", "NONE", "SINGLE", 
		"TRUE", "FALSE", "EXISTS", "CASE", "ELSE", "END", "WHEN", "THEN", "StringLiteral", 
		"EscapedChar", "HexInteger", "DecimalInteger", "OctalInteger", "HexLetter", 
		"HexDigit", "Digit", "NonZeroDigit", "NonZeroOctDigit", "OctDigit", "ZeroDigit", 
		"ExponentDecimalReal", "RegularDecimalReal", "CONSTRAINT", "DO", "FOR", 
		"REQUIRE", "UNIQUE", "MANDATORY", "SCALAR", "OF", "ADD", "DROP", "FILTER", 
		"EXTRACT", "UnescapedSymbolicName", "IdentifierStart", "IdentifierPart", 
		"EscapedSymbolicName", "SP", "WHITESPACE", "Comment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Seraph.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SeraphParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class OS_SeraphContext extends ParserRuleContext {
		public OS_RegisterQueryContext oS_RegisterQuery() {
			return getRuleContext(OS_RegisterQueryContext.class,0);
		}
		public OS_UnregisterQueryContext oS_UnregisterQuery() {
			return getRuleContext(OS_UnregisterQueryContext.class,0);
		}
		public OS_SeraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_Seraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_Seraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_Seraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_Seraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_SeraphContext oS_Seraph() throws RecognitionException {
		OS_SeraphContext _localctx = new OS_SeraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_oS_Seraph);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				oS_RegisterQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				oS_UnregisterQuery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_RegisterQueryContext extends ParserRuleContext {
		public TerminalNode REGISTER() { return getToken(SeraphParser.REGISTER, 0); }
		public TerminalNode QUERY() { return getToken(SeraphParser.QUERY, 0); }
		public OS_QueryIDContext oS_QueryID() {
			return getRuleContext(OS_QueryIDContext.class,0);
		}
		public OS_S2RContext oS_S2R() {
			return getRuleContext(OS_S2RContext.class,0);
		}
		public OS_R2RContext oS_R2R() {
			return getRuleContext(OS_R2RContext.class,0);
		}
		public OS_R2SContext oS_R2S() {
			return getRuleContext(OS_R2SContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OS_RegisterQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_RegisterQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_RegisterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_RegisterQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_RegisterQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_RegisterQueryContext oS_RegisterQuery() throws RecognitionException {
		OS_RegisterQueryContext _localctx = new OS_RegisterQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oS_RegisterQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(254);
				match(SP);
				}
			}

			setState(257);
			match(REGISTER);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(258);
				match(SP);
				}
			}

			setState(261);
			match(QUERY);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(262);
				match(SP);
				}
			}

			setState(265);
			oS_QueryID();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(266);
				match(SP);
				}
			}

			setState(269);
			match(T__0);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(270);
				match(SP);
				}
			}

			setState(273);
			oS_S2R();
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(274);
				match(SP);
				}
				break;
			}
			setState(277);
			oS_R2R();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(278);
				match(SP);
				}
			}

			setState(281);
			oS_R2S();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(282);
				match(SP);
				}
			}

			setState(285);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_UnregisterQueryContext extends ParserRuleContext {
		public TerminalNode UNREGISTER() { return getToken(SeraphParser.UNREGISTER, 0); }
		public TerminalNode QUERY() { return getToken(SeraphParser.QUERY, 0); }
		public OS_QueryIDContext oS_QueryID() {
			return getRuleContext(OS_QueryIDContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OS_UnregisterQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_UnregisterQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_UnregisterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_UnregisterQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_UnregisterQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_UnregisterQueryContext oS_UnregisterQuery() throws RecognitionException {
		OS_UnregisterQueryContext _localctx = new OS_UnregisterQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oS_UnregisterQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(287);
				match(SP);
				}
			}

			setState(290);
			match(UNREGISTER);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(291);
				match(SP);
				}
			}

			setState(294);
			match(QUERY);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(295);
				match(SP);
				}
			}

			setState(298);
			oS_QueryID();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_QueryIDContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(SeraphParser.IRIREF, 0); }
		public OS_QueryIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_QueryID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_QueryID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_QueryID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_QueryID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_QueryIDContext oS_QueryID() throws RecognitionException {
		OS_QueryIDContext _localctx = new OS_QueryIDContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_oS_QueryID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2RContext extends ParserRuleContext {
		public List<TerminalNode> FROM() { return getTokens(SeraphParser.FROM); }
		public TerminalNode FROM(int i) {
			return getToken(SeraphParser.FROM, i);
		}
		public TerminalNode STREAM() { return getToken(SeraphParser.STREAM, 0); }
		public OS_S2R_InputStreamContext oS_S2R_InputStream() {
			return getRuleContext(OS_S2R_InputStreamContext.class,0);
		}
		public TerminalNode STARTING() { return getToken(SeraphParser.STARTING, 0); }
		public OS_S2R_StartContext oS_S2R_Start() {
			return getRuleContext(OS_S2R_StartContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SeraphParser.WITH, 0); }
		public TerminalNode WINDOW() { return getToken(SeraphParser.WINDOW, 0); }
		public TerminalNode RANGE() { return getToken(SeraphParser.RANGE, 0); }
		public OS_S2R_RangeContext oS_S2R_Range() {
			return getRuleContext(OS_S2R_RangeContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OS_S2RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2RContext oS_S2R() throws RecognitionException {
		OS_S2RContext _localctx = new OS_S2RContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_oS_S2R);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(FROM);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(303);
				match(SP);
				}
			}

			setState(306);
			match(STREAM);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(307);
				match(SP);
				}
			}

			setState(310);
			oS_S2R_InputStream();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(311);
				match(SP);
				}
			}

			setState(314);
			match(STARTING);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(315);
				match(SP);
				}
			}

			setState(318);
			match(FROM);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(319);
				match(SP);
				}
			}

			setState(322);
			oS_S2R_Start();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(323);
				match(SP);
				}
			}

			setState(326);
			match(WITH);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(327);
				match(SP);
				}
			}

			setState(330);
			match(WINDOW);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(331);
				match(SP);
				}
			}

			setState(334);
			match(RANGE);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(335);
				match(SP);
				}
			}

			setState(338);
			oS_S2R_Range();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_InputStreamContext extends ParserRuleContext {
		public OS_StreamContext oS_Stream() {
			return getRuleContext(OS_StreamContext.class,0);
		}
		public OS_S2R_InputStreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_InputStream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_InputStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_InputStream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_InputStream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_InputStreamContext oS_S2R_InputStream() throws RecognitionException {
		OS_S2R_InputStreamContext _localctx = new OS_S2R_InputStreamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_oS_S2R_InputStream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			oS_Stream();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_RangeContext extends ParserRuleContext {
		public OS_S2R_EventRangeContext oS_S2R_EventRange() {
			return getRuleContext(OS_S2R_EventRangeContext.class,0);
		}
		public OS_S2R_TimeRangeContext oS_S2R_TimeRange() {
			return getRuleContext(OS_S2R_TimeRangeContext.class,0);
		}
		public OS_S2R_RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_Range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_Range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_Range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_Range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_RangeContext oS_S2R_Range() throws RecognitionException {
		OS_S2R_RangeContext _localctx = new OS_S2R_RangeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_oS_S2R_Range);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				oS_S2R_EventRange();
				}
				break;
			case ISO8601_Duration:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				oS_S2R_TimeRange();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_EventRangeContext extends ParserRuleContext {
		public OS_EventRangeContext oS_EventRange() {
			return getRuleContext(OS_EventRangeContext.class,0);
		}
		public OS_S2R_EventRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_EventRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_EventRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_EventRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_EventRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_EventRangeContext oS_S2R_EventRange() throws RecognitionException {
		OS_S2R_EventRangeContext _localctx = new OS_S2R_EventRangeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oS_S2R_EventRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			oS_EventRange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_TimeRangeContext extends ParserRuleContext {
		public OS_TimeRangeContext oS_TimeRange() {
			return getRuleContext(OS_TimeRangeContext.class,0);
		}
		public OS_S2R_TimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_TimeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_TimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_TimeRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_TimeRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_TimeRangeContext oS_S2R_TimeRange() throws RecognitionException {
		OS_S2R_TimeRangeContext _localctx = new OS_S2R_TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_oS_S2R_TimeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			oS_TimeRange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2SContext extends ParserRuleContext {
		public TerminalNode EMIT() { return getToken(SeraphParser.EMIT, 0); }
		public OS_R2S_ReportContext oS_R2S_Report() {
			return getRuleContext(OS_R2S_ReportContext.class,0);
		}
		public TerminalNode EVERY() { return getToken(SeraphParser.EVERY, 0); }
		public OS_R2S_RangeContext oS_R2S_Range() {
			return getRuleContext(OS_R2S_RangeContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SeraphParser.INTO, 0); }
		public OS_R2S_OutputStreamContext oS_R2S_OutputStream() {
			return getRuleContext(OS_R2S_OutputStreamContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OS_R2SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2SContext oS_R2S() throws RecognitionException {
		OS_R2SContext _localctx = new OS_R2SContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_oS_R2S);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(EMIT);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(351);
				match(SP);
				}
			}

			setState(354);
			oS_R2S_Report();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(355);
				match(SP);
				}
			}

			setState(358);
			match(EVERY);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(359);
				match(SP);
				}
			}

			setState(362);
			oS_R2S_Range();
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(363);
				match(SP);
				}
			}

			setState(366);
			match(INTO);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(367);
				match(SP);
				}
			}

			setState(370);
			oS_R2S_OutputStream();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_OutputStreamContext extends ParserRuleContext {
		public OS_StreamContext oS_Stream() {
			return getRuleContext(OS_StreamContext.class,0);
		}
		public OS_R2S_OutputStreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_OutputStream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_OutputStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_OutputStream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_OutputStream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_OutputStreamContext oS_R2S_OutputStream() throws RecognitionException {
		OS_R2S_OutputStreamContext _localctx = new OS_R2S_OutputStreamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_oS_R2S_OutputStream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			oS_Stream();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_StreamContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(SeraphParser.IRIREF, 0); }
		public OS_StreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_Stream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_Stream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_Stream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_Stream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_StreamContext oS_Stream() throws RecognitionException {
		OS_StreamContext _localctx = new OS_StreamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_oS_Stream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_RangeContext extends ParserRuleContext {
		public OS_R2S_EventRangeContext oS_R2S_EventRange() {
			return getRuleContext(OS_R2S_EventRangeContext.class,0);
		}
		public OS_R2S_TimeRangeContext oS_R2S_TimeRange() {
			return getRuleContext(OS_R2S_TimeRangeContext.class,0);
		}
		public OS_R2S_RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_Range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_Range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_Range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_Range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_RangeContext oS_R2S_Range() throws RecognitionException {
		OS_R2S_RangeContext _localctx = new OS_R2S_RangeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_oS_R2S_Range);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				oS_R2S_EventRange();
				}
				break;
			case ISO8601_Duration:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				oS_R2S_TimeRange();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_EventRangeContext extends ParserRuleContext {
		public OS_EventRangeContext oS_EventRange() {
			return getRuleContext(OS_EventRangeContext.class,0);
		}
		public OS_R2S_EventRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_EventRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_EventRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_EventRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_EventRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_EventRangeContext oS_R2S_EventRange() throws RecognitionException {
		OS_R2S_EventRangeContext _localctx = new OS_R2S_EventRangeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_oS_R2S_EventRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			oS_EventRange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_TimeRangeContext extends ParserRuleContext {
		public OS_TimeRangeContext oS_TimeRange() {
			return getRuleContext(OS_TimeRangeContext.class,0);
		}
		public OS_R2S_TimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_TimeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_TimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_TimeRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_TimeRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_TimeRangeContext oS_R2S_TimeRange() throws RecognitionException {
		OS_R2S_TimeRangeContext _localctx = new OS_R2S_TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_oS_R2S_TimeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			oS_TimeRange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_ReportContext extends ParserRuleContext {
		public OS_R2S_ReportOnEnteringContext oS_R2S_ReportOnEntering() {
			return getRuleContext(OS_R2S_ReportOnEnteringContext.class,0);
		}
		public OS_R2S_ReportOnExitContext oS_R2S_ReportOnExit() {
			return getRuleContext(OS_R2S_ReportOnExitContext.class,0);
		}
		public OS_R2S_ReportSnapshotContext oS_R2S_ReportSnapshot() {
			return getRuleContext(OS_R2S_ReportSnapshotContext.class,0);
		}
		public OS_R2S_ReportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_Report; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_Report(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_Report(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_Report(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_ReportContext oS_R2S_Report() throws RecognitionException {
		OS_R2S_ReportContext _localctx = new OS_R2S_ReportContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_oS_R2S_Report);
		try {
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				oS_R2S_ReportOnEntering();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				oS_R2S_ReportOnExit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(386);
				oS_R2S_ReportSnapshot();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_ReportOnEnteringContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SeraphParser.ON, 0); }
		public TerminalNode ENTERING() { return getToken(SeraphParser.ENTERING, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OS_R2S_ReportOnEnteringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_ReportOnEntering; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_ReportOnEntering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_ReportOnEntering(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_ReportOnEntering(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_ReportOnEnteringContext oS_R2S_ReportOnEntering() throws RecognitionException {
		OS_R2S_ReportOnEnteringContext _localctx = new OS_R2S_ReportOnEnteringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_oS_R2S_ReportOnEntering);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(ON);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(390);
				match(SP);
				}
			}

			setState(393);
			match(ENTERING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_ReportOnExitContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SeraphParser.ON, 0); }
		public TerminalNode EXIT() { return getToken(SeraphParser.EXIT, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OS_R2S_ReportOnExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_ReportOnExit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_ReportOnExit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_ReportOnExit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_ReportOnExit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_ReportOnExitContext oS_R2S_ReportOnExit() throws RecognitionException {
		OS_R2S_ReportOnExitContext _localctx = new OS_R2S_ReportOnExitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_oS_R2S_ReportOnExit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(ON);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(396);
				match(SP);
				}
			}

			setState(399);
			match(EXIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2S_ReportSnapshotContext extends ParserRuleContext {
		public TerminalNode SNAPSHOT() { return getToken(SeraphParser.SNAPSHOT, 0); }
		public OS_R2S_ReportSnapshotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2S_ReportSnapshot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2S_ReportSnapshot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2S_ReportSnapshot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2S_ReportSnapshot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2S_ReportSnapshotContext oS_R2S_ReportSnapshot() throws RecognitionException {
		OS_R2S_ReportSnapshotContext _localctx = new OS_R2S_ReportSnapshotContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_oS_R2S_ReportSnapshot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(SNAPSHOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_TimeRangeContext extends ParserRuleContext {
		public TerminalNode ISO8601_Duration() { return getToken(SeraphParser.ISO8601_Duration, 0); }
		public OS_TimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_TimeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_TimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_TimeRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_TimeRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_TimeRangeContext oS_TimeRange() throws RecognitionException {
		OS_TimeRangeContext _localctx = new OS_TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_oS_TimeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(ISO8601_Duration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_EventRangeContext extends ParserRuleContext {
		public OC_IntegerLiteralContext oC_IntegerLiteral() {
			return getRuleContext(OC_IntegerLiteralContext.class,0);
		}
		public TerminalNode EVENTS() { return getToken(SeraphParser.EVENTS, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OS_EventRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_EventRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_EventRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_EventRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_EventRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_EventRangeContext oS_EventRange() throws RecognitionException {
		OS_EventRangeContext _localctx = new OS_EventRangeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_oS_EventRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			oC_IntegerLiteral();
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(406);
				match(SP);
				}
			}

			setState(409);
			match(EVENTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_StartContext extends ParserRuleContext {
		public OS_S2R_StartLatestContext oS_S2R_StartLatest() {
			return getRuleContext(OS_S2R_StartLatestContext.class,0);
		}
		public OS_S2R_StartEarliestContext oS_S2R_StartEarliest() {
			return getRuleContext(OS_S2R_StartEarliestContext.class,0);
		}
		public OS_S2R_StartTimeInstantContext oS_S2R_StartTimeInstant() {
			return getRuleContext(OS_S2R_StartTimeInstantContext.class,0);
		}
		public OS_S2R_StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_Start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_Start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_Start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_Start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_StartContext oS_S2R_Start() throws RecognitionException {
		OS_S2R_StartContext _localctx = new OS_S2R_StartContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_oS_S2R_Start);
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LATEST:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				oS_S2R_StartLatest();
				}
				break;
			case EARLIEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				oS_S2R_StartEarliest();
				}
				break;
			case ISO8601_UTC_Datetime:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				oS_S2R_StartTimeInstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_StartLatestContext extends ParserRuleContext {
		public TerminalNode LATEST() { return getToken(SeraphParser.LATEST, 0); }
		public OS_S2R_StartLatestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_StartLatest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_StartLatest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_StartLatest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_StartLatest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_StartLatestContext oS_S2R_StartLatest() throws RecognitionException {
		OS_S2R_StartLatestContext _localctx = new OS_S2R_StartLatestContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_oS_S2R_StartLatest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(LATEST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_StartEarliestContext extends ParserRuleContext {
		public TerminalNode EARLIEST() { return getToken(SeraphParser.EARLIEST, 0); }
		public OS_S2R_StartEarliestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_StartEarliest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_StartEarliest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_StartEarliest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_StartEarliest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_StartEarliestContext oS_S2R_StartEarliest() throws RecognitionException {
		OS_S2R_StartEarliestContext _localctx = new OS_S2R_StartEarliestContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_oS_S2R_StartEarliest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(EARLIEST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_S2R_StartTimeInstantContext extends ParserRuleContext {
		public TerminalNode ISO8601_UTC_Datetime() { return getToken(SeraphParser.ISO8601_UTC_Datetime, 0); }
		public OS_S2R_StartTimeInstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_S2R_StartTimeInstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_S2R_StartTimeInstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_S2R_StartTimeInstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_S2R_StartTimeInstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_S2R_StartTimeInstantContext oS_S2R_StartTimeInstant() throws RecognitionException {
		OS_S2R_StartTimeInstantContext _localctx = new OS_S2R_StartTimeInstantContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_oS_S2R_StartTimeInstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			match(ISO8601_UTC_Datetime);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CypherContext extends ParserRuleContext {
		public OC_StatementContext oC_Statement() {
			return getRuleContext(OC_StatementContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_CypherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Cypher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Cypher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Cypher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Cypher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_CypherContext oC_Cypher() throws RecognitionException {
		OC_CypherContext _localctx = new OC_CypherContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_oC_Cypher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(422);
				match(SP);
				}
			}

			setState(425);
			oC_Statement();
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(426);
					match(SP);
					}
				}

				setState(429);
				match(T__2);
				}
				break;
			}
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(432);
				match(SP);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OS_R2RContext extends ParserRuleContext {
		public OC_CypherContext oC_Cypher() {
			return getRuleContext(OC_CypherContext.class,0);
		}
		public OS_R2RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_R2R; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOS_R2R(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOS_R2R(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOS_R2R(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OS_R2RContext oS_R2R() throws RecognitionException {
		OS_R2RContext _localctx = new OS_R2RContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_oS_R2R);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			oC_Cypher();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StatementContext extends ParserRuleContext {
		public OC_QueryContext oC_Query() {
			return getRuleContext(OC_QueryContext.class,0);
		}
		public OC_StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_StatementContext oC_Statement() throws RecognitionException {
		OC_StatementContext _localctx = new OC_StatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_oC_Statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			oC_Query();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_QueryContext extends ParserRuleContext {
		public OC_RegularQueryContext oC_RegularQuery() {
			return getRuleContext(OC_RegularQueryContext.class,0);
		}
		public OC_StandaloneCallContext oC_StandaloneCall() {
			return getRuleContext(OC_StandaloneCallContext.class,0);
		}
		public OC_QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Query(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Query(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_QueryContext oC_Query() throws RecognitionException {
		OC_QueryContext _localctx = new OC_QueryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_oC_Query);
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				oC_RegularQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				oC_StandaloneCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RegularQueryContext extends ParserRuleContext {
		public OC_SingleQueryContext oC_SingleQuery() {
			return getRuleContext(OC_SingleQueryContext.class,0);
		}
		public List<OC_UnionContext> oC_Union() {
			return getRuleContexts(OC_UnionContext.class);
		}
		public OC_UnionContext oC_Union(int i) {
			return getRuleContext(OC_UnionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_RegularQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RegularQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RegularQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RegularQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RegularQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RegularQueryContext oC_RegularQuery() throws RecognitionException {
		OC_RegularQueryContext _localctx = new OC_RegularQueryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_oC_RegularQuery);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			oC_SingleQuery();
			setState(450);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(445);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(444);
						match(SP);
						}
					}

					setState(447);
					oC_Union();
					}
					} 
				}
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnionContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(SeraphParser.UNION, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode ALL() { return getToken(SeraphParser.ALL, 0); }
		public OC_SingleQueryContext oC_SingleQuery() {
			return getRuleContext(OC_SingleQueryContext.class,0);
		}
		public OC_UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Union(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Union(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_UnionContext oC_Union() throws RecognitionException {
		OC_UnionContext _localctx = new OC_UnionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_oC_Union);
		int _la;
		try {
			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(453);
				match(UNION);
				setState(454);
				match(SP);
				setState(455);
				match(ALL);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(456);
					match(SP);
					}
				}

				setState(459);
				oC_SingleQuery();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(460);
				match(UNION);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(461);
					match(SP);
					}
				}

				setState(464);
				oC_SingleQuery();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SingleQueryContext extends ParserRuleContext {
		public OC_SinglePartQueryContext oC_SinglePartQuery() {
			return getRuleContext(OC_SinglePartQueryContext.class,0);
		}
		public OC_MultiPartQueryContext oC_MultiPartQuery() {
			return getRuleContext(OC_MultiPartQueryContext.class,0);
		}
		public OC_SingleQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SingleQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SingleQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SingleQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SingleQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SingleQueryContext oC_SingleQuery() throws RecognitionException {
		OC_SingleQueryContext _localctx = new OC_SingleQueryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_oC_SingleQuery);
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				oC_SinglePartQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				oC_MultiPartQuery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SinglePartQueryContext extends ParserRuleContext {
		public OC_ReturnContext oC_Return() {
			return getRuleContext(OC_ReturnContext.class,0);
		}
		public List<OC_ReadingClauseContext> oC_ReadingClause() {
			return getRuleContexts(OC_ReadingClauseContext.class);
		}
		public OC_ReadingClauseContext oC_ReadingClause(int i) {
			return getRuleContext(OC_ReadingClauseContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_UpdatingClauseContext> oC_UpdatingClause() {
			return getRuleContexts(OC_UpdatingClauseContext.class);
		}
		public OC_UpdatingClauseContext oC_UpdatingClause(int i) {
			return getRuleContext(OC_UpdatingClauseContext.class,i);
		}
		public OC_SinglePartQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SinglePartQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SinglePartQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SinglePartQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SinglePartQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SinglePartQueryContext oC_SinglePartQuery() throws RecognitionException {
		OC_SinglePartQueryContext _localctx = new OC_SinglePartQueryContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_oC_SinglePartQuery);
		int _la;
		try {
			int _alt;
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (MATCH - 70)) | (1L << (UNWIND - 70)) | (1L << (CALL - 70)))) != 0)) {
					{
					{
					setState(471);
					oC_ReadingClause();
					setState(473);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(472);
						match(SP);
						}
					}

					}
					}
					setState(479);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(480);
				oC_Return();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (MATCH - 70)) | (1L << (UNWIND - 70)) | (1L << (CALL - 70)))) != 0)) {
					{
					{
					setState(481);
					oC_ReadingClause();
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(482);
						match(SP);
						}
					}

					}
					}
					setState(489);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(490);
				oC_UpdatingClause();
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(492);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(491);
							match(SP);
							}
						}

						setState(494);
						oC_UpdatingClause();
						}
						} 
					}
					setState(499);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				setState(504);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(500);
						match(SP);
						}
					}

					setState(503);
					oC_Return();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MultiPartQueryContext extends ParserRuleContext {
		public OC_SinglePartQueryContext oC_SinglePartQuery() {
			return getRuleContext(OC_SinglePartQueryContext.class,0);
		}
		public List<OC_WithContext> oC_With() {
			return getRuleContexts(OC_WithContext.class);
		}
		public OC_WithContext oC_With(int i) {
			return getRuleContext(OC_WithContext.class,i);
		}
		public List<OC_ReadingClauseContext> oC_ReadingClause() {
			return getRuleContexts(OC_ReadingClauseContext.class);
		}
		public OC_ReadingClauseContext oC_ReadingClause(int i) {
			return getRuleContext(OC_ReadingClauseContext.class,i);
		}
		public List<OC_UpdatingClauseContext> oC_UpdatingClause() {
			return getRuleContexts(OC_UpdatingClauseContext.class);
		}
		public OC_UpdatingClauseContext oC_UpdatingClause(int i) {
			return getRuleContext(OC_UpdatingClauseContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_MultiPartQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MultiPartQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_MultiPartQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_MultiPartQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_MultiPartQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MultiPartQueryContext oC_MultiPartQuery() throws RecognitionException {
		OC_MultiPartQueryContext _localctx = new OC_MultiPartQueryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_oC_MultiPartQuery);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(530); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(514);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (MATCH - 70)) | (1L << (UNWIND - 70)) | (1L << (CALL - 70)))) != 0)) {
						{
						{
						setState(508);
						oC_ReadingClause();
						setState(510);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(509);
							match(SP);
							}
						}

						}
						}
						setState(516);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(523);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (MERGE - 74)) | (1L << (CREATE - 74)) | (1L << (SET - 74)) | (1L << (DETACH - 74)) | (1L << (DELETE - 74)) | (1L << (REMOVE - 74)))) != 0)) {
						{
						{
						setState(517);
						oC_UpdatingClause();
						setState(519);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(518);
							match(SP);
							}
						}

						}
						}
						setState(525);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(526);
					oC_With();
					setState(528);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(527);
						match(SP);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(532); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(534);
			oC_SinglePartQuery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UpdatingClauseContext extends ParserRuleContext {
		public OC_CreateContext oC_Create() {
			return getRuleContext(OC_CreateContext.class,0);
		}
		public OC_MergeContext oC_Merge() {
			return getRuleContext(OC_MergeContext.class,0);
		}
		public OC_DeleteContext oC_Delete() {
			return getRuleContext(OC_DeleteContext.class,0);
		}
		public OC_SetContext oC_Set() {
			return getRuleContext(OC_SetContext.class,0);
		}
		public OC_RemoveContext oC_Remove() {
			return getRuleContext(OC_RemoveContext.class,0);
		}
		public OC_UpdatingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_UpdatingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_UpdatingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_UpdatingClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_UpdatingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_UpdatingClauseContext oC_UpdatingClause() throws RecognitionException {
		OC_UpdatingClauseContext _localctx = new OC_UpdatingClauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_oC_UpdatingClause);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				oC_Create();
				}
				break;
			case MERGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				oC_Merge();
				}
				break;
			case DETACH:
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				oC_Delete();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
				oC_Set();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(540);
				oC_Remove();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReadingClauseContext extends ParserRuleContext {
		public OC_MatchContext oC_Match() {
			return getRuleContext(OC_MatchContext.class,0);
		}
		public OC_UnwindContext oC_Unwind() {
			return getRuleContext(OC_UnwindContext.class,0);
		}
		public OC_InQueryCallContext oC_InQueryCall() {
			return getRuleContext(OC_InQueryCallContext.class,0);
		}
		public OC_ReadingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReadingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ReadingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ReadingClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ReadingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ReadingClauseContext oC_ReadingClause() throws RecognitionException {
		OC_ReadingClauseContext _localctx = new OC_ReadingClauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_oC_ReadingClause);
		try {
			setState(546);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONAL:
			case MATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				oC_Match();
				}
				break;
			case UNWIND:
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				oC_Unwind();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(545);
				oC_InQueryCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MatchContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(SeraphParser.MATCH, 0); }
		public OC_PatternContext oC_Pattern() {
			return getRuleContext(OC_PatternContext.class,0);
		}
		public TerminalNode OPTIONAL() { return getToken(SeraphParser.OPTIONAL, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public OC_MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Match; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Match(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Match(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Match(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MatchContext oC_Match() throws RecognitionException {
		OC_MatchContext _localctx = new OC_MatchContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_oC_Match);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTIONAL) {
				{
				setState(548);
				match(OPTIONAL);
				setState(549);
				match(SP);
				}
			}

			setState(552);
			match(MATCH);
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(553);
				match(SP);
				}
			}

			setState(556);
			oC_Pattern();
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(557);
					match(SP);
					}
				}

				setState(560);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnwindContext extends ParserRuleContext {
		public TerminalNode UNWIND() { return getToken(SeraphParser.UNWIND, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode AS() { return getToken(SeraphParser.AS, 0); }
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_UnwindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Unwind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Unwind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Unwind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Unwind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_UnwindContext oC_Unwind() throws RecognitionException {
		OC_UnwindContext _localctx = new OC_UnwindContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_oC_Unwind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(UNWIND);
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(564);
				match(SP);
				}
			}

			setState(567);
			oC_Expression();
			setState(568);
			match(SP);
			setState(569);
			match(AS);
			setState(570);
			match(SP);
			setState(571);
			oC_Variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MergeContext extends ParserRuleContext {
		public TerminalNode MERGE() { return getToken(SeraphParser.MERGE, 0); }
		public OC_PatternPartContext oC_PatternPart() {
			return getRuleContext(OC_PatternPartContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_MergeActionContext> oC_MergeAction() {
			return getRuleContexts(OC_MergeActionContext.class);
		}
		public OC_MergeActionContext oC_MergeAction(int i) {
			return getRuleContext(OC_MergeActionContext.class,i);
		}
		public OC_MergeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Merge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Merge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Merge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Merge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MergeContext oC_Merge() throws RecognitionException {
		OC_MergeContext _localctx = new OC_MergeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_oC_Merge);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(MERGE);
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(574);
				match(SP);
				}
			}

			setState(577);
			oC_PatternPart();
			setState(582);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(578);
					match(SP);
					setState(579);
					oC_MergeAction();
					}
					} 
				}
				setState(584);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MergeActionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SeraphParser.ON, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode MATCH() { return getToken(SeraphParser.MATCH, 0); }
		public OC_SetContext oC_Set() {
			return getRuleContext(OC_SetContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(SeraphParser.CREATE, 0); }
		public OC_MergeActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MergeAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_MergeAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_MergeAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_MergeAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MergeActionContext oC_MergeAction() throws RecognitionException {
		OC_MergeActionContext _localctx = new OC_MergeActionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_oC_MergeAction);
		try {
			setState(595);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(585);
				match(ON);
				setState(586);
				match(SP);
				setState(587);
				match(MATCH);
				setState(588);
				match(SP);
				setState(589);
				oC_Set();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(590);
				match(ON);
				setState(591);
				match(SP);
				setState(592);
				match(CREATE);
				setState(593);
				match(SP);
				setState(594);
				oC_Set();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CreateContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SeraphParser.CREATE, 0); }
		public OC_PatternContext oC_Pattern() {
			return getRuleContext(OC_PatternContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Create(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Create(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Create(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_CreateContext oC_Create() throws RecognitionException {
		OC_CreateContext _localctx = new OC_CreateContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_oC_Create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(CREATE);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(598);
				match(SP);
				}
			}

			setState(601);
			oC_Pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(SeraphParser.SET, 0); }
		public List<OC_SetItemContext> oC_SetItem() {
			return getRuleContexts(OC_SetItemContext.class);
		}
		public OC_SetItemContext oC_SetItem(int i) {
			return getRuleContext(OC_SetItemContext.class,i);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SetContext oC_Set() throws RecognitionException {
		OC_SetContext _localctx = new OC_SetContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_oC_Set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(SET);
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(604);
				match(SP);
				}
			}

			setState(607);
			oC_SetItem();
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(608);
				match(T__3);
				setState(609);
				oC_SetItem();
				}
				}
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SetItemContext extends ParserRuleContext {
		public OC_PropertyExpressionContext oC_PropertyExpression() {
			return getRuleContext(OC_PropertyExpressionContext.class,0);
		}
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_SetItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SetItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SetItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SetItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SetItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SetItemContext oC_SetItem() throws RecognitionException {
		OC_SetItemContext _localctx = new OC_SetItemContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_oC_SetItem);
		int _la;
		try {
			setState(651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(615);
				oC_PropertyExpression();
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(616);
					match(SP);
					}
				}

				setState(619);
				match(T__4);
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(620);
					match(SP);
					}
				}

				setState(623);
				oC_Expression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(625);
				oC_Variable();
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(626);
					match(SP);
					}
				}

				setState(629);
				match(T__4);
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(630);
					match(SP);
					}
				}

				setState(633);
				oC_Expression();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(635);
				oC_Variable();
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(636);
					match(SP);
					}
				}

				setState(639);
				match(T__5);
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(640);
					match(SP);
					}
				}

				setState(643);
				oC_Expression();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(645);
				oC_Variable();
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(646);
					match(SP);
					}
				}

				setState(649);
				oC_NodeLabels();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DeleteContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SeraphParser.DELETE, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public TerminalNode DETACH() { return getToken(SeraphParser.DETACH, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Delete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_DeleteContext oC_Delete() throws RecognitionException {
		OC_DeleteContext _localctx = new OC_DeleteContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_oC_Delete);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DETACH) {
				{
				setState(653);
				match(DETACH);
				setState(654);
				match(SP);
				}
			}

			setState(657);
			match(DELETE);
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(658);
				match(SP);
				}
			}

			setState(661);
			oC_Expression();
			setState(672);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(663);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(662);
						match(SP);
						}
					}

					setState(665);
					match(T__3);
					setState(667);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(666);
						match(SP);
						}
					}

					setState(669);
					oC_Expression();
					}
					} 
				}
				setState(674);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RemoveContext extends ParserRuleContext {
		public TerminalNode REMOVE() { return getToken(SeraphParser.REMOVE, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_RemoveItemContext> oC_RemoveItem() {
			return getRuleContexts(OC_RemoveItemContext.class);
		}
		public OC_RemoveItemContext oC_RemoveItem(int i) {
			return getRuleContext(OC_RemoveItemContext.class,i);
		}
		public OC_RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Remove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Remove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Remove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Remove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RemoveContext oC_Remove() throws RecognitionException {
		OC_RemoveContext _localctx = new OC_RemoveContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_oC_Remove);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(REMOVE);
			setState(676);
			match(SP);
			setState(677);
			oC_RemoveItem();
			setState(688);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(678);
						match(SP);
						}
					}

					setState(681);
					match(T__3);
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(682);
						match(SP);
						}
					}

					setState(685);
					oC_RemoveItem();
					}
					} 
				}
				setState(690);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RemoveItemContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_PropertyExpressionContext oC_PropertyExpression() {
			return getRuleContext(OC_PropertyExpressionContext.class,0);
		}
		public OC_RemoveItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RemoveItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RemoveItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RemoveItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RemoveItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RemoveItemContext oC_RemoveItem() throws RecognitionException {
		OC_RemoveItemContext _localctx = new OC_RemoveItemContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_oC_RemoveItem);
		try {
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(691);
				oC_Variable();
				setState(692);
				oC_NodeLabels();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				oC_PropertyExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_InQueryCallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(SeraphParser.CALL, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() {
			return getRuleContext(OC_ExplicitProcedureInvocationContext.class,0);
		}
		public TerminalNode YIELD() { return getToken(SeraphParser.YIELD, 0); }
		public OC_YieldItemsContext oC_YieldItems() {
			return getRuleContext(OC_YieldItemsContext.class,0);
		}
		public OC_InQueryCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_InQueryCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_InQueryCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_InQueryCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_InQueryCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_InQueryCallContext oC_InQueryCall() throws RecognitionException {
		OC_InQueryCallContext _localctx = new OC_InQueryCallContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_oC_InQueryCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(CALL);
			setState(698);
			match(SP);
			setState(699);
			oC_ExplicitProcedureInvocation();
			setState(706);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				{
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(700);
					match(SP);
					}
				}

				setState(703);
				match(YIELD);
				setState(704);
				match(SP);
				setState(705);
				oC_YieldItems();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StandaloneCallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(SeraphParser.CALL, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() {
			return getRuleContext(OC_ExplicitProcedureInvocationContext.class,0);
		}
		public OC_ImplicitProcedureInvocationContext oC_ImplicitProcedureInvocation() {
			return getRuleContext(OC_ImplicitProcedureInvocationContext.class,0);
		}
		public TerminalNode YIELD() { return getToken(SeraphParser.YIELD, 0); }
		public OC_YieldItemsContext oC_YieldItems() {
			return getRuleContext(OC_YieldItemsContext.class,0);
		}
		public OC_StandaloneCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StandaloneCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_StandaloneCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_StandaloneCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_StandaloneCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_StandaloneCallContext oC_StandaloneCall() throws RecognitionException {
		OC_StandaloneCallContext _localctx = new OC_StandaloneCallContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_oC_StandaloneCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(CALL);
			setState(709);
			match(SP);
			setState(712);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(710);
				oC_ExplicitProcedureInvocation();
				}
				break;
			case 2:
				{
				setState(711);
				oC_ImplicitProcedureInvocation();
				}
				break;
			}
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(714);
				match(SP);
				setState(715);
				match(YIELD);
				setState(716);
				match(SP);
				setState(717);
				oC_YieldItems();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_YieldItemsContext extends ParserRuleContext {
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public List<OC_YieldItemContext> oC_YieldItem() {
			return getRuleContexts(OC_YieldItemContext.class);
		}
		public OC_YieldItemContext oC_YieldItem(int i) {
			return getRuleContext(OC_YieldItemContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_YieldItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_YieldItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_YieldItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_YieldItems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_YieldItems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_YieldItemsContext oC_YieldItems() throws RecognitionException {
		OC_YieldItemsContext _localctx = new OC_YieldItemsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_oC_YieldItems);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(720);
				match(T__6);
				}
				break;
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				{
				{
				setState(721);
				oC_YieldItem();
				setState(732);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(723);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(722);
							match(SP);
							}
						}

						setState(725);
						match(T__3);
						setState(727);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(726);
							match(SP);
							}
						}

						setState(729);
						oC_YieldItem();
						}
						} 
					}
					setState(734);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(737);
					match(SP);
					}
				}

				setState(740);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_YieldItemContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_ProcedureResultFieldContext oC_ProcedureResultField() {
			return getRuleContext(OC_ProcedureResultFieldContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode AS() { return getToken(SeraphParser.AS, 0); }
		public OC_YieldItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_YieldItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_YieldItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_YieldItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_YieldItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_YieldItemContext oC_YieldItem() throws RecognitionException {
		OC_YieldItemContext _localctx = new OC_YieldItemContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_oC_YieldItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(743);
				oC_ProcedureResultField();
				setState(744);
				match(SP);
				setState(745);
				match(AS);
				setState(746);
				match(SP);
				}
				break;
			}
			setState(750);
			oC_Variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_WithContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SeraphParser.WITH, 0); }
		public OC_ProjectionBodyContext oC_ProjectionBody() {
			return getRuleContext(OC_ProjectionBodyContext.class,0);
		}
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_With; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_With(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_With(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_With(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_WithContext oC_With() throws RecognitionException {
		OC_WithContext _localctx = new OC_WithContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_oC_With);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			match(WITH);
			setState(753);
			oC_ProjectionBody();
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(755);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(754);
					match(SP);
					}
				}

				setState(757);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SeraphParser.RETURN, 0); }
		public OC_ProjectionBodyContext oC_ProjectionBody() {
			return getRuleContext(OC_ProjectionBodyContext.class,0);
		}
		public OC_ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ReturnContext oC_Return() throws RecognitionException {
		OC_ReturnContext _localctx = new OC_ReturnContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_oC_Return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(RETURN);
			setState(761);
			oC_ProjectionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProjectionBodyContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ProjectionItemsContext oC_ProjectionItems() {
			return getRuleContext(OC_ProjectionItemsContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(SeraphParser.DISTINCT, 0); }
		public OC_OrderContext oC_Order() {
			return getRuleContext(OC_OrderContext.class,0);
		}
		public OC_SkipContext oC_Skip() {
			return getRuleContext(OC_SkipContext.class,0);
		}
		public OC_LimitContext oC_Limit() {
			return getRuleContext(OC_LimitContext.class,0);
		}
		public OC_ProjectionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProjectionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ProjectionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ProjectionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ProjectionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ProjectionBodyContext oC_ProjectionBody() throws RecognitionException {
		OC_ProjectionBodyContext _localctx = new OC_ProjectionBodyContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_oC_ProjectionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(763);
					match(SP);
					}
				}

				setState(766);
				match(DISTINCT);
				}
				break;
			}
			setState(769);
			match(SP);
			setState(770);
			oC_ProjectionItems();
			setState(773);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(771);
				match(SP);
				setState(772);
				oC_Order();
				}
				break;
			}
			setState(777);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(775);
				match(SP);
				setState(776);
				oC_Skip();
				}
				break;
			}
			setState(781);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(779);
				match(SP);
				setState(780);
				oC_Limit();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProjectionItemsContext extends ParserRuleContext {
		public List<OC_ProjectionItemContext> oC_ProjectionItem() {
			return getRuleContexts(OC_ProjectionItemContext.class);
		}
		public OC_ProjectionItemContext oC_ProjectionItem(int i) {
			return getRuleContext(OC_ProjectionItemContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ProjectionItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProjectionItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ProjectionItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ProjectionItems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ProjectionItems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ProjectionItemsContext oC_ProjectionItems() throws RecognitionException {
		OC_ProjectionItemsContext _localctx = new OC_ProjectionItemsContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_oC_ProjectionItems);
		int _la;
		try {
			int _alt;
			setState(811);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(783);
				match(T__6);
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(785);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(784);
							match(SP);
							}
						}

						setState(787);
						match(T__3);
						setState(789);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(788);
							match(SP);
							}
						}

						setState(791);
						oC_ProjectionItem();
						}
						} 
					}
					setState(796);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				}
				}
				}
				break;
			case T__0:
			case T__8:
			case T__10:
			case T__14:
			case T__15:
			case T__25:
			case ALL:
			case NOT:
			case NULL:
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case TRUE:
			case FALSE:
			case EXISTS:
			case CASE:
			case StringLiteral:
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
			case HexLetter:
			case ExponentDecimalReal:
			case RegularDecimalReal:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(797);
				oC_ProjectionItem();
				setState(808);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(799);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(798);
							match(SP);
							}
						}

						setState(801);
						match(T__3);
						setState(803);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(802);
							match(SP);
							}
						}

						setState(805);
						oC_ProjectionItem();
						}
						} 
					}
					setState(810);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProjectionItemContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode AS() { return getToken(SeraphParser.AS, 0); }
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_ProjectionItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProjectionItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ProjectionItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ProjectionItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ProjectionItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ProjectionItemContext oC_ProjectionItem() throws RecognitionException {
		OC_ProjectionItemContext _localctx = new OC_ProjectionItemContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_oC_ProjectionItem);
		try {
			setState(820);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(813);
				oC_Expression();
				setState(814);
				match(SP);
				setState(815);
				match(AS);
				setState(816);
				match(SP);
				setState(817);
				oC_Variable();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(819);
				oC_Expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_OrderContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SeraphParser.ORDER, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode BY() { return getToken(SeraphParser.BY, 0); }
		public List<OC_SortItemContext> oC_SortItem() {
			return getRuleContexts(OC_SortItemContext.class);
		}
		public OC_SortItemContext oC_SortItem(int i) {
			return getRuleContext(OC_SortItemContext.class,i);
		}
		public OC_OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Order(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Order(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Order(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_OrderContext oC_Order() throws RecognitionException {
		OC_OrderContext _localctx = new OC_OrderContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_oC_Order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(ORDER);
			setState(823);
			match(SP);
			setState(824);
			match(BY);
			setState(825);
			match(SP);
			setState(826);
			oC_SortItem();
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(827);
				match(T__3);
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(828);
					match(SP);
					}
				}

				setState(831);
				oC_SortItem();
				}
				}
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SkipContext extends ParserRuleContext {
		public TerminalNode L_SKIP() { return getToken(SeraphParser.L_SKIP, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Skip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Skip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Skip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SkipContext oC_Skip() throws RecognitionException {
		OC_SkipContext _localctx = new OC_SkipContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_oC_Skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			match(L_SKIP);
			setState(838);
			match(SP);
			setState(839);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LimitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SeraphParser.LIMIT, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Limit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Limit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Limit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_LimitContext oC_Limit() throws RecognitionException {
		OC_LimitContext _localctx = new OC_LimitContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_oC_Limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(LIMIT);
			setState(842);
			match(SP);
			setState(843);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SortItemContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public TerminalNode ASCENDING() { return getToken(SeraphParser.ASCENDING, 0); }
		public TerminalNode ASC() { return getToken(SeraphParser.ASC, 0); }
		public TerminalNode DESCENDING() { return getToken(SeraphParser.DESCENDING, 0); }
		public TerminalNode DESC() { return getToken(SeraphParser.DESC, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SortItemContext oC_SortItem() throws RecognitionException {
		OC_SortItemContext _localctx = new OC_SortItemContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_oC_SortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			oC_Expression();
			setState(850);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(847);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(846);
					match(SP);
					}
				}

				setState(849);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (ASCENDING - 90)) | (1L << (ASC - 90)) | (1L << (DESCENDING - 90)) | (1L << (DESC - 90)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_WhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SeraphParser.WHERE, 0); }
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Where(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Where(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Where(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_WhereContext oC_Where() throws RecognitionException {
		OC_WhereContext _localctx = new OC_WhereContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_oC_Where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			match(WHERE);
			setState(853);
			match(SP);
			setState(854);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternContext extends ParserRuleContext {
		public List<OC_PatternPartContext> oC_PatternPart() {
			return getRuleContexts(OC_PatternPartContext.class);
		}
		public OC_PatternPartContext oC_PatternPart(int i) {
			return getRuleContext(OC_PatternPartContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PatternContext oC_Pattern() throws RecognitionException {
		OC_PatternContext _localctx = new OC_PatternContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_oC_Pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			oC_PatternPart();
			setState(867);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(858);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(857);
						match(SP);
						}
					}

					setState(860);
					match(T__3);
					setState(862);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(861);
						match(SP);
						}
					}

					setState(864);
					oC_PatternPart();
					}
					} 
				}
				setState(869);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternPartContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_AnonymousPatternPartContext oC_AnonymousPatternPart() {
			return getRuleContext(OC_AnonymousPatternPartContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PatternPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PatternPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PatternPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PatternPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PatternPartContext oC_PatternPart() throws RecognitionException {
		OC_PatternPartContext _localctx = new OC_PatternPartContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_oC_PatternPart);
		int _la;
		try {
			setState(881);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(870);
				oC_Variable();
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(871);
					match(SP);
					}
				}

				setState(874);
				match(T__7);
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(875);
					match(SP);
					}
				}

				setState(878);
				oC_AnonymousPatternPart();
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(880);
				oC_AnonymousPatternPart();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AnonymousPatternPartContext extends ParserRuleContext {
		public OC_PatternElementContext oC_PatternElement() {
			return getRuleContext(OC_PatternElementContext.class,0);
		}
		public OC_AnonymousPatternPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AnonymousPatternPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_AnonymousPatternPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_AnonymousPatternPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_AnonymousPatternPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_AnonymousPatternPartContext oC_AnonymousPatternPart() throws RecognitionException {
		OC_AnonymousPatternPartContext _localctx = new OC_AnonymousPatternPartContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_oC_AnonymousPatternPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			oC_PatternElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternElementContext extends ParserRuleContext {
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public List<OC_PatternElementChainContext> oC_PatternElementChain() {
			return getRuleContexts(OC_PatternElementChainContext.class);
		}
		public OC_PatternElementChainContext oC_PatternElementChain(int i) {
			return getRuleContext(OC_PatternElementChainContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PatternElementContext oC_PatternElement() {
			return getRuleContext(OC_PatternElementContext.class,0);
		}
		public OC_PatternElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PatternElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PatternElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PatternElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PatternElementContext oC_PatternElement() throws RecognitionException {
		OC_PatternElementContext _localctx = new OC_PatternElementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_oC_PatternElement);
		int _la;
		try {
			int _alt;
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(885);
				oC_NodePattern();
				setState(892);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(887);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(886);
							match(SP);
							}
						}

						setState(889);
						oC_PatternElementChain();
						}
						} 
					}
					setState(894);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(895);
				match(T__8);
				setState(896);
				oC_PatternElement();
				setState(897);
				match(T__9);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodePatternContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_PropertiesContext oC_Properties() {
			return getRuleContext(OC_PropertiesContext.class,0);
		}
		public OC_NodePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NodePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NodePattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NodePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NodePatternContext oC_NodePattern() throws RecognitionException {
		OC_NodePatternContext _localctx = new OC_NodePatternContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_oC_NodePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			match(T__8);
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(902);
				match(SP);
				}
			}

			setState(909);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (COUNT - 105)) | (1L << (ANY - 105)) | (1L << (NONE - 105)) | (1L << (SINGLE - 105)) | (1L << (HexLetter - 105)) | (1L << (FILTER - 105)) | (1L << (EXTRACT - 105)) | (1L << (UnescapedSymbolicName - 105)) | (1L << (EscapedSymbolicName - 105)))) != 0)) {
				{
				setState(905);
				oC_Variable();
				setState(907);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(906);
					match(SP);
					}
				}

				}
			}

			setState(915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(911);
				oC_NodeLabels();
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(912);
					match(SP);
					}
				}

				}
			}

			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__25) {
				{
				setState(917);
				oC_Properties();
				setState(919);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(918);
					match(SP);
					}
				}

				}
			}

			setState(923);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternElementChainContext extends ParserRuleContext {
		public OC_RelationshipPatternContext oC_RelationshipPattern() {
			return getRuleContext(OC_RelationshipPatternContext.class,0);
		}
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_PatternElementChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternElementChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PatternElementChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PatternElementChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PatternElementChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PatternElementChainContext oC_PatternElementChain() throws RecognitionException {
		OC_PatternElementChainContext _localctx = new OC_PatternElementChainContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_oC_PatternElementChain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			oC_RelationshipPattern();
			setState(927);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(926);
				match(SP);
				}
			}

			setState(929);
			oC_NodePattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipPatternContext extends ParserRuleContext {
		public OC_LeftArrowHeadContext oC_LeftArrowHead() {
			return getRuleContext(OC_LeftArrowHeadContext.class,0);
		}
		public List<OC_DashContext> oC_Dash() {
			return getRuleContexts(OC_DashContext.class);
		}
		public OC_DashContext oC_Dash(int i) {
			return getRuleContext(OC_DashContext.class,i);
		}
		public OC_RightArrowHeadContext oC_RightArrowHead() {
			return getRuleContext(OC_RightArrowHeadContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_RelationshipDetailContext oC_RelationshipDetail() {
			return getRuleContext(OC_RelationshipDetailContext.class,0);
		}
		public OC_RelationshipPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RelationshipPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RelationshipPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RelationshipPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RelationshipPatternContext oC_RelationshipPattern() throws RecognitionException {
		OC_RelationshipPatternContext _localctx = new OC_RelationshipPatternContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_oC_RelationshipPattern);
		int _la;
		try {
			setState(995);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(931);
				oC_LeftArrowHead();
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(932);
					match(SP);
					}
				}

				setState(935);
				oC_Dash();
				setState(937);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
				case 1:
					{
					setState(936);
					match(SP);
					}
					break;
				}
				setState(940);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(939);
					oC_RelationshipDetail();
					}
				}

				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(942);
					match(SP);
					}
				}

				setState(945);
				oC_Dash();
				setState(947);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(946);
					match(SP);
					}
				}

				setState(949);
				oC_RightArrowHead();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(951);
				oC_LeftArrowHead();
				setState(953);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(952);
					match(SP);
					}
				}

				setState(955);
				oC_Dash();
				setState(957);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(956);
					match(SP);
					}
					break;
				}
				setState(960);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(959);
					oC_RelationshipDetail();
					}
				}

				setState(963);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(962);
					match(SP);
					}
				}

				setState(965);
				oC_Dash();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(967);
				oC_Dash();
				setState(969);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(968);
					match(SP);
					}
					break;
				}
				setState(972);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(971);
					oC_RelationshipDetail();
					}
				}

				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(974);
					match(SP);
					}
				}

				setState(977);
				oC_Dash();
				setState(979);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(978);
					match(SP);
					}
				}

				setState(981);
				oC_RightArrowHead();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(983);
				oC_Dash();
				setState(985);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
				case 1:
					{
					setState(984);
					match(SP);
					}
					break;
				}
				setState(988);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(987);
					oC_RelationshipDetail();
					}
				}

				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(990);
					match(SP);
					}
				}

				setState(993);
				oC_Dash();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipDetailContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_RelationshipTypesContext oC_RelationshipTypes() {
			return getRuleContext(OC_RelationshipTypesContext.class,0);
		}
		public OC_RangeLiteralContext oC_RangeLiteral() {
			return getRuleContext(OC_RangeLiteralContext.class,0);
		}
		public OC_PropertiesContext oC_Properties() {
			return getRuleContext(OC_PropertiesContext.class,0);
		}
		public OC_RelationshipDetailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RelationshipDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RelationshipDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RelationshipDetail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RelationshipDetailContext oC_RelationshipDetail() throws RecognitionException {
		OC_RelationshipDetailContext _localctx = new OC_RelationshipDetailContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_oC_RelationshipDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			match(T__10);
			setState(999);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(998);
				match(SP);
				}
			}

			setState(1005);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (COUNT - 105)) | (1L << (ANY - 105)) | (1L << (NONE - 105)) | (1L << (SINGLE - 105)) | (1L << (HexLetter - 105)) | (1L << (FILTER - 105)) | (1L << (EXTRACT - 105)) | (1L << (UnescapedSymbolicName - 105)) | (1L << (EscapedSymbolicName - 105)))) != 0)) {
				{
				setState(1001);
				oC_Variable();
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1002);
					match(SP);
					}
				}

				}
			}

			setState(1011);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(1007);
				oC_RelationshipTypes();
				setState(1009);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1008);
					match(SP);
					}
				}

				}
			}

			setState(1014);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(1013);
				oC_RangeLiteral();
				}
			}

			setState(1020);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__25) {
				{
				setState(1016);
				oC_Properties();
				setState(1018);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1017);
					match(SP);
					}
				}

				}
			}

			setState(1022);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertiesContext extends ParserRuleContext {
		public OC_MapLiteralContext oC_MapLiteral() {
			return getRuleContext(OC_MapLiteralContext.class,0);
		}
		public OC_ParameterContext oC_Parameter() {
			return getRuleContext(OC_ParameterContext.class,0);
		}
		public OC_PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Properties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PropertiesContext oC_Properties() throws RecognitionException {
		OC_PropertiesContext _localctx = new OC_PropertiesContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_oC_Properties);
		try {
			setState(1026);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(1024);
				oC_MapLiteral();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(1025);
				oC_Parameter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipTypesContext extends ParserRuleContext {
		public List<OC_RelTypeNameContext> oC_RelTypeName() {
			return getRuleContexts(OC_RelTypeNameContext.class);
		}
		public OC_RelTypeNameContext oC_RelTypeName(int i) {
			return getRuleContext(OC_RelTypeNameContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_RelationshipTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RelationshipTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RelationshipTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RelationshipTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RelationshipTypesContext oC_RelationshipTypes() throws RecognitionException {
		OC_RelationshipTypesContext _localctx = new OC_RelationshipTypesContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_oC_RelationshipTypes);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			match(T__7);
			setState(1030);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1029);
				match(SP);
				}
			}

			setState(1032);
			oC_RelTypeName();
			setState(1046);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1034);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1033);
						match(SP);
						}
					}

					setState(1036);
					match(T__12);
					setState(1038);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(1037);
						match(T__7);
						}
					}

					setState(1041);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1040);
						match(SP);
						}
					}

					setState(1043);
					oC_RelTypeName();
					}
					} 
				}
				setState(1048);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodeLabelsContext extends ParserRuleContext {
		public List<OC_NodeLabelContext> oC_NodeLabel() {
			return getRuleContexts(OC_NodeLabelContext.class);
		}
		public OC_NodeLabelContext oC_NodeLabel(int i) {
			return getRuleContext(OC_NodeLabelContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_NodeLabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodeLabels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NodeLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NodeLabels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NodeLabels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NodeLabelsContext oC_NodeLabels() throws RecognitionException {
		OC_NodeLabelsContext _localctx = new OC_NodeLabelsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_oC_NodeLabels);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
			oC_NodeLabel();
			setState(1056);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1051);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1050);
						match(SP);
						}
					}

					setState(1053);
					oC_NodeLabel();
					}
					} 
				}
				setState(1058);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodeLabelContext extends ParserRuleContext {
		public OC_LabelNameContext oC_LabelName() {
			return getRuleContext(OC_LabelNameContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_NodeLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodeLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NodeLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NodeLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NodeLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NodeLabelContext oC_NodeLabel() throws RecognitionException {
		OC_NodeLabelContext _localctx = new OC_NodeLabelContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_oC_NodeLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			match(T__7);
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1060);
				match(SP);
				}
			}

			setState(1063);
			oC_LabelName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RangeLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_IntegerLiteralContext> oC_IntegerLiteral() {
			return getRuleContexts(OC_IntegerLiteralContext.class);
		}
		public OC_IntegerLiteralContext oC_IntegerLiteral(int i) {
			return getRuleContext(OC_IntegerLiteralContext.class,i);
		}
		public OC_RangeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RangeLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RangeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RangeLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RangeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RangeLiteralContext oC_RangeLiteral() throws RecognitionException {
		OC_RangeLiteralContext _localctx = new OC_RangeLiteralContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_oC_RangeLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			match(T__6);
			setState(1067);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1066);
				match(SP);
				}
			}

			setState(1073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (HexInteger - 119)) | (1L << (DecimalInteger - 119)) | (1L << (OctalInteger - 119)))) != 0)) {
				{
				setState(1069);
				oC_IntegerLiteral();
				setState(1071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1070);
					match(SP);
					}
				}

				}
			}

			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(1075);
				match(T__13);
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1076);
					match(SP);
					}
				}

				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (HexInteger - 119)) | (1L << (DecimalInteger - 119)) | (1L << (OctalInteger - 119)))) != 0)) {
					{
					setState(1079);
					oC_IntegerLiteral();
					setState(1081);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1080);
						match(SP);
						}
					}

					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LabelNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_LabelNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_LabelName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_LabelName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_LabelName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_LabelName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_LabelNameContext oC_LabelName() throws RecognitionException {
		OC_LabelNameContext _localctx = new OC_LabelNameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_oC_LabelName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1087);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelTypeNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_RelTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RelTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RelTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RelTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RelTypeNameContext oC_RelTypeName() throws RecognitionException {
		OC_RelTypeNameContext _localctx = new OC_RelTypeNameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_oC_RelTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ExpressionContext extends ParserRuleContext {
		public OC_OrExpressionContext oC_OrExpression() {
			return getRuleContext(OC_OrExpressionContext.class,0);
		}
		public OC_ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ExpressionContext oC_Expression() throws RecognitionException {
		OC_ExpressionContext _localctx = new OC_ExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_oC_Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			oC_OrExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_OrExpressionContext extends ParserRuleContext {
		public List<OC_XorExpressionContext> oC_XorExpression() {
			return getRuleContexts(OC_XorExpressionContext.class);
		}
		public OC_XorExpressionContext oC_XorExpression(int i) {
			return getRuleContext(OC_XorExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<TerminalNode> OR() { return getTokens(SeraphParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SeraphParser.OR, i);
		}
		public OC_OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_OrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_OrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_OrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_OrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_OrExpressionContext oC_OrExpression() throws RecognitionException {
		OC_OrExpressionContext _localctx = new OC_OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_oC_OrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1093);
			oC_XorExpression();
			setState(1100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1094);
					match(SP);
					setState(1095);
					match(OR);
					setState(1096);
					match(SP);
					setState(1097);
					oC_XorExpression();
					}
					} 
				}
				setState(1102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_XorExpressionContext extends ParserRuleContext {
		public List<OC_AndExpressionContext> oC_AndExpression() {
			return getRuleContexts(OC_AndExpressionContext.class);
		}
		public OC_AndExpressionContext oC_AndExpression(int i) {
			return getRuleContext(OC_AndExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<TerminalNode> XOR() { return getTokens(SeraphParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(SeraphParser.XOR, i);
		}
		public OC_XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_XorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_XorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_XorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_XorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_XorExpressionContext oC_XorExpression() throws RecognitionException {
		OC_XorExpressionContext _localctx = new OC_XorExpressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_oC_XorExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1103);
			oC_AndExpression();
			setState(1110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1104);
					match(SP);
					setState(1105);
					match(XOR);
					setState(1106);
					match(SP);
					setState(1107);
					oC_AndExpression();
					}
					} 
				}
				setState(1112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AndExpressionContext extends ParserRuleContext {
		public List<OC_NotExpressionContext> oC_NotExpression() {
			return getRuleContexts(OC_NotExpressionContext.class);
		}
		public OC_NotExpressionContext oC_NotExpression(int i) {
			return getRuleContext(OC_NotExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<TerminalNode> AND() { return getTokens(SeraphParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SeraphParser.AND, i);
		}
		public OC_AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_AndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_AndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_AndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_AndExpressionContext oC_AndExpression() throws RecognitionException {
		OC_AndExpressionContext _localctx = new OC_AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_oC_AndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1113);
			oC_NotExpression();
			setState(1120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1114);
					match(SP);
					setState(1115);
					match(AND);
					setState(1116);
					match(SP);
					setState(1117);
					oC_NotExpression();
					}
					} 
				}
				setState(1122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NotExpressionContext extends ParserRuleContext {
		public OC_ComparisonExpressionContext oC_ComparisonExpression() {
			return getRuleContext(OC_ComparisonExpressionContext.class,0);
		}
		public List<TerminalNode> NOT() { return getTokens(SeraphParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(SeraphParser.NOT, i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NotExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NotExpressionContext oC_NotExpression() throws RecognitionException {
		OC_NotExpressionContext _localctx = new OC_NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_oC_NotExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOT) {
				{
				{
				setState(1123);
				match(NOT);
				setState(1125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1124);
					match(SP);
					}
				}

				}
				}
				setState(1131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1132);
			oC_ComparisonExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ComparisonExpressionContext extends ParserRuleContext {
		public OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() {
			return getRuleContext(OC_AddOrSubtractExpressionContext.class,0);
		}
		public List<OC_PartialComparisonExpressionContext> oC_PartialComparisonExpression() {
			return getRuleContexts(OC_PartialComparisonExpressionContext.class);
		}
		public OC_PartialComparisonExpressionContext oC_PartialComparisonExpression(int i) {
			return getRuleContext(OC_PartialComparisonExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ComparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ComparisonExpressionContext oC_ComparisonExpression() throws RecognitionException {
		OC_ComparisonExpressionContext _localctx = new OC_ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_oC_ComparisonExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1134);
			oC_AddOrSubtractExpression();
			setState(1141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1135);
						match(SP);
						}
					}

					setState(1138);
					oC_PartialComparisonExpression();
					}
					} 
				}
				setState(1143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AddOrSubtractExpressionContext extends ParserRuleContext {
		public List<OC_MultiplyDivideModuloExpressionContext> oC_MultiplyDivideModuloExpression() {
			return getRuleContexts(OC_MultiplyDivideModuloExpressionContext.class);
		}
		public OC_MultiplyDivideModuloExpressionContext oC_MultiplyDivideModuloExpression(int i) {
			return getRuleContext(OC_MultiplyDivideModuloExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_AddOrSubtractExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AddOrSubtractExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_AddOrSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_AddOrSubtractExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_AddOrSubtractExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() throws RecognitionException {
		OC_AddOrSubtractExpressionContext _localctx = new OC_AddOrSubtractExpressionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_oC_AddOrSubtractExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			oC_MultiplyDivideModuloExpression();
			setState(1163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
					case 1:
						{
						{
						setState(1146);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1145);
							match(SP);
							}
						}

						setState(1148);
						match(T__14);
						setState(1150);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1149);
							match(SP);
							}
						}

						setState(1152);
						oC_MultiplyDivideModuloExpression();
						}
						}
						break;
					case 2:
						{
						{
						setState(1154);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1153);
							match(SP);
							}
						}

						setState(1156);
						match(T__15);
						setState(1158);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1157);
							match(SP);
							}
						}

						setState(1160);
						oC_MultiplyDivideModuloExpression();
						}
						}
						break;
					}
					} 
				}
				setState(1165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MultiplyDivideModuloExpressionContext extends ParserRuleContext {
		public List<OC_PowerOfExpressionContext> oC_PowerOfExpression() {
			return getRuleContexts(OC_PowerOfExpressionContext.class);
		}
		public OC_PowerOfExpressionContext oC_PowerOfExpression(int i) {
			return getRuleContext(OC_PowerOfExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_MultiplyDivideModuloExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MultiplyDivideModuloExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_MultiplyDivideModuloExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_MultiplyDivideModuloExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_MultiplyDivideModuloExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MultiplyDivideModuloExpressionContext oC_MultiplyDivideModuloExpression() throws RecognitionException {
		OC_MultiplyDivideModuloExpressionContext _localctx = new OC_MultiplyDivideModuloExpressionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_oC_MultiplyDivideModuloExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			oC_PowerOfExpression();
			setState(1193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
					case 1:
						{
						{
						setState(1168);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1167);
							match(SP);
							}
						}

						setState(1170);
						match(T__6);
						setState(1172);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1171);
							match(SP);
							}
						}

						setState(1174);
						oC_PowerOfExpression();
						}
						}
						break;
					case 2:
						{
						{
						setState(1176);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1175);
							match(SP);
							}
						}

						setState(1178);
						match(T__16);
						setState(1180);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1179);
							match(SP);
							}
						}

						setState(1182);
						oC_PowerOfExpression();
						}
						}
						break;
					case 3:
						{
						{
						setState(1184);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1183);
							match(SP);
							}
						}

						setState(1186);
						match(T__17);
						setState(1188);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1187);
							match(SP);
							}
						}

						setState(1190);
						oC_PowerOfExpression();
						}
						}
						break;
					}
					} 
				}
				setState(1195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PowerOfExpressionContext extends ParserRuleContext {
		public List<OC_UnaryAddOrSubtractExpressionContext> oC_UnaryAddOrSubtractExpression() {
			return getRuleContexts(OC_UnaryAddOrSubtractExpressionContext.class);
		}
		public OC_UnaryAddOrSubtractExpressionContext oC_UnaryAddOrSubtractExpression(int i) {
			return getRuleContext(OC_UnaryAddOrSubtractExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PowerOfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PowerOfExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PowerOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PowerOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PowerOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PowerOfExpressionContext oC_PowerOfExpression() throws RecognitionException {
		OC_PowerOfExpressionContext _localctx = new OC_PowerOfExpressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_oC_PowerOfExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			oC_UnaryAddOrSubtractExpression();
			setState(1207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1198);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1197);
						match(SP);
						}
					}

					setState(1200);
					match(T__18);
					setState(1202);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1201);
						match(SP);
						}
					}

					setState(1204);
					oC_UnaryAddOrSubtractExpression();
					}
					} 
				}
				setState(1209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnaryAddOrSubtractExpressionContext extends ParserRuleContext {
		public OC_StringListNullOperatorExpressionContext oC_StringListNullOperatorExpression() {
			return getRuleContext(OC_StringListNullOperatorExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_UnaryAddOrSubtractExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_UnaryAddOrSubtractExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_UnaryAddOrSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_UnaryAddOrSubtractExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_UnaryAddOrSubtractExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_UnaryAddOrSubtractExpressionContext oC_UnaryAddOrSubtractExpression() throws RecognitionException {
		OC_UnaryAddOrSubtractExpressionContext _localctx = new OC_UnaryAddOrSubtractExpressionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_oC_UnaryAddOrSubtractExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__15) {
				{
				{
				setState(1210);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1211);
					match(SP);
					}
				}

				}
				}
				setState(1218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1219);
			oC_StringListNullOperatorExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StringListNullOperatorExpressionContext extends ParserRuleContext {
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<OC_StringOperatorExpressionContext> oC_StringOperatorExpression() {
			return getRuleContexts(OC_StringOperatorExpressionContext.class);
		}
		public OC_StringOperatorExpressionContext oC_StringOperatorExpression(int i) {
			return getRuleContext(OC_StringOperatorExpressionContext.class,i);
		}
		public List<OC_ListOperatorExpressionContext> oC_ListOperatorExpression() {
			return getRuleContexts(OC_ListOperatorExpressionContext.class);
		}
		public OC_ListOperatorExpressionContext oC_ListOperatorExpression(int i) {
			return getRuleContext(OC_ListOperatorExpressionContext.class,i);
		}
		public List<OC_NullOperatorExpressionContext> oC_NullOperatorExpression() {
			return getRuleContexts(OC_NullOperatorExpressionContext.class);
		}
		public OC_NullOperatorExpressionContext oC_NullOperatorExpression(int i) {
			return getRuleContext(OC_NullOperatorExpressionContext.class,i);
		}
		public OC_StringListNullOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StringListNullOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_StringListNullOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_StringListNullOperatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_StringListNullOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_StringListNullOperatorExpressionContext oC_StringListNullOperatorExpression() throws RecognitionException {
		OC_StringListNullOperatorExpressionContext _localctx = new OC_StringListNullOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_oC_StringListNullOperatorExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1221);
			oC_PropertyOrLabelsExpression();
			setState(1227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1225);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
					case 1:
						{
						setState(1222);
						oC_StringOperatorExpression();
						}
						break;
					case 2:
						{
						setState(1223);
						oC_ListOperatorExpression();
						}
						break;
					case 3:
						{
						setState(1224);
						oC_NullOperatorExpression();
						}
						break;
					}
					} 
				}
				setState(1229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListOperatorExpressionContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode IN() { return getToken(SeraphParser.IN, 0); }
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ListOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ListOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ListOperatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ListOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ListOperatorExpressionContext oC_ListOperatorExpression() throws RecognitionException {
		OC_ListOperatorExpressionContext _localctx = new OC_ListOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_oC_ListOperatorExpression);
		int _la;
		try {
			setState(1255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1230);
				match(SP);
				setState(1231);
				match(IN);
				setState(1233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1232);
					match(SP);
					}
				}

				setState(1235);
				oC_PropertyOrLabelsExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1236);
					match(SP);
					}
				}

				setState(1239);
				match(T__10);
				setState(1240);
				oC_Expression();
				setState(1241);
				match(T__11);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1243);
					match(SP);
					}
				}

				setState(1246);
				match(T__10);
				setState(1248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__25))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ALL - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (COUNT - 69)) | (1L << (ANY - 69)) | (1L << (NONE - 69)) | (1L << (SINGLE - 69)) | (1L << (TRUE - 69)) | (1L << (FALSE - 69)) | (1L << (EXISTS - 69)) | (1L << (CASE - 69)) | (1L << (StringLiteral - 69)) | (1L << (HexInteger - 69)) | (1L << (DecimalInteger - 69)) | (1L << (OctalInteger - 69)) | (1L << (HexLetter - 69)) | (1L << (ExponentDecimalReal - 69)) | (1L << (RegularDecimalReal - 69)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FILTER - 141)) | (1L << (EXTRACT - 141)) | (1L << (UnescapedSymbolicName - 141)) | (1L << (EscapedSymbolicName - 141)))) != 0)) {
					{
					setState(1247);
					oC_Expression();
					}
				}

				setState(1250);
				match(T__13);
				setState(1252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__25))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ALL - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (COUNT - 69)) | (1L << (ANY - 69)) | (1L << (NONE - 69)) | (1L << (SINGLE - 69)) | (1L << (TRUE - 69)) | (1L << (FALSE - 69)) | (1L << (EXISTS - 69)) | (1L << (CASE - 69)) | (1L << (StringLiteral - 69)) | (1L << (HexInteger - 69)) | (1L << (DecimalInteger - 69)) | (1L << (OctalInteger - 69)) | (1L << (HexLetter - 69)) | (1L << (ExponentDecimalReal - 69)) | (1L << (RegularDecimalReal - 69)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FILTER - 141)) | (1L << (EXTRACT - 141)) | (1L << (UnescapedSymbolicName - 141)) | (1L << (EscapedSymbolicName - 141)))) != 0)) {
					{
					setState(1251);
					oC_Expression();
					}
				}

				setState(1254);
				match(T__11);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StringOperatorExpressionContext extends ParserRuleContext {
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode STARTS() { return getToken(SeraphParser.STARTS, 0); }
		public TerminalNode WITH() { return getToken(SeraphParser.WITH, 0); }
		public TerminalNode ENDS() { return getToken(SeraphParser.ENDS, 0); }
		public TerminalNode CONTAINS() { return getToken(SeraphParser.CONTAINS, 0); }
		public OC_StringOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StringOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_StringOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_StringOperatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_StringOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_StringOperatorExpressionContext oC_StringOperatorExpression() throws RecognitionException {
		OC_StringOperatorExpressionContext _localctx = new OC_StringOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_oC_StringOperatorExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				{
				{
				setState(1257);
				match(SP);
				setState(1258);
				match(STARTS);
				setState(1259);
				match(SP);
				setState(1260);
				match(WITH);
				}
				}
				break;
			case 2:
				{
				{
				setState(1261);
				match(SP);
				setState(1262);
				match(ENDS);
				setState(1263);
				match(SP);
				setState(1264);
				match(WITH);
				}
				}
				break;
			case 3:
				{
				{
				setState(1265);
				match(SP);
				setState(1266);
				match(CONTAINS);
				}
				}
				break;
			}
			setState(1270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1269);
				match(SP);
				}
			}

			setState(1272);
			oC_PropertyOrLabelsExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NullOperatorExpressionContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode IS() { return getToken(SeraphParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SeraphParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SeraphParser.NOT, 0); }
		public OC_NullOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NullOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NullOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NullOperatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NullOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NullOperatorExpressionContext oC_NullOperatorExpression() throws RecognitionException {
		OC_NullOperatorExpressionContext _localctx = new OC_NullOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_oC_NullOperatorExpression);
		try {
			setState(1284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1274);
				match(SP);
				setState(1275);
				match(IS);
				setState(1276);
				match(SP);
				setState(1277);
				match(NULL);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1278);
				match(SP);
				setState(1279);
				match(IS);
				setState(1280);
				match(SP);
				setState(1281);
				match(NOT);
				setState(1282);
				match(SP);
				setState(1283);
				match(NULL);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyOrLabelsExpressionContext extends ParserRuleContext {
		public OC_AtomContext oC_Atom() {
			return getRuleContext(OC_AtomContext.class,0);
		}
		public List<OC_PropertyLookupContext> oC_PropertyLookup() {
			return getRuleContexts(OC_PropertyLookupContext.class);
		}
		public OC_PropertyLookupContext oC_PropertyLookup(int i) {
			return getRuleContext(OC_PropertyLookupContext.class,i);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PropertyOrLabelsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyOrLabelsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PropertyOrLabelsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PropertyOrLabelsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PropertyOrLabelsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() throws RecognitionException {
		OC_PropertyOrLabelsExpressionContext _localctx = new OC_PropertyOrLabelsExpressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_oC_PropertyOrLabelsExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1286);
			oC_Atom();
			setState(1293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1288);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1287);
						match(SP);
						}
					}

					setState(1290);
					oC_PropertyLookup();
					}
					} 
				}
				setState(1295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			}
			setState(1300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(1297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1296);
					match(SP);
					}
				}

				setState(1299);
				oC_NodeLabels();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AtomContext extends ParserRuleContext {
		public OC_LiteralContext oC_Literal() {
			return getRuleContext(OC_LiteralContext.class,0);
		}
		public OC_ParameterContext oC_Parameter() {
			return getRuleContext(OC_ParameterContext.class,0);
		}
		public OC_CaseExpressionContext oC_CaseExpression() {
			return getRuleContext(OC_CaseExpressionContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(SeraphParser.COUNT, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ListComprehensionContext oC_ListComprehension() {
			return getRuleContext(OC_ListComprehensionContext.class,0);
		}
		public OC_PatternComprehensionContext oC_PatternComprehension() {
			return getRuleContext(OC_PatternComprehensionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(SeraphParser.ALL, 0); }
		public OC_FilterExpressionContext oC_FilterExpression() {
			return getRuleContext(OC_FilterExpressionContext.class,0);
		}
		public TerminalNode ANY() { return getToken(SeraphParser.ANY, 0); }
		public TerminalNode NONE() { return getToken(SeraphParser.NONE, 0); }
		public TerminalNode SINGLE() { return getToken(SeraphParser.SINGLE, 0); }
		public OC_RelationshipsPatternContext oC_RelationshipsPattern() {
			return getRuleContext(OC_RelationshipsPatternContext.class,0);
		}
		public OC_ParenthesizedExpressionContext oC_ParenthesizedExpression() {
			return getRuleContext(OC_ParenthesizedExpressionContext.class,0);
		}
		public OC_FunctionInvocationContext oC_FunctionInvocation() {
			return getRuleContext(OC_FunctionInvocationContext.class,0);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_AtomContext oC_Atom() throws RecognitionException {
		OC_AtomContext _localctx = new OC_AtomContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_oC_Atom);
		int _la;
		try {
			setState(1380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1302);
				oC_Literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1303);
				oC_Parameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1304);
				oC_CaseExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1305);
				match(COUNT);
				setState(1307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1306);
					match(SP);
					}
				}

				setState(1309);
				match(T__8);
				setState(1311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1310);
					match(SP);
					}
				}

				setState(1313);
				match(T__6);
				setState(1315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1314);
					match(SP);
					}
				}

				setState(1317);
				match(T__9);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1318);
				oC_ListComprehension();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1319);
				oC_PatternComprehension();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(1320);
				match(ALL);
				setState(1322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1321);
					match(SP);
					}
				}

				setState(1324);
				match(T__8);
				setState(1326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1325);
					match(SP);
					}
				}

				setState(1328);
				oC_FilterExpression();
				setState(1330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1329);
					match(SP);
					}
				}

				setState(1332);
				match(T__9);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(1334);
				match(ANY);
				setState(1336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1335);
					match(SP);
					}
				}

				setState(1338);
				match(T__8);
				setState(1340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1339);
					match(SP);
					}
				}

				setState(1342);
				oC_FilterExpression();
				setState(1344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1343);
					match(SP);
					}
				}

				setState(1346);
				match(T__9);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(1348);
				match(NONE);
				setState(1350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1349);
					match(SP);
					}
				}

				setState(1352);
				match(T__8);
				setState(1354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1353);
					match(SP);
					}
				}

				setState(1356);
				oC_FilterExpression();
				setState(1358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1357);
					match(SP);
					}
				}

				setState(1360);
				match(T__9);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(1362);
				match(SINGLE);
				setState(1364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1363);
					match(SP);
					}
				}

				setState(1366);
				match(T__8);
				setState(1368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1367);
					match(SP);
					}
				}

				setState(1370);
				oC_FilterExpression();
				setState(1372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1371);
					match(SP);
					}
				}

				setState(1374);
				match(T__9);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1376);
				oC_RelationshipsPattern();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1377);
				oC_ParenthesizedExpression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1378);
				oC_FunctionInvocation();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1379);
				oC_Variable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LiteralContext extends ParserRuleContext {
		public OC_NumberLiteralContext oC_NumberLiteral() {
			return getRuleContext(OC_NumberLiteralContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(SeraphParser.StringLiteral, 0); }
		public OC_BooleanLiteralContext oC_BooleanLiteral() {
			return getRuleContext(OC_BooleanLiteralContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SeraphParser.NULL, 0); }
		public OC_MapLiteralContext oC_MapLiteral() {
			return getRuleContext(OC_MapLiteralContext.class,0);
		}
		public OC_ListLiteralContext oC_ListLiteral() {
			return getRuleContext(OC_ListLiteralContext.class,0);
		}
		public OC_LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_LiteralContext oC_Literal() throws RecognitionException {
		OC_LiteralContext _localctx = new OC_LiteralContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_oC_Literal);
		try {
			setState(1388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
			case ExponentDecimalReal:
			case RegularDecimalReal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1382);
				oC_NumberLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1383);
				match(StringLiteral);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1384);
				oC_BooleanLiteral();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1385);
				match(NULL);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 5);
				{
				setState(1386);
				oC_MapLiteral();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(1387);
				oC_ListLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SeraphParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SeraphParser.FALSE, 0); }
		public OC_BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_BooleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_BooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_BooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_BooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_BooleanLiteralContext oC_BooleanLiteral() throws RecognitionException {
		OC_BooleanLiteralContext _localctx = new OC_BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_oC_BooleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1390);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ListLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ListLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ListLiteralContext oC_ListLiteral() throws RecognitionException {
		OC_ListLiteralContext _localctx = new OC_ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_oC_ListLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1392);
			match(T__10);
			setState(1394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1393);
				match(SP);
				}
			}

			setState(1413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__25))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ALL - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (COUNT - 69)) | (1L << (ANY - 69)) | (1L << (NONE - 69)) | (1L << (SINGLE - 69)) | (1L << (TRUE - 69)) | (1L << (FALSE - 69)) | (1L << (EXISTS - 69)) | (1L << (CASE - 69)) | (1L << (StringLiteral - 69)) | (1L << (HexInteger - 69)) | (1L << (DecimalInteger - 69)) | (1L << (OctalInteger - 69)) | (1L << (HexLetter - 69)) | (1L << (ExponentDecimalReal - 69)) | (1L << (RegularDecimalReal - 69)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FILTER - 141)) | (1L << (EXTRACT - 141)) | (1L << (UnescapedSymbolicName - 141)) | (1L << (EscapedSymbolicName - 141)))) != 0)) {
				{
				setState(1396);
				oC_Expression();
				setState(1398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1397);
					match(SP);
					}
				}

				setState(1410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(1400);
					match(T__3);
					setState(1402);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1401);
						match(SP);
						}
					}

					setState(1404);
					oC_Expression();
					setState(1406);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1405);
						match(SP);
						}
					}

					}
					}
					setState(1412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1415);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PartialComparisonExpressionContext extends ParserRuleContext {
		public OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() {
			return getRuleContext(OC_AddOrSubtractExpressionContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_PartialComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PartialComparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PartialComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PartialComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PartialComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PartialComparisonExpressionContext oC_PartialComparisonExpression() throws RecognitionException {
		OC_PartialComparisonExpressionContext _localctx = new OC_PartialComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_oC_PartialComparisonExpression);
		int _la;
		try {
			setState(1447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1417);
				match(T__4);
				setState(1419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1418);
					match(SP);
					}
				}

				setState(1421);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1422);
				match(T__19);
				setState(1424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1423);
					match(SP);
					}
				}

				setState(1426);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1427);
				match(T__20);
				setState(1429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1428);
					match(SP);
					}
				}

				setState(1431);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1432);
				match(T__21);
				setState(1434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1433);
					match(SP);
					}
				}

				setState(1436);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(1437);
				match(T__22);
				setState(1439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1438);
					match(SP);
					}
				}

				setState(1441);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(1442);
				match(T__23);
				setState(1444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1443);
					match(SP);
					}
				}

				setState(1446);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ParenthesizedExpressionContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ParenthesizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ParenthesizedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ParenthesizedExpressionContext oC_ParenthesizedExpression() throws RecognitionException {
		OC_ParenthesizedExpressionContext _localctx = new OC_ParenthesizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_oC_ParenthesizedExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1449);
			match(T__8);
			setState(1451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1450);
				match(SP);
				}
			}

			setState(1453);
			oC_Expression();
			setState(1455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1454);
				match(SP);
				}
			}

			setState(1457);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipsPatternContext extends ParserRuleContext {
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public List<OC_PatternElementChainContext> oC_PatternElementChain() {
			return getRuleContexts(OC_PatternElementChainContext.class);
		}
		public OC_PatternElementChainContext oC_PatternElementChain(int i) {
			return getRuleContext(OC_PatternElementChainContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_RelationshipsPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipsPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RelationshipsPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RelationshipsPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RelationshipsPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RelationshipsPatternContext oC_RelationshipsPattern() throws RecognitionException {
		OC_RelationshipsPatternContext _localctx = new OC_RelationshipsPatternContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_oC_RelationshipsPattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1459);
			oC_NodePattern();
			setState(1464); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1461);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1460);
						match(SP);
						}
					}

					setState(1463);
					oC_PatternElementChain();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1466); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FilterExpressionContext extends ParserRuleContext {
		public OC_IdInCollContext oC_IdInColl() {
			return getRuleContext(OC_IdInCollContext.class,0);
		}
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_FilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FilterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_FilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_FilterExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_FilterExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_FilterExpressionContext oC_FilterExpression() throws RecognitionException {
		OC_FilterExpressionContext _localctx = new OC_FilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_oC_FilterExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1468);
			oC_IdInColl();
			setState(1473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				{
				setState(1470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1469);
					match(SP);
					}
				}

				setState(1472);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_IdInCollContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode IN() { return getToken(SeraphParser.IN, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_IdInCollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_IdInColl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_IdInColl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_IdInColl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_IdInColl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_IdInCollContext oC_IdInColl() throws RecognitionException {
		OC_IdInCollContext _localctx = new OC_IdInCollContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_oC_IdInColl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			oC_Variable();
			setState(1476);
			match(SP);
			setState(1477);
			match(IN);
			setState(1478);
			match(SP);
			setState(1479);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FunctionInvocationContext extends ParserRuleContext {
		public OC_FunctionNameContext oC_FunctionName() {
			return getRuleContext(OC_FunctionNameContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode DISTINCT() { return getToken(SeraphParser.DISTINCT, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FunctionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_FunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_FunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_FunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_FunctionInvocationContext oC_FunctionInvocation() throws RecognitionException {
		OC_FunctionInvocationContext _localctx = new OC_FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_oC_FunctionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1481);
			oC_FunctionName();
			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1482);
				match(SP);
				}
			}

			setState(1485);
			match(T__8);
			setState(1487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1486);
				match(SP);
				}
			}

			setState(1493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DISTINCT) {
				{
				setState(1489);
				match(DISTINCT);
				setState(1491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1490);
					match(SP);
					}
				}

				}
			}

			setState(1512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__25))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ALL - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (COUNT - 69)) | (1L << (ANY - 69)) | (1L << (NONE - 69)) | (1L << (SINGLE - 69)) | (1L << (TRUE - 69)) | (1L << (FALSE - 69)) | (1L << (EXISTS - 69)) | (1L << (CASE - 69)) | (1L << (StringLiteral - 69)) | (1L << (HexInteger - 69)) | (1L << (DecimalInteger - 69)) | (1L << (OctalInteger - 69)) | (1L << (HexLetter - 69)) | (1L << (ExponentDecimalReal - 69)) | (1L << (RegularDecimalReal - 69)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FILTER - 141)) | (1L << (EXTRACT - 141)) | (1L << (UnescapedSymbolicName - 141)) | (1L << (EscapedSymbolicName - 141)))) != 0)) {
				{
				setState(1495);
				oC_Expression();
				setState(1497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1496);
					match(SP);
					}
				}

				setState(1509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(1499);
					match(T__3);
					setState(1501);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1500);
						match(SP);
						}
					}

					setState(1503);
					oC_Expression();
					setState(1505);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1504);
						match(SP);
						}
					}

					}
					}
					setState(1511);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1514);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FunctionNameContext extends ParserRuleContext {
		public OC_NamespaceContext oC_Namespace() {
			return getRuleContext(OC_NamespaceContext.class,0);
		}
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SeraphParser.EXISTS, 0); }
		public OC_FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FunctionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_FunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_FunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_FunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_FunctionNameContext oC_FunctionName() throws RecognitionException {
		OC_FunctionNameContext _localctx = new OC_FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_oC_FunctionName);
		try {
			setState(1520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1516);
				oC_Namespace();
				setState(1517);
				oC_SymbolicName();
				}
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1519);
				match(EXISTS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ExplicitProcedureInvocationContext extends ParserRuleContext {
		public OC_ProcedureNameContext oC_ProcedureName() {
			return getRuleContext(OC_ProcedureNameContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ExplicitProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ExplicitProcedureInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ExplicitProcedureInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ExplicitProcedureInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ExplicitProcedureInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() throws RecognitionException {
		OC_ExplicitProcedureInvocationContext _localctx = new OC_ExplicitProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_oC_ExplicitProcedureInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1522);
			oC_ProcedureName();
			setState(1524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1523);
				match(SP);
				}
			}

			setState(1526);
			match(T__8);
			setState(1528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1527);
				match(SP);
				}
			}

			setState(1547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__25))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ALL - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (COUNT - 69)) | (1L << (ANY - 69)) | (1L << (NONE - 69)) | (1L << (SINGLE - 69)) | (1L << (TRUE - 69)) | (1L << (FALSE - 69)) | (1L << (EXISTS - 69)) | (1L << (CASE - 69)) | (1L << (StringLiteral - 69)) | (1L << (HexInteger - 69)) | (1L << (DecimalInteger - 69)) | (1L << (OctalInteger - 69)) | (1L << (HexLetter - 69)) | (1L << (ExponentDecimalReal - 69)) | (1L << (RegularDecimalReal - 69)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FILTER - 141)) | (1L << (EXTRACT - 141)) | (1L << (UnescapedSymbolicName - 141)) | (1L << (EscapedSymbolicName - 141)))) != 0)) {
				{
				setState(1530);
				oC_Expression();
				setState(1532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1531);
					match(SP);
					}
				}

				setState(1544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(1534);
					match(T__3);
					setState(1536);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1535);
						match(SP);
						}
					}

					setState(1538);
					oC_Expression();
					setState(1540);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1539);
						match(SP);
						}
					}

					}
					}
					setState(1546);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1549);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ImplicitProcedureInvocationContext extends ParserRuleContext {
		public OC_ProcedureNameContext oC_ProcedureName() {
			return getRuleContext(OC_ProcedureNameContext.class,0);
		}
		public OC_ImplicitProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ImplicitProcedureInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ImplicitProcedureInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ImplicitProcedureInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ImplicitProcedureInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ImplicitProcedureInvocationContext oC_ImplicitProcedureInvocation() throws RecognitionException {
		OC_ImplicitProcedureInvocationContext _localctx = new OC_ImplicitProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_oC_ImplicitProcedureInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			oC_ProcedureName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProcedureResultFieldContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ProcedureResultFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProcedureResultField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ProcedureResultField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ProcedureResultField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ProcedureResultField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ProcedureResultFieldContext oC_ProcedureResultField() throws RecognitionException {
		OC_ProcedureResultFieldContext _localctx = new OC_ProcedureResultFieldContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_oC_ProcedureResultField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1553);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProcedureNameContext extends ParserRuleContext {
		public OC_NamespaceContext oC_Namespace() {
			return getRuleContext(OC_NamespaceContext.class,0);
		}
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ProcedureNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProcedureName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ProcedureName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ProcedureName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ProcedureName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ProcedureNameContext oC_ProcedureName() throws RecognitionException {
		OC_ProcedureNameContext _localctx = new OC_ProcedureNameContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_oC_ProcedureName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1555);
			oC_Namespace();
			setState(1556);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NamespaceContext extends ParserRuleContext {
		public List<OC_SymbolicNameContext> oC_SymbolicName() {
			return getRuleContexts(OC_SymbolicNameContext.class);
		}
		public OC_SymbolicNameContext oC_SymbolicName(int i) {
			return getRuleContext(OC_SymbolicNameContext.class,i);
		}
		public OC_NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Namespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Namespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Namespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NamespaceContext oC_Namespace() throws RecognitionException {
		OC_NamespaceContext _localctx = new OC_NamespaceContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_oC_Namespace);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1558);
					oC_SymbolicName();
					setState(1559);
					match(T__24);
					}
					} 
				}
				setState(1565);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListComprehensionContext extends ParserRuleContext {
		public OC_FilterExpressionContext oC_FilterExpression() {
			return getRuleContext(OC_FilterExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_ListComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListComprehension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ListComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ListComprehension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ListComprehension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ListComprehensionContext oC_ListComprehension() throws RecognitionException {
		OC_ListComprehensionContext _localctx = new OC_ListComprehensionContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_oC_ListComprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			match(T__10);
			setState(1568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1567);
				match(SP);
				}
			}

			setState(1570);
			oC_FilterExpression();
			setState(1579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				setState(1572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1571);
					match(SP);
					}
				}

				setState(1574);
				match(T__12);
				setState(1576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1575);
					match(SP);
					}
				}

				setState(1578);
				oC_Expression();
				}
				break;
			}
			setState(1582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1581);
				match(SP);
				}
			}

			setState(1584);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternComprehensionContext extends ParserRuleContext {
		public OC_RelationshipsPatternContext oC_RelationshipsPattern() {
			return getRuleContext(OC_RelationshipsPatternContext.class,0);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SeraphParser.WHERE, 0); }
		public OC_PatternComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternComprehension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PatternComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PatternComprehension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PatternComprehension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PatternComprehensionContext oC_PatternComprehension() throws RecognitionException {
		OC_PatternComprehensionContext _localctx = new OC_PatternComprehensionContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_oC_PatternComprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1586);
			match(T__10);
			setState(1588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1587);
				match(SP);
				}
			}

			setState(1598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (COUNT - 105)) | (1L << (ANY - 105)) | (1L << (NONE - 105)) | (1L << (SINGLE - 105)) | (1L << (HexLetter - 105)) | (1L << (FILTER - 105)) | (1L << (EXTRACT - 105)) | (1L << (UnescapedSymbolicName - 105)) | (1L << (EscapedSymbolicName - 105)))) != 0)) {
				{
				setState(1590);
				oC_Variable();
				setState(1592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1591);
					match(SP);
					}
				}

				setState(1594);
				match(T__4);
				setState(1596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1595);
					match(SP);
					}
				}

				}
			}

			setState(1600);
			oC_RelationshipsPattern();
			setState(1602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1601);
				match(SP);
				}
			}

			setState(1612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1604);
				match(WHERE);
				setState(1606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1605);
					match(SP);
					}
				}

				setState(1608);
				oC_Expression();
				setState(1610);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1609);
					match(SP);
					}
				}

				}
			}

			setState(1614);
			match(T__12);
			setState(1616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1615);
				match(SP);
				}
			}

			setState(1618);
			oC_Expression();
			setState(1620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1619);
				match(SP);
				}
			}

			setState(1622);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyLookupContext extends ParserRuleContext {
		public OC_PropertyKeyNameContext oC_PropertyKeyName() {
			return getRuleContext(OC_PropertyKeyNameContext.class,0);
		}
		public TerminalNode SP() { return getToken(SeraphParser.SP, 0); }
		public OC_PropertyLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyLookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PropertyLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PropertyLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PropertyLookup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PropertyLookupContext oC_PropertyLookup() throws RecognitionException {
		OC_PropertyLookupContext _localctx = new OC_PropertyLookupContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_oC_PropertyLookup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			match(T__24);
			setState(1626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1625);
				match(SP);
				}
			}

			{
			setState(1628);
			oC_PropertyKeyName();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CaseExpressionContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SeraphParser.END, 0); }
		public TerminalNode ELSE() { return getToken(SeraphParser.ELSE, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public TerminalNode CASE() { return getToken(SeraphParser.CASE, 0); }
		public List<OC_CaseAlternativesContext> oC_CaseAlternatives() {
			return getRuleContexts(OC_CaseAlternativesContext.class);
		}
		public OC_CaseAlternativesContext oC_CaseAlternatives(int i) {
			return getRuleContext(OC_CaseAlternativesContext.class,i);
		}
		public OC_CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_CaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_CaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_CaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_CaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_CaseExpressionContext oC_CaseExpression() throws RecognitionException {
		OC_CaseExpressionContext _localctx = new OC_CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_oC_CaseExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				{
				{
				setState(1630);
				match(CASE);
				setState(1635); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1632);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1631);
							match(SP);
							}
						}

						setState(1634);
						oC_CaseAlternatives();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1637); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,289,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				break;
			case 2:
				{
				{
				setState(1639);
				match(CASE);
				setState(1641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1640);
					match(SP);
					}
				}

				setState(1643);
				oC_Expression();
				setState(1648); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1645);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1644);
							match(SP);
							}
						}

						setState(1647);
						oC_CaseAlternatives();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1650); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,292,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				break;
			}
			setState(1662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				{
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1654);
					match(SP);
					}
				}

				setState(1657);
				match(ELSE);
				setState(1659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1658);
					match(SP);
					}
				}

				setState(1661);
				oC_Expression();
				}
				break;
			}
			setState(1665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1664);
				match(SP);
				}
			}

			setState(1667);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CaseAlternativesContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SeraphParser.WHEN, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public TerminalNode THEN() { return getToken(SeraphParser.THEN, 0); }
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_CaseAlternativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_CaseAlternatives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_CaseAlternatives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_CaseAlternatives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_CaseAlternatives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_CaseAlternativesContext oC_CaseAlternatives() throws RecognitionException {
		OC_CaseAlternativesContext _localctx = new OC_CaseAlternativesContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_oC_CaseAlternatives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1669);
			match(WHEN);
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1670);
				match(SP);
				}
			}

			setState(1673);
			oC_Expression();
			setState(1675);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1674);
				match(SP);
				}
			}

			setState(1677);
			match(THEN);
			setState(1679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1678);
				match(SP);
				}
			}

			setState(1681);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_VariableContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_VariableContext oC_Variable() throws RecognitionException {
		OC_VariableContext _localctx = new OC_VariableContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_oC_Variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1683);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NumberLiteralContext extends ParserRuleContext {
		public OC_DoubleLiteralContext oC_DoubleLiteral() {
			return getRuleContext(OC_DoubleLiteralContext.class,0);
		}
		public OC_IntegerLiteralContext oC_IntegerLiteral() {
			return getRuleContext(OC_IntegerLiteralContext.class,0);
		}
		public OC_NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NumberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_NumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_NumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_NumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_NumberLiteralContext oC_NumberLiteral() throws RecognitionException {
		OC_NumberLiteralContext _localctx = new OC_NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_oC_NumberLiteral);
		try {
			setState(1687);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ExponentDecimalReal:
			case RegularDecimalReal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1685);
				oC_DoubleLiteral();
				}
				break;
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
				enterOuterAlt(_localctx, 2);
				{
				setState(1686);
				oC_IntegerLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MapLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public List<OC_PropertyKeyNameContext> oC_PropertyKeyName() {
			return getRuleContexts(OC_PropertyKeyNameContext.class);
		}
		public OC_PropertyKeyNameContext oC_PropertyKeyName(int i) {
			return getRuleContext(OC_PropertyKeyNameContext.class,i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_MapLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MapLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_MapLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_MapLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_MapLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_MapLiteralContext oC_MapLiteral() throws RecognitionException {
		OC_MapLiteralContext _localctx = new OC_MapLiteralContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_oC_MapLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1689);
			match(T__0);
			setState(1691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1690);
				match(SP);
				}
			}

			setState(1726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (UNION - 68)) | (1L << (ALL - 68)) | (1L << (OPTIONAL - 68)) | (1L << (MATCH - 68)) | (1L << (UNWIND - 68)) | (1L << (AS - 68)) | (1L << (MERGE - 68)) | (1L << (ON - 68)) | (1L << (CREATE - 68)) | (1L << (SET - 68)) | (1L << (DETACH - 68)) | (1L << (DELETE - 68)) | (1L << (REMOVE - 68)) | (1L << (WITH - 68)) | (1L << (RETURN - 68)) | (1L << (DISTINCT - 68)) | (1L << (ORDER - 68)) | (1L << (BY - 68)) | (1L << (L_SKIP - 68)) | (1L << (LIMIT - 68)) | (1L << (ASCENDING - 68)) | (1L << (ASC - 68)) | (1L << (DESCENDING - 68)) | (1L << (DESC - 68)) | (1L << (WHERE - 68)) | (1L << (OR - 68)) | (1L << (XOR - 68)) | (1L << (AND - 68)) | (1L << (NOT - 68)) | (1L << (IN - 68)) | (1L << (STARTS - 68)) | (1L << (ENDS - 68)) | (1L << (CONTAINS - 68)) | (1L << (IS - 68)) | (1L << (NULL - 68)) | (1L << (COUNT - 68)) | (1L << (ANY - 68)) | (1L << (NONE - 68)) | (1L << (SINGLE - 68)) | (1L << (TRUE - 68)) | (1L << (FALSE - 68)) | (1L << (EXISTS - 68)) | (1L << (CASE - 68)) | (1L << (ELSE - 68)) | (1L << (END - 68)) | (1L << (WHEN - 68)) | (1L << (THEN - 68)) | (1L << (HexLetter - 68)) | (1L << (CONSTRAINT - 68)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (DO - 132)) | (1L << (FOR - 132)) | (1L << (REQUIRE - 132)) | (1L << (UNIQUE - 132)) | (1L << (MANDATORY - 132)) | (1L << (SCALAR - 132)) | (1L << (OF - 132)) | (1L << (ADD - 132)) | (1L << (DROP - 132)) | (1L << (FILTER - 132)) | (1L << (EXTRACT - 132)) | (1L << (UnescapedSymbolicName - 132)) | (1L << (EscapedSymbolicName - 132)))) != 0)) {
				{
				setState(1693);
				oC_PropertyKeyName();
				setState(1695);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1694);
					match(SP);
					}
				}

				setState(1697);
				match(T__7);
				setState(1699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1698);
					match(SP);
					}
				}

				setState(1701);
				oC_Expression();
				setState(1703);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1702);
					match(SP);
					}
				}

				setState(1723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(1705);
					match(T__3);
					setState(1707);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1706);
						match(SP);
						}
					}

					setState(1709);
					oC_PropertyKeyName();
					setState(1711);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1710);
						match(SP);
						}
					}

					setState(1713);
					match(T__7);
					setState(1715);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1714);
						match(SP);
						}
					}

					setState(1717);
					oC_Expression();
					setState(1719);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1718);
						match(SP);
						}
					}

					}
					}
					setState(1725);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1728);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ParameterContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public TerminalNode DecimalInteger() { return getToken(SeraphParser.DecimalInteger, 0); }
		public OC_ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ParameterContext oC_Parameter() throws RecognitionException {
		OC_ParameterContext _localctx = new OC_ParameterContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_oC_Parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1730);
			match(T__25);
			setState(1733);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				{
				setState(1731);
				oC_SymbolicName();
				}
				break;
			case DecimalInteger:
				{
				setState(1732);
				match(DecimalInteger);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyExpressionContext extends ParserRuleContext {
		public OC_AtomContext oC_Atom() {
			return getRuleContext(OC_AtomContext.class,0);
		}
		public List<OC_PropertyLookupContext> oC_PropertyLookup() {
			return getRuleContexts(OC_PropertyLookupContext.class);
		}
		public OC_PropertyLookupContext oC_PropertyLookup(int i) {
			return getRuleContext(OC_PropertyLookupContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(SeraphParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(SeraphParser.SP, i);
		}
		public OC_PropertyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PropertyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PropertyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PropertyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PropertyExpressionContext oC_PropertyExpression() throws RecognitionException {
		OC_PropertyExpressionContext _localctx = new OC_PropertyExpressionContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_oC_PropertyExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1735);
			oC_Atom();
			setState(1740); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1737);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1736);
						match(SP);
						}
					}

					setState(1739);
					oC_PropertyLookup();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1742); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,314,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyKeyNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_PropertyKeyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyKeyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_PropertyKeyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_PropertyKeyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_PropertyKeyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_PropertyKeyNameContext oC_PropertyKeyName() throws RecognitionException {
		OC_PropertyKeyNameContext _localctx = new OC_PropertyKeyNameContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_oC_PropertyKeyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1744);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode HexInteger() { return getToken(SeraphParser.HexInteger, 0); }
		public TerminalNode OctalInteger() { return getToken(SeraphParser.OctalInteger, 0); }
		public TerminalNode DecimalInteger() { return getToken(SeraphParser.DecimalInteger, 0); }
		public OC_IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_IntegerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_IntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_IntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_IntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_IntegerLiteralContext oC_IntegerLiteral() throws RecognitionException {
		OC_IntegerLiteralContext _localctx = new OC_IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_oC_IntegerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1746);
			_la = _input.LA(1);
			if ( !(((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (HexInteger - 119)) | (1L << (DecimalInteger - 119)) | (1L << (OctalInteger - 119)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DoubleLiteralContext extends ParserRuleContext {
		public TerminalNode ExponentDecimalReal() { return getToken(SeraphParser.ExponentDecimalReal, 0); }
		public TerminalNode RegularDecimalReal() { return getToken(SeraphParser.RegularDecimalReal, 0); }
		public OC_DoubleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_DoubleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_DoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_DoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_DoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_DoubleLiteralContext oC_DoubleLiteral() throws RecognitionException {
		OC_DoubleLiteralContext _localctx = new OC_DoubleLiteralContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_oC_DoubleLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1748);
			_la = _input.LA(1);
			if ( !(_la==ExponentDecimalReal || _la==RegularDecimalReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SchemaNameContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ReservedWordContext oC_ReservedWord() {
			return getRuleContext(OC_ReservedWordContext.class,0);
		}
		public OC_SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SchemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SchemaName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SchemaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SchemaNameContext oC_SchemaName() throws RecognitionException {
		OC_SchemaNameContext _localctx = new OC_SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_oC_SchemaName);
		try {
			setState(1752);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 1);
				{
				setState(1750);
				oC_SymbolicName();
				}
				break;
			case UNION:
			case ALL:
			case OPTIONAL:
			case MATCH:
			case UNWIND:
			case AS:
			case MERGE:
			case ON:
			case CREATE:
			case SET:
			case DETACH:
			case DELETE:
			case REMOVE:
			case WITH:
			case RETURN:
			case DISTINCT:
			case ORDER:
			case BY:
			case L_SKIP:
			case LIMIT:
			case ASCENDING:
			case ASC:
			case DESCENDING:
			case DESC:
			case WHERE:
			case OR:
			case XOR:
			case AND:
			case NOT:
			case IN:
			case STARTS:
			case ENDS:
			case CONTAINS:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case EXISTS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case CONSTRAINT:
			case DO:
			case FOR:
			case REQUIRE:
			case UNIQUE:
			case MANDATORY:
			case SCALAR:
			case OF:
			case ADD:
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1751);
				oC_ReservedWord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReservedWordContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SeraphParser.ALL, 0); }
		public TerminalNode ASC() { return getToken(SeraphParser.ASC, 0); }
		public TerminalNode ASCENDING() { return getToken(SeraphParser.ASCENDING, 0); }
		public TerminalNode BY() { return getToken(SeraphParser.BY, 0); }
		public TerminalNode CREATE() { return getToken(SeraphParser.CREATE, 0); }
		public TerminalNode DELETE() { return getToken(SeraphParser.DELETE, 0); }
		public TerminalNode DESC() { return getToken(SeraphParser.DESC, 0); }
		public TerminalNode DESCENDING() { return getToken(SeraphParser.DESCENDING, 0); }
		public TerminalNode DETACH() { return getToken(SeraphParser.DETACH, 0); }
		public TerminalNode EXISTS() { return getToken(SeraphParser.EXISTS, 0); }
		public TerminalNode LIMIT() { return getToken(SeraphParser.LIMIT, 0); }
		public TerminalNode MATCH() { return getToken(SeraphParser.MATCH, 0); }
		public TerminalNode MERGE() { return getToken(SeraphParser.MERGE, 0); }
		public TerminalNode ON() { return getToken(SeraphParser.ON, 0); }
		public TerminalNode OPTIONAL() { return getToken(SeraphParser.OPTIONAL, 0); }
		public TerminalNode ORDER() { return getToken(SeraphParser.ORDER, 0); }
		public TerminalNode REMOVE() { return getToken(SeraphParser.REMOVE, 0); }
		public TerminalNode RETURN() { return getToken(SeraphParser.RETURN, 0); }
		public TerminalNode SET() { return getToken(SeraphParser.SET, 0); }
		public TerminalNode L_SKIP() { return getToken(SeraphParser.L_SKIP, 0); }
		public TerminalNode WHERE() { return getToken(SeraphParser.WHERE, 0); }
		public TerminalNode WITH() { return getToken(SeraphParser.WITH, 0); }
		public TerminalNode UNION() { return getToken(SeraphParser.UNION, 0); }
		public TerminalNode UNWIND() { return getToken(SeraphParser.UNWIND, 0); }
		public TerminalNode AND() { return getToken(SeraphParser.AND, 0); }
		public TerminalNode AS() { return getToken(SeraphParser.AS, 0); }
		public TerminalNode CONTAINS() { return getToken(SeraphParser.CONTAINS, 0); }
		public TerminalNode DISTINCT() { return getToken(SeraphParser.DISTINCT, 0); }
		public TerminalNode ENDS() { return getToken(SeraphParser.ENDS, 0); }
		public TerminalNode IN() { return getToken(SeraphParser.IN, 0); }
		public TerminalNode IS() { return getToken(SeraphParser.IS, 0); }
		public TerminalNode NOT() { return getToken(SeraphParser.NOT, 0); }
		public TerminalNode OR() { return getToken(SeraphParser.OR, 0); }
		public TerminalNode STARTS() { return getToken(SeraphParser.STARTS, 0); }
		public TerminalNode XOR() { return getToken(SeraphParser.XOR, 0); }
		public TerminalNode FALSE() { return getToken(SeraphParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(SeraphParser.TRUE, 0); }
		public TerminalNode NULL() { return getToken(SeraphParser.NULL, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SeraphParser.CONSTRAINT, 0); }
		public TerminalNode DO() { return getToken(SeraphParser.DO, 0); }
		public TerminalNode FOR() { return getToken(SeraphParser.FOR, 0); }
		public TerminalNode REQUIRE() { return getToken(SeraphParser.REQUIRE, 0); }
		public TerminalNode UNIQUE() { return getToken(SeraphParser.UNIQUE, 0); }
		public TerminalNode CASE() { return getToken(SeraphParser.CASE, 0); }
		public TerminalNode WHEN() { return getToken(SeraphParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SeraphParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(SeraphParser.ELSE, 0); }
		public TerminalNode END() { return getToken(SeraphParser.END, 0); }
		public TerminalNode MANDATORY() { return getToken(SeraphParser.MANDATORY, 0); }
		public TerminalNode SCALAR() { return getToken(SeraphParser.SCALAR, 0); }
		public TerminalNode OF() { return getToken(SeraphParser.OF, 0); }
		public TerminalNode ADD() { return getToken(SeraphParser.ADD, 0); }
		public TerminalNode DROP() { return getToken(SeraphParser.DROP, 0); }
		public OC_ReservedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReservedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_ReservedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_ReservedWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_ReservedWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_ReservedWordContext oC_ReservedWord() throws RecognitionException {
		OC_ReservedWordContext _localctx = new OC_ReservedWordContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_oC_ReservedWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1754);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (UNION - 68)) | (1L << (ALL - 68)) | (1L << (OPTIONAL - 68)) | (1L << (MATCH - 68)) | (1L << (UNWIND - 68)) | (1L << (AS - 68)) | (1L << (MERGE - 68)) | (1L << (ON - 68)) | (1L << (CREATE - 68)) | (1L << (SET - 68)) | (1L << (DETACH - 68)) | (1L << (DELETE - 68)) | (1L << (REMOVE - 68)) | (1L << (WITH - 68)) | (1L << (RETURN - 68)) | (1L << (DISTINCT - 68)) | (1L << (ORDER - 68)) | (1L << (BY - 68)) | (1L << (L_SKIP - 68)) | (1L << (LIMIT - 68)) | (1L << (ASCENDING - 68)) | (1L << (ASC - 68)) | (1L << (DESCENDING - 68)) | (1L << (DESC - 68)) | (1L << (WHERE - 68)) | (1L << (OR - 68)) | (1L << (XOR - 68)) | (1L << (AND - 68)) | (1L << (NOT - 68)) | (1L << (IN - 68)) | (1L << (STARTS - 68)) | (1L << (ENDS - 68)) | (1L << (CONTAINS - 68)) | (1L << (IS - 68)) | (1L << (NULL - 68)) | (1L << (TRUE - 68)) | (1L << (FALSE - 68)) | (1L << (EXISTS - 68)) | (1L << (CASE - 68)) | (1L << (ELSE - 68)) | (1L << (END - 68)) | (1L << (WHEN - 68)) | (1L << (THEN - 68)) | (1L << (CONSTRAINT - 68)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (DO - 132)) | (1L << (FOR - 132)) | (1L << (REQUIRE - 132)) | (1L << (UNIQUE - 132)) | (1L << (MANDATORY - 132)) | (1L << (SCALAR - 132)) | (1L << (OF - 132)) | (1L << (ADD - 132)) | (1L << (DROP - 132)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SymbolicNameContext extends ParserRuleContext {
		public TerminalNode UnescapedSymbolicName() { return getToken(SeraphParser.UnescapedSymbolicName, 0); }
		public TerminalNode EscapedSymbolicName() { return getToken(SeraphParser.EscapedSymbolicName, 0); }
		public TerminalNode HexLetter() { return getToken(SeraphParser.HexLetter, 0); }
		public TerminalNode COUNT() { return getToken(SeraphParser.COUNT, 0); }
		public TerminalNode FILTER() { return getToken(SeraphParser.FILTER, 0); }
		public TerminalNode EXTRACT() { return getToken(SeraphParser.EXTRACT, 0); }
		public TerminalNode ANY() { return getToken(SeraphParser.ANY, 0); }
		public TerminalNode NONE() { return getToken(SeraphParser.NONE, 0); }
		public TerminalNode SINGLE() { return getToken(SeraphParser.SINGLE, 0); }
		public OC_SymbolicNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SymbolicName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_SymbolicName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_SymbolicName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_SymbolicName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_SymbolicNameContext oC_SymbolicName() throws RecognitionException {
		OC_SymbolicNameContext _localctx = new OC_SymbolicNameContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_oC_SymbolicName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1756);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (COUNT - 105)) | (1L << (ANY - 105)) | (1L << (NONE - 105)) | (1L << (SINGLE - 105)) | (1L << (HexLetter - 105)) | (1L << (FILTER - 105)) | (1L << (EXTRACT - 105)) | (1L << (UnescapedSymbolicName - 105)) | (1L << (EscapedSymbolicName - 105)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LeftArrowHeadContext extends ParserRuleContext {
		public OC_LeftArrowHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_LeftArrowHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_LeftArrowHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_LeftArrowHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_LeftArrowHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_LeftArrowHeadContext oC_LeftArrowHead() throws RecognitionException {
		OC_LeftArrowHeadContext _localctx = new OC_LeftArrowHeadContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_oC_LeftArrowHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1758);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RightArrowHeadContext extends ParserRuleContext {
		public OC_RightArrowHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RightArrowHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_RightArrowHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_RightArrowHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_RightArrowHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_RightArrowHeadContext oC_RightArrowHead() throws RecognitionException {
		OC_RightArrowHeadContext _localctx = new OC_RightArrowHeadContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_oC_RightArrowHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DashContext extends ParserRuleContext {
		public OC_DashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Dash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).enterOC_Dash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphListener ) ((SeraphListener)listener).exitOC_Dash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SeraphVisitor ) return ((SeraphVisitor<? extends T>)visitor).visitOC_Dash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OC_DashContext oC_Dash() throws RecognitionException {
		OC_DashContext _localctx = new OC_DashContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_oC_Dash);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0097\u06e7\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\3\2\3\2\5\2\u00ff\n\2\3"+
		"\3\5\3\u0102\n\3\3\3\3\3\5\3\u0106\n\3\3\3\3\3\5\3\u010a\n\3\3\3\3\3\5"+
		"\3\u010e\n\3\3\3\3\3\5\3\u0112\n\3\3\3\3\3\5\3\u0116\n\3\3\3\3\3\5\3\u011a"+
		"\n\3\3\3\3\3\5\3\u011e\n\3\3\3\3\3\3\4\5\4\u0123\n\4\3\4\3\4\5\4\u0127"+
		"\n\4\3\4\3\4\5\4\u012b\n\4\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u0133\n\6\3\6\3"+
		"\6\5\6\u0137\n\6\3\6\3\6\5\6\u013b\n\6\3\6\3\6\5\6\u013f\n\6\3\6\3\6\5"+
		"\6\u0143\n\6\3\6\3\6\5\6\u0147\n\6\3\6\3\6\5\6\u014b\n\6\3\6\3\6\5\6\u014f"+
		"\n\6\3\6\3\6\5\6\u0153\n\6\3\6\3\6\3\7\3\7\3\b\3\b\5\b\u015b\n\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\5\13\u0163\n\13\3\13\3\13\5\13\u0167\n\13\3\13\3"+
		"\13\5\13\u016b\n\13\3\13\3\13\5\13\u016f\n\13\3\13\3\13\5\13\u0173\n\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16\u017d\n\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\21\5\21\u0186\n\21\3\22\3\22\5\22\u018a\n\22\3\22\3\22"+
		"\3\23\3\23\5\23\u0190\n\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\5\26"+
		"\u019a\n\26\3\26\3\26\3\27\3\27\3\27\5\27\u01a1\n\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\5\33\u01aa\n\33\3\33\3\33\5\33\u01ae\n\33\3\33\5\33"+
		"\u01b1\n\33\3\33\5\33\u01b4\n\33\3\34\3\34\3\35\3\35\3\36\3\36\5\36\u01bc"+
		"\n\36\3\37\3\37\5\37\u01c0\n\37\3\37\7\37\u01c3\n\37\f\37\16\37\u01c6"+
		"\13\37\3 \3 \3 \3 \5 \u01cc\n \3 \3 \3 \5 \u01d1\n \3 \5 \u01d4\n \3!"+
		"\3!\5!\u01d8\n!\3\"\3\"\5\"\u01dc\n\"\7\"\u01de\n\"\f\"\16\"\u01e1\13"+
		"\"\3\"\3\"\3\"\5\"\u01e6\n\"\7\"\u01e8\n\"\f\"\16\"\u01eb\13\"\3\"\3\""+
		"\5\"\u01ef\n\"\3\"\7\"\u01f2\n\"\f\"\16\"\u01f5\13\"\3\"\5\"\u01f8\n\""+
		"\3\"\5\"\u01fb\n\"\5\"\u01fd\n\"\3#\3#\5#\u0201\n#\7#\u0203\n#\f#\16#"+
		"\u0206\13#\3#\3#\5#\u020a\n#\7#\u020c\n#\f#\16#\u020f\13#\3#\3#\5#\u0213"+
		"\n#\6#\u0215\n#\r#\16#\u0216\3#\3#\3$\3$\3$\3$\3$\5$\u0220\n$\3%\3%\3"+
		"%\5%\u0225\n%\3&\3&\5&\u0229\n&\3&\3&\5&\u022d\n&\3&\3&\5&\u0231\n&\3"+
		"&\5&\u0234\n&\3\'\3\'\5\'\u0238\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\5(\u0242"+
		"\n(\3(\3(\3(\7(\u0247\n(\f(\16(\u024a\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\5)\u0256\n)\3*\3*\5*\u025a\n*\3*\3*\3+\3+\5+\u0260\n+\3+\3+\3+\7+\u0265"+
		"\n+\f+\16+\u0268\13+\3,\3,\5,\u026c\n,\3,\3,\5,\u0270\n,\3,\3,\3,\3,\5"+
		",\u0276\n,\3,\3,\5,\u027a\n,\3,\3,\3,\3,\5,\u0280\n,\3,\3,\5,\u0284\n"+
		",\3,\3,\3,\3,\5,\u028a\n,\3,\3,\5,\u028e\n,\3-\3-\5-\u0292\n-\3-\3-\5"+
		"-\u0296\n-\3-\3-\5-\u029a\n-\3-\3-\5-\u029e\n-\3-\7-\u02a1\n-\f-\16-\u02a4"+
		"\13-\3.\3.\3.\3.\5.\u02aa\n.\3.\3.\5.\u02ae\n.\3.\7.\u02b1\n.\f.\16.\u02b4"+
		"\13.\3/\3/\3/\3/\5/\u02ba\n/\3\60\3\60\3\60\3\60\5\60\u02c0\n\60\3\60"+
		"\3\60\3\60\5\60\u02c5\n\60\3\61\3\61\3\61\3\61\5\61\u02cb\n\61\3\61\3"+
		"\61\3\61\3\61\5\61\u02d1\n\61\3\62\3\62\3\62\5\62\u02d6\n\62\3\62\3\62"+
		"\5\62\u02da\n\62\3\62\7\62\u02dd\n\62\f\62\16\62\u02e0\13\62\5\62\u02e2"+
		"\n\62\3\62\5\62\u02e5\n\62\3\62\5\62\u02e8\n\62\3\63\3\63\3\63\3\63\3"+
		"\63\5\63\u02ef\n\63\3\63\3\63\3\64\3\64\3\64\5\64\u02f6\n\64\3\64\5\64"+
		"\u02f9\n\64\3\65\3\65\3\65\3\66\5\66\u02ff\n\66\3\66\5\66\u0302\n\66\3"+
		"\66\3\66\3\66\3\66\5\66\u0308\n\66\3\66\3\66\5\66\u030c\n\66\3\66\3\66"+
		"\5\66\u0310\n\66\3\67\3\67\5\67\u0314\n\67\3\67\3\67\5\67\u0318\n\67\3"+
		"\67\7\67\u031b\n\67\f\67\16\67\u031e\13\67\3\67\3\67\5\67\u0322\n\67\3"+
		"\67\3\67\5\67\u0326\n\67\3\67\7\67\u0329\n\67\f\67\16\67\u032c\13\67\5"+
		"\67\u032e\n\67\38\38\38\38\38\38\38\58\u0337\n8\39\39\39\39\39\39\39\5"+
		"9\u0340\n9\39\79\u0343\n9\f9\169\u0346\139\3:\3:\3:\3:\3;\3;\3;\3;\3<"+
		"\3<\5<\u0352\n<\3<\5<\u0355\n<\3=\3=\3=\3=\3>\3>\5>\u035d\n>\3>\3>\5>"+
		"\u0361\n>\3>\7>\u0364\n>\f>\16>\u0367\13>\3?\3?\5?\u036b\n?\3?\3?\5?\u036f"+
		"\n?\3?\3?\3?\5?\u0374\n?\3@\3@\3A\3A\5A\u037a\nA\3A\7A\u037d\nA\fA\16"+
		"A\u0380\13A\3A\3A\3A\3A\5A\u0386\nA\3B\3B\5B\u038a\nB\3B\3B\5B\u038e\n"+
		"B\5B\u0390\nB\3B\3B\5B\u0394\nB\5B\u0396\nB\3B\3B\5B\u039a\nB\5B\u039c"+
		"\nB\3B\3B\3C\3C\5C\u03a2\nC\3C\3C\3D\3D\5D\u03a8\nD\3D\3D\5D\u03ac\nD"+
		"\3D\5D\u03af\nD\3D\5D\u03b2\nD\3D\3D\5D\u03b6\nD\3D\3D\3D\3D\5D\u03bc"+
		"\nD\3D\3D\5D\u03c0\nD\3D\5D\u03c3\nD\3D\5D\u03c6\nD\3D\3D\3D\3D\5D\u03cc"+
		"\nD\3D\5D\u03cf\nD\3D\5D\u03d2\nD\3D\3D\5D\u03d6\nD\3D\3D\3D\3D\5D\u03dc"+
		"\nD\3D\5D\u03df\nD\3D\5D\u03e2\nD\3D\3D\5D\u03e6\nD\3E\3E\5E\u03ea\nE"+
		"\3E\3E\5E\u03ee\nE\5E\u03f0\nE\3E\3E\5E\u03f4\nE\5E\u03f6\nE\3E\5E\u03f9"+
		"\nE\3E\3E\5E\u03fd\nE\5E\u03ff\nE\3E\3E\3F\3F\5F\u0405\nF\3G\3G\5G\u0409"+
		"\nG\3G\3G\5G\u040d\nG\3G\3G\5G\u0411\nG\3G\5G\u0414\nG\3G\7G\u0417\nG"+
		"\fG\16G\u041a\13G\3H\3H\5H\u041e\nH\3H\7H\u0421\nH\fH\16H\u0424\13H\3"+
		"I\3I\5I\u0428\nI\3I\3I\3J\3J\5J\u042e\nJ\3J\3J\5J\u0432\nJ\5J\u0434\n"+
		"J\3J\3J\5J\u0438\nJ\3J\3J\5J\u043c\nJ\5J\u043e\nJ\5J\u0440\nJ\3K\3K\3"+
		"L\3L\3M\3M\3N\3N\3N\3N\3N\7N\u044d\nN\fN\16N\u0450\13N\3O\3O\3O\3O\3O"+
		"\7O\u0457\nO\fO\16O\u045a\13O\3P\3P\3P\3P\3P\7P\u0461\nP\fP\16P\u0464"+
		"\13P\3Q\3Q\5Q\u0468\nQ\7Q\u046a\nQ\fQ\16Q\u046d\13Q\3Q\3Q\3R\3R\5R\u0473"+
		"\nR\3R\7R\u0476\nR\fR\16R\u0479\13R\3S\3S\5S\u047d\nS\3S\3S\5S\u0481\n"+
		"S\3S\3S\5S\u0485\nS\3S\3S\5S\u0489\nS\3S\7S\u048c\nS\fS\16S\u048f\13S"+
		"\3T\3T\5T\u0493\nT\3T\3T\5T\u0497\nT\3T\3T\5T\u049b\nT\3T\3T\5T\u049f"+
		"\nT\3T\3T\5T\u04a3\nT\3T\3T\5T\u04a7\nT\3T\7T\u04aa\nT\fT\16T\u04ad\13"+
		"T\3U\3U\5U\u04b1\nU\3U\3U\5U\u04b5\nU\3U\7U\u04b8\nU\fU\16U\u04bb\13U"+
		"\3V\3V\5V\u04bf\nV\7V\u04c1\nV\fV\16V\u04c4\13V\3V\3V\3W\3W\3W\3W\7W\u04cc"+
		"\nW\fW\16W\u04cf\13W\3X\3X\3X\5X\u04d4\nX\3X\3X\5X\u04d8\nX\3X\3X\3X\3"+
		"X\3X\5X\u04df\nX\3X\3X\5X\u04e3\nX\3X\3X\5X\u04e7\nX\3X\5X\u04ea\nX\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u04f6\nY\3Y\5Y\u04f9\nY\3Y\3Y\3Z\3Z\3"+
		"Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u0507\nZ\3[\3[\5[\u050b\n[\3[\7[\u050e\n[\f"+
		"[\16[\u0511\13[\3[\5[\u0514\n[\3[\5[\u0517\n[\3\\\3\\\3\\\3\\\3\\\5\\"+
		"\u051e\n\\\3\\\3\\\5\\\u0522\n\\\3\\\3\\\5\\\u0526\n\\\3\\\3\\\3\\\3\\"+
		"\3\\\5\\\u052d\n\\\3\\\3\\\5\\\u0531\n\\\3\\\3\\\5\\\u0535\n\\\3\\\3\\"+
		"\3\\\3\\\5\\\u053b\n\\\3\\\3\\\5\\\u053f\n\\\3\\\3\\\5\\\u0543\n\\\3\\"+
		"\3\\\3\\\3\\\5\\\u0549\n\\\3\\\3\\\5\\\u054d\n\\\3\\\3\\\5\\\u0551\n\\"+
		"\3\\\3\\\3\\\3\\\5\\\u0557\n\\\3\\\3\\\5\\\u055b\n\\\3\\\3\\\5\\\u055f"+
		"\n\\\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u0567\n\\\3]\3]\3]\3]\3]\3]\5]\u056f"+
		"\n]\3^\3^\3_\3_\5_\u0575\n_\3_\3_\5_\u0579\n_\3_\3_\5_\u057d\n_\3_\3_"+
		"\5_\u0581\n_\7_\u0583\n_\f_\16_\u0586\13_\5_\u0588\n_\3_\3_\3`\3`\5`\u058e"+
		"\n`\3`\3`\3`\5`\u0593\n`\3`\3`\3`\5`\u0598\n`\3`\3`\3`\5`\u059d\n`\3`"+
		"\3`\3`\5`\u05a2\n`\3`\3`\3`\5`\u05a7\n`\3`\5`\u05aa\n`\3a\3a\5a\u05ae"+
		"\na\3a\3a\5a\u05b2\na\3a\3a\3b\3b\5b\u05b8\nb\3b\6b\u05bb\nb\rb\16b\u05bc"+
		"\3c\3c\5c\u05c1\nc\3c\5c\u05c4\nc\3d\3d\3d\3d\3d\3d\3e\3e\5e\u05ce\ne"+
		"\3e\3e\5e\u05d2\ne\3e\3e\5e\u05d6\ne\5e\u05d8\ne\3e\3e\5e\u05dc\ne\3e"+
		"\3e\5e\u05e0\ne\3e\3e\5e\u05e4\ne\7e\u05e6\ne\fe\16e\u05e9\13e\5e\u05eb"+
		"\ne\3e\3e\3f\3f\3f\3f\5f\u05f3\nf\3g\3g\5g\u05f7\ng\3g\3g\5g\u05fb\ng"+
		"\3g\3g\5g\u05ff\ng\3g\3g\5g\u0603\ng\3g\3g\5g\u0607\ng\7g\u0609\ng\fg"+
		"\16g\u060c\13g\5g\u060e\ng\3g\3g\3h\3h\3i\3i\3j\3j\3j\3k\3k\3k\7k\u061c"+
		"\nk\fk\16k\u061f\13k\3l\3l\5l\u0623\nl\3l\3l\5l\u0627\nl\3l\3l\5l\u062b"+
		"\nl\3l\5l\u062e\nl\3l\5l\u0631\nl\3l\3l\3m\3m\5m\u0637\nm\3m\3m\5m\u063b"+
		"\nm\3m\3m\5m\u063f\nm\5m\u0641\nm\3m\3m\5m\u0645\nm\3m\3m\5m\u0649\nm"+
		"\3m\3m\5m\u064d\nm\5m\u064f\nm\3m\3m\5m\u0653\nm\3m\3m\5m\u0657\nm\3m"+
		"\3m\3n\3n\5n\u065d\nn\3n\3n\3o\3o\5o\u0663\no\3o\6o\u0666\no\ro\16o\u0667"+
		"\3o\3o\5o\u066c\no\3o\3o\5o\u0670\no\3o\6o\u0673\no\ro\16o\u0674\5o\u0677"+
		"\no\3o\5o\u067a\no\3o\3o\5o\u067e\no\3o\5o\u0681\no\3o\5o\u0684\no\3o"+
		"\3o\3p\3p\5p\u068a\np\3p\3p\5p\u068e\np\3p\3p\5p\u0692\np\3p\3p\3q\3q"+
		"\3r\3r\5r\u069a\nr\3s\3s\5s\u069e\ns\3s\3s\5s\u06a2\ns\3s\3s\5s\u06a6"+
		"\ns\3s\3s\5s\u06aa\ns\3s\3s\5s\u06ae\ns\3s\3s\5s\u06b2\ns\3s\3s\5s\u06b6"+
		"\ns\3s\3s\5s\u06ba\ns\7s\u06bc\ns\fs\16s\u06bf\13s\5s\u06c1\ns\3s\3s\3"+
		"t\3t\3t\5t\u06c8\nt\3u\3u\5u\u06cc\nu\3u\6u\u06cf\nu\ru\16u\u06d0\3v\3"+
		"v\3w\3w\3x\3x\3y\3y\5y\u06db\ny\3z\3z\3{\3{\3|\3|\3}\3}\3~\3~\3~\2\2\177"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec"+
		"\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\2\f\3\2\\_\3\2\21\22\3\2op"+
		"\3\2y{\3\2\u0083\u0084\6\2FRUjov\u0085\u008e\6\2kn||\u008f\u0091\u0094"+
		"\u0094\4\2\27\27\35 \4\2\30\30!$\4\2\22\22%/\2\u07c7\2\u00fe\3\2\2\2\4"+
		"\u0101\3\2\2\2\6\u0122\3\2\2\2\b\u012e\3\2\2\2\n\u0130\3\2\2\2\f\u0156"+
		"\3\2\2\2\16\u015a\3\2\2\2\20\u015c\3\2\2\2\22\u015e\3\2\2\2\24\u0160\3"+
		"\2\2\2\26\u0176\3\2\2\2\30\u0178\3\2\2\2\32\u017c\3\2\2\2\34\u017e\3\2"+
		"\2\2\36\u0180\3\2\2\2 \u0185\3\2\2\2\"\u0187\3\2\2\2$\u018d\3\2\2\2&\u0193"+
		"\3\2\2\2(\u0195\3\2\2\2*\u0197\3\2\2\2,\u01a0\3\2\2\2.\u01a2\3\2\2\2\60"+
		"\u01a4\3\2\2\2\62\u01a6\3\2\2\2\64\u01a9\3\2\2\2\66\u01b5\3\2\2\28\u01b7"+
		"\3\2\2\2:\u01bb\3\2\2\2<\u01bd\3\2\2\2>\u01d3\3\2\2\2@\u01d7\3\2\2\2B"+
		"\u01fc\3\2\2\2D\u0214\3\2\2\2F\u021f\3\2\2\2H\u0224\3\2\2\2J\u0228\3\2"+
		"\2\2L\u0235\3\2\2\2N\u023f\3\2\2\2P\u0255\3\2\2\2R\u0257\3\2\2\2T\u025d"+
		"\3\2\2\2V\u028d\3\2\2\2X\u0291\3\2\2\2Z\u02a5\3\2\2\2\\\u02b9\3\2\2\2"+
		"^\u02bb\3\2\2\2`\u02c6\3\2\2\2b\u02e1\3\2\2\2d\u02ee\3\2\2\2f\u02f2\3"+
		"\2\2\2h\u02fa\3\2\2\2j\u0301\3\2\2\2l\u032d\3\2\2\2n\u0336\3\2\2\2p\u0338"+
		"\3\2\2\2r\u0347\3\2\2\2t\u034b\3\2\2\2v\u034f\3\2\2\2x\u0356\3\2\2\2z"+
		"\u035a\3\2\2\2|\u0373\3\2\2\2~\u0375\3\2\2\2\u0080\u0385\3\2\2\2\u0082"+
		"\u0387\3\2\2\2\u0084\u039f\3\2\2\2\u0086\u03e5\3\2\2\2\u0088\u03e7\3\2"+
		"\2\2\u008a\u0404\3\2\2\2\u008c\u0406\3\2\2\2\u008e\u041b\3\2\2\2\u0090"+
		"\u0425\3\2\2\2\u0092\u042b\3\2\2\2\u0094\u0441\3\2\2\2\u0096\u0443\3\2"+
		"\2\2\u0098\u0445\3\2\2\2\u009a\u0447\3\2\2\2\u009c\u0451\3\2\2\2\u009e"+
		"\u045b\3\2\2\2\u00a0\u046b\3\2\2\2\u00a2\u0470\3\2\2\2\u00a4\u047a\3\2"+
		"\2\2\u00a6\u0490\3\2\2\2\u00a8\u04ae\3\2\2\2\u00aa\u04c2\3\2\2\2\u00ac"+
		"\u04c7\3\2\2\2\u00ae\u04e9\3\2\2\2\u00b0\u04f5\3\2\2\2\u00b2\u0506\3\2"+
		"\2\2\u00b4\u0508\3\2\2\2\u00b6\u0566\3\2\2\2\u00b8\u056e\3\2\2\2\u00ba"+
		"\u0570\3\2\2\2\u00bc\u0572\3\2\2\2\u00be\u05a9\3\2\2\2\u00c0\u05ab\3\2"+
		"\2\2\u00c2\u05b5\3\2\2\2\u00c4\u05be\3\2\2\2\u00c6\u05c5\3\2\2\2\u00c8"+
		"\u05cb\3\2\2\2\u00ca\u05f2\3\2\2\2\u00cc\u05f4\3\2\2\2\u00ce\u0611\3\2"+
		"\2\2\u00d0\u0613\3\2\2\2\u00d2\u0615\3\2\2\2\u00d4\u061d\3\2\2\2\u00d6"+
		"\u0620\3\2\2\2\u00d8\u0634\3\2\2\2\u00da\u065a\3\2\2\2\u00dc\u0676\3\2"+
		"\2\2\u00de\u0687\3\2\2\2\u00e0\u0695\3\2\2\2\u00e2\u0699\3\2\2\2\u00e4"+
		"\u069b\3\2\2\2\u00e6\u06c4\3\2\2\2\u00e8\u06c9\3\2\2\2\u00ea\u06d2\3\2"+
		"\2\2\u00ec\u06d4\3\2\2\2\u00ee\u06d6\3\2\2\2\u00f0\u06da\3\2\2\2\u00f2"+
		"\u06dc\3\2\2\2\u00f4\u06de\3\2\2\2\u00f6\u06e0\3\2\2\2\u00f8\u06e2\3\2"+
		"\2\2\u00fa\u06e4\3\2\2\2\u00fc\u00ff\5\4\3\2\u00fd\u00ff\5\6\4\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\3\3\2\2\2\u0100\u0102\7\u0095"+
		"\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0105\7\60\2\2\u0104\u0106\7\u0095\2\2\u0105\u0104\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\7\62\2\2\u0108\u010a\7\u0095"+
		"\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010d\5\b\5\2\u010c\u010e\7\u0095\2\2\u010d\u010c\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\7\3\2\2\u0110\u0112\7\u0095\2"+
		"\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115"+
		"\5\n\6\2\u0114\u0116\7\u0095\2\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2"+
		"\2\u0116\u0117\3\2\2\2\u0117\u0119\5\66\34\2\u0118\u011a\7\u0095\2\2\u0119"+
		"\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\5\24"+
		"\13\2\u011c\u011e\7\u0095\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2"+
		"\u011e\u011f\3\2\2\2\u011f\u0120\7\4\2\2\u0120\5\3\2\2\2\u0121\u0123\7"+
		"\u0095\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2"+
		"\u0124\u0126\7\61\2\2\u0125\u0127\7\u0095\2\2\u0126\u0125\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\7\62\2\2\u0129\u012b\7"+
		"\u0095\2\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2"+
		"\u012c\u012d\5\b\5\2\u012d\7\3\2\2\2\u012e\u012f\7@\2\2\u012f\t\3\2\2"+
		"\2\u0130\u0132\7\63\2\2\u0131\u0133\7\u0095\2\2\u0132\u0131\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\7\65\2\2\u0135\u0137\7"+
		"\u0095\2\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2"+
		"\u0138\u013a\5\f\7\2\u0139\u013b\7\u0095\2\2\u013a\u0139\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\7<\2\2\u013d\u013f\7\u0095"+
		"\2\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u0142\7\63\2\2\u0141\u0143\7\u0095\2\2\u0142\u0141\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\5,\27\2\u0145\u0147\7\u0095\2"+
		"\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a"+
		"\7U\2\2\u0149\u014b\7\u0095\2\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2"+
		"\2\u014b\u014c\3\2\2\2\u014c\u014e\7\66\2\2\u014d\u014f\7\u0095\2\2\u014e"+
		"\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\79"+
		"\2\2\u0151\u0153\7\u0095\2\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0155\5\16\b\2\u0155\13\3\2\2\2\u0156\u0157\5\30"+
		"\r\2\u0157\r\3\2\2\2\u0158\u015b\5\20\t\2\u0159\u015b\5\22\n\2\u015a\u0158"+
		"\3\2\2\2\u015a\u0159\3\2\2\2\u015b\17\3\2\2\2\u015c\u015d\5*\26\2\u015d"+
		"\21\3\2\2\2\u015e\u015f\5(\25\2\u015f\23\3\2\2\2\u0160\u0162\7\67\2\2"+
		"\u0161\u0163\7\u0095\2\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0166\5 \21\2\u0165\u0167\7\u0095\2\2\u0166\u0165"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\7:\2\2\u0169"+
		"\u016b\7\u0095\2\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c"+
		"\3\2\2\2\u016c\u016e\5\32\16\2\u016d\u016f\7\u0095\2\2\u016e\u016d\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\7\64\2\2\u0171"+
		"\u0173\7\u0095\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174\u0175\5\26\f\2\u0175\25\3\2\2\2\u0176\u0177\5\30\r\2\u0177"+
		"\27\3\2\2\2\u0178\u0179\7@\2\2\u0179\31\3\2\2\2\u017a\u017d\5\34\17\2"+
		"\u017b\u017d\5\36\20\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\33"+
		"\3\2\2\2\u017e\u017f\5*\26\2\u017f\35\3\2\2\2\u0180\u0181\5(\25\2\u0181"+
		"\37\3\2\2\2\u0182\u0186\5\"\22\2\u0183\u0186\5$\23\2\u0184\u0186\5&\24"+
		"\2\u0185\u0182\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2\2\2\u0186!"+
		"\3\2\2\2\u0187\u0189\7M\2\2\u0188\u018a\7\u0095\2\2\u0189\u0188\3\2\2"+
		"\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\7=\2\2\u018c#\3"+
		"\2\2\2\u018d\u018f\7M\2\2\u018e\u0190\7\u0095\2\2\u018f\u018e\3\2\2\2"+
		"\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\7?\2\2\u0192%\3\2"+
		"\2\2\u0193\u0194\7>\2\2\u0194\'\3\2\2\2\u0195\u0196\7A\2\2\u0196)\3\2"+
		"\2\2\u0197\u0199\5\u00ecw\2\u0198\u019a\7\u0095\2\2\u0199\u0198\3\2\2"+
		"\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\7C\2\2\u019c+\3"+
		"\2\2\2\u019d\u01a1\5.\30\2\u019e\u01a1\5\60\31\2\u019f\u01a1\5\62\32\2"+
		"\u01a0\u019d\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1-\3"+
		"\2\2\2\u01a2\u01a3\7E\2\2\u01a3/\3\2\2\2\u01a4\u01a5\7D\2\2\u01a5\61\3"+
		"\2\2\2\u01a6\u01a7\7B\2\2\u01a7\63\3\2\2\2\u01a8\u01aa\7\u0095\2\2\u01a9"+
		"\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01b0\58"+
		"\35\2\u01ac\u01ae\7\u0095\2\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2"+
		"\u01ae\u01af\3\2\2\2\u01af\u01b1\7\5\2\2\u01b0\u01ad\3\2\2\2\u01b0\u01b1"+
		"\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b4\7\u0095\2\2\u01b3\u01b2\3\2\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4\65\3\2\2\2\u01b5\u01b6\5\64\33\2\u01b6\67"+
		"\3\2\2\2\u01b7\u01b8\5:\36\2\u01b89\3\2\2\2\u01b9\u01bc\5<\37\2\u01ba"+
		"\u01bc\5`\61\2\u01bb\u01b9\3\2\2\2\u01bb\u01ba\3\2\2\2\u01bc;\3\2\2\2"+
		"\u01bd\u01c4\5@!\2\u01be\u01c0\7\u0095\2\2\u01bf\u01be\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c3\5> \2\u01c2\u01bf\3\2\2\2\u01c3"+
		"\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5=\3\2\2\2"+
		"\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7F\2\2\u01c8\u01c9\7\u0095\2\2\u01c9"+
		"\u01cb\7G\2\2\u01ca\u01cc\7\u0095\2\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d4\5@!\2\u01ce\u01d0\7F\2\2\u01cf"+
		"\u01d1\7\u0095\2\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2"+
		"\3\2\2\2\u01d2\u01d4\5@!\2\u01d3\u01c7\3\2\2\2\u01d3\u01ce\3\2\2\2\u01d4"+
		"?\3\2\2\2\u01d5\u01d8\5B\"\2\u01d6\u01d8\5D#\2\u01d7\u01d5\3\2\2\2\u01d7"+
		"\u01d6\3\2\2\2\u01d8A\3\2\2\2\u01d9\u01db\5H%\2\u01da\u01dc\7\u0095\2"+
		"\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01d9"+
		"\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e2\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01fd\5h\65\2\u01e3\u01e5\5H"+
		"%\2\u01e4\u01e6\7\u0095\2\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e8\3\2\2\2\u01e7\u01e3\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec"+
		"\u01f3\5F$\2\u01ed\u01ef\7\u0095\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3"+
		"\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\5F$\2\u01f1\u01ee\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01fa\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f8\7\u0095\2\2\u01f7\u01f6\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\5h\65\2\u01fa\u01f7\3\2"+
		"\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01df\3\2\2\2\u01fc"+
		"\u01e9\3\2\2\2\u01fdC\3\2\2\2\u01fe\u0200\5H%\2\u01ff\u0201\7\u0095\2"+
		"\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u01fe"+
		"\3\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u020d\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u0209\5F$\2\u0208\u020a\7\u0095"+
		"\2\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b"+
		"\u0207\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2"+
		"\2\2\u020e\u0210\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0212\5f\64\2\u0211"+
		"\u0213\7\u0095\2\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0215"+
		"\3\2\2\2\u0214\u0204\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\5B\"\2\u0219E\3\2\2\2\u021a"+
		"\u0220\5R*\2\u021b\u0220\5N(\2\u021c\u0220\5X-\2\u021d\u0220\5T+\2\u021e"+
		"\u0220\5Z.\2\u021f\u021a\3\2\2\2\u021f\u021b\3\2\2\2\u021f\u021c\3\2\2"+
		"\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220G\3\2\2\2\u0221\u0225"+
		"\5J&\2\u0222\u0225\5L\'\2\u0223\u0225\5^\60\2\u0224\u0221\3\2\2\2\u0224"+
		"\u0222\3\2\2\2\u0224\u0223\3\2\2\2\u0225I\3\2\2\2\u0226\u0227\7H\2\2\u0227"+
		"\u0229\7\u0095\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a"+
		"\3\2\2\2\u022a\u022c\7I\2\2\u022b\u022d\7\u0095\2\2\u022c\u022b\3\2\2"+
		"\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0233\5z>\2\u022f\u0231"+
		"\7\u0095\2\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2"+
		"\2\u0232\u0234\5x=\2\u0233\u0230\3\2\2\2\u0233\u0234\3\2\2\2\u0234K\3"+
		"\2\2\2\u0235\u0237\7J\2\2\u0236\u0238\7\u0095\2\2\u0237\u0236\3\2\2\2"+
		"\u0237\u0238\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\5\u0098M\2\u023a"+
		"\u023b\7\u0095\2\2\u023b\u023c\7K\2\2\u023c\u023d\7\u0095\2\2\u023d\u023e"+
		"\5\u00e0q\2\u023eM\3\2\2\2\u023f\u0241\7L\2\2\u0240\u0242\7\u0095\2\2"+
		"\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0248"+
		"\5|?\2\u0244\u0245\7\u0095\2\2\u0245\u0247\5P)\2\u0246\u0244\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249O\3\2\2\2"+
		"\u024a\u0248\3\2\2\2\u024b\u024c\7M\2\2\u024c\u024d\7\u0095\2\2\u024d"+
		"\u024e\7I\2\2\u024e\u024f\7\u0095\2\2\u024f\u0256\5T+\2\u0250\u0251\7"+
		"M\2\2\u0251\u0252\7\u0095\2\2\u0252\u0253\7N\2\2\u0253\u0254\7\u0095\2"+
		"\2\u0254\u0256\5T+\2\u0255\u024b\3\2\2\2\u0255\u0250\3\2\2\2\u0256Q\3"+
		"\2\2\2\u0257\u0259\7N\2\2\u0258\u025a\7\u0095\2\2\u0259\u0258\3\2\2\2"+
		"\u0259\u025a\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u025c\5z>\2\u025cS\3\2"+
		"\2\2\u025d\u025f\7O\2\2\u025e\u0260\7\u0095\2\2\u025f\u025e\3\2\2\2\u025f"+
		"\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0266\5V,\2\u0262\u0263\7\6\2"+
		"\2\u0263\u0265\5V,\2\u0264\u0262\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267U\3\2\2\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026b\5\u00e8u\2\u026a\u026c\7\u0095\2\2\u026b\u026a\3\2\2\2\u026b\u026c"+
		"\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026f\7\7\2\2\u026e\u0270\7\u0095\2"+
		"\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272"+
		"\5\u0098M\2\u0272\u028e\3\2\2\2\u0273\u0275\5\u00e0q\2\u0274\u0276\7\u0095"+
		"\2\2\u0275\u0274\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0277\3\2\2\2\u0277"+
		"\u0279\7\7\2\2\u0278\u027a\7\u0095\2\2\u0279\u0278\3\2\2\2\u0279\u027a"+
		"\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\5\u0098M\2\u027c\u028e\3\2\2"+
		"\2\u027d\u027f\5\u00e0q\2\u027e\u0280\7\u0095\2\2\u027f\u027e\3\2\2\2"+
		"\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0283\7\b\2\2\u0282\u0284"+
		"\7\u0095\2\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2"+
		"\2\u0285\u0286\5\u0098M\2\u0286\u028e\3\2\2\2\u0287\u0289\5\u00e0q\2\u0288"+
		"\u028a\7\u0095\2\2\u0289\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b"+
		"\3\2\2\2\u028b\u028c\5\u008eH\2\u028c\u028e\3\2\2\2\u028d\u0269\3\2\2"+
		"\2\u028d\u0273\3\2\2\2\u028d\u027d\3\2\2\2\u028d\u0287\3\2\2\2\u028eW"+
		"\3\2\2\2\u028f\u0290\7P\2\2\u0290\u0292\7\u0095\2\2\u0291\u028f\3\2\2"+
		"\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0295\7Q\2\2\u0294\u0296"+
		"\7\u0095\2\2\u0295\u0294\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\3\2\2"+
		"\2\u0297\u02a2\5\u0098M\2\u0298\u029a\7\u0095\2\2\u0299\u0298\3\2\2\2"+
		"\u0299\u029a\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d\7\6\2\2\u029c\u029e"+
		"\7\u0095\2\2\u029d\u029c\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2\2"+
		"\2\u029f\u02a1\5\u0098M\2\u02a0\u0299\3\2\2\2\u02a1\u02a4\3\2\2\2\u02a2"+
		"\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3Y\3\2\2\2\u02a4\u02a2\3\2\2\2"+
		"\u02a5\u02a6\7R\2\2\u02a6\u02a7\7\u0095\2\2\u02a7\u02b2\5\\/\2\u02a8\u02aa"+
		"\7\u0095\2\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab\3\2\2"+
		"\2\u02ab\u02ad\7\6\2\2\u02ac\u02ae\7\u0095\2\2\u02ad\u02ac\3\2\2\2\u02ad"+
		"\u02ae\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\5\\/\2\u02b0\u02a9\3\2"+
		"\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3"+
		"[\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02b6\5\u00e0q\2\u02b6\u02b7\5\u008e"+
		"H\2\u02b7\u02ba\3\2\2\2\u02b8\u02ba\5\u00e8u\2\u02b9\u02b5\3\2\2\2\u02b9"+
		"\u02b8\3\2\2\2\u02ba]\3\2\2\2\u02bb\u02bc\7S\2\2\u02bc\u02bd\7\u0095\2"+
		"\2\u02bd\u02c4\5\u00ccg\2\u02be\u02c0\7\u0095\2\2\u02bf\u02be\3\2\2\2"+
		"\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\7T\2\2\u02c2\u02c3"+
		"\7\u0095\2\2\u02c3\u02c5\5b\62\2\u02c4\u02bf\3\2\2\2\u02c4\u02c5\3\2\2"+
		"\2\u02c5_\3\2\2\2\u02c6\u02c7\7S\2\2\u02c7\u02ca\7\u0095\2\2\u02c8\u02cb"+
		"\5\u00ccg\2\u02c9\u02cb\5\u00ceh\2\u02ca\u02c8\3\2\2\2\u02ca\u02c9\3\2"+
		"\2\2\u02cb\u02d0\3\2\2\2\u02cc\u02cd\7\u0095\2\2\u02cd\u02ce\7T\2\2\u02ce"+
		"\u02cf\7\u0095\2\2\u02cf\u02d1\5b\62\2\u02d0\u02cc\3\2\2\2\u02d0\u02d1"+
		"\3\2\2\2\u02d1a\3\2\2\2\u02d2\u02e2\7\t\2\2\u02d3\u02de\5d\63\2\u02d4"+
		"\u02d6\7\u0095\2\2\u02d5\u02d4\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7"+
		"\3\2\2\2\u02d7\u02d9\7\6\2\2\u02d8\u02da\7\u0095\2\2\u02d9\u02d8\3\2\2"+
		"\2\u02d9\u02da\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dd\5d\63\2\u02dc\u02d5"+
		"\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2\2\2\u02de\u02df\3\2\2\2\u02df"+
		"\u02e2\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1\u02d2\3\2\2\2\u02e1\u02d3\3\2"+
		"\2\2\u02e2\u02e7\3\2\2\2\u02e3\u02e5\7\u0095\2\2\u02e4\u02e3\3\2\2\2\u02e4"+
		"\u02e5\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e8\5x=\2\u02e7\u02e4\3\2\2"+
		"\2\u02e7\u02e8\3\2\2\2\u02e8c\3\2\2\2\u02e9\u02ea\5\u00d0i\2\u02ea\u02eb"+
		"\7\u0095\2\2\u02eb\u02ec\7K\2\2\u02ec\u02ed\7\u0095\2\2\u02ed\u02ef\3"+
		"\2\2\2\u02ee\u02e9\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0"+
		"\u02f1\5\u00e0q\2\u02f1e\3\2\2\2\u02f2\u02f3\7U\2\2\u02f3\u02f8\5j\66"+
		"\2\u02f4\u02f6\7\u0095\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6"+
		"\u02f7\3\2\2\2\u02f7\u02f9\5x=\2\u02f8\u02f5\3\2\2\2\u02f8\u02f9\3\2\2"+
		"\2\u02f9g\3\2\2\2\u02fa\u02fb\7V\2\2\u02fb\u02fc\5j\66\2\u02fci\3\2\2"+
		"\2\u02fd\u02ff\7\u0095\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff"+
		"\u0300\3\2\2\2\u0300\u0302\7W\2\2\u0301\u02fe\3\2\2\2\u0301\u0302\3\2"+
		"\2\2\u0302\u0303\3\2\2\2\u0303\u0304\7\u0095\2\2\u0304\u0307\5l\67\2\u0305"+
		"\u0306\7\u0095\2\2\u0306\u0308\5p9\2\u0307\u0305\3\2\2\2\u0307\u0308\3"+
		"\2\2\2\u0308\u030b\3\2\2\2\u0309\u030a\7\u0095\2\2\u030a\u030c\5r:\2\u030b"+
		"\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030e\7\u0095"+
		"\2\2\u030e\u0310\5t;\2\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310k"+
		"\3\2\2\2\u0311\u031c\7\t\2\2\u0312\u0314\7\u0095\2\2\u0313\u0312\3\2\2"+
		"\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0317\7\6\2\2\u0316\u0318"+
		"\7\u0095\2\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\3\2\2"+
		"\2\u0319\u031b\5n8\2\u031a\u0313\3\2\2\2\u031b\u031e\3\2\2\2\u031c\u031a"+
		"\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u032e\3\2\2\2\u031e\u031c\3\2\2\2\u031f"+
		"\u032a\5n8\2\u0320\u0322\7\u0095\2\2\u0321\u0320\3\2\2\2\u0321\u0322\3"+
		"\2\2\2\u0322\u0323\3\2\2\2\u0323\u0325\7\6\2\2\u0324\u0326\7\u0095\2\2"+
		"\u0325\u0324\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0329"+
		"\5n8\2\u0328\u0321\3\2\2\2\u0329\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032a"+
		"\u032b\3\2\2\2\u032b\u032e\3\2\2\2\u032c\u032a\3\2\2\2\u032d\u0311\3\2"+
		"\2\2\u032d\u031f\3\2\2\2\u032em\3\2\2\2\u032f\u0330\5\u0098M\2\u0330\u0331"+
		"\7\u0095\2\2\u0331\u0332\7K\2\2\u0332\u0333\7\u0095\2\2\u0333\u0334\5"+
		"\u00e0q\2\u0334\u0337\3\2\2\2\u0335\u0337\5\u0098M\2\u0336\u032f\3\2\2"+
		"\2\u0336\u0335\3\2\2\2\u0337o\3\2\2\2\u0338\u0339\7X\2\2\u0339\u033a\7"+
		"\u0095\2\2\u033a\u033b\7Y\2\2\u033b\u033c\7\u0095\2\2\u033c\u0344\5v<"+
		"\2\u033d\u033f\7\6\2\2\u033e\u0340\7\u0095\2\2\u033f\u033e\3\2\2\2\u033f"+
		"\u0340\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0343\5v<\2\u0342\u033d\3\2\2"+
		"\2\u0343\u0346\3\2\2\2\u0344\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345q"+
		"\3\2\2\2\u0346\u0344\3\2\2\2\u0347\u0348\7Z\2\2\u0348\u0349\7\u0095\2"+
		"\2\u0349\u034a\5\u0098M\2\u034as\3\2\2\2\u034b\u034c\7[\2\2\u034c\u034d"+
		"\7\u0095\2\2\u034d\u034e\5\u0098M\2\u034eu\3\2\2\2\u034f\u0354\5\u0098"+
		"M\2\u0350\u0352\7\u0095\2\2\u0351\u0350\3\2\2\2\u0351\u0352\3\2\2\2\u0352"+
		"\u0353\3\2\2\2\u0353\u0355\t\2\2\2\u0354\u0351\3\2\2\2\u0354\u0355\3\2"+
		"\2\2\u0355w\3\2\2\2\u0356\u0357\7`\2\2\u0357\u0358\7\u0095\2\2\u0358\u0359"+
		"\5\u0098M\2\u0359y\3\2\2\2\u035a\u0365\5|?\2\u035b\u035d\7\u0095\2\2\u035c"+
		"\u035b\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0360\7\6"+
		"\2\2\u035f\u0361\7\u0095\2\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0362\3\2\2\2\u0362\u0364\5|?\2\u0363\u035c\3\2\2\2\u0364\u0367\3\2\2"+
		"\2\u0365\u0363\3\2\2\2\u0365\u0366\3\2\2\2\u0366{\3\2\2\2\u0367\u0365"+
		"\3\2\2\2\u0368\u036a\5\u00e0q\2\u0369\u036b\7\u0095\2\2\u036a\u0369\3"+
		"\2\2\2\u036a\u036b\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036e\7\n\2\2\u036d"+
		"\u036f\7\u0095\2\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370"+
		"\3\2\2\2\u0370\u0371\5~@\2\u0371\u0374\3\2\2\2\u0372\u0374\5~@\2\u0373"+
		"\u0368\3\2\2\2\u0373\u0372\3\2\2\2\u0374}\3\2\2\2\u0375\u0376\5\u0080"+
		"A\2\u0376\177\3\2\2\2\u0377\u037e\5\u0082B\2\u0378\u037a\7\u0095\2\2\u0379"+
		"\u0378\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037d\5\u0084"+
		"C\2\u037c\u0379\3\2\2\2\u037d\u0380\3\2\2\2\u037e\u037c\3\2\2\2\u037e"+
		"\u037f\3\2\2\2\u037f\u0386\3\2\2\2\u0380\u037e\3\2\2\2\u0381\u0382\7\13"+
		"\2\2\u0382\u0383\5\u0080A\2\u0383\u0384\7\f\2\2\u0384\u0386\3\2\2\2\u0385"+
		"\u0377\3\2\2\2\u0385\u0381\3\2\2\2\u0386\u0081\3\2\2\2\u0387\u0389\7\13"+
		"\2\2\u0388\u038a\7\u0095\2\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2\u038a"+
		"\u038f\3\2\2\2\u038b\u038d\5\u00e0q\2\u038c\u038e\7\u0095\2\2\u038d\u038c"+
		"\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u0390\3\2\2\2\u038f\u038b\3\2\2\2\u038f"+
		"\u0390\3\2\2\2\u0390\u0395\3\2\2\2\u0391\u0393\5\u008eH\2\u0392\u0394"+
		"\7\u0095\2\2\u0393\u0392\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0396\3\2\2"+
		"\2\u0395\u0391\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u039b\3\2\2\2\u0397\u0399"+
		"\5\u008aF\2\u0398\u039a\7\u0095\2\2\u0399\u0398\3\2\2\2\u0399\u039a\3"+
		"\2\2\2\u039a\u039c\3\2\2\2\u039b\u0397\3\2\2\2\u039b\u039c\3\2\2\2\u039c"+
		"\u039d\3\2\2\2\u039d\u039e\7\f\2\2\u039e\u0083\3\2\2\2\u039f\u03a1\5\u0086"+
		"D\2\u03a0\u03a2\7\u0095\2\2\u03a1\u03a0\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2"+
		"\u03a3\3\2\2\2\u03a3\u03a4\5\u0082B\2\u03a4\u0085\3\2\2\2\u03a5\u03a7"+
		"\5\u00f6|\2\u03a6\u03a8\7\u0095\2\2\u03a7\u03a6\3\2\2\2\u03a7\u03a8\3"+
		"\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\5\u00fa~\2\u03aa\u03ac\7\u0095"+
		"\2\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ae\3\2\2\2\u03ad"+
		"\u03af\5\u0088E\2\u03ae\u03ad\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b1"+
		"\3\2\2\2\u03b0\u03b2\7\u0095\2\2\u03b1\u03b0\3\2\2\2\u03b1\u03b2\3\2\2"+
		"\2\u03b2\u03b3\3\2\2\2\u03b3\u03b5\5\u00fa~\2\u03b4\u03b6\7\u0095\2\2"+
		"\u03b5\u03b4\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b8"+
		"\5\u00f8}\2\u03b8\u03e6\3\2\2\2\u03b9\u03bb\5\u00f6|\2\u03ba\u03bc\7\u0095"+
		"\2\2\u03bb\u03ba\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd"+
		"\u03bf\5\u00fa~\2\u03be\u03c0\7\u0095\2\2\u03bf\u03be\3\2\2\2\u03bf\u03c0"+
		"\3\2\2\2\u03c0\u03c2\3\2\2\2\u03c1\u03c3\5\u0088E\2\u03c2\u03c1\3\2\2"+
		"\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\3\2\2\2\u03c4\u03c6\7\u0095\2\2\u03c5"+
		"\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c8\5\u00fa"+
		"~\2\u03c8\u03e6\3\2\2\2\u03c9\u03cb\5\u00fa~\2\u03ca\u03cc\7\u0095\2\2"+
		"\u03cb\u03ca\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03ce\3\2\2\2\u03cd\u03cf"+
		"\5\u0088E\2\u03ce\u03cd\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d1\3\2\2"+
		"\2\u03d0\u03d2\7\u0095\2\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2"+
		"\u03d3\3\2\2\2\u03d3\u03d5\5\u00fa~\2\u03d4\u03d6\7\u0095\2\2\u03d5\u03d4"+
		"\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d8\5\u00f8}"+
		"\2\u03d8\u03e6\3\2\2\2\u03d9\u03db\5\u00fa~\2\u03da\u03dc\7\u0095\2\2"+
		"\u03db\u03da\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03de\3\2\2\2\u03dd\u03df"+
		"\5\u0088E\2\u03de\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e1\3\2\2"+
		"\2\u03e0\u03e2\7\u0095\2\2\u03e1\u03e0\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2"+
		"\u03e3\3\2\2\2\u03e3\u03e4\5\u00fa~\2\u03e4\u03e6\3\2\2\2\u03e5\u03a5"+
		"\3\2\2\2\u03e5\u03b9\3\2\2\2\u03e5\u03c9\3\2\2\2\u03e5\u03d9\3\2\2\2\u03e6"+
		"\u0087\3\2\2\2\u03e7\u03e9\7\r\2\2\u03e8\u03ea\7\u0095\2\2\u03e9\u03e8"+
		"\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03ef\3\2\2\2\u03eb\u03ed\5\u00e0q"+
		"\2\u03ec\u03ee\7\u0095\2\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee"+
		"\u03f0\3\2\2\2\u03ef\u03eb\3\2\2\2\u03ef\u03f0\3\2\2\2\u03f0\u03f5\3\2"+
		"\2\2\u03f1\u03f3\5\u008cG\2\u03f2\u03f4\7\u0095\2\2\u03f3\u03f2\3\2\2"+
		"\2\u03f3\u03f4\3\2\2\2\u03f4\u03f6\3\2\2\2\u03f5\u03f1\3\2\2\2\u03f5\u03f6"+
		"\3\2\2\2\u03f6\u03f8\3\2\2\2\u03f7\u03f9\5\u0092J\2\u03f8\u03f7\3\2\2"+
		"\2\u03f8\u03f9\3\2\2\2\u03f9\u03fe\3\2\2\2\u03fa\u03fc\5\u008aF\2\u03fb"+
		"\u03fd\7\u0095\2\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03ff"+
		"\3\2\2\2\u03fe\u03fa\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0400\3\2\2\2\u0400"+
		"\u0401\7\16\2\2\u0401\u0089\3\2\2\2\u0402\u0405\5\u00e4s\2\u0403\u0405"+
		"\5\u00e6t\2\u0404\u0402\3\2\2\2\u0404\u0403\3\2\2\2\u0405\u008b\3\2\2"+
		"\2\u0406\u0408\7\n\2\2\u0407\u0409\7\u0095\2\2\u0408\u0407\3\2\2\2\u0408"+
		"\u0409\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u0418\5\u0096L\2\u040b\u040d"+
		"\7\u0095\2\2\u040c\u040b\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u040e\3\2\2"+
		"\2\u040e\u0410\7\17\2\2\u040f\u0411\7\n\2\2\u0410\u040f\3\2\2\2\u0410"+
		"\u0411\3\2\2\2\u0411\u0413\3\2\2\2\u0412\u0414\7\u0095\2\2\u0413\u0412"+
		"\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u0417\5\u0096L"+
		"\2\u0416\u040c\3\2\2\2\u0417\u041a\3\2\2\2\u0418\u0416\3\2\2\2\u0418\u0419"+
		"\3\2\2\2\u0419\u008d\3\2\2\2\u041a\u0418\3\2\2\2\u041b\u0422\5\u0090I"+
		"\2\u041c\u041e\7\u0095\2\2\u041d\u041c\3\2\2\2\u041d\u041e\3\2\2\2\u041e"+
		"\u041f\3\2\2\2\u041f\u0421\5\u0090I\2\u0420\u041d\3\2\2\2\u0421\u0424"+
		"\3\2\2\2\u0422\u0420\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u008f\3\2\2\2\u0424"+
		"\u0422\3\2\2\2\u0425\u0427\7\n\2\2\u0426\u0428\7\u0095\2\2\u0427\u0426"+
		"\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042a\5\u0094K"+
		"\2\u042a\u0091\3\2\2\2\u042b\u042d\7\t\2\2\u042c\u042e\7\u0095\2\2\u042d"+
		"\u042c\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u0433\3\2\2\2\u042f\u0431\5\u00ec"+
		"w\2\u0430\u0432\7\u0095\2\2\u0431\u0430\3\2\2\2\u0431\u0432\3\2\2\2\u0432"+
		"\u0434\3\2\2\2\u0433\u042f\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u043f\3\2"+
		"\2\2\u0435\u0437\7\20\2\2\u0436\u0438\7\u0095\2\2\u0437\u0436\3\2\2\2"+
		"\u0437\u0438\3\2\2\2\u0438\u043d\3\2\2\2\u0439\u043b\5\u00ecw\2\u043a"+
		"\u043c\7\u0095\2\2\u043b\u043a\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043e"+
		"\3\2\2\2\u043d\u0439\3\2\2\2\u043d\u043e\3\2\2\2\u043e\u0440\3\2\2\2\u043f"+
		"\u0435\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0093\3\2\2\2\u0441\u0442\5\u00f0"+
		"y\2\u0442\u0095\3\2\2\2\u0443\u0444\5\u00f0y\2\u0444\u0097\3\2\2\2\u0445"+
		"\u0446\5\u009aN\2\u0446\u0099\3\2\2\2\u0447\u044e\5\u009cO\2\u0448\u0449"+
		"\7\u0095\2\2\u0449\u044a\7a\2\2\u044a\u044b\7\u0095\2\2\u044b\u044d\5"+
		"\u009cO\2\u044c\u0448\3\2\2\2\u044d\u0450\3\2\2\2\u044e\u044c\3\2\2\2"+
		"\u044e\u044f\3\2\2\2\u044f\u009b\3\2\2\2\u0450\u044e\3\2\2\2\u0451\u0458"+
		"\5\u009eP\2\u0452\u0453\7\u0095\2\2\u0453\u0454\7b\2\2\u0454\u0455\7\u0095"+
		"\2\2\u0455\u0457\5\u009eP\2\u0456\u0452\3\2\2\2\u0457\u045a\3\2\2\2\u0458"+
		"\u0456\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u009d\3\2\2\2\u045a\u0458\3\2"+
		"\2\2\u045b\u0462\5\u00a0Q\2\u045c\u045d\7\u0095\2\2\u045d\u045e\7c\2\2"+
		"\u045e\u045f\7\u0095\2\2\u045f\u0461\5\u00a0Q\2\u0460\u045c\3\2\2\2\u0461"+
		"\u0464\3\2\2\2\u0462\u0460\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u009f\3\2"+
		"\2\2\u0464\u0462\3\2\2\2\u0465\u0467\7d\2\2\u0466\u0468\7\u0095\2\2\u0467"+
		"\u0466\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u046a\3\2\2\2\u0469\u0465\3\2"+
		"\2\2\u046a\u046d\3\2\2\2\u046b\u0469\3\2\2\2\u046b\u046c\3\2\2\2\u046c"+
		"\u046e\3\2\2\2\u046d\u046b\3\2\2\2\u046e\u046f\5\u00a2R\2\u046f\u00a1"+
		"\3\2\2\2\u0470\u0477\5\u00a4S\2\u0471\u0473\7\u0095\2\2\u0472\u0471\3"+
		"\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0476\5\u00be`\2"+
		"\u0475\u0472\3\2\2\2\u0476\u0479\3\2\2\2\u0477\u0475\3\2\2\2\u0477\u0478"+
		"\3\2\2\2\u0478\u00a3\3\2\2\2\u0479\u0477\3\2\2\2\u047a\u048d\5\u00a6T"+
		"\2\u047b\u047d\7\u0095\2\2\u047c\u047b\3\2\2\2\u047c\u047d\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u0480\7\21\2\2\u047f\u0481\7\u0095\2\2\u0480\u047f"+
		"\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u048c\5\u00a6T"+
		"\2\u0483\u0485\7\u0095\2\2\u0484\u0483\3\2\2\2\u0484\u0485\3\2\2\2\u0485"+
		"\u0486\3\2\2\2\u0486\u0488\7\22\2\2\u0487\u0489\7\u0095\2\2\u0488\u0487"+
		"\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048c\5\u00a6T"+
		"\2\u048b\u047c\3\2\2\2\u048b\u0484\3\2\2\2\u048c\u048f\3\2\2\2\u048d\u048b"+
		"\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u00a5\3\2\2\2\u048f\u048d\3\2\2\2\u0490"+
		"\u04ab\5\u00a8U\2\u0491\u0493\7\u0095\2\2\u0492\u0491\3\2\2\2\u0492\u0493"+
		"\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0496\7\t\2\2\u0495\u0497\7\u0095\2"+
		"\2\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0498\3\2\2\2\u0498\u04aa"+
		"\5\u00a8U\2\u0499\u049b\7\u0095\2\2\u049a\u0499\3\2\2\2\u049a\u049b\3"+
		"\2\2\2\u049b\u049c\3\2\2\2\u049c\u049e\7\23\2\2\u049d\u049f\7\u0095\2"+
		"\2\u049e\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04aa"+
		"\5\u00a8U\2\u04a1\u04a3\7\u0095\2\2\u04a2\u04a1\3\2\2\2\u04a2\u04a3\3"+
		"\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a6\7\24\2\2\u04a5\u04a7\7\u0095\2"+
		"\2\u04a6\u04a5\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa"+
		"\5\u00a8U\2\u04a9\u0492\3\2\2\2\u04a9\u049a\3\2\2\2\u04a9\u04a2\3\2\2"+
		"\2\u04aa\u04ad\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u00a7"+
		"\3\2\2\2\u04ad\u04ab\3\2\2\2\u04ae\u04b9\5\u00aaV\2\u04af\u04b1\7\u0095"+
		"\2\2\u04b0\u04af\3\2\2\2\u04b0\u04b1\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2"+
		"\u04b4\7\25\2\2\u04b3\u04b5\7\u0095\2\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5"+
		"\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b8\5\u00aaV\2\u04b7\u04b0\3\2\2"+
		"\2\u04b8\u04bb\3\2\2\2\u04b9\u04b7\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u00a9"+
		"\3\2\2\2\u04bb\u04b9\3\2\2\2\u04bc\u04be\t\3\2\2\u04bd\u04bf\7\u0095\2"+
		"\2\u04be\u04bd\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c1\3\2\2\2\u04c0\u04bc"+
		"\3\2\2\2\u04c1\u04c4\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3"+
		"\u04c5\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c5\u04c6\5\u00acW\2\u04c6\u00ab"+
		"\3\2\2\2\u04c7\u04cd\5\u00b4[\2\u04c8\u04cc\5\u00b0Y\2\u04c9\u04cc\5\u00ae"+
		"X\2\u04ca\u04cc\5\u00b2Z\2\u04cb\u04c8\3\2\2\2\u04cb\u04c9\3\2\2\2\u04cb"+
		"\u04ca\3\2\2\2\u04cc\u04cf\3\2\2\2\u04cd\u04cb\3\2\2\2\u04cd\u04ce\3\2"+
		"\2\2\u04ce\u00ad\3\2\2\2\u04cf\u04cd\3\2\2\2\u04d0\u04d1\7\u0095\2\2\u04d1"+
		"\u04d3\7e\2\2\u04d2\u04d4\7\u0095\2\2\u04d3\u04d2\3\2\2\2\u04d3\u04d4"+
		"\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04ea\5\u00b4[\2\u04d6\u04d8\7\u0095"+
		"\2\2\u04d7\u04d6\3\2\2\2\u04d7\u04d8\3\2\2\2\u04d8\u04d9\3\2\2\2\u04d9"+
		"\u04da\7\r\2\2\u04da\u04db\5\u0098M\2\u04db\u04dc\7\16\2\2\u04dc\u04ea"+
		"\3\2\2\2\u04dd\u04df\7\u0095\2\2\u04de\u04dd\3\2\2\2\u04de\u04df\3\2\2"+
		"\2\u04df\u04e0\3\2\2\2\u04e0\u04e2\7\r\2\2\u04e1\u04e3\5\u0098M\2\u04e2"+
		"\u04e1\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e6\7\20"+
		"\2\2\u04e5\u04e7\5\u0098M\2\u04e6\u04e5\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7"+
		"\u04e8\3\2\2\2\u04e8\u04ea\7\16\2\2\u04e9\u04d0\3\2\2\2\u04e9\u04d7\3"+
		"\2\2\2\u04e9\u04de\3\2\2\2\u04ea\u00af\3\2\2\2\u04eb\u04ec\7\u0095\2\2"+
		"\u04ec\u04ed\7f\2\2\u04ed\u04ee\7\u0095\2\2\u04ee\u04f6\7U\2\2\u04ef\u04f0"+
		"\7\u0095\2\2\u04f0\u04f1\7g\2\2\u04f1\u04f2\7\u0095\2\2\u04f2\u04f6\7"+
		"U\2\2\u04f3\u04f4\7\u0095\2\2\u04f4\u04f6\7h\2\2\u04f5\u04eb\3\2\2\2\u04f5"+
		"\u04ef\3\2\2\2\u04f5\u04f3\3\2\2\2\u04f6\u04f8\3\2\2\2\u04f7\u04f9\7\u0095"+
		"\2\2\u04f8\u04f7\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa"+
		"\u04fb\5\u00b4[\2\u04fb\u00b1\3\2\2\2\u04fc\u04fd\7\u0095\2\2\u04fd\u04fe"+
		"\7i\2\2\u04fe\u04ff\7\u0095\2\2\u04ff\u0507\7j\2\2\u0500\u0501\7\u0095"+
		"\2\2\u0501\u0502\7i\2\2\u0502\u0503\7\u0095\2\2\u0503\u0504\7d\2\2\u0504"+
		"\u0505\7\u0095\2\2\u0505\u0507\7j\2\2\u0506\u04fc\3\2\2\2\u0506\u0500"+
		"\3\2\2\2\u0507\u00b3\3\2\2\2\u0508\u050f\5\u00b6\\\2\u0509\u050b\7\u0095"+
		"\2\2\u050a\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050c\3\2\2\2\u050c"+
		"\u050e\5\u00dan\2\u050d\u050a\3\2\2\2\u050e\u0511\3\2\2\2\u050f\u050d"+
		"\3\2\2\2\u050f\u0510\3\2\2\2\u0510\u0516\3\2\2\2\u0511\u050f\3\2\2\2\u0512"+
		"\u0514\7\u0095\2\2\u0513\u0512\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0515"+
		"\3\2\2\2\u0515\u0517\5\u008eH\2\u0516\u0513\3\2\2\2\u0516\u0517\3\2\2"+
		"\2\u0517\u00b5\3\2\2\2\u0518\u0567\5\u00b8]\2\u0519\u0567\5\u00e6t\2\u051a"+
		"\u0567\5\u00dco\2\u051b\u051d\7k\2\2\u051c\u051e\7\u0095\2\2\u051d\u051c"+
		"\3\2\2\2\u051d\u051e\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0521\7\13\2\2"+
		"\u0520\u0522\7\u0095\2\2\u0521\u0520\3\2\2\2\u0521\u0522\3\2\2\2\u0522"+
		"\u0523\3\2\2\2\u0523\u0525\7\t\2\2\u0524\u0526\7\u0095\2\2\u0525\u0524"+
		"\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0567\7\f\2\2\u0528"+
		"\u0567\5\u00d6l\2\u0529\u0567\5\u00d8m\2\u052a\u052c\7G\2\2\u052b\u052d"+
		"\7\u0095\2\2\u052c\u052b\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052e\3\2\2"+
		"\2\u052e\u0530\7\13\2\2\u052f\u0531\7\u0095\2\2\u0530\u052f\3\2\2\2\u0530"+
		"\u0531\3\2\2\2\u0531\u0532\3\2\2\2\u0532\u0534\5\u00c4c\2\u0533\u0535"+
		"\7\u0095\2\2\u0534\u0533\3\2\2\2\u0534\u0535\3\2\2\2\u0535\u0536\3\2\2"+
		"\2\u0536\u0537\7\f\2\2\u0537\u0567\3\2\2\2\u0538\u053a\7l\2\2\u0539\u053b"+
		"\7\u0095\2\2\u053a\u0539\3\2\2\2\u053a\u053b\3\2\2\2\u053b\u053c\3\2\2"+
		"\2\u053c\u053e\7\13\2\2\u053d\u053f\7\u0095\2\2\u053e\u053d\3\2\2\2\u053e"+
		"\u053f\3\2\2\2\u053f\u0540\3\2\2\2\u0540\u0542\5\u00c4c\2\u0541\u0543"+
		"\7\u0095\2\2\u0542\u0541\3\2\2\2\u0542\u0543\3\2\2\2\u0543\u0544\3\2\2"+
		"\2\u0544\u0545\7\f\2\2\u0545\u0567\3\2\2\2\u0546\u0548\7m\2\2\u0547\u0549"+
		"\7\u0095\2\2\u0548\u0547\3\2\2\2\u0548\u0549\3\2\2\2\u0549\u054a\3\2\2"+
		"\2\u054a\u054c\7\13\2\2\u054b\u054d\7\u0095\2\2\u054c\u054b\3\2\2\2\u054c"+
		"\u054d\3\2\2\2\u054d\u054e\3\2\2\2\u054e\u0550\5\u00c4c\2\u054f\u0551"+
		"\7\u0095\2\2\u0550\u054f\3\2\2\2\u0550\u0551\3\2\2\2\u0551\u0552\3\2\2"+
		"\2\u0552\u0553\7\f\2\2\u0553\u0567\3\2\2\2\u0554\u0556\7n\2\2\u0555\u0557"+
		"\7\u0095\2\2\u0556\u0555\3\2\2\2\u0556\u0557\3\2\2\2\u0557\u0558\3\2\2"+
		"\2\u0558\u055a\7\13\2\2\u0559\u055b\7\u0095\2\2\u055a\u0559\3\2\2\2\u055a"+
		"\u055b\3\2\2\2\u055b\u055c\3\2\2\2\u055c\u055e\5\u00c4c\2\u055d\u055f"+
		"\7\u0095\2\2\u055e\u055d\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u0560\3\2\2"+
		"\2\u0560\u0561\7\f\2\2\u0561\u0567\3\2\2\2\u0562\u0567\5\u00c2b\2\u0563"+
		"\u0567\5\u00c0a\2\u0564\u0567\5\u00c8e\2\u0565\u0567\5\u00e0q\2\u0566"+
		"\u0518\3\2\2\2\u0566\u0519\3\2\2\2\u0566\u051a\3\2\2\2\u0566\u051b\3\2"+
		"\2\2\u0566\u0528\3\2\2\2\u0566\u0529\3\2\2\2\u0566\u052a\3\2\2\2\u0566"+
		"\u0538\3\2\2\2\u0566\u0546\3\2\2\2\u0566\u0554\3\2\2\2\u0566\u0562\3\2"+
		"\2\2\u0566\u0563\3\2\2\2\u0566\u0564\3\2\2\2\u0566\u0565\3\2\2\2\u0567"+
		"\u00b7\3\2\2\2\u0568\u056f\5\u00e2r\2\u0569\u056f\7w\2\2\u056a\u056f\5"+
		"\u00ba^\2\u056b\u056f\7j\2\2\u056c\u056f\5\u00e4s\2\u056d\u056f\5\u00bc"+
		"_\2\u056e\u0568\3\2\2\2\u056e\u0569\3\2\2\2\u056e\u056a\3\2\2\2\u056e"+
		"\u056b\3\2\2\2\u056e\u056c\3\2\2\2\u056e\u056d\3\2\2\2\u056f\u00b9\3\2"+
		"\2\2\u0570\u0571\t\4\2\2\u0571\u00bb\3\2\2\2\u0572\u0574\7\r\2\2\u0573"+
		"\u0575\7\u0095\2\2\u0574\u0573\3\2\2\2\u0574\u0575\3\2\2\2\u0575\u0587"+
		"\3\2\2\2\u0576\u0578\5\u0098M\2\u0577\u0579\7\u0095\2\2\u0578\u0577\3"+
		"\2\2\2\u0578\u0579\3\2\2\2\u0579\u0584\3\2\2\2\u057a\u057c\7\6\2\2\u057b"+
		"\u057d\7\u0095\2\2\u057c\u057b\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u057e"+
		"\3\2\2\2\u057e\u0580\5\u0098M\2\u057f\u0581\7\u0095\2\2\u0580\u057f\3"+
		"\2\2\2\u0580\u0581\3\2\2\2\u0581\u0583\3\2\2\2\u0582\u057a\3\2\2\2\u0583"+
		"\u0586\3\2\2\2\u0584\u0582\3\2\2\2\u0584\u0585\3\2\2\2\u0585\u0588\3\2"+
		"\2\2\u0586\u0584\3\2\2\2\u0587\u0576\3\2\2\2\u0587\u0588\3\2\2\2\u0588"+
		"\u0589\3\2\2\2\u0589\u058a\7\16\2\2\u058a\u00bd\3\2\2\2\u058b\u058d\7"+
		"\7\2\2\u058c\u058e\7\u0095\2\2\u058d\u058c\3\2\2\2\u058d\u058e\3\2\2\2"+
		"\u058e\u058f\3\2\2\2\u058f\u05aa\5\u00a4S\2\u0590\u0592\7\26\2\2\u0591"+
		"\u0593\7\u0095\2\2\u0592\u0591\3\2\2\2\u0592\u0593\3\2\2\2\u0593\u0594"+
		"\3\2\2\2\u0594\u05aa\5\u00a4S\2\u0595\u0597\7\27\2\2\u0596\u0598\7\u0095"+
		"\2\2\u0597\u0596\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u0599\3\2\2\2\u0599"+
		"\u05aa\5\u00a4S\2\u059a\u059c\7\30\2\2\u059b\u059d\7\u0095\2\2\u059c\u059b"+
		"\3\2\2\2\u059c\u059d\3\2\2\2\u059d\u059e\3\2\2\2\u059e\u05aa\5\u00a4S"+
		"\2\u059f\u05a1\7\31\2\2\u05a0\u05a2\7\u0095\2\2\u05a1\u05a0\3\2\2\2\u05a1"+
		"\u05a2\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05aa\5\u00a4S\2\u05a4\u05a6"+
		"\7\32\2\2\u05a5\u05a7\7\u0095\2\2\u05a6\u05a5\3\2\2\2\u05a6\u05a7\3\2"+
		"\2\2\u05a7\u05a8\3\2\2\2\u05a8\u05aa\5\u00a4S\2\u05a9\u058b\3\2\2\2\u05a9"+
		"\u0590\3\2\2\2\u05a9\u0595\3\2\2\2\u05a9\u059a\3\2\2\2\u05a9\u059f\3\2"+
		"\2\2\u05a9\u05a4\3\2\2\2\u05aa\u00bf\3\2\2\2\u05ab\u05ad\7\13\2\2\u05ac"+
		"\u05ae\7\u0095\2\2\u05ad\u05ac\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05af"+
		"\3\2\2\2\u05af\u05b1\5\u0098M\2\u05b0\u05b2\7\u0095\2\2\u05b1\u05b0\3"+
		"\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05b4\7\f\2\2\u05b4"+
		"\u00c1\3\2\2\2\u05b5\u05ba\5\u0082B\2\u05b6\u05b8\7\u0095\2\2\u05b7\u05b6"+
		"\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05bb\5\u0084C"+
		"\2\u05ba\u05b7\3\2\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05ba\3\2\2\2\u05bc\u05bd"+
		"\3\2\2\2\u05bd\u00c3\3\2\2\2\u05be\u05c3\5\u00c6d\2\u05bf\u05c1\7\u0095"+
		"\2\2\u05c0\u05bf\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2"+
		"\u05c4\5x=\2\u05c3\u05c0\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4\u00c5\3\2\2"+
		"\2\u05c5\u05c6\5\u00e0q\2\u05c6\u05c7\7\u0095\2\2\u05c7\u05c8\7e\2\2\u05c8"+
		"\u05c9\7\u0095\2\2\u05c9\u05ca\5\u0098M\2\u05ca\u00c7\3\2\2\2\u05cb\u05cd"+
		"\5\u00caf\2\u05cc\u05ce\7\u0095\2\2\u05cd\u05cc\3\2\2\2\u05cd\u05ce\3"+
		"\2\2\2\u05ce\u05cf\3\2\2\2\u05cf\u05d1\7\13\2\2\u05d0\u05d2\7\u0095\2"+
		"\2\u05d1\u05d0\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2\u05d7\3\2\2\2\u05d3\u05d5"+
		"\7W\2\2\u05d4\u05d6\7\u0095\2\2\u05d5\u05d4\3\2\2\2\u05d5\u05d6\3\2\2"+
		"\2\u05d6\u05d8\3\2\2\2\u05d7\u05d3\3\2\2\2\u05d7\u05d8\3\2\2\2\u05d8\u05ea"+
		"\3\2\2\2\u05d9\u05db\5\u0098M\2\u05da\u05dc\7\u0095\2\2\u05db\u05da\3"+
		"\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05e7\3\2\2\2\u05dd\u05df\7\6\2\2\u05de"+
		"\u05e0\7\u0095\2\2\u05df\u05de\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0\u05e1"+
		"\3\2\2\2\u05e1\u05e3\5\u0098M\2\u05e2\u05e4\7\u0095\2\2\u05e3\u05e2\3"+
		"\2\2\2\u05e3\u05e4\3\2\2\2\u05e4\u05e6\3\2\2\2\u05e5\u05dd\3\2\2\2\u05e6"+
		"\u05e9\3\2\2\2\u05e7\u05e5\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05eb\3\2"+
		"\2\2\u05e9\u05e7\3\2\2\2\u05ea\u05d9\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb"+
		"\u05ec\3\2\2\2\u05ec\u05ed\7\f\2\2\u05ed\u00c9\3\2\2\2\u05ee\u05ef\5\u00d4"+
		"k\2\u05ef\u05f0\5\u00f4{\2\u05f0\u05f3\3\2\2\2\u05f1\u05f3\7q\2\2\u05f2"+
		"\u05ee\3\2\2\2\u05f2\u05f1\3\2\2\2\u05f3\u00cb\3\2\2\2\u05f4\u05f6\5\u00d2"+
		"j\2\u05f5\u05f7\7\u0095\2\2\u05f6\u05f5\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7"+
		"\u05f8\3\2\2\2\u05f8\u05fa\7\13\2\2\u05f9\u05fb\7\u0095\2\2\u05fa\u05f9"+
		"\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u060d\3\2\2\2\u05fc\u05fe\5\u0098M"+
		"\2\u05fd\u05ff\7\u0095\2\2\u05fe\u05fd\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff"+
		"\u060a\3\2\2\2\u0600\u0602\7\6\2\2\u0601\u0603\7\u0095\2\2\u0602\u0601"+
		"\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0604\3\2\2\2\u0604\u0606\5\u0098M"+
		"\2\u0605\u0607\7\u0095\2\2\u0606\u0605\3\2\2\2\u0606\u0607\3\2\2\2\u0607"+
		"\u0609\3\2\2\2\u0608\u0600\3\2\2\2\u0609\u060c\3\2\2\2\u060a\u0608\3\2"+
		"\2\2\u060a\u060b\3\2\2\2\u060b\u060e\3\2\2\2\u060c\u060a\3\2\2\2\u060d"+
		"\u05fc\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u060f\3\2\2\2\u060f\u0610\7\f"+
		"\2\2\u0610\u00cd\3\2\2\2\u0611\u0612\5\u00d2j\2\u0612\u00cf\3\2\2\2\u0613"+
		"\u0614\5\u00f4{\2\u0614\u00d1\3\2\2\2\u0615\u0616\5\u00d4k\2\u0616\u0617"+
		"\5\u00f4{\2\u0617\u00d3\3\2\2\2\u0618\u0619\5\u00f4{\2\u0619\u061a\7\33"+
		"\2\2\u061a\u061c\3\2\2\2\u061b\u0618\3\2\2\2\u061c\u061f\3\2\2\2\u061d"+
		"\u061b\3\2\2\2\u061d\u061e\3\2\2\2\u061e\u00d5\3\2\2\2\u061f\u061d\3\2"+
		"\2\2\u0620\u0622\7\r\2\2\u0621\u0623\7\u0095\2\2\u0622\u0621\3\2\2\2\u0622"+
		"\u0623\3\2\2\2\u0623\u0624\3\2\2\2\u0624\u062d\5\u00c4c\2\u0625\u0627"+
		"\7\u0095\2\2\u0626\u0625\3\2\2\2\u0626\u0627\3\2\2\2\u0627\u0628\3\2\2"+
		"\2\u0628\u062a\7\17\2\2\u0629\u062b\7\u0095\2\2\u062a\u0629\3\2\2\2\u062a"+
		"\u062b\3\2\2\2\u062b\u062c\3\2\2\2\u062c\u062e\5\u0098M\2\u062d\u0626"+
		"\3\2\2\2\u062d\u062e\3\2\2\2\u062e\u0630\3\2\2\2\u062f\u0631\7\u0095\2"+
		"\2\u0630\u062f\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u0632\3\2\2\2\u0632\u0633"+
		"\7\16\2\2\u0633\u00d7\3\2\2\2\u0634\u0636\7\r\2\2\u0635\u0637\7\u0095"+
		"\2\2\u0636\u0635\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0640\3\2\2\2\u0638"+
		"\u063a\5\u00e0q\2\u0639\u063b\7\u0095\2\2\u063a\u0639\3\2\2\2\u063a\u063b"+
		"\3\2\2\2\u063b\u063c\3\2\2\2\u063c\u063e\7\7\2\2\u063d\u063f\7\u0095\2"+
		"\2\u063e\u063d\3\2\2\2\u063e\u063f\3\2\2\2\u063f\u0641\3\2\2\2\u0640\u0638"+
		"\3\2\2\2\u0640\u0641\3\2\2\2\u0641\u0642\3\2\2\2\u0642\u0644\5\u00c2b"+
		"\2\u0643\u0645\7\u0095\2\2\u0644\u0643\3\2\2\2\u0644\u0645\3\2\2\2\u0645"+
		"\u064e\3\2\2\2\u0646\u0648\7`\2\2\u0647\u0649\7\u0095\2\2\u0648\u0647"+
		"\3\2\2\2\u0648\u0649\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u064c\5\u0098M"+
		"\2\u064b\u064d\7\u0095\2\2\u064c\u064b\3\2\2\2\u064c\u064d\3\2\2\2\u064d"+
		"\u064f\3\2\2\2\u064e\u0646\3\2\2\2\u064e\u064f\3\2\2\2\u064f\u0650\3\2"+
		"\2\2\u0650\u0652\7\17\2\2\u0651\u0653\7\u0095\2\2\u0652\u0651\3\2\2\2"+
		"\u0652\u0653\3\2\2\2\u0653\u0654\3\2\2\2\u0654\u0656\5\u0098M\2\u0655"+
		"\u0657\7\u0095\2\2\u0656\u0655\3\2\2\2\u0656\u0657\3\2\2\2\u0657\u0658"+
		"\3\2\2\2\u0658\u0659\7\16\2\2\u0659\u00d9\3\2\2\2\u065a\u065c\7\33\2\2"+
		"\u065b\u065d\7\u0095\2\2\u065c\u065b\3\2\2\2\u065c\u065d\3\2\2\2\u065d"+
		"\u065e\3\2\2\2\u065e\u065f\5\u00eav\2\u065f\u00db\3\2\2\2\u0660\u0665"+
		"\7r\2\2\u0661\u0663\7\u0095\2\2\u0662\u0661\3\2\2\2\u0662\u0663\3\2\2"+
		"\2\u0663\u0664\3\2\2\2\u0664\u0666\5\u00dep\2\u0665\u0662\3\2\2\2\u0666"+
		"\u0667\3\2\2\2\u0667\u0665\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u0677\3\2"+
		"\2\2\u0669\u066b\7r\2\2\u066a\u066c\7\u0095\2\2\u066b\u066a\3\2\2\2\u066b"+
		"\u066c\3\2\2\2\u066c\u066d\3\2\2\2\u066d\u0672\5\u0098M\2\u066e\u0670"+
		"\7\u0095\2\2\u066f\u066e\3\2\2\2\u066f\u0670\3\2\2\2\u0670\u0671\3\2\2"+
		"\2\u0671\u0673\5\u00dep\2\u0672\u066f\3\2\2\2\u0673\u0674\3\2\2\2\u0674"+
		"\u0672\3\2\2\2\u0674\u0675\3\2\2\2\u0675\u0677\3\2\2\2\u0676\u0660\3\2"+
		"\2\2\u0676\u0669\3\2\2\2\u0677\u0680\3\2\2\2\u0678\u067a\7\u0095\2\2\u0679"+
		"\u0678\3\2\2\2\u0679\u067a\3\2\2\2\u067a\u067b\3\2\2\2\u067b\u067d\7s"+
		"\2\2\u067c\u067e\7\u0095\2\2\u067d\u067c\3\2\2\2\u067d\u067e\3\2\2\2\u067e"+
		"\u067f\3\2\2\2\u067f\u0681\5\u0098M\2\u0680\u0679\3\2\2\2\u0680\u0681"+
		"\3\2\2\2\u0681\u0683\3\2\2\2\u0682\u0684\7\u0095\2\2\u0683\u0682\3\2\2"+
		"\2\u0683\u0684\3\2\2\2\u0684\u0685\3\2\2\2\u0685\u0686\7t\2\2\u0686\u00dd"+
		"\3\2\2\2\u0687\u0689\7u\2\2\u0688\u068a\7\u0095\2\2\u0689\u0688\3\2\2"+
		"\2\u0689\u068a\3\2\2\2\u068a\u068b\3\2\2\2\u068b\u068d\5\u0098M\2\u068c"+
		"\u068e\7\u0095\2\2\u068d\u068c\3\2\2\2\u068d\u068e\3\2\2\2\u068e\u068f"+
		"\3\2\2\2\u068f\u0691\7v\2\2\u0690\u0692\7\u0095\2\2\u0691\u0690\3\2\2"+
		"\2\u0691\u0692\3\2\2\2\u0692\u0693\3\2\2\2\u0693\u0694\5\u0098M\2\u0694"+
		"\u00df\3\2\2\2\u0695\u0696\5\u00f4{\2\u0696\u00e1\3\2\2\2\u0697\u069a"+
		"\5\u00eex\2\u0698\u069a\5\u00ecw\2\u0699\u0697\3\2\2\2\u0699\u0698\3\2"+
		"\2\2\u069a\u00e3\3\2\2\2\u069b\u069d\7\3\2\2\u069c\u069e\7\u0095\2\2\u069d"+
		"\u069c\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u06c0\3\2\2\2\u069f\u06a1\5\u00ea"+
		"v\2\u06a0\u06a2\7\u0095\2\2\u06a1\u06a0\3\2\2\2\u06a1\u06a2\3\2\2\2\u06a2"+
		"\u06a3\3\2\2\2\u06a3\u06a5\7\n\2\2\u06a4\u06a6\7\u0095\2\2\u06a5\u06a4"+
		"\3\2\2\2\u06a5\u06a6\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a9\5\u0098M"+
		"\2\u06a8\u06aa\7\u0095\2\2\u06a9\u06a8\3\2\2\2\u06a9\u06aa\3\2\2\2\u06aa"+
		"\u06bd\3\2\2\2\u06ab\u06ad\7\6\2\2\u06ac\u06ae\7\u0095\2\2\u06ad\u06ac"+
		"\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u06af\3\2\2\2\u06af\u06b1\5\u00eav"+
		"\2\u06b0\u06b2\7\u0095\2\2\u06b1\u06b0\3\2\2\2\u06b1\u06b2\3\2\2\2\u06b2"+
		"\u06b3\3\2\2\2\u06b3\u06b5\7\n\2\2\u06b4\u06b6\7\u0095\2\2\u06b5\u06b4"+
		"\3\2\2\2\u06b5\u06b6\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b9\5\u0098M"+
		"\2\u06b8\u06ba\7\u0095\2\2\u06b9\u06b8\3\2\2\2\u06b9\u06ba\3\2\2\2\u06ba"+
		"\u06bc\3\2\2\2\u06bb\u06ab\3\2\2\2\u06bc\u06bf\3\2\2\2\u06bd\u06bb\3\2"+
		"\2\2\u06bd\u06be\3\2\2\2\u06be\u06c1\3\2\2\2\u06bf\u06bd\3\2\2\2\u06c0"+
		"\u069f\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c3\7\4"+
		"\2\2\u06c3\u00e5\3\2\2\2\u06c4\u06c7\7\34\2\2\u06c5\u06c8\5\u00f4{\2\u06c6"+
		"\u06c8\7z\2\2\u06c7\u06c5\3\2\2\2\u06c7\u06c6\3\2\2\2\u06c8\u00e7\3\2"+
		"\2\2\u06c9\u06ce\5\u00b6\\\2\u06ca\u06cc\7\u0095\2\2\u06cb\u06ca\3\2\2"+
		"\2\u06cb\u06cc\3\2\2\2\u06cc\u06cd\3\2\2\2\u06cd\u06cf\5\u00dan\2\u06ce"+
		"\u06cb\3\2\2\2\u06cf\u06d0\3\2\2\2\u06d0\u06ce\3\2\2\2\u06d0\u06d1\3\2"+
		"\2\2\u06d1\u00e9\3\2\2\2\u06d2\u06d3\5\u00f0y\2\u06d3\u00eb\3\2\2\2\u06d4"+
		"\u06d5\t\5\2\2\u06d5\u00ed\3\2\2\2\u06d6\u06d7\t\6\2\2\u06d7\u00ef\3\2"+
		"\2\2\u06d8\u06db\5\u00f4{\2\u06d9\u06db\5\u00f2z\2\u06da\u06d8\3\2\2\2"+
		"\u06da\u06d9\3\2\2\2\u06db\u00f1\3\2\2\2\u06dc\u06dd\t\7\2\2\u06dd\u00f3"+
		"\3\2\2\2\u06de\u06df\t\b\2\2\u06df\u00f5\3\2\2\2\u06e0\u06e1\t\t\2\2\u06e1"+
		"\u00f7\3\2\2\2\u06e2\u06e3\t\n\2\2\u06e3\u00f9\3\2\2\2\u06e4\u06e5\t\13"+
		"\2\2\u06e5\u00fb\3\2\2\2\u013e\u00fe\u0101\u0105\u0109\u010d\u0111\u0115"+
		"\u0119\u011d\u0122\u0126\u012a\u0132\u0136\u013a\u013e\u0142\u0146\u014a"+
		"\u014e\u0152\u015a\u0162\u0166\u016a\u016e\u0172\u017c\u0185\u0189\u018f"+
		"\u0199\u01a0\u01a9\u01ad\u01b0\u01b3\u01bb\u01bf\u01c4\u01cb\u01d0\u01d3"+
		"\u01d7\u01db\u01df\u01e5\u01e9\u01ee\u01f3\u01f7\u01fa\u01fc\u0200\u0204"+
		"\u0209\u020d\u0212\u0216\u021f\u0224\u0228\u022c\u0230\u0233\u0237\u0241"+
		"\u0248\u0255\u0259\u025f\u0266\u026b\u026f\u0275\u0279\u027f\u0283\u0289"+
		"\u028d\u0291\u0295\u0299\u029d\u02a2\u02a9\u02ad\u02b2\u02b9\u02bf\u02c4"+
		"\u02ca\u02d0\u02d5\u02d9\u02de\u02e1\u02e4\u02e7\u02ee\u02f5\u02f8\u02fe"+
		"\u0301\u0307\u030b\u030f\u0313\u0317\u031c\u0321\u0325\u032a\u032d\u0336"+
		"\u033f\u0344\u0351\u0354\u035c\u0360\u0365\u036a\u036e\u0373\u0379\u037e"+
		"\u0385\u0389\u038d\u038f\u0393\u0395\u0399\u039b\u03a1\u03a7\u03ab\u03ae"+
		"\u03b1\u03b5\u03bb\u03bf\u03c2\u03c5\u03cb\u03ce\u03d1\u03d5\u03db\u03de"+
		"\u03e1\u03e5\u03e9\u03ed\u03ef\u03f3\u03f5\u03f8\u03fc\u03fe\u0404\u0408"+
		"\u040c\u0410\u0413\u0418\u041d\u0422\u0427\u042d\u0431\u0433\u0437\u043b"+
		"\u043d\u043f\u044e\u0458\u0462\u0467\u046b\u0472\u0477\u047c\u0480\u0484"+
		"\u0488\u048b\u048d\u0492\u0496\u049a\u049e\u04a2\u04a6\u04a9\u04ab\u04b0"+
		"\u04b4\u04b9\u04be\u04c2\u04cb\u04cd\u04d3\u04d7\u04de\u04e2\u04e6\u04e9"+
		"\u04f5\u04f8\u0506\u050a\u050f\u0513\u0516\u051d\u0521\u0525\u052c\u0530"+
		"\u0534\u053a\u053e\u0542\u0548\u054c\u0550\u0556\u055a\u055e\u0566\u056e"+
		"\u0574\u0578\u057c\u0580\u0584\u0587\u058d\u0592\u0597\u059c\u05a1\u05a6"+
		"\u05a9\u05ad\u05b1\u05b7\u05bc\u05c0\u05c3\u05cd\u05d1\u05d5\u05d7\u05db"+
		"\u05df\u05e3\u05e7\u05ea\u05f2\u05f6\u05fa\u05fe\u0602\u0606\u060a\u060d"+
		"\u061d\u0622\u0626\u062a\u062d\u0630\u0636\u063a\u063e\u0640\u0644\u0648"+
		"\u064c\u064e\u0652\u0656\u065c\u0662\u0667\u066b\u066f\u0674\u0676\u0679"+
		"\u067d\u0680\u0683\u0689\u068d\u0691\u0699\u069d\u06a1\u06a5\u06a9\u06ad"+
		"\u06b1\u06b5\u06b9\u06bd\u06c0\u06c7\u06cb\u06d0\u06da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}