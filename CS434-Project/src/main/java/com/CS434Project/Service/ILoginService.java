package com.CS434Project.Service;

import com.CS434Project.Model.Request.CheckUserRequest;
import com.CS434Project.Model.Response.CheckUserResponse;

public interface ILoginService {
    CheckUserResponse checkLecturer(CheckUserRequest request);
    CheckUserResponse checkGradStudent(CheckUserRequest request);
    CheckUserResponse checkUnderGradStudent(CheckUserRequest request);
}
