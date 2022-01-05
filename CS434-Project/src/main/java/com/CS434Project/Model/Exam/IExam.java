package com.CS434Project.Model.Exam;

import com.CS434Project.Model.Question.Question;

import java.util.List;

public interface IExam {
    List<Question> getQuestions();
    String getExamName();
    void setExamName(String examName);
}
