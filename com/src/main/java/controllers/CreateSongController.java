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
    String artist = (currentUser != null) ? currentUser.getUserName() : "Unknown Artist";

    int difficulty = 1;
    String difficultySelected = difficultyDropdown.getValue();
    if (difficultySelected != null) {
        if (difficultySelected.equalsIgnoreCase("Easy")) difficulty = 2;
        else if (difficultySelected.equalsIgnoreCase("Medium")) difficulty = 4;
        else if (difficultySelected.equalsIgnoreCase("Hard")) difficulty = 6;
    }

    String genre = genreDropdown.getValue() != null ? genreDropdown.getValue() : "Other";
    String duration = durationField.getText().trim();
    if (duration.isEmpty()) duration = "1:00";

    // 🔥 Here’s where we generate realistic values like your old songs:
    String sheetMusic = name.replaceAll(" ", "_") + "_Sheet.pdf";
    String tabsMusic = name.replaceAll(" ", "_") + "_Tabs.txt";
    int tempo = 80; // Default tempo (can make this adjustable later)
    String instrument = "Piano"; // Default instrument (adjustable too)

    // Actually create the song
    Song newSong = new Song(
        UUID.randomUUID().toString(),
        name,
        difficulty,
        duration,
        genre,
        measures,
        sheetMusic,
        tabsMusic,
        false,    // metronome off by default (can change)
        artist,
        tempo,
        instrument
    );

    SongList.getInstance().addSong(newSong);
    SongList.getInstance().saveSongs();
    MusicAppFacade.getInstance().setCurrentSong(newSong);

    System.out.println("🎵 Song created and saved: " + newSong.getSongName());

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
