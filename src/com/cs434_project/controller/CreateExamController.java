package com.cs434_project.controller;

import com.cs434_project.model.Question.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateExamController {

    @FXML
    private Button addQuestionButton;

    @FXML
    private ComboBox<String> questionTypesCombo;

    @FXML
    private TextField examName;

    @FXML
    private Label examNameLabel;

    @FXML
    void addQuestion(ActionEvent event) throws IOException {
        int questionId = questionTypesCombo.getSelectionModel().getSelectedIndex();
        switch (questionId){
            case 1:
                //create multichoice
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                //nullquestion
        }
    }

    @FXML
    void onChangeExamName(ActionEvent event) {
        this.examNameLabel.setText(examName.getText());
    }

}
