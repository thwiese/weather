package de.thwiese.weather.model;

import org.junit.jupiter.api.Test;

import static de.thwiese.weather.model.Unit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemperatureUnitTest {

    private final static double DOUBLE_FUZZY = 0.001;

    @Test
    void testTemperatureConversionsCelsiusToFahrenheit() {
        assertEquals(CELSIUS.convert(FAHRENHEIT, 10.0), 50.0, DOUBLE_FUZZY);
        assertEquals(CELSIUS.convert(FAHRENHEIT, 0.0), 32.0, DOUBLE_FUZZY);
        assertEquals(CELSIUS.convert(FAHRENHEIT, -4.6), 23.72, DOUBLE_FUZZY);
    }

    @Test
    void testTemperatureConversionsFahrenheitToCelsius() {
        assertEquals(-4.6, FAHRENHEIT.convert(CELSIUS, 23.72), DOUBLE_FUZZY);
        assertEquals(-0.0, FAHRENHEIT.convert(CELSIUS, 32.0), DOUBLE_FUZZY);
        assertEquals(-4.6, FAHRENHEIT.convert(CELSIUS, 23.72), DOUBLE_FUZZY);
    }

    @Test
    void testTemperatureConversionsCelsiusToKelvin() {
        assertEquals(283.15, CELSIUS.convert(KELVIN, 10.0), DOUBLE_FUZZY);
        assertEquals(273.15, CELSIUS.convert(KELVIN, 0.0), DOUBLE_FUZZY);
        assertEquals(268.55, CELSIUS.convert(KELVIN, -4.6), DOUBLE_FUZZY);
    }

    @Test
    void testTemperatureConversionsKelvinToCelsius() {
        assertEquals(10.0, KELVIN.convert(CELSIUS, 283.15), DOUBLE_FUZZY);
        assertEquals(-0.0, KELVIN.convert(CELSIUS, 273.15), DOUBLE_FUZZY);
        assertEquals(-4.6, KELVIN.convert(CELSIUS, 268.55), DOUBLE_FUZZY);
    }

    @Test
    void testTemperatureConversionsFahrenheitToKelvin() {
        assertEquals(252.81667, FAHRENHEIT.convert(KELVIN, -4.6), DOUBLE_FUZZY);
        assertEquals(255.372, FAHRENHEIT.convert(KELVIN, 0.0), DOUBLE_FUZZY);
        assertEquals(260.928, FAHRENHEIT.convert(KELVIN, 10.0), DOUBLE_FUZZY);
    }

    @Test
    void testTemperatureConversionsKelvinToFahrenheit() {
        assertEquals(-4.6, KELVIN.convert(FAHRENHEIT, 252.81667), DOUBLE_FUZZY);
        assertEquals(-0.0, KELVIN.convert(FAHRENHEIT, 255.372), DOUBLE_FUZZY);
        assertEquals(10.0, KELVIN.convert(FAHRENHEIT, 260.928), DOUBLE_FUZZY);
    }

    @Test
    void testUndefinedConversion() {
        assertThrows(IllegalArgumentException.class, () -> TEMPERATURE.convert(CELSIUS, 0.0));
    }
}
