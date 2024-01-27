package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import java.util.List;

public class AbsolutePath implements Expression {
    final private Expression expression;
    final private String fileName;

    public AbsolutePath(String fileName, Expression expression) {
        this.expression = expression;
        this.fileName = fileName;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        return expression.evaluate(nodes);
    }

    public String getFileName() {
        return fileName;
    }
}
