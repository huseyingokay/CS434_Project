package com.CS434Project.Service;

import com.CS434Project.Model.Request.CreateExamRequest;
import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Model.Response.GetExamListResponse;
import com.CS434Project.Model.Response.GetExamResponse;
import com.CS434Project.Model.Response.GetExamResultResponse;

import java.util.List;

public interface IExamService {
    public CreateExamResponse createExam(CreateExamRequest request);
    GetExamResponse getExam(int examId);
    GetExamResultResponse getExamResult(int examId, int studentId);
    GetExamListResponse getExamList(String userType);
}
