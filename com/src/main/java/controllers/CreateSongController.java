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
           // Measure measure = new Measure(measureNumber++, Chord.fromString(currentChord));
           // measures.add(measure);
            songElements.add("— New Measure —");
            currentChord.clear();
        } else {
            songElements.add("⚠️ Measure skipped: no notes");
        }
    }

    @FXML
    private void saveSong() {
        String name = songNameField.getText().trim();
        if (name.isEmpty() || measures.isEmpty()) {
            System.out.println("⚠️ Please enter a song name and at least one measure.");
            return;
        }

        Song newSong = new Song(
                UUID.randomUUID().toString(),
                name,
                1,                      // default difficulty
                "1:00",                 // default length
                "Custom",               // default genre
                measures,
                "",                     // default sheet music
                "",                     // default tabs
                false,                  // default metronome
                "Unknown"               // default artist
        );

        SongList.getInstance().addSong(newSong);
        SongList.getInstance().saveSongs();

        System.out.println("Song saved: " + newSong.getSongName());
    }

    @FXML
    private void goToPiano() throws IOException {
        App.setRoot("piano");
    }
}
