package com.lab3.DTOs;

import com.lab3.Database.DatabaseConnection;
import jakarta.faces.bean.ManagedBean;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean(name = "examBean")
public class Exam {
    private String name;
    private String starting_time;
    private String duration;

    public Exam() {

    }

    public Exam(String name, String date, String duration) {
        this.name = name;
        this.starting_time = date;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean addInDB(Exam exam) throws SQLException, ClassNotFoundException {
        System.out.println(exam);
        Class.forName("org.postgresql.Driver");
        String addExam = "insert into exams(name, starting_time, duration) values(?,?,?)";
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "admin");
        PreparedStatement statement = con.prepareStatement(addExam);
        statement.setString(1, exam.getName());
        statement.setString(2, exam.getStarting_time());
        statement.setString(3, exam.duration);
        System.out.println("Data Added Successfully");
        return statement.executeUpdate() > 0;
    }

    public Map<String, String> getExams() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "admin");
        String getExams = "SELECT t.* FROM public.exams t";
        Statement st = con.createStatement();
        Map<String, String> exams = new LinkedHashMap<>();
        ResultSet rs = st.executeQuery(getExams);
        while (rs.next()) {
            String exam = rs.getString(2);
            exams.put(exam, exam);
        }
        return exams;
    }
}
