package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) {
        // NOTE: getVar returns a List but not necessarily an ArrayList.
        // Always construct a new ArrayList
        return new ArrayList<>(ctx.getVar(name));
    }

    @Override
    public String toString() {
        return String.format("$%s", name);
    }

    public String getName() {
        return name;
    }
}
