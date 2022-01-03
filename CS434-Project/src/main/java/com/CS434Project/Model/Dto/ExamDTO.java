package com.CS434Project.Model.Dto;


import com.CS434Project.Model.Request.UserType;

import java.util.ArrayList;
import java.util.List;

public class ExamDTO implements IExamDTO{
    private int id;
    private List<QuestionDTO> questions = new ArrayList<>();
    private UserType userType;

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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
