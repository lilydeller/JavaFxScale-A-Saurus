package controllers;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import model.User;
import model.UserList;
import model.MusicAppFacade;
public class SignUpController {
    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_password;
    @FXML
    private Button btn_signup;
    @FXML 
    private Button btn_back;

    @FXML
    private void btnSignUpClicked(ActionEvent event) throws IOException {

        
    }
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
    @FXML 
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    

}
