package com.lab3.DTOs;

import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "_exam")
public class Exam {
    private int id;
    private String name;
    private Integer hour = 0;
    private Integer minutes = 0;
    private Integer duration = 0;

    public Exam() {

    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
