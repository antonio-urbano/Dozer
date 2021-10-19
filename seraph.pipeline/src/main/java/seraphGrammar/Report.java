package seraphGrammar;

public class Report {
    private StreamOperator streamOperator;
    private Range range;

    public Report(StreamOperator streamOperator, Range range) {
        this.streamOperator = streamOperator;
        this.range = range;
    }

    public StreamOperator getStreamOperator() {
        return streamOperator;
    }

    public Range getRange() {
        return range;
    }

    public class ReportBuilder {
        private StreamOperator streamOperator;
        private Range range;

        public void setStreamOperator(StreamOperator streamOperator) {
            this.streamOperator = streamOperator;
        }

        public void setTimeRange(TimeRange timeRange) {
            this.range = timeRange;
        }

        public void setEventRange(EventRange eventRange) {
            this.range = eventRange;
        }

        public Report build() {
            return new Report(this.streamOperator, this.range);
        }
    }
}
