package com.CS434Project.Service;

import com.CS434Project.Model.Answer.Answer;
import com.CS434Project.Model.Dto.ExamDTO;
import com.CS434Project.Model.Dto.NullExamDTO;
import com.CS434Project.Model.Dto.QuestionDTO;
import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.Question;
import com.CS434Project.Model.Request.CreateExamRequest;
import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Response.GetExamResponse;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Repository.AnswerRepository;
import com.CS434Project.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService implements IExamService{
    @Autowired
    ExamRepository examRepository;

    @Autowired
    AnswerRepository answerRepository;

    public CreateExamResponse createExam(CreateExamRequest request){
        Exam exam = new Exam();
        exam.setExamName(request.getExamName());
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

    public double getExamResult(int examId, int studentId) {
        Exam requestedExam = examRepository.findById(examId).get();
        List<Answer> answers = answerRepository.findByStudentIdAndExamId(studentId,examId);
        double totalScore = 0.0;

        for(int i=0; i<requestedExam.getQuestions().size(); i++){
            Question currentQuestion = requestedExam.getQuestions().get(i);
            Answer studentAnswer = answers.stream().filter(answer ->
                answer.getQuestionId() == currentQuestion.getId()
            ).findAny().get();

            if(currentQuestion.getAnswer().equals(studentAnswer.getAnswer())){
                totalScore += requestedExam.getQuestions().get(i).getQuestionPoint();
            }
        }
        return totalScore;
    }

    public List<String> getExamList(String userType){
        List<String> examList = new ArrayList<>();
        //examList = examRepository.findExamNameByUserType(userType);
        examList.addAll(examRepository.findExamNameByUserType(UserType.AllStudents));
        return examList;
    }
}
