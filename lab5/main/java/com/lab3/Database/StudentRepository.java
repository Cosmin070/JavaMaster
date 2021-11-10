package com.lab3.Database;

import com.lab3.DTOs.ExamsEntity;
import com.lab3.DTOs.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentRepository {
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List getAllStudents() {
        Query query = entityManager.createNamedQuery("StudentsEntity.getAll");
        return query.getResultList();
    }

    public void insertStudent(StudentsEntity student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
