package com.CS434Project.Controller;

import com.CS434Project.Model.Request.AddAnswerRequest;
import com.CS434Project.Repository.AnswerRepository;
import com.CS434Project.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping
    public void addAnswer(@RequestBody AddAnswerRequest request){
        answerService.addAnswer(request);
    }
}
