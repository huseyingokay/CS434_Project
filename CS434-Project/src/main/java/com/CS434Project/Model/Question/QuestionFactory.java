package com.CS434Project.Model.Question;

public class QuestionFactory {
    public Question getQuestion(QuestionType questionType){
        Question question;
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
        return question;
    }
}
