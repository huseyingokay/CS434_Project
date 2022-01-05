package com.CS434Project.Controller;

import com.CS434Project.Model.Question.QuestionType;
import com.CS434Project.Model.Request.CreateMultiChoiceQuestionRequest;
import com.CS434Project.Model.Request.CreateTrueFalseQuestion;
import com.CS434Project.Model.Request.CreateWrittenQuestion;
import com.CS434Project.Service.IQuestionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/question")
public class QuestionController {
    private IQuestionService questionService;

    public QuestionController(IQuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/multichoice")
    public void createMultiChoiceQuestion(@RequestBody CreateMultiChoiceQuestionRequest question){
        questionService.createMultiChoiceQuestion(question, QuestionType.MULTICHOICE);
    }

    @PostMapping("/truefalse")
    public void createTrueFalseQuestion(@RequestBody CreateTrueFalseQuestion question){
        questionService.createTrueFalseQuestion(question, QuestionType.TRUEFALSE);
    }

    @PostMapping("/written")
    public void createWrittenQuestion(@RequestBody CreateWrittenQuestion question){
        questionService.createWrittenQuestion(question, QuestionType.WRITTEN);
    }

    @GetMapping("{exam-id}")
    public void getQuestionNamesAndGrades(@PathVariable("exam-id") int examId){

    }
}
