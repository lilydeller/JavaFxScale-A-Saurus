package model;

import java.util.ArrayList;

public class Measure {
    private ArrayList<Chord> chords;
    private int measureNumber;

 
    public Measure(int measureNumber, ArrayList<Chord> chords) {
        this.measureNumber = measureNumber;
        this.chords = (chords != null) ? chords : new ArrayList<>();
    }

 
    public void addChord(Chord chord) {
        if (chord != null) {
            chords.add(chord);
        }
    }

  
    public void removeChord(Chord chord) {
        chords.remove(chord);
    }

    
    public ArrayList<Chord> getChords() {
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