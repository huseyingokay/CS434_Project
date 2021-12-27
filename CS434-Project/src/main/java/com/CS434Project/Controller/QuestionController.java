package com.CS434Project.Controller;

import com.CS434Project.Model.Question.MultiChoiceQuestion;
import com.CS434Project.Model.Question.Question;
import com.CS434Project.Model.Request.CreateMultiChoiceQuestionRequest;
import com.CS434Project.Model.Request.CreateTrueFalseQuestion;
import com.CS434Project.Model.Request.CreateWrittenQuestion;
import com.CS434Project.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/multichoice")
    public void createMultiChoiceQuestion(@RequestBody CreateMultiChoiceQuestionRequest question){
        questionService.createMultiChoiceQuestion(question);
    }

    @PostMapping("/truefalse")
    public void createTrueFalseQuestion(@RequestBody CreateTrueFalseQuestion question){
        questionService.createTrueFalseQuestion(question);
    }

    @PostMapping("/written")
    public void createWrittenQuestion(@RequestBody CreateWrittenQuestion question){
        questionService.createWrittenQuestion(question);
    }
}
