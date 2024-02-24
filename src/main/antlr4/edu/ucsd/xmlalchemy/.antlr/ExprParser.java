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
		IDENTITY_EQUALITY_KEYWORD=5, IDENTITY_EQUALITY_OPERATOR=6, ASSIGNMENT_OPERATOR=7, 
		EMPTY=8, FOR=9, IN=10, LET=11, LOGICAL_AND=12, LOGICAL_NOT=13, LOGICAL_OR=14, 
		RETURN=15, SATISFIES=16, SOME=17, WHERE=18, LEFT_PAREN=19, RIGHT_PAREN=20, 
		LEFT_SQUARE_BRACKET=21, RIGHT_SQUARE_BRACKET=22, LEFT_ANGLE_BRACKET=23, 
		RIGHT_ANGLE_BRACKET=24, LEFT_CURLY_BRACKET=25, RIGHT_CURLY_BRACKET=26, 
		COMMA=27, DOCUMENT=28, WILDCARD=29, SINGLE_DOT=30, DOUBLE_DOT=31, TEXT=32, 
		AT_SYMBOL=33, DOLLAR=34, NAME=35, STRING=36, WHITESPACE=37, ANY=38;
	public static final int
		RULE_query = 0, RULE_queryCondition = 1, RULE_absolutePath = 2, RULE_relativePath = 3, 
		RULE_pathFilter = 4, RULE_openingTag = 5, RULE_closingTag = 6, RULE_forClause = 7, 
		RULE_letClause = 8, RULE_whereClause = 9, RULE_returnClause = 10, RULE_var = 11, 
		RULE_documentName = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "queryCondition", "absolutePath", "relativePath", "pathFilter", 
			"openingTag", "closingTag", "forClause", "letClause", "whereClause", 
			"returnClause", "var", "documentName"
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
	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	 
		public QueryContext() { }
		public void copyFrom(QueryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryDescendantContext extends QueryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode DOUBLE_SLASH() { return getToken(ExprParser.DOUBLE_SLASH, 0); }
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public QueryDescendantContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends QueryContext {
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public StringLiteralContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends QueryContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VariableContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryElementContext extends QueryContext {
		public OpeningTagContext openingTag() {
			return getRuleContext(OpeningTagContext.class,0);
		}
		public TerminalNode LEFT_CURLY_BRACKET() { return getToken(ExprParser.LEFT_CURLY_BRACKET, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RIGHT_CURLY_BRACKET() { return getToken(ExprParser.RIGHT_CURLY_BRACKET, 0); }
		public ClosingTagContext closingTag() {
			return getRuleContext(ClosingTagContext.class,0);
		}
		public QueryElementContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConcatenationContext extends QueryContext {
		public QueryContext left;
		public QueryContext right;
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public QueryConcatenationContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryLetClauseContext extends QueryContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public QueryLetClauseContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryFlworContext extends QueryContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public QueryFlworContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryAbsolutePathContext extends QueryContext {
		public AbsolutePathContext absolutePath() {
			return getRuleContext(AbsolutePathContext.class,0);
		}
		public QueryAbsolutePathContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryParenthesizedContext extends QueryContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public QueryParenthesizedContext(QueryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryChildContext extends QueryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ExprParser.SLASH, 0); }
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public QueryChildContext(QueryContext ctx) { copyFrom(ctx); }
	}

	public final QueryContext query() throws RecognitionException {
		return query(0);
	}

	private QueryContext query(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryContext _localctx = new QueryContext(_ctx, _parentState);
		QueryContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_query, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(27);
				var();
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(STRING);
				}
				break;
			case DOCUMENT:
				{
				_localctx = new QueryAbsolutePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				absolutePath();
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new QueryParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(LEFT_PAREN);
				setState(31);
				query(0);
				setState(32);
				match(RIGHT_PAREN);
				}
				break;
			case LEFT_ANGLE_BRACKET:
				{
				_localctx = new QueryElementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				openingTag();
				setState(35);
				match(LEFT_CURLY_BRACKET);
				setState(36);
				query(0);
				setState(37);
				match(RIGHT_CURLY_BRACKET);
				setState(38);
				closingTag();
				}
				break;
			case FOR:
				{
				_localctx = new QueryFlworContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				forClause();
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LET) {
					{
					setState(41);
					letClause();
					}
				}

				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(44);
					whereClause();
					}
				}

				setState(47);
				returnClause();
				}
				break;
			case LET:
				{
				_localctx = new QueryLetClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				letClause();
				setState(50);
				query(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new QueryConcatenationContext(new QueryContext(_parentctx, _parentState));
						((QueryConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(54);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(55);
						match(COMMA);
						setState(56);
						((QueryConcatenationContext)_localctx).right = query(7);
						}
						break;
					case 2:
						{
						_localctx = new QueryChildContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(57);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(58);
						match(SLASH);
						setState(59);
						relativePath(0);
						}
						break;
					case 3:
						{
						_localctx = new QueryDescendantContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(60);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(61);
						match(DOUBLE_SLASH);
						setState(62);
						relativePath(0);
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class QueryConditionContext extends ParserRuleContext {
		public QueryConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryCondition; }
	 
		public QueryConditionContext() { }
		public void copyFrom(QueryConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionAndContext extends QueryConditionContext {
		public QueryConditionContext left;
		public QueryConditionContext right;
		public TerminalNode LOGICAL_AND() { return getToken(ExprParser.LOGICAL_AND, 0); }
		public List<QueryConditionContext> queryCondition() {
			return getRuleContexts(QueryConditionContext.class);
		}
		public QueryConditionContext queryCondition(int i) {
			return getRuleContext(QueryConditionContext.class,i);
		}
		public QueryConditionAndContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionOrContext extends QueryConditionContext {
		public QueryConditionContext left;
		public QueryConditionContext right;
		public TerminalNode LOGICAL_OR() { return getToken(ExprParser.LOGICAL_OR, 0); }
		public List<QueryConditionContext> queryCondition() {
			return getRuleContexts(QueryConditionContext.class);
		}
		public QueryConditionContext queryCondition(int i) {
			return getRuleContext(QueryConditionContext.class,i);
		}
		public QueryConditionOrContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionIdentityEqualContext extends QueryConditionContext {
		public QueryContext left;
		public QueryContext right;
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public TerminalNode IDENTITY_EQUALITY_OPERATOR() { return getToken(ExprParser.IDENTITY_EQUALITY_OPERATOR, 0); }
		public TerminalNode IDENTITY_EQUALITY_KEYWORD() { return getToken(ExprParser.IDENTITY_EQUALITY_KEYWORD, 0); }
		public QueryConditionIdentityEqualContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionNotContext extends QueryConditionContext {
		public TerminalNode LOGICAL_NOT() { return getToken(ExprParser.LOGICAL_NOT, 0); }
		public QueryConditionContext queryCondition() {
			return getRuleContext(QueryConditionContext.class,0);
		}
		public QueryConditionNotContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionExistentialQuantifierContext extends QueryConditionContext {
		public TerminalNode SOME() { return getToken(ExprParser.SOME, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(ExprParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(ExprParser.IN, i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public TerminalNode SATISFIES() { return getToken(ExprParser.SATISFIES, 0); }
		public QueryConditionContext queryCondition() {
			return getRuleContext(QueryConditionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public QueryConditionExistentialQuantifierContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionEmptyContext extends QueryConditionContext {
		public TerminalNode EMPTY() { return getToken(ExprParser.EMPTY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public QueryConditionEmptyContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionValueEqualContext extends QueryConditionContext {
		public QueryContext left;
		public QueryContext right;
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public TerminalNode VALUE_EQUALITY_OPERATOR() { return getToken(ExprParser.VALUE_EQUALITY_OPERATOR, 0); }
		public TerminalNode VALUE_EQUALITY_KEYWORD() { return getToken(ExprParser.VALUE_EQUALITY_KEYWORD, 0); }
		public QueryConditionValueEqualContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryConditionParenthesizedContext extends QueryConditionContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public QueryConditionContext queryCondition() {
			return getRuleContext(QueryConditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public QueryConditionParenthesizedContext(QueryConditionContext ctx) { copyFrom(ctx); }
	}

	public final QueryConditionContext queryCondition() throws RecognitionException {
		return queryCondition(0);
	}

	private QueryConditionContext queryCondition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryConditionContext _localctx = new QueryConditionContext(_ctx, _parentState);
		QueryConditionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_queryCondition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new QueryConditionValueEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(69);
				((QueryConditionValueEqualContext)_localctx).left = query(0);
				setState(70);
				_la = _input.LA(1);
				if ( !(_la==VALUE_EQUALITY_KEYWORD || _la==VALUE_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(71);
				((QueryConditionValueEqualContext)_localctx).right = query(0);
				}
				break;
			case 2:
				{
				_localctx = new QueryConditionIdentityEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				((QueryConditionIdentityEqualContext)_localctx).left = query(0);
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==IDENTITY_EQUALITY_KEYWORD || _la==IDENTITY_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				((QueryConditionIdentityEqualContext)_localctx).right = query(0);
				}
				break;
			case 3:
				{
				_localctx = new QueryConditionEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(EMPTY);
				setState(78);
				match(LEFT_PAREN);
				setState(79);
				query(0);
				setState(80);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				{
				_localctx = new QueryConditionExistentialQuantifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(SOME);
				setState(83);
				var();
				setState(84);
				match(IN);
				setState(85);
				query(0);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(86);
					match(COMMA);
					setState(87);
					var();
					setState(88);
					match(IN);
					setState(89);
					query(0);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(SATISFIES);
				setState(97);
				queryCondition(5);
				}
				break;
			case 5:
				{
				_localctx = new QueryConditionParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(LEFT_PAREN);
				setState(100);
				queryCondition(0);
				setState(101);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				{
				_localctx = new QueryConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(LOGICAL_NOT);
				setState(104);
				queryCondition(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new QueryConditionAndContext(new QueryConditionContext(_parentctx, _parentState));
						((QueryConditionAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryCondition);
						setState(107);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(108);
						match(LOGICAL_AND);
						setState(109);
						((QueryConditionAndContext)_localctx).right = queryCondition(4);
						}
						break;
					case 2:
						{
						_localctx = new QueryConditionOrContext(new QueryConditionContext(_parentctx, _parentState));
						((QueryConditionOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryCondition);
						setState(110);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(111);
						match(LOGICAL_OR);
						setState(112);
						((QueryConditionOrContext)_localctx).right = queryCondition(3);
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public DocumentNameContext documentName() {
			return getRuleContext(DocumentNameContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_absolutePath);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AbsolutePathChildContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				documentName();
				setState(119);
				match(SLASH);
				setState(120);
				relativePath(0);
				}
				break;
			case 2:
				_localctx = new AbsolutePathDescendantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				documentName();
				setState(123);
				match(DOUBLE_SLASH);
				setState(124);
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
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
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
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				((TagNameContext)_localctx).tagName = match(NAME);
				}
				break;
			case WILDCARD:
				{
				_localctx = new WildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(WILDCARD);
				}
				break;
			case SINGLE_DOT:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(SINGLE_DOT);
				}
				break;
			case DOUBLE_DOT:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				match(DOUBLE_DOT);
				}
				break;
			case TEXT:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(TEXT);
				}
				break;
			case AT_SYMBOL:
				{
				_localctx = new AttributeNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(AT_SYMBOL);
				setState(135);
				((AttributeNameContext)_localctx).attributeName = match(NAME);
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new RelativePathParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(LEFT_PAREN);
				setState(137);
				relativePath(0);
				setState(138);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathChildContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathChildContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(142);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(143);
						match(SLASH);
						setState(144);
						((RelativePathChildContext)_localctx).right = relativePath(5);
						}
						break;
					case 2:
						{
						_localctx = new RelativePathDescendantContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathDescendantContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(145);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(146);
						match(DOUBLE_SLASH);
						setState(147);
						((RelativePathDescendantContext)_localctx).right = relativePath(4);
						}
						break;
					case 3:
						{
						_localctx = new RelativePathConcatenationContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(148);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(149);
						match(COMMA);
						setState(150);
						((RelativePathConcatenationContext)_localctx).right = relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new RelativePathWithPathFilterContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(151);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(152);
						match(LEFT_SQUARE_BRACKET);
						setState(153);
						pathFilter(0);
						setState(154);
						match(RIGHT_SQUARE_BRACKET);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class PathFilterValueEqualContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public TerminalNode VALUE_EQUALITY_OPERATOR() { return getToken(ExprParser.VALUE_EQUALITY_OPERATOR, 0); }
		public TerminalNode VALUE_EQUALITY_KEYWORD() { return getToken(ExprParser.VALUE_EQUALITY_KEYWORD, 0); }
		public PathFilterValueEqualContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterEqualStringLiteralContext extends PathFilterContext {
		public Token stringLiteral;
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public TerminalNode VALUE_EQUALITY_OPERATOR() { return getToken(ExprParser.VALUE_EQUALITY_OPERATOR, 0); }
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public PathFilterEqualStringLiteralContext(PathFilterContext ctx) { copyFrom(ctx); }
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
	public static class PathFilterRelativePathContext extends PathFilterContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public PathFilterRelativePathContext(PathFilterContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterIdentityEqualContext extends PathFilterContext {
		public RelativePathContext left;
		public RelativePathContext right;
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public TerminalNode IDENTITY_EQUALITY_OPERATOR() { return getToken(ExprParser.IDENTITY_EQUALITY_OPERATOR, 0); }
		public TerminalNode IDENTITY_EQUALITY_KEYWORD() { return getToken(ExprParser.IDENTITY_EQUALITY_KEYWORD, 0); }
		public PathFilterIdentityEqualContext(PathFilterContext ctx) { copyFrom(ctx); }
	}

	public final PathFilterContext pathFilter() throws RecognitionException {
		return pathFilter(0);
	}

	private PathFilterContext pathFilter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathFilterContext _localctx = new PathFilterContext(_ctx, _parentState);
		PathFilterContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_pathFilter, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new PathFilterRelativePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				relativePath(0);
				}
				break;
			case 2:
				{
				_localctx = new PathFilterValueEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				((PathFilterValueEqualContext)_localctx).left = relativePath(0);
				setState(164);
				_la = _input.LA(1);
				if ( !(_la==VALUE_EQUALITY_KEYWORD || _la==VALUE_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(165);
				((PathFilterValueEqualContext)_localctx).right = relativePath(0);
				}
				break;
			case 3:
				{
				_localctx = new PathFilterIdentityEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				((PathFilterIdentityEqualContext)_localctx).left = relativePath(0);
				setState(168);
				_la = _input.LA(1);
				if ( !(_la==IDENTITY_EQUALITY_KEYWORD || _la==IDENTITY_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(169);
				((PathFilterIdentityEqualContext)_localctx).right = relativePath(0);
				}
				break;
			case 4:
				{
				_localctx = new PathFilterEqualStringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				relativePath(0);
				setState(172);
				match(VALUE_EQUALITY_OPERATOR);
				setState(173);
				((PathFilterEqualStringLiteralContext)_localctx).stringLiteral = match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new PathFilterParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(LEFT_PAREN);
				setState(176);
				pathFilter(0);
				setState(177);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				{
				_localctx = new PathFilterNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(LOGICAL_NOT);
				setState(180);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterAndContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						match(LOGICAL_AND);
						setState(185);
						((PathFilterAndContext)_localctx).right = pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterOrContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						match(LOGICAL_OR);
						setState(188);
						((PathFilterOrContext)_localctx).right = pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(193);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OpeningTagContext extends ParserRuleContext {
		public TerminalNode LEFT_ANGLE_BRACKET() { return getToken(ExprParser.LEFT_ANGLE_BRACKET, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public TerminalNode RIGHT_ANGLE_BRACKET() { return getToken(ExprParser.RIGHT_ANGLE_BRACKET, 0); }
		public OpeningTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingTag; }
	}

	public final OpeningTagContext openingTag() throws RecognitionException {
		OpeningTagContext _localctx = new OpeningTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_openingTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(LEFT_ANGLE_BRACKET);
			setState(195);
			match(NAME);
			setState(196);
			match(RIGHT_ANGLE_BRACKET);
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
	public static class ClosingTagContext extends ParserRuleContext {
		public TerminalNode LEFT_ANGLE_BRACKET() { return getToken(ExprParser.LEFT_ANGLE_BRACKET, 0); }
		public TerminalNode SLASH() { return getToken(ExprParser.SLASH, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public TerminalNode RIGHT_ANGLE_BRACKET() { return getToken(ExprParser.RIGHT_ANGLE_BRACKET, 0); }
		public ClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingTag; }
	}

	public final ClosingTagContext closingTag() throws RecognitionException {
		ClosingTagContext _localctx = new ClosingTagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_closingTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(LEFT_ANGLE_BRACKET);
			setState(199);
			match(SLASH);
			setState(200);
			match(NAME);
			setState(201);
			match(RIGHT_ANGLE_BRACKET);
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
	public static class ForClauseContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ExprParser.FOR, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(ExprParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(ExprParser.IN, i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(FOR);
			setState(204);
			var();
			setState(205);
			match(IN);
			setState(206);
			query(0);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(207);
				match(COMMA);
				setState(208);
				var();
				setState(209);
				match(IN);
				setState(210);
				query(0);
				}
				}
				setState(216);
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
	public static class LetClauseContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(ExprParser.LET, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> ASSIGNMENT_OPERATOR() { return getTokens(ExprParser.ASSIGNMENT_OPERATOR); }
		public TerminalNode ASSIGNMENT_OPERATOR(int i) {
			return getToken(ExprParser.ASSIGNMENT_OPERATOR, i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(LET);
			setState(218);
			var();
			setState(219);
			match(ASSIGNMENT_OPERATOR);
			setState(220);
			query(0);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(221);
				match(COMMA);
				setState(222);
				var();
				setState(223);
				match(ASSIGNMENT_OPERATOR);
				setState(224);
				query(0);
				}
				}
				setState(230);
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
	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(ExprParser.WHERE, 0); }
		public QueryConditionContext queryCondition() {
			return getRuleContext(QueryConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(WHERE);
			setState(232);
			queryCondition(0);
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
	public static class ReturnClauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ExprParser.RETURN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(RETURN);
			setState(235);
			query(0);
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
	public static class VarContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(ExprParser.DOLLAR, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(DOLLAR);
			setState(238);
			match(NAME);
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
	public static class DocumentNameContext extends ParserRuleContext {
		public Token filename;
		public TerminalNode DOCUMENT() { return getToken(ExprParser.DOCUMENT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public DocumentNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentName; }
	}

	public final DocumentNameContext documentName() throws RecognitionException {
		DocumentNameContext _localctx = new DocumentNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_documentName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(DOCUMENT);
			setState(241);
			match(LEFT_PAREN);
			setState(242);
			((DocumentNameContext)_localctx).filename = match(STRING);
			setState(243);
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
		case 0:
			return query_sempred((QueryContext)_localctx, predIndex);
		case 1:
			return queryCondition_sempred((QueryConditionContext)_localctx, predIndex);
		case 3:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 4:
			return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean query_sempred(QueryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean queryCondition_sempred(QueryConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00f6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"+\b\u0000\u0001\u0000\u0003\u0000.\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\\\b"+
		"\u0001\n\u0001\f\u0001_\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001j\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001r\b\u0001\n\u0001\f\u0001u\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u007f\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u008d\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u009d\b\u0003\n\u0003\f\u0003\u00a0\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u00b6\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00be\b\u0004"+
		"\n\u0004\f\u0004\u00c1\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00d5\b\u0007\n\u0007\f\u0007"+
		"\u00d8\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u00e3\b\b\n\b\f\b\u00e6\t\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0004\u0000\u0002\u0006"+
		"\b\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u0000\u0002\u0001\u0000\u0003\u0004\u0001\u0000\u0005\u0006\u010f\u0000"+
		"4\u0001\u0000\u0000\u0000\u0002i\u0001\u0000\u0000\u0000\u0004~\u0001"+
		"\u0000\u0000\u0000\u0006\u008c\u0001\u0000\u0000\u0000\b\u00b5\u0001\u0000"+
		"\u0000\u0000\n\u00c2\u0001\u0000\u0000\u0000\f\u00c6\u0001\u0000\u0000"+
		"\u0000\u000e\u00cb\u0001\u0000\u0000\u0000\u0010\u00d9\u0001\u0000\u0000"+
		"\u0000\u0012\u00e7\u0001\u0000\u0000\u0000\u0014\u00ea\u0001\u0000\u0000"+
		"\u0000\u0016\u00ed\u0001\u0000\u0000\u0000\u0018\u00f0\u0001\u0000\u0000"+
		"\u0000\u001a\u001b\u0006\u0000\uffff\uffff\u0000\u001b5\u0003\u0016\u000b"+
		"\u0000\u001c5\u0005$\u0000\u0000\u001d5\u0003\u0004\u0002\u0000\u001e"+
		"\u001f\u0005\u0013\u0000\u0000\u001f \u0003\u0000\u0000\u0000 !\u0005"+
		"\u0014\u0000\u0000!5\u0001\u0000\u0000\u0000\"#\u0003\n\u0005\u0000#$"+
		"\u0005\u0019\u0000\u0000$%\u0003\u0000\u0000\u0000%&\u0005\u001a\u0000"+
		"\u0000&\'\u0003\f\u0006\u0000\'5\u0001\u0000\u0000\u0000(*\u0003\u000e"+
		"\u0007\u0000)+\u0003\u0010\b\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+-\u0001\u0000\u0000\u0000,.\u0003\u0012\t\u0000-,\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0003"+
		"\u0014\n\u000005\u0001\u0000\u0000\u000012\u0003\u0010\b\u000023\u0003"+
		"\u0000\u0000\u000135\u0001\u0000\u0000\u00004\u001a\u0001\u0000\u0000"+
		"\u00004\u001c\u0001\u0000\u0000\u00004\u001d\u0001\u0000\u0000\u00004"+
		"\u001e\u0001\u0000\u0000\u00004\"\u0001\u0000\u0000\u00004(\u0001\u0000"+
		"\u0000\u000041\u0001\u0000\u0000\u00005A\u0001\u0000\u0000\u000067\n\u0006"+
		"\u0000\u000078\u0005\u001b\u0000\u00008@\u0003\u0000\u0000\u00079:\n\u0005"+
		"\u0000\u0000:;\u0005\u0001\u0000\u0000;@\u0003\u0006\u0003\u0000<=\n\u0004"+
		"\u0000\u0000=>\u0005\u0002\u0000\u0000>@\u0003\u0006\u0003\u0000?6\u0001"+
		"\u0000\u0000\u0000?9\u0001\u0000\u0000\u0000?<\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000B\u0001\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0006"+
		"\u0001\uffff\uffff\u0000EF\u0003\u0000\u0000\u0000FG\u0007\u0000\u0000"+
		"\u0000GH\u0003\u0000\u0000\u0000Hj\u0001\u0000\u0000\u0000IJ\u0003\u0000"+
		"\u0000\u0000JK\u0007\u0001\u0000\u0000KL\u0003\u0000\u0000\u0000Lj\u0001"+
		"\u0000\u0000\u0000MN\u0005\b\u0000\u0000NO\u0005\u0013\u0000\u0000OP\u0003"+
		"\u0000\u0000\u0000PQ\u0005\u0014\u0000\u0000Qj\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0011\u0000\u0000ST\u0003\u0016\u000b\u0000TU\u0005\n\u0000\u0000"+
		"U]\u0003\u0000\u0000\u0000VW\u0005\u001b\u0000\u0000WX\u0003\u0016\u000b"+
		"\u0000XY\u0005\n\u0000\u0000YZ\u0003\u0000\u0000\u0000Z\\\u0001\u0000"+
		"\u0000\u0000[V\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000`a\u0005\u0010\u0000\u0000ab\u0003\u0002\u0001"+
		"\u0005bj\u0001\u0000\u0000\u0000cd\u0005\u0013\u0000\u0000de\u0003\u0002"+
		"\u0001\u0000ef\u0005\u0014\u0000\u0000fj\u0001\u0000\u0000\u0000gh\u0005"+
		"\r\u0000\u0000hj\u0003\u0002\u0001\u0001iD\u0001\u0000\u0000\u0000iI\u0001"+
		"\u0000\u0000\u0000iM\u0001\u0000\u0000\u0000iR\u0001\u0000\u0000\u0000"+
		"ic\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000js\u0001\u0000\u0000"+
		"\u0000kl\n\u0003\u0000\u0000lm\u0005\f\u0000\u0000mr\u0003\u0002\u0001"+
		"\u0004no\n\u0002\u0000\u0000op\u0005\u000e\u0000\u0000pr\u0003\u0002\u0001"+
		"\u0003qk\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0003"+
		"\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0003\u0018\f\u0000"+
		"wx\u0005\u0001\u0000\u0000xy\u0003\u0006\u0003\u0000y\u007f\u0001\u0000"+
		"\u0000\u0000z{\u0003\u0018\f\u0000{|\u0005\u0002\u0000\u0000|}\u0003\u0006"+
		"\u0003\u0000}\u007f\u0001\u0000\u0000\u0000~v\u0001\u0000\u0000\u0000"+
		"~z\u0001\u0000\u0000\u0000\u007f\u0005\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0006\u0003\uffff\uffff\u0000\u0081\u008d\u0005#\u0000\u0000\u0082\u008d"+
		"\u0005\u001d\u0000\u0000\u0083\u008d\u0005\u001e\u0000\u0000\u0084\u008d"+
		"\u0005\u001f\u0000\u0000\u0085\u008d\u0005 \u0000\u0000\u0086\u0087\u0005"+
		"!\u0000\u0000\u0087\u008d\u0005#\u0000\u0000\u0088\u0089\u0005\u0013\u0000"+
		"\u0000\u0089\u008a\u0003\u0006\u0003\u0000\u008a\u008b\u0005\u0014\u0000"+
		"\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u0080\u0001\u0000\u0000"+
		"\u0000\u008c\u0082\u0001\u0000\u0000\u0000\u008c\u0083\u0001\u0000\u0000"+
		"\u0000\u008c\u0084\u0001\u0000\u0000\u0000\u008c\u0085\u0001\u0000\u0000"+
		"\u0000\u008c\u0086\u0001\u0000\u0000\u0000\u008c\u0088\u0001\u0000\u0000"+
		"\u0000\u008d\u009e\u0001\u0000\u0000\u0000\u008e\u008f\n\u0004\u0000\u0000"+
		"\u008f\u0090\u0005\u0001\u0000\u0000\u0090\u009d\u0003\u0006\u0003\u0005"+
		"\u0091\u0092\n\u0003\u0000\u0000\u0092\u0093\u0005\u0002\u0000\u0000\u0093"+
		"\u009d\u0003\u0006\u0003\u0004\u0094\u0095\n\u0001\u0000\u0000\u0095\u0096"+
		"\u0005\u001b\u0000\u0000\u0096\u009d\u0003\u0006\u0003\u0002\u0097\u0098"+
		"\n\u0002\u0000\u0000\u0098\u0099\u0005\u0015\u0000\u0000\u0099\u009a\u0003"+
		"\b\u0004\u0000\u009a\u009b\u0005\u0016\u0000\u0000\u009b\u009d\u0001\u0000"+
		"\u0000\u0000\u009c\u008e\u0001\u0000\u0000\u0000\u009c\u0091\u0001\u0000"+
		"\u0000\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009c\u0097\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u0007\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u0004"+
		"\uffff\uffff\u0000\u00a2\u00b6\u0003\u0006\u0003\u0000\u00a3\u00a4\u0003"+
		"\u0006\u0003\u0000\u00a4\u00a5\u0007\u0000\u0000\u0000\u00a5\u00a6\u0003"+
		"\u0006\u0003\u0000\u00a6\u00b6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0003"+
		"\u0006\u0003\u0000\u00a8\u00a9\u0007\u0001\u0000\u0000\u00a9\u00aa\u0003"+
		"\u0006\u0003\u0000\u00aa\u00b6\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003"+
		"\u0006\u0003\u0000\u00ac\u00ad\u0005\u0004\u0000\u0000\u00ad\u00ae\u0005"+
		"$\u0000\u0000\u00ae\u00b6\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0013"+
		"\u0000\u0000\u00b0\u00b1\u0003\b\u0004\u0000\u00b1\u00b2\u0005\u0014\u0000"+
		"\u0000\u00b2\u00b6\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\r\u0000\u0000"+
		"\u00b4\u00b6\u0003\b\u0004\u0001\u00b5\u00a1\u0001\u0000\u0000\u0000\u00b5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00b5\u00a7\u0001\u0000\u0000\u0000\u00b5"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b5\u00af\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u00bf\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\n\u0003\u0000\u0000\u00b8\u00b9\u0005\f\u0000\u0000\u00b9\u00be"+
		"\u0003\b\u0004\u0004\u00ba\u00bb\n\u0002\u0000\u0000\u00bb\u00bc\u0005"+
		"\u000e\u0000\u0000\u00bc\u00be\u0003\b\u0004\u0003\u00bd\u00b7\u0001\u0000"+
		"\u0000\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\t\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005\u0017\u0000\u0000\u00c3\u00c4\u0005#\u0000\u0000"+
		"\u00c4\u00c5\u0005\u0018\u0000\u0000\u00c5\u000b\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\u0017\u0000\u0000\u00c7\u00c8\u0005\u0001\u0000\u0000"+
		"\u00c8\u00c9\u0005#\u0000\u0000\u00c9\u00ca\u0005\u0018\u0000\u0000\u00ca"+
		"\r\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\t\u0000\u0000\u00cc\u00cd"+
		"\u0003\u0016\u000b\u0000\u00cd\u00ce\u0005\n\u0000\u0000\u00ce\u00d6\u0003"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005\u001b\u0000\u0000\u00d0\u00d1\u0003"+
		"\u0016\u000b\u0000\u00d1\u00d2\u0005\n\u0000\u0000\u00d2\u00d3\u0003\u0000"+
		"\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u000f\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u000b"+
		"\u0000\u0000\u00da\u00db\u0003\u0016\u000b\u0000\u00db\u00dc\u0005\u0007"+
		"\u0000\u0000\u00dc\u00e4\u0003\u0000\u0000\u0000\u00dd\u00de\u0005\u001b"+
		"\u0000\u0000\u00de\u00df\u0003\u0016\u000b\u0000\u00df\u00e0\u0005\u0007"+
		"\u0000\u0000\u00e0\u00e1\u0003\u0000\u0000\u0000\u00e1\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e2\u00dd\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u0011\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005\u0012\u0000\u0000\u00e8\u00e9\u0003\u0002"+
		"\u0001\u0000\u00e9\u0013\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u000f"+
		"\u0000\u0000\u00eb\u00ec\u0003\u0000\u0000\u0000\u00ec\u0015\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0005\"\u0000\u0000\u00ee\u00ef\u0005#\u0000"+
		"\u0000\u00ef\u0017\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u001c\u0000"+
		"\u0000\u00f1\u00f2\u0005\u0013\u0000\u0000\u00f2\u00f3\u0005$\u0000\u0000"+
		"\u00f3\u00f4\u0005\u0014\u0000\u0000\u00f4\u0019\u0001\u0000\u0000\u0000"+
		"\u0012*-4?A]iqs~\u008c\u009c\u009e\u00b5\u00bd\u00bf\u00d6\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}