package processors;

import engine.CurrentAgent;
import engine.JsonDeserializer;
import engine.JsonSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class CurrentAgentSerde implements Serde<CurrentAgent> {

    private final JsonSerializer<CurrentAgent> serializer = new JsonSerializer<>();
    private final JsonDeserializer<CurrentAgent> deserializer = new JsonDeserializer<>(
            CurrentAgent.class);

    @Override
    public Serializer<CurrentAgent> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<CurrentAgent> deserializer() {
        return deserializer;
    }
}
