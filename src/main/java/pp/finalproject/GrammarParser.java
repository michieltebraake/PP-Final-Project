// Generated from E:/michiel/Documents/GitHub/PP-Final-Project/src/main/java/pp/finalproject\Grammar.g4 by ANTLR 4.5
package pp.finalproject;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, IF=3, WHILE=4, SHARED=5, PROCEDURE=6, SYNCHRONIZED=7, TRUE=8, 
		FALSE=9, EQUAL=10, NOTEQUAL=11, LT=12, LTE=13, GT=14, GTE=15, ASSIGN=16, 
		OR=17, AND=18, SEMI=19, LPAR=20, RPAR=21, LCURLY=22, RCURLY=23, LSQ=24, 
		RSQ=25, PLUS=26, MINUS=27, TIMES=28, DIVIDE=29, MODULO=30, COMMA=31, ID=32, 
		NUM=33, WS=34;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_ifcompare = 2, RULE_ifbody = 3, 
		RULE_whilecompare = 4, RULE_whilebody = 5, RULE_synchronizedbody = 6, 
		RULE_target = 7, RULE_arraytype = 8, RULE_procedure = 9, RULE_expr = 10, 
		RULE_type = 11;
	public static final String[] ruleNames = {
		"program", "stat", "ifcompare", "ifbody", "whilecompare", "whilebody", 
		"synchronizedbody", "target", "arraytype", "procedure", "expr", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'integer'", "'boolean'", "'if'", "'while'", "'shared'", "'procedure'", 
		"'synchronized'", "'true'", "'false'", "'=='", "'!='", "'<'", "'<='", 
		"'>'", "'>='", "'='", "'||'", "'&&'", "';'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "'+'", "'-'", "'*'", "'/'", "'%'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "BOOL", "IF", "WHILE", "SHARED", "PROCEDURE", "SYNCHRONIZED", 
		"TRUE", "FALSE", "EQUAL", "NOTEQUAL", "LT", "LTE", "GT", "GTE", "ASSIGN", 
		"OR", "AND", "SEMI", "LPAR", "RPAR", "LCURLY", "RCURLY", "LSQ", "RSQ", 
		"PLUS", "MINUS", "TIMES", "DIVIDE", "MODULO", "COMMA", "ID", "NUM", "WS"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); 
				stat();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public IfcompareContext ifcompare() {
			return getRuleContext(IfcompareContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public IfbodyContext ifbody() {
			return getRuleContext(IfbodyContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfStat(this);
		}
	}
	public static class SynchronizedStatContext extends StatContext {
		public TerminalNode SYNCHRONIZED() { return getToken(GrammarParser.SYNCHRONIZED, 0); }
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public SynchronizedbodyContext synchronizedbody() {
			return getRuleContext(SynchronizedbodyContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public SynchronizedStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSynchronizedStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSynchronizedStat(this);
		}
	}
	public static class ArrayAssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode LSQ() { return getToken(GrammarParser.LSQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RSQ() { return getToken(GrammarParser.RSQ, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public ArrayAssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayAssignStat(this);
		}
	}
	public static class DeclAssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode SHARED() { return getToken(GrammarParser.SHARED, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public DeclAssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclAssignStat(this);
		}
	}
	public static class DeclStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode SHARED() { return getToken(GrammarParser.SHARED, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public DeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclStat(this);
		}
	}
	public static class ProcedureStatContext extends StatContext {
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public ProcedureStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProcedureStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProcedureStat(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAssignStat(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public WhilecompareContext whilecompare() {
			return getRuleContext(WhilecompareContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public WhilebodyContext whilebody() {
			return getRuleContext(WhilebodyContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhileStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				switch (_input.LA(1)) {
				case SHARED:
					{
					setState(29); 
					match(SHARED);
					setState(30); 
					target();
					}
					break;
				case INT:
				case BOOL:
					{
					setState(31); 
					target();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(34); 
				match(ID);
				setState(35); 
				match(ASSIGN);
				setState(36); 
				expr(0);
				setState(37); 
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				switch (_input.LA(1)) {
				case SHARED:
					{
					setState(39); 
					match(SHARED);
					setState(40); 
					target();
					}
					break;
				case INT:
				case BOOL:
					{
					setState(41); 
					target();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(44); 
				match(ID);
				setState(45); 
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(47); 
				match(ID);
				setState(48); 
				match(ASSIGN);
				setState(49); 
				expr(0);
				setState(50); 
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(52); 
				ifcompare();
				setState(53); 
				match(LCURLY);
				setState(54); 
				ifbody();
				setState(55); 
				match(RCURLY);
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(57); 
				whilecompare();
				setState(58); 
				match(LCURLY);
				setState(59); 
				whilebody();
				setState(60); 
				match(RCURLY);
				}
				break;
			case 6:
				_localctx = new ProcedureStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(62); 
				procedure();
				}
				break;
			case 7:
				_localctx = new SynchronizedStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(63); 
				match(SYNCHRONIZED);
				setState(64); 
				match(LCURLY);
				setState(65); 
				synchronizedbody();
				setState(66); 
				match(RCURLY);
				}
				break;
			case 8:
				_localctx = new ArrayAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(68); 
				match(ID);
				setState(69); 
				match(LSQ);
				setState(70); 
				expr(0);
				setState(71); 
				match(RSQ);
				setState(72); 
				match(ASSIGN);
				setState(73); 
				expr(0);
				setState(74); 
				match(SEMI);
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

	public static class IfcompareContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public IfcompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcompare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfcompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfcompare(this);
		}
	}

	public final IfcompareContext ifcompare() throws RecognitionException {
		IfcompareContext _localctx = new IfcompareContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifcompare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			match(IF);
			setState(79); 
			match(LPAR);
			setState(80); 
			expr(0);
			setState(81); 
			match(RPAR);
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

	public static class IfbodyContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfbody(this);
		}
	}

	public final IfbodyContext ifbody() throws RecognitionException {
		IfbodyContext _localctx = new IfbodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(83); 
				stat();
				}
				}
				setState(88);
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

	public static class WhilecompareContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GrammarParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public WhilecompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilecompare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhilecompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhilecompare(this);
		}
	}

	public final WhilecompareContext whilecompare() throws RecognitionException {
		WhilecompareContext _localctx = new WhilecompareContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whilecompare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			match(WHILE);
			setState(90); 
			match(LPAR);
			setState(91); 
			expr(0);
			setState(92); 
			match(RPAR);
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

	public static class WhilebodyContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public WhilebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilebody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhilebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhilebody(this);
		}
	}

	public final WhilebodyContext whilebody() throws RecognitionException {
		WhilebodyContext _localctx = new WhilebodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whilebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(94); 
				stat();
				}
				}
				setState(99);
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

	public static class SynchronizedbodyContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public SynchronizedbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSynchronizedbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSynchronizedbody(this);
		}
	}

	public final SynchronizedbodyContext synchronizedbody() throws RecognitionException {
		SynchronizedbodyContext _localctx = new SynchronizedbodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_synchronizedbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(100); 
				stat();
				}
				}
				setState(105);
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

	public static class TargetContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTarget(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_target);
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); 
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); 
				arraytype();
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

	public static class ArraytypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQ() { return getToken(GrammarParser.LSQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(GrammarParser.RSQ, 0); }
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArraytype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArraytype(this);
		}
	}

	public final ArraytypeContext arraytype() throws RecognitionException {
		ArraytypeContext _localctx = new ArraytypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arraytype);
		try {
			setState(119);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); 
				type();
				setState(111); 
				match(LSQ);
				setState(112); 
				expr(0);
				setState(113); 
				match(RSQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); 
				type();
				setState(116); 
				match(LSQ);
				setState(117); 
				match(RSQ);
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

	public static class ProcedureContext extends ParserRuleContext {
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
	 
		public ProcedureContext() { }
		public void copyFrom(ProcedureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamProcedureContext extends ProcedureContext {
		public TerminalNode PROCEDURE() { return getToken(GrammarParser.PROCEDURE, 0); }
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public ParamProcedureContext(ProcedureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParamProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParamProcedure(this);
		}
	}
	public static class NoParamProcedureContext extends ProcedureContext {
		public TerminalNode PROCEDURE() { return getToken(GrammarParser.PROCEDURE, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public NoParamProcedureContext(ProcedureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNoParamProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNoParamProcedure(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_procedure);
		int _la;
		try {
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new NoParamProcedureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121); 
				match(PROCEDURE);
				setState(122); 
				match(ID);
				setState(123); 
				match(LPAR);
				setState(124); 
				match(RPAR);
				setState(125); 
				match(LCURLY);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
					{
					{
					setState(126); 
					stat();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132); 
				match(RCURLY);
				}
				break;
			case 2:
				_localctx = new ParamProcedureContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133); 
				match(PROCEDURE);
				setState(134); 
				match(ID);
				setState(135); 
				match(LPAR);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT || _la==BOOL) {
					{
					{
					setState(136); 
					target();
					setState(137); 
					match(ID);
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(138); 
						match(COMMA);
						setState(139); 
						target();
						setState(140); 
						match(ID);
						}
						}
						setState(146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152); 
				match(RPAR);
				setState(153); 
				match(LCURLY);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
					{
					{
					setState(154); 
					stat();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160); 
				match(RCURLY);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParExpr(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode LSQ() { return getToken(GrammarParser.LSQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(GrammarParser.RSQ, 0); }
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayExpr(this);
		}
	}
	public static class TimesDivideExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(GrammarParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(GrammarParser.MODULO, 0); }
		public TimesDivideExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTimesDivideExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTimesDivideExpr(this);
		}
	}
	public static class PlusMinusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public PlusMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPlusMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPlusMinusExpr(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(GrammarParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOrExpr(this);
		}
	}
	public static class MinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMinusExpr(this);
		}
	}
	public static class ArrayAssignExprContext extends ExprContext {
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public ArrayAssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayAssignExpr(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(GrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GrammarParser.FALSE, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitConstExpr(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIdExpr(this);
		}
	}
	public static class CmpExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(GrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(GrammarParser.GT, 0); }
		public TerminalNode LTE() { return getToken(GrammarParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(GrammarParser.GTE, 0); }
		public TerminalNode EQUAL() { return getToken(GrammarParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(GrammarParser.NOTEQUAL, 0); }
		public CmpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmpExpr(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(GrammarParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAndExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(164); 
				match(MINUS);
				setState(165); 
				expr(9);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 3:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167); 
				match(LPAR);
				setState(168); 
				expr(0);
				setState(169); 
				match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171); 
				match(LCURLY);
				setState(172); 
				expr(0);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(173); 
					match(COMMA);
					setState(174); 
					expr(0);
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(180); 
				match(RCURLY);
				}
				break;
			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182); 
				match(ID);
				setState(183); 
				match(LSQ);
				setState(184); 
				expr(0);
				setState(185); 
				match(RSQ);
				}
				break;
			case 6:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187); 
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(213);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new TimesDivideExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(191);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIVIDE) | (1L << MODULO))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(192); 
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(194);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(195); 
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new CmpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(204);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(197); 
							match(LT);
							}
							break;
						case GT:
							{
							setState(198); 
							match(GT);
							}
							break;
						case LTE:
							{
							setState(199); 
							match(LTE);
							}
							break;
						case TRUE:
						case FALSE:
						case LPAR:
						case LCURLY:
						case MINUS:
						case ID:
						case NUM:
							{
							}
							break;
						case GTE:
							{
							setState(201); 
							match(GTE);
							}
							break;
						case EQUAL:
							{
							setState(202); 
							match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(203); 
							match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(206); 
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(208); 
						match(OR);
						setState(209); 
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(211); 
						match(AND);
						setState(212); 
						expr(4);
						}
						break;
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(GrammarParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 10);
		case 1: 
			return precpred(_ctx, 8);
		case 2: 
			return precpred(_ctx, 7);
		case 3: 
			return precpred(_ctx, 4);
		case 4: 
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u00df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\5\3#\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3O\n\3\3\4\3\4\3\4\3\4\3\4\3\5\7\5W\n\5"+
		"\f\5\16\5Z\13\5\3\6\3\6\3\6\3\6\3\6\3\7\7\7b\n\7\f\7\16\7e\13\7\3\b\7"+
		"\bh\n\b\f\b\16\bk\13\b\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0082\n\13\f\13\16"+
		"\13\u0085\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u0091\n\13\f\13\16\13\u0094\13\13\7\13\u0096\n\13\f\13\16\13\u0099\13"+
		"\13\3\13\3\13\3\13\7\13\u009e\n\13\f\13\16\13\u00a1\13\13\3\13\5\13\u00a4"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b2\n\f\f"+
		"\f\16\f\u00b5\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bf\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cf\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d8\n\f\f\f\16\f\u00db\13\f\3\r\3\r\3\r\2"+
		"\3\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6\4\2\n\13##\3\2\36 \3\2\34\35"+
		"\3\2\3\4\u00f7\2\33\3\2\2\2\4N\3\2\2\2\6P\3\2\2\2\bX\3\2\2\2\n[\3\2\2"+
		"\2\fc\3\2\2\2\16i\3\2\2\2\20n\3\2\2\2\22y\3\2\2\2\24\u00a3\3\2\2\2\26"+
		"\u00be\3\2\2\2\30\u00dc\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\35\3\2"+
		"\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37 \7\7\2\2 #\5\20\t\2!"+
		"#\5\20\t\2\"\37\3\2\2\2\"!\3\2\2\2#$\3\2\2\2$%\7\"\2\2%&\7\22\2\2&\'\5"+
		"\26\f\2\'(\7\25\2\2(O\3\2\2\2)*\7\7\2\2*-\5\20\t\2+-\5\20\t\2,)\3\2\2"+
		"\2,+\3\2\2\2-.\3\2\2\2./\7\"\2\2/\60\7\25\2\2\60O\3\2\2\2\61\62\7\"\2"+
		"\2\62\63\7\22\2\2\63\64\5\26\f\2\64\65\7\25\2\2\65O\3\2\2\2\66\67\5\6"+
		"\4\2\678\7\30\2\289\5\b\5\29:\7\31\2\2:O\3\2\2\2;<\5\n\6\2<=\7\30\2\2"+
		"=>\5\f\7\2>?\7\31\2\2?O\3\2\2\2@O\5\24\13\2AB\7\t\2\2BC\7\30\2\2CD\5\16"+
		"\b\2DE\7\31\2\2EO\3\2\2\2FG\7\"\2\2GH\7\32\2\2HI\5\26\f\2IJ\7\33\2\2J"+
		"K\7\22\2\2KL\5\26\f\2LM\7\25\2\2MO\3\2\2\2N\"\3\2\2\2N,\3\2\2\2N\61\3"+
		"\2\2\2N\66\3\2\2\2N;\3\2\2\2N@\3\2\2\2NA\3\2\2\2NF\3\2\2\2O\5\3\2\2\2"+
		"PQ\7\5\2\2QR\7\26\2\2RS\5\26\f\2ST\7\27\2\2T\7\3\2\2\2UW\5\4\3\2VU\3\2"+
		"\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\t\3\2\2\2ZX\3\2\2\2[\\\7\6\2\2\\]"+
		"\7\26\2\2]^\5\26\f\2^_\7\27\2\2_\13\3\2\2\2`b\5\4\3\2a`\3\2\2\2be\3\2"+
		"\2\2ca\3\2\2\2cd\3\2\2\2d\r\3\2\2\2ec\3\2\2\2fh\5\4\3\2gf\3\2\2\2hk\3"+
		"\2\2\2ig\3\2\2\2ij\3\2\2\2j\17\3\2\2\2ki\3\2\2\2lo\5\30\r\2mo\5\22\n\2"+
		"nl\3\2\2\2nm\3\2\2\2o\21\3\2\2\2pq\5\30\r\2qr\7\32\2\2rs\5\26\f\2st\7"+
		"\33\2\2tz\3\2\2\2uv\5\30\r\2vw\7\32\2\2wx\7\33\2\2xz\3\2\2\2yp\3\2\2\2"+
		"yu\3\2\2\2z\23\3\2\2\2{|\7\b\2\2|}\7\"\2\2}~\7\26\2\2~\177\7\27\2\2\177"+
		"\u0083\7\30\2\2\u0080\u0082\5\4\3\2\u0081\u0080\3\2\2\2\u0082\u0085\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u00a4\7\31\2\2\u0087\u0088\7\b\2\2\u0088\u0089\7"+
		"\"\2\2\u0089\u0097\7\26\2\2\u008a\u008b\5\20\t\2\u008b\u0092\7\"\2\2\u008c"+
		"\u008d\7!\2\2\u008d\u008e\5\20\t\2\u008e\u008f\7\"\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008c\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u008a\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\27\2\2\u009b\u009f\7"+
		"\30\2\2\u009c\u009e\5\4\3\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u00a4\7\31\2\2\u00a3{\3\2\2\2\u00a3\u0087\3\2\2\2\u00a4\25"+
		"\3\2\2\2\u00a5\u00a6\b\f\1\2\u00a6\u00a7\7\35\2\2\u00a7\u00bf\5\26\f\13"+
		"\u00a8\u00bf\t\2\2\2\u00a9\u00aa\7\26\2\2\u00aa\u00ab\5\26\f\2\u00ab\u00ac"+
		"\7\27\2\2\u00ac\u00bf\3\2\2\2\u00ad\u00ae\7\30\2\2\u00ae\u00b3\5\26\f"+
		"\2\u00af\u00b0\7!\2\2\u00b0\u00b2\5\26\f\2\u00b1\u00af\3\2\2\2\u00b2\u00b5"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00b7\7\31\2\2\u00b7\u00bf\3\2\2\2\u00b8\u00b9\7"+
		"\"\2\2\u00b9\u00ba\7\32\2\2\u00ba\u00bb\5\26\f\2\u00bb\u00bc\7\33\2\2"+
		"\u00bc\u00bf\3\2\2\2\u00bd\u00bf\7\"\2\2\u00be\u00a5\3\2\2\2\u00be\u00a8"+
		"\3\2\2\2\u00be\u00a9\3\2\2\2\u00be\u00ad\3\2\2\2\u00be\u00b8\3\2\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00d9\3\2\2\2\u00c0\u00c1\f\f\2\2\u00c1\u00c2\t\3"+
		"\2\2\u00c2\u00d8\5\26\f\r\u00c3\u00c4\f\n\2\2\u00c4\u00c5\t\4\2\2\u00c5"+
		"\u00d8\5\26\f\13\u00c6\u00ce\f\t\2\2\u00c7\u00cf\7\16\2\2\u00c8\u00cf"+
		"\7\20\2\2\u00c9\u00cf\7\17\2\2\u00ca\u00cf\3\2\2\2\u00cb\u00cf\7\21\2"+
		"\2\u00cc\u00cf\7\f\2\2\u00cd\u00cf\7\r\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8"+
		"\3\2\2\2\u00ce\u00c9\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d8\5\26"+
		"\f\n\u00d1\u00d2\f\6\2\2\u00d2\u00d3\7\23\2\2\u00d3\u00d8\5\26\f\7\u00d4"+
		"\u00d5\f\5\2\2\u00d5\u00d6\7\24\2\2\u00d6\u00d8\5\26\f\6\u00d7\u00c0\3"+
		"\2\2\2\u00d7\u00c3\3\2\2\2\u00d7\u00c6\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7"+
		"\u00d4\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\27\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\t\5\2\2\u00dd\31"+
		"\3\2\2\2\25\35\",NXciny\u0083\u0092\u0097\u009f\u00a3\u00b3\u00be\u00ce"+
		"\u00d7\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}