package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import model.MusicAppFacade;
import model.Song;

import java.io.IOException;
import java.util.List;

public class SongSearchController {
    private static List<Song> searchResults;


    @FXML private TextField txt_search;


    private String selectedLetterRange = "All";
    private String selectedGenre = "All";
    private String selectedDifficulty = "All";

 
    private Button selectedLetterButton;
    private Button selectedGenreButton;
    private Button selectedDifficultyButton;


    /*
     * filters songs based on selected letter 
     */
    @FXML
    private void handleLetterFilter(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        if (selectedLetterButton != null) {
            selectedLetterButton.getStyleClass().remove("selected-filter");
        }
        clicked.getStyleClass().add("selected-filter");
        selectedLetterButton = clicked;
        selectedLetterRange = clicked.getText();
    }


    /*
     * filters songs based on genre 
     */
    @FXML
    private void handleGenreFilter(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        if (selectedGenreButton != null) {
            selectedGenreButton.getStyleClass().remove("selected-filter");
        }
        clicked.getStyleClass().add("selected-filter");
        selectedGenreButton = clicked;
        selectedGenre = clicked.getText();
    }

    /*
     * filter songs based on diffculty 
     */
    @FXML
    private void handleDifficultyFilter(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        if (selectedDifficultyButton != null) {
            selectedDifficultyButton.getStyleClass().remove("selected-filter");
        }
        clicked.getStyleClass().add("selected-filter");
        selectedDifficultyButton = clicked;
        selectedDifficulty = clicked.getText();
    }

    /*
     * searches songs based on the filter settings 
     */
    @FXML
    private void handleSearch(ActionEvent e) throws Exception {
        String query = txt_search.getText().trim();

    
       
        int difficultyRange;
        switch (selectedDifficulty) {
            case "1–4":
                difficultyRange = 1;
                break;
            case "5–10":
                difficultyRange = 2;
                break;
            default:
                difficultyRange = 0; 
                break;
        }
    
        List<Song> results = MusicAppFacade.getInstance().filterSongs(
            query,
            selectedLetterRange,
            selectedGenre,
            difficultyRange
        );
    
        //displays results on song result screen after feeding it the filterd songs 
        SongResultsController.setResults(results);
        App.setRoot("songresults");
    }
    

    /*
     * moves to home 
     */
    @FXML
    private void handleBack() throws Exception {
        App.setRoot("home");
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

/*
 * moves to settings 
 */
@FXML
public void goUser() throws IOException {
    App.setRoot("settings");
}
}
