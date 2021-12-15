package com.cs434_project.model.Student;

public abstract class Student {
    private int studentId;
    private String studentName;
    private String password;

    public Student(int studentId, String studentName, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
    }
}
