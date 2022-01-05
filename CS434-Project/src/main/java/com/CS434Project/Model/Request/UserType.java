package com.CS434Project.Model.Request;

import com.CS434Project.Model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {
    Admin("admin"), GradStudent("grad"), UnderGradStudent("undergrad"), AllStudents("all") ;
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
