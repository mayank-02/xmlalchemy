package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.DocumentCache;
import edu.ucsd.xmlalchemy.Expression;
import java.util.ArrayList;
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
        var document = DocumentCache.read(fileName.replace("\"", ""));
        var inputNodes = new ArrayList<Node>(List.of(document));
        return expression.evaluate(inputNodes);
    }

    @Override
    public String toString() {
        return String.format("doc(%s)/%s", fileName, expression.toString());
    }
}
