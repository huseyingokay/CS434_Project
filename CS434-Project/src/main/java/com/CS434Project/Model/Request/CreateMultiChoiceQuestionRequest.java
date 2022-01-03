package com.CS434Project.Model.Request;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.QuestionType;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class CreateMultiChoiceQuestionRequest {
    private int answerIndex;
    private String questionExplanation;
    private double questionPoint;
    private QuestionType questionType;
    private int examId;
    private List<String> choices = new ArrayList<>();

    public int getAnswer() {
        return answerIndex;
    }

    public void setAnswer(int answer) {
        this.answerIndex = answerIndex;
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

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
