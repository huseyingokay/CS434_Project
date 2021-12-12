package com.cs434_project.model.Question.QuestionFactory;

import com.cs434_project.model.Question.MultiChoiceQuestion;
import com.cs434_project.model.Question.Question;

import java.util.List;

public class MultiChoiceQuestionFactory extends QuestionFactory{
    public Question getQuestion(int questionNumber, String questionInformation) {
        return new MultiChoiceQuestion(questionNumber, questionInformation);
    }
}
