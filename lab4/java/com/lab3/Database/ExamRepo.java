package com.lab3.Database;

import com.lab3.DTOs.Exam;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamRepo {
    @Resource(name = "jdbc/java")
    private final DataSource dataSource;
    private Connection connection;

    public ExamRepo() throws NamingException {
        Context initContext = new InitialContext();
        dataSource = (DataSource) initContext.lookup("jdbc/java");
    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public Boolean addInDB(Exam exam) throws SQLException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "insert into exams(name, hour, minutes,duration) values(?,?,?,?)");
        stmt.setString(1, exam.getName());
        stmt.setInt(2, exam.getHour());
        stmt.setInt(3, exam.getMinutes());
        stmt.setInt(4, exam.getDuration());
        int result = stmt.executeUpdate();
        connection.close();
        return result > 0;
    }

    public List<String> getExamNames() throws SQLException {
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

    public int getExamId(String examName) throws SQLException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select id from exams where name=?");
        stmt.setString(1, examName);
        ResultSet rs = stmt.executeQuery();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public List<Exam> getExams() throws SQLException {
        connection = getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from exams");
        List<Exam> exams = new ArrayList<>();
        while (rs.next()) {
            Exam exam = new Exam();
            exam.setId(rs.getInt(1));
            exam.setName(rs.getString(2));
            exam.setHour(rs.getInt(3));
            exam.setMinutes(rs.getInt(4));
            exam.setDuration(rs.getInt(5));
            exams.add(exam);
        }
        connection.close();
        return exams;
    }
}
