package seraphGrammar;

import java.time.Duration;

public class TimeRange extends Range {
    private Duration duration;

    public TimeRange(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public boolean isTimeRange() {
        return true;
    }
}
