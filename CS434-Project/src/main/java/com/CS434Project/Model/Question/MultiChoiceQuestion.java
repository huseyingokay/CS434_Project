package com.CS434Project.Model.Question;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MULTICHOICE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class MultiChoiceQuestion extends Question{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name="ANSWERINDEX")
    private int answerIndex;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
}
