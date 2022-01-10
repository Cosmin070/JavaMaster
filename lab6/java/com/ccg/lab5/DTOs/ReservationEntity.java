package com.ccg.lab5.DTOs;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@NamedQueries({
        @NamedQuery(name = "Reservation.GetAll", query = "select e from ReservationEntity e")
})
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "resource", nullable = false)
    private String resource;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "exam", nullable = false)
    private String exam;

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}