package com.cs434_project.model.Question.QuestionFactory;

import com.cs434_project.model.Question.Question;

import java.util.List;

public abstract class QuestionFactory {
    abstract public Question getQuestion(int questionNumber, String questionInformation);
}
