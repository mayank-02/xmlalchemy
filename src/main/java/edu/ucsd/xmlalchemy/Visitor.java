package edu.ucsd.xmlalchemy;

import java.util.ArrayList;
import edu.ucsd.xmlalchemy.ExpressionParser.*;
import edu.ucsd.xmlalchemy.xpath.*;
import edu.ucsd.xmlalchemy.xquery.*;

public class Visitor extends ExpressionParserBaseVisitor<Expression> {

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
        return new RelativePathParenthesized(visit(ctx.relativePath()));
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
    public Expression visitPathFilterValueEqual(PathFilterValueEqualContext ctx) {
        var leftExpression = visit(ctx.left);
        var rightExpression = visit(ctx.right);
        return new PathFilterValueEqual(leftExpression, rightExpression);
    }

    @Override
    public Expression visitPathFilterIdentityEqual(PathFilterIdentityEqualContext ctx) {
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
        return new PathFilterParenthesized(visit(ctx.pathFilter()));
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

    @Override
    public Expression visitStringLiteral(StringLiteralContext ctx) {
        return new StringLiteral(ctx.getText());
    }

    @Override
    public Expression visitQueryAbsolutePath(QueryAbsolutePathContext ctx) {
        return new QueryAbsolutePath(visit(ctx.absolutePath()));
    }

    @Override
    public Expression visitQueryParenthesized(QueryParenthesizedContext ctx) {
        return new QueryParenthesized(visit(ctx.query()));
    }

    @Override
    public Expression visitQueryConcatenation(QueryConcatenationContext ctx) {
        var leftQuery = visit(ctx.left);
        var rightQuery = visit(ctx.right);
        return new QueryConcatenation(leftQuery, rightQuery);
    }

    @Override
    public Expression visitQueryChild(QueryChildContext ctx) {
        var query = visit(ctx.query());
        var relativePath = visit(ctx.relativePath());
        return new QueryChild(query, relativePath);
    }

    @Override
    public Expression visitQueryDescendant(QueryDescendantContext ctx) {
        var query = visit(ctx.query());
        var relativePath = visit(ctx.relativePath());
        return new QueryDescendant(query, relativePath);
    }

    @Override
    public Expression visitQueryElement(QueryElementContext ctx) {
        return new QueryElement(ctx.openingTag().NAME().getText(), visit(ctx.query()));
    }

    @Override
    public Expression visitQueryConditionValueEqual(QueryConditionValueEqualContext ctx) {
        var leftQuery = visit(ctx.left);
        var rightQuery = visit(ctx.right);
        return new QueryConditionValueEqual(leftQuery, rightQuery);
    }

    @Override
    public Expression visitQueryConditionIdentityEqual(QueryConditionIdentityEqualContext ctx) {
        var leftQuery = visit(ctx.left);
        var rightQuery = visit(ctx.right);
        return new QueryConditionIdentityEqual(leftQuery, rightQuery);
    }

    @Override
    public Expression visitQueryConditionEmpty(QueryConditionEmptyContext ctx) {
        var query = visit(ctx.query());
        return new QueryConditionEmpty(query);
    }

    @Override
    public Expression visitQueryConditionParenthesized(QueryConditionParenthesizedContext ctx) {
        return new QueryConditionParenthesized(visit(ctx.queryCondition()));
    }

    @Override
    public Expression visitQueryConditionAnd(QueryConditionAndContext ctx) {
        var leftQueryCondition = visit(ctx.left);
        var rightQueryCondition = visit(ctx.right);
        return new QueryConditionAnd(leftQueryCondition, rightQueryCondition);
    }

    @Override
    public Expression visitQueryConditionOr(QueryConditionOrContext ctx) {
        var leftQueryCondition = visit(ctx.left);
        var rightQueryCondition = visit(ctx.right);
        return new QueryConditionOr(leftQueryCondition, rightQueryCondition);
    }

    @Override
    public Expression visitQueryConditionNot(QueryConditionNotContext ctx) {
        var queryCondition = visit(ctx.queryCondition());
        return new QueryConditionNot(queryCondition);
    }

    @Override
    public Expression visitVariable(VariableContext ctx) {
        return new Variable(ctx.var().NAME().getText());
    }

    @Override
    public Expression visitQueryLetClause(QueryLetClauseContext ctx) {
        var assignments = new ArrayList<Tuple<String, Expression>>();
        for (int i = 0; i < ctx.letClause().var().size(); i++) {
            var variable = ctx.letClause().var(i).NAME().getText();
            var expression = visit(ctx.letClause().query(i));
            assignments.add(new Tuple<>(variable, expression));
        }
        return new QueryLetClause(assignments, visit(ctx.query()));
    }

    @Override
    public Expression visitQueryFlwor(QueryFlworContext ctx) {
        // FOR clause
        var iterators = new ArrayList<Tuple<String, Expression>>();
        for (int i = 0; i < ctx.forClause().var().size(); i++) {
            var variable = ctx.forClause().var(i).NAME().getText();
            var expression = visit(ctx.forClause().query(i));
            iterators.add(new Tuple<>(variable, expression));
        }

        // LET clause
        var assignments = new ArrayList<Tuple<String, Expression>>();
        if (ctx.letClause() != null) {
            for (int i = 0; i < ctx.letClause().var().size(); i++) {
                var variable = ctx.letClause().var(i).NAME().getText();
                var expression = visit(ctx.letClause().query(i));
                assignments.add(new Tuple<>(variable, expression));
            }
        }

        // WHERE clause
        Expression condition = null;
        if (ctx.whereClause() != null) {
            condition = visit(ctx.whereClause().queryCondition());
        }

        // RETURN clause
        var returnExpression = visit(ctx.returnClause().query());

        return new QueryFlworClause(iterators, assignments, condition, returnExpression);
    }

    @Override
    public Expression visitQueryConditionExistentialQuantifier(
            QueryConditionExistentialQuantifierContext ctx) {
        var iterators = new ArrayList<Tuple<String, Expression>>();
        for (int i = 0; i < ctx.var().size(); i++) {
            var variable = ctx.var(i).NAME().getText();
            var expression = visit(ctx.query(i));
            iterators.add(new Tuple<>(variable, expression));
        }

        var condition = visit(ctx.queryCondition());

        return new QueryConditionExistentialQuantifier(iterators, condition);
    }

    @Override
    public Expression visitQueryJoinClause(QueryJoinClauseContext ctx) {
        return visit(ctx.joinClause());
    }

    @Override
    public Expression visitJoinClause(JoinClauseContext ctx) {
        var leftQuery = visit(ctx.left);
        var rightQuery = visit(ctx.right);
        var leftCondition = ctx.condition.left;
        var rightCondition = ctx.condition.right;

        var leftAttributes = new ArrayList<String>();
        if (leftCondition.NAME() != null) {
            for (int i = 0; i < leftCondition.NAME().size(); i++) {
                leftAttributes.add(leftCondition.NAME(i).getText());
            }
        }

        var rightAttributes = new ArrayList<String>();
        if (rightCondition.NAME() != null) {
            for (int i = 0; i < rightCondition.NAME().size(); i++) {
                rightAttributes.add(rightCondition.NAME(i).getText());
            }
        }

        return new JoinClause(leftQuery, rightQuery, leftAttributes, rightAttributes);
    }

    @Override
    public Expression visitJoinFlworClause(JoinFlworClauseContext ctx) {
        if (ctx.joinClause() != null) {
            return visit(ctx.joinClause());
        }

        // FOR clause
        var iterators = new ArrayList<Tuple<String, Expression>>();
        for (int i = 0; i < ctx.forClause().var().size(); i++) {
            var variable = ctx.forClause().var(i).NAME().getText();
            var expression = visit(ctx.forClause().query(i));
            iterators.add(new Tuple<>(variable, expression));
        }

        // WHERE clause
        Expression condition = null;
        if (ctx.whereClause() != null) {
            condition = visit(ctx.whereClause().queryCondition());
        }

        // RETURN clause
        var returnExpression = visit(ctx.joinReturnClause());
        var emptyAssignments = new ArrayList<Tuple<String, Expression>>();
        return new QueryFlworClause(iterators, emptyAssignments, condition, returnExpression);
    }

    @Override
    public Expression visitJoinReturnClause(JoinReturnClauseContext ctx) {
        var tupleElement = visit(ctx.tupleElement(0));
        for (int i = 1; i < ctx.tupleElement().size(); i++) {
            var nextTupleElement = visit(ctx.tupleElement(i));
            tupleElement = new QueryConcatenation(tupleElement, nextTupleElement);
        }
        return new QueryElement("tuple", tupleElement);
    }

    @Override
    public Expression visitTupleElement(TupleElementContext ctx) {
        return new QueryElement(ctx.openingTag().NAME().getText(),
                new Variable(ctx.var().NAME().getText()));
    }
}
