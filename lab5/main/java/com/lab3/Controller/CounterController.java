package com.lab3.Controller;

import com.lab3.DTOs.ExamsEntity;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "counter")
@SessionScoped
public class CounterController {
    private final List<ExamsEntity> examList;
    private int currentIndex;

    public CounterController() throws NamingException, SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        examList = entityManager.createNamedQuery("ExamsEntity.getAll").getResultList();
    }

    public String getExamName() {
        return examList.get(currentIndex).getName();
    }


    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void increment() {
        currentIndex = currentIndex + 1 == examList.size() ? 0 : currentIndex + 1;
    }
}
