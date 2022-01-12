package com.example.demo.Client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/client")
@ApplicationScoped
public class Client {
    @Inject
    @RestClient
    private Service service;

    @GET
    @Path("/test/{author}")
    public String onClientSide(@PathParam("author") String parameter) {
        return service.getUpload(parameter);
    }
}
