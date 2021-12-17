package com.cs434_project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class TrueFalseQuestionController {

    @FXML
    private RadioButton choiceA;

    @FXML
    private RadioButton choiceB;

    @FXML
    private TextField questionField;

    @FXML
    private Label questionId = new Label();

    public void setTextToLabel (String text) {
        questionId.setText(text);
    }

}
