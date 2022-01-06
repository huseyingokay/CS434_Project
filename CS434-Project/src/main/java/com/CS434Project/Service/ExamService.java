package com.CS434Project.Service;

import com.CS434Project.Model.Answer.Answer;
import com.CS434Project.Model.Dto.ExamAndIdDto;
import com.CS434Project.Model.Dto.ExamDTO;
import com.CS434Project.Model.Dto.NullExamDTO;
import com.CS434Project.Model.Dto.QuestionDTO;
import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.MultiChoiceQuestion;
import com.CS434Project.Model.Question.Question;
import com.CS434Project.Model.Request.CreateExamRequest;
import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Response.GetExamListResponse;
import com.CS434Project.Model.Response.GetExamResponse;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Model.Response.GetExamResultResponse;
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

            if(!foundExam.getQuestions().isEmpty()) {
                foundExam.getQuestions().forEach((question -> {
                    QuestionDTO questionDTO = new QuestionDTO();
                    questionDTO.setId(question.getId());
                    questionDTO.setQuestionPoint(question.getQuestionPoint());
                    questionDTO.setQuestionExplanation(question.getQuestionExplanation());
                    questionDTO.setQuestionType(question.getQuestionType());
                    if(question.getQuestionType().equals("MULTICHOICE")){
                        MultiChoiceQuestion multiChoiceQuestion = (MultiChoiceQuestion) question;
                        questionDTO.setChoices(multiChoiceQuestion.getChoices());
                    }

                    examDTO.addQuestion(questionDTO);
                }));
                response.setExamDTO(examDTO);
            }
        }
        return response;
    }

    public GetExamResultResponse getExamResult(int examId, int studentId) {
        Exam requestedExam = examRepository.findById(examId).get();
        List<Answer> answers = answerRepository.findByStudentIdAndExamId(studentId,examId);
        GetExamResultResponse response = new GetExamResultResponse();
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
        response.setResult(totalScore);
        return response;
    }

    public GetExamListResponse getExamList(String userType){
        List<ExamAndIdDto> examDtoList = new ArrayList<>();
        List<Exam> examList = new ArrayList<>();

        examList.addAll(examRepository.findExamNameByUserType(UserType.AllStudents));
        examList.forEach(exam -> {
            ExamAndIdDto examDto = new ExamAndIdDto();
            examDto.setExamId(exam.getId());
            examDto.setExamName(exam.getExamName());
            examDtoList.add(examDto);
        });
        GetExamListResponse response = new GetExamListResponse();
        response.setExamList(examDtoList);
        return response;
    }
}
