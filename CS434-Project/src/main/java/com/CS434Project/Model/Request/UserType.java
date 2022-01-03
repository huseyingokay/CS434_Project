package com.CS434Project.Model.Request;

import com.CS434Project.Model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {
    Admin("ADMIN"), GradStudent("GRADSTUDENT"), UnderGradStudent("UNDERGRADSTUDENT"), AllStudents("ALLSTUDENTS") ;
    private final String text;

    UserType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getUserType() {
        return this.text;
    }

}
