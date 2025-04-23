package controllers;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class SettingsController {

    @FXML
    private void goToHome(ActionEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void goToEditProfile(ActionEvent event) throws IOException {
        App.setRoot("edit profile");  
    }

    @FXML
    private void goToSavedSongs(ActionEvent event) throws IOException {
        App.setRoot("your saved songs");  
    }

    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        App.setRoot("add a friend");  
    }



    @FXML
    private void logout(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
public void goHome() throws IOException {
    App.setRoot("home");
}

@FXML
public void goSongs() throws IOException {
    App.setRoot("songssearch");
}

@FXML
public void goLessons() throws IOException {
    App.setRoot("lessonfolder");
}

@FXML
public void goUser() throws IOException {
    App.setRoot("userprofile");
}

}
