package de.thwiese.weather.model.value;

import de.thwiese.weather.model.Unit;

import java.util.Locale;

/**
 * Wrapper class that represents a double value with a concrete @{@link Unit}.
 *
 * @author Thomas Wiese
 */
public class Value {

    private double value;

    private Unit unit;

    public Value(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return toString(Locale.getDefault());
    }

    public String toString(Locale locale) {
        return String.format(locale, "%1$,.2f %2$s", value, unit.symbol());
    }
}
