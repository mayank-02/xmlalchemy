package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import java.util.List;

public class AbsolutePathChild implements Expression {
    private final String fileName;
    private final Expression expression;

    public AbsolutePathChild(String fileName, Expression expression) {
        this.fileName = fileName;
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        return expression.evaluate(nodes);
    }

    public String getFileName() {
        return fileName;
    }
}
