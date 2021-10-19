package seraphGrammar;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.openseraph.antrl4.SeraphLexer;
import org.openseraph.antrl4.SeraphParser;

public class SeraphQueryParser
{
    public static Query parse(String queryString) {
        org.openseraph.antrl4.SeraphLexer seraphLexer = new SeraphLexer(CharStreams.fromString(queryString));
        CommonTokenStream tokens = new CommonTokenStream(seraphLexer);
        SeraphParser parser = new SeraphParser(tokens);
        ParseTree tree = parser.oS_Seraph();

        ParseTreeWalker walker = new ParseTreeWalker();
        SeraphListenerImpl seraphListener = new SeraphListenerImpl();
        walker.walk(seraphListener, tree);

        return seraphListener.getSeraphQuery();
    }
}
