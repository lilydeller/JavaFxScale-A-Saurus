package model;

import java.util.ArrayList;

public class Instrument {
    private String name;
    private ArrayList<Keys> keys;
    private ArrayList<Instrument> instruments;
    private ArrayList<Flashcard> flashcards;
    private ArrayList<Lesson> lessons;
    private boolean isRecording;
    private ArrayList<String> recordedNotes; // sttores recorded notes add to uml 

    public Instrument(String name) {
        this.name = name;
        this.keys = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.flashcards = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.isRecording = false;
        this.recordedNotes = new ArrayList<>();
    }

    // gtters
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

    // toggle sustain effect
    public void toggleSustain() {
        System.out.println(name + " sustain toggled.");
    }

    // start recording
    public void startRecording() {
        isRecording = true;
        recordedNotes.clear();
        System.out.println("recording started.");
    }

    // stop recording
    public void stopRecording() {
        isRecording = false;
        System.out.println("recording stopped.");
    }

    // play the recorded notes
    public void playRecording() {
        if (recordedNotes.isEmpty()) {
            System.out.println("no recording available.");
        } else {
            System.out.println("playing recording: " + String.join(", ", recordedNotes));
        }
    }

    // clear the recording
    public void clearRecording() {
        recordedNotes.clear();
        System.out.println("recording cleared.");
    }

    // to simulate pressing a key and record it if the recording thing is active
    public void pressKey(Keys key) {
        System.out.println("Key " + key.getKey() + " pressed.");
        if (isRecording) {
            recordedNotes.add(key.getKey().toString());
        }
    }

    // to simulate releasing a key
    public void releaseKey(Keys key) {
        System.out.println("Key " + key.getKey() + " released.");
    }
}
