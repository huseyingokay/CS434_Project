package com.CS434Project.Model.Request;

import com.CS434Project.Model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {
    Admin("ADMIN"), GradStudent("GRADSTUDENT"), UnderGradStudent("UNDERGRADSTUDENT");
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

    @JsonCreator
    public static UserType getDepartmentFromCode(String value) {

        for (UserType dep : UserType.values()) {

            if (dep.getUserType().equals(value)) {
                return dep;
            }
        }

        return null;
    }
}
