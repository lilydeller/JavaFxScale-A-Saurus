package model;

import java.util.ArrayList;
import java.util.List;

public class SheetMusic {
    private static final String[] NOTE_ORDER = { "B", "A#", "A", "G#", "G", "F#", "F", "E", "D#", "D", "C#", "C" };
    private static final int ROWS = 12;      // 12 pitches
    private static final int COLS = 4;       // 4 beats per measure
    private static final int MEASURES_PER_LINE = 4; // display 4 horizontally

    public static void convertToSheetMusic(Song song) {
        List<String[][]> allMeasures = new ArrayList<>();
        for (Measure measure : song.getMeasures()) {
            allMeasures.add(generateVisualMeasure(measure));
        }

        for (int start = 0; start < allMeasures.size(); start += MEASURES_PER_LINE) {
            int end = Math.min(start + MEASURES_PER_LINE, allMeasures.size());
            printHorizontalMeasures(allMeasures.subList(start, end));
        }
    }

    public static String[][] generateVisualMeasure(Measure measure) {
        String[][] visual = new String[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                visual[i][j] = "-";
            }
        }

        ArrayList<Chord> chords = measure.getChords();
        for (int beat = 0; beat < Math.min(chords.size(), COLS); beat++) {
            Chord chord = chords.get(beat);
            for (Pitch pitch : chord.getNotes()) {
                int rowIndex = getNoteIndex(pitch);
                if (rowIndex != -1) {
                    visual[rowIndex][beat] = "♩";  // Use musical note symbol
                }
            }
        }

        return visual;
    }

    private static int getNoteIndex(Pitch pitch) {
        for (int i = 0; i < NOTE_ORDER.length; i++) {
            if (pitch.name().equals(NOTE_ORDER[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void printHorizontalMeasures(List<String[][]> measures) {
        for (int row = 0; row < ROWS; row++) {
            StringBuilder line = new StringBuilder();
            line.append(String.format("%-3s: ", NOTE_ORDER[row])); // align pitch name

            for (String[][] measure : measures) {
                for (int col = 0; col < COLS; col++) {
                    line.append(String.format("%2s ", measure[row][col])); // fixed spacing
                }
                line.append("  "); // space between measures
            }
            System.out.println(line);
        }
        System.out.println(); // gap after each row block
    }

    public static String getNoteName(int index) {
        return NOTE_ORDER[index];
    }
}
