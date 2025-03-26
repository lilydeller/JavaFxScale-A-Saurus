package model;

import java.util.ArrayList;

public class Instrument {
    private String name;
    private ArrayList<Keys> keys;
    private ArrayList<Instrument> instruments;
    private ArrayList<Flashcard> flashcards;
    private ArrayList<Lesson> lessons;
    private boolean isRecording;
    private ArrayList<String> recordedNotes; 
    private Piano piano; 

    public Instrument(String name) {
        this.name = name;
        this.keys = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.flashcards = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.isRecording = false;
        this.recordedNotes = new ArrayList<>();
        this.piano = new Piano(); 
    }

  
    public String getName() {
        return name;
    }

    public ArrayList<Keys> getKeys() {
        return keys;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public ArrayList<Flashcard> getFlashcards() {
        return flashcards;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /*
     * Toggle sustain effect
     */
    public void toggleSustain() {
        piano.toggleSustain();
        System.out.println(name + " sustain toggled.");
    }

    /*
     * Start recording
     */
    public void startRecording() {
        isRecording = true;
        recordedNotes.clear();
        System.out.println("Recording started.");
    }

    /*
     * stop recording
     */
    public void stopRecording() {
        isRecording = false;
        System.out.println("Recording stopped.");
    }

    /*
     * play the recorded notes
     */
    public void playRecording() {
        if (recordedNotes.isEmpty()) {
            System.out.println("No recording available.");
        } else {
            System.out.println("Playing recording: " + String.join(", ", recordedNotes));
        }
    }

    /*
     * clear the recording
     */
    public void clearRecording() {
        recordedNotes.clear();
        System.out.println("Recording cleared.");
    }

    /*
     * Simulate pressing a key and recording it if active
     */
    public void pressKey(Keys key) {
        piano.pressKey(key);
        if (isRecording) {
            recordedNotes.add(key.getKey().toString());
        }
    }

    /*
     * Simulate releasing a key
     */
    public void releaseKey(Keys key) {
        piano.releaseKey(key);
    }

    /*
     * Play a song using stored measures
     */
    public void playSong(Song song) {
        System.out.println("Now playing: " + song.getSongName());
        for (Measure measure : song.getMeasures()) {
            System.out.println("Measure: " + measure.toString());
        }
        if (song.isMetronomeEnabled()) {
            System.out.println("Metronome is ON.");
        }
        System.out.println("Song ended.");
    }
}
