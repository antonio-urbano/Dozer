package engine;

public class QueryConfiguration {

    private String input_broker;
    private String output_broker;
    private String input_topic;
    private String output_topic;
    private StreamingOperator streaming_operator;
    private Integer event_range;
    private int ISO_8601_range;
    private TimeInstant time_instant;
    private String ISO_8601_time_instant;
    private long window_time_range;
    private int window_event_range;
    private String cypherQuery;
    private String registeredQueryName;


    private static QueryConfiguration queryConfig = null;


    public static QueryConfiguration getQueryConfiguration(){
        if(queryConfig == null)
            queryConfig = new QueryConfiguration();

        return queryConfig;
    }


    public String getInput_broker() {
        return input_broker;
    }

    public void setInput_broker(String input_broker) {
        this.input_broker = input_broker;
    }

    public String getOutput_broker() {
        return output_broker;
    }

    public void setOutput_broker(String output_broker) {
        this.output_broker = output_broker;
    }

    public String getInput_topic() {
        return input_topic;
    }

    public void setInput_topic(String input_topic) {
        this.input_topic = input_topic;
    }

    public String getOutput_topic() {
        return output_topic;
    }

    public void setOutput_topic(String output_topic) {
        this.output_topic = output_topic;
    }

    public StreamingOperator getStreaming_operator() {
        return streaming_operator;
    }

    public void setStreaming_operator(StreamingOperator streaming_operator) {
        this.streaming_operator = streaming_operator;
    }

    public Integer getEvent_range() {
        return event_range;
    }

    public void setEvent_range(Integer event_range) {
        this.event_range = event_range;
    }

    public TimeInstant getTime_instant() {
        return time_instant;
    }

    public void setTime_instant(TimeInstant time_instant) {
        this.time_instant = time_instant;
    }

    public long getWindow_time_range() {
        return window_time_range;
    }

    public void setWindow_time_range(long window_time_range) {
        this.window_time_range = window_time_range;
    }

    public int getWindow_event_range() {
        return window_event_range;
    }

    public void setWindow_event_range(int window_event_range) {
        this.window_event_range = window_event_range;
    }

    public static QueryConfiguration getQueryConfig() {
        return queryConfig;
    }

    public static void setQueryConfig(QueryConfiguration queryConfig) {
        QueryConfiguration.queryConfig = queryConfig;
    }

    public int getISO_8601_range() {
        return ISO_8601_range;
    }

    public void setISO_8601_range(int ISO_8601_range) {
        this.ISO_8601_range = ISO_8601_range;
    }

    public String getISO_8601_time_instant() {
        return ISO_8601_time_instant;
    }

    public void setISO_8601_time_instant(String ISO_8601_time_instant) {
        this.ISO_8601_time_instant = ISO_8601_time_instant;
    }

    public String getCypherQuery() {
        return cypherQuery;
    }

    public void setCypherQuery(String cypherQuery) {
        this.cypherQuery = cypherQuery;
    }


    public String getRegisteredQueryName() {
        return registeredQueryName;
    }

    public void setRegisteredQueryName(String registeredQueryName) {
        this.registeredQueryName = registeredQueryName;
    }
}
