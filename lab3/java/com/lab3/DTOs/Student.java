package com.lab3.DTOs;

import jakarta.faces.bean.ManagedBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ManagedBean(name = "studentBean")
public class Student {
    private String firstName;
    private String lastName;
    private String year;
    private String exam;

    public Student(String first_name, String last_name, String year) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.year = year;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean addInDB(Student student) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String addExam = "insert into students(first_name, last_name, year) values(?,?,?)";
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "admin");
        PreparedStatement statement = con.prepareStatement(addExam);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getYear());
        System.out.println("Data Added Successfully");
        return statement.executeUpdate() > 0;
    }
}
