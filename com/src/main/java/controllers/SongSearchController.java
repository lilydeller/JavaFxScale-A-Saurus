package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SongSearchController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchBtn;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_findMatches;

    @FXML
    private void handleSearch() {
        String searchTerm = searchField.getText();
        System.out.println("Searching for: " + searchTerm);
        /*
         * filtering 
         */
    }

    @FXML
    private void handleFindMatches() {
        System.out.println("Finding matches...");
        /*
         * matching logic 
         */
    }

    @FXML
    private void handleBack() throws IOException {
        App.setRoot("home");
    }
}
