package com.CS434Project.Service;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.MultiChoiceQuestion;
import com.CS434Project.Model.Question.QuestionFactory;
import com.CS434Project.Model.Question.TrueFalseQuestion;
import com.CS434Project.Model.Question.WrittenQuestion;
import com.CS434Project.Model.Request.CreateMultiChoiceQuestionRequest;
import com.CS434Project.Model.Request.CreateTrueFalseQuestion;
import com.CS434Project.Model.Request.CreateWrittenQuestion;
import com.CS434Project.Repository.ExamRepository;
import com.CS434Project.Repository.MultiChoiceQuestionRepository;
import com.CS434Project.Repository.TrueFalseQuestionRepository;
import com.CS434Project.Repository.WrittenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    MultiChoiceQuestionRepository multiChoiceQuestionRepository;

    @Autowired
    TrueFalseQuestionRepository trueFalseQuestionRepository;

    @Autowired
    WrittenQuestionRepository writtenQuestionRepository;

    @Autowired
    ExamRepository examRepository;

    QuestionFactory questionFactory = new QuestionFactory();

    public void createMultiChoiceQuestion(CreateMultiChoiceQuestionRequest request) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        MultiChoiceQuestion question = (MultiChoiceQuestion) questionFactory.getQuestion(request.getQuestionType());
        question.setExam(exam.get());
        question.setQuestionType(request.getQuestionType());
        question.setQuestionExplanation(request.getQuestionExplanation());
        question.setQuestionPoint(request.getQuestionPoint());
        question.setAnswerIndex(request.getAnswer());
        exam.get().addQuestion(question);
        multiChoiceQuestionRepository.save(question);
        examRepository.save(exam.get());
    }

    public void createTrueFalseQuestion(CreateTrueFalseQuestion request) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        TrueFalseQuestion question = (TrueFalseQuestion) questionFactory.getQuestion(request.getQuestionType());
        question.setExam(exam.get());
        question.setQuestionType(request.getQuestionType());
        question.setQuestionExplanation(request.getQuestionExplanation());
        question.setQuestionPoint(request.getQuestionPoint());
        question.setAnswer(request.getAnswer());
        exam.get().addQuestion(question);
        trueFalseQuestionRepository.save(question);
        examRepository.save(exam.get());
    }
    public void createWrittenQuestion(CreateWrittenQuestion request) {
        Optional<Exam> exam = examRepository.findById(request.getExamId());
        WrittenQuestion question = (WrittenQuestion) questionFactory.getQuestion(request.getQuestionType());
        question.setExam(exam.get());
        question.setQuestionType(request.getQuestionType());
        question.setQuestionExplanation(request.getQuestionExplanation());
        question.setQuestionPoint(request.getQuestionPoint());
        question.setAnswer(request.getAnswer());
        exam.get().addQuestion(question);
        writtenQuestionRepository.save(question);
        examRepository.save(exam.get());
    }

}
