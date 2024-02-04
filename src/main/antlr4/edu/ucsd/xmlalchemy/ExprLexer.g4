lexer grammar ExprLexer;

SLASH: '/';
DOUBLE_SLASH: '//';
VALUE_EQUALITY_KEYWORD: 'eq';
VALUE_EQUALITY_OPERATOR: '=';
IDENTITY_EQUALITY_KEYWORD: 'is';
IDENTITY_EQUALITY_OPERATOR: '==';
LOGICAL_NOT: 'not';
LOGICAL_AND: 'and';
LOGICAL_OR: 'or';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_SQUARE_BRACKET: '[';
RIGHT_SQUARE_BRACKET: ']';
COMMA: ',';
DOCUMENT: [dD][oO][cC];
WILDCARD: '*';
SINGLE_DOT: '.';
DOUBLE_DOT: '..';
TEXT: 'text()';
AT_SYMBOL: '@';
NAME: [a-zA-Z_][a-zA-Z_0-9]*;
STRING : '"' (ASCII_CHAR | ESCAPE_SEQ)* '"' ;
fragment ASCII_CHAR : '\u0020'..'\u0021' | '\u0023'..'\u005B' | '\u005D'..'\u007E' ;
fragment ESCAPE_SEQ : '\\' ( '"' | '\\' ) ;
WHITESPACE: (' ' | '\t' | '\r' | '\n') -> skip;
ANY: . ;
