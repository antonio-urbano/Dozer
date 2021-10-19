package seraphGrammar;

public class EventStart extends Start {
    private Event event;

    public EventStart(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public boolean isEventStart() {
        return true;
    }
}
