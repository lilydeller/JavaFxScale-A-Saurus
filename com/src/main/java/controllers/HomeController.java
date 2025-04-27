package controllers;
import controllers.App;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import model.MusicAppFacade;
import model.User;
import music.Music;

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
    
    @FXML
    private Label lbl_username;



    /*
     * displays the currently logged in user on the home screen when loading 
     */
    @FXML
    private Label dinoPointsLabel;



    /*
     * displays the currently logged in user on the home screen when loading 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    refreshHomeScreen();
}


public void refreshHomeScreen() {
    User currentUser = MusicAppFacade.getInstance().getCurrentUser();

    if (currentUser != null) {
        lbl_username.setText("Welcome, " + currentUser.getUserName() + "!");
        dinoPointsLabel.setText(currentUser.getDinoPoints() + " Dino Points ⭐");
    } else {
        lbl_username.setText("Welcome! ");
        dinoPointsLabel.setText("0 Dino Points ⭐");
    }
}

    @FXML
    private void onProfileClicked(ActionEvent event) {

        System.out.println("Profile clicked");
    }

    /*
     * logs current user out and returns to login 
     */
    @FXML
    private void onLogoutClicked(ActionEvent event) throws IOException {
        System.out.println("Logging out.");
        App.setRoot("login"); 
    }

    @FXML
    private void handleChooseReward() {
        System.out.println("Choose reward clicked!");
        /*
         * TODO reward screen
         */
    }
    
    /*
     * moves to songsearch screen 
     */
    @FXML
    private void handleFindSong() throws IOException {
        App.setRoot("songsearch");
    }
    
    /*
     * moves to create song screen
     */
    @FXML
    private void handleCreateSong() throws IOException {
        App.setRoot("createsong");
    }
    
    /*
     * moves to piano screen 
     */
    @FXML
    private void handleContinueLastSong() throws IOException {
        App.setRoot("piano"); 
    }
    
    /*
     * moves to lessonfolder screen 
     */
    @FXML
    private void handleViewAllLessons() throws IOException {
        App.setRoot("lessonfolder")
    }
    
    /*
     * moves to leader board screen 
     */
    @FXML
    private void handleViewLeaderboard() throws IOException {
        App.setRoot("leaderboard");
    }

        
}