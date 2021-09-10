package engine;

//todo handle with the QueryConfigListener
public class SeraphPayload {

    // SeraphQueryParser payload
    private String query_id;
    private String input_stream_topic;
    private long window_size;
    private TimeInstant time_instant;
    private String output_stream_topic;     // CypherQueryHandler
    private StreamingOperator streaming_operator;
    private Long emit_time_range;
    private String cypher_query;

    // SeraphQueryTicker, TimeManagedConsumer, CypherQueryHandler
    private Long timestampToSync;


    public String getQuery_id() { return query_id; }
    public void setQuery_id(String query_id) { this.query_id = query_id; }

    public String getInput_stream_topic() { return input_stream_topic; }
    public void setInput_stream_topic(String input_stream_topic) { this.input_stream_topic = input_stream_topic; }

    public long getWindow_size() { return window_size; }
    public void setWindow_size(long window_size) { this.window_size = window_size; }

    public TimeInstant getTime_instant() { return time_instant; }
    public void setTime_instant(TimeInstant time_instant) { this.time_instant = time_instant; }

    public String getOutput_stream_topic() { return output_stream_topic; }
    public void setOutput_stream_topic(String output_stream_topic) { this.output_stream_topic = output_stream_topic; }

    public StreamingOperator getStreaming_operator() { return streaming_operator; }
    public void setStreaming_operator(StreamingOperator streaming_operator) { this.streaming_operator = streaming_operator; }

    public Long getEmit_time_range() { return emit_time_range; }
    public void setEmit_time_range(Long emit_time_range) { this.emit_time_range = emit_time_range; }

    public Long getTimestampToSync() { return timestampToSync; }
    public void setTimestampToSync(Long timestampToSync) { this.timestampToSync = timestampToSync; }

    public String getCypher_query() { return cypher_query; }
    public void setCypher_query(String cypher_query) { this.cypher_query = cypher_query; }

//    public Map<String, Object> getPayload(String agentName){
//        Map<String, Object> payload = new HashMap<>();
//        if (agentName.equals(SeraphQueryParser.class.getSimpleName())) {
//            payload.put("query_id", this.query_id);
//            payload.put("input_stream_topic", this.input_stream_topic);
//            payload.put("window_size", this.window_size);
//            payload.put("time_instant", this.time_instant);
//            payload.put("output_stream_topic", this.output_stream_topic);
//            payload.put("streaming_operator", this.streaming_operator);
//            payload.put("every_time_operator", this.every_time_operator);
//            return payload;
//        }
//        else if(agentName.equals(CypherQueryHandler.class.getSimpleName())) {
//            payload.put("output_stream_topic", this.output_stream_topic);
//        }
//        payload.put("timestamp_to_sync", this.timestamp_to_sync);
//
//        return payload;
//    }


//    @Override
//    @JsonIgnore
//    public String toString() {
//        return "SeraphPayload{" +
//                "query_id='" + query_id + '\'' +
//                ", input_stream_topic='" + input_stream_topic + '\'' +
//                ", window_size=" + window_size +
//                ", time_instant=" + time_instant +
//                ", output_stream_topic='" + output_stream_topic + '\'' +
//                ", streaming_operator=" + streaming_operator +
//                ", emit_time_range=" + emit_time_range +
//                ", cypher_query='" + cypher_query + '\'' +
//                ", timestamp_to_sync=" + timestamp_to_sync +
//                '}';
//    }
}
