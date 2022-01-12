package com.ccg.lab.Services;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;

import java.util.Set;


@ApplicationPath("/resources")
@RolesAllowed({"author", "admin"})
public class Resource extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(DocumentService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}