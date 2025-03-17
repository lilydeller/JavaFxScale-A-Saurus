package model;

import java.util.List;

public class Chord {
    private List<Pitch> notes;

    public Chord(List<Pitch> notes) {
        this.notes = notes;
    }

    public List<Pitch> getNotes() {
        return notes;
    }

    public void addNote(Pitch note) {
        notes.add(note);
    }

    public void removeNote(Pitch note) {
        notes.remove(note);
    }
}
