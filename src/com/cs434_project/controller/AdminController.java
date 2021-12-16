package com.cs434_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button createExamButton;

    @FXML
    void createExam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../layout/createexam.fxml"));
        Stage stage = (Stage) createExamButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
