package de.thwiese.weather.supplier;

import de.thwiese.weather.model.supplier.ISupplier;
import de.thwiese.weather.model.value.ValueSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/test-config.xml"})
class WH2601Test {

    @Inject
    @Named("WH2601Supplier")
    private Provider<ISupplier> supplier;

    @Test
    void test() {
        ISupplier wh2601 = supplier.get();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            ValueSet valueSet = wh2601.grabValueSet("/data/wh2601.html.mock");
            System.out.println(i + " " + valueSet.toString());
        });

    }
}
