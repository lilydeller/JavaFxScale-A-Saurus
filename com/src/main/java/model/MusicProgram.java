package model;

import music.Music;

public class MusicProgram {
    public void playsong(String songName) {
        try {
            if (songName.equalsIgnoreCase("Twinkle Twinkle Little Star")) {
                playTwinkle();
            }else if (songName.equalsIgnoreCase("Autumn Leaves")) {
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playLine2();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playLine3();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playLine1();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playLine2();
    }

    private void playAutumnLeaves() {
        playAutumnLine1();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playAutumnLine2();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }     
    }
    //Twinkle Twinkle Little Star
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
        Music.playNote("C");
        Music.playNote("F");
        Music.playNote("Bb");
        Music.playNote("Eb");
    }

    private void playAutumnLine2() {
        Music.playNote("Amin");
        Music.playNote("D7");
        Music.playNote("Gm");
        Music.playNote("C");
    }

    // Bohemian Rhapsody
    private void playBohemianLine1() {
        Music.playNote("G");
        Music.playNote("C");
        Music.playNote("F");
        Music.playNote("Bb");
    }

    private void playBohemianLine2() {
        Music.playNote("C");
        Music.playNote("G");
        Music.playNote("F");
        Music.playNote("Bb");
    }

}