package com.ccg.lab.Entities;

import javax.persistence.*;

@Entity
@Table(name = "uploads")
@NamedQueries({
        @NamedQuery(name = "Upload.getUploads", query = "select e from Upload e"),
        @NamedQuery(name = "Upload.getUploadsByUser", query = "select e from Upload e where e.username=?1")
})
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    @Basic
    @Column(name = "document", nullable = false)
    private String document;

    @Basic
    @Column(name = "document_id", nullable = false)
    private String documentId;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "username='" + username + '\'' +
                ", document='" + document + '\'' +
                ", documentId='" + documentId + '\'' +
                '}';
    }
}