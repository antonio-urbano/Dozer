package seraphGrammar;

public class Window {
    private Start start;
    private Range range;

    public Window(Start start, Range range) {
        this.start = start;
        this.range = range;
    }

    public Start getStart() {
        return start;
    }

    public Range getRange() {
        return range;
    }

    public class WindowBuilder {
        private Start start;
        private Range range;

        public void setStartTimeInstant(TimeStart timeStart) {
            this.start = timeStart;
        }

        public void setStartEvent(EventStart eventStart) {
            this.start = eventStart;
        }

        public void setTimeRange(TimeRange timeRange) {
            this.range = timeRange;
        }

        public void setEventRange(EventRange eventRange) {
            this.range = eventRange;
        }

        public Window build() {
            return new Window(this.start, this.range);
        }
    }
}
