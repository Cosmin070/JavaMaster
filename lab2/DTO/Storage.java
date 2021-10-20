package com.example.lab2.DTO;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Record> entries;

    public Storage() {
        this.entries = new ArrayList<>();
    }

    public ArrayList<Record> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Record> entries) {
        this.entries = entries;
    }

    public void addRecord(Record record) {
        entries.add(record);
    }

    @Override
    public String toString() {
        return "<table>" +
                "<tr>" +
                "   <th>Category</th>" +
                "   <th>Key</th>" +
                "   <th>Value</th>" +
                "</tr>" + this.getEntries() +
                "</table>";
    }
}
