package com.ccg.lab.Filters;

import jakarta.servlet.annotation.WebFilter;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
@WebFilter(urlPatterns = {"/*"})
public class DocumentCache implements ContainerResponseFilter {
    Map<String, String> cache = new HashMap<>();

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {
        System.out.println("merge?");
        if (containerRequestContext.getMethod().equalsIgnoreCase("get")) {
            MultivaluedMap<String, String> params = containerRequestContext.getUriInfo().getPathParameters();
            cache.put(params.get("id").get(1) == null ? "empty" : params.get("id").get(1), String.valueOf(containerResponseContext.getEntityStream()));
            System.out.println("Filter: " + cache.entrySet());
        }
    }
}
