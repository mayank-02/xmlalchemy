// Generated from /home/mayank/xmlalchemy/src/main/antlr4/edu/ucsd/xmlalchemy/ExprLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SLASH=1, DOUBLE_SLASH=2, VALUE_EQUALITY_KEYWORD=3, VALUE_EQUALITY_OPERATOR=4, 
		IDENTITY_EQUALITY_KEYWORD=5, IDENTITY_EQUALITY_OPERATOR=6, LOGICAL_NOT=7, 
		LOGICAL_AND=8, LOGICAL_OR=9, LEFT_PAREN=10, RIGHT_PAREN=11, LEFT_SQUARE_BRACKET=12, 
		RIGHT_SQUARE_BRACKET=13, COMMA=14, DOCUMENT=15, WILDCARD=16, SINGLE_DOT=17, 
		DOUBLE_DOT=18, TEXT=19, AT_SYMBOL=20, STRING_LITERAL=21, STRING=22, FILENAME=23, 
		WHITESPACE=24, ANY=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SLASH", "DOUBLE_SLASH", "VALUE_EQUALITY_KEYWORD", "VALUE_EQUALITY_OPERATOR", 
			"IDENTITY_EQUALITY_KEYWORD", "IDENTITY_EQUALITY_OPERATOR", "LOGICAL_NOT", 
			"LOGICAL_AND", "LOGICAL_OR", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_SQUARE_BRACKET", 
			"RIGHT_SQUARE_BRACKET", "COMMA", "DOCUMENT", "WILDCARD", "SINGLE_DOT", 
			"DOUBLE_DOT", "TEXT", "AT_SYMBOL", "STRING_LITERAL", "STRING", "FILENAME", 
			"WHITESPACE", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'eq'", "'='", "'is'", "'=='", "'not'", "'and'", 
			"'or'", "'('", "')'", "'['", "']'", "','", null, "'*'", "'.'", "'..'", 
			"'text()'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SLASH", "DOUBLE_SLASH", "VALUE_EQUALITY_KEYWORD", "VALUE_EQUALITY_OPERATOR", 
			"IDENTITY_EQUALITY_KEYWORD", "IDENTITY_EQUALITY_OPERATOR", "LOGICAL_NOT", 
			"LOGICAL_AND", "LOGICAL_OR", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_SQUARE_BRACKET", 
			"RIGHT_SQUARE_BRACKET", "COMMA", "DOCUMENT", "WILDCARD", "SINGLE_DOT", 
			"DOUBLE_DOT", "TEXT", "AT_SYMBOL", "STRING_LITERAL", "STRING", "FILENAME", 
			"WHITESPACE", "ANY"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u0086\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0005\u0015s\b\u0015\n\u0015\f\u0015v\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016z\b\u0016\n\u0016\f\u0016}\t\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000\u0007\u0002"+
		"\u0000DDdd\u0002\u0000OOoo\u0002\u0000CCcc\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0004\u0000.9AZ__az\u0003\u0000\t\n\r\r  \u0087\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00035"+
		"\u0001\u0000\u0000\u0000\u00058\u0001\u0000\u0000\u0000\u0007;\u0001\u0000"+
		"\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000b@\u0001\u0000\u0000\u0000"+
		"\rC\u0001\u0000\u0000\u0000\u000fG\u0001\u0000\u0000\u0000\u0011K\u0001"+
		"\u0000\u0000\u0000\u0013N\u0001\u0000\u0000\u0000\u0015P\u0001\u0000\u0000"+
		"\u0000\u0017R\u0001\u0000\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001b"+
		"V\u0001\u0000\u0000\u0000\u001dX\u0001\u0000\u0000\u0000\u001f\\\u0001"+
		"\u0000\u0000\u0000!^\u0001\u0000\u0000\u0000#`\u0001\u0000\u0000\u0000"+
		"%c\u0001\u0000\u0000\u0000\'j\u0001\u0000\u0000\u0000)l\u0001\u0000\u0000"+
		"\u0000+p\u0001\u0000\u0000\u0000-w\u0001\u0000\u0000\u0000/\u0080\u0001"+
		"\u0000\u0000\u00001\u0084\u0001\u0000\u0000\u000034\u0005/\u0000\u0000"+
		"4\u0002\u0001\u0000\u0000\u000056\u0005/\u0000\u000067\u0005/\u0000\u0000"+
		"7\u0004\u0001\u0000\u0000\u000089\u0005e\u0000\u00009:\u0005q\u0000\u0000"+
		":\u0006\u0001\u0000\u0000\u0000;<\u0005=\u0000\u0000<\b\u0001\u0000\u0000"+
		"\u0000=>\u0005i\u0000\u0000>?\u0005s\u0000\u0000?\n\u0001\u0000\u0000"+
		"\u0000@A\u0005=\u0000\u0000AB\u0005=\u0000\u0000B\f\u0001\u0000\u0000"+
		"\u0000CD\u0005n\u0000\u0000DE\u0005o\u0000\u0000EF\u0005t\u0000\u0000"+
		"F\u000e\u0001\u0000\u0000\u0000GH\u0005a\u0000\u0000HI\u0005n\u0000\u0000"+
		"IJ\u0005d\u0000\u0000J\u0010\u0001\u0000\u0000\u0000KL\u0005o\u0000\u0000"+
		"LM\u0005r\u0000\u0000M\u0012\u0001\u0000\u0000\u0000NO\u0005(\u0000\u0000"+
		"O\u0014\u0001\u0000\u0000\u0000PQ\u0005)\u0000\u0000Q\u0016\u0001\u0000"+
		"\u0000\u0000RS\u0005[\u0000\u0000S\u0018\u0001\u0000\u0000\u0000TU\u0005"+
		"]\u0000\u0000U\u001a\u0001\u0000\u0000\u0000VW\u0005,\u0000\u0000W\u001c"+
		"\u0001\u0000\u0000\u0000XY\u0007\u0000\u0000\u0000YZ\u0007\u0001\u0000"+
		"\u0000Z[\u0007\u0002\u0000\u0000[\u001e\u0001\u0000\u0000\u0000\\]\u0005"+
		"*\u0000\u0000] \u0001\u0000\u0000\u0000^_\u0005.\u0000\u0000_\"\u0001"+
		"\u0000\u0000\u0000`a\u0005.\u0000\u0000ab\u0005.\u0000\u0000b$\u0001\u0000"+
		"\u0000\u0000cd\u0005t\u0000\u0000de\u0005e\u0000\u0000ef\u0005x\u0000"+
		"\u0000fg\u0005t\u0000\u0000gh\u0005(\u0000\u0000hi\u0005)\u0000\u0000"+
		"i&\u0001\u0000\u0000\u0000jk\u0005@\u0000\u0000k(\u0001\u0000\u0000\u0000"+
		"lm\u0005\"\u0000\u0000mn\u0003+\u0015\u0000no\u0005\"\u0000\u0000o*\u0001"+
		"\u0000\u0000\u0000pt\u0007\u0003\u0000\u0000qs\u0007\u0004\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000u,\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000w{\u0005\"\u0000\u0000xz\u0007\u0005\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005\"\u0000\u0000\u007f.\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0007\u0006\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0006\u0017\u0000\u0000\u00830\u0001\u0000\u0000\u0000\u0084\u0085\t"+
		"\u0000\u0000\u0000\u00852\u0001\u0000\u0000\u0000\u0003\u0000t{\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}