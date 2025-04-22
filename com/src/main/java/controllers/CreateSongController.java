package controllers;

import controllers.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class CreateSongController {

    @FXML
    private ListView<String> noteListView;

    @FXML
    private FlowPane noteButtonPane;

    @FXML
    private TextField songNameField;

    private ObservableList<String> songElements;

    private ArrayList<Measure> measures = new ArrayList<>();
    private ArrayList<String> currentChord = new ArrayList<>();
    private int measureNumber = 1;

    @FXML
    public void initialize() {
        songElements = FXCollections.observableArrayList();
        noteListView.setItems(songElements);
        createNoteButtons();
    }

    private void createNoteButtons() {
        for (Pitch pitch : Pitch.values()) {
            String label = pitch.name().replace("_SHARP", "♯").replace("FLAT", "♭").replace("_", "");
            Button noteButton = new Button(label);
            noteButton.setMinWidth(80);
            noteButton.setOnAction(e -> addNote(pitch));
            noteButtonPane.getChildren().add(noteButton);
        }
    }

    private void addNote(Pitch pitch) {
        String label = pitch.name().replace("_SHARP", "♯").replace("FLAT", "♭").replace("_", "");
        songElements.add("Note: " + label);
        currentChord.add(label);
    }

    @FXML
private void addMeasure() {
    if (!currentChord.isEmpty()) {

        Chord chord = Chord.fromLabels(currentChord);

     
        ArrayList<Chord> chords = new ArrayList<>();
        chords.add(chord);
        Measure measure = new Measure(measureNumber++, chords);


        measures.add(measure);
        songElements.add("— New Measure —");

      
        currentChord.clear();
    } else {
        songElements.add("Measure skipped: no notes");
    }
}


   @FXML
private void saveSong() {
    String name = songNameField.getText().trim();
    if (name.isEmpty() || measures.isEmpty()) {
        System.out.println("Please enter a song name and at least one measure.");
        return;
    }

    User currentUser = MusicAppFacade.getInstance().getCurrentUser();
    String artist = currentUser.getUserName();


    MusicAppFacade.getInstance().createAndSaveSong(
        name,
        artist,
        1,          
        "1:00",     
        "Custom",  
        measures
    );
}
    

    @FXML
    private void goToPiano() throws IOException {
        App.setRoot("piano");
    }
}
