package com.CS434Project.Service;

import com.CS434Project.Model.Lecturer.Lecturer;
import com.CS434Project.Model.Request.CheckUserRequest;
import com.CS434Project.Model.Response.CheckUserResponse;
import com.CS434Project.Model.Student.GradStudent;
import com.CS434Project.Model.Student.UnderGradStudent;
import com.CS434Project.Model.User;
import com.CS434Project.Repository.GradRepository;
import com.CS434Project.Repository.LecturerRepository;
import com.CS434Project.Repository.UnderGradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    UnderGradRepository underGradRepository;

    @Autowired
    GradRepository gradRepository;

    public CheckUserResponse checkLecturer(CheckUserRequest request){
        CheckUserResponse response = new CheckUserResponse();
        try{

            User user = (Lecturer)lecturerRepository.findByUsername(request.getUsername());
            response.setValid(userValidate(user, request));
            response.setMessage("ok");
            return response;
        }
        catch(Exception e){
            response.setValid(false);
            return response;
        }
    }

    public CheckUserResponse checkGradStudent(CheckUserRequest request) {
        CheckUserResponse response = new CheckUserResponse();
        try{
            User user = (GradStudent)gradRepository.findByUsername(request.getUsername());
            response.setValid(userValidate(user, request));
            response.setMessage("ok");
            return response;
        }
        catch(Exception e){
            return response;
        }
    }

    public CheckUserResponse checkUnderGradStudent(CheckUserRequest request) {
        CheckUserResponse response = new CheckUserResponse();
        try{
            User user = (UnderGradStudent)underGradRepository.findByUsername(request.getUsername());
            response.setValid(userValidate(user, request));
            response.setMessage("ok");
            return response;
        }
        catch(Exception e){
            return response;
        }
    }

    private boolean userValidate(User user, CheckUserRequest request){
        if(!(user == null) && user.getPassword().equals(request.getPassword())){
            return true;
        }
        else
            return false;
    }
}
