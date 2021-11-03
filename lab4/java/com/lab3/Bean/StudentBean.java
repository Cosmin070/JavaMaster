package com.lab3.Bean;

import com.lab3.DTOs.Student;
import com.lab3.Database.StudentRepo;
import jakarta.faces.bean.ManagedBean;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "studentBean")
public class StudentBean {
    StudentRepo repo;

    public StudentBean() throws NamingException {
        this.repo = new StudentRepo();
    }

    public void addInDB(Student student) throws SQLException, ClassNotFoundException {
        Boolean result = repo.addInDB(student);
    }

    public List<Student> getStudentList() throws SQLException {
        return repo.getStudents();
    }
}
