package com.CS434Project.Model.Question;

import com.CS434Project.Model.Exam.Exam;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name="EXPLANATION")
    private String questionExplanation;

    private double questionPoint;

    private QuestionType questionType;

    @ManyToOne
    private Exam exam;

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

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionExplanation='" + questionExplanation + '\'' +
                ", questionPoint=" + questionPoint +
                ", questionType=" + questionType +
                ", exam=" + exam +
                '}';
    }
}
