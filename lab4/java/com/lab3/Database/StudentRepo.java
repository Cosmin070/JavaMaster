package com.lab3.Database;

import com.lab3.DTOs.Student;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepo {
    @Resource(name = "jdbc/java")
    private final DataSource dataSource;
    ExamRepo repo;
    private Connection connection;

    public StudentRepo() throws NamingException {
        Context initContext = new InitialContext();
        dataSource = (DataSource) initContext.lookup("jdbc/java");
        this.repo = new ExamRepo();
    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public Boolean addInDB(Student student) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "insert into students(first_name, last_name,year) values(?,?,?)");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setInt(3, student.getYear());
        int result = stmt.executeUpdate();
        connection.close();
        addSchedule(student);
        return result > 0;
    }

    private Boolean addSchedule(Student student) throws SQLException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "insert into scheduler(exam_id, student_id) values(?,?)");
        int studentId = getStudentId(student);
        int examId = repo.getExamId(student.getExam());
        stmt.setInt(1, examId);
        stmt.setInt(2, studentId);
        connection.close();
        return stmt.executeUpdate() > 0;
    }

    public List<String> getExams() throws SQLException {
        connection = getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select distinct name from exams");
        List<String> exams = new ArrayList<>();
        while (rs.next()) {
            exams.add(rs.getString(1));
        }
        connection.close();
        return exams;
    }

    public int getStudentId(Student student) throws SQLException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select id from students where first_name=? and last_name=? and year=?");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setInt(3, student.getYear());
        ResultSet rs = stmt.executeQuery();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public List<Student> getStudents() throws SQLException {
        connection = getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from students");
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setFirstName(rs.getString(2));
            student.setLastName(rs.getString(3));
            student.setYear(rs.getInt(4));
            students.add(student);
        }
        connection.close();
        return students;
    }
}
