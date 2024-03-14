package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.DocumentCache;
import edu.ucsd.xmlalchemy.Expression;
import edu.ucsd.xmlalchemy.Utils;

public class AbsolutePathDescendant implements Expression {
    private final String fileName;
    private final Expression expression;

    public AbsolutePathDescendant(String fileName, Expression expression) {
        this.fileName = fileName;
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var document = DocumentCache.read(fileName.replace("\"", ""));
        var descendantNodes = Utils.getDescendantNodes(document);
        return new ArrayList<>(new LinkedHashSet<>(expression.evaluate(descendantNodes)));
    }

    @Override
    public String toString() {
        return String.format("doc(%s)//%s", fileName, expression.toString());
    }
}
