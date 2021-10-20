package com.example.lab2.DTO;

public class Record {
    private String category, key, value;

    public Record(String category, String key, String value) {
        this.category = category;
        this.key = key;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "<tr>" +
                "<td>" + getCategory() + "</td>" +
                "<td>" + getKey() + "</td>" +
                "<td>" + getValue() + "</td>" +
                "</tr>";
    }
}
