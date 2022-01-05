package com.CS434Project.Controller;

import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Response.GetExamResponse;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Service.IExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/exam")
public class ExamController {
    private IExamService examService;

    public ExamController(IExamService examService){
        this.examService = examService;
    }

    @PostMapping
    public CreateExamResponse createExam(){
        return examService.createExam();
    }

    @GetMapping("{exam-id}")
    public GetExamResponse getExam(@PathVariable("exam-id") int examId) {
        return examService.getExam(examId);
    }

    @GetMapping("{exam-id}/results/{student-id}")
    public double getExamResult(@PathVariable("exam-id") int examId, @PathVariable("student-id") int studentId){
        return examService.getExamResult(examId, studentId);
    }

    @GetMapping
    public List<String> getExamList(@RequestBody UserType userType){
        return examService.getExamList(userType);
    }
}
