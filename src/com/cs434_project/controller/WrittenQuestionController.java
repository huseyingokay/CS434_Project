package com.cs434_project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WrittenQuestionController {

    @FXML
    private TextField answerField;

    @FXML
    private TextField questionField;

    @FXML
    private Label questionId = new Label();

    public void setTextToLabel (String text) {
        questionId.setText(text);
    }

}
