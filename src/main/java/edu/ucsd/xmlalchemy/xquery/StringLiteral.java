package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringLiteral other = (StringLiteral) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}