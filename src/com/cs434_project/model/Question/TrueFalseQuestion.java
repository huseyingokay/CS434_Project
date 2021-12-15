package com.cs434_project.model.Question;

public class TrueFalseQuestion implements Question {
    private int questionNumber;
    private String questionInformation;
    private boolean questionAnswerField;

    public TrueFalseQuestion(int questionNumber, String questionInformation){
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

    public void setQuestionAnswerField(boolean questionAnswerField) {
        this.questionAnswerField = questionAnswerField;
    }
    //endregion

    @Override
    public void saveAnswer(int studentId) {

    }
}
