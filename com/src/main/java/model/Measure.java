package model;

import java.util.ArrayList;

public class Measure {
    private int measureNumber;
    private ArrayList<String> chords;

    public Measure(int measureNumber, ArrayList<String> chords) {
        this.measureNumber = measureNumber;
        this.chords = chords != null ? chords : new ArrayList<>(); // make sure it's not null
    }

    public void addChord(Chord chord) {
        if (chord != null) {
            chords.add(chord.toString()); // convert chord to string 
        }
    }

    public void removeChords(Chord chord) {
        if (chord != null) {
            chords.remove(chord.toString());
        }
    }

    public ArrayList<String> getChords() {
        return chords;
    }


    public int getMeasureNumber() {
        return measureNumber;
    }
}
