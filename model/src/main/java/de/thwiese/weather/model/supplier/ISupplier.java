package de.thwiese.weather.model.supplier;

import de.thwiese.weather.model.value.ValueSet;

public interface ISupplier {

    String getVersion();

    ValueSet grabValueSet(Object... params);
}
