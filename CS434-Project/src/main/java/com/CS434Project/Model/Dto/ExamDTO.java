package com.CS434Project.Model.Dto;


import java.util.ArrayList;
import java.util.List;

public class ExamDTO implements IExamDTO{
    private int id;
    private List<QuestionDTO> questions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public void addQuestion(QuestionDTO question) {
        this.questions.add(question);
    }
}
