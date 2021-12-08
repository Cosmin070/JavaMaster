package com.ccg.lab.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;

import java.io.Serializable;
import java.util.UUID;

@ApplicationScoped
public class UIDGenerator implements Serializable {
    @Produces
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
