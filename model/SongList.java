//package com.model;
/*
 * lily 
 */
import java.util.ArrayList;

public class SongList {
    private ArrayList<Song> songs;
    private static SongList songList;

    // constructor
    private SongList() {
        songs = new ArrayList<>();
    }

    // singleton pattern: to get instance of SongList
    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    public void addSong(Song song) {
   
    }

    public void removeSong(Song song) {

    }

    public void sortByName() {
  
    }

    public void sortByDifficulty() {
    
    }

    public void sortByLength() {
     
    }

    public void sortByGenre() {
    
    }

    public Song getSong(String songName) {

        return null;
    }

    public void display() {
   
    }

    public void saveSongs() {

    }
}
