package com.lab3.Controller;

import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "navigationController")
public class NavigationController {
    public String CreateStudent() {
        return "createStudent";
    }

    public String CreateExam() {
        return "createExam";
    }
}
