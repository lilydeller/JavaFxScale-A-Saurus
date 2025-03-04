package model;

import java.util.ArrayList;

public class Song {
    private String songId;
    private String songName;
    private ArrayList<Measure> songMeasures;
    private boolean metronome;
    private String genre;
    private int difficulty;
    private int length;
    private String sheetMusic;
    private String tabsMusic;

    public Song(String songId, String songName, int difficulty, int length, String genre,
                ArrayList<Measure> measures, String sheetMusic, String tabsMusic, boolean metronome) {
        this.songId = songId;
        this.songName = songName;
        this.difficulty = difficulty;
        this.length = length;
        this.genre = genre;
        this.songMeasures = measures != null ? measures : new ArrayList<>(); // make sure it's not null
        this.sheetMusic = sheetMusic;
        this.tabsMusic = tabsMusic;
        this.metronome = metronome;
    }

    public String getSongName() {
        return songName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public void addMeasure(Measure measure) {
        songMeasures.add(measure);
    }

    public void toggleMetronome() {
        metronome = !metronome;
    }
}
