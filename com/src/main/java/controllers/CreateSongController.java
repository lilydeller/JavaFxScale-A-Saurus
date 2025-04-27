package controllers;

import controllers.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class CreateSongController {

@FXML
private TextField songNameField;

@FXML
private ComboBox<String> measuresDropdown;

@FXML
private ComboBox<String> difficultyDropdown;

@FXML
private ComboBox<String> genreDropdown;

@FXML
private TextField durationField;

@FXML
private ListView<String> notesListView;

    private ObservableList<String> songElements;

    private ArrayList<Measure> measures = new ArrayList<>();
    private ArrayList<String> currentChord = new ArrayList<>();
    private int measureNumber = 1;

 
    @FXML
    public void initialize() {
        songElements = FXCollections.observableArrayList();
        measuresDropdown.getItems().addAll("4", "8", "12", "16");
        difficultyDropdown.getItems().addAll("Easy", "Medium", "Hard");
        genreDropdown.getItems().addAll("Pop", "Rock", "Jazz", "Classical", "Other");
    
        notesListView.getItems().addAll("C", "C♯", "D", "D♯", "E", "F", "F♯", "G", "G♯", "A", "A♯", "B");
        notesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
    private void addSelectedNotes() {
    ObservableList<String> selectedNotes = notesListView.getSelectionModel().getSelectedItems();

    if (selectedNotes.isEmpty()) {
        System.out.println("No notes selected to add!");
        return;
    }

    currentChord.clear(); 
    currentChord.addAll(selectedNotes);

    System.out.println("Added notes: " + currentChord);
}

    

    private void createNoteButtons() {
        for (Pitch pitch : Pitch.values()) {
            String label = pitch.name().replace("_SHARP", "♯").replace("FLAT", "♭").replace("_", "");
            Button noteButton = new Button(label);
            noteButton.setMinWidth(80);
            noteButton.setOnAction(e -> addNote(pitch));
         
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
    
            System.out.println("Added Measure #" + measureNumber + " with chords: " + currentChord);
    
            currentChord.clear();
        } else {
            System.out.println("No notes to add in measure!");
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
        String artist = currentUser != null ? currentUser.getUserName() : "Unknown";
    

        ArrayList<Measure> newMeasures = new ArrayList<>();
        int measureNum = 1;
        for (Measure oldMeasure : measures) {
            ArrayList<String> notes = new ArrayList<>();
            for (Chord chord : oldMeasure.getChords()) {
                notes.add(Chord.chordToString(chord.getNotes()));  
            }
            Measure newMeasure = new Measure(measureNum++, notes, oldMeasure.getChords());
            newMeasures.add(newMeasure);
        }
    
        MusicAppFacade.getInstance().createAndSaveSong(
            name,
            artist,
            1,          
            "1:00",     
            "Custom",   
            newMeasures
        );
    
        Song createdSong = SongList.getInstance().getSong(name);
        MusicAppFacade.getInstance().setCurrentSong(createdSong);
    
        try {
            App.setRoot("piano");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    @FXML
    private void goToPiano() throws IOException {
        App.setRoot("piano");
    }

    @FXML
    public void goHome() throws IOException {
    App.setRoot("home");
    }

    @FXML
    public void goSongs() throws IOException {
    App.setRoot("songssearch");
    }

    @FXML
    public void goLessons() throws IOException {
    App.setRoot("lessonfolder");
    }

    @FXML
    public void goUser() throws IOException {
    App.setRoot("settings");
    }
}
