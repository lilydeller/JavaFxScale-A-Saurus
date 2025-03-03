package model;

import java.util.ArrayList;

public class Chord {
    private ArrayList<Keys> notes;

    public Chord() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Keys key) {
        notes.add(key);
    }

    public ArrayList<Keys> getNotes() {
        return notes;
    }
}
