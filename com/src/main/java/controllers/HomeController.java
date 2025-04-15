package controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class HomeController implements Initializable {

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_logout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // to do 
}

    @FXML
    private void onProfileClicked(ActionEvent event) {

        System.out.println("Profile clicked");
    }

    @FXML
    private void onLogoutClicked(ActionEvent event) throws IOException {
        System.out.println("Logging out.");
        App.setRoot("login"); 
    }

        @FXML
        private void handleFindSong(ActionEvent event) throws IOException {
            App.setRoot("songsearch");
        }
        
    }
