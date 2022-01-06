package com.CS434Project.Model.Dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {
    private int id;
    private String questionExplanation;
    private double questionPoint;
    private String questionType;
    private List<String> choices = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    public double getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(double questionPoint) {
        this.questionPoint = questionPoint;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = new ArrayList<>();
        this.choices = choices;
    }
}
