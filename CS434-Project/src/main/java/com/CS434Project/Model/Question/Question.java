package com.CS434Project.Model.Question;

import com.CS434Project.Model.Exam.Exam;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "QUESTION_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "QUESTION_TYPE", insertable = false, updatable = false)
    private String questionType;

    @Column(name="EXPLANATION")
    private String questionExplanation;

    @Column(name="ANSWERINDEX")
    private String answer;

    private double questionPoint;

    @ManyToOne
    private Exam exam;

    //region Getters&Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    public double getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(double questionPoint) {
        this.questionPoint = questionPoint;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionExplanation='" + questionExplanation + '\'' +
                ", questionPoint=" + questionPoint +
                ", exam=" + exam +
                '}';
    }
    //endregion
}
