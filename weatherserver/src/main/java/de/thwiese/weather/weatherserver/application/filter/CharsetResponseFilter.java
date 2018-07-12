package de.thwiese.weather.weatherserver.application.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Reponsefilter to add UTF-8 charset to response header if not other charset is set.
 *
 * @author Thomas Wiese
 */
public class CharsetResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        String mediaType = response.getMediaType().toString();
        if (!mediaType.contains("charset")) {
            response.getHeaders().putSingle("Content-Type", mediaType + "; charset=utf-8");
        }
    }

}
