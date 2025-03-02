/*
 * @author lily deller
 */
package com.model;

import java.util.ArrayList;

public class Song {
    private String songName;
    private ArrayList<Measure> song;
    private Song sheetMusic;
    private Song tabsMusic;
    private boolean metronome;
    private Genre genre;

    public Song(ArrayList<Note> song) {
        this.song = new ArrayList<>();
        this.metronome = false;
    }

    public void setSheet() {
        // Stub 
    }

    public void setTabs() {
        // Stub 
    }

    public void addNote(String note, int noteLength) {
        // Stub 
    }

    public boolean toggleMetronome() {
        metronome = !metronome;
        return metronome;
    }

    public void adjustTempo(int bpm) {
        // Stub 
    }

    public boolean contains(String keyword) {
        return false; // Stub 
    }

    public void addMeasure(Measure measure) {
        song.add(measure);
    }
}
