package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Manages a collection of Song objects
 */
public class SongList {
    private ArrayList<Song> songs;
    private static SongList songList;

    /**
     * Creates new SongList
     */
    private SongList() {
        songs = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of SongList
     * @return singleton SongList instance
     */
    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    /**
     * Adds a song to the list
     * @param song
     */
    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
            System.out.println("added song: " + song.getSongName());
        }
    }

    /**
     * Removes a song from the list
     * @param song
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * Sorts the songs by name in alphabetical order
     */
    public void sortByName() {
        Collections.sort(songs, Comparator.comparing(Song::getSongName));
    }

    /**
     * Sorts the songs by difficulty
     */
    public void sortByDifficulty() {
        Collections.sort(songs, Comparator.comparingInt(Song::getDifficulty));
    }

    /**
     * Gets a list of songs with a specific difficulty
     * @param difficulty
     * @return ArrayList of songs with specified difficulty
     */
    public ArrayList<Song> getSongsByDifficulty(int difficulty) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getDifficulty() == difficulty) {
                result.add(song);
            }
        }
        return result;
    }

    /**
     * Sorts the songs by length
     */
    public void sortByLength() {
        Collections.sort(songs, Comparator.comparingInt(song -> convertLengthToSeconds(song.getLength())));
    }

    /**
     * COnvers the song length from "mm:ss" format to total seconds
     * @param length
     * @return int of length in seconds
     */
    private int convertLengthToSeconds(String length) {
        try {
            String[] parts = length.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return (minutes * 60) + seconds;
        } catch (Exception e) {
            System.out.println("Invalid song length format: " + length);
            return 0;  
        }
    }

    /**
     * Sorts the songs by genre in alphabetical order
     */
    public void sortByGenre() {
        Collections.sort(songs, Comparator.comparing(Song::getGenre));
    }

    /**
     * Retrieves a song by its name
     * @param songName
     * @return Song with the same name
     */
    public Song getSong(String songName) {
        for (Song song : songs) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        System.out.println("Song \"" + songName + "\" not found in SongList.");
        return null;
    }

    /**
     * Displays all available songs
     */
    public void display() {
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
            return;
        }
        System.out.println(" Available Songs:");
        for (Song song : songs) {
            System.out.println("- " + song.getSongName() + " (" + song.getGenre() + ")");
        }
    }

    /**
     * Saves the current list of songs
     */
    public void saveSongs() {
        DataWriter.saveSongs(); 
    }
    
    

    /**
     * Retrieves the list of songs
     * @return ArrayList of songs
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Gets songs by a specific artist
     * @param artistName
     * @return ArrayList of songs by a specific artist
     */
    public ArrayList<Song> getSongsByArtist(String artistName) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artistName)) {
                result.add(song);
            }
        }
        return result;
    }
 
}
