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
            System.out.println("dded song: " + song.getSongName());
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

    public ArrayList<Song> getSongsByDifficulty(int difficulty) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getDifficulty() == difficulty) {
                result.add(song);
            }
        }
        return result;
    }


    public void sortByLength() {
        Collections.sort(songs, Comparator.comparingInt(song -> convertLengthToSeconds(song.getLength())));
    }

    private int convertLengthToSeconds(String length) {
        String[] parts = length.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return (minutes * 60) + seconds;
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
        System.out.println("Song \"" + songName + "\" not found in SongList.");
        return null;
    }

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

    public void saveSongs() {
        songList.saveSongs();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
    public 
}
