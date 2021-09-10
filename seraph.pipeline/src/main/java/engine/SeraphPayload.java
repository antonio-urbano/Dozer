package engine;

//todo handle with the QueryConfigListener
public class SeraphPayload {

    // SeraphQueryParser payload
    private String queryId;
    private String inputStreamTopic;
    private long windowRange;       //todo timeRange and eventRange
    private TimeInstant timeInstant;
    private String outputStreamTopic;
    private StreamingOperator streamingOperator;
    private Long emitEveryTimeRange;         //todo emitEveryEventRange
    private String cypherQuery;

    // SeraphQueryTicker, TimeManagedConsumer, CypherQueryHandler
    private Long timestampToSync;


    public String getQueryId() { return queryId; }
    public void setQueryId(String queryId) { this.queryId = queryId; }

    public String getInputStreamTopic() { return inputStreamTopic; }
    public void setInputStreamTopic(String inputStreamTopic) { this.inputStreamTopic = inputStreamTopic; }

    public long getWindowRange() { return windowRange; }
    public void setWindowRange(long windowRange) { this.windowRange = windowRange; }

    public TimeInstant getTimeInstant() { return timeInstant; }
    public void setTimeInstant(TimeInstant timeInstant) { this.timeInstant = timeInstant; }

    public String getOutputStreamTopic() { return outputStreamTopic; }
    public void setOutputStreamTopic(String outputStreamTopic) { this.outputStreamTopic = outputStreamTopic; }

    public StreamingOperator getStreamingOperator() { return streamingOperator; }
    public void setStreamingOperator(StreamingOperator streamingOperator) { this.streamingOperator = streamingOperator; }

    public Long getEmitEveryTimeRange() { return emitEveryTimeRange; }
    public void setEmitEveryTimeRange(Long emitEveryTimeRange) { this.emitEveryTimeRange = emitEveryTimeRange; }

    public Long getTimestampToSync() { return timestampToSync; }
    public void setTimestampToSync(Long timestampToSync) { this.timestampToSync = timestampToSync; }

    public String getCypherQuery() { return cypherQuery; }
    public void setCypherQuery(String cypherQuery) { this.cypherQuery = cypherQuery; }

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
