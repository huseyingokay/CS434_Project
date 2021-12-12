package com.cs434_project.model.Question;

public interface Question {
    int getQuestionNumber();
    String getQuestionInformation();
    void setQuestionNumber(int questionNumber);
    void setQuestionInformation(String questionInformation);
    void saveAnswer(int studentId);
}
