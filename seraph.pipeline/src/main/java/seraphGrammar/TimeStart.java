package seraphGrammar;

import java.time.Instant;

public class TimeStart extends Start {
    private Instant instant;

    public TimeStart(Instant instant) {
        this.instant = instant;
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public boolean isTimeStart() {
        return true;
    }
}
