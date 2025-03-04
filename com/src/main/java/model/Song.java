package model;

import java.util.ArrayList;

public class Song {
    private String songName;
    private ArrayList<Measure> songMeasures;
    private boolean metronome;
    private String genre;
    private int difficulty;
    private int length; 

    public Song(String songName, int difficulty, int length, String genre) {
        this.songName = songName;
        this.difficulty = difficulty;
        this.length = length;
        this.genre = genre;
        this.songMeasures = new ArrayList<>();
        this.metronome = false;
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
