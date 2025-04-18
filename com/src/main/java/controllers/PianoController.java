package controllers;

import controllers.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.jfugue.player.Player;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PianoController {

    private Player player = new Player();
    private Map<Button, String> noteMap = new HashMap<>();

    @FXML private Button keyC4, keyD4, keyE4, keyF4, keyG4, keyA4, keyB4;
    @FXML private Button keyC5, keyD5, keyE5, keyF5, keyG5, keyA5, keyB5;

    @FXML private Button keyCSharp4, keyDSharp4, keyFSharp4, keyGSharp4, keyASharp4;
    @FXML private Button keyCSharp5, keyDSharp5, keyFSharp5, keyGSharp5, keyASharp5;

    @FXML private Button btnBack;


    @FXML
    public void initialize() {
      
        noteMap.put(keyC4, "C4");    noteMap.put(keyCSharp4, "C#4");
        noteMap.put(keyD4, "D4");    noteMap.put(keyDSharp4, "D#4");
        noteMap.put(keyE4, "E4");
        noteMap.put(keyF4, "F4");    noteMap.put(keyFSharp4, "F#4");
        noteMap.put(keyG4, "G4");    noteMap.put(keyGSharp4, "G#4");
        noteMap.put(keyA4, "A4");    noteMap.put(keyASharp4, "A#4");
        noteMap.put(keyB4, "B4");

        noteMap.put(keyC5, "C5");    noteMap.put(keyCSharp5, "C#5");
        noteMap.put(keyD5, "D5");    noteMap.put(keyDSharp5, "D#5");
        noteMap.put(keyE5, "E5");
        noteMap.put(keyF5, "F5");    noteMap.put(keyFSharp5, "F#5");
        noteMap.put(keyG5, "G5");    noteMap.put(keyGSharp5, "G#5");
        noteMap.put(keyA5, "A5");    noteMap.put(keyASharp5, "A#5");
        noteMap.put(keyB5, "B5");
    }

    @FXML
    private void handleKeyPress(javafx.event.ActionEvent e) {
        Button key = (Button) e.getSource();
        String note = noteMap.get(key);
        if (note != null) {
            key.getStyleClass().add("highlighted");
            new Thread(() -> {
                player.play(note);
                try {
                    Thread.sleep(200); 
                } catch (InterruptedException ignored) {}
                javafx.application.Platform.runLater(() -> key.getStyleClass().remove("highlighted"));
            }).start();
        }
    }



    @FXML
     private void goToPiano() throws Exception {
        App.setRoot("piano");
    }


    @FXML
    private void handleBack() throws Exception {
        App.setRoot("home");  
    }
}
