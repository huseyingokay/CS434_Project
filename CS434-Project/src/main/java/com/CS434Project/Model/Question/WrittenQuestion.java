package com.CS434Project.Model.Question;

import javax.persistence.*;

@Entity
@Table(name = "T_WRITTENQUESTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WrittenQuestion extends Question{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name="ANSWER")
    private String answer;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
