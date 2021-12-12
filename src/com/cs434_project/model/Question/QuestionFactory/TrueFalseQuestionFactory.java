package com.cs434_project.model.Question.QuestionFactory;

import com.cs434_project.model.Question.Question;
import com.cs434_project.model.Question.TrueFalseQuestion;

public class TrueFalseQuestionFactory extends QuestionFactory{
    public Question getQuestion(int questionNumber, String questionInformation) {
        return new TrueFalseQuestion(questionNumber, questionInformation);
    }
}
