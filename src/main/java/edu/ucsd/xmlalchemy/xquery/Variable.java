package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        return ctx.getVar(name);
    }

}
