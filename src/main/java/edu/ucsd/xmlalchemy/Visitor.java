package edu.ucsd.xmlalchemy;

import edu.ucsd.xmlalchemy.ExprParser.*;
import edu.ucsd.xmlalchemy.xpath.*;

public class Visitor extends ExprParserBaseVisitor<Expression> {

    @Override
    public Expression visitAbsolutePathChild(AbsolutePathChildContext ctx) {
        Expression relativePath = visit(ctx.relativePath());
        return new AbsolutePathChild(ctx.documentName().filename.getText(), relativePath);
    }

    @Override
    public Expression visitTagName(TagNameContext ctx) {
        return new TagName(ctx.tagName.getText());
    }

    @Override
    public Expression visitWildcard(WildcardContext ctx) {
        return new Wildcard();
    }

    @Override
    public Expression visitCurrent(CurrentContext ctx) {
        return new Current();
    }

    @Override
    public Expression visitParent(ParentContext ctx) {
        return new Parent();
    }

    @Override
    public Expression visitText(TextContext ctx) {
        return new Text();
    }

    @Override
    public Expression visitAttributeName(AttributeNameContext ctx) {
        return new Attribute(ctx.attributeName.getText());
    }

    @Override
    public Expression visitRelativePathChild(RelativePathChildContext ctx) {
        Expression leftExpression = visit(ctx.left);
        Expression rightExpression = visit(ctx.right);
        return new RelativePathChild(leftExpression, rightExpression);
    }

    @Override
    public Expression visitRelativePathConcatenation(RelativePathConcatenationContext ctx) {
        Expression leftExpression = visit(ctx.left);
        Expression rightExpression = visit(ctx.right);
        return new RelativePathConcatenation(leftExpression, rightExpression);
    }

    @Override
    public Expression visitRelativePathParenthesized(RelativePathParenthesizedContext ctx) {
        return visit(ctx.relativePath());
    }

    @Override
    public Expression visitRelativePathWithPathFilter(RelativePathWithPathFilterContext ctx) {
        var relativePath = visit(ctx.relativePath());
        var pathFilter = visit(ctx.pathFilter());
        return new RelativePathWithPathFilter(relativePath, pathFilter);
    }

    @Override
    public Expression visitPathFilterRelativePath(PathFilterRelativePathContext ctx) {
        var relativePath = visit(ctx.relativePath());
        return new PathFilterRelativePath(relativePath);
    }

    @Override
    public Expression visitPathFilterValueEqualKeyword(PathFilterValueEqualKeywordContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterValueEqual(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterValueEqualOperator(PathFilterValueEqualOperatorContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterValueEqual(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterIdentityEqualKeyword(
            PathFilterIdentityEqualKeywordContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterIdentityEqual(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterIdentityEqualOperator(
            PathFilterIdentityEqualOperatorContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterIdentityEqual(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterAnd(PathFilterAndContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterAnd(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterNot(PathFilterNotContext ctx) {
        var expression = visit(ctx.pathFilter());
        return new PathFilterNot(expression);
    }

    @Override
    public Expression visitPathFilterOr(PathFilterOrContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterOr(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterParenthesized(PathFilterParenthesizedContext ctx) {
        return visit(ctx.pathFilter());
    }

    @Override
    public Expression visitAbsolutePathDescendant(AbsolutePathDescendantContext ctx) {
        Expression relativePath = visit(ctx.relativePath());
        return new AbsolutePathDescendant(ctx.documentName().filename.getText(), relativePath);
    }

    @Override
    public Expression visitRelativePathDescendant(RelativePathDescendantContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new RelativePathDescendant(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterEqualStringLiteral(PathFilterEqualStringLiteralContext ctx) {
        var leftExpression = visit(ctx.relativePath());
        return new PathFilterEqualStringLiteral(leftExpression, ctx.stringLiteral.getText());
    }
}
