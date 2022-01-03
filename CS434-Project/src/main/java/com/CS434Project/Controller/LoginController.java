package com.CS434Project.Controller;

import com.CS434Project.Model.Request.CheckUserRequest;
import com.CS434Project.Model.Response.CheckUserResponse;
import com.CS434Project.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/lecturer")
    public CheckUserResponse checkLecturer(@RequestBody CheckUserRequest request){
        return loginService.checkLecturer(request);
    }
    @PostMapping("/grad")
    public CheckUserResponse checkGradStudent(@RequestBody CheckUserRequest request){
        return loginService.checkGradStudent(request);
    }
    @PostMapping("/undergrad")
    public CheckUserResponse checkUnderGradStudent(@RequestBody CheckUserRequest request){
        return loginService.checkUnderGradStudent(request);
    }
}
