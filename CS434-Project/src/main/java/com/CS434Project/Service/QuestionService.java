package com.CS434Project.Service;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.*;
import com.CS434Project.Model.Request.CreateMultiChoiceQuestionRequest;
import com.CS434Project.Model.Request.CreateTrueFalseQuestion;
import com.CS434Project.Model.Request.CreateWrittenQuestion;
import com.CS434Project.Repository.ExamRepository;
import com.CS434Project.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository<WrittenQuestion> writtenQuestionQuestionRepository;

    @Autowired
    QuestionRepository<MultiChoiceQuestion> multiChoiceQuestionQuestionRepository;

    @Autowired
    QuestionRepository<TrueFalseQuestion> trueFalseQuestionQuestionRepository;

    @Autowired
    ExamRepository examRepository;

    QuestionFactory questionFactory = new QuestionFactory();

    public void createMultiChoiceQuestion(CreateMultiChoiceQuestionRequest request, QuestionType questionType) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        MultiChoiceQuestion question = (MultiChoiceQuestion) questionFactory.getQuestion(questionType);
        question.setAnswerIndex(request.getAnswer());
        setQuestionCommonAttributes(question, exam.get(), request.getQuestionExplanation(), request.getQuestionPoint());
        multiChoiceQuestionQuestionRepository.save(question);
    }

    public void createTrueFalseQuestion(CreateTrueFalseQuestion request, QuestionType questionType) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        TrueFalseQuestion question = (TrueFalseQuestion) questionFactory.getQuestion(questionType);
        question.setAnswer(request.getAnswer());
        setQuestionCommonAttributes(question, exam.get(), request.getQuestionExplanation(), request.getQuestionPoint());
        trueFalseQuestionQuestionRepository.save(question);
    }
    public void createWrittenQuestion(CreateWrittenQuestion request, QuestionType questionType) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        WrittenQuestion question = (WrittenQuestion) questionFactory.getQuestion(questionType);
        question.setAnswer(request.getAnswer());
        setQuestionCommonAttributes(question, exam.get(), request.getQuestionExplanation(), request.getQuestionPoint());
        writtenQuestionQuestionRepository.save(question);
    }

    private void setQuestionCommonAttributes(Question question, Exam exam, String questionExplanation, double questionPoint){
        question.setExam(exam);
        question.setQuestionExplanation(questionExplanation);
        question.setQuestionPoint(questionPoint);
        exam.addQuestion(question);
        examRepository.save(exam);
    }

}
