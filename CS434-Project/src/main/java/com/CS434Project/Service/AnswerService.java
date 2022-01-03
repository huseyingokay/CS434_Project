package com.CS434Project.Service;

import com.CS434Project.Model.Answer.Answer;
import com.CS434Project.Model.Request.AddAnswerRequest;
import com.CS434Project.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public void addAnswer(AddAnswerRequest request) {
        Answer answer = new Answer();
        answer.setAnswer(request.getAnswer());
        answer.setQuestionId(request.getQuestionId());
        answer.setStudentId(request.getStudentId());
        answer.setExamId(request.getExamId());
        answerRepository.save(answer);
    }
}
