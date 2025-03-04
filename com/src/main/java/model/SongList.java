package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongList {
    private ArrayList<Song> songs;
    private static SongList songList;

    // constructer
    private SongList() {
        songs = new ArrayList<>();
    }

    // singleton pattern
    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    // ad a song to the list
    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
        }
    }

    // remove a song from the list
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // sort by song name
    public void sortByName() {
        Collections.sort(songs, Comparator.comparing(Song::getSongName));
    }

    // sort by difficulty 
    public void sortByDifficulty() {
        Collections.sort(songs, Comparator.comparingInt(Song::getDifficulty));
    }

    // sort by song length 
    public void sortByLength() {
        Collections.sort(songs, Comparator.comparingInt(Song::getLength));
    }

    // sort by genre 
    public void sortByGenre() {
        Collections.sort(songs, Comparator.comparing(Song::getGenre));
    }

    // get a song by its name
    public Song getSong(String songName) {
        for (Song song : songs) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null; // will return null if not found
    }

    // to display all songs
    public void display() {
        for (Song song : songs) {
            System.out.println(song.getSongName() + " - Genre: " + song.getGenre());
        }
    }

    // placeholder for saving songs (JSON/database handling) also don't know if we're getting rid of this function
    public void saveSongs() {
        System.out.println("Saving songs...");
    }
}
