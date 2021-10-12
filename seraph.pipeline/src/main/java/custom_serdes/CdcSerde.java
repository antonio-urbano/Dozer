package custom_serdes;

import cdc_converter.CdcCreateRecord;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Custom Serde for the {@link CdcCreateRecord}
 */
public class CdcSerde implements Serde<CdcCreateRecord> {

    private final JsonSerializer<CdcCreateRecord> serializer = new JsonSerializer<>();
    private final JsonDeserializer<CdcCreateRecord> deserializer = new JsonDeserializer<>(
            CdcCreateRecord.class);

    @Override
    public Serializer<CdcCreateRecord> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<CdcCreateRecord> deserializer() {
        return deserializer;
    }
}
