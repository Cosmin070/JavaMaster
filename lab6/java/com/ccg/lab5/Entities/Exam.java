package com.ccg.lab5.Entities;

public class Exam {
    private String name;
    private Integer hour = 0;
    private Integer minutes = 0;
    private Integer duration = 0;

    public Exam(String name, Integer hour, Integer minutes, Integer duration) {
        this.name = name;
        this.hour = hour;
        this.minutes = minutes;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
