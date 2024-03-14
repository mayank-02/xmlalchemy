package edu.ucsd.xmlalchemy.xpath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
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
    public List<Node> evaluate(List<Node> nodes) {
        try {
            var document = DocumentCache.read(fileName.replace("\"", ""));
            var descendantNodes = Utils.getDescendantNodes(document);
            return new ArrayList<>(new LinkedHashSet<>(expression.evaluate(descendantNodes)));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException("Encountered issue while reading file: " + fileName);
        }
    }

    @Override
    public String toString() {
        return String.format("doc(%s)//%s", fileName, expression.toString());
    }
}
