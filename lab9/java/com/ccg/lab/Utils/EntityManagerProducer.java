package com.ccg.lab.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

    @Produces
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }
}
