package model;

import java.util.ArrayList;

/**
 * Represents a measure containing a list of chords
 */
public class Measure {
    private ArrayList<Chord> chords;
    private int measureNumber;

    /**
     * Creates a Measure object with a specific measure number and list of chords
     * 
     * @param measureNumber
     * @param chords
     */
    public Measure(int measureNumber, ArrayList<Chord> chords) {
        this.measureNumber = measureNumber;
        this.chords = (chords != null) ? chords : new ArrayList<>();
    }

    /**
     * Adds a chord to the measure
     * 
     * @param chord
     */
    public void addChord(Chord chord) {
        if (chord != null) {
            chords.add(chord);
        }
    }

    /**
     * Removes a specified chord from the measure
     * @param chord
     */
    public void removeChord(Chord chord) {
        chords.remove(chord);
    }

    /**
     * Get a list of chords in the measure
     * @return an ArrayList of chords
     */
    public ArrayList<Chord> getChords() {
        return chords;
    }

    /**
     * Gets the measure number
     * @return int of the measure number
     */
    public int getMeasureNumber() {
        return measureNumber;
    }

   /**
    * returns a string representation of the measure object
    *
    * @return string of measure and chords
    */
    @Override
    public String toString() {
        return "Measure{" +
                "measureNumber=" + measureNumber +
                ", chords=" + chords +
                '}';
    }
}