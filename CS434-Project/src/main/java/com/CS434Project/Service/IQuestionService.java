package com.CS434Project.Service;

import com.CS434Project.Model.Question.QuestionType;
import com.CS434Project.Model.Request.CreateMultiChoiceQuestionRequest;
import com.CS434Project.Model.Request.CreateTrueFalseQuestion;
import com.CS434Project.Model.Request.CreateWrittenQuestion;

public interface IQuestionService {
    void createMultiChoiceQuestion(CreateMultiChoiceQuestionRequest request, QuestionType questionType);
    void createTrueFalseQuestion(CreateTrueFalseQuestion request, QuestionType questionType);
    void createWrittenQuestion(CreateWrittenQuestion request, QuestionType questionType);
}
