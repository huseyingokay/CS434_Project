package com.CS434Project.Controller;

import com.CS434Project.Model.Request.checkUserRequest;
import com.CS434Project.Model.Response.checkUserResponse;
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
    public checkUserResponse checkLecturer(@RequestBody checkUserRequest request){
        return loginService.checkLecturer(request);
    }
    @PostMapping("/grad")
    public checkUserResponse checkGradStudent(@RequestBody checkUserRequest request){
        return loginService.checkGradStudent(request);
    }
    @PostMapping("/undergrad")
    public checkUserResponse checkUnderGradStudent(@RequestBody checkUserRequest request){
        return loginService.checkUnderGradStudent(request);
    }
}
