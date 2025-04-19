package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import model.MusicAppFacade;
import model.Song;

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
    
        SongResultsController.setResults(results);
        App.setRoot("songresults");
    }
    

    @FXML
    private void handleBack() throws Exception {
        App.setRoot("home");
    }
}
