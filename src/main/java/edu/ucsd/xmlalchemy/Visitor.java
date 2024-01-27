package edu.ucsd.xmlalchemy;

import edu.ucsd.xmlalchemy.ExprParser.AbsolutePathChildContext;
import edu.ucsd.xmlalchemy.ExprParser.AttributeNameContext;
import edu.ucsd.xmlalchemy.ExprParser.CurrentContext;
import edu.ucsd.xmlalchemy.ExprParser.ParentContext;
import edu.ucsd.xmlalchemy.ExprParser.RelativePathChildContext;
import edu.ucsd.xmlalchemy.ExprParser.TagNameContext;
import edu.ucsd.xmlalchemy.ExprParser.TextContext;
import edu.ucsd.xmlalchemy.ExprParser.WildcardContext;
import edu.ucsd.xmlalchemy.xpath.TagName;
import edu.ucsd.xmlalchemy.xpath.Text;
import edu.ucsd.xmlalchemy.xpath.Wildcard;
import edu.ucsd.xmlalchemy.xpath.AbsolutePath;
import edu.ucsd.xmlalchemy.xpath.Attribute;
import edu.ucsd.xmlalchemy.xpath.Current;
import edu.ucsd.xmlalchemy.xpath.Expression;
import edu.ucsd.xmlalchemy.xpath.Parent;
import edu.ucsd.xmlalchemy.xpath.RelativePathChild;

public class Visitor extends ExprParserBaseVisitor<Expression> {

    @Override
    public Expression visitAbsolutePathChild(AbsolutePathChildContext ctx) {
        Expression relativePath = visit(ctx.relativePath());
        return new AbsolutePath(ctx.documentName().FILENAME().getText(), relativePath);
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
}
