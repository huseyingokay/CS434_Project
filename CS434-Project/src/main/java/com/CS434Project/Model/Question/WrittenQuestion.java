package com.CS434Project.Model.Question;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("WRITTEN")
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
}
