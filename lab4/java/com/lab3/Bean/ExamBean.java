package com.lab3.Bean;

import com.lab3.DTOs.Exam;
import com.lab3.Database.ExamRepo;
import jakarta.faces.bean.ManagedBean;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "examBean")
public class ExamBean {
    ExamRepo repo;

    public ExamBean() throws NamingException {
        this.repo = new ExamRepo();
    }

    public void addInDB(Exam exam) throws SQLException, ClassNotFoundException {
        Boolean result = repo.addInDB(exam);
    }

    public List<String> getExamNames() throws SQLException {
        return repo.getExamNames();
    }

    public List<Exam> getExams() throws SQLException {
        return repo.getExams();
    }
}
