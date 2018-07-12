package de.thwiese.weather.model;

import de.thwiese.weather.model.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTest {

    @Test
    void testToString() {
        Value value = new Value(-45.10d, Unit.CELSIUS);
        assertEquals("-45,10 °C", value.toString(Locale.GERMAN));
        value.setValue(0.0d);
        assertEquals("0,00 °C", value.toString(Locale.GERMAN));
    }
}
