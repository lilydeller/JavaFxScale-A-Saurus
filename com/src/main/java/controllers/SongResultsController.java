package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.MusicAppFacade;
import model.Song;

import java.io.IOException;
import java.util.List;

public class SongResultsController {

    @FXML private VBox resultsContainer;

    private static List<Song> filteredSongs;

   
    public static void setResults(List<Song> songs) {
        filteredSongs = songs;
    }

    
    @FXML
    public void initialize() {
        resultsContainer.getChildren().clear();

        if (filteredSongs == null || filteredSongs.isEmpty()) {
            resultsContainer.getChildren().add(new Label("No matching songs found."));
            return;
        }

        for (Song song : filteredSongs) {
            VBox songBox = new VBox();
            songBox.setStyle("-fx-background-color: #D8F9A0; -fx-border-color: #2F4F4F; -fx-padding: 10;");
            songBox.setSpacing(5);

            Label name = new Label(song.getSongName() + " by " + song.getArtist());
            Label difficulty = new Label("Difficulty: " + song.getDifficulty());
            Label length = new Label("Length: " + song.getLength());
            Label genre = new Label("Genre: " + song.getGenre());

            Button play = new Button("Play Along");
            Button sheet = new Button("View Sheet Music");
            Button save = new Button("Save to My Songs");

            play.setOnAction(e -> MusicAppFacade.getInstance().openSong(song.getSongName()));
            sheet.setOnAction(e -> {
                /*
                 * lily TODOopen sheet music file 
                 */
                System.out.println("Viewing: " + song.getSheetMusic());
            });
            save.setOnAction(e -> {
                /*
                 * TODO implement saving song to user prof
                 */
                System.out.println("Saved song: " + song.getSongName());
            });

            HBox buttonRow = new HBox(play, sheet, save);
            buttonRow.setSpacing(10);

            songBox.getChildren().addAll(name, difficulty, length, genre, buttonRow);
            resultsContainer.getChildren().add(songBox);
        }
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("songsearch");
    }
}
