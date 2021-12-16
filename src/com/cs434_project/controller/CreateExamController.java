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

    private int index = 1;

    @FXML
    void addQuestion(ActionEvent event) throws IOException {
        examArea.setPannable(true);
        int questionId = questionTypesCombo.getSelectionModel().getSelectedIndex();

        switch (questionId){
            case 0:
                FXMLLoader root = new FXMLLoader(getClass().getResource("../layout/MultiChoiceQuestion.fxml"));
                Pane pane = root.load();

                pane.setId("pane" + index);

                MultiChoiceQuestionController controller = root.getController();
                controller.setTextToLabel("Question " + index);
                vbox.getChildren().add(pane);
                examArea.setContent(vbox);
                index++;
                break;
            case 1:
                FXMLLoader root2 = new FXMLLoader(getClass().getResource("../layout/TrueFalseQuestion.fxml"));
                Pane pane2 = root2.load();

                pane2.setId("pane" + index);

                TrueFalseQuestionController controller2 = root2.getController();
                controller2.setTextToLabel("Question " + index);
                vbox.getChildren().add(pane2);
                examArea.setContent(vbox);
                index++;
                break;
            case 2:
                FXMLLoader root3 = new FXMLLoader(getClass().getResource("../layout/WrittenQuestion.fxml"));
                Pane pane3 = root3.load();

                pane3.setId("pane" + index);

                WrittenQuestionController controller3 = root3.getController();
                controller3.setTextToLabel("Question " + index);
                vbox.getChildren().add(pane3);
                examArea.setContent(vbox);
                index++;
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
