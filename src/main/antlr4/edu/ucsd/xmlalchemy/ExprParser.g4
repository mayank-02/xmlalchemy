parser grammar ExprParser;
options {
    tokenVocab = ExprLexer;
}

query
    : var                                                                   # variable
    | STRING                                                                # stringLiteral
    | absolutePath                                                          # queryAbsolutePath
    | LEFT_PAREN query RIGHT_PAREN                                          # queryParenthesized
    | left = query COMMA right = query                                      # queryConcatenation
    | query SLASH relativePath                                              # queryChild
    | query DOUBLE_SLASH relativePath                                       # queryDescendant
    | openingTag LEFT_CURLY_BRACKET query RIGHT_CURLY_BRACKET closingTag    # queryElement
    | forClause letClause? whereClause? returnClause                        # queryFlwor
    | letClause query                                                       # queryLetClause
    ;

queryCondition
    : left = query (VALUE_EQUALITY_OPERATOR | VALUE_EQUALITY_KEYWORD) right = query           # queryConditionValueEqual
    | left = query (IDENTITY_EQUALITY_OPERATOR | IDENTITY_EQUALITY_KEYWORD)  right = query    # queryConditionIdentityEqual
    | EMPTY LEFT_PAREN query RIGHT_PAREN                                                      # queryConditionEmpty
    | SOME var IN query (COMMA var IN query)* SATISFIES queryCondition                        # queryConditionExistentialQuantifier
    | LEFT_PAREN queryCondition RIGHT_PAREN                                                   # queryConditionParenthesized
    | left = queryCondition LOGICAL_AND right = queryCondition                                # queryConditionAnd
    | left = queryCondition LOGICAL_OR right = queryCondition                                 # queryConditionOr
    | LOGICAL_NOT queryCondition                                                              # queryConditionNot
    ;

absolutePath
    : documentName SLASH relativePath           # absolutePathChild
    | documentName DOUBLE_SLASH relativePath    # absolutePathDescendant
    ;

relativePath
    : tagName = NAME                                                      # tagName
    | WILDCARD                                                            # wildcard
    | SINGLE_DOT                                                          # current
    | DOUBLE_DOT                                                          # parent
    | TEXT                                                                # text
    | AT_SYMBOL attributeName = NAME                                      # attributeName
    | LEFT_PAREN relativePath RIGHT_PAREN                                 # relativePathParenthesized
    | left = relativePath SLASH right = relativePath                      # relativePathChild
    | left = relativePath DOUBLE_SLASH right = relativePath               # relativePathDescendant
    | relativePath LEFT_SQUARE_BRACKET pathFilter RIGHT_SQUARE_BRACKET    # relativePathWithPathFilter
    | left = relativePath COMMA right = relativePath                      # relativePathConcatenation
    ;

pathFilter
    : relativePath                                                                                          # pathFilterRelativePath
    | left = relativePath (VALUE_EQUALITY_OPERATOR | VALUE_EQUALITY_KEYWORD) right = relativePath           # pathFilterValueEqual
    | left = relativePath (IDENTITY_EQUALITY_OPERATOR | IDENTITY_EQUALITY_KEYWORD)  right = relativePath    # pathFilterIdentityEqual
    | relativePath VALUE_EQUALITY_OPERATOR stringLiteral = STRING                                           # pathFilterEqualStringLiteral
    | LEFT_PAREN pathFilter RIGHT_PAREN                                                                     # pathFilterParenthesized
    | left = pathFilter LOGICAL_AND right = pathFilter                                                      # pathFilterAnd
    | left = pathFilter LOGICAL_OR right = pathFilter                                                       # pathFilterOr
    | LOGICAL_NOT pathFilter                                                                                # pathFilterNot
    ;

openingTag
    :LEFT_ANGLE_BRACKET NAME RIGHT_ANGLE_BRACKET
    ;

closingTag
    :LEFT_ANGLE_BRACKET SLASH NAME RIGHT_ANGLE_BRACKET
    ;

forClause
    : FOR var IN query (COMMA var IN query)*
    ;

letClause
    : LET var ASSIGNMENT_OPERATOR query (COMMA var ASSIGNMENT_OPERATOR query)*
    ;

whereClause
    : WHERE queryCondition
    ;

returnClause
    : RETURN query
    ;

var
    : DOLLAR NAME;

documentName
    : DOCUMENT LEFT_PAREN filename = STRING RIGHT_PAREN
    ;