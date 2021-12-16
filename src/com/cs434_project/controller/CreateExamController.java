package com.cs434_project.controller;

import com.cs434_project.model.Exam.Exam;
import com.cs434_project.model.Question.MultiChoiceQuestion;
import com.cs434_project.model.Question.Question;
import com.sun.glass.ui.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

    private Exam exam;

    @FXML
    private ScrollPane examArea;

    private VBox vbox = new VBox();

    @FXML
    void addQuestion(ActionEvent event) throws IOException {
        int index = 1;
        examArea.setPannable(true);
        int questionId = questionTypesCombo.getSelectionModel().getSelectedIndex();
        System.out.println(questionId);
        switch (questionId){
            case 0:
                Pane root = FXMLLoader.load(getClass().getResource("../layout/MultiChoiceQuestion.fxml"));
                root.setId("pane" + index);

                vbox.getChildren().add(root);
                examArea.setContent(vbox);
                index++;
                break;
            case 1:
                Pane root2 = FXMLLoader.load(getClass().getResource("../layout/MultiChoiceQuestion.fxml"));
                root2.setId("pane" + index);

                vbox.getChildren().add(root2);
                examArea.setContent(vbox);
                index++;
                break;
            case 2:
                break;
            default:
                //nullquestion
        }
    }

    @FXML
    void onChangeExamName(ActionEvent event) {
        this.examNameLabel.setText(examName.getText());
    }

    @FXML
    void saveExam(ActionEvent event) {

    }


}
