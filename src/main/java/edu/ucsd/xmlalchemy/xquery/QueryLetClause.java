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
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        for (var assignment : assignments) {
            ctx.setVar(assignment.first, assignment.second.evaluateQuery(ctx, nodes));
        }
        return query.evaluateQuery(ctx, nodes);
    }
}
