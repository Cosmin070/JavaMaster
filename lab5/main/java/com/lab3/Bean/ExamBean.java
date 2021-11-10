package com.lab3.Bean;

import com.lab3.DTOs.ExamsEntity;
import com.lab3.Database.ExamRepository;
import jakarta.faces.bean.ManagedBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean(name = "examBean")
public class ExamBean {
    ExamRepository examRepository;

    public ExamBean() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.examRepository = new ExamRepository(entityManager);
    }

    public List<String> getExamNames() {
        return examRepository.getExamNames();
    }

    public List<ExamsEntity> getExams() {
        return examRepository.getAllExams();
    }

    public void addInDB(ExamsEntity exam) {
        examRepository.insertExam(exam);

    }
}
