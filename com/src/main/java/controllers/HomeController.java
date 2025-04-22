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
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane mainContent;
    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_logout;
    @FXML
    private Label lbl_username;

    @FXML
    private Button btn_home;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_settings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User currentUser = MusicAppFacade.getInstance().getCurrentUser();
        loadNavBar();
        highlightHomeButton();

        if (currentUser != null) {
            lbl_username.setText("Welcome, " + currentUser.getUserName() + "!");
        } else {
            lbl_username.setText("Welcome!");
        }
    }

    private void loadNavBar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resources\\scaleasaurus\\navbar.fxml"));
            HBox navbar = loader.load();
            mainContent.getChildren().add(navbar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void highlightHomeButton() {
        btn_home.getStyleClass().add("highlighted");
        btn_create.getStyleClass().remove("highlighted");
        btn_settings.getStyleClass().remove("highlighted");
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
    private void handleChooseReward() {
        System.out.println("Choose reward clicked!");
        // TODO: reward screen
    }

    @FXML
    private void handleFindSong() throws IOException {
        App.setRoot("songsearch");
    }

    @FXML
    private void handleCreateSong() throws IOException {
        App.setRoot("createsong");
    }

    @FXML
    private void handleContinueLastSong() throws IOException {
        App.setRoot("piano");
    }

    @FXML
    private void handleViewAllLessons() throws IOException {
        App.setRoot("lessonfolder");
    }

    @FXML
    private void handleHomeClick() {
        highlightHomeButton();
        // Optionally, navigate to the Home screen if needed (though this is already the Home screen)
    }

    @FXML
    private void handleCreateClick() {
        btn_create.getStyleClass().add("highlighted");
        btn_home.getStyleClass().remove("highlighted");
        btn_settings.getStyleClass().remove("highlighted");
        // Navigate to the Create screen
        try {
            App.setRoot("createsong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSettingsClick() {
        btn_settings.getStyleClass().add("highlighted");
        btn_home.getStyleClass().remove("highlighted");
        btn_create.getStyleClass().remove("highlighted");
        // Navigate to the Settings screen
        try {
            App.setRoot("settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
