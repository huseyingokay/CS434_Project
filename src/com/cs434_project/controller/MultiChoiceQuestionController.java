package com.cs434_project.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MultiChoiceQuestionController implements Initializable {

    @FXML
    private RadioButton choiceA;

    @FXML
    private TextField choiceAAnswer;

    @FXML
    private RadioButton choiceB;

    @FXML
    private TextField choiceBAnswer;

    @FXML
    private RadioButton choiceC;

    @FXML
    private TextField choiceCAnswer;

    @FXML
    private RadioButton choiceD;

    @FXML
    private TextField choiceDAnswer;

    @FXML
    private TextField questionField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Label questionId = new Label();

    public void setTextToLabel (String text) {
        questionId.setText(text);
    }
}
