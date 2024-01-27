parser grammar ExprParser;
options {
	tokenVocab = ExprLexer;
}

absolutePath
    : documentName SLASH relativePath			                            # absolutePathChild
	| DOCUMENT LEFT_PAREN FILENAME RIGHT_PAREN DOUBLE_SLASH relativePath	# absolutePathDescendant
    ;

relativePath
    : tagName = STRING													# tagName
	| WILDCARD															# wildcard
	| SINGLE_DOT														# current
	| DOUBLE_DOT														# parent
	| TEXT																# text
	| AT_SYMBOL attributeName = STRING									# attributeName
	| LEFT_PAREN relativePath RIGHT_PAREN								# relativePathParenthesized
	| left = relativePath SLASH right = relativePath					# relativePathChild
	| left = relativePath DOUBLE_SLASH right = relativePath				# relativePathDescendant
	| relativePath LEFT_SQUARE_BRACKET pathFilter RIGHT_SQUARE_BRACKET	# relativePathWithPathFilter
	| left = relativePath COMMA right = relativePath					# relativePathConcatenation
    ;

pathFilter
    : relativePath															# pathFilterRelativePath
	| left = relativePath VALUE_EQUALITY_OPERATOR right = relativePath		# pathFilterValueEqualOperator
	| left = relativePath VALUE_EQUALITY_KEYWORD right = relativePath		# pathFilterValueEqualKeyword
	| left = relativePath IDENTITY_EQUALITY_OPERATOR right = relativePath	# pathFilterIdentityEqualOperator
	| left = relativePath IDENTITY_EQUALITY_KEYWORD right = relativePath    # pathFilterIdentityEqualKeyword
	| relativePath VALUE_EQUALITY_OPERATOR STRING_LITERAL	                # pathFilterEqualStringConstant
	| LEFT_PAREN pathFilter RIGHT_PAREN						                # pathFilterParenthesized
	| left = pathFilter LOGICAL_AND right = pathFilter		                # pathFilterAnd
	| left = pathFilter LOGICAL_OR right = pathFilter		                # pathFilterOr
	| LOGICAL_NOT pathFilter								                # pathFilterNot
    ;

documentName
    : DOCUMENT LEFT_PAREN FILENAME RIGHT_PAREN
    ;
