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
		IDENTITY_EQUALITY_KEYWORD=5, IDENTITY_EQUALITY_OPERATOR=6, ASSIGNMENT_OPERATOR=7, 
		EMPTY=8, FOR=9, IN=10, LET=11, LOGICAL_AND=12, LOGICAL_NOT=13, LOGICAL_OR=14, 
		RETURN=15, SATISFIES=16, SOME=17, WHERE=18, LEFT_PAREN=19, RIGHT_PAREN=20, 
		LEFT_SQUARE_BRACKET=21, RIGHT_SQUARE_BRACKET=22, LEFT_ANGLE_BRACKET=23, 
		RIGHT_ANGLE_BRACKET=24, LEFT_CURLY_BRACKET=25, RIGHT_CURLY_BRACKET=26, 
		COMMA=27, DOCUMENT=28, WILDCARD=29, SINGLE_DOT=30, DOUBLE_DOT=31, TEXT=32, 
		AT_SYMBOL=33, DOLLAR=34, NAME=35, STRING=36, WHITESPACE=37, ANY=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SLASH", "DOUBLE_SLASH", "VALUE_EQUALITY_KEYWORD", "VALUE_EQUALITY_OPERATOR", 
			"IDENTITY_EQUALITY_KEYWORD", "IDENTITY_EQUALITY_OPERATOR", "ASSIGNMENT_OPERATOR", 
			"EMPTY", "FOR", "IN", "LET", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", 
			"RETURN", "SATISFIES", "SOME", "WHERE", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", "LEFT_ANGLE_BRACKET", 
			"RIGHT_ANGLE_BRACKET", "LEFT_CURLY_BRACKET", "RIGHT_CURLY_BRACKET", "COMMA", 
			"DOCUMENT", "WILDCARD", "SINGLE_DOT", "DOUBLE_DOT", "TEXT", "AT_SYMBOL", 
			"DOLLAR", "NAME", "STRING", "ASCII_CHAR", "ESCAPE_SEQ", "WHITESPACE", 
			"ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'eq'", "'='", "'is'", "'=='", "':='", "'empty'", 
			"'for'", "'in'", "'let'", "'and'", "'not'", "'or'", "'return'", "'satisfies'", 
			"'some'", "'where'", "'('", "')'", "'['", "']'", "'<'", "'>'", "'{'", 
			"'}'", "','", null, "'*'", "'.'", "'..'", "'text()'", "'@'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SLASH", "DOUBLE_SLASH", "VALUE_EQUALITY_KEYWORD", "VALUE_EQUALITY_OPERATOR", 
			"IDENTITY_EQUALITY_KEYWORD", "IDENTITY_EQUALITY_OPERATOR", "ASSIGNMENT_OPERATOR", 
			"EMPTY", "FOR", "IN", "LET", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", 
			"RETURN", "SATISFIES", "SOME", "WHERE", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", "LEFT_ANGLE_BRACKET", 
			"RIGHT_ANGLE_BRACKET", "LEFT_CURLY_BRACKET", "RIGHT_CURLY_BRACKET", "COMMA", 
			"DOCUMENT", "WILDCARD", "SINGLE_DOT", "DOUBLE_DOT", "TEXT", "AT_SYMBOL", 
			"DOLLAR", "NAME", "STRING", "WHITESPACE", "ANY"
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
		"\u0004\u0000&\u00e0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0001\"\u0001\"\u0005\"\u00c7\b\"\n\"\f\"\u00ca\t\"\u0001"+
		"#\u0001#\u0001#\u0005#\u00cf\b#\n#\f#\u00d2\t#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0000"+
		"\u0000(\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$I\u0000K\u0000M%O&\u0001\u0000\b\u0002\u0000DDdd\u0002\u0000OOoo\u0002"+
		"\u0000CCcc\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000 !#[]~\u0002"+
		"\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u00e0\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000"+
		"\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000"+
		"\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0001Q"+
		"\u0001\u0000\u0000\u0000\u0003S\u0001\u0000\u0000\u0000\u0005V\u0001\u0000"+
		"\u0000\u0000\u0007Y\u0001\u0000\u0000\u0000\t[\u0001\u0000\u0000\u0000"+
		"\u000b^\u0001\u0000\u0000\u0000\ra\u0001\u0000\u0000\u0000\u000fd\u0001"+
		"\u0000\u0000\u0000\u0011j\u0001\u0000\u0000\u0000\u0013n\u0001\u0000\u0000"+
		"\u0000\u0015q\u0001\u0000\u0000\u0000\u0017u\u0001\u0000\u0000\u0000\u0019"+
		"y\u0001\u0000\u0000\u0000\u001b}\u0001\u0000\u0000\u0000\u001d\u0080\u0001"+
		"\u0000\u0000\u0000\u001f\u0087\u0001\u0000\u0000\u0000!\u0091\u0001\u0000"+
		"\u0000\u0000#\u0096\u0001\u0000\u0000\u0000%\u009c\u0001\u0000\u0000\u0000"+
		"\'\u009e\u0001\u0000\u0000\u0000)\u00a0\u0001\u0000\u0000\u0000+\u00a2"+
		"\u0001\u0000\u0000\u0000-\u00a4\u0001\u0000\u0000\u0000/\u00a6\u0001\u0000"+
		"\u0000\u00001\u00a8\u0001\u0000\u0000\u00003\u00aa\u0001\u0000\u0000\u0000"+
		"5\u00ac\u0001\u0000\u0000\u00007\u00ae\u0001\u0000\u0000\u00009\u00b2"+
		"\u0001\u0000\u0000\u0000;\u00b4\u0001\u0000\u0000\u0000=\u00b6\u0001\u0000"+
		"\u0000\u0000?\u00b9\u0001\u0000\u0000\u0000A\u00c0\u0001\u0000\u0000\u0000"+
		"C\u00c2\u0001\u0000\u0000\u0000E\u00c4\u0001\u0000\u0000\u0000G\u00cb"+
		"\u0001\u0000\u0000\u0000I\u00d5\u0001\u0000\u0000\u0000K\u00d7\u0001\u0000"+
		"\u0000\u0000M\u00da\u0001\u0000\u0000\u0000O\u00de\u0001\u0000\u0000\u0000"+
		"QR\u0005/\u0000\u0000R\u0002\u0001\u0000\u0000\u0000ST\u0005/\u0000\u0000"+
		"TU\u0005/\u0000\u0000U\u0004\u0001\u0000\u0000\u0000VW\u0005e\u0000\u0000"+
		"WX\u0005q\u0000\u0000X\u0006\u0001\u0000\u0000\u0000YZ\u0005=\u0000\u0000"+
		"Z\b\u0001\u0000\u0000\u0000[\\\u0005i\u0000\u0000\\]\u0005s\u0000\u0000"+
		"]\n\u0001\u0000\u0000\u0000^_\u0005=\u0000\u0000_`\u0005=\u0000\u0000"+
		"`\f\u0001\u0000\u0000\u0000ab\u0005:\u0000\u0000bc\u0005=\u0000\u0000"+
		"c\u000e\u0001\u0000\u0000\u0000de\u0005e\u0000\u0000ef\u0005m\u0000\u0000"+
		"fg\u0005p\u0000\u0000gh\u0005t\u0000\u0000hi\u0005y\u0000\u0000i\u0010"+
		"\u0001\u0000\u0000\u0000jk\u0005f\u0000\u0000kl\u0005o\u0000\u0000lm\u0005"+
		"r\u0000\u0000m\u0012\u0001\u0000\u0000\u0000no\u0005i\u0000\u0000op\u0005"+
		"n\u0000\u0000p\u0014\u0001\u0000\u0000\u0000qr\u0005l\u0000\u0000rs\u0005"+
		"e\u0000\u0000st\u0005t\u0000\u0000t\u0016\u0001\u0000\u0000\u0000uv\u0005"+
		"a\u0000\u0000vw\u0005n\u0000\u0000wx\u0005d\u0000\u0000x\u0018\u0001\u0000"+
		"\u0000\u0000yz\u0005n\u0000\u0000z{\u0005o\u0000\u0000{|\u0005t\u0000"+
		"\u0000|\u001a\u0001\u0000\u0000\u0000}~\u0005o\u0000\u0000~\u007f\u0005"+
		"r\u0000\u0000\u007f\u001c\u0001\u0000\u0000\u0000\u0080\u0081\u0005r\u0000"+
		"\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005t\u0000\u0000\u0083"+
		"\u0084\u0005u\u0000\u0000\u0084\u0085\u0005r\u0000\u0000\u0085\u0086\u0005"+
		"n\u0000\u0000\u0086\u001e\u0001\u0000\u0000\u0000\u0087\u0088\u0005s\u0000"+
		"\u0000\u0088\u0089\u0005a\u0000\u0000\u0089\u008a\u0005t\u0000\u0000\u008a"+
		"\u008b\u0005i\u0000\u0000\u008b\u008c\u0005s\u0000\u0000\u008c\u008d\u0005"+
		"f\u0000\u0000\u008d\u008e\u0005i\u0000\u0000\u008e\u008f\u0005e\u0000"+
		"\u0000\u008f\u0090\u0005s\u0000\u0000\u0090 \u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005s\u0000\u0000\u0092\u0093\u0005o\u0000\u0000\u0093\u0094\u0005"+
		"m\u0000\u0000\u0094\u0095\u0005e\u0000\u0000\u0095\"\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005w\u0000\u0000\u0097\u0098\u0005h\u0000\u0000\u0098"+
		"\u0099\u0005e\u0000\u0000\u0099\u009a\u0005r\u0000\u0000\u009a\u009b\u0005"+
		"e\u0000\u0000\u009b$\u0001\u0000\u0000\u0000\u009c\u009d\u0005(\u0000"+
		"\u0000\u009d&\u0001\u0000\u0000\u0000\u009e\u009f\u0005)\u0000\u0000\u009f"+
		"(\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005[\u0000\u0000\u00a1*\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005]\u0000\u0000\u00a3,\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005<\u0000\u0000\u00a5.\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0005>\u0000\u0000\u00a70\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"{\u0000\u0000\u00a92\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005}\u0000"+
		"\u0000\u00ab4\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005,\u0000\u0000\u00ad"+
		"6\u0001\u0000\u0000\u0000\u00ae\u00af\u0007\u0000\u0000\u0000\u00af\u00b0"+
		"\u0007\u0001\u0000\u0000\u00b0\u00b1\u0007\u0002\u0000\u0000\u00b18\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b3\u0005*\u0000\u0000\u00b3:\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005.\u0000\u0000\u00b5<\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0005.\u0000\u0000\u00b7\u00b8\u0005.\u0000\u0000\u00b8>\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005t\u0000\u0000\u00ba\u00bb\u0005e\u0000"+
		"\u0000\u00bb\u00bc\u0005x\u0000\u0000\u00bc\u00bd\u0005t\u0000\u0000\u00bd"+
		"\u00be\u0005(\u0000\u0000\u00be\u00bf\u0005)\u0000\u0000\u00bf@\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005@\u0000\u0000\u00c1B\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005$\u0000\u0000\u00c3D\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c8\u0007\u0003\u0000\u0000\u00c5\u00c7\u0007\u0004\u0000\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"F\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00d0"+
		"\u0005\"\u0000\u0000\u00cc\u00cf\u0003I$\u0000\u00cd\u00cf\u0003K%\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\"\u0000\u0000\u00d4"+
		"H\u0001\u0000\u0000\u0000\u00d5\u00d6\u0007\u0005\u0000\u0000\u00d6J\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0005\\\u0000\u0000\u00d8\u00d9\u0007\u0006"+
		"\u0000\u0000\u00d9L\u0001\u0000\u0000\u0000\u00da\u00db\u0007\u0007\u0000"+
		"\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0006&\u0000\u0000"+
		"\u00ddN\u0001\u0000\u0000\u0000\u00de\u00df\t\u0000\u0000\u0000\u00df"+
		"P\u0001\u0000\u0000\u0000\u0004\u0000\u00c8\u00ce\u00d0\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}