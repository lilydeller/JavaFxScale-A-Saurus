package controllers;
import controllers.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import model.Pitch;
import java.io.IOException;
import javafx.event.ActionEvent;


public class CreateSongController {

    @FXML
    private ListView<String> noteListView;

    @FXML
    private FlowPane noteButtonPane;

    @FXML
    private TextField songNameField;  // TextField for entering the song name

    private ObservableList<String> songElements;

    @FXML
    public void initialize() {
        // Initialize ObservableList for song elements
        songElements = FXCollections.observableArrayList();
        noteListView.setItems(songElements);

        // Ensure the FlowPane is initialized and buttons are added
        createNoteButtons();
    }

    // Method to create note buttons and add them to the FlowPane
    private void createNoteButtons() {
        for (Pitch pitch : Pitch.values()) {
            String label = pitch.name().replace("_SHARP", "♯").replace("FLAT", "♭").replace("_", "");
            Button noteButton = new Button(label);
            noteButton.setMinWidth(80);  // Set a fixed width for buttons
            // Set action on button click to add the corresponding note
            noteButton.setOnAction(e -> addNote(pitch));
            noteButtonPane.getChildren().add(noteButton);  // Add button to FlowPane
        }
    }

    // Method to add a note to the song
    private void addNote(Pitch pitch) {
        String label = pitch.name().replace("_SHARP", "♯").replace("FLAT", "♭").replace("_", "");
        songElements.add("Note: " + label);  // Add note to the song
    }

    // Method to add a new measure
    @FXML
    private void addMeasure() {
        songElements.add("— New Measure —");  // Add a placeholder for a new measure
    }

    // You could add a method to get the song name, if needed
    public String getSongName() {
        return songNameField.getText();

        @FXML
        private void goToPiano() throws IOException {
            App.setRoot("piano"); 
        }
        
    }
}





