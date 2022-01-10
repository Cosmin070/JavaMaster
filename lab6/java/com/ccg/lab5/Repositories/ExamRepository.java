package com.ccg.lab5.Repositories;

import com.ccg.lab5.DTOs.ExamsEntity;
import jakarta.inject.Inject;

import javax.persistence.EntityManager;
import java.util.List;

public class ExamRepository implements ExamRepositoryBase{
    @Inject
    private EntityManager entityManager;

    @Override
    public void saveExam(ExamsEntity exam) {
        entityManager.persist(exam);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List getExams() {
        return entityManager.createNamedQuery("ExamsEntity.getAll").getResultList();
    }
}
