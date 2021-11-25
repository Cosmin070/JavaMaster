package com.lab3.DTOs;


import jakarta.faces.bean.ManagedBean;

import javax.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "exams", schema = "public", catalog = "java")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator", discriminatorType = DiscriminatorType.STRING
)
@NamedQueries({
        @NamedQuery(name = "ExamsEntity.getAll", query = "select e from ExamsEntity e order by e.id"),
        @NamedQuery(name = "ExamsEntity.getExamId", query = "select e from ExamsEntity e where e.name=?1"),
        @NamedQuery(name = "ExamsEntity.getExamNames", query = "select e.name from ExamsEntity e group by e.name")
})

@ManagedBean(name = "_exam")
public class ExamsEntity {
    int id;
    String name;
    Integer hour = 0;
    Integer minutes = 0;
    Integer duration = 0;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exams_id_seq")
    @SequenceGenerator(name = "exams_id_seq", sequenceName = "exams_id_seq", allocationSize = 1)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "hour", nullable = false)
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Basic
    @Column(name = "minutes", nullable = false)
    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamsEntity that = (ExamsEntity) o;

        if (id != that.id) return false;
        if (hour != that.hour) return false;
        if (minutes != that.minutes) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + hour;
        result = 31 * result + minutes;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
