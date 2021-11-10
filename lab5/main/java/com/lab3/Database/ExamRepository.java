package com.lab3.Database;

import com.lab3.DTOs.ExamsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ExamRepository {
    private final EntityManager entityManager;

    public ExamRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List getAllExams() {
        Query query = entityManager.createNamedQuery("ExamsEntity.getAll");
        return query.getResultList();
    }

    public ExamsEntity getExamName(String name) {
        return (ExamsEntity) entityManager.createNamedQuery("ExamsEntity.getExamId").setParameter(1, name).getSingleResult();
    }

    public List getExamNames() {
        return entityManager.createNamedQuery("ExamsEntity.getExamNames").getResultList();
    }

    public void insertExam(ExamsEntity exam) {
        entityManager.getTransaction().begin();
        entityManager.persist(exam);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
