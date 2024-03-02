package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Tuple;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryLetClause implements Expression {
    private final List<Tuple<String, Expression>> assignments;
    private final Expression query;
    
    public QueryLetClause(List<Tuple<String, Expression>> assignments, Expression query) {
        this.assignments = assignments;
        this.query = query;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        for (var assignment : assignments) {
            ctx.setVar(assignment.first, assignment.second.evaluateQuery(ctx));
        }
        return query.evaluateQuery(ctx);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("let ");
        for (int i = 0; i < assignments.size(); i++) {
            var assignment = assignments.get(i);
            sb.append(String.format("$%s := %s", assignment.first, assignment.second.toString()));
            if (i != assignments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ");
        sb.append(query.toString());
        return sb.toString();
    }
}
