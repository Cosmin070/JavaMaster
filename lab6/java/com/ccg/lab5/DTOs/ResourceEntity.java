package com.ccg.lab5.DTOs;

import javax.persistence.*;

@Entity
@Table(name = "resources")
@NamedQueries({
        @NamedQuery(name = "Resource.GetAll", query = "select e from ResourceEntity e")
}
)
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "resource", nullable = false)
    private String resource;

    @Column(name = "amount", nullable = false)
    private Integer amount;

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