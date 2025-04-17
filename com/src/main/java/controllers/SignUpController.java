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
    private TextField txt_username;
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
    private Label lbl_error;

    @FXML
    private void btnSignUpClicked(ActionEvent event) throws IOException {
        handleSignUp();
        
    }
    @FXML
    private void handleSignUp() throws IOException {
        String username = txt_username.getText().trim();
        String firstName = txt_firstname.getText().trim();
        String lastName = txt_lastname.getText().trim();
        String email = txt_email.getText().trim();
        String password = txt_password.getText().trim();

        if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            lbl_error.setText("All boxes must be filled");
            return;
        }

        //checks if username is taken 
        if (UserList.getInstance().isUsernameTaken(username)) {
            lbl_error.setText("Username is taken");
            return;
        }

        MusicAppFacade facade = MusicAppFacade.getInstance();
        User newUser = facade.signup(username, email, password);

        if (newUser == null) {
            lbl_error.setText("Sign up failed");
            return;
        }

        facade.addUserInfo(firstName, lastName);
        App.setRoot("home");
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("login");
    }
}