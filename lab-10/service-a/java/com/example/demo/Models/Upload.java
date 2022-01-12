package com.example.demo.Models;

import javax.persistence.*;

@Entity(name = "uploads")
@Table(name = "uploads")
@NamedQueries({
        @NamedQuery(name = "Upload.getAll", query = "select e from uploads e"),
        @NamedQuery(name = "Upload.getByAuthor", query = "select e from uploads e where e.author = ?1")
})
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}