package com.CS434Project.Service;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Response.createExamResponse;
import com.CS434Project.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    ExamRepository examRepository;

    @Autowired


    public createExamResponse createExam(){
        Exam exam = new Exam();
        examRepository.save(exam);

        createExamResponse response = new createExamResponse();
        response.setExamId(exam.getId());
        return response;
    }

    public Exam getExam(int examId) {
        return new Exam();
    }
}
