package engine;

import config.KafkaConfigProperties;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import seraphGrammar.SeraphLexer;
import seraphGrammar.SeraphParser;


public class SeraphQueryParser {


    private final SeraphPayload seraphPayload;

    public SeraphQueryParser(){
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

        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic",      // todo topic name
                new CurrentAgent(this.getClass().getSimpleName(),
                        "completed", 1627576500000L)));//(SeraphPayloadHandler.getInitTimeToSync()));  //todo
        kafkaProducer.flush();

    }
}
