package model;

import java.util.ArrayList;
import java.util.List;

public class Measure {
    private List<Chord> chords;

    public Measure() {
        this.chords = new ArrayList<>();
    }

    public void addChord(Chord chord) {
        chords.add(chord);
    }

    public void removeChord(Chord chord) {
        chords.remove(chord);
    }

    public List<Chord> getChords() {
        return chords;
    }


    public int getMeasureNumber() {
        return measureNumber;
    }
}
