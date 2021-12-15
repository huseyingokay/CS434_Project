package com.cs434_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button adminLogin;

    @FXML
    private TextField adminPassword;

    @FXML
    private TextField adminUserName;

    @FXML
    private Button studentLogin;

    @FXML
    private TextField studentPassword;

    @FXML
    private TextField studentUserName;

    @FXML
    void loginAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../layout/admin.fxml"));
        Stage stage = (Stage) adminUserName.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void loginStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../layout/student.fxml"));
        Stage stage = (Stage) adminUserName.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
