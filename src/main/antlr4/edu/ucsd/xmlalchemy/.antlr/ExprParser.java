// Generated from /home/mayank/xmlalchemy/src/main/antlr4/edu/ucsd/xmlalchemy/ExprParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
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
	public static final int
		RULE_absolutePath = 0, RULE_relativePath = 1, RULE_pathFilter = 2, RULE_documentName = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"absolutePath", "relativePath", "pathFilter", "documentName"
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

	@Override
	public String getGrammarFileName() { return "ExprParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathContext extends ParserRuleContext {
		public AbsolutePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolutePath; }
	 
		public AbsolutePathContext() { }
		public void copyFrom(AbsolutePathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathDescendantContext extends AbsolutePathContext {
		public TerminalNode DOCUMENT() { return getToken(ExprParser.DOCUMENT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public TerminalNode FILENAME() { return getToken(ExprParser.FILENAME, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public TerminalNode DOUBLE_SLASH() { return getToken(ExprParser.DOUBLE_SLASH, 0); }
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public AbsolutePathDescendantContext(AbsolutePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathChildContext extends AbsolutePathContext {
		public DocumentNameContext documentName() {
			return getRuleContext(DocumentNameContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ExprParser.SLASH, 0); }
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public AbsolutePathChildContext(AbsolutePathContext ctx) { copyFrom(ctx); }
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_absolutePath);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new AbsolutePathChildContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				documentName();
				setState(9);
				match(SLASH);
				setState(10);
				relativePath(0);
				}
				break;
			case 2:
				_localctx = new AbsolutePathDescendantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				match(DOCUMENT);
				setState(13);
				match(LEFT_PAREN);
				setState(14);
				match(FILENAME);
				setState(15);
				match(RIGHT_PAREN);
				setState(16);
				match(DOUBLE_SLASH);
				setState(17);
				relativePath(0);
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
	public static class RelativePathContext extends ParserRuleContext {
		public RelativePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativePath; }
	 
		public RelativePathContext() { }
		public void copyFrom(RelativePathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathChildContext extends RelativePathContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode SLASH() { return getToken(ExprParser.SLASH, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public RelativePathChildContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentContext extends RelativePathContext {
		public TerminalNode DOUBLE_DOT() { return getToken(ExprParser.DOUBLE_DOT, 0); }
		public ParentContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathParenthesizedContext extends RelativePathContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public RelativePathParenthesizedContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CurrentContext extends RelativePathContext {
		public TerminalNode SINGLE_DOT() { return getToken(ExprParser.SINGLE_DOT, 0); }
		public CurrentContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathWithPathFilterContext extends RelativePathContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(ExprParser.LEFT_SQUARE_BRACKET, 0); }
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(ExprParser.RIGHT_SQUARE_BRACKET, 0); }
		public RelativePathWithPathFilterContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeNameContext extends RelativePathContext {
		public Token attributeName;
		public TerminalNode AT_SYMBOL() { return getToken(ExprParser.AT_SYMBOL, 0); }
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public AttributeNameContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends RelativePathContext {
		public TerminalNode TEXT() { return getToken(ExprParser.TEXT, 0); }
		public TextContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends RelativePathContext {
		public Token tagName;
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public TagNameContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathConcatenationContext extends RelativePathContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public RelativePathConcatenationContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathDescendantContext extends RelativePathContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode DOUBLE_SLASH() { return getToken(ExprParser.DOUBLE_SLASH, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public RelativePathDescendantContext(RelativePathContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WildcardContext extends RelativePathContext {
		public TerminalNode WILDCARD() { return getToken(ExprParser.WILDCARD, 0); }
		public WildcardContext(RelativePathContext ctx) { copyFrom(ctx); }
	}

	public final RelativePathContext relativePath() throws RecognitionException {
		return relativePath(0);
	}

	private RelativePathContext relativePath(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelativePathContext _localctx = new RelativePathContext(_ctx, _parentState);
		RelativePathContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				((TagNameContext)_localctx).tagName = match(STRING);
				}
				break;
			case WILDCARD:
				{
				_localctx = new WildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(WILDCARD);
				}
				break;
			case SINGLE_DOT:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(SINGLE_DOT);
				}
				break;
			case DOUBLE_DOT:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(DOUBLE_DOT);
				}
				break;
			case TEXT:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(TEXT);
				}
				break;
			case AT_SYMBOL:
				{
				_localctx = new AttributeNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(AT_SYMBOL);
				setState(27);
				((AttributeNameContext)_localctx).attributeName = match(STRING);
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new RelativePathParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(LEFT_PAREN);
				setState(29);
				relativePath(0);
				setState(30);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(48);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathChildContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathChildContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(34);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(35);
						match(SLASH);
						setState(36);
						((RelativePathChildContext)_localctx).right = relativePath(5);
						}
						break;
					case 2:
						{
						_localctx = new RelativePathDescendantContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathDescendantContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(37);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(38);
						match(DOUBLE_SLASH);
						setState(39);
						((RelativePathDescendantContext)_localctx).right = relativePath(4);
						}
						break;
					case 3:
						{
						_localctx = new RelativePathConcatenationContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(40);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(41);
						match(COMMA);
						setState(42);
						((RelativePathConcatenationContext)_localctx).right = relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new RelativePathWithPathFilterContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(43);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(44);
						match(LEFT_SQUARE_BRACKET);
						setState(45);
						pathFilter(0);
						setState(46);
						match(RIGHT_SQUARE_BRACKET);
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterContext extends ParserRuleContext {
		public PathFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathFilter; }
	 
		public PathFilterContext() { }
		public void copyFrom(PathFilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterValueEqualOperatorContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode VALUE_EQUALITY_OPERATOR() { return getToken(ExprParser.VALUE_EQUALITY_OPERATOR, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public PathFilterValueEqualOperatorContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterOrContext extends PathFilterContext {
		public PathFilterContext left;
		public PathFilterContext right;
		public TerminalNode LOGICAL_OR() { return getToken(ExprParser.LOGICAL_OR, 0); }
		public List<PathFilterContext> pathFilter() {
			return getRuleContexts(PathFilterContext.class);
		}
		public PathFilterContext pathFilter(int i) {
			return getRuleContext(PathFilterContext.class,i);
		}
		public PathFilterOrContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterEqualStringConstantContext extends PathFilterContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public TerminalNode VALUE_EQUALITY_OPERATOR() { return getToken(ExprParser.VALUE_EQUALITY_OPERATOR, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ExprParser.STRING_LITERAL, 0); }
		public PathFilterEqualStringConstantContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterParenthesizedContext extends PathFilterContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public PathFilterParenthesizedContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterNotContext extends PathFilterContext {
		public TerminalNode LOGICAL_NOT() { return getToken(ExprParser.LOGICAL_NOT, 0); }
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public PathFilterNotContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterValueEqualKeywordContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode VALUE_EQUALITY_KEYWORD() { return getToken(ExprParser.VALUE_EQUALITY_KEYWORD, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public PathFilterValueEqualKeywordContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterAndContext extends PathFilterContext {
		public PathFilterContext left;
		public PathFilterContext right;
		public TerminalNode LOGICAL_AND() { return getToken(ExprParser.LOGICAL_AND, 0); }
		public List<PathFilterContext> pathFilter() {
			return getRuleContexts(PathFilterContext.class);
		}
		public PathFilterContext pathFilter(int i) {
			return getRuleContext(PathFilterContext.class,i);
		}
		public PathFilterAndContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterIdentityEqualKeywordContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode IDENTITY_EQUALITY_KEYWORD() { return getToken(ExprParser.IDENTITY_EQUALITY_KEYWORD, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public PathFilterIdentityEqualKeywordContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterRelativePathContext extends PathFilterContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public PathFilterRelativePathContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterIdentityEqualOperatorContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public TerminalNode IDENTITY_EQUALITY_OPERATOR() { return getToken(ExprParser.IDENTITY_EQUALITY_OPERATOR, 0); }
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public PathFilterIdentityEqualOperatorContext(PathFilterContext ctx) { copyFrom(ctx); }
	}

	public final PathFilterContext pathFilter() throws RecognitionException {
		return pathFilter(0);
	}

	private PathFilterContext pathFilter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathFilterContext _localctx = new PathFilterContext(_ctx, _parentState);
		PathFilterContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_pathFilter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new PathFilterRelativePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				relativePath(0);
				}
				break;
			case 2:
				{
				_localctx = new PathFilterValueEqualOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				((PathFilterValueEqualOperatorContext)_localctx).left = relativePath(0);
				setState(56);
				match(VALUE_EQUALITY_OPERATOR);
				setState(57);
				((PathFilterValueEqualOperatorContext)_localctx).right = relativePath(0);
				}
				break;
			case 3:
				{
				_localctx = new PathFilterValueEqualKeywordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				((PathFilterValueEqualKeywordContext)_localctx).left = relativePath(0);
				setState(60);
				match(VALUE_EQUALITY_KEYWORD);
				setState(61);
				((PathFilterValueEqualKeywordContext)_localctx).right = relativePath(0);
				}
				break;
			case 4:
				{
				_localctx = new PathFilterIdentityEqualOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				((PathFilterIdentityEqualOperatorContext)_localctx).left = relativePath(0);
				setState(64);
				match(IDENTITY_EQUALITY_OPERATOR);
				setState(65);
				((PathFilterIdentityEqualOperatorContext)_localctx).right = relativePath(0);
				}
				break;
			case 5:
				{
				_localctx = new PathFilterIdentityEqualKeywordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				((PathFilterIdentityEqualKeywordContext)_localctx).left = relativePath(0);
				setState(68);
				match(IDENTITY_EQUALITY_KEYWORD);
				setState(69);
				((PathFilterIdentityEqualKeywordContext)_localctx).right = relativePath(0);
				}
				break;
			case 6:
				{
				_localctx = new PathFilterEqualStringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				relativePath(0);
				setState(72);
				match(VALUE_EQUALITY_OPERATOR);
				setState(73);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				_localctx = new PathFilterParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(LEFT_PAREN);
				setState(76);
				pathFilter(0);
				setState(77);
				match(RIGHT_PAREN);
				}
				break;
			case 8:
				{
				_localctx = new PathFilterNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(LOGICAL_NOT);
				setState(80);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterAndContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(83);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(84);
						match(LOGICAL_AND);
						setState(85);
						((PathFilterAndContext)_localctx).right = pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterOrContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(86);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(87);
						match(LOGICAL_OR);
						setState(88);
						((PathFilterOrContext)_localctx).right = pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentNameContext extends ParserRuleContext {
		public TerminalNode DOCUMENT() { return getToken(ExprParser.DOCUMENT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public TerminalNode FILENAME() { return getToken(ExprParser.FILENAME, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public DocumentNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentName; }
	}

	public final DocumentNameContext documentName() throws RecognitionException {
		DocumentNameContext _localctx = new DocumentNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_documentName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(DOCUMENT);
			setState(95);
			match(LEFT_PAREN);
			setState(96);
			match(FILENAME);
			setState(97);
			match(RIGHT_PAREN);
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
		case 1:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 2:
			return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u0013\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001!\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00011\b\u0001\n\u0001\f\u00014\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002R\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002Z\b\u0002\n\u0002\f\u0002]\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0002\u0002\u0004\u0004"+
		"\u0000\u0002\u0004\u0006\u0000\u0000s\u0000\u0012\u0001\u0000\u0000\u0000"+
		"\u0002 \u0001\u0000\u0000\u0000\u0004Q\u0001\u0000\u0000\u0000\u0006^"+
		"\u0001\u0000\u0000\u0000\b\t\u0003\u0006\u0003\u0000\t\n\u0005\u0001\u0000"+
		"\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\u0013\u0001\u0000\u0000\u0000"+
		"\f\r\u0005\u000f\u0000\u0000\r\u000e\u0005\n\u0000\u0000\u000e\u000f\u0005"+
		"\u0017\u0000\u0000\u000f\u0010\u0005\u000b\u0000\u0000\u0010\u0011\u0005"+
		"\u0002\u0000\u0000\u0011\u0013\u0003\u0002\u0001\u0000\u0012\b\u0001\u0000"+
		"\u0000\u0000\u0012\f\u0001\u0000\u0000\u0000\u0013\u0001\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0006\u0001\uffff\uffff\u0000\u0015!\u0005\u0016\u0000"+
		"\u0000\u0016!\u0005\u0010\u0000\u0000\u0017!\u0005\u0011\u0000\u0000\u0018"+
		"!\u0005\u0012\u0000\u0000\u0019!\u0005\u0013\u0000\u0000\u001a\u001b\u0005"+
		"\u0014\u0000\u0000\u001b!\u0005\u0016\u0000\u0000\u001c\u001d\u0005\n"+
		"\u0000\u0000\u001d\u001e\u0003\u0002\u0001\u0000\u001e\u001f\u0005\u000b"+
		"\u0000\u0000\u001f!\u0001\u0000\u0000\u0000 \u0014\u0001\u0000\u0000\u0000"+
		" \u0016\u0001\u0000\u0000\u0000 \u0017\u0001\u0000\u0000\u0000 \u0018"+
		"\u0001\u0000\u0000\u0000 \u0019\u0001\u0000\u0000\u0000 \u001a\u0001\u0000"+
		"\u0000\u0000 \u001c\u0001\u0000\u0000\u0000!2\u0001\u0000\u0000\u0000"+
		"\"#\n\u0004\u0000\u0000#$\u0005\u0001\u0000\u0000$1\u0003\u0002\u0001"+
		"\u0005%&\n\u0003\u0000\u0000&\'\u0005\u0002\u0000\u0000\'1\u0003\u0002"+
		"\u0001\u0004()\n\u0001\u0000\u0000)*\u0005\u000e\u0000\u0000*1\u0003\u0002"+
		"\u0001\u0002+,\n\u0002\u0000\u0000,-\u0005\f\u0000\u0000-.\u0003\u0004"+
		"\u0002\u0000./\u0005\r\u0000\u0000/1\u0001\u0000\u0000\u00000\"\u0001"+
		"\u0000\u0000\u00000%\u0001\u0000\u0000\u00000(\u0001\u0000\u0000\u0000"+
		"0+\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000056\u0006\u0002\uffff\uffff\u00006R\u0003\u0002\u0001"+
		"\u000078\u0003\u0002\u0001\u000089\u0005\u0004\u0000\u00009:\u0003\u0002"+
		"\u0001\u0000:R\u0001\u0000\u0000\u0000;<\u0003\u0002\u0001\u0000<=\u0005"+
		"\u0003\u0000\u0000=>\u0003\u0002\u0001\u0000>R\u0001\u0000\u0000\u0000"+
		"?@\u0003\u0002\u0001\u0000@A\u0005\u0006\u0000\u0000AB\u0003\u0002\u0001"+
		"\u0000BR\u0001\u0000\u0000\u0000CD\u0003\u0002\u0001\u0000DE\u0005\u0005"+
		"\u0000\u0000EF\u0003\u0002\u0001\u0000FR\u0001\u0000\u0000\u0000GH\u0003"+
		"\u0002\u0001\u0000HI\u0005\u0004\u0000\u0000IJ\u0005\u0015\u0000\u0000"+
		"JR\u0001\u0000\u0000\u0000KL\u0005\n\u0000\u0000LM\u0003\u0004\u0002\u0000"+
		"MN\u0005\u000b\u0000\u0000NR\u0001\u0000\u0000\u0000OP\u0005\u0007\u0000"+
		"\u0000PR\u0003\u0004\u0002\u0001Q5\u0001\u0000\u0000\u0000Q7\u0001\u0000"+
		"\u0000\u0000Q;\u0001\u0000\u0000\u0000Q?\u0001\u0000\u0000\u0000QC\u0001"+
		"\u0000\u0000\u0000QG\u0001\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000R[\u0001\u0000\u0000\u0000ST\n\u0003\u0000\u0000"+
		"TU\u0005\b\u0000\u0000UZ\u0003\u0004\u0002\u0004VW\n\u0002\u0000\u0000"+
		"WX\u0005\t\u0000\u0000XZ\u0003\u0004\u0002\u0003YS\u0001\u0000\u0000\u0000"+
		"YV\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\\u0005\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^_\u0005\u000f\u0000\u0000_`\u0005\n\u0000\u0000`a\u0005"+
		"\u0017\u0000\u0000ab\u0005\u000b\u0000\u0000b\u0007\u0001\u0000\u0000"+
		"\u0000\u0007\u0012 02QY[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}