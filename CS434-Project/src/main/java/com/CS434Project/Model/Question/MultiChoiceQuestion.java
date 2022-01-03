package com.CS434Project.Model.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MULTICHOICE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class MultiChoiceQuestion extends Question{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @ElementCollection
    private List<String> choices = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
