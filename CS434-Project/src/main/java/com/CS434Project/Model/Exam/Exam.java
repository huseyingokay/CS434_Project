package com.CS434Project.Model.Exam;

import com.CS434Project.Model.Question.Question;
import com.CS434Project.Model.Request.UserType;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_EXAM")
public class Exam implements IExam{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String examName;

    @OneToMany(mappedBy = "exam")
    private List<Question> questions = new ArrayList<>();

    private UserType userType = UserType.AllStudents;

    //region Getters&Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    //endregion
}
