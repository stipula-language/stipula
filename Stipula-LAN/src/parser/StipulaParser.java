// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class StipulaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, DOT=4, EQ=5, NEQ=6, IMPL=7, ASM=8, ASSETUP=9, 
		FIELDUP=10, PLUS=11, MINUS=12, TIMES=13, DIV=14, AT=15, TILDE=16, TRUE=17, 
		FALSE=18, LPAR=19, RPAR=20, SLPAR=21, SRPAR=22, CLPAR=23, CRPAR=24, LEQ=25, 
		GEQ=26, LE=27, GE=28, OR=29, AND=30, NOT=31, EMPTY=32, NOW=33, TRIGGER=34, 
		IF=35, ELSEIF=36, ELSE=37, STIPULA=38, ASSET=39, FIELD=40, AGREEMENT=41, 
		INTEGER=42, DOUBLE=43, BOOLEAN=44, STRING=45, PARTY=46, INIT=47, RAWSTRING=48, 
		INT=49, REAL=50, WS=51, ID=52, OTHER=53, LINECOMENTS=54, BLOCKCOMENTS=55, 
		ERR=56;
	public static final int
		RULE_prog = 0, RULE_agreement = 1, RULE_assetdecl = 2, RULE_fielddecl = 3, 
		RULE_fun = 4, RULE_assign = 5, RULE_dec = 6, RULE_type = 7, RULE_state = 8, 
		RULE_party = 9, RULE_vardec = 10, RULE_assetdec = 11, RULE_varasm = 12, 
		RULE_stat = 13, RULE_ifelse = 14, RULE_events = 15, RULE_prec = 16, RULE_expr = 17, 
		RULE_term = 18, RULE_factor = 19, RULE_value = 20, RULE_date = 21, RULE_real = 22, 
		RULE_number = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "agreement", "assetdecl", "fielddecl", "fun", "assign", "dec", 
			"type", "state", "party", "vardec", "assetdec", "varasm", "stat", "ifelse", 
			"events", "prec", "expr", "term", "factor", "value", "date", "real", 
			"number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "','", "'.'", "'=='", "'!='", "'==>'", "'='", "'-o'", 
			"'->'", "'+'", "'-'", "'*'", "'/'", "'@'", "'~'", "'true'", "'false'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<='", "'>='", "'<'", "'>'", 
			"'||'", "'&&'", "'!'", "'_'", "'now'", "'>>'", "'if'", "'else if'", "'else'", 
			"'stipula'", "'asset'", "'field'", "'agreement'", "'int'", "'real'", 
			"'bool'", "'string'", "'party'", "'init'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEMIC", "COLON", "COMMA", "DOT", "EQ", "NEQ", "IMPL", "ASM", "ASSETUP", 
			"FIELDUP", "PLUS", "MINUS", "TIMES", "DIV", "AT", "TILDE", "TRUE", "FALSE", 
			"LPAR", "RPAR", "SLPAR", "SRPAR", "CLPAR", "CRPAR", "LEQ", "GEQ", "LE", 
			"GE", "OR", "AND", "NOT", "EMPTY", "NOW", "TRIGGER", "IF", "ELSEIF", 
			"ELSE", "STIPULA", "ASSET", "FIELD", "AGREEMENT", "INTEGER", "DOUBLE", 
			"BOOLEAN", "STRING", "PARTY", "INIT", "RAWSTRING", "INT", "REAL", "WS", 
			"ID", "OTHER", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
	public String getGrammarFileName() { return "java-escape"; }

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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public Token contract_id;
		public Token init_state;
		public TerminalNode STIPULA() { return getToken(StipulaParser.STIPULA, 0); }
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public TerminalNode INIT() { return getToken(StipulaParser.INIT, 0); }
		public AgreementContext agreement() {
			return getRuleContext(AgreementContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public AssetdeclContext assetdecl() {
			return getRuleContext(AssetdeclContext.class,0);
		}
		public FielddeclContext fielddecl() {
			return getRuleContext(FielddeclContext.class,0);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
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
			setState(48);
			match(STIPULA);
			setState(49);
			((ProgContext)_localctx).contract_id = match(ID);
			setState(50);
			match(CLPAR);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSET) {
				{
				setState(51);
				assetdecl();
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FIELD) {
				{
				setState(54);
				fielddecl();
				}
			}

			setState(57);
			match(INIT);
			setState(58);
			((ProgContext)_localctx).init_state = match(ID);
			setState(59);
			agreement();
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				fun();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627468800L) != 0 );
			setState(65);
			match(CRPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AgreementContext extends ParserRuleContext {
		public TerminalNode AGREEMENT() { return getToken(StipulaParser.AGREEMENT, 0); }
		public List<TerminalNode> LPAR() { return getTokens(StipulaParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(StipulaParser.LPAR, i);
		}
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
		}
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(StipulaParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(StipulaParser.RPAR, i);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public TerminalNode AT() { return getToken(StipulaParser.AT, 0); }
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
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
			setState(67);
			match(AGREEMENT);
			setState(68);
			match(LPAR);
			setState(69);
			party();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70);
				match(COMMA);
				setState(71);
				party();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(RPAR);
			setState(78);
			match(LPAR);
			setState(79);
			vardec();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80);
				match(COMMA);
				setState(81);
				vardec();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(RPAR);
			setState(88);
			match(CLPAR);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				assign();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(94);
			match(CRPAR);
			setState(95);
			match(IMPL);
			setState(96);
			match(AT);
			setState(97);
			state();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssetdeclContext extends ParserRuleContext {
		public Token ID;
		public List<Token> idAsset = new ArrayList<Token>();
		public TerminalNode ASSET() { return getToken(StipulaParser.ASSET, 0); }
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
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
			setState(99);
			match(ASSET);
			setState(100);
			((AssetdeclContext)_localctx).ID = match(ID);
			((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(101);
				match(COMMA);
				setState(102);
				((AssetdeclContext)_localctx).ID = match(ID);
				((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
				}
				}
				setState(107);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FielddeclContext extends ParserRuleContext {
		public Token ID;
		public List<Token> idField = new ArrayList<Token>();
		public TerminalNode FIELD() { return getToken(StipulaParser.FIELD, 0); }
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
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
			setState(108);
			match(FIELD);
			setState(109);
			((FielddeclContext)_localctx).ID = match(ID);
			((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(110);
				match(COMMA);
				setState(111);
				((FielddeclContext)_localctx).ID = match(ID);
				((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
				}
				}
				setState(116);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends ParserRuleContext {
		public Token funId;
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
		public List<TerminalNode> LPAR() { return getTokens(StipulaParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(StipulaParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(StipulaParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(StipulaParser.RPAR, i);
		}
		public TerminalNode SLPAR() { return getToken(StipulaParser.SLPAR, 0); }
		public TerminalNode SRPAR() { return getToken(StipulaParser.SRPAR, 0); }
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public TerminalNode SEMIC() { return getToken(StipulaParser.SEMIC, 0); }
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public List<TerminalNode> AT() { return getTokens(StipulaParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(StipulaParser.AT, i);
		}
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
		}
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
		public TerminalNode TILDE() { return getToken(StipulaParser.TILDE, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<AssetdecContext> assetdec() {
			return getRuleContexts(AssetdecContext.class);
		}
		public AssetdecContext assetdec(int i) {
			return getRuleContext(AssetdecContext.class,i);
		}
		public PrecContext prec() {
			return getRuleContext(PrecContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<EventsContext> events() {
			return getRuleContexts(EventsContext.class);
		}
		public EventsContext events(int i) {
			return getRuleContext(EventsContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StipulaParser.COMMA, i);
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(117);
				match(AT);
				setState(118);
				state();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(124);
				party();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125);
					match(COMMA);
					setState(126);
					party();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TILDE:
				{
				setState(132);
				match(TILDE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(135);
			match(COLON);
			setState(136);
			((FunContext)_localctx).funId = match(ID);
			setState(137);
			match(LPAR);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(138);
				vardec();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(139);
					match(COMMA);
					setState(140);
					vardec();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(148);
			match(RPAR);
			setState(149);
			match(SLPAR);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(150);
				assetdec();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151);
					match(COMMA);
					setState(152);
					assetdec();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(160);
			match(SRPAR);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(161);
				match(LPAR);
				setState(162);
				prec();
				setState(163);
				match(RPAR);
				}
			}

			setState(167);
			match(CLPAR);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				stat();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709904384L) != 0 );
			setState(173);
			match(SEMIC);
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				events();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 6473956643993696L) != 0 );
			setState(179);
			match(CRPAR);
			setState(180);
			match(IMPL);
			setState(181);
			match(AT);
			setState(182);
			state();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public List<PartyContext> party() {
			return getRuleContexts(PartyContext.class);
		}
		public PartyContext party(int i) {
			return getRuleContext(PartyContext.class,i);
		}
		public TerminalNode COLON() { return getToken(StipulaParser.COLON, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StipulaParser.COMMA); }
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
			setState(184);
			party();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185);
				match(COMMA);
				setState(186);
				party();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(COLON);
			setState(193);
			vardec();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(194);
				match(COMMA);
				setState(195);
				vardec();
				}
				}
				setState(200);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public TerminalNode ASSET() { return getToken(StipulaParser.ASSET, 0); }
		public TerminalNode FIELD() { return getToken(StipulaParser.FIELD, 0); }
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
			setState(201);
			_la = _input.LA(1);
			if ( !(_la==ASSET || _la==FIELD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(202);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(StipulaParser.INTEGER, 0); }
		public TerminalNode DOUBLE() { return getToken(StipulaParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(StipulaParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(StipulaParser.STRING, 0); }
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
			setState(204);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697666560L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(206);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(208);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(210);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(212);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarasmContext extends ParserRuleContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(StipulaParser.ASM, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(214);
			vardec();
			setState(215);
			match(ASM);
			setState(216);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public ValueContext left;
		public Token operator;
		public Token right;
		public Token rightPlus;
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ASSETUP() { return getToken(StipulaParser.ASSETUP, 0); }
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public TerminalNode COMMA() { return getToken(StipulaParser.COMMA, 0); }
		public TerminalNode FIELDUP() { return getToken(StipulaParser.FIELDUP, 0); }
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
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((StatContext)_localctx).left = value();
				setState(220);
				((StatContext)_localctx).operator = match(ASSETUP);
				setState(221);
				((StatContext)_localctx).right = match(ID);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(222);
					match(COMMA);
					setState(223);
					((StatContext)_localctx).rightPlus = match(ID);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				((StatContext)_localctx).left = value();
				setState(227);
				((StatContext)_localctx).operator = match(FIELDUP);
				setState(228);
				((StatContext)_localctx).right = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EMPTY || _la==ID) ) {
					((StatContext)_localctx).right = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				ifelse();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfelseContext extends ParserRuleContext {
		public ExprContext cond;
		public StatContext stat;
		public List<StatContext> ifBranch = new ArrayList<StatContext>();
		public ExprContext expr;
		public List<ExprContext> condElseIf = new ArrayList<ExprContext>();
		public List<StatContext> elseIfBranch = new ArrayList<StatContext>();
		public List<StatContext> elseBranch = new ArrayList<StatContext>();
		public TerminalNode IF() { return getToken(StipulaParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(StipulaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(StipulaParser.RPAR, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(StipulaParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(StipulaParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(StipulaParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(StipulaParser.CRPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> ELSEIF() { return getTokens(StipulaParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(StipulaParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(StipulaParser.ELSE, 0); }
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
			setState(233);
			match(IF);
			setState(234);
			match(LPAR);
			setState(235);
			((IfelseContext)_localctx).cond = expr();
			setState(236);
			match(RPAR);
			setState(237);
			match(CLPAR);
			setState(238);
			((IfelseContext)_localctx).stat = stat();
			((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709904384L) != 0) {
				{
				{
				setState(239);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
			match(CRPAR);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(246);
				match(ELSEIF);
				setState(247);
				((IfelseContext)_localctx).expr = expr();
				((IfelseContext)_localctx).condElseIf.add(((IfelseContext)_localctx).expr);
				setState(248);
				match(CLPAR);
				setState(249);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709904384L) != 0) {
					{
					{
					setState(250);
					((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				match(CRPAR);
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(263);
				match(ELSE);
				setState(264);
				match(CLPAR);
				setState(265);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709904384L) != 0) {
					{
					{
					setState(266);
					((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(272);
				match(CRPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EventsContext extends ParserRuleContext {
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TRIGGER() { return getToken(StipulaParser.TRIGGER, 0); }
		public List<TerminalNode> AT() { return getTokens(StipulaParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(StipulaParser.AT, i);
		}
		public List<TerminalNode> ID() { return getTokens(StipulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StipulaParser.ID, i);
		}
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode IMPL() { return getToken(StipulaParser.IMPL, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
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
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(EMPTY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(277);
				expr();
				setState(278);
				match(TRIGGER);
				setState(279);
				match(AT);
				setState(280);
				match(ID);
				setState(281);
				match(CLPAR);
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(282);
					stat();
					}
					}
					setState(285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709904384L) != 0 );
				setState(287);
				match(CRPAR);
				setState(288);
				match(IMPL);
				setState(289);
				match(AT);
				setState(290);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(294);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermContext left;
		public Token operator;
		public ExprContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(StipulaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(StipulaParser.MINUS, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(StipulaParser.PLUS, 0); }
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
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(296);
				match(MINUS);
				}
				break;
			}
			setState(299);
			((ExprContext)_localctx).left = term();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 536877056L) != 0) {
				{
				setState(300);
				((ExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 536877056L) != 0) ) {
					((ExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(301);
				((ExprContext)_localctx).right = expr();
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

	@SuppressWarnings("CheckReturnValue")
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
		public TerminalNode DIV() { return getToken(StipulaParser.DIV, 0); }
		public TerminalNode AND() { return getToken(StipulaParser.AND, 0); }
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
			setState(304);
			((TermContext)_localctx).left = factor();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073766400L) != 0) {
				{
				setState(305);
				((TermContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1073766400L) != 0) ) {
					((TermContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(306);
				((TermContext)_localctx).right = term();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public Token operator;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(StipulaParser.EQ, 0); }
		public TerminalNode LE() { return getToken(StipulaParser.LE, 0); }
		public TerminalNode GE() { return getToken(StipulaParser.GE, 0); }
		public TerminalNode LEQ() { return getToken(StipulaParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(StipulaParser.GEQ, 0); }
		public TerminalNode NEQ() { return getToken(StipulaParser.NEQ, 0); }
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
			setState(309);
			((FactorContext)_localctx).left = value();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 503316576L) != 0) {
				{
				setState(310);
				((FactorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 503316576L) != 0) ) {
					((FactorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(311);
				((FactorContext)_localctx).right = value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
		public TerminalNode NOW() { return getToken(StipulaParser.NOW, 0); }
		public TerminalNode LPAR() { return getToken(StipulaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(StipulaParser.RPAR, 0); }
		public TerminalNode RAWSTRING() { return getToken(StipulaParser.RAWSTRING, 0); }
		public TerminalNode EMPTY() { return getToken(StipulaParser.EMPTY, 0); }
		public TerminalNode TRUE() { return getToken(StipulaParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(StipulaParser.FALSE, 0); }
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
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				date();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				number();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(317);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				match(NOW);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				match(LPAR);
				setState(320);
				expr();
				setState(321);
				match(RPAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(323);
				match(RAWSTRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(324);
				match(EMPTY);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(325);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DateContext extends ParserRuleContext {
		public Token INT;
		public List<Token> val = new ArrayList<Token>();
		public List<TerminalNode> DIV() { return getTokens(StipulaParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(StipulaParser.DIV, i);
		}
		public List<TerminalNode> COLON() { return getTokens(StipulaParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(StipulaParser.COLON, i);
		}
		public List<TerminalNode> INT() { return getTokens(StipulaParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(StipulaParser.INT, i);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			((DateContext)_localctx).INT = match(INT);
			((DateContext)_localctx).val.add(((DateContext)_localctx).INT);
			setState(329);
			match(DIV);
			setState(330);
			((DateContext)_localctx).INT = match(INT);
			((DateContext)_localctx).val.add(((DateContext)_localctx).INT);
			setState(331);
			match(DIV);
			setState(332);
			((DateContext)_localctx).INT = match(INT);
			((DateContext)_localctx).val.add(((DateContext)_localctx).INT);
			setState(333);
			match(COLON);
			setState(334);
			((DateContext)_localctx).INT = match(INT);
			((DateContext)_localctx).val.add(((DateContext)_localctx).INT);
			setState(335);
			match(COLON);
			setState(336);
			((DateContext)_localctx).INT = match(INT);
			((DateContext)_localctx).val.add(((DateContext)_localctx).INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RealContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode DOT() { return getToken(StipulaParser.DOT, 0); }
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
		enterRule(_localctx, 44, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			number();
			setState(339);
			match(DOT);
			setState(340);
			number();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(StipulaParser.INT, 0); }
		public TerminalNode REAL() { return getToken(StipulaParser.REAL, 0); }
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
		enterRule(_localctx, 46, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==REAL) ) {
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
		"\u0004\u00018\u0159\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0000\u0003\u0000"+
		"8\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		">\b\u0000\u000b\u0000\f\u0000?\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001I\b\u0001\n\u0001"+
		"\f\u0001L\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001S\b\u0001\n\u0001\f\u0001V\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001[\b\u0001\u000b\u0001\f\u0001\\\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002h\b\u0002\n\u0002\f\u0002k\t\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003q\b\u0003"+
		"\n\u0003\f\u0003t\t\u0003\u0001\u0004\u0001\u0004\u0005\u0004x\b\u0004"+
		"\n\u0004\f\u0004{\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u0080\b\u0004\n\u0004\f\u0004\u0083\t\u0004\u0001\u0004\u0003\u0004\u0086"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u008e\b\u0004\n\u0004\f\u0004\u0091\t\u0004\u0003\u0004"+
		"\u0093\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u009a\b\u0004\n\u0004\f\u0004\u009d\t\u0004\u0003\u0004\u009f"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00a6\b\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00aa\b\u0004"+
		"\u000b\u0004\f\u0004\u00ab\u0001\u0004\u0001\u0004\u0004\u0004\u00b0\b"+
		"\u0004\u000b\u0004\f\u0004\u00b1\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00bc"+
		"\b\u0005\n\u0005\f\u0005\u00bf\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00c5\b\u0005\n\u0005\f\u0005\u00c8\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00e1\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e8\b\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00f1\b\u000e\n\u000e\f\u000e\u00f4\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00fc\b\u000e\n\u000e\f\u000e\u00ff\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0103\b\u000e\n\u000e\f\u000e\u0106\t\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u010c\b\u000e\n\u000e\f\u000e"+
		"\u010f\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0113\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u011c\b\u000f\u000b\u000f\f\u000f\u011d\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0125\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u012a\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u012f\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u0134\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0139\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0147\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.\u0000\b\u0001\u0000\'(\u0001\u0000*-\u0002\u0000  44\u0002\u0000"+
		"\u000b\f\u001d\u001d\u0002\u0000\r\u000e\u001e\u001e\u0002\u0000\u0005"+
		"\u0006\u0019\u001c\u0001\u0000\u0011\u0012\u0001\u000012\u016b\u00000"+
		"\u0001\u0000\u0000\u0000\u0002C\u0001\u0000\u0000\u0000\u0004c\u0001\u0000"+
		"\u0000\u0000\u0006l\u0001\u0000\u0000\u0000\by\u0001\u0000\u0000\u0000"+
		"\n\u00b8\u0001\u0000\u0000\u0000\f\u00c9\u0001\u0000\u0000\u0000\u000e"+
		"\u00cc\u0001\u0000\u0000\u0000\u0010\u00ce\u0001\u0000\u0000\u0000\u0012"+
		"\u00d0\u0001\u0000\u0000\u0000\u0014\u00d2\u0001\u0000\u0000\u0000\u0016"+
		"\u00d4\u0001\u0000\u0000\u0000\u0018\u00d6\u0001\u0000\u0000\u0000\u001a"+
		"\u00e7\u0001\u0000\u0000\u0000\u001c\u00e9\u0001\u0000\u0000\u0000\u001e"+
		"\u0124\u0001\u0000\u0000\u0000 \u0126\u0001\u0000\u0000\u0000\"\u0129"+
		"\u0001\u0000\u0000\u0000$\u0130\u0001\u0000\u0000\u0000&\u0135\u0001\u0000"+
		"\u0000\u0000(\u0146\u0001\u0000\u0000\u0000*\u0148\u0001\u0000\u0000\u0000"+
		",\u0152\u0001\u0000\u0000\u0000.\u0156\u0001\u0000\u0000\u000001\u0005"+
		"&\u0000\u000012\u00054\u0000\u000024\u0005\u0017\u0000\u000035\u0003\u0004"+
		"\u0002\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001"+
		"\u0000\u0000\u000068\u0003\u0006\u0003\u000076\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0005/\u0000\u0000"+
		":;\u00054\u0000\u0000;=\u0003\u0002\u0001\u0000<>\u0003\b\u0004\u0000"+
		"=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0018"+
		"\u0000\u0000B\u0001\u0001\u0000\u0000\u0000CD\u0005)\u0000\u0000DE\u0005"+
		"\u0013\u0000\u0000EJ\u0003\u0012\t\u0000FG\u0005\u0003\u0000\u0000GI\u0003"+
		"\u0012\t\u0000HF\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000MN\u0005\u0014\u0000\u0000NO\u0005\u0013\u0000"+
		"\u0000OT\u0003\u0014\n\u0000PQ\u0005\u0003\u0000\u0000QS\u0003\u0014\n"+
		"\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0005\u0014\u0000\u0000XZ\u0005\u0017\u0000\u0000"+
		"Y[\u0003\n\u0005\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0018\u0000\u0000_`\u0005\u0007\u0000\u0000`a\u0005"+
		"\u000f\u0000\u0000ab\u0003\u0010\b\u0000b\u0003\u0001\u0000\u0000\u0000"+
		"cd\u0005\'\u0000\u0000di\u00054\u0000\u0000ef\u0005\u0003\u0000\u0000"+
		"fh\u00054\u0000\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0005\u0001\u0000"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005(\u0000\u0000mr\u00054\u0000"+
		"\u0000no\u0005\u0003\u0000\u0000oq\u00054\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"uv\u0005\u000f\u0000\u0000vx\u0003\u0010\b\u0000wu\u0001\u0000\u0000\u0000"+
		"x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z\u0085\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|\u0081"+
		"\u0003\u0012\t\u0000}~\u0005\u0003\u0000\u0000~\u0080\u0003\u0012\t\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0086\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0005\u0010\u0000\u0000\u0085|\u0001\u0000\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\u0002\u0000\u0000\u0088\u0089\u00054\u0000\u0000\u0089\u0092\u0005"+
		"\u0013\u0000\u0000\u008a\u008f\u0003\u0014\n\u0000\u008b\u008c\u0005\u0003"+
		"\u0000\u0000\u008c\u008e\u0003\u0014\n\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u008a\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005\u0014\u0000\u0000\u0095\u009e\u0005\u0015\u0000"+
		"\u0000\u0096\u009b\u0003\u0016\u000b\u0000\u0097\u0098\u0005\u0003\u0000"+
		"\u0000\u0098\u009a\u0003\u0016\u000b\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u0096\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a5\u0005\u0016\u0000\u0000\u00a1\u00a2\u0005\u0013\u0000"+
		"\u0000\u00a2\u00a3\u0003 \u0010\u0000\u00a3\u00a4\u0005\u0014\u0000\u0000"+
		"\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a9\u0005\u0017\u0000\u0000\u00a8\u00aa\u0003\u001a\r\u0000\u00a9"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0005\u0001\u0000\u0000\u00ae"+
		"\u00b0\u0003\u001e\u000f\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0005\u0018\u0000\u0000\u00b4\u00b5\u0005\u0007\u0000\u0000\u00b5"+
		"\u00b6\u0005\u000f\u0000\u0000\u00b6\u00b7\u0003\u0010\b\u0000\u00b7\t"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bd\u0003\u0012\t\u0000\u00b9\u00ba\u0005"+
		"\u0003\u0000\u0000\u00ba\u00bc\u0003\u0012\t\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0002"+
		"\u0000\u0000\u00c1\u00c6\u0003\u0014\n\u0000\u00c2\u00c3\u0005\u0003\u0000"+
		"\u0000\u00c3\u00c5\u0003\u0014\n\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u000b\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0007\u0000\u0000\u0000"+
		"\u00ca\u00cb\u00054\u0000\u0000\u00cb\r\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0007\u0001\u0000\u0000\u00cd\u000f\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u00054\u0000\u0000\u00cf\u0011\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u00054\u0000\u0000\u00d1\u0013\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005"+
		"4\u0000\u0000\u00d3\u0015\u0001\u0000\u0000\u0000\u00d4\u00d5\u00054\u0000"+
		"\u0000\u00d5\u0017\u0001\u0000\u0000\u0000\u00d6\u00d7\u0003\u0014\n\u0000"+
		"\u00d7\u00d8\u0005\b\u0000\u0000\u00d8\u00d9\u0003\"\u0011\u0000\u00d9"+
		"\u0019\u0001\u0000\u0000\u0000\u00da\u00e8\u0005 \u0000\u0000\u00db\u00dc"+
		"\u0003(\u0014\u0000\u00dc\u00dd\u0005\t\u0000\u0000\u00dd\u00e0\u0005"+
		"4\u0000\u0000\u00de\u00df\u0005\u0003\u0000\u0000\u00df\u00e1\u00054\u0000"+
		"\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e8\u0001\u0000\u0000\u0000\u00e2\u00e3\u0003(\u0014\u0000"+
		"\u00e3\u00e4\u0005\n\u0000\u0000\u00e4\u00e5\u0007\u0002\u0000\u0000\u00e5"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e8\u0003\u001c\u000e\u0000\u00e7"+
		"\u00da\u0001\u0000\u0000\u0000\u00e7\u00db\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8"+
		"\u001b\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005#\u0000\u0000\u00ea\u00eb"+
		"\u0005\u0013\u0000\u0000\u00eb\u00ec\u0003\"\u0011\u0000\u00ec\u00ed\u0005"+
		"\u0014\u0000\u0000\u00ed\u00ee\u0005\u0017\u0000\u0000\u00ee\u00f2\u0003"+
		"\u001a\r\u0000\u00ef\u00f1\u0003\u001a\r\u0000\u00f0\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u0104\u0005\u0018"+
		"\u0000\u0000\u00f6\u00f7\u0005$\u0000\u0000\u00f7\u00f8\u0003\"\u0011"+
		"\u0000\u00f8\u00f9\u0005\u0017\u0000\u0000\u00f9\u00fd\u0003\u001a\r\u0000"+
		"\u00fa\u00fc\u0003\u001a\r\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc"+
		"\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0001\u0000\u0000\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fd\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0018\u0000\u0000\u0101"+
		"\u0103\u0001\u0000\u0000\u0000\u0102\u00f6\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0105\u0112\u0001\u0000\u0000\u0000\u0106"+
		"\u0104\u0001\u0000\u0000\u0000\u0107\u0108\u0005%\u0000\u0000\u0108\u0109"+
		"\u0005\u0017\u0000\u0000\u0109\u010d\u0003\u001a\r\u0000\u010a\u010c\u0003"+
		"\u001a\r\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000"+
		"\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u0110\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0005\u0018\u0000\u0000\u0111\u0113\u0001\u0000"+
		"\u0000\u0000\u0112\u0107\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000"+
		"\u0000\u0000\u0113\u001d\u0001\u0000\u0000\u0000\u0114\u0125\u0005 \u0000"+
		"\u0000\u0115\u0116\u0003\"\u0011\u0000\u0116\u0117\u0005\"\u0000\u0000"+
		"\u0117\u0118\u0005\u000f\u0000\u0000\u0118\u0119\u00054\u0000\u0000\u0119"+
		"\u011b\u0005\u0017\u0000\u0000\u011a\u011c\u0003\u001a\r\u0000\u011b\u011a"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011b"+
		"\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u0018\u0000\u0000\u0120\u0121"+
		"\u0005\u0007\u0000\u0000\u0121\u0122\u0005\u000f\u0000\u0000\u0122\u0123"+
		"\u00054\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0114\u0001"+
		"\u0000\u0000\u0000\u0124\u0115\u0001\u0000\u0000\u0000\u0125\u001f\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0003\"\u0011\u0000\u0127!\u0001\u0000"+
		"\u0000\u0000\u0128\u012a\u0005\f\u0000\u0000\u0129\u0128\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000"+
		"\u0000\u012b\u012e\u0003$\u0012\u0000\u012c\u012d\u0007\u0003\u0000\u0000"+
		"\u012d\u012f\u0003\"\u0011\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0001\u0000\u0000\u0000\u012f#\u0001\u0000\u0000\u0000\u0130\u0133"+
		"\u0003&\u0013\u0000\u0131\u0132\u0007\u0004\u0000\u0000\u0132\u0134\u0003"+
		"$\u0012\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000"+
		"\u0000\u0000\u0134%\u0001\u0000\u0000\u0000\u0135\u0138\u0003(\u0014\u0000"+
		"\u0136\u0137\u0007\u0005\u0000\u0000\u0137\u0139\u0003(\u0014\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139"+
		"\'\u0001\u0000\u0000\u0000\u013a\u0147\u0001\u0000\u0000\u0000\u013b\u0147"+
		"\u0003*\u0015\u0000\u013c\u0147\u0003.\u0017\u0000\u013d\u0147\u00054"+
		"\u0000\u0000\u013e\u0147\u0005!\u0000\u0000\u013f\u0140\u0005\u0013\u0000"+
		"\u0000\u0140\u0141\u0003\"\u0011\u0000\u0141\u0142\u0005\u0014\u0000\u0000"+
		"\u0142\u0147\u0001\u0000\u0000\u0000\u0143\u0147\u00050\u0000\u0000\u0144"+
		"\u0147\u0005 \u0000\u0000\u0145\u0147\u0007\u0006\u0000\u0000\u0146\u013a"+
		"\u0001\u0000\u0000\u0000\u0146\u013b\u0001\u0000\u0000\u0000\u0146\u013c"+
		"\u0001\u0000\u0000\u0000\u0146\u013d\u0001\u0000\u0000\u0000\u0146\u013e"+
		"\u0001\u0000\u0000\u0000\u0146\u013f\u0001\u0000\u0000\u0000\u0146\u0143"+
		"\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0145"+
		"\u0001\u0000\u0000\u0000\u0147)\u0001\u0000\u0000\u0000\u0148\u0149\u0005"+
		"1\u0000\u0000\u0149\u014a\u0005\u000e\u0000\u0000\u014a\u014b\u00051\u0000"+
		"\u0000\u014b\u014c\u0005\u000e\u0000\u0000\u014c\u014d\u00051\u0000\u0000"+
		"\u014d\u014e\u0005\u0002\u0000\u0000\u014e\u014f\u00051\u0000\u0000\u014f"+
		"\u0150\u0005\u0002\u0000\u0000\u0150\u0151\u00051\u0000\u0000\u0151+\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0003.\u0017\u0000\u0153\u0154\u0005\u0004"+
		"\u0000\u0000\u0154\u0155\u0003.\u0017\u0000\u0155-\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0007\u0007\u0000\u0000\u0157/\u0001\u0000\u0000\u0000\""+
		"47?JT\\iry\u0081\u0085\u008f\u0092\u009b\u009e\u00a5\u00ab\u00b1\u00bd"+
		"\u00c6\u00e0\u00e7\u00f2\u00fd\u0104\u010d\u0112\u011d\u0124\u0129\u012e"+
		"\u0133\u0138\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}