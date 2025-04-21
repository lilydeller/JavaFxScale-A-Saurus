package controllers;

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

    @FXML
    public void initialize() {
        currentUser = MusicAppFacade.getInstance().getCurrentUser();
        loadUserSongs();
    }

    private void loadUserSongs() {
        savedSongsListView.getItems().clear();
        for (Song song : currentUser.getSavedSongs()) {
            savedSongsListView.getItems().add(song.getSongName() + " by " + song.getArtist());
        }
    }

    

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
}
