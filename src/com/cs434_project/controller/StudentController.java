package com.cs434_project.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;


public class StudentController {

    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;

    @FXML
    private ListView<String> examList;

    @FXML
    private Label examListLabel;

    @FXML
    private AnchorPane studentAnchorPane;


    @FXML
    void startExam(MouseEvent event) throws IOException {
        int selectedExamId = examList.getSelectionModel().getSelectedIndex();
        if (event.getClickCount() == 2) {
            Parent root = FXMLLoader.load(getClass().getResource("../layout/ExamPopup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void clickedNo(ActionEvent event) {
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void clickedYes(ActionEvent event) throws IOException {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.hide();
        Stage mainStage = new Stage();
        mainStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("../layout/Exam.fxml"));
        mainStage.setScene(new Scene(root));

    }

}
