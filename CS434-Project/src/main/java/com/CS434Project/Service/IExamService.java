package com.CS434Project.Service;

import com.CS434Project.Model.Response.CreateExamResponse;
import com.CS434Project.Model.Response.GetExamResponse;

public interface IExamService {
    public CreateExamResponse createExam();
    GetExamResponse getExam(int examId);
    double getExamResult(int examId, int studentId);
}
