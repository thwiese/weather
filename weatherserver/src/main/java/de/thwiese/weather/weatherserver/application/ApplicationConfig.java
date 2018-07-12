package de.thwiese.weather.weatherserver.application;

import de.thwiese.weather.weatherserver.application.filter.CharsetResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("de.thwiese");
        register(CharsetResponseFilter.class);
    }


}
