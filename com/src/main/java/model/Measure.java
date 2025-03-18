package model;

import java.util.ArrayList;
import java.util.List;

public class Measure {
    private List<Chord> chords;
    private int measureNumber; 

    public Measure(int measureNumber, ArrayList<Chord> chords) { 
        this.chords = new ArrayList<>();
        this.measureNumber = measureNumber; 
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

    @Override
    public String toString() {
        return "Measure{" +
                "measureNumber=" + measureNumber +
                ", chords=" + chords +
                '}';
    }
}
