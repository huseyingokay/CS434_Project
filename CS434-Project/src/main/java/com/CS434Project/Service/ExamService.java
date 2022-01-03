package com.CS434Project.Service;

import com.CS434Project.Model.Dto.ExamDTO;
import com.CS434Project.Model.Dto.NullExamDTO;
import com.CS434Project.Model.Dto.QuestionDTO;
import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Response.GetExamResponse;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    ExamRepository examRepository;

    public CreateExamResponse createExam(){
        Exam exam = new Exam();
        examRepository.save(exam);

        CreateExamResponse response = new CreateExamResponse();
        response.setExamId(exam.getId());
        return response;
    }

    public GetExamResponse getExam(int examId) {
        GetExamResponse response = new GetExamResponse();
        response.setExamDTO(new NullExamDTO());

        if(examRepository.findById(examId).isPresent()){
            Exam foundExam = examRepository.findById(examId).get();
            ExamDTO examDTO = new ExamDTO();
            examDTO.setId(foundExam.getId());

            foundExam.getQuestions().forEach((question -> {
                QuestionDTO questionDTO = new QuestionDTO();
                questionDTO.setId(question.getId());
                questionDTO.setQuestionPoint(question.getQuestionPoint());
                questionDTO.setQuestionExplanation(question.getQuestionExplanation());
                questionDTO.setQuestionType(question.getQuestionType());
                examDTO.addQuestion(questionDTO);
            }));
            response.setExamDTO(examDTO);
        }
        return response;
    }
}
