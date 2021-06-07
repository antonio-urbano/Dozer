package engine;


import seraphGrammar.SeraphParser;
import seraphGrammar.SeraphParserBaseListener;
import java.time.Duration;

/**
 * This class is used to parse the registered query and update the important fields used
 * by all the components of the engine {@link QueryConfiguration}
 * It extends the {@link SeraphParserBaseListener} to handle a subset of its methods.
 */
public class QueryConfigListener extends SeraphParserBaseListener {
    SeraphParser parser;
//    QueryConfiguration queryConfiguration = QueryConfiguration.getQueryConfiguration();
    private final SeraphPayload seraphPayload;


    public QueryConfigListener(SeraphParser parser, SeraphPayload seraphPayload) {
        this.parser = parser;
        this.seraphPayload = seraphPayload;
    }


    @Override public void enterOS_QueryName(SeraphParser.OS_QueryNameContext ctx)  {
        // query Name: people_to_be_tested
//        queryConfiguration.setRegisteredQueryName(ctx.getText());
        this.seraphPayload.setQuery_id(ctx.getText());
//        this.currentAgent.updatePayload("query_id",ctx.getText());
    }


    @Override public void enterOS_QueryCypher(SeraphParser.OS_QueryCypherContext ctx) {
        /*
        MATCH
    (patient:Patient)-[:TESTED_FOR {positive:true}]->(virus:Virus),
    (person:Person)-[:ADMINISTERS|IS_WITH*1..3]-(patient)
RETURN DISTINCT person.name, virus.name ;
         */
//        queryConfiguration.setCypherQuery(ctx.getText());
//        this.currentAgent.updatePayload("cypher_query", ctx.getText());
        this.seraphPayload.setCypher_query(ctx.getText());

    }

    @Override public void enterOS_InputStream(SeraphParser.OS_InputStreamContext ctx)  {
        // kafka://localhost:9092/eventtopic
        String url_topic = ctx.KAFKA_TOPIC().getText();
        String broker = ctx.getText().substring(url_topic.lastIndexOf(":")+1, url_topic.lastIndexOf("/")); //9092
        String kafka_topic = ctx.getText().substring(url_topic.lastIndexOf("/")+1); //eventtopic
//        queryConfiguration.setInput_broker(broker);
//        queryConfiguration.setInput_topic(kafka_topic);
//        this.currentAgent.updatePayload("input_stream_topic", kafka_topic);
        this.seraphPayload.setInput_stream_topic(kafka_topic);

    }

    @Override public void enterOS_TimeInstant(SeraphParser.OS_TimeInstantContext ctx) {
        // Latest
        TimeInstant timeInstant;
        switch (ctx.getText().toLowerCase()){
            case "latest": timeInstant = TimeInstant.LATEST; break;
            case "earliest": timeInstant = TimeInstant.EARLIEST; break;
            default: timeInstant = null; break;
        }
//        queryConfiguration.setTime_instant(timeInstant);
//        this.currentAgent.updatePayload("time_instant", timeInstant);
        this.seraphPayload.setTime_instant(timeInstant);
    }


    @Override public void enterOS_ISO_8601_Datetime(SeraphParser.OS_ISO_8601_DatetimeContext ctx) {
        System.out.println("\n16:   " + ctx);
        //queryConfiguration.setISO_8601_time_instant(ctx.ISO8601_DATETIME_UTC().getText());

    }

    @Override public void enterOS_WindowRange(SeraphParser.OS_WindowRangeContext ctx) {
        //PT4H
    }


    @Override public void enterOS_WindowEventRange(SeraphParser.OS_WindowEventRangeContext ctx) {
    }


    @Override public void enterOS_WindowTimeRange(SeraphParser.OS_WindowTimeRangeContext ctx) {
        //PT4H
        Duration duration = Duration.parse(ctx.getText());
//        queryConfiguration.setWindow_time_range(duration.toMillis());
//        this.currentAgent.updatePayload("every_time_operator", duration.toMillis());
        this.seraphPayload.setEmit_time_range(duration.toMillis());
    }


    @Override public void enterOS_Emit(SeraphParser.OS_EmitContext ctx) {

        StreamingOperator streamingOperator;
        switch (ctx.getText()){
            case "SNAPSHOT": streamingOperator = StreamingOperator.SNAPSHOT; break;
            case "ONENTERING": streamingOperator = StreamingOperator.ONENTERING; break;
            case "ONEXIT": streamingOperator = StreamingOperator.ONEXIT; break;
            default: streamingOperator = null; break;
        }
//        queryConfiguration.setStreaming_operator(streamingOperator);
//        this.currentAgent.updatePayload("streaming_operator", streamingOperator);
        this.seraphPayload.setStreaming_operator(streamingOperator);

    }


    @Override public void enterOS_OutputStream(SeraphParser.OS_OutputStreamContext ctx) {
        // kafka://localhost:9092/resulttopic
        String url_topic = ctx.KAFKA_TOPIC().getText();
        String broker = ctx.getText().substring(url_topic.lastIndexOf(":")+1, url_topic.lastIndexOf("/")); //9092
        String kafka_topic = ctx.getText().substring(url_topic.lastIndexOf("/")+1); //resulttopic
//        queryConfiguration.setOutput_broker(broker);
//        queryConfiguration.setOutput_topic(kafka_topic);
//        this.currentAgent.updatePayload("output_stream_topic", kafka_topic);
        this.seraphPayload.setOutput_stream_topic(kafka_topic);
    }

    @Override public void enterOS_EmitRange(SeraphParser.OS_EmitRangeContext ctx) {
        //1Event
    }

    @Override public void enterOS_EmitEventRange(SeraphParser.OS_EmitEventRangeContext ctx) {
//        queryConfiguration.setEvent_range(Integer.parseInt(ctx.EMIT_RANGE_INT().getText()));
    }

    @Override public void enterOS_EmitTimeRange(SeraphParser.OS_EmitTimeRangeContext ctx) {
        //PT5M
        Duration duration = Duration.parse(ctx.getText());
        this.seraphPayload.setEmit_time_range(duration.toMillis());
    }

}
