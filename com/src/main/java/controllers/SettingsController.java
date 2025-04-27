package controllers;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class SettingsController {

    /*
     * goes back to home 
     */
    @FXML
    private void goToHome(ActionEvent event) throws IOException {
        App.setRoot("home");
    }

    /*
     * moves to edit profile screen 
     */
    @FXML
    private void goToEditProfile(ActionEvent event) throws IOException {
        App.setRoot("edit profile");  
    }

    /*
     * moves to saved songs 
     */
    @FXML
    private void goToSavedSongs(ActionEvent event) throws IOException {
        App.setRoot("your saved songs");  
    }

    /*
     * moves to add a friend screen 
     */
    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        App.setRoot("add a friend");  
    }



    /*
     * moves to login screen
     */
    @FXML
    private void logout(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    /*
     * moves to home screen 
     */
    @FXML
public void goHome() throws IOException {
    App.setRoot("home");
}

/*
 * moves to song search screen
 */
@FXML
public void goSongs() throws IOException {
    App.setRoot("songssearch");
}

/*
 * moves to lesson folder 
 */
@FXML
public void goLessons() throws IOException {
    App.setRoot("lessonfolder");
}

/*
 * moves to users profile 
 */
@FXML
public void goUser() throws IOException {
    App.setRoot("userprofile");
}

}
