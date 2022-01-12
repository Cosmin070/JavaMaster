package com.ccg.lab.Services;

import com.ccg.lab.Filters.DocumentCache;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class MyClient {

    private static String URI_VIEW = "http://localhost:8080/lab7-1.0-SNAPSHOT/resources/documents";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient()
                .register(DocumentCache.class);
        String temp = client.target(URI_VIEW).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("Client :\n" + temp);
    }
}