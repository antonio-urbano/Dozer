package seraphGrammar;

public class EventRange extends Range {
    private Long size;

    public EventRange(Long size) {
        this.size = size;
    }

    public Long getSize() {
        return size;
    }

    @Override
    public boolean isEventRange() {
        return true;
    }
}
