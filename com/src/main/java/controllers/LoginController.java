package controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;


import model.User;
import model.UserList;
import model.MusicAppFacade;

public class LoginController {

    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;
    @FXML
    private Button btn_login;    
    @FXML
    private Button btn_signup;
    @FXML
    private Button back;        

   
    @FXML
private void btnLoginClicked(ActionEvent event) throws IOException {
    String username = txt_username.getText();
    String password = txt_password.getText();

    User user = UserList.getInstance().getUser(username, password);
    if (user != null) {
        App.setRoot("home");
    } else {
        lbl_error.setText("invalid login");
    }
}


   
    @FXML
    private void switchToSignUp() throws IOException {
        App.setRoot("signup");
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    
}
