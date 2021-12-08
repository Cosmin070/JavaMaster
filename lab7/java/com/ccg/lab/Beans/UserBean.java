package com.ccg.lab.Beans;

import jakarta.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "userBean")
public class UserBean implements Serializable {
    private final List<String> roles = Arrays.asList("admin", "author", "reviewer");
    private String username;
    private String password;
    private String role;

    public List<String> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
