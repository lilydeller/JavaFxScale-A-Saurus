package controllers;

import javafx.fxml.FXML;
import controllers.App;

import java.io.IOException;

public class NavbarController {

    @FXML
    public void goHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    public void goFindSong() throws IOException {
        App.setRoot("songsearch");  
    }

    @FXML
    public void goLessons() throws IOException {
        App.setRoot("lessonfolder");
    }

    @FXML
    public void goUser() throws IOException {
        App.setRoot("settings");
    }
}
