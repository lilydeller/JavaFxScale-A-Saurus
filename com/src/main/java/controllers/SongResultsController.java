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

   /*
    * filters songs based on search 
    */
    public static void setResults(List<Song> songs) {
        filteredSongs = songs;
    }

    /*
     * creates and displays a vbox for each song that is filtered 
     */
    @FXML
    public void initialize() {

        resultsContainer.setStyle("-fx-background-color: #fdf5ec;");
        resultsContainer.getChildren().clear();

        if (filteredSongs == null || filteredSongs.isEmpty()) {
            resultsContainer.getChildren().add(new Label("No matching songs found."));
            return;
        }

        for (Song song : filteredSongs) {
            VBox songBox = new VBox();
            songBox.setStyle("-fx-background-color: #D8F9A0;" + "-fx-border-color: #2F4F4F;" + "-fx-border-radius: 10;" + "-fx-background-radius: 10;" + "-fx-padding: 10;");
            songBox.setSpacing(5);

            Label name = new Label(song.getSongName() + " by " + song.getArtist());
            Label difficulty = new Label("Difficulty: " + song.getDifficulty());
            Label length = new Label("Length: " + song.getLength());
            Label genre = new Label("Genre: " + song.getGenre());

            Button play = new Button("Play Along");
    
            Button save = new Button("Save to My Songs");

            play.setStyle(
        "-fx-background-color:rgb(23, 153, 58);" +
        "-fx-background-radius: 8;" +
        "-fx-border-radius: 8;" +
        "-fx-text-fill: black;"
    );

    save.setStyle(
        "-fx-background-color:rgb(23, 153, 58);" +
        "-fx-background-radius: 8;" +
        "-fx-border-radius: 8;" +
        "-fx-text-fill: black;"
    );

            play.setOnAction(e -> {
                MusicAppFacade.getInstance().setCurrentSong(song);
                try {
                    App.setRoot("piano");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

         
            save.setOnAction(e -> {
                MusicAppFacade.getInstance().addSongToCurrentUser(song);
                System.out.println(" Saved: " + song.getSongName());
            });

            HBox buttonRow = new HBox(play,save);
            buttonRow.setSpacing(10);

            songBox.getChildren().addAll(name, difficulty, length, genre, buttonRow);
            resultsContainer.getChildren().add(songBox);
        }
    }

    


    /*
     * moves to song search 
     */
    @FXML
    private void handleBack() throws IOException {
        App.setRoot("songsearch");
    }

    /*
     * moves back to home 
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

/*
 * moves to settings 
 */
@FXML
public void goUser() throws IOException {
    App.setRoot("settings");
}
}
