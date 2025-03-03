/*
 * @author lily 
 */
//package com.model;

import java.util.ArrayList;

public class Piano {
    private ArrayList<Note> keys;
    private ArrayList<Note> activeKeys;
    private int octave;
    private int volume;
    private boolean isRecording;
    private ArrayList<Note> recordedNotes;

    public Piano() {
        this.keys = new ArrayList<>();
        this.activeKeys = new ArrayList<>();
        this.octave = 0;
        this.volume = 0;
        this.isRecording = false;
        this.recordedNotes = new ArrayList<>();
    }

    public void pressKey(Key key) {

    }

    public void releaseKey(Key key) {

    }

    public void toggleSustain() {
 
    }

    public void changeOctave(int newOctave) {

    }

    public void adjustVolume(int newVolume) {

    }
}
