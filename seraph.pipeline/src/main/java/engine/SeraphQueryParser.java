package engine;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import seraphGrammar.SeraphLexer;
import seraphGrammar.SeraphParser;
import stateStore.PubSubRedisStateStore;


public class SeraphQueryParser {

//    private final CurrentAgent currentAgent;
//    private final PubSubRedisStateStore stateStore;

    private final SeraphPayload seraphPayload;

    public SeraphQueryParser(){
//        this.currentAgent=new CurrentAgent(this.getClass().getSimpleName(), "started");
//        this.stateStore = new PubSubRedisStateStore(this.currentAgent);
//        this.stateStore.writeState("global_state_store", this.currentAgent);
        this.seraphPayload = new SeraphPayload();
    }


    /**
     * It uses a {@link ParseTreeWalker} to walk the tree created by
     * parsing the registered query by the {@link QueryConfigListener}
     */
    public void parseQuery() {
        CharStream in = CharStreams.fromString("REGISTER QUERY people_to_be_tested {\n" +
                "FROM STREAM kafka://localhost:9092/eventtopic \n" +
                "STARTING FROM Latest \n" +
                "WITH WINDOW RANGE PT1M\n" +
                "MATCH\n" +
                "    (patient:Patient)-[t:TESTED_FOR {positive:true}]->(virus:Virus)  \n" +
                "RETURN DISTINCT patient.name, virus.name;\n" +
                "EMIT ON EXIT \n" +
                "EVERY PT5M \n" +
                "INTO kafka://localhost:9092/resulttopic1 \n" +
                "}");

        SeraphLexer lexer = new SeraphLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SeraphParser parser = new SeraphParser(tokens);

        ParseTree tree = parser.oS_Seraph();
        ParseTreeWalker walker = new ParseTreeWalker();
        QueryConfigListener queryConfigListener = new QueryConfigListener(parser, this.seraphPayload);
        walker.walk(queryConfigListener, tree);
//        this.currentAgent.updateCurrentAgent(this.getClass().getSimpleName(), "completed", System.currentTimeMillis());
//        System.err.println("QQQ: " + this.currentAgent.getAgentName() + "  " +this.currentAgent.getPayload().get("input_stream_topic") + "  " +this.currentAgent.getPayload().toString());
//        this.stateStore.writeState((String) this.currentAgent.getPayload().get("query_id"), this.currentAgent);
//        this.stateStore.writeState("global_state_store", this.currentAgent);

//        System.out.println(this.seraphPayload);
        SeraphPayloadHandler payloadHandler = new SeraphPayloadHandler();
        payloadHandler.writePayloadIntoKafka(this.seraphPayload);
//        return true;
    }
}
