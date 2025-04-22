package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


    public ArrayList<Song> getSongsByArtist(String artist) {
        ArrayList<Song> songsByArtist = new ArrayList<>();
        for (Song song : songs) {
            String songArtist = song.getArtist();
            if (songArtist != null && songArtist.equalsIgnoreCase(artist)) {
                songsByArtist.add(song);
            }
        }
        return songsByArtist;
    }

    public ArrayList<Song> getSongsByGenre(String genre) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                result.add(song);
            }
        }
        return result;
    }

    public ArrayList<Song> getSongsByLengthRange(int minSeconds, int maxSeconds) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            int lengthInSeconds = convertLengthToSeconds(song.getLength());
            if (lengthInSeconds >= minSeconds && lengthInSeconds <= maxSeconds) {
                result.add(song);
            }
        }
        return result;
    }
    
    public List<Song> filterSongs(String query, String artistRange, String genre, int difficultyRange) {
    ArrayList<Song> filtered = new ArrayList<>();

    for (Song song : songs) {
        boolean matchesQuery = (query == null || query.isEmpty()) ||
                song.getSongName().toLowerCase().contains(query.toLowerCase()) ||
                song.getArtist().toLowerCase().contains(query.toLowerCase());

        boolean matchesArtistRange = artistRange.equals("All") ||
                (!song.getArtist().isEmpty() &&
                        isArtistInRange(song.getArtist().toUpperCase().charAt(0), artistRange));

        boolean matchesGenre = genre.equals("All") || song.getGenre().equalsIgnoreCase(genre);

        boolean matchesDifficulty = difficultyRange == 0 ||
                (difficultyRange == 1 && song.getDifficulty() <= 4) ||
                (difficultyRange == 2 && song.getDifficulty() >= 5);

        if (matchesQuery && matchesArtistRange && matchesGenre && matchesDifficulty) {
            filtered.add(song);
        }
    }

    return filtered;
}

private boolean isArtistInRange(char letter, String range) {
    switch (range) {
        case "A–D": return letter >= 'A' && letter <= 'D';
        case "I–O": return letter >= 'I' && letter <= 'O';
        case "P–S": return letter >= 'P' && letter <= 'S';
        case "T–W": return letter >= 'T' && letter <= 'W';
        case "Y–Z": return letter >= 'Y' && letter <= 'Z';
        default: return true; 
    }
}

public void loadSongs() {
    ArrayList<Song> loaded = DataLoader.loadSongs(); 
    songs.clear();
    songs.addAll(loaded);
    System.out.println("Songs loaded: " + songs.size());
}


}

