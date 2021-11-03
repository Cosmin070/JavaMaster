package com.lab3.Controller;

import com.lab3.DTOs.Allocation;
import com.lab3.DTOs.Exam;
import com.lab3.Database.AllocationRepo;
import com.lab3.Database.ExamRepo;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "counter")
@SessionScoped
public class CounterController {
    private final List<Exam> examList;
    private final List<Allocation> allocationList;
    private final ExamRepo examRepo;
    private final AllocationRepo allocationRepo;
    private int currentIndex;

    public CounterController() throws NamingException, SQLException {
        examRepo = new ExamRepo();
        allocationRepo = new AllocationRepo();
        examList = examRepo.getExams();
        allocationList = allocationRepo.getAllocation();
    }

    public String getExamName() {
        return examList.get(currentIndex).getName();
    }

    public int getStudentCount() {
        int count = 0;
        for (Allocation allocation : allocationList) {
            if (allocation.getExam().equals(getExamName())) {
                count++;
            }
        }
        return count;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void increment() {
        currentIndex = currentIndex + 1 == examList.size() ? 0 : currentIndex + 1;
    }
}
