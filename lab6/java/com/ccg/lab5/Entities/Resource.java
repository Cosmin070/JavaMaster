package com.ccg.lab5.Entities;

public class Resource {
    private String resource;
    private Integer amount;

    public Resource(String resource, Integer amount) {
        this.resource = resource;
        this.amount = amount;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
