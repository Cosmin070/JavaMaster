package com.lab3.DTOs;

import jakarta.faces.bean.ManagedBean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean(name = "written")
@Entity
@DiscriminatorValue(value = "written")
public class WrittenTestEntity extends ExamsEntity{
    String resources;

    @Basic
    @Column(name = "resources", nullable = false, length = -1)
    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
}
