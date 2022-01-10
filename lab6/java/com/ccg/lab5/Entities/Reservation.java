package com.ccg.lab5.Entities;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "reserv")
public class Reservation {
    private String resource;
    private Integer amount;
    private String examName;

    public Reservation(String resource, Integer amount, String examName) {
        this.resource = resource;
        this.amount = amount;
        this.examName = examName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
