package com.cs434_project.model.Question;

public class NullQuestion implements Question{
    public static NullQuestion emp = new NullQuestion();

    @Override
    public int getQuestionNumber() {
        return 0;
    }

    @Override
    public String getQuestionInformation() {
        return null;
    }

    @Override
    public void setQuestionNumber(int questionNumber) {
        //nothing
    }

    @Override
    public void setQuestionInformation(String questionInformation) {
        //nothing
    }

    @Override
    public void saveAnswer(int studentId) {
        //nothing
    }
}
