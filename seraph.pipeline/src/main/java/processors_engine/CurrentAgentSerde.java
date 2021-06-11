package processors_engine;

import engine.CurrentAgent;
import engine.JsonDeserializer;
import engine.JsonSerializer;
import engine.Neo4jObj;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CurrentAgentSerde implements Serde<CurrentAgent> {

    JsonSerializer<CurrentAgent> serializer = new JsonSerializer<>();
    JsonDeserializer<CurrentAgent> deserializer = new JsonDeserializer<>(
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
