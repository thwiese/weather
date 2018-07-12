package de.thwiese.weather.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleFunction;

/**
 * Enumeration of units for measurement values.
 * Units are grouped to a top level unit type. E.g. Units for the top level unit
 * temperature are Celsius, Kelvin, ...
 * Each unit also contains conversion functions to calculate other units.
 *
 * @author Thomas Wiese
 */
public enum Unit {

    TEMPERATURE("T"),
    CELSIUS("°C", TEMPERATURE),
    FAHRENHEIT("°F", TEMPERATURE),
    KELVIN("K", TEMPERATURE);

    static {
        CELSIUS.converterMap.put(FAHRENHEIT, x -> 1.8 * x + 32.0);
        CELSIUS.converterMap.put(KELVIN, x -> x + 273.15);
        FAHRENHEIT.converterMap.put(CELSIUS, x -> (x - 32.0) / 1.8);
        FAHRENHEIT.converterMap.put(KELVIN, x -> (x + 459.67) / 1.8);
        KELVIN.converterMap.put(CELSIUS, x -> x - 273.15);
        KELVIN.converterMap.put(FAHRENHEIT, x -> 1.8 * x - 459.67);
    }

    private Unit group;
    private String symbol;
    private final Map<Unit, DoubleFunction<Double>> converterMap = new HashMap<>();

    Unit(String symbol) {
        this.symbol = symbol;
        this.group = null;
    }

    Unit(String symbol, Unit group) {
        this.symbol = symbol;
        this.group = group;
    }

    public Unit group() {
        return group;
    }

    public String symbol() {
        return symbol;
    }

    public double convert(Unit unit, double value) {
        if (this == unit) {
            return value;
        }
        if (!converterMap.containsKey(unit)) {
            throw new IllegalArgumentException("No converter found");
        }
        return converterMap.get(unit).apply(value);
    }

}
