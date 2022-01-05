package com.CS434Project.Model.Exam;

import com.CS434Project.Model.Question.Question;

import java.util.List;

public class ExamProxy implements IExam{
    private String examName;
    private Exam exam;

    @Override
    public List<Question> getQuestions() {
        exam = new Exam();
        exam.setExamName(examName);
        return exam.getQuestions();
    }

    @Override
    public String getExamName() {
        return this.getExamName();
    }

    @Override
    public void setExamName(String examName) {
        this.examName = examName;
    }
}
