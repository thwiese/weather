package de.thwiese.weather.weatherserver;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("de.thwiese");
    }

}
