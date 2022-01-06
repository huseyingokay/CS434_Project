package com.CS434Project.Model.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionFactory {
    private static final Map<QuestionType, Question> questionMap = new HashMap();

    public Question getQuestion(QuestionType questionType){
        Question question;

        if (questionMap.get(questionType) != null) {
            question = questionMap.get(questionType);
        }

        switch(questionType){
            case WRITTEN:
                question = new WrittenQuestion();
                break;
            case TRUEFALSE:
                question = new TrueFalseQuestion();
                break;
            case MULTICHOICE:
                question = new MultiChoiceQuestion();
                break;
            default:
                question = new NullQuestion();
                break;
        }

        questionMap.put(questionType, question);
        return question;
    }
}
