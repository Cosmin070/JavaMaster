package com.ccg.lab5.Repositories;

import com.ccg.lab5.DTOs.ExamsEntity;

import java.util.List;

public interface ExamRepositoryBase {
    void saveExam(ExamsEntity exam);

    List getExams();
}
