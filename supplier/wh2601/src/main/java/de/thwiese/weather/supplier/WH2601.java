package de.thwiese.weather.supplier;

import de.thwiese.weather.model.Unit;
import de.thwiese.weather.model.supplier.ISupplier;
import de.thwiese.weather.model.supplier.SupplierException;
import de.thwiese.weather.model.value.Value;
import de.thwiese.weather.model.value.ValueSet;
import de.thwiese.weather.model.value.ValueType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Named("WH2601Supplier")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WH2601 implements ISupplier {

    private static final String VERSION = "4.3";

    private static final String HTML_CHARSET = "UTF-8";

    private static final String LIVE_HTML_INPUT_CLASS = "item_2";
    private static final String TIMESTAMP_FORMAT = "HH:mm MM/dd/yyyy";

    @PostConstruct
    public void init() {
        System.out.println(String.format("%s initialize ... ", WH2601.class));
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public ValueSet grabValueSet(Object... params) {
        if (params == null || params.length == 0 || !(params[0] instanceof String)) {
            throw new SupplierException("First parameter should contain dataSource string");
        }
        final ValueSet valueSet = new ValueSet();

        Document page = getDocument((String) params[0]);

        page.getElementsByClass(LIVE_HTML_INPUT_CLASS).forEach(e -> {
            String name = e.attr("name");
            if (name != null && !"".equals(name) && "text".equals(e.attr("type"))) {
                switch (name) {
                    case "outTemp": {
                        valueSet.getValues().put(ValueType.TEMP_OUTDOOR, new Value(Double.parseDouble(e.val()), Unit.CELSIUS));
                        break;
                    }
                    case "inTemp": {
                        valueSet.getValues().put(ValueType.TEMP_INDOOR, new Value(Double.parseDouble(e.val()), Unit.CELSIUS));
                        break;
                    }
                    case "CurrTime": {
                        valueSet.setTimestamp(this.parseTimestamp(e.val()));
                    }
                }
            }
        });
        return valueSet;
    }

    private Document getDocument(final String dataSource) {
        try {
            if (dataSource.toLowerCase().startsWith("http")) {
                return Jsoup.parse(new URL(dataSource), 1000);
            } else {
                return Jsoup.parse(this.getClass().getResourceAsStream(dataSource), HTML_CHARSET, "/");
            }
        } catch (Exception e) {
            throw new SupplierException("Reading data from WH261 datasource " + dataSource + " failed", e);
        }
    }

    private LocalDateTime parseTimestamp(final String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT));
    }


}
