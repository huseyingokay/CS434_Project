package com.CS434Project.Controller;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Response.createExamResponse;
import com.CS434Project.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;

    @PostMapping
    public createExamResponse createExam(){
        return examService.createExam();
    }

    @GetMapping("{exam-id}")
    public Exam getExam(@PathVariable("exam-id") int examId) {
        return examService.getExam(examId);
    }
}
