package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class HomeController {

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_logout;

    @Override
    public void initialize(URL location, ResourceBundle resources) { ... }

    @FXML
    private void onProfileClicked(ActionEvent event) {

        System.out.println("Profile clicked");
    }

    @FXML
    private void onLogoutClicked(ActionEvent event) throws IOException {
        System.out.println("Logging out.");
        App.setRoot("login"); 
    }
}
