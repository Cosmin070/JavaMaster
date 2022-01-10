package com.ccg.lab5.Controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "navigationController")
public class NavigationController {
    public String CreateStudent() {
        return "createStudent";
    }

    public String CreateExam() {
        return "createExam";
    }
}
