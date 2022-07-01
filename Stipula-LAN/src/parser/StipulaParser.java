// Generated from Stipula.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StipulaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, DOT=4, EQ=5, NEQ=6, IMPL=7, ASM=8, ASSETUP=9, 
		FIELDUP=10, PLUS=11, MINUS=12, TIMES=13, DIV=14, AT=15, TRUE=16, FALSE=17, 
		LPAR=18, RPAR=19, SLPAR=20, SRPAR=21, CLPAR=22, CRPAR=23, LEQ=24, GEQ=25, 
		LE=26, GE=27, OR=28, AND=29, NOT=30, EMPTY=31, NOW=32, TRIGGER=33, IF=34, 
		ELSEIF=35, ELSE=36, STIPULA=37, ASSET=38, FIELD=39, AGREEMENT=40, INTEGER=41, 
		DOUBLE=42, BOOLEAN=43, PARTY=44, INIT=45, INT=46, REAL=47, WS=48, ID=49, 
		OTHER=50, LINECOMENTS=51, BLOCKCOMENTS=52, ERR=53;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "','", "'.'", "'=='", "'!='", "'==>'", "'='", 
		"'-○'", "'->'", "'+'", "'-'", "'*'", "'/'", "'@'", "'true'", "'false'", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", "'<='", "'>='", "'<'", "'>'", 
		"'||'", "'&&'", "'!'", "'_'", "'now'", "'>>'", "'if'", "'else if'", "'else'", 
		"'stipula'", "'asset'", "'field'", "'agreement'", "'int'", "'real'", "'bool'", 
		"'party'", "'init'", "INT", "REAL", "WS", "ID", "OTHER", "LINECOMENTS", 
		"BLOCKCOMENTS", "ERR"
	};
	public static final int
		RULE_prog = 0, RULE_id = 1, RULE_agreement = 2, RULE_fun = 3, RULE_assign = 4, 
		RULE_declist = 5, RULE_strings = 6, RULE_type = 7, RULE_state = 8, RULE_disputer = 9, 
		RULE_vardec = 10, RULE_assetdec = 11, RULE_varasm = 12, RULE_stat = 13, 
		RULE_ifelse = 14, RULE_events = 15, RULE_prec = 16, RULE_expr = 17, RULE_term = 18, 
		RULE_factor = 19, RULE_value = 20, RULE_real = 21, RULE_number = 22;
	public static final String[] ruleNames = {
		"prog", "id", "agreement", "fun", "assign", "declist", "strings", "type", 
		"state", "disputer", "vardec", "assetdec", "varasm", "stat", "ifelse", 
		"events", "prec", "expr", "term", "factor", "value", "real", "number"
	};

	@Override
	public String getGrammarFileName() { return "Stipula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StipulaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclistContext declist(int i) {
			return getRuleContext(DeclistContext.class,i);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode STIPULA() { return getToken(StipulaParser.STIPULA, 0); }
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public AgreementContext agreement() {
			return getRuleContext(AgreementContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public List<DeclistContext> declist() {
			return getRuleContexts(DeclistContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(STIPULA);
			setState(47); id();
			setState(48); match(CLPAR);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSET) | (1L << FIELD) | (1L << INTEGER) | (1L << DOUBLE) | (1L << BOOLEAN) | (1L << PARTY) | (1L << INIT))) != 0)) {
				{
				{
				setState(49); declist();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			_la = _input.LA(1);
			if (_la==AGREEMENT) {
				{
				setState(55); agreement();
				}
			}

			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58); fun();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT );
			setState(63); match(CRPAR);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(ID);
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

	public static class AgreementContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(StipulaParser.AT, 0); }
		public DisputerContext disputer(int i) {
			return getRuleContext(DisputerContext.class,i);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public TerminalNode AGREEMENT() { return getToken(StipulaParser.AGREEMENT, 0); }
		public List<TerminalNode> LPAR() { return getTokens(StipulaParser.LPAR); }
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
		}
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public TerminalNode RPAR(int i) {
			return getToken(StipulaParser.RPAR, i);
		}
		public TerminalNode LPAR(int i) {
			return getToken(StipulaParser.LPAR, i);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public List<TerminalNode> RPAR() { return getTokens(StipulaParser.RPAR); }
		public List<DisputerContext> disputer() {
			return getRuleContexts(DisputerContext.class);
		}
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public AgreementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterAgreement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitAgreement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitAgreement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgreementContext agreement() throws RecognitionException {
		AgreementContext _localctx = new AgreementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_agreement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67); match(AGREEMENT);
			setState(68); match(LPAR);
			setState(69); disputer();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70); match(COMMA);
				setState(71); disputer();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77); match(RPAR);
			setState(78); match(LPAR);
			setState(79); vardec();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80); match(COMMA);
				setState(81); vardec();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87); match(RPAR);
			setState(88); match(CLPAR);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89); assign();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(94); match(CRPAR);
			setState(95); match(IMPL);
			setState(96); match(AT);
			setState(97); state();
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

	public static class FunContext extends ParserRuleContext {
		public List<TerminalNode> AT() { return getTokens(StipulaParser.AT); }
		public List<AssetdecContext> assetdec() {
			return getRuleContexts(AssetdecContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode AT(int i) {
			return getToken(StipulaParser.AT, i);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode SLPAR() { return getToken(StipulaParser.SLPAR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(StipulaParser.RPAR, i);
		}
		public TerminalNode LPAR(int i) {
			return getToken(StipulaParser.LPAR, i);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public List<EventsContext> events() {
			return getRuleContexts(EventsContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public AssetdecContext assetdec(int i) {
			return getRuleContext(AssetdecContext.class,i);
		}
		public List<DisputerContext> disputer() {
			return getRuleContexts(DisputerContext.class);
		}
		public EventsContext events(int i) {
			return getRuleContext(EventsContext.class,i);
		}
		public DisputerContext disputer(int i) {
			return getRuleContext(DisputerContext.class,i);
		}
		public PrecContext prec() {
			return getRuleContext(PrecContext.class,0);
		}
		public TerminalNode SRPAR() { return getToken(StipulaParser.SRPAR, 0); }
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public List<TerminalNode> LPAR() { return getTokens(StipulaParser.LPAR); }
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public TerminalNode SEMIC() { return getToken(StipulaParser.SEMIC, 0); }
		public List<TerminalNode> RPAR() { return getTokens(StipulaParser.RPAR); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(99); match(AT);
			setState(100); state();
			setState(101); disputer();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(102); match(COMMA);
				setState(103); disputer();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); match(COLON);
			setState(110); id();
			setState(111); match(LPAR);
			setState(120);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(112); vardec();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(113); match(COMMA);
					setState(114); vardec();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(122); match(RPAR);
			setState(123); match(SLPAR);
			setState(132);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(124); assetdec();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125); match(COMMA);
					setState(126); assetdec();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134); match(SRPAR);
			setState(139);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(135); match(LPAR);
				setState(136); prec();
				setState(137); match(RPAR);
				}
			}

			setState(141); match(CLPAR);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142); stat();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
			setState(147); match(SEMIC);
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148); events();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
			setState(153); match(CRPAR);
			setState(154); match(IMPL);
			setState(155); match(AT);
			setState(156); state();
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

	public static class AssignContext extends ParserRuleContext {
		public DisputerContext disputer(int i) {
			return getRuleContext(DisputerContext.class,i);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
		public List<DisputerContext> disputer() {
			return getRuleContexts(DisputerContext.class);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(158); disputer();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(159); match(COMMA);
				setState(160); disputer();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166); match(COLON);
			setState(167); vardec();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(168); match(COMMA);
				setState(169); vardec();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclistContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public DeclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterDeclist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitDeclist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitDeclist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclistContext declist() throws RecognitionException {
		DeclistContext _localctx = new DeclistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); type();
			setState(176); strings();
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

	public static class StringsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_strings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(ID);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(StipulaParser.INTEGER, 0); }
		public TerminalNode FIELD() { return getToken(StipulaParser.FIELD, 0); }
		public TerminalNode INIT() { return getToken(StipulaParser.INIT, 0); }
		public TerminalNode ASSET() { return getToken(StipulaParser.ASSET, 0); }
		public TerminalNode BOOLEAN() { return getToken(StipulaParser.BOOLEAN, 0); }
		public TerminalNode DOUBLE() { return getToken(StipulaParser.DOUBLE, 0); }
		public TerminalNode PARTY() { return getToken(StipulaParser.PARTY, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSET) | (1L << FIELD) | (1L << INTEGER) | (1L << DOUBLE) | (1L << BOOLEAN) | (1L << PARTY) | (1L << INIT))) != 0)) ) {
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

	public static class StateContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); strings();
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

	public static class DisputerContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public DisputerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disputer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterDisputer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitDisputer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitDisputer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisputerContext disputer() throws RecognitionException {
		DisputerContext _localctx = new DisputerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_disputer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); strings();
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

	public static class VardecContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); strings();
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

	public static class AssetdecContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public AssetdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterAssetdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitAssetdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitAssetdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetdecContext assetdec() throws RecognitionException {
		AssetdecContext _localctx = new AssetdecContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assetdec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); strings();
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

	public static class VarasmContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASM() { return getToken(StipulaParser.ASM, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterVarasm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitVarasm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitVarasm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); vardec();
			setState(191); match(ASM);
			setState(192); expr();
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
		public ValueContext left;
		public Token operator;
		public ValueContext right;
		public ValueContext rightPlus;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode ASSETUP() { return getToken(StipulaParser.ASSETUP, 0); }
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(StipulaParser.COMMA, 0); }
		public TerminalNode FIELDUP() { return getToken(StipulaParser.FIELDUP, 0); }
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stat);
		int _la;
		try {
			setState(210);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194); match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(195); ((StatContext)_localctx).left = value();
				setState(196); ((StatContext)_localctx).operator = match(ASSETUP);
				setState(197); ((StatContext)_localctx).right = value();
				setState(200);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(198); match(COMMA);
					setState(199); ((StatContext)_localctx).rightPlus = value();
					}
				}

				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(202); ((StatContext)_localctx).left = value();
				setState(203); ((StatContext)_localctx).operator = match(FIELDUP);
				setState(204); ((StatContext)_localctx).right = value();
				setState(207);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(205); match(COMMA);
					setState(206); ((StatContext)_localctx).rightPlus = value();
					}
				}

				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209); ifelse();
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

	public static class IfelseContext extends ParserRuleContext {
		public ExprContext cond;
		public StatContext stat;
		public List<StatContext> ifBranch = new ArrayList<StatContext>();
		public ExprContext expr;
		public List<ExprContext> condElseIf = new ArrayList<ExprContext>();
		public List<StatContext> elseIfBranch = new ArrayList<StatContext>();
		public List<StatContext> elseBranch = new ArrayList<StatContext>();
		public List<TerminalNode> ELSEIF() { return getTokens(StipulaParser.ELSEIF); }
		public TerminalNode ELSE() { return getToken(StipulaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(StipulaParser.IF, 0); }
		public List<TerminalNode> CRPAR() { return getTokens(StipulaParser.CRPAR); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LPAR() { return getToken(StipulaParser.LPAR, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(StipulaParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(StipulaParser.CLPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CRPAR(int i) {
			return getToken(StipulaParser.CRPAR, i);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSEIF(int i) {
			return getToken(StipulaParser.ELSEIF, i);
		}
		public TerminalNode RPAR() { return getToken(StipulaParser.RPAR, 0); }
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitIfelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(212); match(IF);
			setState(213); match(LPAR);
			setState(214); ((IfelseContext)_localctx).cond = expr();
			setState(215); match(RPAR);
			setState(216); match(CLPAR);
			setState(217); ((IfelseContext)_localctx).stat = stat();
			((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
				{
				{
				setState(218); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224); match(CRPAR);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(225); match(ELSEIF);
				setState(226); ((IfelseContext)_localctx).expr = expr();
				((IfelseContext)_localctx).condElseIf.add(((IfelseContext)_localctx).expr);
				setState(227); match(CLPAR);
				setState(228); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
					{
					{
					setState(229); ((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235); match(CRPAR);
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(242); match(ELSE);
				setState(243); match(CLPAR);
				setState(244); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
					{
					{
					setState(245); ((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251); match(CRPAR);
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

	public static class EventsContext extends ParserRuleContext {
		public List<TerminalNode> AT() { return getTokens(StipulaParser.AT); }
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AT(int i) {
			return getToken(StipulaParser.AT, i);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public TerminalNode TRIGGER() { return getToken(StipulaParser.TRIGGER, 0); }
		public EventsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_events; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterEvents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitEvents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitEvents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventsContext events() throws RecognitionException {
		EventsContext _localctx = new EventsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_events);
		int _la;
		try {
			setState(271);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255); match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(256); expr();
				setState(257); match(TRIGGER);
				setState(258); match(AT);
				setState(259); match(ID);
				setState(260); match(CLPAR);
				setState(262); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(261); stat();
					}
					}
					setState(264); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
				setState(266); match(CRPAR);
				setState(267); match(IMPL);
				setState(268); match(AT);
				setState(269); match(ID);
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

	public static class PrecContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterPrec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitPrec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitPrec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecContext prec() throws RecognitionException {
		PrecContext _localctx = new PrecContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_prec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); expr();
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
		public TermContext left;
		public Token operator;
		public ExprContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(StipulaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(StipulaParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(StipulaParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(275); match(MINUS);
				}
			}

			setState(278); ((ExprContext)_localctx).left = term();
			setState(281);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) {
				{
				setState(279);
				((ExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) ) {
					((ExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(280); ((ExprContext)_localctx).right = expr();
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public Token operator;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(StipulaParser.TIMES, 0); }
		public TerminalNode AND() { return getToken(StipulaParser.AND, 0); }
		public TerminalNode DIV() { return getToken(StipulaParser.DIV, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); ((TermContext)_localctx).left = factor();
			setState(286);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) {
				{
				setState(284);
				((TermContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) ) {
					((TermContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(285); ((TermContext)_localctx).right = term();
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public Token operator;
		public ValueContext right;
		public TerminalNode GEQ() { return getToken(StipulaParser.GEQ, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode GE() { return getToken(StipulaParser.GE, 0); }
		public TerminalNode NEQ() { return getToken(StipulaParser.NEQ, 0); }
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(StipulaParser.LEQ, 0); }
		public TerminalNode LE() { return getToken(StipulaParser.LE, 0); }
		public TerminalNode EQ() { return getToken(StipulaParser.EQ, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); ((FactorContext)_localctx).left = value();
			setState(291);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LE) | (1L << GE))) != 0)) {
				{
				setState(289);
				((FactorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LE) | (1L << GE))) != 0)) ) {
					((FactorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(290); ((FactorContext)_localctx).right = value();
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

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode NOW() { return getToken(StipulaParser.NOW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(StipulaParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(StipulaParser.TRUE, 0); }
		public TerminalNode LPAR() { return getToken(StipulaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(StipulaParser.RPAR, 0); }
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		int _la;
		try {
			setState(302);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(293); number();
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(294); match(NOW);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(295); match(LPAR);
				setState(296); expr();
				setState(297); match(RPAR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(299); strings();
				}
				break;
			case EMPTY:
				enterOuterAlt(_localctx, 5);
				{
				setState(300); match(EMPTY);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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

	public static class RealContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public TerminalNode DOT() { return getToken(StipulaParser.DOT, 0); }
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public RealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealContext real() throws RecognitionException {
		RealContext _localctx = new RealContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304); number();
			setState(305); match(DOT);
			setState(306); number();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(StipulaParser.REAL, 0); }
		public TerminalNode INT() { return getToken(StipulaParser.INT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==REAL) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0139\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\5\2;\n\2\3\2\6\2>\n\2\r\2\16\2?\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\6\4]\n\4\r\4\16\4^\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5v\n\5\f\5\16\5y\13\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u0082\n\5\f\5\16\5\u0085\13\5\5\5\u0087\n\5\3\5\3\5\3\5\3\5\3\5\5\5\u008e"+
		"\n\5\3\5\3\5\6\5\u0092\n\5\r\5\16\5\u0093\3\5\3\5\6\5\u0098\n\5\r\5\16"+
		"\5\u0099\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u00a4\n\6\f\6\16\6\u00a7"+
		"\13\6\3\6\3\6\3\6\3\6\7\6\u00ad\n\6\f\6\16\6\u00b0\13\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00d2\n\17\3\17\5\17\u00d5\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u00de\n\20\f\20\16\20\u00e1\13\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20\3\20\3\20\7\20\u00f0\n\20\f"+
		"\20\16\20\u00f3\13\20\3\20\3\20\3\20\3\20\7\20\u00f9\n\20\f\20\16\20\u00fc"+
		"\13\20\3\20\3\20\5\20\u0100\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6"+
		"\21\u0109\n\21\r\21\16\21\u010a\3\21\3\21\3\21\3\21\3\21\5\21\u0112\n"+
		"\21\3\22\3\22\3\23\5\23\u0117\n\23\3\23\3\23\3\23\5\23\u011c\n\23\3\24"+
		"\3\24\3\24\5\24\u0121\n\24\3\25\3\25\3\25\5\25\u0126\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0131\n\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\2\b\4\2()+/\4\2\r\16\36\36\4\2\17\20\37\37\4\2\7\b\32\35\3\2\22\23\3"+
		"\2\60\61\u0146\2\60\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\be\3\2\2\2\n\u00a0\3"+
		"\2\2\2\f\u00b1\3\2\2\2\16\u00b4\3\2\2\2\20\u00b6\3\2\2\2\22\u00b8\3\2"+
		"\2\2\24\u00ba\3\2\2\2\26\u00bc\3\2\2\2\30\u00be\3\2\2\2\32\u00c0\3\2\2"+
		"\2\34\u00d4\3\2\2\2\36\u00d6\3\2\2\2 \u0111\3\2\2\2\"\u0113\3\2\2\2$\u0116"+
		"\3\2\2\2&\u011d\3\2\2\2(\u0122\3\2\2\2*\u0130\3\2\2\2,\u0132\3\2\2\2."+
		"\u0136\3\2\2\2\60\61\7\'\2\2\61\62\5\4\3\2\62\66\7\30\2\2\63\65\5\f\7"+
		"\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\29;\5\6\4\2:9\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\5\b\5\2=<\3\2\2"+
		"\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\31\2\2B\3\3\2\2\2CD\7\63"+
		"\2\2D\5\3\2\2\2EF\7*\2\2FG\7\24\2\2GL\5\24\13\2HI\7\5\2\2IK\5\24\13\2"+
		"JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\25\2"+
		"\2PQ\7\24\2\2QV\5\26\f\2RS\7\5\2\2SU\5\26\f\2TR\3\2\2\2UX\3\2\2\2VT\3"+
		"\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\25\2\2Z\\\7\30\2\2[]\5\n\6\2"+
		"\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\31\2\2ab\7\t"+
		"\2\2bc\7\21\2\2cd\5\22\n\2d\7\3\2\2\2ef\7\21\2\2fg\5\22\n\2gl\5\24\13"+
		"\2hi\7\5\2\2ik\5\24\13\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2"+
		"\2\2nl\3\2\2\2op\7\4\2\2pq\5\4\3\2qz\7\24\2\2rw\5\26\f\2st\7\5\2\2tv\5"+
		"\26\f\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zr"+
		"\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\25\2\2}\u0086\7\26\2\2~\u0083\5\30\r"+
		"\2\177\u0080\7\5\2\2\u0080\u0082\5\30\r\2\u0081\177\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086~\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u008d\7\27\2\2\u0089\u008a\7\24\2\2\u008a\u008b\5\"\22\2\u008b"+
		"\u008c\7\25\2\2\u008c\u008e\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\7\30\2\2\u0090\u0092\5\34\17\2"+
		"\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\7\3\2\2\u0096\u0098\5 \21\2\u0097"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\31\2\2\u009c\u009d\7\t\2\2\u009d"+
		"\u009e\7\21\2\2\u009e\u009f\5\22\n\2\u009f\t\3\2\2\2\u00a0\u00a5\5\24"+
		"\13\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\5\24\13\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\4\2\2\u00a9\u00ae\5\26\f\2\u00aa"+
		"\u00ab\7\5\2\2\u00ab\u00ad\5\26\f\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\13\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\5\20\t\2\u00b2\u00b3\5\16\b\2\u00b3\r\3\2\2"+
		"\2\u00b4\u00b5\7\63\2\2\u00b5\17\3\2\2\2\u00b6\u00b7\t\2\2\2\u00b7\21"+
		"\3\2\2\2\u00b8\u00b9\5\16\b\2\u00b9\23\3\2\2\2\u00ba\u00bb\5\16\b\2\u00bb"+
		"\25\3\2\2\2\u00bc\u00bd\5\16\b\2\u00bd\27\3\2\2\2\u00be\u00bf\5\16\b\2"+
		"\u00bf\31\3\2\2\2\u00c0\u00c1\5\26\f\2\u00c1\u00c2\7\n\2\2\u00c2\u00c3"+
		"\5$\23\2\u00c3\33\3\2\2\2\u00c4\u00d5\7!\2\2\u00c5\u00c6\5*\26\2\u00c6"+
		"\u00c7\7\13\2\2\u00c7\u00ca\5*\26\2\u00c8\u00c9\7\5\2\2\u00c9\u00cb\5"+
		"*\26\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00d5\3\2\2\2\u00cc"+
		"\u00cd\5*\26\2\u00cd\u00ce\7\f\2\2\u00ce\u00d1\5*\26\2\u00cf\u00d0\7\5"+
		"\2\2\u00d0\u00d2\5*\26\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d5\3\2\2\2\u00d3\u00d5\5\36\20\2\u00d4\u00c4\3\2\2\2\u00d4\u00c5\3"+
		"\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\35\3\2\2\2\u00d6"+
		"\u00d7\7$\2\2\u00d7\u00d8\7\24\2\2\u00d8\u00d9\5$\23\2\u00d9\u00da\7\25"+
		"\2\2\u00da\u00db\7\30\2\2\u00db\u00df\5\34\17\2\u00dc\u00de\5\34\17\2"+
		"\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00f1\7\31\2\2"+
		"\u00e3\u00e4\7%\2\2\u00e4\u00e5\5$\23\2\u00e5\u00e6\7\30\2\2\u00e6\u00ea"+
		"\5\34\17\2\u00e7\u00e9\5\34\17\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2"+
		"\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ed\u00ee\7\31\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e3\3\2\2\2"+
		"\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00ff"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7&\2\2\u00f5\u00f6\7\30\2\2\u00f6"+
		"\u00fa\5\34\17\2\u00f7\u00f9\5\34\17\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00fe\7\31\2\2\u00fe\u0100\3\2\2\2\u00ff\u00f4\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\37\3\2\2\2\u0101\u0112\7!\2\2\u0102\u0103"+
		"\5$\23\2\u0103\u0104\7#\2\2\u0104\u0105\7\21\2\2\u0105\u0106\7\63\2\2"+
		"\u0106\u0108\7\30\2\2\u0107\u0109\5\34\17\2\u0108\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\u010d\7\31\2\2\u010d\u010e\7\t\2\2\u010e\u010f\7\21\2\2\u010f"+
		"\u0110\7\63\2\2\u0110\u0112\3\2\2\2\u0111\u0101\3\2\2\2\u0111\u0102\3"+
		"\2\2\2\u0112!\3\2\2\2\u0113\u0114\5$\23\2\u0114#\3\2\2\2\u0115\u0117\7"+
		"\16\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011b\5&\24\2\u0119\u011a\t\3\2\2\u011a\u011c\5$\23\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c%\3\2\2\2\u011d\u0120\5(\25\2\u011e\u011f"+
		"\t\4\2\2\u011f\u0121\5&\24\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\'\3\2\2\2\u0122\u0125\5*\26\2\u0123\u0124\t\5\2\2\u0124\u0126\5*\26\2"+
		"\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126)\3\2\2\2\u0127\u0131\5"+
		".\30\2\u0128\u0131\7\"\2\2\u0129\u012a\7\24\2\2\u012a\u012b\5$\23\2\u012b"+
		"\u012c\7\25\2\2\u012c\u0131\3\2\2\2\u012d\u0131\5\16\b\2\u012e\u0131\7"+
		"!\2\2\u012f\u0131\t\6\2\2\u0130\u0127\3\2\2\2\u0130\u0128\3\2\2\2\u0130"+
		"\u0129\3\2\2\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2"+
		"\2\2\u0131+\3\2\2\2\u0132\u0133\5.\30\2\u0133\u0134\7\6\2\2\u0134\u0135"+
		"\5.\30\2\u0135-\3\2\2\2\u0136\u0137\t\7\2\2\u0137/\3\2\2\2!\66:?LV^lw"+
		"z\u0083\u0086\u008d\u0093\u0099\u00a5\u00ae\u00ca\u00d1\u00d4\u00df\u00ea"+
		"\u00f1\u00fa\u00ff\u010a\u0111\u0116\u011b\u0120\u0125\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}