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
		INT=1, BOOL=2, IF=3, WHILE=4, SHARED=5, PROCEDURE=6, TRUE=7, FALSE=8, 
		EQUAL=9, NOTEQUAL=10, LT=11, LTE=12, GT=13, GTE=14, ASSIGN=15, OR=16, 
		AND=17, SEMI=18, LPAR=19, RPAR=20, LCURLY=21, RCURLY=22, LSQ=23, RSQ=24, 
		PLUS=25, MINUS=26, TIMES=27, DIVIDE=28, MODULO=29, COMMA=30, ID=31, NUM=32, 
		WS=33;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_ifbody = 2, RULE_target = 3, RULE_arraytype = 4, 
		RULE_procedure = 5, RULE_expr = 6, RULE_type = 7;
	public static final String[] ruleNames = {
		"program", "stat", "ifbody", "target", "arraytype", "procedure", "expr", 
		"type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'integer'", "'boolean'", "'if'", "'while'", "'shared'", "'procedure'", 
		"'true'", "'false'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'='", 
		"'||'", "'&&'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "BOOL", "IF", "WHILE", "SHARED", "PROCEDURE", "TRUE", "FALSE", 
		"EQUAL", "NOTEQUAL", "LT", "LTE", "GT", "GTE", "ASSIGN", "OR", "AND", 
		"SEMI", "LPAR", "RPAR", "LCURLY", "RCURLY", "LSQ", "RSQ", "PLUS", "MINUS", 
		"TIMES", "DIVIDE", "MODULO", "COMMA", "ID", "NUM", "WS"
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); 
				stat();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << ID))) != 0) );
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
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
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
	public static class SharedDeclStatContext extends StatContext {
		public TerminalNode SHARED() { return getToken(GrammarParser.SHARED, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public SharedDeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSharedDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSharedDeclStat(this);
		}
	}
	public static class DeclStatContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
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
		public TerminalNode WHILE() { return getToken(GrammarParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
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
		int _la;
		try {
			setState(61);
			switch (_input.LA(1)) {
			case SHARED:
				_localctx = new SharedDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21); 
				match(SHARED);
				setState(22); 
				target();
				setState(23); 
				match(ID);
				setState(24); 
				match(ASSIGN);
				setState(25); 
				expr(0);
				setState(26); 
				match(SEMI);
				}
				break;
			case INT:
			case BOOL:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28); 
				target();
				setState(29); 
				match(ID);
				setState(30); 
				match(ASSIGN);
				setState(31); 
				expr(0);
				setState(32); 
				match(SEMI);
				}
				break;
			case ID:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
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
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(39); 
				match(IF);
				setState(40); 
				match(LPAR);
				setState(41); 
				expr(0);
				setState(42); 
				match(RPAR);
				setState(43); 
				match(LCURLY);
				setState(44); 
				ifbody();
				setState(45); 
				match(RCURLY);
				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(47); 
				match(WHILE);
				setState(48); 
				match(LPAR);
				setState(49); 
				expr(0);
				setState(50); 
				match(RPAR);
				setState(51); 
				match(LCURLY);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << ID))) != 0)) {
					{
					{
					setState(52); 
					stat();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58); 
				match(RCURLY);
				}
				break;
			case PROCEDURE:
				_localctx = new ProcedureStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60); 
				procedure();
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
		enterRule(_localctx, 4, RULE_ifbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << ID))) != 0)) {
				{
				{
				setState(63); 
				stat();
				}
				}
				setState(68);
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
		enterRule(_localctx, 6, RULE_target);
		try {
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); 
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); 
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
		enterRule(_localctx, 8, RULE_arraytype);
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); 
				type();
				setState(74); 
				match(LSQ);
				setState(75); 
				expr(0);
				setState(76); 
				match(RSQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); 
				type();
				setState(79); 
				match(LSQ);
				setState(80); 
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
		enterRule(_localctx, 10, RULE_procedure);
		int _la;
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new NoParamProcedureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84); 
				match(PROCEDURE);
				setState(85); 
				match(ID);
				setState(86); 
				match(LPAR);
				setState(87); 
				match(RPAR);
				setState(88); 
				match(LCURLY);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << ID))) != 0)) {
					{
					{
					setState(89); 
					stat();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95); 
				match(RCURLY);
				}
				break;
			case 2:
				_localctx = new ParamProcedureContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); 
				match(PROCEDURE);
				setState(97); 
				match(ID);
				setState(98); 
				match(LPAR);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT || _la==BOOL) {
					{
					{
					setState(99); 
					target();
					setState(100); 
					match(ID);
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(101); 
						match(COMMA);
						setState(102); 
						target();
						setState(103); 
						match(ID);
						}
						}
						setState(109);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115); 
				match(RPAR);
				setState(116); 
				match(LCURLY);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << SHARED) | (1L << PROCEDURE) | (1L << ID))) != 0)) {
					{
					{
					setState(117); 
					stat();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123); 
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
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public List<TerminalNode> NUM() { return getTokens(GrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(GrammarParser.NUM, i);
		}
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(127); 
				match(MINUS);
				setState(128); 
				expr(8);
				}
				break;
			case TRUE:
			case FALSE:
			case NUM:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case LPAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130); 
				match(LPAR);
				setState(131); 
				expr(0);
				setState(132); 
				match(RPAR);
				}
				break;
			case LCURLY:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134); 
				match(LCURLY);
				setState(135); 
				match(NUM);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136); 
					match(COMMA);
					setState(137); 
					match(NUM);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143); 
				match(RCURLY);
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144); 
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new TimesDivideExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(148);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIVIDE) | (1L << MODULO))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(149); 
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(151);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(152); 
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new CmpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(161);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(154); 
							match(LT);
							}
							break;
						case GT:
							{
							setState(155); 
							match(GT);
							}
							break;
						case LTE:
							{
							setState(156); 
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
							setState(158); 
							match(GTE);
							}
							break;
						case EQUAL:
							{
							setState(159); 
							match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(160); 
							match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(163); 
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165); 
						match(OR);
						setState(166); 
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(168); 
						match(AND);
						setState(169); 
						expr(3);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
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
		case 6: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 9);
		case 1: 
			return precpred(_ctx, 7);
		case 2: 
			return precpred(_ctx, 6);
		case 3: 
			return precpred(_ctx, 3);
		case 4: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00b4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2"+
		"\r\2\16\2\25\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\5\3@\n\3\3\4\7\4C\n\4\f\4\16\4F\13"+
		"\4\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6U\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\7\7q\n\7\f\7\16\7t\13\7\3\7\3\7\3"+
		"\7\7\7y\n\7\f\7\16\7|\13\7\3\7\5\7\177\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\b\u008d\n\b\f\b\16\b\u0090\13\b\3\b\3\b\5\b\u0094"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a4"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ad\n\b\f\b\16\b\u00b0\13\b\3\t"+
		"\3\t\3\t\2\3\16\n\2\4\6\b\n\f\16\20\2\6\4\2\t\n\"\"\3\2\35\37\3\2\33\34"+
		"\3\2\3\4\u00ca\2\23\3\2\2\2\4?\3\2\2\2\6D\3\2\2\2\bI\3\2\2\2\nT\3\2\2"+
		"\2\f~\3\2\2\2\16\u0093\3\2\2\2\20\u00b1\3\2\2\2\22\24\5\4\3\2\23\22\3"+
		"\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\30\7"+
		"\7\2\2\30\31\5\b\5\2\31\32\7!\2\2\32\33\7\21\2\2\33\34\5\16\b\2\34\35"+
		"\7\24\2\2\35@\3\2\2\2\36\37\5\b\5\2\37 \7!\2\2 !\7\21\2\2!\"\5\16\b\2"+
		"\"#\7\24\2\2#@\3\2\2\2$%\7!\2\2%&\7\21\2\2&\'\5\16\b\2\'(\7\24\2\2(@\3"+
		"\2\2\2)*\7\5\2\2*+\7\25\2\2+,\5\16\b\2,-\7\26\2\2-.\7\27\2\2./\5\6\4\2"+
		"/\60\7\30\2\2\60@\3\2\2\2\61\62\7\6\2\2\62\63\7\25\2\2\63\64\5\16\b\2"+
		"\64\65\7\26\2\2\659\7\27\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3"+
		"\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\30\2\2=@\3\2\2\2>@\5\f\7\2?\27"+
		"\3\2\2\2?\36\3\2\2\2?$\3\2\2\2?)\3\2\2\2?\61\3\2\2\2?>\3\2\2\2@\5\3\2"+
		"\2\2AC\5\4\3\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FD\3"+
		"\2\2\2GJ\5\20\t\2HJ\5\n\6\2IG\3\2\2\2IH\3\2\2\2J\t\3\2\2\2KL\5\20\t\2"+
		"LM\7\31\2\2MN\5\16\b\2NO\7\32\2\2OU\3\2\2\2PQ\5\20\t\2QR\7\31\2\2RS\7"+
		"\32\2\2SU\3\2\2\2TK\3\2\2\2TP\3\2\2\2U\13\3\2\2\2VW\7\b\2\2WX\7!\2\2X"+
		"Y\7\25\2\2YZ\7\26\2\2Z^\7\27\2\2[]\5\4\3\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2"+
		"\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2a\177\7\30\2\2bc\7\b\2\2cd\7!\2\2dr"+
		"\7\25\2\2ef\5\b\5\2fm\7!\2\2gh\7 \2\2hi\5\b\5\2ij\7!\2\2jl\3\2\2\2kg\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pe\3\2\2\2qt\3"+
		"\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\26\2\2vz\7\27\2\2w"+
		"y\5\4\3\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2"+
		"}\177\7\30\2\2~V\3\2\2\2~b\3\2\2\2\177\r\3\2\2\2\u0080\u0081\b\b\1\2\u0081"+
		"\u0082\7\34\2\2\u0082\u0094\5\16\b\n\u0083\u0094\t\2\2\2\u0084\u0085\7"+
		"\25\2\2\u0085\u0086\5\16\b\2\u0086\u0087\7\26\2\2\u0087\u0094\3\2\2\2"+
		"\u0088\u0089\7\27\2\2\u0089\u008e\7\"\2\2\u008a\u008b\7 \2\2\u008b\u008d"+
		"\7\"\2\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0094\7\30"+
		"\2\2\u0092\u0094\7!\2\2\u0093\u0080\3\2\2\2\u0093\u0083\3\2\2\2\u0093"+
		"\u0084\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u00ae\3\2"+
		"\2\2\u0095\u0096\f\13\2\2\u0096\u0097\t\3\2\2\u0097\u00ad\5\16\b\f\u0098"+
		"\u0099\f\t\2\2\u0099\u009a\t\4\2\2\u009a\u00ad\5\16\b\n\u009b\u00a3\f"+
		"\b\2\2\u009c\u00a4\7\r\2\2\u009d\u00a4\7\17\2\2\u009e\u00a4\7\16\2\2\u009f"+
		"\u00a4\3\2\2\2\u00a0\u00a4\7\20\2\2\u00a1\u00a4\7\13\2\2\u00a2\u00a4\7"+
		"\f\2\2\u00a3\u009c\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3"+
		"\u009f\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00ad\5\16\b\t\u00a6\u00a7\f\5\2\2\u00a7"+
		"\u00a8\7\22\2\2\u00a8\u00ad\5\16\b\6\u00a9\u00aa\f\4\2\2\u00aa\u00ab\7"+
		"\23\2\2\u00ab\u00ad\5\16\b\5\u00ac\u0095\3\2\2\2\u00ac\u0098\3\2\2\2\u00ac"+
		"\u009b\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\17\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b1\u00b2\t\5\2\2\u00b2\21\3\2\2\2\22\259?DIT^mrz~\u008e\u0093"+
		"\u00a3\u00ac\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}