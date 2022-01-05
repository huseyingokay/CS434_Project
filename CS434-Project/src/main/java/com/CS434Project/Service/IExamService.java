package com.CS434Project.Service;

import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Model.Response.GetExamResponse;

import java.util.List;

public interface IExamService {
    public CreateExamResponse createExam();
    GetExamResponse getExam(int examId);
    double getExamResult(int examId, int studentId);
    List<String> getExamList(UserType userType);
}
