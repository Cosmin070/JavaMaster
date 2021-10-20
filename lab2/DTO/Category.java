package com.example.lab2.DTO;

public class Category {
    String[] categories = new String[]{
            "",
            "Vegetable",
            "Fruit",
            "Dairy",
            "Furniture",
            "Electronic"
    };

    public Category() {
    }

    public Category(String[] categories) {
        this.categories = categories;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
