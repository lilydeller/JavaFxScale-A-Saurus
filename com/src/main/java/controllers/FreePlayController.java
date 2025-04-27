package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jfugue.player.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreePlayController {

    @FXML private AnchorPane freePlayRoot;
    @FXML private VBox whiteKeyBox;
    @FXML private Pane blackKeyPane;
    @FXML private Label lbl_playingNote;

    private final Player player = new Player();
    private final Map<String, Button> keyMap = new HashMap<>();
    private final Map<KeyCode, String> keyboardMap = new HashMap<>();

    private static final String[] NOTE_ORDER = {
        "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
    };

    @FXML
    public void initialize() {
        createKeys(3);  
        setupKeyboardMapping();

        freePlayRoot.setOnKeyPressed(this::handleKeyboardPress);
        freePlayRoot.setFocusTraversable(true);
    }

    private void createKeys(int octaves) {
        int startOctave = 4;
        double whiteKeyHeight = 40;
        double blackKeyHeight = 30;
        double whiteKeyWidth = 180;
        double blackKeyWidth = 130;

        for (int o = 0; o < octaves; o++) {
            for (int i = 0; i < NOTE_ORDER.length; i++) {
                String note = NOTE_ORDER[i] + (startOctave + o);
                if (!NOTE_ORDER[i].contains("#")) {
                    Button whiteKey = new Button();
                    whiteKey.setPrefSize(whiteKeyWidth, whiteKeyHeight);
                    whiteKey.setStyle("-fx-background-color: white; -fx-border-color: black;");
                    whiteKey.setOnAction(e -> handleKeyPress(note, whiteKey));
                    whiteKeyBox.getChildren().add(whiteKey);
                    keyMap.put(note, whiteKey);
                } else {
                    Button blackKey = new Button();
                    blackKey.setPrefSize(blackKeyWidth, blackKeyHeight);
                    blackKey.setStyle("-fx-background-color: black;");
                    blackKey.setOnAction(e -> handleKeyPress(note, blackKey));

                    double yOffset = (whiteKeyBox.getChildren().size() - 1) * whiteKeyHeight - blackKeyHeight / 2;
                    blackKey.setLayoutX((whiteKeyWidth - blackKeyWidth) / 2);
                    blackKey.setLayoutY(yOffset);

                    blackKeyPane.getChildren().add(blackKey);
                    keyMap.put(note, blackKey);
                }
            }
        }
    }

    private void handleKeyPress(String note, Button key) {
        lbl_playingNote.setText("Playing: " + note);
        player.play(note + "q");
        key.setStyle(note.contains("#")
            ? "-fx-background-color: #444;"
            : "-fx-background-color: #a2d2ff; -fx-border-color: black;");
        new Thread(() -> {
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            Platform.runLater(() -> key.setStyle(
                note.contains("#") ? "-fx-background-color: black;" : "-fx-background-color: white; -fx-border-color: black;"
            ));
        }).start();
    }

    private void setupKeyboardMapping() {
        keyboardMap.put(KeyCode.A, "C4");
        keyboardMap.put(KeyCode.W, "C#4");
        keyboardMap.put(KeyCode.S, "D4");
        keyboardMap.put(KeyCode.E, "D#4");
        keyboardMap.put(KeyCode.D, "E4");
        keyboardMap.put(KeyCode.F, "F4");
        keyboardMap.put(KeyCode.T, "F#4");
        keyboardMap.put(KeyCode.G, "G4");
        keyboardMap.put(KeyCode.Y, "G#4");
        keyboardMap.put(KeyCode.H, "A4");
        keyboardMap.put(KeyCode.U, "A#4");
        keyboardMap.put(KeyCode.J, "B4");
        keyboardMap.put(KeyCode.K, "C5");
        keyboardMap.put(KeyCode.O, "C#5");
        keyboardMap.put(KeyCode.L, "D5");
        keyboardMap.put(KeyCode.P, "D#5");
        keyboardMap.put(KeyCode.SEMICOLON, "E5");
    }

    private void handleKeyboardPress(KeyEvent event) {
        String note = keyboardMap.get(event.getCode());
        if (note != null) {
            Button key = keyMap.get(note);
            if (key != null) {
                handleKeyPress(note, key);
            }
        }
    }

    @FXML
    public void goHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    public void goSongs() throws IOException {
        App.setRoot("songsearch");
    }

    @FXML
    public void goLessons() throws IOException {
        App.setRoot("lessonfolder");
    }

    @FXML
    public void goSettings() throws IOException {
        App.setRoot("settings");
    }
}
