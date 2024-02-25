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
		RETURN=15, SATISFIES=16, SOME=17, WHERE=18, JOIN=19, OPENING_TUPLE_TAG=20, 
		CLOSING_TUPLE_TAG=21, LEFT_PAREN=22, RIGHT_PAREN=23, LEFT_SQUARE_BRACKET=24, 
		RIGHT_SQUARE_BRACKET=25, LEFT_ANGLE_BRACKET=26, RIGHT_ANGLE_BRACKET=27, 
		LEFT_CURLY_BRACKET=28, RIGHT_CURLY_BRACKET=29, COMMA=30, DOCUMENT=31, 
		WILDCARD=32, SINGLE_DOT=33, DOUBLE_DOT=34, TEXT=35, AT_SYMBOL=36, DOLLAR=37, 
		NAME=38, STRING=39, WHITESPACE=40, ANY=41;
	public static final int
		RULE_query = 0, RULE_queryCondition = 1, RULE_absolutePath = 2, RULE_relativePath = 3, 
		RULE_pathFilter = 4, RULE_openingTag = 5, RULE_closingTag = 6, RULE_forClause = 7, 
		RULE_letClause = 8, RULE_whereClause = 9, RULE_returnClause = 10, RULE_var = 11, 
		RULE_documentName = 12, RULE_joinClause = 13, RULE_joinAttributeList = 14, 
		RULE_joinConditionClause = 15, RULE_joinReturnClause = 16, RULE_tupleElement = 17, 
		RULE_joinFlworClause = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "queryCondition", "absolutePath", "relativePath", "pathFilter", 
			"openingTag", "closingTag", "forClause", "letClause", "whereClause", 
			"returnClause", "var", "documentName", "joinClause", "joinAttributeList", 
			"joinConditionClause", "joinReturnClause", "tupleElement", "joinFlworClause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'eq'", "'='", "'is'", "'=='", "':='", "'empty'", 
			"'for'", "'in'", "'let'", "'and'", "'not'", "'or'", "'return'", "'satisfies'", 
			"'some'", "'where'", "'join'", "'<tuple>'", "'</tuple>'", "'('", "')'", 
			"'['", "']'", "'<'", "'>'", "'{'", "'}'", "','", null, "'*'", "'.'", 
			"'..'", "'text()'", "'@'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SLASH", "DOUBLE_SLASH", "VALUE_EQUALITY_KEYWORD", "VALUE_EQUALITY_OPERATOR", 
			"IDENTITY_EQUALITY_KEYWORD", "IDENTITY_EQUALITY_OPERATOR", "ASSIGNMENT_OPERATOR", 
			"EMPTY", "FOR", "IN", "LET", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", 
			"RETURN", "SATISFIES", "SOME", "WHERE", "JOIN", "OPENING_TUPLE_TAG", 
			"CLOSING_TUPLE_TAG", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_SQUARE_BRACKET", 
			"RIGHT_SQUARE_BRACKET", "LEFT_ANGLE_BRACKET", "RIGHT_ANGLE_BRACKET", 
			"LEFT_CURLY_BRACKET", "RIGHT_CURLY_BRACKET", "COMMA", "DOCUMENT", "WILDCARD", 
			"SINGLE_DOT", "DOUBLE_DOT", "TEXT", "AT_SYMBOL", "DOLLAR", "NAME", "STRING", 
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
	public static class QueryJoinClauseContext extends QueryContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public QueryJoinClauseContext(QueryContext ctx) { copyFrom(ctx); }
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
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(39);
				var();
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(STRING);
				}
				break;
			case DOCUMENT:
				{
				_localctx = new QueryAbsolutePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				absolutePath();
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new QueryParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(LEFT_PAREN);
				setState(43);
				query(0);
				setState(44);
				match(RIGHT_PAREN);
				}
				break;
			case LEFT_ANGLE_BRACKET:
				{
				_localctx = new QueryElementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				openingTag();
				setState(47);
				match(LEFT_CURLY_BRACKET);
				setState(48);
				query(0);
				setState(49);
				match(RIGHT_CURLY_BRACKET);
				setState(50);
				closingTag();
				}
				break;
			case FOR:
				{
				_localctx = new QueryFlworContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				forClause();
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LET) {
					{
					setState(53);
					letClause();
					}
				}

				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(56);
					whereClause();
					}
				}

				setState(59);
				returnClause();
				}
				break;
			case LET:
				{
				_localctx = new QueryLetClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				letClause();
				setState(62);
				query(2);
				}
				break;
			case JOIN:
				{
				_localctx = new QueryJoinClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				joinClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(76);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new QueryConcatenationContext(new QueryContext(_parentctx, _parentState));
						((QueryConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(67);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(68);
						match(COMMA);
						setState(69);
						((QueryConcatenationContext)_localctx).right = query(8);
						}
						break;
					case 2:
						{
						_localctx = new QueryChildContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(70);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(71);
						match(SLASH);
						setState(72);
						relativePath(0);
						}
						break;
					case 3:
						{
						_localctx = new QueryDescendantContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(73);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(74);
						match(DOUBLE_SLASH);
						setState(75);
						relativePath(0);
						}
						break;
					}
					} 
				}
				setState(80);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new QueryConditionValueEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(82);
				((QueryConditionValueEqualContext)_localctx).left = query(0);
				setState(83);
				_la = _input.LA(1);
				if ( !(_la==VALUE_EQUALITY_KEYWORD || _la==VALUE_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(84);
				((QueryConditionValueEqualContext)_localctx).right = query(0);
				}
				break;
			case 2:
				{
				_localctx = new QueryConditionIdentityEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				((QueryConditionIdentityEqualContext)_localctx).left = query(0);
				setState(87);
				_la = _input.LA(1);
				if ( !(_la==IDENTITY_EQUALITY_KEYWORD || _la==IDENTITY_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				((QueryConditionIdentityEqualContext)_localctx).right = query(0);
				}
				break;
			case 3:
				{
				_localctx = new QueryConditionEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(EMPTY);
				setState(91);
				match(LEFT_PAREN);
				setState(92);
				query(0);
				setState(93);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				{
				_localctx = new QueryConditionExistentialQuantifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(SOME);
				setState(96);
				var();
				setState(97);
				match(IN);
				setState(98);
				query(0);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(99);
					match(COMMA);
					setState(100);
					var();
					setState(101);
					match(IN);
					setState(102);
					query(0);
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109);
				match(SATISFIES);
				setState(110);
				queryCondition(5);
				}
				break;
			case 5:
				{
				_localctx = new QueryConditionParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(LEFT_PAREN);
				setState(113);
				queryCondition(0);
				setState(114);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				{
				_localctx = new QueryConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(LOGICAL_NOT);
				setState(117);
				queryCondition(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(126);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new QueryConditionAndContext(new QueryConditionContext(_parentctx, _parentState));
						((QueryConditionAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryCondition);
						setState(120);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(121);
						match(LOGICAL_AND);
						setState(122);
						((QueryConditionAndContext)_localctx).right = queryCondition(4);
						}
						break;
					case 2:
						{
						_localctx = new QueryConditionOrContext(new QueryConditionContext(_parentctx, _parentState));
						((QueryConditionOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryCondition);
						setState(123);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(124);
						match(LOGICAL_OR);
						setState(125);
						((QueryConditionOrContext)_localctx).right = queryCondition(3);
						}
						break;
					}
					} 
				}
				setState(130);
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AbsolutePathChildContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				documentName();
				setState(132);
				match(SLASH);
				setState(133);
				relativePath(0);
				}
				break;
			case 2:
				_localctx = new AbsolutePathDescendantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				documentName();
				setState(136);
				match(DOUBLE_SLASH);
				setState(137);
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
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(142);
				((TagNameContext)_localctx).tagName = match(NAME);
				}
				break;
			case WILDCARD:
				{
				_localctx = new WildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(WILDCARD);
				}
				break;
			case SINGLE_DOT:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(SINGLE_DOT);
				}
				break;
			case DOUBLE_DOT:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(DOUBLE_DOT);
				}
				break;
			case TEXT:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(TEXT);
				}
				break;
			case AT_SYMBOL:
				{
				_localctx = new AttributeNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(AT_SYMBOL);
				setState(148);
				((AttributeNameContext)_localctx).attributeName = match(NAME);
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new RelativePathParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(LEFT_PAREN);
				setState(150);
				relativePath(0);
				setState(151);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathChildContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathChildContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						match(SLASH);
						setState(157);
						((RelativePathChildContext)_localctx).right = relativePath(5);
						}
						break;
					case 2:
						{
						_localctx = new RelativePathDescendantContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathDescendantContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						match(DOUBLE_SLASH);
						setState(160);
						((RelativePathDescendantContext)_localctx).right = relativePath(4);
						}
						break;
					case 3:
						{
						_localctx = new RelativePathConcatenationContext(new RelativePathContext(_parentctx, _parentState));
						((RelativePathConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(161);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(162);
						match(COMMA);
						setState(163);
						((RelativePathConcatenationContext)_localctx).right = relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new RelativePathWithPathFilterContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(LEFT_SQUARE_BRACKET);
						setState(166);
						pathFilter(0);
						setState(167);
						match(RIGHT_SQUARE_BRACKET);
						}
						break;
					}
					} 
				}
				setState(173);
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
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new PathFilterRelativePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(175);
				relativePath(0);
				}
				break;
			case 2:
				{
				_localctx = new PathFilterValueEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				((PathFilterValueEqualContext)_localctx).left = relativePath(0);
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==VALUE_EQUALITY_KEYWORD || _la==VALUE_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				((PathFilterValueEqualContext)_localctx).right = relativePath(0);
				}
				break;
			case 3:
				{
				_localctx = new PathFilterIdentityEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				((PathFilterIdentityEqualContext)_localctx).left = relativePath(0);
				setState(181);
				_la = _input.LA(1);
				if ( !(_la==IDENTITY_EQUALITY_KEYWORD || _la==IDENTITY_EQUALITY_OPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(182);
				((PathFilterIdentityEqualContext)_localctx).right = relativePath(0);
				}
				break;
			case 4:
				{
				_localctx = new PathFilterEqualStringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				relativePath(0);
				setState(185);
				match(VALUE_EQUALITY_OPERATOR);
				setState(186);
				((PathFilterEqualStringLiteralContext)_localctx).stringLiteral = match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new PathFilterParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(LEFT_PAREN);
				setState(189);
				pathFilter(0);
				setState(190);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				{
				_localctx = new PathFilterNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(LOGICAL_NOT);
				setState(193);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterAndContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(196);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(197);
						match(LOGICAL_AND);
						setState(198);
						((PathFilterAndContext)_localctx).right = pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterOrContext(new PathFilterContext(_parentctx, _parentState));
						((PathFilterOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(199);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(200);
						match(LOGICAL_OR);
						setState(201);
						((PathFilterOrContext)_localctx).right = pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(206);
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
			setState(207);
			match(LEFT_ANGLE_BRACKET);
			setState(208);
			match(NAME);
			setState(209);
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
			setState(211);
			match(LEFT_ANGLE_BRACKET);
			setState(212);
			match(SLASH);
			setState(213);
			match(NAME);
			setState(214);
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
			setState(216);
			match(FOR);
			setState(217);
			var();
			setState(218);
			match(IN);
			setState(219);
			query(0);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(220);
				match(COMMA);
				setState(221);
				var();
				setState(222);
				match(IN);
				setState(223);
				query(0);
				}
				}
				setState(229);
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
			setState(230);
			match(LET);
			setState(231);
			var();
			setState(232);
			match(ASSIGNMENT_OPERATOR);
			setState(233);
			query(0);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(234);
				match(COMMA);
				setState(235);
				var();
				setState(236);
				match(ASSIGNMENT_OPERATOR);
				setState(237);
				query(0);
				}
				}
				setState(243);
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
			setState(244);
			match(WHERE);
			setState(245);
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
			setState(247);
			match(RETURN);
			setState(248);
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
			setState(250);
			match(DOLLAR);
			setState(251);
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
			setState(253);
			match(DOCUMENT);
			setState(254);
			match(LEFT_PAREN);
			setState(255);
			((DocumentNameContext)_localctx).filename = match(STRING);
			setState(256);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JoinClauseContext extends ParserRuleContext {
		public JoinFlworClauseContext left;
		public JoinFlworClauseContext right;
		public JoinConditionClauseContext condition;
		public TerminalNode JOIN() { return getToken(ExprParser.JOIN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExprParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExprParser.RIGHT_PAREN, 0); }
		public List<JoinFlworClauseContext> joinFlworClause() {
			return getRuleContexts(JoinFlworClauseContext.class);
		}
		public JoinFlworClauseContext joinFlworClause(int i) {
			return getRuleContext(JoinFlworClauseContext.class,i);
		}
		public JoinConditionClauseContext joinConditionClause() {
			return getRuleContext(JoinConditionClauseContext.class,0);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(JOIN);
			setState(259);
			match(LEFT_PAREN);
			setState(260);
			((JoinClauseContext)_localctx).left = joinFlworClause();
			setState(261);
			match(COMMA);
			setState(262);
			((JoinClauseContext)_localctx).right = joinFlworClause();
			setState(263);
			match(COMMA);
			setState(264);
			((JoinClauseContext)_localctx).condition = joinConditionClause();
			setState(265);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JoinAttributeListContext extends ParserRuleContext {
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(ExprParser.LEFT_SQUARE_BRACKET, 0); }
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(ExprParser.RIGHT_SQUARE_BRACKET, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExprParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExprParser.NAME, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public JoinAttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinAttributeList; }
	}

	public final JoinAttributeListContext joinAttributeList() throws RecognitionException {
		JoinAttributeListContext _localctx = new JoinAttributeListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_joinAttributeList);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(LEFT_SQUARE_BRACKET);
				setState(268);
				match(RIGHT_SQUARE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(LEFT_SQUARE_BRACKET);
				setState(270);
				match(NAME);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(271);
					match(COMMA);
					setState(272);
					match(NAME);
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(RIGHT_SQUARE_BRACKET);
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
	public static class JoinConditionClauseContext extends ParserRuleContext {
		public JoinAttributeListContext left;
		public JoinAttributeListContext right;
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public List<JoinAttributeListContext> joinAttributeList() {
			return getRuleContexts(JoinAttributeListContext.class);
		}
		public JoinAttributeListContext joinAttributeList(int i) {
			return getRuleContext(JoinAttributeListContext.class,i);
		}
		public JoinConditionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinConditionClause; }
	}

	public final JoinConditionClauseContext joinConditionClause() throws RecognitionException {
		JoinConditionClauseContext _localctx = new JoinConditionClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_joinConditionClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((JoinConditionClauseContext)_localctx).left = joinAttributeList();
			setState(282);
			match(COMMA);
			setState(283);
			((JoinConditionClauseContext)_localctx).right = joinAttributeList();
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
	public static class JoinReturnClauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ExprParser.RETURN, 0); }
		public TerminalNode OPENING_TUPLE_TAG() { return getToken(ExprParser.OPENING_TUPLE_TAG, 0); }
		public TerminalNode LEFT_CURLY_BRACKET() { return getToken(ExprParser.LEFT_CURLY_BRACKET, 0); }
		public List<TupleElementContext> tupleElement() {
			return getRuleContexts(TupleElementContext.class);
		}
		public TupleElementContext tupleElement(int i) {
			return getRuleContext(TupleElementContext.class,i);
		}
		public TerminalNode RIGHT_CURLY_BRACKET() { return getToken(ExprParser.RIGHT_CURLY_BRACKET, 0); }
		public TerminalNode CLOSING_TUPLE_TAG() { return getToken(ExprParser.CLOSING_TUPLE_TAG, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public JoinReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinReturnClause; }
	}

	public final JoinReturnClauseContext joinReturnClause() throws RecognitionException {
		JoinReturnClauseContext _localctx = new JoinReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_joinReturnClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(RETURN);
			setState(286);
			match(OPENING_TUPLE_TAG);
			setState(287);
			match(LEFT_CURLY_BRACKET);
			setState(288);
			tupleElement();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(289);
				match(COMMA);
				setState(290);
				tupleElement();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
			match(RIGHT_CURLY_BRACKET);
			setState(297);
			match(CLOSING_TUPLE_TAG);
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
	public static class TupleElementContext extends ParserRuleContext {
		public OpeningTagContext openingTag() {
			return getRuleContext(OpeningTagContext.class,0);
		}
		public TerminalNode LEFT_CURLY_BRACKET() { return getToken(ExprParser.LEFT_CURLY_BRACKET, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode RIGHT_CURLY_BRACKET() { return getToken(ExprParser.RIGHT_CURLY_BRACKET, 0); }
		public ClosingTagContext closingTag() {
			return getRuleContext(ClosingTagContext.class,0);
		}
		public TupleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleElement; }
	}

	public final TupleElementContext tupleElement() throws RecognitionException {
		TupleElementContext _localctx = new TupleElementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tupleElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			openingTag();
			setState(300);
			match(LEFT_CURLY_BRACKET);
			setState(301);
			var();
			setState(302);
			match(RIGHT_CURLY_BRACKET);
			setState(303);
			closingTag();
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
	public static class JoinFlworClauseContext extends ParserRuleContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public JoinReturnClauseContext joinReturnClause() {
			return getRuleContext(JoinReturnClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public JoinFlworClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinFlworClause; }
	}

	public final JoinFlworClauseContext joinFlworClause() throws RecognitionException {
		JoinFlworClauseContext _localctx = new JoinFlworClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_joinFlworClause);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JOIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				joinClause();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(306);
				forClause();
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(307);
					whereClause();
					}
				}

				setState(310);
				joinReturnClause();
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
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
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
		"\u0004\u0001)\u013b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000"+
		"\u0001\u0000\u0003\u0000:\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000B\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000M\b\u0000\n\u0000\f\u0000P\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"i\b\u0001\n\u0001\f\u0001l\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001w\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u007f\b\u0001\n\u0001\f\u0001\u0082"+
		"\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u008c\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009a"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00aa\b\u0003\n\u0003\f\u0003"+
		"\u00ad\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00c3\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00cb\b\u0004\n\u0004\f\u0004\u00ce\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00e2\b\u0007\n"+
		"\u0007\f\u0007\u00e5\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u00f0\b\b\n\b\f\b\u00f3\t\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0112\b\u000e"+
		"\n\u000e\f\u000e\u0115\t\u000e\u0001\u000e\u0003\u000e\u0118\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0124\b\u0010\n"+
		"\u0010\f\u0010\u0127\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0135\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u0139\b\u0012\u0001\u0012\u0000\u0004\u0000\u0002\u0006"+
		"\b\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$\u0000\u0002\u0001\u0000\u0003\u0004\u0001\u0000"+
		"\u0005\u0006\u0154\u0000A\u0001\u0000\u0000\u0000\u0002v\u0001\u0000\u0000"+
		"\u0000\u0004\u008b\u0001\u0000\u0000\u0000\u0006\u0099\u0001\u0000\u0000"+
		"\u0000\b\u00c2\u0001\u0000\u0000\u0000\n\u00cf\u0001\u0000\u0000\u0000"+
		"\f\u00d3\u0001\u0000\u0000\u0000\u000e\u00d8\u0001\u0000\u0000\u0000\u0010"+
		"\u00e6\u0001\u0000\u0000\u0000\u0012\u00f4\u0001\u0000\u0000\u0000\u0014"+
		"\u00f7\u0001\u0000\u0000\u0000\u0016\u00fa\u0001\u0000\u0000\u0000\u0018"+
		"\u00fd\u0001\u0000\u0000\u0000\u001a\u0102\u0001\u0000\u0000\u0000\u001c"+
		"\u0117\u0001\u0000\u0000\u0000\u001e\u0119\u0001\u0000\u0000\u0000 \u011d"+
		"\u0001\u0000\u0000\u0000\"\u012b\u0001\u0000\u0000\u0000$\u0138\u0001"+
		"\u0000\u0000\u0000&\'\u0006\u0000\uffff\uffff\u0000\'B\u0003\u0016\u000b"+
		"\u0000(B\u0005\'\u0000\u0000)B\u0003\u0004\u0002\u0000*+\u0005\u0016\u0000"+
		"\u0000+,\u0003\u0000\u0000\u0000,-\u0005\u0017\u0000\u0000-B\u0001\u0000"+
		"\u0000\u0000./\u0003\n\u0005\u0000/0\u0005\u001c\u0000\u000001\u0003\u0000"+
		"\u0000\u000012\u0005\u001d\u0000\u000023\u0003\f\u0006\u00003B\u0001\u0000"+
		"\u0000\u000046\u0003\u000e\u0007\u000057\u0003\u0010\b\u000065\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u00008:\u0003"+
		"\u0012\t\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0003\u0014\n\u0000<B\u0001\u0000\u0000\u0000=>\u0003"+
		"\u0010\b\u0000>?\u0003\u0000\u0000\u0002?B\u0001\u0000\u0000\u0000@B\u0003"+
		"\u001a\r\u0000A&\u0001\u0000\u0000\u0000A(\u0001\u0000\u0000\u0000A)\u0001"+
		"\u0000\u0000\u0000A*\u0001\u0000\u0000\u0000A.\u0001\u0000\u0000\u0000"+
		"A4\u0001\u0000\u0000\u0000A=\u0001\u0000\u0000\u0000A@\u0001\u0000\u0000"+
		"\u0000BN\u0001\u0000\u0000\u0000CD\n\u0007\u0000\u0000DE\u0005\u001e\u0000"+
		"\u0000EM\u0003\u0000\u0000\bFG\n\u0006\u0000\u0000GH\u0005\u0001\u0000"+
		"\u0000HM\u0003\u0006\u0003\u0000IJ\n\u0005\u0000\u0000JK\u0005\u0002\u0000"+
		"\u0000KM\u0003\u0006\u0003\u0000LC\u0001\u0000\u0000\u0000LF\u0001\u0000"+
		"\u0000\u0000LI\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0001\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000QR\u0006\u0001\uffff\uffff\u0000RS\u0003"+
		"\u0000\u0000\u0000ST\u0007\u0000\u0000\u0000TU\u0003\u0000\u0000\u0000"+
		"Uw\u0001\u0000\u0000\u0000VW\u0003\u0000\u0000\u0000WX\u0007\u0001\u0000"+
		"\u0000XY\u0003\u0000\u0000\u0000Yw\u0001\u0000\u0000\u0000Z[\u0005\b\u0000"+
		"\u0000[\\\u0005\u0016\u0000\u0000\\]\u0003\u0000\u0000\u0000]^\u0005\u0017"+
		"\u0000\u0000^w\u0001\u0000\u0000\u0000_`\u0005\u0011\u0000\u0000`a\u0003"+
		"\u0016\u000b\u0000ab\u0005\n\u0000\u0000bj\u0003\u0000\u0000\u0000cd\u0005"+
		"\u001e\u0000\u0000de\u0003\u0016\u000b\u0000ef\u0005\n\u0000\u0000fg\u0003"+
		"\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hc\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u0010"+
		"\u0000\u0000no\u0003\u0002\u0001\u0005ow\u0001\u0000\u0000\u0000pq\u0005"+
		"\u0016\u0000\u0000qr\u0003\u0002\u0001\u0000rs\u0005\u0017\u0000\u0000"+
		"sw\u0001\u0000\u0000\u0000tu\u0005\r\u0000\u0000uw\u0003\u0002\u0001\u0001"+
		"vQ\u0001\u0000\u0000\u0000vV\u0001\u0000\u0000\u0000vZ\u0001\u0000\u0000"+
		"\u0000v_\u0001\u0000\u0000\u0000vp\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000w\u0080\u0001\u0000\u0000\u0000xy\n\u0003\u0000\u0000yz\u0005"+
		"\f\u0000\u0000z\u007f\u0003\u0002\u0001\u0004{|\n\u0002\u0000\u0000|}"+
		"\u0005\u000e\u0000\u0000}\u007f\u0003\u0002\u0001\u0003~x\u0001\u0000"+
		"\u0000\u0000~{\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0003\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0003\u0018\f\u0000\u0084\u0085\u0005\u0001\u0000\u0000\u0085\u0086"+
		"\u0003\u0006\u0003\u0000\u0086\u008c\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0003\u0018\f\u0000\u0088\u0089\u0005\u0002\u0000\u0000\u0089\u008a\u0003"+
		"\u0006\u0003\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0083\u0001"+
		"\u0000\u0000\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008c\u0005\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0006\u0003\uffff\uffff\u0000\u008e\u009a"+
		"\u0005&\u0000\u0000\u008f\u009a\u0005 \u0000\u0000\u0090\u009a\u0005!"+
		"\u0000\u0000\u0091\u009a\u0005\"\u0000\u0000\u0092\u009a\u0005#\u0000"+
		"\u0000\u0093\u0094\u0005$\u0000\u0000\u0094\u009a\u0005&\u0000\u0000\u0095"+
		"\u0096\u0005\u0016\u0000\u0000\u0096\u0097\u0003\u0006\u0003\u0000\u0097"+
		"\u0098\u0005\u0017\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099"+
		"\u008d\u0001\u0000\u0000\u0000\u0099\u008f\u0001\u0000\u0000\u0000\u0099"+
		"\u0090\u0001\u0000\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099"+
		"\u0092\u0001\u0000\u0000\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099"+
		"\u0095\u0001\u0000\u0000\u0000\u009a\u00ab\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\n\u0004\u0000\u0000\u009c\u009d\u0005\u0001\u0000\u0000\u009d\u00aa"+
		"\u0003\u0006\u0003\u0005\u009e\u009f\n\u0003\u0000\u0000\u009f\u00a0\u0005"+
		"\u0002\u0000\u0000\u00a0\u00aa\u0003\u0006\u0003\u0004\u00a1\u00a2\n\u0001"+
		"\u0000\u0000\u00a2\u00a3\u0005\u001e\u0000\u0000\u00a3\u00aa\u0003\u0006"+
		"\u0003\u0002\u00a4\u00a5\n\u0002\u0000\u0000\u00a5\u00a6\u0005\u0018\u0000"+
		"\u0000\u00a6\u00a7\u0003\b\u0004\u0000\u00a7\u00a8\u0005\u0019\u0000\u0000"+
		"\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u009b\u0001\u0000\u0000\u0000"+
		"\u00a9\u009e\u0001\u0000\u0000\u0000\u00a9\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a4\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u0007\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0006\u0004\uffff\uffff\u0000\u00af\u00c3\u0003\u0006\u0003"+
		"\u0000\u00b0\u00b1\u0003\u0006\u0003\u0000\u00b1\u00b2\u0007\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0003\u0006\u0003\u0000\u00b3\u00c3\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0003\u0006\u0003\u0000\u00b5\u00b6\u0007\u0001\u0000"+
		"\u0000\u00b6\u00b7\u0003\u0006\u0003\u0000\u00b7\u00c3\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0003\u0006\u0003\u0000\u00b9\u00ba\u0005\u0004\u0000"+
		"\u0000\u00ba\u00bb\u0005\'\u0000\u0000\u00bb\u00c3\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0005\u0016\u0000\u0000\u00bd\u00be\u0003\b\u0004\u0000\u00be"+
		"\u00bf\u0005\u0017\u0000\u0000\u00bf\u00c3\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0005\r\u0000\u0000\u00c1\u00c3\u0003\b\u0004\u0001\u00c2\u00ae"+
		"\u0001\u0000\u0000\u0000\u00c2\u00b0\u0001\u0000\u0000\u0000\u00c2\u00b4"+
		"\u0001\u0000\u0000\u0000\u00c2\u00b8\u0001\u0000\u0000\u0000\u00c2\u00bc"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00cc"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\n\u0003\u0000\u0000\u00c5\u00c6\u0005"+
		"\f\u0000\u0000\u00c6\u00cb\u0003\b\u0004\u0004\u00c7\u00c8\n\u0002\u0000"+
		"\u0000\u00c8\u00c9\u0005\u000e\u0000\u0000\u00c9\u00cb\u0003\b\u0004\u0003"+
		"\u00ca\u00c4\u0001\u0000\u0000\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000"+
		"\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\t\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u001a\u0000\u0000\u00d0"+
		"\u00d1\u0005&\u0000\u0000\u00d1\u00d2\u0005\u001b\u0000\u0000\u00d2\u000b"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u001a\u0000\u0000\u00d4\u00d5"+
		"\u0005\u0001\u0000\u0000\u00d5\u00d6\u0005&\u0000\u0000\u00d6\u00d7\u0005"+
		"\u001b\u0000\u0000\u00d7\r\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\t"+
		"\u0000\u0000\u00d9\u00da\u0003\u0016\u000b\u0000\u00da\u00db\u0005\n\u0000"+
		"\u0000\u00db\u00e3\u0003\u0000\u0000\u0000\u00dc\u00dd\u0005\u001e\u0000"+
		"\u0000\u00dd\u00de\u0003\u0016\u000b\u0000\u00de\u00df\u0005\n\u0000\u0000"+
		"\u00df\u00e0\u0003\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e1\u00dc\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u000f\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005\u000b\u0000\u0000\u00e7\u00e8\u0003\u0016\u000b\u0000"+
		"\u00e8\u00e9\u0005\u0007\u0000\u0000\u00e9\u00f1\u0003\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0005\u001e\u0000\u0000\u00eb\u00ec\u0003\u0016\u000b\u0000"+
		"\u00ec\u00ed\u0005\u0007\u0000\u0000\u00ed\u00ee\u0003\u0000\u0000\u0000"+
		"\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ea\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u0011\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u0012\u0000\u0000"+
		"\u00f5\u00f6\u0003\u0002\u0001\u0000\u00f6\u0013\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005\u000f\u0000\u0000\u00f8\u00f9\u0003\u0000\u0000\u0000"+
		"\u00f9\u0015\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005%\u0000\u0000\u00fb"+
		"\u00fc\u0005&\u0000\u0000\u00fc\u0017\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0005\u001f\u0000\u0000\u00fe\u00ff\u0005\u0016\u0000\u0000\u00ff\u0100"+
		"\u0005\'\u0000\u0000\u0100\u0101\u0005\u0017\u0000\u0000\u0101\u0019\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0005\u0013\u0000\u0000\u0103\u0104\u0005"+
		"\u0016\u0000\u0000\u0104\u0105\u0003$\u0012\u0000\u0105\u0106\u0005\u001e"+
		"\u0000\u0000\u0106\u0107\u0003$\u0012\u0000\u0107\u0108\u0005\u001e\u0000"+
		"\u0000\u0108\u0109\u0003\u001e\u000f\u0000\u0109\u010a\u0005\u0017\u0000"+
		"\u0000\u010a\u001b\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u0018\u0000"+
		"\u0000\u010c\u0118\u0005\u0019\u0000\u0000\u010d\u010e\u0005\u0018\u0000"+
		"\u0000\u010e\u0113\u0005&\u0000\u0000\u010f\u0110\u0005\u001e\u0000\u0000"+
		"\u0110\u0112\u0005&\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112"+
		"\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113"+
		"\u0114\u0001\u0000\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115"+
		"\u0113\u0001\u0000\u0000\u0000\u0116\u0118\u0005\u0019\u0000\u0000\u0117"+
		"\u010b\u0001\u0000\u0000\u0000\u0117\u010d\u0001\u0000\u0000\u0000\u0118"+
		"\u001d\u0001\u0000\u0000\u0000\u0119\u011a\u0003\u001c\u000e\u0000\u011a"+
		"\u011b\u0005\u001e\u0000\u0000\u011b\u011c\u0003\u001c\u000e\u0000\u011c"+
		"\u001f\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u000f\u0000\u0000\u011e"+
		"\u011f\u0005\u0014\u0000\u0000\u011f\u0120\u0005\u001c\u0000\u0000\u0120"+
		"\u0125\u0003\"\u0011\u0000\u0121\u0122\u0005\u001e\u0000\u0000\u0122\u0124"+
		"\u0003\"\u0011\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0127\u0001"+
		"\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001"+
		"\u0000\u0000\u0000\u0126\u0128\u0001\u0000\u0000\u0000\u0127\u0125\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0005\u001d\u0000\u0000\u0129\u012a\u0005"+
		"\u0015\u0000\u0000\u012a!\u0001\u0000\u0000\u0000\u012b\u012c\u0003\n"+
		"\u0005\u0000\u012c\u012d\u0005\u001c\u0000\u0000\u012d\u012e\u0003\u0016"+
		"\u000b\u0000\u012e\u012f\u0005\u001d\u0000\u0000\u012f\u0130\u0003\f\u0006"+
		"\u0000\u0130#\u0001\u0000\u0000\u0000\u0131\u0139\u0003\u001a\r\u0000"+
		"\u0132\u0134\u0003\u000e\u0007\u0000\u0133\u0135\u0003\u0012\t\u0000\u0134"+
		"\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0003 \u0010\u0000\u0137\u0139"+
		"\u0001\u0000\u0000\u0000\u0138\u0131\u0001\u0000\u0000\u0000\u0138\u0132"+
		"\u0001\u0000\u0000\u0000\u0139%\u0001\u0000\u0000\u0000\u001769ALNjv~"+
		"\u0080\u008b\u0099\u00a9\u00ab\u00c2\u00ca\u00cc\u00e3\u00f1\u0113\u0117"+
		"\u0125\u0134\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}