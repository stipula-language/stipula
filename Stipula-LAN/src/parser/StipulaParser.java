// Generated from /Users/laneve/Documents/dev/STIPULA/Stipula-LAN/Stipula.g4 by ANTLR 4.13.1
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
		RULE_stat = 13, RULE_ifelse = 14, RULE_event = 15, RULE_prec = 16, RULE_expr = 17, 
		RULE_term = 18, RULE_factor = 19, RULE_value = 20, RULE_real = 21, RULE_number = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "agreement", "assetdecl", "fielddecl", "fun", "assign", "dec", 
			"type", "state", "party", "vardec", "assetdec", "varasm", "stat", "ifelse", 
			"event", "prec", "expr", "term", "factor", "value", "real", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "','", "'.'", "'=='", "'!='", "'=>'", "'='", "'-o'", 
			"'->'", "'+'", "'-'", "'*'", "'/'", "'@'", "'~'", "'true'", "'false'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<='", "'>='", "'<'", "'>'", 
			"'||'", "'&&'", "'!'", "'_'", "'now'", "'>>'", "'if'", "'else if'", "'else'", 
			"'stipula'", "'assets'", "'fields'", "'agreement'", "'int'", "'real'", 
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
	public String getGrammarFileName() { return "Stipula.g4"; }

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
		public TerminalNode STIPULA() { return getToken(StipulaParser.STIPULA, 0); }
		public TerminalNode CLPAR() { return getToken(StipulaParser.CLPAR, 0); }
		public AgreementContext agreement() {
			return getRuleContext(AgreementContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(StipulaParser.CRPAR, 0); }
		public TerminalNode ID() { return getToken(StipulaParser.ID, 0); }
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
			setState(46);
			match(STIPULA);
			setState(47);
			((ProgContext)_localctx).contract_id = match(ID);
			setState(48);
			match(CLPAR);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSET) {
				{
				setState(49);
				assetdecl();
				}
			}

			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FIELD) {
				{
				setState(52);
				fielddecl();
				}
			}

			setState(55);
			agreement();
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				fun();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627468800L) != 0) );
			setState(61);
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
			setState(63);
			match(AGREEMENT);
			setState(64);
			match(LPAR);
			setState(65);
			party();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(66);
				match(COMMA);
				setState(67);
				party();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(RPAR);
			setState(74);
			match(LPAR);
			setState(75);
			vardec();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76);
				match(COMMA);
				setState(77);
				vardec();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(RPAR);
			setState(84);
			match(CLPAR);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				assign();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(90);
			match(CRPAR);
			setState(91);
			match(IMPL);
			setState(92);
			match(AT);
			setState(93);
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
			setState(95);
			match(ASSET);
			setState(96);
			((AssetdeclContext)_localctx).ID = match(ID);
			((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				((AssetdeclContext)_localctx).ID = match(ID);
				((AssetdeclContext)_localctx).idAsset.add(((AssetdeclContext)_localctx).ID);
				}
				}
				setState(103);
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
			setState(104);
			match(FIELD);
			setState(105);
			((FielddeclContext)_localctx).ID = match(ID);
			((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(106);
				match(COMMA);
				setState(107);
				((FielddeclContext)_localctx).ID = match(ID);
				((FielddeclContext)_localctx).idField.add(((FielddeclContext)_localctx).ID);
				}
				}
				setState(112);
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
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(113);
				match(AT);
				setState(114);
				state();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(120);
				party();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(121);
					match(COMMA);
					setState(122);
					party();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TILDE:
				{
				setState(128);
				match(TILDE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(131);
			match(COLON);
			setState(132);
			((FunContext)_localctx).funId = match(ID);
			setState(133);
			match(LPAR);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134);
				vardec();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135);
					match(COMMA);
					setState(136);
					vardec();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(RPAR);
			setState(145);
			match(SLPAR);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(146);
				assetdec();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(148);
					assetdec();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(156);
			match(SRPAR);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(157);
				match(LPAR);
				setState(158);
				prec();
				setState(159);
				match(RPAR);
				}
			}

			setState(163);
			match(CLPAR);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164);
					stat();
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6473937350168576L) != 0)) {
				{
				{
				setState(170);
				event();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(CRPAR);
			setState(177);
			match(IMPL);
			setState(178);
			match(AT);
			setState(179);
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
			setState(181);
			party();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(182);
				match(COMMA);
				setState(183);
				party();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
			match(COLON);
			setState(190);
			vardec();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(191);
				match(COMMA);
				setState(192);
				vardec();
				}
				}
				setState(197);
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
			setState(198);
			_la = _input.LA(1);
			if ( !(_la==ASSET || _la==FIELD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(199);
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
			setState(201);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697666560L) != 0)) ) {
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
			setState(203);
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
			setState(205);
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
			setState(207);
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
			setState(209);
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
			setState(211);
			vardec();
			setState(212);
			match(ASM);
			setState(213);
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
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((StatContext)_localctx).left = value();
				setState(216);
				((StatContext)_localctx).operator = match(ASSETUP);
				setState(217);
				((StatContext)_localctx).right = match(ID);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(218);
					match(COMMA);
					setState(219);
					((StatContext)_localctx).rightPlus = match(ID);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				((StatContext)_localctx).left = value();
				setState(223);
				((StatContext)_localctx).operator = match(FIELDUP);
				setState(224);
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
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
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
			setState(229);
			match(IF);
			setState(230);
			match(LPAR);
			setState(231);
			((IfelseContext)_localctx).cond = expr();
			setState(232);
			match(RPAR);
			setState(233);
			match(CLPAR);
			setState(234);
			((IfelseContext)_localctx).stat = stat();
			((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709902848L) != 0)) {
				{
				{
				setState(235);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).ifBranch.add(((IfelseContext)_localctx).stat);
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			match(CRPAR);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(242);
				match(ELSEIF);
				setState(243);
				((IfelseContext)_localctx).expr = expr();
				((IfelseContext)_localctx).condElseIf.add(((IfelseContext)_localctx).expr);
				setState(244);
				match(CLPAR);
				setState(245);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709902848L) != 0)) {
					{
					{
					setState(246);
					((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseIfBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(252);
				match(CRPAR);
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(259);
				match(ELSE);
				setState(260);
				match(CLPAR);
				setState(261);
				((IfelseContext)_localctx).stat = stat();
				((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709902848L) != 0)) {
					{
					{
					setState(262);
					((IfelseContext)_localctx).stat = stat();
					((IfelseContext)_localctx).elseBranch.add(((IfelseContext)_localctx).stat);
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
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
	public static class EventContext extends ParserRuleContext {
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
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StipulaListener ) ((StipulaListener)listener).exitEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StipulaVisitor ) return ((StipulaVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_event);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			expr();
			setState(273);
			match(TRIGGER);
			setState(274);
			match(AT);
			setState(275);
			match(ID);
			setState(276);
			match(CLPAR);
			setState(278); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(277);
				stat();
				}
				}
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6473971709902848L) != 0) );
			setState(282);
			match(CRPAR);
			setState(283);
			match(IMPL);
			setState(284);
			match(AT);
			setState(285);
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
			setState(287);
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
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(289);
				match(MINUS);
				}
			}

			setState(292);
			((ExprContext)_localctx).left = term();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536877056L) != 0)) {
				{
				setState(293);
				((ExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 536877056L) != 0)) ) {
					((ExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(294);
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
			setState(297);
			((TermContext)_localctx).left = factor();
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073766400L) != 0)) {
				{
				setState(298);
				((TermContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073766400L) != 0)) ) {
					((TermContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(299);
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
			setState(302);
			((FactorContext)_localctx).left = value();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316576L) != 0)) {
				{
				setState(303);
				((FactorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316576L) != 0)) ) {
					((FactorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(304);
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
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				number();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				match(ID);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(NOW);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				match(LPAR);
				setState(311);
				expr();
				setState(312);
				match(RPAR);
				}
				break;
			case RAWSTRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(314);
				match(RAWSTRING);
				}
				break;
			case EMPTY:
				enterOuterAlt(_localctx, 6);
				{
				setState(315);
				match(EMPTY);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(316);
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
		enterRule(_localctx, 42, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			number();
			setState(320);
			match(DOT);
			setState(321);
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
		enterRule(_localctx, 44, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
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
		"\u0004\u00018\u0146\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0000\u0003\u00006\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000:\b\u0000\u000b\u0000\f\u0000;\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"E\b\u0001\n\u0001\f\u0001H\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001O\b\u0001\n\u0001\f\u0001R\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001W\b\u0001\u000b\u0001"+
		"\f\u0001X\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002d\b\u0002"+
		"\n\u0002\f\u0002g\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003m\b\u0003\n\u0003\f\u0003p\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0005\u0004t\b\u0004\n\u0004\f\u0004w\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004|\b\u0004\n\u0004\f\u0004\u007f\t\u0004\u0001"+
		"\u0004\u0003\u0004\u0082\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008a\b\u0004\n\u0004\f\u0004"+
		"\u008d\t\u0004\u0003\u0004\u008f\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0096\b\u0004\n\u0004\f\u0004"+
		"\u0099\t\u0004\u0003\u0004\u009b\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00a2\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00a6\b\u0004\n\u0004\f\u0004\u00a9\t\u0004\u0001\u0004"+
		"\u0005\u0004\u00ac\b\u0004\n\u0004\f\u0004\u00af\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00b9\b\u0005\n\u0005\f\u0005\u00bc\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00c2\b\u0005\n\u0005"+
		"\f\u0005\u00c5\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00dd\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00e4\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00ed\b\u000e\n\u000e\f\u000e\u00f0"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00f8\b\u000e\n\u000e\f\u000e\u00fb\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00ff\b\u000e\n\u000e\f\u000e\u0102\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0108\b\u000e\n"+
		"\u000e\f\u000e\u010b\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u010f"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u0117\b\u000f\u000b\u000f\f\u000f\u0118\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0003\u0011\u0123\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0128\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u012d\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0132\b"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u013e"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\b\u0001"+
		"\u0000\'(\u0001\u0000*-\u0002\u0000  44\u0002\u0000\u000b\f\u001d\u001d"+
		"\u0002\u0000\r\u000e\u001e\u001e\u0002\u0000\u0005\u0006\u0019\u001c\u0001"+
		"\u0000\u0011\u0012\u0001\u000012\u0155\u0000.\u0001\u0000\u0000\u0000"+
		"\u0002?\u0001\u0000\u0000\u0000\u0004_\u0001\u0000\u0000\u0000\u0006h"+
		"\u0001\u0000\u0000\u0000\bu\u0001\u0000\u0000\u0000\n\u00b5\u0001\u0000"+
		"\u0000\u0000\f\u00c6\u0001\u0000\u0000\u0000\u000e\u00c9\u0001\u0000\u0000"+
		"\u0000\u0010\u00cb\u0001\u0000\u0000\u0000\u0012\u00cd\u0001\u0000\u0000"+
		"\u0000\u0014\u00cf\u0001\u0000\u0000\u0000\u0016\u00d1\u0001\u0000\u0000"+
		"\u0000\u0018\u00d3\u0001\u0000\u0000\u0000\u001a\u00e3\u0001\u0000\u0000"+
		"\u0000\u001c\u00e5\u0001\u0000\u0000\u0000\u001e\u0110\u0001\u0000\u0000"+
		"\u0000 \u011f\u0001\u0000\u0000\u0000\"\u0122\u0001\u0000\u0000\u0000"+
		"$\u0129\u0001\u0000\u0000\u0000&\u012e\u0001\u0000\u0000\u0000(\u013d"+
		"\u0001\u0000\u0000\u0000*\u013f\u0001\u0000\u0000\u0000,\u0143\u0001\u0000"+
		"\u0000\u0000./\u0005&\u0000\u0000/0\u00054\u0000\u000002\u0005\u0017\u0000"+
		"\u000013\u0003\u0004\u0002\u000021\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000035\u0001\u0000\u0000\u000046\u0003\u0006\u0003\u000054\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0003\u0002\u0001\u00008:\u0003\b\u0004\u000098\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=>\u0005\u0018\u0000\u0000>\u0001\u0001"+
		"\u0000\u0000\u0000?@\u0005)\u0000\u0000@A\u0005\u0013\u0000\u0000AF\u0003"+
		"\u0012\t\u0000BC\u0005\u0003\u0000\u0000CE\u0003\u0012\t\u0000DB\u0001"+
		"\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0014\u0000\u0000JK\u0005\u0013\u0000\u0000KP\u0003\u0014"+
		"\n\u0000LM\u0005\u0003\u0000\u0000MO\u0003\u0014\n\u0000NL\u0001\u0000"+
		"\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"ST\u0005\u0014\u0000\u0000TV\u0005\u0017\u0000\u0000UW\u0003\n\u0005\u0000"+
		"VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\u0018"+
		"\u0000\u0000[\\\u0005\u0007\u0000\u0000\\]\u0005\u000f\u0000\u0000]^\u0003"+
		"\u0010\b\u0000^\u0003\u0001\u0000\u0000\u0000_`\u0005\'\u0000\u0000`e"+
		"\u00054\u0000\u0000ab\u0005\u0003\u0000\u0000bd\u00054\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000f\u0005\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000hi\u0005(\u0000\u0000in\u00054\u0000\u0000jk\u0005\u0003\u0000"+
		"\u0000km\u00054\u0000\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0007\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u000f\u0000\u0000"+
		"rt\u0003\u0010\b\u0000sq\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0081\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000x}\u0003\u0012\t\u0000yz\u0005\u0003"+
		"\u0000\u0000z|\u0003\u0012\t\u0000{y\u0001\u0000\u0000\u0000|\u007f\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0082\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0005\u0010\u0000\u0000\u0081x\u0001\u0000\u0000\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"\u0002\u0000\u0000\u0084\u0085\u00054\u0000\u0000\u0085\u008e\u0005\u0013"+
		"\u0000\u0000\u0086\u008b\u0003\u0014\n\u0000\u0087\u0088\u0005\u0003\u0000"+
		"\u0000\u0088\u008a\u0003\u0014\n\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0086\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\u0014\u0000\u0000\u0091\u009a\u0005\u0015\u0000\u0000"+
		"\u0092\u0097\u0003\u0016\u000b\u0000\u0093\u0094\u0005\u0003\u0000\u0000"+
		"\u0094\u0096\u0003\u0016\u000b\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u0092\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u00a1\u0005\u0016\u0000\u0000\u009d\u009e\u0005\u0013\u0000\u0000"+
		"\u009e\u009f\u0003 \u0010\u0000\u009f\u00a0\u0005\u0014\u0000\u0000\u00a0"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a7\u0005\u0017\u0000\u0000\u00a4\u00a6\u0003\u001a\r\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ad"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ac"+
		"\u0003\u001e\u000f\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0018\u0000\u0000\u00b1\u00b2"+
		"\u0005\u0007\u0000\u0000\u00b2\u00b3\u0005\u000f\u0000\u0000\u00b3\u00b4"+
		"\u0003\u0010\b\u0000\u00b4\t\u0001\u0000\u0000\u0000\u00b5\u00ba\u0003"+
		"\u0012\t\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7\u00b9\u0003\u0012"+
		"\t\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0005\u0002\u0000\u0000\u00be\u00c3\u0003\u0014\n\u0000"+
		"\u00bf\u00c0\u0005\u0003\u0000\u0000\u00c0\u00c2\u0003\u0014\n\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u000b\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0007\u0000\u0000\u0000\u00c7\u00c8\u00054\u0000\u0000\u00c8\r"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0007\u0001\u0000\u0000\u00ca\u000f"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u00054\u0000\u0000\u00cc\u0011\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u00054\u0000\u0000\u00ce\u0013\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u00054\u0000\u0000\u00d0\u0015\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u00054\u0000\u0000\u00d2\u0017\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0003\u0014\n\u0000\u00d4\u00d5\u0005\b\u0000\u0000\u00d5"+
		"\u00d6\u0003\"\u0011\u0000\u00d6\u0019\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0003(\u0014\u0000\u00d8\u00d9\u0005\t\u0000\u0000\u00d9\u00dc\u0005"+
		"4\u0000\u0000\u00da\u00db\u0005\u0003\u0000\u0000\u00db\u00dd\u00054\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000"+
		"\u0000\u00dd\u00e4\u0001\u0000\u0000\u0000\u00de\u00df\u0003(\u0014\u0000"+
		"\u00df\u00e0\u0005\n\u0000\u0000\u00e0\u00e1\u0007\u0002\u0000\u0000\u00e1"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e4\u0003\u001c\u000e\u0000\u00e3"+
		"\u00d7\u0001\u0000\u0000\u0000\u00e3\u00de\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u001b\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0005#\u0000\u0000\u00e6\u00e7\u0005\u0013\u0000\u0000\u00e7\u00e8"+
		"\u0003\"\u0011\u0000\u00e8\u00e9\u0005\u0014\u0000\u0000\u00e9\u00ea\u0005"+
		"\u0017\u0000\u0000\u00ea\u00ee\u0003\u001a\r\u0000\u00eb\u00ed\u0003\u001a"+
		"\r\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f1\u0100\u0005\u0018\u0000\u0000\u00f2\u00f3\u0005$\u0000\u0000"+
		"\u00f3\u00f4\u0003\"\u0011\u0000\u00f4\u00f5\u0005\u0017\u0000\u0000\u00f5"+
		"\u00f9\u0003\u001a\r\u0000\u00f6\u00f8\u0003\u001a\r\u0000\u00f7\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0005\u0018\u0000\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00f2"+
		"\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u010e"+
		"\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0005%\u0000\u0000\u0104\u0105\u0005\u0017\u0000\u0000\u0105\u0109\u0003"+
		"\u001a\r\u0000\u0106\u0108\u0003\u001a\r\u0000\u0107\u0106\u0001\u0000"+
		"\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000"+
		"\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0018"+
		"\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u0103\u0001\u0000"+
		"\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u001d\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0003\"\u0011\u0000\u0111\u0112\u0005\"\u0000"+
		"\u0000\u0112\u0113\u0005\u000f\u0000\u0000\u0113\u0114\u00054\u0000\u0000"+
		"\u0114\u0116\u0005\u0017\u0000\u0000\u0115\u0117\u0003\u001a\r\u0000\u0116"+
		"\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0018\u0000\u0000\u011b"+
		"\u011c\u0005\u0007\u0000\u0000\u011c\u011d\u0005\u000f\u0000\u0000\u011d"+
		"\u011e\u00054\u0000\u0000\u011e\u001f\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0003\"\u0011\u0000\u0120!\u0001\u0000\u0000\u0000\u0121\u0123\u0005"+
		"\f\u0000\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000"+
		"\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0127\u0003$\u0012"+
		"\u0000\u0125\u0126\u0007\u0003\u0000\u0000\u0126\u0128\u0003\"\u0011\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128#\u0001\u0000\u0000\u0000\u0129\u012c\u0003&\u0013\u0000\u012a\u012b"+
		"\u0007\u0004\u0000\u0000\u012b\u012d\u0003$\u0012\u0000\u012c\u012a\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d%\u0001\u0000"+
		"\u0000\u0000\u012e\u0131\u0003(\u0014\u0000\u012f\u0130\u0007\u0005\u0000"+
		"\u0000\u0130\u0132\u0003(\u0014\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\'\u0001\u0000\u0000\u0000\u0133"+
		"\u013e\u0003,\u0016\u0000\u0134\u013e\u00054\u0000\u0000\u0135\u013e\u0005"+
		"!\u0000\u0000\u0136\u0137\u0005\u0013\u0000\u0000\u0137\u0138\u0003\""+
		"\u0011\u0000\u0138\u0139\u0005\u0014\u0000\u0000\u0139\u013e\u0001\u0000"+
		"\u0000\u0000\u013a\u013e\u00050\u0000\u0000\u013b\u013e\u0005 \u0000\u0000"+
		"\u013c\u013e\u0007\u0006\u0000\u0000\u013d\u0133\u0001\u0000\u0000\u0000"+
		"\u013d\u0134\u0001\u0000\u0000\u0000\u013d\u0135\u0001\u0000\u0000\u0000"+
		"\u013d\u0136\u0001\u0000\u0000\u0000\u013d\u013a\u0001\u0000\u0000\u0000"+
		"\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013c\u0001\u0000\u0000\u0000"+
		"\u013e)\u0001\u0000\u0000\u0000\u013f\u0140\u0003,\u0016\u0000\u0140\u0141"+
		"\u0005\u0004\u0000\u0000\u0141\u0142\u0003,\u0016\u0000\u0142+\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0007\u0007\u0000\u0000\u0144-\u0001\u0000\u0000"+
		"\u0000!25;FPXenu}\u0081\u008b\u008e\u0097\u009a\u00a1\u00a7\u00ad\u00ba"+
		"\u00c3\u00dc\u00e3\u00ee\u00f9\u0100\u0109\u010e\u0118\u0122\u0127\u012c"+
		"\u0131\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}