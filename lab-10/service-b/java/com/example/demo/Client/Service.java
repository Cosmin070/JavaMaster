package com.example.demo.Client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@RegisterRestClient(baseUri = "https://localhost:9443/data/upload")
@ApplicationScoped
public interface Service {

    @GET
    @Path("/{author}")
    String getUpload(@PathParam("author") String parameter);

}
