package com.cs434_project.model.Question.QuestionFactory;

import com.cs434_project.model.Question.Question;
import com.cs434_project.model.Question.WrittenQuestion;

public class WrittenQuestionFactory extends QuestionFactory{
    public Question getQuestion(int questionNumber, String questionInformation) {
        return new WrittenQuestion(questionNumber, questionInformation);
    }
}
