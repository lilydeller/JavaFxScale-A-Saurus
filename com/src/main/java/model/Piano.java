package model;

import java.util.ArrayList;

public class Piano {
    private int octave;
    private int volume;
    private boolean isRecording;
    private ArrayList<String> recordedNotes;

    public Piano() {
        this.octave = 4; // Default middle octave
        this.volume = 50; // Default volume
        this.isRecording = false;
        this.recordedNotes = new ArrayList<>();
    }

    public void pressKey(Keys key) {
        System.out.println("Piano Key " + key.getKey() + " pressed.");
        if (isRecording) {
            recordedNotes.add(key.getKey().toString());
        }
    }

    public void releaseKey(Keys key) {
        System.out.println("Piano Key " + key.getKey() + " released.");
    }

    public void toggleSustain() {
        System.out.println("Piano sustain toggled.");
    }

    public void changeOctave(int newOctave) {
        this.octave = newOctave;
        System.out.println("Piano octave changed to: " + octave);
    }

    public void adjustVolume(int newVolume) {
        this.volume = newVolume;
        System.out.println("Piano volume set to: " + volume);
    }
}
