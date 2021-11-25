package com.lab3.DTOs;


import jakarta.faces.bean.ManagedBean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean(name = "presentation")
@Entity
@DiscriminatorValue(value = "presentation")
public class PresentationEntity extends ExamsEntity{
    Integer slidesCount = 0;

    @Basic
    @Column(name = "slides", nullable = false)
    public int getSlidesCount() {
        return slidesCount;
    }

    public void setSlidesCount(int slidesCount) {
        this.slidesCount = slidesCount;
    }
}
