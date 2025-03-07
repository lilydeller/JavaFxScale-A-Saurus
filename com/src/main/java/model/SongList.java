package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongList {
    private ArrayList<Song> songs;
    private static SongList songList;


    private SongList() {
        songs = new ArrayList<>();
    }


    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
        }
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void sortByName() {
        Collections.sort(songs, Comparator.comparing(Song::getSongName));
    }


    public void sortByDifficulty() {
        Collections.sort(songs, Comparator.comparingInt(Song::getDifficulty));
    }


    public void sortByLength() {
        Collections.sort(songs, Comparator.comparing(Song::getLength));
    }


    public void sortByGenre() {
        Collections.sort(songs, Comparator.comparing(Song::getGenre));
    }


    public Song getSong(String songName) {
        for (Song song : songs) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null; 
    }


    public ArrayList<Song> getSongsByDifficulty(String difficulty) {
        ArrayList<Song> filteredSongs = new ArrayList<>();
        int difficultyLevel = 0;
        switch (difficulty) {
            case "Easy":
                difficultyLevel = 1;
                break;
            case "Medium":
                difficultyLevel = 2;
                break;
            case "Hard":
                difficultyLevel = 3;
                break;
        }
        for (Song song : songs) {
            if (song.getDifficulty() == difficultyLevel) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    public void display() {
        for (Song song : songs) {
            System.out.println(song.getSongName() + " - Genre: " + song.getGenre());
        }
    }

    // placeholder for saving songs (JSON/database handling)
    public void saveSongs() {
        System.out.println("Saving songs...");
    }

    // get all songs for testing or UI display
    public ArrayList<Song> getSongs() {
        return songs;
    }
}
