package model;

import java.util.ArrayList;

public class Song {
    private String songId;
    private String songName;
    private int difficulty;
    private String length;
    private String genre;
    private ArrayList<Measure> measures;
    private String sheetMusic;
    private String tabsMusic;
    private boolean metronome;

    // corrected constructor to match DataLoader.java
    public Song(String songId, String songName, int difficulty, String length, String genre,
                ArrayList<Measure> measures, String sheetMusic, String tabsMusic, boolean metronome) {
        this.songId = songId;
        this.songName = songName;
        this.difficulty = difficulty;
        this.length = length;
        this.genre = genre;
        this.measures = measures != null ? measures : new ArrayList<>();
        this.sheetMusic = sheetMusic;
        this.tabsMusic = tabsMusic;
        this.metronome = metronome;
    }

    // getter methods
    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    public String getSheetMusic() {
        return sheetMusic;
    }

    public String getTabsMusic() {
        return tabsMusic;
    }

    public boolean isMetronomeEnabled() {
        return metronome;
    }

    public void addMeasure(Measure measure) {
        if (measure != null) {
            measures.add(measure);
        }
    }

    public void toggleMetronome() {
        metronome = !metronome;
    }
}
