package com.music;

import org.jfugue.player.Player;

public class MusicPlayer {
    private static final String SONG = "C D E F G A B"; // Placeholder, modify for TV Off

    public static void playSong() {
        Player player = new Player();
        player.play(SONG);
    }

    public static void main(String[] args) {
        playSong();
    }
}
