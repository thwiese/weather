package de.thwiese.weather.model.value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class ValueSet implements Serializable {

    private LocalDateTime timestamp;

    private final Map<ValueType, Value> values = new HashMap<>();

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<ValueType, Value> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return String.format("ValueSet %s: %s", getTimestamp().format(DateTimeFormatter.ISO_DATE_TIME), values);
    }
}
