package com.CS434Project.Model.Dto;

import java.util.List;

public class NullExamDTO implements IExamDTO{
    private int id = 0;
    private List<QuestionDTO> questions = null;

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
}
