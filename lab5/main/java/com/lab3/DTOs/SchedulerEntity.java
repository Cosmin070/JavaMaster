package com.lab3.DTOs;

import jakarta.persistence.*;
import org.hibernate.annotations.Target;

@Entity
@Table(name = "scheduler", schema = "public", catalog = "java")
public class SchedulerEntity {
    private int id;
    private ExamsEntity examsByExamId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchedulerEntity that = (SchedulerEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id", nullable = false)
    public ExamsEntity getExamsByExamId() {
        return examsByExamId;
    }

    public void setExamsByExamId(ExamsEntity examsByExamId) {
        this.examsByExamId = examsByExamId;
    }
}
