package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class StringLiteral implements Expression {
    private final String value;

    public StringLiteral(String value) {
        this.value = value.substring(1, value.length() - 1);
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        return new ArrayList<>(List.of(ctx.makeTextNode(value)));
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", value);
    }
}