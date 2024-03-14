package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import edu.ucsd.xmlalchemy.DocumentCache;
import edu.ucsd.xmlalchemy.Expression;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

public class AbsolutePathChild implements Expression {
    private final String fileName;
    private final Expression expression;

    public AbsolutePathChild(String fileName, Expression expression) {
        this.fileName = fileName;
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) {
        try {
            var document = DocumentCache.read(fileName.replace("\"", ""));
            var inputNodes = new ArrayList<Node>(List.of(document));
            return expression.evaluate(inputNodes);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException("Encountered issue while reading file: " + fileName);
        }
    }

    @Override
    public String toString() {
        return String.format("doc(%s)/%s", fileName, expression.toString());
    }
}
