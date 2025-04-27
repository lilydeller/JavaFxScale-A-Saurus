package controllers;

import java.io.IOException;

/*
 * TODO NEED A SET ROOT - WHERE TO GO FROM HERE 
 */
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import model.MusicAppFacade;
import model.Song;
import model.User;

public class SavedSongsController {

    @FXML
    private ListView<String> savedSongsListView;

    @FXML
    private Button backButton, viewButton;

    private User currentUser;

    /*
     * takes current user and loads songs by user 
     */
    @FXML
    public void initialize() {
        currentUser = MusicAppFacade.getInstance().getCurrentUser();
        loadUserSongs();
    }

    /*
     * loads songs from saved song list 
     */
    private void loadUserSongs() {
        savedSongsListView.getItems().clear();
        for (Song song : currentUser.getSavedSongs()) {
            savedSongsListView.getItems().add(song.getSongName() + " by " + song.getArtist());
        }
    }

    

    /*
     * sets selected song as current song 
     */
    @FXML
    private void handleViewSong() {
        int selectedIndex = savedSongsListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Song selectedSong = currentUser.getSavedSongs().get(selectedIndex);
            MusicAppFacade.getInstance().setCurrentSong(selectedSong);
        
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a song to view.");
            alert.showAndWait();
        }
    }

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

/*moves to settings  */
@FXML
public void goUser() throws IOException {
    App.setRoot("settings");
}
}
