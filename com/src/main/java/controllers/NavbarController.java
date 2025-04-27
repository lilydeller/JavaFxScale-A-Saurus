package controllers;

import javafx.fxml.FXML;
import controllers.App;

import java.io.IOException;

public class NavbarController {

    /*
     * moves to home 
     */
    @FXML
    public void goHome() throws IOException {
        App.setRoot("home");
    }

    /*
     * moves to song search 
     */
    @FXML
    public void goFindSong() throws IOException {
        App.setRoot("songsearch");  
    }

    /*
     * moves to lessons folder
     */
    @FXML
    public void goLessons() throws IOException {
        App.setRoot("lessonfolder");
    }

    /*
     * moves to settings 
     */
    @FXML
    public void goUser() throws IOException {
        App.setRoot("settings");
    }
}
