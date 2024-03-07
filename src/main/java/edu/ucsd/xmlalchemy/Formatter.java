package edu.ucsd.xmlalchemy;

import java.util.Stack;

public class Formatter {

    private Formatter() {}

    public static String format(String query) {
        var preformattedQuery = query.replace(", ", ",\n").replace("join (", "join (\n")
                .replace("where", "\nwhere").replace("return", "\nreturn")
                .replace("<tuple>{", "<tuple>{\n").replace("}</tuple>", "\n}</tuple>");

        // Track current indentation level and use a stack to save indentation levels of for clauses
        var indentLevel = 0;
        var indentationStack = new Stack<Integer>();

        var formattedQuery = new StringBuilder();
        var lines = preformattedQuery.split("\n");

        for (String line : lines) {
            // Before formatting current line
            if (line.trim().contains("</tuple>")) {
                indentationStack.pop();
                indentLevel--;
            } else if (line.trim().contains("let")) {
                indentLevel = indentationStack.peek();
            } else if (line.trim().contains("where")) {
                indentLevel = indentationStack.peek();
            } else if (line.trim().contains("return")) {
                indentLevel = indentationStack.peek();
            }

            // Save current line with indentation
            formattedQuery.append("    ".repeat(Math.max(0, indentLevel))).append(line).append("\n");

            // After formatting current line
            if (line.contains("for ")) {
                indentationStack.add(indentLevel);
                indentLevel++;
            } else if (line.trim().contains("join")) {
                indentLevel++;
            } else if (line.trim().contains("return")) {
                indentLevel++;
            } else if (line.trim().contains("]),")) {
                indentLevel--;
            }
        }

        return formattedQuery.toString().trim();
    }
}
