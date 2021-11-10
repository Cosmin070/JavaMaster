package com.lab3.Bean;

import com.lab3.DTOs.StudentsEntity;
import com.lab3.Database.StudentRepository;
import jakarta.faces.bean.ManagedBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean(name = "studentBean")
public class StudentBean {
    StudentRepository studentRepository;

    public StudentBean() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.studentRepository = new StudentRepository(entityManager);
    }

    public void addInDB(StudentsEntity student) {
        studentRepository.insertStudent(student);
    }

    public List<StudentsEntity> getStudentList() {
        return studentRepository.getAllStudents();
    }
}
