package com.example;

import java.io.IOException;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private Label display;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void sign() {
        if (!DatabaseConnection.checkUser(emailField.getText())) {
            if (!emailField.getText().contains("@")) {
                display.setText("Wrong email");
                return;
            }
            DatabaseConnection.add(nameField.getText(), emailField.getText(), passwordField.getText());
            display.setText("Hello, " + nameField.getText());
        } else {
            display.setText("This user already exist");
        }
    }

    @FXML
    public void logIn() throws IOException {
        App.setRoot("secondary");
    }
}
