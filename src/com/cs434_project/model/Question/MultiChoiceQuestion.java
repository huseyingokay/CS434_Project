package com.cs434_project.model.Question;

import java.util.List;

public class MultiChoiceQuestion implements Question {
    private int questionNumber;
    private String questionInformation;
    private List<String> choices;
    private String questionAnswerField;

    public MultiChoiceQuestion(int questionNumber, String questionInformation){
        this.questionNumber = questionNumber;
        this.questionInformation = questionInformation;
    }

    //region getters & setters
    @Override
    public int getQuestionNumber() {
        return this.questionNumber;
    }

    @Override
    public String getQuestionInformation() {
        return this.questionInformation;
    }

    @Override
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public void setQuestionInformation(String questionInformation) {
        this.questionInformation = questionInformation;
    }

    public void setChoices(List<String> choices){
        this.choices = choices;
    }
    //endregion

    @Override
    public void saveAnswer(int studentId) {

    }
}
