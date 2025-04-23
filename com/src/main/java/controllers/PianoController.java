package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Chord; 

import model.Song;
import model.SongList;
import model.Measure;
import model.MusicAppFacade;

import org.jfugue.player.Player;

import java.io.IOException;
import java.util.*;

public class PianoController {

    @FXML private AnchorPane pianoRoot;
    @FXML private Canvas sheetCanvas;
    @FXML private VBox whiteKeyBox;
    @FXML private ScrollPane sheetScrollPane;


    @FXML private Pane blackKeyPane;

    private final Player player = new Player();
    private final Map<String, Button> keyMap = new HashMap<>();
    private List<String> currentNotes = new ArrayList<>();
    private int noteIndex = 0;
    private Timeline playbackTimeline;
    private static final double NOTE_SPACING = 25;
    private static final String[] NOTE_ORDER = {
        "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
    };

    @FXML
    public void initialize() {
        createKeys(4);  
        Song song = MusicAppFacade.getInstance().getCurrentSong();
        if (song != null) {
            loadAndPlaySong(song);
        }
    }

    private void createKeys(int octaves) {
        int startOctave = 3;
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
                    whiteKey.setOnAction(e -> handleKeyPressDynamic(note, whiteKey));
                    whiteKeyBox.getChildren().add(whiteKey);
                    keyMap.put(note, whiteKey);

                } else {
                
                    Button blackKey = new Button();
                    blackKey.setPrefSize(blackKeyWidth, blackKeyHeight);
                    blackKey.setStyle("-fx-background-color: black;");
                    blackKey.setOnAction(e -> handleKeyPressDynamic(note, blackKey));
    
                    double yOffset = (whiteKeyBox.getChildren().size() - 1) * whiteKeyHeight - blackKeyHeight / 2;
                    blackKey.setLayoutX((whiteKeyWidth - blackKeyWidth) / 2); 
                    blackKey.setLayoutY(yOffset);
    
                    blackKeyPane.getChildren().add(blackKey);
                    keyMap.put(note, blackKey);
                }
            }
        }
    }

    private void handleKeyPressDynamic(String note, Button key) {
        player.play(note + "q");
        key.setStyle(note.contains("#")
            ? "-fx-background-color: #444;"
            : "-fx-background-color: #a2d2ff; -fx-border-color: black;");
        new Thread(() -> {
            try { Thread.sleep(250); } catch (InterruptedException ignored) {}
            Platform.runLater(() -> key.setStyle(note.contains("#") ? "-fx-background-color: black;" : "-fx-background-color: white; -fx-border-color: black;"));
        }).start();
    }

    private void loadAndPlaySong(Song song) {
        if (song == null) return;
        currentNotes.clear();
        for (Measure measure : song.getMeasures()) {
            for (String chordLabel : measure.getNotes()) {
                if (!chordLabel.equalsIgnoreCase("Unknown")) {
                    currentNotes.add(chordLabel);
                }
            }
        }
        noteIndex = 0;
        drawSheetMusic(currentNotes);
        scheduleNotes();
    }
    


    private void drawSheetMusic(List<String> notes) {
        GraphicsContext gc = sheetCanvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, sheetCanvas.getWidth(), sheetCanvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        double top = 40;         
        double spacing = 15;
        for (int i = 0; i < 20; i++) {
            double x = 10 + i * 20; 
            gc.setStroke(Color.LIGHTGRAY);
            gc.strokeLine(x, 0, x, sheetCanvas.getHeight());
        }
        
        double y = 20;
        gc.setFont(Font.font("Serif", FontWeight.BOLD, 24));
        for (String note : notes) {
            String[] pitches = note.contains("+") ? note.split("\\+") : new String[] { note };
            for (String pitch : pitches) {
                String clean = pitch.replaceAll("[^A-G#0-9]", "");
                String duration = pitch.replaceAll("[A-G#0-9]", "");
                double x = noteToX(clean);
                String symbol = duration.equals("i") ? "♪" : "♩";
                gc.setFill(Color.BLACK);
                gc.fillText(symbol, x, y);
            }
            y += 25;
        }
    }
    private double noteToX(String pitch) {
        return switch (pitch) {
            case "C4" -> 10;  case "C#4" -> 20;  case "D4" -> 30;
            case "D#4" -> 40; case "E4"  -> 50;  case "F4" -> 60;
            case "F#4" -> 70; case "G4"  -> 80;  case "G#4" -> 90;
            case "A4"  -> 100; case "A#4" -> 110; case "B4" -> 120;
            case "C5"  -> 130; case "C#5" -> 140; case "D5" -> 150;
            case "D#5" -> 160; case "E5"  -> 170; case "F5" -> 180;
            case "F#5" -> 190; case "G5"  -> 200; case "G#5" -> 210;
            case "A5"  -> 220; case "A#5" -> 230; case "B5" -> 240;
            default -> 80; 
        };
    }
    

    private double noteToY(String pitch) {
        return switch (pitch) {
            case "C4" -> 65; case "C#4" -> 63; case "D4" -> 60;
            case "D#4" -> 58; case "E4" -> 55; case "F4" -> 52;
            case "F#4" -> 50; case "G4" -> 47; case "G#4" -> 45;
            case "A4" -> 42; case "A#4" -> 40; case "B4" -> 37;
            case "C5" -> 35; case "C#5" -> 33; case "D5" -> 30;
            case "D#5" -> 28; case "E5" -> 25; case "F5" -> 23;
            case "F#5" -> 21; case "G5" -> 18; case "G#5" -> 16;
            case "A5" -> 13; case "A#5" -> 11; case "B5" -> 9;
            default -> 70;
        };
    }

    private void scheduleNotes() {
        playbackTimeline = new Timeline(new KeyFrame(Duration.millis(600), e -> highlightNextNote()));
        playbackTimeline.setCycleCount(currentNotes.size());
        playbackTimeline.play();
    }

    private void highlightNextNote() {
        if (noteIndex >= currentNotes.size()) return;
    
        GraphicsContext gc = sheetCanvas.getGraphicsContext2D();
    
        
            
            
    
        String[] pitches = currentNotes.get(noteIndex).split("\\+");
        gc.setFill(Color.LIMEGREEN);
    
        for (String pitch : pitches) {
            String clean = pitch.replaceAll("[^A-G#0-9]", "");
            String duration = pitch.replaceAll("[A-G#0-9]", "");
            String symbol = duration.equals("i") ? "♪" : "♩";
            player.play(clean + duration);
    
            double x = noteToX(clean); 
    
            Button key = keyMap.get(clean);
            if (key != null) {
                key.setStyle("-fx-background-color: lightgreen;");
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        Platform.runLater(() -> key.setStyle(
                            clean.contains("#") ? "-fx-background-color: black;" : "-fx-background-color: white; -fx-border-color: black;"
                        ));
                    }
                }, 400);
            }
        }
    
        
        double scrollHeight = sheetCanvas.getHeight();
        double visibleHeight = sheetScrollPane.getViewportBounds().getHeight();
        double y = 40 + noteIndex * NOTE_SPACING;

        double scrollY = Math.max(0, (y - visibleHeight / 2) / (scrollHeight - visibleHeight));
        sheetScrollPane.setVvalue(scrollY);

    
        noteIndex++;
    }
    

    @FXML
    public void handleSaveExit() throws IOException {
        MusicAppFacade.getInstance().saveCurrentSession();
        App.setRoot("home");
    }

    @FXML
    public void handleBack() throws IOException {
        App.setRoot("home");
    }
}
