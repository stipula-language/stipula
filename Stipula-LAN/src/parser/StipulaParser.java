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
		DOUBLE=42, BOOLEAN=43, STRING=44, PARTY=45, INIT=46, RAWSTRING=47, INT=48, 
		REAL=49, WS=50, ID=51, OTHER=52, LINECOMENTS=53, BLOCKCOMENTS=54, ERR=55;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "','", "'.'", "'=='", "'!='", "'==>'", "'='", 
		"'-o'", "'->'", "'+'", "'-'", "'*'", "'/'", "'@'", "'true'", "'false'", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", "'<='", "'>='", "'<'", "'>'", 
		"'||'", "'&&'", "'!'", "'_'", "'now'", "'>>'", "'if'", "'else if'", "'else'", 
		"'stipula'", "'asset'", "'field'", "'agreement'", "'int'", "'real'", "'bool'", 
		"'string'", "'party'", "'init'", "RAWSTRING", "INT", "REAL", "WS", "ID", 
		"OTHER", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};
	public static final int
		RULE_prog = 0, RULE_agreement = 1, RULE_assetdecl = 2, RULE_fielddecl = 3, 
		RULE_fun = 4, RULE_assign = 5, RULE_dec = 6, RULE_type = 7, RULE_state = 8, 
		RULE_party = 9, RULE_vardec = 10, RULE_assetdec = 11, RULE_varasm = 12, 
		RULE_stat = 13, RULE_ifelse = 14, RULE_events = 15, RULE_prec = 16, RULE_expr = 17, 
		RULE_term = 18, RULE_factor = 19, RULE_value = 20, RULE_real = 21, RULE_number = 22;
	public static final String[] ruleNames = {
		"prog", "agreement", "assetdecl", "fielddecl", "fun", "assign", "dec", 
		"type", "state", "party", "vardec", "assetdec", "varasm", "stat", "ifelse", 
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
		public Token contract_id;
		public Token init_state;
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public FielddeclContext fielddecl() {
			return getRuleContext(FielddeclContext.class,0);
		}
		public TerminalNode INIT() { return getToken(StipulaParser.INIT, 0); }
		public AssetdeclContext assetdecl() {
			return getRuleContext(AssetdeclContext.class,0);
		}
		public TerminalNode STIPULA() { return getToken(StipulaParser.STIPULA, 0); }
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public AgreementContext agreement() {
			return getRuleContext(AgreementContext.class,0);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
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
			setState(47); ((ProgContext)_localctx).contract_id = match(ID);
			setState(48); match(CLPAR);
			setState(50);
			_la = _input.LA(1);
			if (_la==ASSET) {
				{
				setState(49); assetdecl();
				}
			}

			setState(53);
			_la = _input.LA(1);
			if (_la==FIELD) {
				{
				setState(52); fielddecl();
				}
			}

			setState(55); match(INIT);
			setState(56); ((ProgContext)_localctx).init_state = match(ID);
			setState(57); agreement();
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
			} while ( _la==AT || _la==ID );
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

	public static class AgreementContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(StipulaParser.AT, 0); }
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
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
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public List<TerminalNode> RPAR() { return getTokens(StipulaParser.RPAR); }
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
		enterRule(_localctx, 2, RULE_agreement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(65); match(AGREEMENT);
			setState(66); match(LPAR);
			setState(67); party();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(68); match(COMMA);
				setState(69); party();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75); match(RPAR);
			setState(76); match(LPAR);
			setState(77); vardec();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(78); match(COMMA);
				setState(79); vardec();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(RPAR);
			setState(86); match(CLPAR);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87); assign();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(92); match(CRPAR);
			setState(93); match(IMPL);
			setState(94); match(AT);
			setState(95); state();
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

	public static class AssetdeclContext extends ParserRuleContext {
		public Token ID;
		public List<Token> idAsset = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ASSET() { return getToken(StipulaParser.ASSET, 0); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public AssetdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterAssetdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitAssetdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitAssetdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetdeclContext assetdecl() throws RecognitionException {
		AssetdeclContext _localctx = new AssetdeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assetdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(ASSET);
			setState(98); ((AssetdeclContext)_localctx).ID = match(ID);
			((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99); match(COMMA);
				setState(100); ((AssetdeclContext)_localctx).ID = match(ID);
				((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
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

	public static class FielddeclContext extends ParserRuleContext {
		public Token ID;
		public List<Token> idField = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode FIELD() { return getToken(StipulaParser.FIELD, 0); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public FielddeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fielddecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterFielddecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitFielddecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitFielddecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FielddeclContext fielddecl() throws RecognitionException {
		FielddeclContext _localctx = new FielddeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fielddecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(FIELD);
			setState(107); ((FielddeclContext)_localctx).ID = match(ID);
			((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(108); match(COMMA);
				setState(109); ((FielddeclContext)_localctx).ID = match(ID);
				((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
				}
				}
				setState(114);
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

	public static class FunContext extends ParserRuleContext {
		public Token funId;
		public List<TerminalNode> AT() { return getTokens(StipulaParser.AT); }
		public List<AssetdecContext> assetdec() {
			return getRuleContexts(AssetdecContext.class);
		}
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode AT(int i) {
			return getToken(StipulaParser.AT, i);
		}
		public TerminalNode SLPAR() { return getToken(StipulaParser.SLPAR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(StipulaParser.RPAR, i);
		}
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
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
		public EventsContext events(int i) {
			return getRuleContext(EventsContext.class,i);
		}
		public PrecContext prec() {
			return getRuleContext(PrecContext.class,0);
		}
		public TerminalNode SRPAR() { return getToken(StipulaParser.SRPAR, 0); }
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
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
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
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
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(115); match(AT);
				setState(116); state();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122); party();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(123); match(COMMA);
				setState(124); party();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130); match(COLON);
			setState(131); ((FunContext)_localctx).funId = match(ID);
			setState(132); match(LPAR);
			setState(141);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(133); vardec();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134); match(COMMA);
					setState(135); vardec();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(143); match(RPAR);
			setState(144); match(SLPAR);
			setState(153);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(145); assetdec();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(146); match(COMMA);
					setState(147); assetdec();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(155); match(SRPAR);
			setState(160);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(156); match(LPAR);
				setState(157); prec();
				setState(158); match(RPAR);
				}
			}

			setState(162); match(CLPAR);
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163); stat();
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
			setState(168); match(SEMIC);
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169); events();
				}
				}
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
			setState(174); match(CRPAR);
			setState(175); match(IMPL);
			setState(176); match(AT);
			setState(177); state();
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
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
		}
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
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
		enterRule(_localctx, 10, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(179); party();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(180); match(COMMA);
				setState(181); party();
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187); match(COLON);
			setState(188); vardec();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(189); match(COMMA);
				setState(190); vardec();
				}
				}
				setState(195);
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

	public static class DecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public TerminalNode FIELD() { return getToken(StipulaParser.FIELD, 0); }
		public TerminalNode ASSET() { return getToken(StipulaParser.ASSET, 0); }
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !(_la==ASSET || _la==FIELD) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(197); match(ID);
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
		public TerminalNode STRING() { return getToken(StipulaParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(StipulaParser.BOOLEAN, 0); }
		public TerminalNode DOUBLE() { return getToken(StipulaParser.DOUBLE, 0); }
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
			setState(199);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << DOUBLE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) ) {
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
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
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
			setState(201); match(ID);
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

	public static class PartyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public PartyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_party; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterParty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitParty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitParty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartyContext party() throws RecognitionException {
		PartyContext _localctx = new PartyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_party);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(ID);
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
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
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
			setState(205); match(ID);
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
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
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
			setState(207); match(ID);
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
			setState(209); vardec();
			setState(210); match(ASM);
			setState(211); expr();
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
		public Token right;
		public Token rightPlus;
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ASSETUP() { return getToken(StipulaParser.ASSETUP, 0); }
		public TerminalNode COMMA() { return getToken(StipulaParser.COMMA, 0); }
		public TerminalNode FIELDUP() { return getToken(StipulaParser.FIELDUP, 0); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
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
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213); match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214); ((StatContext)_localctx).left = value();
				setState(215); ((StatContext)_localctx).operator = match(ASSETUP);
				setState(216); ((StatContext)_localctx).right = match(ID);
				setState(219);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(217); match(COMMA);
					setState(218); ((StatContext)_localctx).rightPlus = match(ID);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221); ((StatContext)_localctx).left = value();
				setState(222); ((StatContext)_localctx).operator = match(FIELDUP);
				setState(223);
				((StatContext)_localctx).right = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EMPTY || _la==ID) ) {
					((StatContext)_localctx).right = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(225); ifelse();
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
			setState(228); match(IF);
			setState(229); match(LPAR);
			setState(230); ((IfelseContext)_localctx).cond = expr();
			setState(231); match(RPAR);
			setState(232); match(CLPAR);
			setState(233); ((IfelseContext)_localctx).stat = stat();
			((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
				{
				{
				setState(234); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240); match(CRPAR);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(241); match(ELSEIF);
				setState(242); ((IfelseContext)_localctx).expr = expr();
				((IfelseContext)_localctx).condElseIf.add(((IfelseContext)_localctx).expr);
				setState(243); match(CLPAR);
				setState(244); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
					{
					{
					setState(245); ((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251); match(CRPAR);
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(258); match(ELSE);
				setState(259); match(CLPAR);
				setState(260); ((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0)) {
					{
					{
					setState(261); ((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267); match(CRPAR);
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
			setState(287);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(272); expr();
				setState(273); match(TRIGGER);
				setState(274); match(AT);
				setState(275); match(ID);
				setState(276); match(CLPAR);
				setState(278); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(277); stat();
					}
					}
					setState(280); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << EMPTY) | (1L << NOW) | (1L << IF) | (1L << RAWSTRING) | (1L << INT) | (1L << REAL) | (1L << ID))) != 0) );
				setState(282); match(CRPAR);
				setState(283); match(IMPL);
				setState(284); match(AT);
				setState(285); match(ID);
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
			setState(289); expr();
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
			setState(292);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(291); match(MINUS);
				}
			}

			setState(294); ((ExprContext)_localctx).left = term();
			setState(297);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) {
				{
				setState(295);
				((ExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) ) {
					((ExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(296); ((ExprContext)_localctx).right = expr();
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
			setState(299); ((TermContext)_localctx).left = factor();
			setState(302);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) {
				{
				setState(300);
				((TermContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) ) {
					((TermContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(301); ((TermContext)_localctx).right = term();
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
			setState(304); ((FactorContext)_localctx).left = value();
			setState(307);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LE) | (1L << GE))) != 0)) {
				{
				setState(305);
				((FactorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LE) | (1L << GE))) != 0)) ) {
					((FactorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(306); ((FactorContext)_localctx).right = value();
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
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public TerminalNode NOW() { return getToken(StipulaParser.NOW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(StipulaParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(StipulaParser.TRUE, 0); }
		public TerminalNode LPAR() { return getToken(StipulaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(StipulaParser.RPAR, 0); }
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public TerminalNode RAWSTRING() { return getToken(StipulaParser.RAWSTRING, 0); }
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
			setState(319);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(309); number();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(310); match(ID);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(311); match(NOW);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(312); match(LPAR);
				setState(313); expr();
				setState(314); match(RPAR);
				}
				break;
			case RAWSTRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(316); match(RAWSTRING);
				}
				break;
			case EMPTY:
				enterOuterAlt(_localctx, 6);
				{
				setState(317); match(EMPTY);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(318);
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
			setState(321); number();
			setState(322); match(DOT);
			setState(323); number();
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
			setState(325);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u014a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\5\2\65\n\2\3\2\5\28\n\2\3\2\3\2\3\2\3\2\6\2>\n\2\r\2\16\2?\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3S\n\3\f\3\16\3V\13\3\3\3\3\3\3\3\6\3[\n\3\r\3\16\3\\\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\5\3\5\3\5\3\5\7\5q\n\5"+
		"\f\5\16\5t\13\5\3\6\3\6\7\6x\n\6\f\6\16\6{\13\6\3\6\3\6\3\6\7\6\u0080"+
		"\n\6\f\6\16\6\u0083\13\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008b\n\6\f\6\16"+
		"\6\u008e\13\6\5\6\u0090\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u0097\n\6\f\6\16\6"+
		"\u009a\13\6\5\6\u009c\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a3\n\6\3\6\3\6\6"+
		"\6\u00a7\n\6\r\6\16\6\u00a8\3\6\3\6\6\6\u00ad\n\6\r\6\16\6\u00ae\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b9\n\7\f\7\16\7\u00bc\13\7\3\7\3\7\3"+
		"\7\3\7\7\7\u00c2\n\7\f\7\16\7\u00c5\13\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00de\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e5\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ee\n\20\f\20\16\20\u00f1\13\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u00f9\n\20\f\20\16\20\u00fc\13\20\3"+
		"\20\3\20\7\20\u0100\n\20\f\20\16\20\u0103\13\20\3\20\3\20\3\20\3\20\7"+
		"\20\u0109\n\20\f\20\16\20\u010c\13\20\3\20\3\20\5\20\u0110\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\6\21\u0119\n\21\r\21\16\21\u011a\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0122\n\21\3\22\3\22\3\23\5\23\u0127\n\23\3\23\3"+
		"\23\3\23\5\23\u012c\n\23\3\24\3\24\3\24\5\24\u0131\n\24\3\25\3\25\3\25"+
		"\5\25\u0136\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0142\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\2\n\3\2()\3\2+.\4\2!!\65\65\4\2\r\16\36"+
		"\36\4\2\17\20\37\37\4\2\7\b\32\35\3\2\22\23\3\2\62\63\u015a\2\60\3\2\2"+
		"\2\4C\3\2\2\2\6c\3\2\2\2\bl\3\2\2\2\ny\3\2\2\2\f\u00b5\3\2\2\2\16\u00c6"+
		"\3\2\2\2\20\u00c9\3\2\2\2\22\u00cb\3\2\2\2\24\u00cd\3\2\2\2\26\u00cf\3"+
		"\2\2\2\30\u00d1\3\2\2\2\32\u00d3\3\2\2\2\34\u00e4\3\2\2\2\36\u00e6\3\2"+
		"\2\2 \u0121\3\2\2\2\"\u0123\3\2\2\2$\u0126\3\2\2\2&\u012d\3\2\2\2(\u0132"+
		"\3\2\2\2*\u0141\3\2\2\2,\u0143\3\2\2\2.\u0147\3\2\2\2\60\61\7\'\2\2\61"+
		"\62\7\65\2\2\62\64\7\30\2\2\63\65\5\6\4\2\64\63\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\3\2\2\2\668\5\b\5\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\60"+
		"\2\2:;\7\65\2\2;=\5\4\3\2<>\5\n\6\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3"+
		"\2\2\2@A\3\2\2\2AB\7\31\2\2B\3\3\2\2\2CD\7*\2\2DE\7\24\2\2EJ\5\24\13\2"+
		"FG\7\5\2\2GI\5\24\13\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2"+
		"\2LJ\3\2\2\2MN\7\25\2\2NO\7\24\2\2OT\5\26\f\2PQ\7\5\2\2QS\5\26\f\2RP\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\25\2\2XZ"+
		"\7\30\2\2Y[\5\f\7\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2"+
		"\2^_\7\31\2\2_`\7\t\2\2`a\7\21\2\2ab\5\22\n\2b\5\3\2\2\2cd\7(\2\2di\7"+
		"\65\2\2ef\7\5\2\2fh\7\65\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j"+
		"\7\3\2\2\2ki\3\2\2\2lm\7)\2\2mr\7\65\2\2no\7\5\2\2oq\7\65\2\2pn\3\2\2"+
		"\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\t\3\2\2\2tr\3\2\2\2uv\7\21\2\2vx\5\22"+
		"\n\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|\u0081"+
		"\5\24\13\2}~\7\5\2\2~\u0080\5\24\13\2\177}\3\2\2\2\u0080\u0083\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u0086\7\65\2\2\u0086\u008f\7\24\2\2"+
		"\u0087\u008c\5\26\f\2\u0088\u0089\7\5\2\2\u0089\u008b\5\26\f\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\25\2\2\u0092\u009b\7\26\2\2\u0093"+
		"\u0098\5\30\r\2\u0094\u0095\7\5\2\2\u0095\u0097\5\30\r\2\u0096\u0094\3"+
		"\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u0093\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a2\7\27\2\2\u009e\u009f\7\24\2\2\u009f"+
		"\u00a0\5\"\22\2\u00a0\u00a1\7\25\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009e\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\7\30\2\2\u00a5"+
		"\u00a7\5\34\17\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\7\3\2\2\u00ab"+
		"\u00ad\5 \21\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\31\2\2\u00b1"+
		"\u00b2\7\t\2\2\u00b2\u00b3\7\21\2\2\u00b3\u00b4\5\22\n\2\u00b4\13\3\2"+
		"\2\2\u00b5\u00ba\5\24\13\2\u00b6\u00b7\7\5\2\2\u00b7\u00b9\5\24\13\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\4\2\2\u00be"+
		"\u00c3\5\26\f\2\u00bf\u00c0\7\5\2\2\u00c0\u00c2\5\26\f\2\u00c1\u00bf\3"+
		"\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\r\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\t\2\2\2\u00c7\u00c8\7\65\2"+
		"\2\u00c8\17\3\2\2\2\u00c9\u00ca\t\3\2\2\u00ca\21\3\2\2\2\u00cb\u00cc\7"+
		"\65\2\2\u00cc\23\3\2\2\2\u00cd\u00ce\7\65\2\2\u00ce\25\3\2\2\2\u00cf\u00d0"+
		"\7\65\2\2\u00d0\27\3\2\2\2\u00d1\u00d2\7\65\2\2\u00d2\31\3\2\2\2\u00d3"+
		"\u00d4\5\26\f\2\u00d4\u00d5\7\n\2\2\u00d5\u00d6\5$\23\2\u00d6\33\3\2\2"+
		"\2\u00d7\u00e5\7!\2\2\u00d8\u00d9\5*\26\2\u00d9\u00da\7\13\2\2\u00da\u00dd"+
		"\7\65\2\2\u00db\u00dc\7\5\2\2\u00dc\u00de\7\65\2\2\u00dd\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00e5\3\2\2\2\u00df\u00e0\5*\26\2\u00e0\u00e1"+
		"\7\f\2\2\u00e1\u00e2\t\4\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e5\5\36\20\2"+
		"\u00e4\u00d7\3\2\2\2\u00e4\u00d8\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5\35\3\2\2\2\u00e6\u00e7\7$\2\2\u00e7\u00e8\7\24\2\2\u00e8"+
		"\u00e9\5$\23\2\u00e9\u00ea\7\25\2\2\u00ea\u00eb\7\30\2\2\u00eb\u00ef\5"+
		"\34\17\2\u00ec\u00ee\5\34\17\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2"+
		"\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f2\u0101\7\31\2\2\u00f3\u00f4\7%\2\2\u00f4\u00f5\5$\23\2\u00f5"+
		"\u00f6\7\30\2\2\u00f6\u00fa\5\34\17\2\u00f7\u00f9\5\34\17\2\u00f8\u00f7"+
		"\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7\31\2\2\u00fe\u0100\3"+
		"\2\2\2\u00ff\u00f3\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u010f\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7&"+
		"\2\2\u0105\u0106\7\30\2\2\u0106\u010a\5\34\17\2\u0107\u0109\5\34\17\2"+
		"\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\7\31\2\2"+
		"\u010e\u0110\3\2\2\2\u010f\u0104\3\2\2\2\u010f\u0110\3\2\2\2\u0110\37"+
		"\3\2\2\2\u0111\u0122\7!\2\2\u0112\u0113\5$\23\2\u0113\u0114\7#\2\2\u0114"+
		"\u0115\7\21\2\2\u0115\u0116\7\65\2\2\u0116\u0118\7\30\2\2\u0117\u0119"+
		"\5\34\17\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2"+
		"\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\31\2\2\u011d\u011e"+
		"\7\t\2\2\u011e\u011f\7\21\2\2\u011f\u0120\7\65\2\2\u0120\u0122\3\2\2\2"+
		"\u0121\u0111\3\2\2\2\u0121\u0112\3\2\2\2\u0122!\3\2\2\2\u0123\u0124\5"+
		"$\23\2\u0124#\3\2\2\2\u0125\u0127\7\16\2\2\u0126\u0125\3\2\2\2\u0126\u0127"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012b\5&\24\2\u0129\u012a\t\5\2\2\u012a"+
		"\u012c\5$\23\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c%\3\2\2\2"+
		"\u012d\u0130\5(\25\2\u012e\u012f\t\6\2\2\u012f\u0131\5&\24\2\u0130\u012e"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131\'\3\2\2\2\u0132\u0135\5*\26\2\u0133"+
		"\u0134\t\7\2\2\u0134\u0136\5*\26\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136)\3\2\2\2\u0137\u0142\5.\30\2\u0138\u0142\7\65\2\2\u0139\u0142"+
		"\7\"\2\2\u013a\u013b\7\24\2\2\u013b\u013c\5$\23\2\u013c\u013d\7\25\2\2"+
		"\u013d\u0142\3\2\2\2\u013e\u0142\7\61\2\2\u013f\u0142\7!\2\2\u0140\u0142"+
		"\t\b\2\2\u0141\u0137\3\2\2\2\u0141\u0138\3\2\2\2\u0141\u0139\3\2\2\2\u0141"+
		"\u013a\3\2\2\2\u0141\u013e\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2"+
		"\2\2\u0142+\3\2\2\2\u0143\u0144\5.\30\2\u0144\u0145\7\6\2\2\u0145\u0146"+
		"\5.\30\2\u0146-\3\2\2\2\u0147\u0148\t\t\2\2\u0148/\3\2\2\2#\64\67?JT\\"+
		"iry\u0081\u008c\u008f\u0098\u009b\u00a2\u00a8\u00ae\u00ba\u00c3\u00dd"+
		"\u00e4\u00ef\u00fa\u0101\u010a\u010f\u011a\u0121\u0126\u012b\u0130\u0135"+
		"\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}