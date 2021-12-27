package com.CS434Project.Model.Request;

import com.CS434Project.Model.Question.QuestionType;

public class CreateTrueFalseQuestion {
    private boolean answer;
    private String questionExplanation;
    private double questionPoint;
    private QuestionType questionType;
    private int examId;

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
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

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
