package com.CS434Project.Model.Question;

import javax.persistence.*;

@Entity
@Table(name = "T_TRUEFALSEQUESTION")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TrueFalseQuestion extends Question{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name="ANSWER")
    private boolean answer;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
