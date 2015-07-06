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
		INT=1, BOOL=2, IF=3, WHILE=4, SHARED=5, SYNCHRONIZED=6, TRUE=7, FALSE=8, 
		EQUAL=9, LT=10, LTE=11, GT=12, GTE=13, ASSIGN=14, OR=15, AND=16, SEMI=17, 
		LPAR=18, RPAR=19, LCURLY=20, RCURLY=21, LSQ=22, RSQ=23, PLUS=24, MINUS=25, 
		TIMES=26, DIVIDE=27, COMMA=28, SPID=29, ID=30, NUM=31, WS=32;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_ifcompare = 2, RULE_ifbody = 3, 
		RULE_whilecompare = 4, RULE_whilebody = 5, RULE_synchronizedbody = 6, 
		RULE_target = 7, RULE_arraytype = 8, RULE_expr = 9, RULE_type = 10;
	public static final String[] ruleNames = {
		"program", "stat", "ifcompare", "ifbody", "whilecompare", "whilebody", 
		"synchronizedbody", "target", "arraytype", "expr", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'integer'", "'boolean'", "'if'", "'while'", "'shared'", "'synchronized'", 
		"'true'", "'false'", "'=='", "'<'", "'<='", "'>'", "'>='", "'='", "'||'", 
		"'&&'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", "'-'", 
		"'*'", "'/'", "','", "'spid'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "BOOL", "IF", "WHILE", "SHARED", "SYNCHRONIZED", "TRUE", 
		"FALSE", "EQUAL", "LT", "LTE", "GT", "GTE", "ASSIGN", "OR", "AND", "SEMI", 
		"LPAR", "RPAR", "LCURLY", "RCURLY", "LSQ", "RSQ", "PLUS", "MINUS", "TIMES", 
		"DIVIDE", "COMMA", "SPID", "ID", "NUM", "WS"
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22); 
				stat();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << SYNCHRONIZED) | (1L << ID))) != 0) );
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
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				switch (_input.LA(1)) {
				case SHARED:
					{
					setState(27); 
					match(SHARED);
					setState(28); 
					target();
					}
					break;
				case INT:
				case BOOL:
					{
					setState(29); 
					target();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(32); 
				match(ID);
				setState(33); 
				match(ASSIGN);
				setState(34); 
				expr(0);
				setState(35); 
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				switch (_input.LA(1)) {
				case SHARED:
					{
					setState(37); 
					match(SHARED);
					setState(38); 
					target();
					}
					break;
				case INT:
				case BOOL:
					{
					setState(39); 
					target();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
				match(ID);
				setState(43); 
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45); 
				match(ID);
				setState(46); 
				match(ASSIGN);
				setState(47); 
				expr(0);
				setState(48); 
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(50); 
				ifcompare();
				setState(51); 
				match(LCURLY);
				setState(52); 
				ifbody();
				setState(53); 
				match(RCURLY);
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55); 
				whilecompare();
				setState(56); 
				match(LCURLY);
				setState(57); 
				whilebody();
				setState(58); 
				match(RCURLY);
				}
				break;
			case 6:
				_localctx = new SynchronizedStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60); 
				match(SYNCHRONIZED);
				setState(61); 
				match(LCURLY);
				setState(62); 
				synchronizedbody();
				setState(63); 
				match(RCURLY);
				}
				break;
			case 7:
				_localctx = new ArrayAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(65); 
				match(ID);
				setState(66); 
				match(LSQ);
				setState(67); 
				expr(0);
				setState(68); 
				match(RSQ);
				setState(69); 
				match(ASSIGN);
				setState(70); 
				expr(0);
				setState(71); 
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
			setState(75); 
			match(IF);
			setState(76); 
			match(LPAR);
			setState(77); 
			expr(0);
			setState(78); 
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
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(80); 
				stat();
				}
				}
				setState(85);
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
			setState(86); 
			match(WHILE);
			setState(87); 
			match(LPAR);
			setState(88); 
			expr(0);
			setState(89); 
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
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(91); 
				stat();
				}
				}
				setState(96);
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
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << SYNCHRONIZED) | (1L << ID))) != 0)) {
				{
				{
				setState(97); 
				stat();
				}
				}
				setState(102);
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
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); 
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); 
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
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); 
				type();
				setState(108); 
				match(LSQ);
				setState(109); 
				expr(0);
				setState(110); 
				match(RSQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); 
				type();
				setState(113); 
				match(LSQ);
				setState(114); 
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
	public static class SpidExprContext extends ExprContext {
		public TerminalNode SPID() { return getToken(GrammarParser.SPID, 0); }
		public SpidExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSpidExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSpidExpr(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119); 
				match(MINUS);
				setState(120); 
				expr(10);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
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
				setState(122); 
				match(LPAR);
				setState(123); 
				expr(0);
				setState(124); 
				match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126); 
				match(LCURLY);
				setState(127); 
				expr(0);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128); 
					match(COMMA);
					setState(129); 
					expr(0);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135); 
				match(RCURLY);
				}
				break;
			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137); 
				match(ID);
				setState(138); 
				match(LSQ);
				setState(139); 
				expr(0);
				setState(140); 
				match(RSQ);
				}
				break;
			case 6:
				{
				_localctx = new SpidExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142); 
				match(SPID);
				}
				break;
			case 7:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143); 
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new TimesDivideExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(147);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(148); 
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(150);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(151); 
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new CmpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(153); 
							match(LT);
							}
							break;
						case GT:
							{
							setState(154); 
							match(GT);
							}
							break;
						case LTE:
							{
							setState(155); 
							match(LTE);
							}
							break;
						case TRUE:
						case FALSE:
						case LPAR:
						case LCURLY:
						case MINUS:
						case SPID:
						case ID:
						case NUM:
							{
							}
							break;
						case GTE:
							{
							setState(157); 
							match(GTE);
							}
							break;
						case EQUAL:
							{
							setState(158); 
							match(EQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(161); 
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(163); 
						match(OR);
						setState(164); 
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166); 
						match(AND);
						setState(167); 
						expr(5);
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
		case 9: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 11);
		case 1: 
			return precpred(_ctx, 9);
		case 2: 
			return precpred(_ctx, 8);
		case 3: 
			return precpred(_ctx, 5);
		case 4: 
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3\4\3\4\3\5\7\5T\n\5\f\5\16\5W\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\7\7_\n\7\f\7\16\7b\13\7\3\b\7\be\n\b\f\b\16"+
		"\bh\13\b\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nw\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0085"+
		"\n\13\f\13\16\13\u0088\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0093\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00a2\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00ab\n\13\f\13\16\13\u00ae\13\13\3\f\3\f\3\f\2\3\24\r\2\4\6\b\n\f\16"+
		"\20\22\24\26\2\6\4\2\t\n!!\3\2\34\35\3\2\32\33\3\2\3\4\u00c5\2\31\3\2"+
		"\2\2\4K\3\2\2\2\6M\3\2\2\2\bU\3\2\2\2\nX\3\2\2\2\f`\3\2\2\2\16f\3\2\2"+
		"\2\20k\3\2\2\2\22v\3\2\2\2\24\u0092\3\2\2\2\26\u00af\3\2\2\2\30\32\5\4"+
		"\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2"+
		"\2\2\35\36\7\7\2\2\36!\5\20\t\2\37!\5\20\t\2 \35\3\2\2\2 \37\3\2\2\2!"+
		"\"\3\2\2\2\"#\7 \2\2#$\7\20\2\2$%\5\24\13\2%&\7\23\2\2&L\3\2\2\2\'(\7"+
		"\7\2\2(+\5\20\t\2)+\5\20\t\2*\'\3\2\2\2*)\3\2\2\2+,\3\2\2\2,-\7 \2\2-"+
		".\7\23\2\2.L\3\2\2\2/\60\7 \2\2\60\61\7\20\2\2\61\62\5\24\13\2\62\63\7"+
		"\23\2\2\63L\3\2\2\2\64\65\5\6\4\2\65\66\7\26\2\2\66\67\5\b\5\2\678\7\27"+
		"\2\28L\3\2\2\29:\5\n\6\2:;\7\26\2\2;<\5\f\7\2<=\7\27\2\2=L\3\2\2\2>?\7"+
		"\b\2\2?@\7\26\2\2@A\5\16\b\2AB\7\27\2\2BL\3\2\2\2CD\7 \2\2DE\7\30\2\2"+
		"EF\5\24\13\2FG\7\31\2\2GH\7\20\2\2HI\5\24\13\2IJ\7\23\2\2JL\3\2\2\2K "+
		"\3\2\2\2K*\3\2\2\2K/\3\2\2\2K\64\3\2\2\2K9\3\2\2\2K>\3\2\2\2KC\3\2\2\2"+
		"L\5\3\2\2\2MN\7\5\2\2NO\7\24\2\2OP\5\24\13\2PQ\7\25\2\2Q\7\3\2\2\2RT\5"+
		"\4\3\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\t\3\2\2\2WU\3\2\2\2XY"+
		"\7\6\2\2YZ\7\24\2\2Z[\5\24\13\2[\\\7\25\2\2\\\13\3\2\2\2]_\5\4\3\2^]\3"+
		"\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\r\3\2\2\2b`\3\2\2\2ce\5\4\3\2dc"+
		"\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\17\3\2\2\2hf\3\2\2\2il\5\26\f"+
		"\2jl\5\22\n\2ki\3\2\2\2kj\3\2\2\2l\21\3\2\2\2mn\5\26\f\2no\7\30\2\2op"+
		"\5\24\13\2pq\7\31\2\2qw\3\2\2\2rs\5\26\f\2st\7\30\2\2tu\7\31\2\2uw\3\2"+
		"\2\2vm\3\2\2\2vr\3\2\2\2w\23\3\2\2\2xy\b\13\1\2yz\7\33\2\2z\u0093\5\24"+
		"\13\f{\u0093\t\2\2\2|}\7\24\2\2}~\5\24\13\2~\177\7\25\2\2\177\u0093\3"+
		"\2\2\2\u0080\u0081\7\26\2\2\u0081\u0086\5\24\13\2\u0082\u0083\7\36\2\2"+
		"\u0083\u0085\5\24\13\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7\27\2\2\u008a\u0093\3\2\2\2\u008b\u008c\7 \2\2\u008c\u008d\7\30"+
		"\2\2\u008d\u008e\5\24\13\2\u008e\u008f\7\31\2\2\u008f\u0093\3\2\2\2\u0090"+
		"\u0093\7\37\2\2\u0091\u0093\7 \2\2\u0092x\3\2\2\2\u0092{\3\2\2\2\u0092"+
		"|\3\2\2\2\u0092\u0080\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0092\u0091\3\2\2\2\u0093\u00ac\3\2\2\2\u0094\u0095\f\r\2\2\u0095\u0096"+
		"\t\3\2\2\u0096\u00ab\5\24\13\16\u0097\u0098\f\13\2\2\u0098\u0099\t\4\2"+
		"\2\u0099\u00ab\5\24\13\f\u009a\u00a1\f\n\2\2\u009b\u00a2\7\f\2\2\u009c"+
		"\u00a2\7\16\2\2\u009d\u00a2\7\r\2\2\u009e\u00a2\3\2\2\2\u009f\u00a2\7"+
		"\17\2\2\u00a0\u00a2\7\13\2\2\u00a1\u009b\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00ab\5\24\13\13\u00a4\u00a5\f\7\2\2\u00a5"+
		"\u00a6\7\21\2\2\u00a6\u00ab\5\24\13\b\u00a7\u00a8\f\6\2\2\u00a8\u00a9"+
		"\7\22\2\2\u00a9\u00ab\5\24\13\7\u00aa\u0094\3\2\2\2\u00aa\u0097\3\2\2"+
		"\2\u00aa\u009a\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\t\5\2\2\u00b0\27\3\2\2\2\20\33 *KU`fkv\u0086"+
		"\u0092\u00a1\u00aa\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}