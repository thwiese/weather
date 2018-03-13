package de.thwiese.weather.weatherserver.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("test")
public class TestResource {

    @GET
    public String test() {
        return "\uD83D\uDE0E server is running ...  ";
    }

}
