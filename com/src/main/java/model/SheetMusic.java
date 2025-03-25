package model;

import java.util.ArrayList;
import java.util.List;

public class SheetMusic {
    private static final String[] NOTE_ORDER = { "B", "A#", "A", "G#", "G", "F#", "F", "E", "D#", "D", "C#", "C" };

    private static final int ROWS = 12; //twelve playable notes 
    private static final int COLS = 4; //4 beats per measure 

    public SheetMusic() {
        //nothing goes here
    }

    public static void convertToSheetMusic(Song song) {

        for (Measure measure : song.getMeasures()) {
            String[][] visualMeasure = new String[ROWS][COLS];

            for (int i = 0; i < ROWS; i++) { //intialize the sheet as empty 
                for (int j = 0; j < COLS; j++) {
                    visualMeasure[i][j] = "-";
                }
            }

            ArrayList<Chord> chords = measure.getChords();
            //iterate through each beat and record the note for the beat in the measure 
            for (int beat = 0; beat < Math.min(chords.size(), COLS); beat++) {
                Chord chord = chords.get(beat);

                //find each note in the chord

                for (Pitch pitch : chord.getNotes()) {
                    int rowIndex = getNoteIndex(pitch);

                    //if pitch found , correct position 
                    if (rowIndex !=  -1) {
                        visualMeasure[rowIndex][beat] = pitch.name();
                    }
                }
            }
            
            printMeasure(visualMeasure);;
            
        }
    }

    private static int getNoteIndex(Pitch pitch) {
        for (int i = 0; i < NOTE_ORDER.length; i++) {
            if (pitch.name().equals(NOTE_ORDER[i])) {
                return i;
            }
        }
        return -1;
    }
    private static void printMeasure(String[][] visualMeasure) {
        // Print each row in the measure (each row represents a pitch)
        for (int i = 0; i < ROWS; i++) {
            System.out.print(NOTE_ORDER[i] + ": "); // Print the note name (pitch)
            for (int j = 0; j < COLS; j++) {
                System.out.print(visualMeasure[i][j] + " "); // Print each beat in the measure
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println(); // Add a blank line between measures
    }
    public static String[][] generateVisualMeasure(Measure measure) {
        String[][] visualMeasure = new String[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                visualMeasure[i][j] = "-";
            }
        }

        ArrayList<Chord> chords = measure.getChords();
        for (int beat = 0; beat < Math.min(chords.size(), COLS); beat++) {
            Chord chord = chords.get(beat);
            for (Pitch pitch : chord.getNotes()) {
                int rowIndex = getNoteIndex(pitch);
                if (rowIndex != -1) {
                    visualMeasure[rowIndex][beat] = pitch.name();
                }
            }
        }
        return visualMeasure;
    }

    public static String getNoteName(int index) {
        return NOTE_ORDER[index];
    }
}
