package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chord {
    private List<Pitch> notes;


    public Chord(List<Pitch> notes) {
        this.notes = notes != null ? notes : new ArrayList<>(); 
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


    private static final Map<String, List<Pitch>> CHORD_MAP = new HashMap<>();

    static {

        CHORD_MAP.put("C", Arrays.asList(Pitch.C, Pitch.E, Pitch.G));
        CHORD_MAP.put("C#", Arrays.asList(Pitch.C_SHARP, Pitch.F, Pitch.G_SHARP));
        CHORD_MAP.put("D", Arrays.asList(Pitch.D, Pitch.F_SHARP, Pitch.A));
        CHORD_MAP.put("D#", Arrays.asList(Pitch.D_SHARP, Pitch.G, Pitch.A_SHARP));
        CHORD_MAP.put("E", Arrays.asList(Pitch.E, Pitch.G_SHARP, Pitch.B));
        CHORD_MAP.put("F", Arrays.asList(Pitch.F, Pitch.A, Pitch.C));
        CHORD_MAP.put("F#", Arrays.asList(Pitch.F_SHARP, Pitch.A_SHARP, Pitch.C_SHARP));
        CHORD_MAP.put("G", Arrays.asList(Pitch.G, Pitch.B, Pitch.D));
        CHORD_MAP.put("G#", Arrays.asList(Pitch.G_SHARP, Pitch.C, Pitch.D_SHARP));
        CHORD_MAP.put("A", Arrays.asList(Pitch.A, Pitch.C_SHARP, Pitch.E));
        CHORD_MAP.put("A#", Arrays.asList(Pitch.A_SHARP, Pitch.D, Pitch.F));
        CHORD_MAP.put("B", Arrays.asList(Pitch.B, Pitch.D_SHARP, Pitch.F_SHARP));
        
     
        CHORD_MAP.put("Am", Arrays.asList(Pitch.A, Pitch.C, Pitch.E));
        CHORD_MAP.put("Cm", Arrays.asList(Pitch.C, Pitch.D_SHARP, Pitch.G));
        CHORD_MAP.put("Dm", Arrays.asList(Pitch.D, Pitch.F, Pitch.A));
        CHORD_MAP.put("Em", Arrays.asList(Pitch.E, Pitch.G, Pitch.B));
        CHORD_MAP.put("Fm", Arrays.asList(Pitch.F, Pitch.G_SHARP, Pitch.C));
        CHORD_MAP.put("Gm", Arrays.asList(Pitch.G, Pitch.A_SHARP, Pitch.D));
        CHORD_MAP.put("Bm", Arrays.asList(Pitch.B, Pitch.D, Pitch.F_SHARP));
    }

    public static Chord fromString(String chordName) {
        return new Chord(CHORD_MAP.getOrDefault(chordName, new ArrayList<>()));  
    }

    
    public static String chordToString(List<Pitch> pitches) {
        for (Map.Entry<String, List<Pitch>> entry : CHORD_MAP.entrySet()) {
            if (entry.getValue().equals(pitches)) {
                return entry.getKey();  
            }
        }
        return "Unknown";  
    }
}
