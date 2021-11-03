package com.lab3.DTOs;

import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "_stud")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Integer year = 0;
    private String exam;

    public Student(String firstName, String lastName, int year, String exam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.exam = exam;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
