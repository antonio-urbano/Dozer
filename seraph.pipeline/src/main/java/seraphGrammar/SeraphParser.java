// Generated from SeraphParser.g4 by ANTLR 4.9.2
package seraphGrammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SeraphParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPENB=1, CLOSEB=2, REGISTER=3, QUERY=4, STREAM=5, STARTING=6, WITH=7, 
		WINDOW=8, RANGE=9, EMIT=10, ON=11, ENTERING=12, EVERY=13, INTO=14, EXIT=15, 
		SNAPSHOT=16, EARLIEST=17, LATEST=18, FROM=19, KAFKA_TOPIC=20, DIGIT=21, 
		MONTH=22, DAY=23, YEAR=24, HOURS=25, MINUTES=26, SECONDS=27, ISO8601_DATETIME_UTC=28, 
		WORD=29, WS=30, WINDOW_RANGE_EVENTS=31, WINDOW_RANGE_EVENT=32, WINDOW_RANGE_INT=33, 
		WINDOW_RANGE_ISO8601DURATION=34, WINDOW_RANGE_WS=35, EMIT_RANGE_EVENTS=36, 
		EMIT_RANGE_EVENT=37, EMIT_RANGE_INT=38, EMIT_RANGE_ISO8601DURATION=39, 
		EMIT_RANGE_WS=40, CYPHER_QUERY=41;
	public static final int
		RULE_oS_Seraph = 0, RULE_oS_RegisterQuery = 1, RULE_oS_QueryName = 2, 
		RULE_oS_QueryCypher = 3, RULE_oS_QueryInput = 4, RULE_oS_InputStream = 5, 
		RULE_oS_TimeInstant = 6, RULE_oS_ISO_8601_Datetime = 7, RULE_oS_WindowRange = 8, 
		RULE_oS_WindowEventRange = 9, RULE_oS_WindowTimeRange = 10, RULE_oS_QueryOutput = 11, 
		RULE_oS_Emit = 12, RULE_oS_OutputStream = 13, RULE_oS_EmitRange = 14, 
		RULE_oS_EmitEventRange = 15, RULE_oS_EmitTimeRange = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"oS_Seraph", "oS_RegisterQuery", "oS_QueryName", "oS_QueryCypher", "oS_QueryInput", 
			"oS_InputStream", "oS_TimeInstant", "oS_ISO_8601_Datetime", "oS_WindowRange", 
			"oS_WindowEventRange", "oS_WindowTimeRange", "oS_QueryOutput", "oS_Emit", 
			"oS_OutputStream", "oS_EmitRange", "oS_EmitEventRange", "oS_EmitTimeRange"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPENB", "CLOSEB", "REGISTER", "QUERY", "STREAM", "STARTING", "WITH", 
			"WINDOW", "RANGE", "EMIT", "ON", "ENTERING", "EVERY", "INTO", "EXIT", 
			"SNAPSHOT", "EARLIEST", "LATEST", "FROM", "KAFKA_TOPIC", "DIGIT", "MONTH", 
			"DAY", "YEAR", "HOURS", "MINUTES", "SECONDS", "ISO8601_DATETIME_UTC", 
			"WORD", "WS", "WINDOW_RANGE_EVENTS", "WINDOW_RANGE_EVENT", "WINDOW_RANGE_INT", 
			"WINDOW_RANGE_ISO8601DURATION", "WINDOW_RANGE_WS", "EMIT_RANGE_EVENTS", 
			"EMIT_RANGE_EVENT", "EMIT_RANGE_INT", "EMIT_RANGE_ISO8601DURATION", "EMIT_RANGE_WS", 
			"CYPHER_QUERY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "SeraphParser.g4"; }

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
		public OS_SeraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_Seraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_Seraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_Seraph(this);
		}
	}

	public final OS_SeraphContext oS_Seraph() throws RecognitionException {
		OS_SeraphContext _localctx = new OS_SeraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_oS_Seraph);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			oS_RegisterQuery();
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
		public OS_QueryNameContext oS_QueryName() {
			return getRuleContext(OS_QueryNameContext.class,0);
		}
		public TerminalNode OPENB() { return getToken(SeraphParser.OPENB, 0); }
		public OS_QueryInputContext oS_QueryInput() {
			return getRuleContext(OS_QueryInputContext.class,0);
		}
		public OS_QueryCypherContext oS_QueryCypher() {
			return getRuleContext(OS_QueryCypherContext.class,0);
		}
		public OS_QueryOutputContext oS_QueryOutput() {
			return getRuleContext(OS_QueryOutputContext.class,0);
		}
		public TerminalNode CLOSEB() { return getToken(SeraphParser.CLOSEB, 0); }
		public TerminalNode EOF() { return getToken(SeraphParser.EOF, 0); }
		public OS_RegisterQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_RegisterQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_RegisterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_RegisterQuery(this);
		}
	}

	public final OS_RegisterQueryContext oS_RegisterQuery() throws RecognitionException {
		OS_RegisterQueryContext _localctx = new OS_RegisterQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oS_RegisterQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(REGISTER);
			setState(37);
			match(QUERY);
			setState(38);
			oS_QueryName();
			setState(39);
			match(OPENB);
			setState(40);
			oS_QueryInput();
			setState(41);
			oS_QueryCypher();
			setState(42);
			oS_QueryOutput();
			setState(43);
			match(CLOSEB);
			setState(44);
			match(EOF);
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

	public static class OS_QueryNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(SeraphParser.WORD, 0); }
		public OS_QueryNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_QueryName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_QueryName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_QueryName(this);
		}
	}

	public final OS_QueryNameContext oS_QueryName() throws RecognitionException {
		OS_QueryNameContext _localctx = new OS_QueryNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oS_QueryName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(WORD);
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

	public static class OS_QueryCypherContext extends ParserRuleContext {
		public TerminalNode CYPHER_QUERY() { return getToken(SeraphParser.CYPHER_QUERY, 0); }
		public OS_QueryCypherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_QueryCypher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_QueryCypher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_QueryCypher(this);
		}
	}

	public final OS_QueryCypherContext oS_QueryCypher() throws RecognitionException {
		OS_QueryCypherContext _localctx = new OS_QueryCypherContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_oS_QueryCypher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(CYPHER_QUERY);
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

	public static class OS_QueryInputContext extends ParserRuleContext {
		public List<TerminalNode> FROM() { return getTokens(SeraphParser.FROM); }
		public TerminalNode FROM(int i) {
			return getToken(SeraphParser.FROM, i);
		}
		public TerminalNode STREAM() { return getToken(SeraphParser.STREAM, 0); }
		public OS_InputStreamContext oS_InputStream() {
			return getRuleContext(OS_InputStreamContext.class,0);
		}
		public TerminalNode STARTING() { return getToken(SeraphParser.STARTING, 0); }
		public OS_TimeInstantContext oS_TimeInstant() {
			return getRuleContext(OS_TimeInstantContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SeraphParser.WITH, 0); }
		public TerminalNode WINDOW() { return getToken(SeraphParser.WINDOW, 0); }
		public TerminalNode RANGE() { return getToken(SeraphParser.RANGE, 0); }
		public OS_WindowRangeContext oS_WindowRange() {
			return getRuleContext(OS_WindowRangeContext.class,0);
		}
		public OS_QueryInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_QueryInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_QueryInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_QueryInput(this);
		}
	}

	public final OS_QueryInputContext oS_QueryInput() throws RecognitionException {
		OS_QueryInputContext _localctx = new OS_QueryInputContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_oS_QueryInput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(FROM);
			setState(51);
			match(STREAM);
			setState(52);
			oS_InputStream();
			setState(53);
			match(STARTING);
			setState(54);
			match(FROM);
			setState(55);
			oS_TimeInstant();
			setState(56);
			match(WITH);
			setState(57);
			match(WINDOW);
			setState(58);
			match(RANGE);
			setState(59);
			oS_WindowRange();
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

	public static class OS_InputStreamContext extends ParserRuleContext {
		public TerminalNode KAFKA_TOPIC() { return getToken(SeraphParser.KAFKA_TOPIC, 0); }
		public OS_InputStreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_InputStream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_InputStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_InputStream(this);
		}
	}

	public final OS_InputStreamContext oS_InputStream() throws RecognitionException {
		OS_InputStreamContext _localctx = new OS_InputStreamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_oS_InputStream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(KAFKA_TOPIC);
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

	public static class OS_TimeInstantContext extends ParserRuleContext {
		public TerminalNode EARLIEST() { return getToken(SeraphParser.EARLIEST, 0); }
		public TerminalNode LATEST() { return getToken(SeraphParser.LATEST, 0); }
		public OS_ISO_8601_DatetimeContext oS_ISO_8601_Datetime() {
			return getRuleContext(OS_ISO_8601_DatetimeContext.class,0);
		}
		public OS_TimeInstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_TimeInstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_TimeInstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_TimeInstant(this);
		}
	}

	public final OS_TimeInstantContext oS_TimeInstant() throws RecognitionException {
		OS_TimeInstantContext _localctx = new OS_TimeInstantContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_oS_TimeInstant);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EARLIEST:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(EARLIEST);
				}
				break;
			case LATEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(LATEST);
				}
				break;
			case ISO8601_DATETIME_UTC:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				oS_ISO_8601_Datetime();
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

	public static class OS_ISO_8601_DatetimeContext extends ParserRuleContext {
		public TerminalNode ISO8601_DATETIME_UTC() { return getToken(SeraphParser.ISO8601_DATETIME_UTC, 0); }
		public OS_ISO_8601_DatetimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_ISO_8601_Datetime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_ISO_8601_Datetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_ISO_8601_Datetime(this);
		}
	}

	public final OS_ISO_8601_DatetimeContext oS_ISO_8601_Datetime() throws RecognitionException {
		OS_ISO_8601_DatetimeContext _localctx = new OS_ISO_8601_DatetimeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oS_ISO_8601_Datetime);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ISO8601_DATETIME_UTC);
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

	public static class OS_WindowRangeContext extends ParserRuleContext {
		public OS_WindowEventRangeContext oS_WindowEventRange() {
			return getRuleContext(OS_WindowEventRangeContext.class,0);
		}
		public OS_WindowTimeRangeContext oS_WindowTimeRange() {
			return getRuleContext(OS_WindowTimeRangeContext.class,0);
		}
		public OS_WindowRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_WindowRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_WindowRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_WindowRange(this);
		}
	}

	public final OS_WindowRangeContext oS_WindowRange() throws RecognitionException {
		OS_WindowRangeContext _localctx = new OS_WindowRangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_oS_WindowRange);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WINDOW_RANGE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				oS_WindowEventRange();
				}
				break;
			case WINDOW_RANGE_ISO8601DURATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				oS_WindowTimeRange();
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

	public static class OS_WindowEventRangeContext extends ParserRuleContext {
		public TerminalNode WINDOW_RANGE_INT() { return getToken(SeraphParser.WINDOW_RANGE_INT, 0); }
		public TerminalNode WINDOW_RANGE_EVENT() { return getToken(SeraphParser.WINDOW_RANGE_EVENT, 0); }
		public TerminalNode WINDOW_RANGE_EVENTS() { return getToken(SeraphParser.WINDOW_RANGE_EVENTS, 0); }
		public OS_WindowEventRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_WindowEventRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_WindowEventRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_WindowEventRange(this);
		}
	}

	public final OS_WindowEventRangeContext oS_WindowEventRange() throws RecognitionException {
		OS_WindowEventRangeContext _localctx = new OS_WindowEventRangeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_oS_WindowEventRange);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(74);
				match(WINDOW_RANGE_INT);
				setState(75);
				match(WINDOW_RANGE_EVENT);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(76);
				match(WINDOW_RANGE_INT);
				setState(77);
				match(WINDOW_RANGE_EVENTS);
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

	public static class OS_WindowTimeRangeContext extends ParserRuleContext {
		public TerminalNode WINDOW_RANGE_ISO8601DURATION() { return getToken(SeraphParser.WINDOW_RANGE_ISO8601DURATION, 0); }
		public OS_WindowTimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_WindowTimeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_WindowTimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_WindowTimeRange(this);
		}
	}

	public final OS_WindowTimeRangeContext oS_WindowTimeRange() throws RecognitionException {
		OS_WindowTimeRangeContext _localctx = new OS_WindowTimeRangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_oS_WindowTimeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(WINDOW_RANGE_ISO8601DURATION);
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

	public static class OS_QueryOutputContext extends ParserRuleContext {
		public TerminalNode EMIT() { return getToken(SeraphParser.EMIT, 0); }
		public OS_EmitContext oS_Emit() {
			return getRuleContext(OS_EmitContext.class,0);
		}
		public TerminalNode EVERY() { return getToken(SeraphParser.EVERY, 0); }
		public OS_EmitRangeContext oS_EmitRange() {
			return getRuleContext(OS_EmitRangeContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SeraphParser.INTO, 0); }
		public OS_OutputStreamContext oS_OutputStream() {
			return getRuleContext(OS_OutputStreamContext.class,0);
		}
		public OS_QueryOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_QueryOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_QueryOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_QueryOutput(this);
		}
	}

	public final OS_QueryOutputContext oS_QueryOutput() throws RecognitionException {
		OS_QueryOutputContext _localctx = new OS_QueryOutputContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_oS_QueryOutput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(EMIT);
			setState(83);
			oS_Emit();
			setState(84);
			match(EVERY);
			setState(85);
			oS_EmitRange();
			setState(86);
			match(INTO);
			setState(87);
			oS_OutputStream();
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

	public static class OS_EmitContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SeraphParser.ON, 0); }
		public TerminalNode ENTERING() { return getToken(SeraphParser.ENTERING, 0); }
		public TerminalNode EXIT() { return getToken(SeraphParser.EXIT, 0); }
		public TerminalNode SNAPSHOT() { return getToken(SeraphParser.SNAPSHOT, 0); }
		public OS_EmitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_Emit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_Emit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_Emit(this);
		}
	}

	public final OS_EmitContext oS_Emit() throws RecognitionException {
		OS_EmitContext _localctx = new OS_EmitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_oS_Emit);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(89);
				match(ON);
				setState(90);
				match(ENTERING);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(91);
				match(ON);
				setState(92);
				match(EXIT);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(93);
				match(SNAPSHOT);
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

	public static class OS_OutputStreamContext extends ParserRuleContext {
		public TerminalNode KAFKA_TOPIC() { return getToken(SeraphParser.KAFKA_TOPIC, 0); }
		public OS_OutputStreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_OutputStream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_OutputStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_OutputStream(this);
		}
	}

	public final OS_OutputStreamContext oS_OutputStream() throws RecognitionException {
		OS_OutputStreamContext _localctx = new OS_OutputStreamContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_oS_OutputStream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(KAFKA_TOPIC);
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

	public static class OS_EmitRangeContext extends ParserRuleContext {
		public OS_EmitEventRangeContext oS_EmitEventRange() {
			return getRuleContext(OS_EmitEventRangeContext.class,0);
		}
		public OS_EmitTimeRangeContext oS_EmitTimeRange() {
			return getRuleContext(OS_EmitTimeRangeContext.class,0);
		}
		public OS_EmitRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_EmitRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_EmitRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_EmitRange(this);
		}
	}

	public final OS_EmitRangeContext oS_EmitRange() throws RecognitionException {
		OS_EmitRangeContext _localctx = new OS_EmitRangeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_oS_EmitRange);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EMIT_RANGE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				oS_EmitEventRange();
				}
				break;
			case EMIT_RANGE_ISO8601DURATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				oS_EmitTimeRange();
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

	public static class OS_EmitEventRangeContext extends ParserRuleContext {
		public TerminalNode EMIT_RANGE_INT() { return getToken(SeraphParser.EMIT_RANGE_INT, 0); }
		public TerminalNode EMIT_RANGE_EVENT() { return getToken(SeraphParser.EMIT_RANGE_EVENT, 0); }
		public TerminalNode EMIT_RANGE_EVENTS() { return getToken(SeraphParser.EMIT_RANGE_EVENTS, 0); }
		public OS_EmitEventRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_EmitEventRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_EmitEventRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_EmitEventRange(this);
		}
	}

	public final OS_EmitEventRangeContext oS_EmitEventRange() throws RecognitionException {
		OS_EmitEventRangeContext _localctx = new OS_EmitEventRangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_oS_EmitEventRange);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(102);
				match(EMIT_RANGE_INT);
				setState(103);
				match(EMIT_RANGE_EVENT);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(104);
				match(EMIT_RANGE_INT);
				setState(105);
				match(EMIT_RANGE_EVENTS);
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

	public static class OS_EmitTimeRangeContext extends ParserRuleContext {
		public TerminalNode EMIT_RANGE_ISO8601DURATION() { return getToken(SeraphParser.EMIT_RANGE_ISO8601DURATION, 0); }
		public OS_EmitTimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oS_EmitTimeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).enterOS_EmitTimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SeraphParserListener ) ((SeraphParserListener)listener).exitOS_EmitTimeRange(this);
		}
	}

	public final OS_EmitTimeRangeContext oS_EmitTimeRange() throws RecognitionException {
		OS_EmitTimeRangeContext _localctx = new OS_EmitTimeRangeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_oS_EmitTimeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(EMIT_RANGE_ISO8601DURATION);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+q\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\5\bE\n\b\3\t\3\t\3"+
		"\n\3\n\5\nK\n\n\3\13\3\13\3\13\3\13\5\13Q\n\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16a\n\16\3\17\3\17\3\20\3\20\5"+
		"\20g\n\20\3\21\3\21\3\21\3\21\5\21m\n\21\3\22\3\22\3\22\2\2\23\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\2g\2$\3\2\2\2\4&\3\2\2\2\6\60\3"+
		"\2\2\2\b\62\3\2\2\2\n\64\3\2\2\2\f?\3\2\2\2\16D\3\2\2\2\20F\3\2\2\2\22"+
		"J\3\2\2\2\24P\3\2\2\2\26R\3\2\2\2\30T\3\2\2\2\32`\3\2\2\2\34b\3\2\2\2"+
		"\36f\3\2\2\2 l\3\2\2\2\"n\3\2\2\2$%\5\4\3\2%\3\3\2\2\2&\'\7\5\2\2\'(\7"+
		"\6\2\2()\5\6\4\2)*\7\3\2\2*+\5\n\6\2+,\5\b\5\2,-\5\30\r\2-.\7\4\2\2./"+
		"\7\2\2\3/\5\3\2\2\2\60\61\7\37\2\2\61\7\3\2\2\2\62\63\7+\2\2\63\t\3\2"+
		"\2\2\64\65\7\25\2\2\65\66\7\7\2\2\66\67\5\f\7\2\678\7\b\2\289\7\25\2\2"+
		"9:\5\16\b\2:;\7\t\2\2;<\7\n\2\2<=\7\13\2\2=>\5\22\n\2>\13\3\2\2\2?@\7"+
		"\26\2\2@\r\3\2\2\2AE\7\23\2\2BE\7\24\2\2CE\5\20\t\2DA\3\2\2\2DB\3\2\2"+
		"\2DC\3\2\2\2E\17\3\2\2\2FG\7\36\2\2G\21\3\2\2\2HK\5\24\13\2IK\5\26\f\2"+
		"JH\3\2\2\2JI\3\2\2\2K\23\3\2\2\2LM\7#\2\2MQ\7\"\2\2NO\7#\2\2OQ\7!\2\2"+
		"PL\3\2\2\2PN\3\2\2\2Q\25\3\2\2\2RS\7$\2\2S\27\3\2\2\2TU\7\f\2\2UV\5\32"+
		"\16\2VW\7\17\2\2WX\5\36\20\2XY\7\20\2\2YZ\5\34\17\2Z\31\3\2\2\2[\\\7\r"+
		"\2\2\\a\7\16\2\2]^\7\r\2\2^a\7\21\2\2_a\7\22\2\2`[\3\2\2\2`]\3\2\2\2`"+
		"_\3\2\2\2a\33\3\2\2\2bc\7\26\2\2c\35\3\2\2\2dg\5 \21\2eg\5\"\22\2fd\3"+
		"\2\2\2fe\3\2\2\2g\37\3\2\2\2hi\7(\2\2im\7\'\2\2jk\7(\2\2km\7&\2\2lh\3"+
		"\2\2\2lj\3\2\2\2m!\3\2\2\2no\7)\2\2o#\3\2\2\2\bDJP`fl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}