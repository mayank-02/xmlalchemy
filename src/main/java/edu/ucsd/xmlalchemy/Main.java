package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            CharStream charStream = CharStreams.fromFileName(filename);
            ExprLexer lexer = new ExprLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);
            ParseTree tree = parser.query();
            System.out.printf("Query: %s", tree.getText());

            ParseTreeWalker walker = new ParseTreeWalker();
            Listener listener = new Listener();
            walker.walk(listener, tree);
        } catch (IOException e){
            System.err.printf("Failed: %s\n", filename);
        }
    }
}
