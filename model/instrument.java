package com.model;

import java.util.ArrayList;

public class Instrument {
    private String name;
    private ArrayList<Note> notes;
    private ArrayList<Instrument> instruments;
    private ArrayList<Flashcard> flashcards;
    private ArrayList<Lesson> lessons;

    public Instrument(String name) {
        this.name = name;
        this.notes = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.flashcards = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public void toggleSustain() {

    }

    public void startRecording() {
 
    }

    public void stopRecording() {
 
    }

    public void playRecording() {

    }

    public void clearRecording() {
       
    }
}
