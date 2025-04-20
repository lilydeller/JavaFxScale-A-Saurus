package model;

import music.Music;

public class MusicProgram {
    public void playSong(String songName) {
        try {
            if (songName.equalsIgnoreCase("Twinkle Twinkle Little Star")) {
                playTwinkle();
            } else if (songName.equalsIgnoreCase("Autumn Leaves")) {
                playAutumnLeaves();
            } else if (songName.equalsIgnoreCase("Bohemian Rhapsody")) {
                playBohemianRhapsody();
            } else {
                System.out.println("Song not found!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void playTwinkle() {
        playLine1();
        Thread.sleep(300);
        playLine2();
        Thread.sleep(300);
        playLine3();
        Thread.sleep(300);
        playLine1();
        Thread.sleep(300);
        playLine2();
    }

    private void playAutumnLeaves() {
        playAutumnLine1();
        Thread.sleep(300);
        playAutumnLine2();
        Thread.sleep(300);
        playAutumnLine3();
    }

    private void playBohemianRhapsody() {
        playBohemianLine1();
        Thread.sleep(300);
        playBohemianLine2();
        Thread.sleep(300);
        playBohemianLine3();
    }

    // Twinkle Twinkle Little Star
    private void playLine1() {
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("G");
        Music.playNote("G");
        Music.playNote("A");
        Music.playNote("A");
        Music.playNote("G");
    }

    private void playLine2() {
        Music.playNote("F");
        Music.playNote("F");
        Music.playNote("E");
        Music.playNote("E");
        Music.playNote("D");
        Music.playNote("D");
        Music.playNote("C");
    }

    private void playLine3() {
        Music.playNote("F");
        Music.playNote("F");
        Music.playNote("E");
        Music.playNote("E");
        Music.playNote("D");
        Music.playNote("D");
        Music.playNote("C");
    }

    // Autumn Leaves
    private void playAutumnLine1() {
        Music.playNote("Cm7");
        Music.playNote("F7");
        Music.playNote("BbM7");
        Music.playNote("EbM7");
    }

    private void playAutumnLine2() {
        Music.playNote("Am7");
        Music.playNote("D7");
        Music.playNote("Gm7");
        Music.playNote("C7");
    }

    private void playAutumnLine3() {
        Music.playNote("Fm7");
        Music.playNote("Bb7");
        Music.playNote("EbM7");
        Music.playNote("AbM7");
    }

    // Bohemian Rhapsody
    private void playBohemianLine1() {
        Music.playNote("Gm");
        Music.playNote("Bb");
        Music.playNote("Eb");
        Music.playNote("F");
    }

    private void playBohemianLine2() {
        Music.playNote("Cm");
        Music.playNote("G7");
        Music.playNote("F");
        Music.playNote("Bb");
    }

    private void playBohemianLine3() {
        Music.playNote("Eb");
        Music.playNote("F");
        Music.playNote("Bb");
        Music.playNote("D");
    }

    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();
        player.playSong("Twinkle Twinkle Little Star");  // Test Twinkle Twinkle
        player.playSong("Autumn Leaves");  // Test Autumn Leaves
        player.playSong("Bohemian Rhapsody");  // Test Bohemian Rhapsody
    }
}
