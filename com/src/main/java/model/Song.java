package model;

import java.util.ArrayList;

/**
 * A song with various attributes like a name, artist, genre, and measures
 */
public class Song {
    private String songId;
    private String songName;
    private String artist;
    private int difficulty;
    private String length;
    private String genre;
    private ArrayList<Measure> measures;
    private String sheetMusic;
    private String tabsMusic;
    private boolean metronome;
    private int tempo;
    private String instrument;

    /**
     * Creates a song object
     * 
     * @param songId
     * @param songName
     * @param difficulty
     * @param length
     * @param genre
     * @param measures
     * @param sheetMusic
     * @param tabsMusic
     * @param metronome
     * @param artist
     */
    public Song(String songId, String songName, int difficulty, String length, String genre,
            ArrayList<Measure> measures, String sheetMusic, String tabsMusic, boolean metronome, String artist) {
    this.songId = songId;
    this.songName = songName;
    this.difficulty = difficulty;
    this.length = length;
    this.genre = genre;
    this.measures = measures != null ? measures : new ArrayList<>();
    this.sheetMusic = sheetMusic;
    this.tabsMusic = tabsMusic;
    this.metronome = metronome;
    this.artist = artist; 
}


    /**
     * Gets the unique of the song
     * @return String of SongId
     */
    public String getSongId() {
        return songId;
    }

   /**
    * gets the name of the song
    * @return String of Song Name
    */ 
    public String getSongName() {
        return songName;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Sets the artsit of the song
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the artist of the song
     * @return String of artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * gets the difficulty of the song
     * @return int of the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * gets the length of the song
     * @return string of the song length
     */
    public String getLength() {
        return length;
    }

    /**
     * gets the genre of the song
     * @return String of the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * gets the measures of the song
     * @return ArrayList of measures
     */
    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    /**
     * gets the sheet music of the song
     * @return String of sheet music
     */
    public String getSheetMusic() {
        return sheetMusic;
    }

    /**
     * gets the tabs music of the song
     * @return String of tabs music
     */
    public String getTabsMusic() {
        return tabsMusic;
    }

    /**
     * checks if the metronome is enabled
     * @return true if metronome is enabled, fasle otherwise
     */
    public boolean isMetronomeEnabled() {
        return metronome;
    }

    /**
     * adds a measure to the song
     * @param measure
     */
    public void addMeasure(Measure measure) {
        if (measure != null) {
            measures.add(measure);
        }
    }

    /**
     * toggles the metronome setting
     */
    public void toggleMetronome() {
        metronome = !metronome;
    }

    /**
     * Returns a string representation of the song object
     * @return string of the song
     */
    @Override
    public String toString() {
        return "Song{" +
                "id='" + songId + '\'' +
                ", name='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                ", difficulty=" + difficulty +
                ", length='" + length + '\'' +
                ", genre='" + genre + '\'' +
                ", measures=" + measures +
                '}';
    }

    
}
