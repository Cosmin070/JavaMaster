package com.ccg.lab.Beans;

import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "uploadBean")
public class UploadBean {
    private Integer id;
    private String document;
    private String username;
    private String documentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
}
