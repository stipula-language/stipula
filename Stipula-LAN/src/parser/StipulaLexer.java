// Generated from Stipula.g4 by ANTLR 4.4
package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StipulaLexer extends Lexer {
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
		DOUBLE=42, BOOLEAN=43, PARTY=44, INIT=45, SINGLE_STRING=46, DOUBLE_STRING=47, 
		INT=48, REAL=49, WS=50, ID=51, OTHER=52, LINECOMENTS=53, BLOCKCOMENTS=54, 
		ERR=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'"
	};
	public static final String[] ruleNames = {
		"SEMIC", "COLON", "COMMA", "DOT", "EQ", "NEQ", "IMPL", "ASM", "ASSETUP", 
		"FIELDUP", "PLUS", "MINUS", "TIMES", "DIV", "AT", "TRUE", "FALSE", "LPAR", 
		"RPAR", "SLPAR", "SRPAR", "CLPAR", "CRPAR", "LEQ", "GEQ", "LE", "GE", 
		"OR", "AND", "NOT", "EMPTY", "NOW", "TRIGGER", "IF", "ELSEIF", "ELSE", 
		"STIPULA", "ASSET", "FIELD", "AGREEMENT", "INTEGER", "DOUBLE", "BOOLEAN", 
		"PARTY", "INIT", "SINGLE_STRING", "DOUBLE_STRING", "INT", "REAL", "WS", 
		"CHAR", "ID", "OTHER", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};


	   //there is a much better way to do this, check the ANTLR guide
	   //I will leave it like this for now just becasue it is quick
	   //but it doesn't work well
	   public int lexicalErrors=0;


	public StipulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Stipula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 55: ERR_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("Invalid char: "+ getText()); lexicalErrors++;  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\29\u016a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\6/\u0113\n/\r/\16/\u0114\3/\3/\3\60"+
		"\3\60\6\60\u011b\n\60\r\60\16\60\u011c\3\60\3\60\3\61\3\61\3\61\7\61\u0124"+
		"\n\61\f\61\16\61\u0127\13\61\5\61\u0129\n\61\3\62\7\62\u012c\n\62\f\62"+
		"\16\62\u012f\13\62\3\62\3\62\6\62\u0133\n\62\r\62\16\62\u0134\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u0141\n\65\f\65\16\65\u0144"+
		"\13\65\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u014c\n\67\f\67\16\67\u014f"+
		"\13\67\3\67\3\67\38\38\38\38\38\38\38\38\38\78\u015c\n8\f8\168\u015f\13"+
		"8\38\38\38\38\38\39\39\39\39\39\2\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\2i\65k\66m\67o8q9\3\2\f\3\2))\3\2$$\3\2\63;\3\2"+
		"\62;\5\2\13\f\17\17\"\"\4\2C\\c|\4\2\f\f\17\17\4\2,,\61\61\3\2,,\3\2\61"+
		"\61\u0176\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5u\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13"+
		"{\3\2\2\2\r~\3\2\2\2\17\u0081\3\2\2\2\21\u0085\3\2\2\2\23\u0087\3\2\2"+
		"\2\25\u008a\3\2\2\2\27\u008d\3\2\2\2\31\u008f\3\2\2\2\33\u0091\3\2\2\2"+
		"\35\u0093\3\2\2\2\37\u0095\3\2\2\2!\u0097\3\2\2\2#\u009c\3\2\2\2%\u00a2"+
		"\3\2\2\2\'\u00a4\3\2\2\2)\u00a6\3\2\2\2+\u00a8\3\2\2\2-\u00aa\3\2\2\2"+
		"/\u00ac\3\2\2\2\61\u00ae\3\2\2\2\63\u00b1\3\2\2\2\65\u00b4\3\2\2\2\67"+
		"\u00b6\3\2\2\29\u00b8\3\2\2\2;\u00bb\3\2\2\2=\u00be\3\2\2\2?\u00c0\3\2"+
		"\2\2A\u00c2\3\2\2\2C\u00c6\3\2\2\2E\u00c9\3\2\2\2G\u00cc\3\2\2\2I\u00d4"+
		"\3\2\2\2K\u00d9\3\2\2\2M\u00e1\3\2\2\2O\u00e7\3\2\2\2Q\u00ed\3\2\2\2S"+
		"\u00f7\3\2\2\2U\u00fb\3\2\2\2W\u0100\3\2\2\2Y\u0105\3\2\2\2[\u010b\3\2"+
		"\2\2]\u0110\3\2\2\2_\u0118\3\2\2\2a\u0128\3\2\2\2c\u012d\3\2\2\2e\u0136"+
		"\3\2\2\2g\u013a\3\2\2\2i\u013c\3\2\2\2k\u0145\3\2\2\2m\u0147\3\2\2\2o"+
		"\u0152\3\2\2\2q\u0165\3\2\2\2st\7=\2\2t\4\3\2\2\2uv\7<\2\2v\6\3\2\2\2"+
		"wx\7.\2\2x\b\3\2\2\2yz\7\60\2\2z\n\3\2\2\2{|\7?\2\2|}\7?\2\2}\f\3\2\2"+
		"\2~\177\7#\2\2\177\u0080\7?\2\2\u0080\16\3\2\2\2\u0081\u0082\7?\2\2\u0082"+
		"\u0083\7?\2\2\u0083\u0084\7@\2\2\u0084\20\3\2\2\2\u0085\u0086\7?\2\2\u0086"+
		"\22\3\2\2\2\u0087\u0088\7/\2\2\u0088\u0089\7\u25cd\2\2\u0089\24\3\2\2"+
		"\2\u008a\u008b\7/\2\2\u008b\u008c\7@\2\2\u008c\26\3\2\2\2\u008d\u008e"+
		"\7-\2\2\u008e\30\3\2\2\2\u008f\u0090\7/\2\2\u0090\32\3\2\2\2\u0091\u0092"+
		"\7,\2\2\u0092\34\3\2\2\2\u0093\u0094\7\61\2\2\u0094\36\3\2\2\2\u0095\u0096"+
		"\7B\2\2\u0096 \3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a"+
		"\7w\2\2\u009a\u009b\7g\2\2\u009b\"\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e"+
		"\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"$\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7+\2\2\u00a5("+
		"\3\2\2\2\u00a6\u00a7\7]\2\2\u00a7*\3\2\2\2\u00a8\u00a9\7_\2\2\u00a9,\3"+
		"\2\2\2\u00aa\u00ab\7}\2\2\u00ab.\3\2\2\2\u00ac\u00ad\7\177\2\2\u00ad\60"+
		"\3\2\2\2\u00ae\u00af\7>\2\2\u00af\u00b0\7?\2\2\u00b0\62\3\2\2\2\u00b1"+
		"\u00b2\7@\2\2\u00b2\u00b3\7?\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7>\2\2\u00b5"+
		"\66\3\2\2\2\u00b6\u00b7\7@\2\2\u00b78\3\2\2\2\u00b8\u00b9\7~\2\2\u00b9"+
		"\u00ba\7~\2\2\u00ba:\3\2\2\2\u00bb\u00bc\7(\2\2\u00bc\u00bd\7(\2\2\u00bd"+
		"<\3\2\2\2\u00be\u00bf\7#\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7a\2\2\u00c1@"+
		"\3\2\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7y\2\2\u00c5"+
		"B\3\2\2\2\u00c6\u00c7\7@\2\2\u00c7\u00c8\7@\2\2\u00c8D\3\2\2\2\u00c9\u00ca"+
		"\7k\2\2\u00ca\u00cb\7h\2\2\u00cbF\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce"+
		"\7n\2\2\u00ce\u00cf\7u\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7\"\2\2\u00d1"+
		"\u00d2\7k\2\2\u00d2\u00d3\7h\2\2\u00d3H\3\2\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7n\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7g\2\2\u00d8J\3\2\2\2\u00d9"+
		"\u00da\7u\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7r\2\2"+
		"\u00dd\u00de\7w\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7c\2\2\u00e0L\3\2\2"+
		"\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5"+
		"\7g\2\2\u00e5\u00e6\7v\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9"+
		"\7k\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7f\2\2\u00ec"+
		"P\3\2\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7i\2\2\u00ef\u00f0\7t\2\2\u00f0"+
		"\u00f1\7g\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7o\2\2\u00f3\u00f4\7g\2\2"+
		"\u00f4\u00f5\7p\2\2\u00f5\u00f6\7v\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7k\2"+
		"\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7v\2\2\u00faT\3\2\2\2\u00fb\u00fc\7"+
		"t\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7n\2\2\u00ffV"+
		"\3\2\2\2\u0100\u0101\7d\2\2\u0101\u0102\7q\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7n\2\2\u0104X\3\2\2\2\u0105\u0106\7r\2\2\u0106\u0107\7c\2\2\u0107"+
		"\u0108\7t\2\2\u0108\u0109\7v\2\2\u0109\u010a\7{\2\2\u010aZ\3\2\2\2\u010b"+
		"\u010c\7k\2\2\u010c\u010d\7p\2\2\u010d\u010e\7k\2\2\u010e\u010f\7v\2\2"+
		"\u010f\\\3\2\2\2\u0110\u0112\7)\2\2\u0111\u0113\n\2\2\2\u0112\u0111\3"+
		"\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\7)\2\2\u0117^\3\2\2\2\u0118\u011a\7$\2\2\u0119"+
		"\u011b\n\3\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7$\2\2\u011f"+
		"`\3\2\2\2\u0120\u0129\7\62\2\2\u0121\u0125\t\4\2\2\u0122\u0124\t\5\2\2"+
		"\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0120\3\2\2\2\u0128"+
		"\u0121\3\2\2\2\u0129b\3\2\2\2\u012a\u012c\t\5\2\2\u012b\u012a\3\2\2\2"+
		"\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130"+
		"\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\7\60\2\2\u0131\u0133\t\5\2\2"+
		"\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135d\3\2\2\2\u0136\u0137\t\6\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0139\b\63\2\2\u0139f\3\2\2\2\u013a\u013b\t\7\2\2\u013bh\3\2\2\2\u013c"+
		"\u0142\5g\64\2\u013d\u0141\5g\64\2\u013e\u0141\5a\61\2\u013f\u0141\5?"+
		" \2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141"+
		"\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143j\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0145\u0146\13\2\2\2\u0146l\3\2\2\2\u0147\u0148\7"+
		"\61\2\2\u0148\u0149\7\61\2\2\u0149\u014d\3\2\2\2\u014a\u014c\n\b\2\2\u014b"+
		"\u014a\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\b\67\2\2\u0151"+
		"n\3\2\2\2\u0152\u0153\7\61\2\2\u0153\u0154\7,\2\2\u0154\u015d\3\2\2\2"+
		"\u0155\u015c\n\t\2\2\u0156\u0157\7\61\2\2\u0157\u015c\n\n\2\2\u0158\u0159"+
		"\7,\2\2\u0159\u015c\n\13\2\2\u015a\u015c\5o8\2\u015b\u0155\3\2\2\2\u015b"+
		"\u0156\3\2\2\2\u015b\u0158\3\2\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0161\7,\2\2\u0161\u0162\7\61\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0164\b8\2\2\u0164p\3\2\2\2\u0165\u0166\13\2\2\2\u0166\u0167"+
		"\b9\3\2\u0167\u0168\3\2\2\2\u0168\u0169\b9\4\2\u0169r\3\2\2\2\16\2\u0114"+
		"\u011c\u0125\u0128\u012d\u0134\u0140\u0142\u014d\u015b\u015d\5\b\2\2\3"+
		"9\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}