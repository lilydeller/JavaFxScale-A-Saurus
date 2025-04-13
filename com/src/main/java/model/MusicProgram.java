package model;

import music.Music;
import java.util.ArrayList;

public class MusicProgram {
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private static Instrument currentInstrument;
    private SongList songList = SongList.getInstance();

    public void addInstrument(Instrument instrument) {
        if (instrument != null) instruments.add(instrument);
    }

    public void setCurrentInstrument(String instrumentName) {
        for (Instrument instrument : instruments) {
            if (instrument.getName().equalsIgnoreCase(instrumentName)) {
                currentInstrument = instrument;
                System.out.println("Current instrument set to: " + instrumentName);
                return;
            }
        }
        System.out.println("Instrument not found.");
    }

    public static void playSong(String songName) {
        if (currentInstrument == null) {
            System.out.println("No instrument selected, defaulting to Piano.");
            currentInstrument = new Instrument("Piano");
        }

        System.out.println("\n🎵 Now Playing: " + songName + " on " + currentInstrument.getName());

        switch (songName.toLowerCase()) {
            case "twinkle twinkle little star":
                playTwinkle();
                break;
            case "autumn leaves":
                playAutumnLeaves();
                break;
            case "bohemian rhapsody":
                playBohemianRhapsody();
                break;
            case "keep driving":
                playKeepDriving();
                break;
            case "fine line":
                playFineLine();
                break;
            case "sign of the times":
                playSignOfTheTimes();
                break;
            default:
                System.out.println("Song not found!");
        }
    }

    // Helper method to repeat the song pattern multiple times to simulate longer duration
    private static void repeatPattern(String pattern, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            Music.playPattern(pattern);
            try {
                Thread.sleep(800); // 0.8 second pause between loops to give it some realistic timing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void playTwinkle() {
        String pattern = (
            "C5q C5q G5q G5q A5q A5q G5h | F5q F5q E5q E5q D5q D5q C5h | " +
            "G5q G5q F5q F5q E5q E5q D5h | G5q G5q F5q F5q E5q E5q D5h | " +
            "C5q C5q G5q G5q A5q A5q G5h | F5q F5q E5q E5q D5q D5q C5h"
        );
        repeatPattern(pattern, 2);  // Play ~30 times to simulate full-length song
    }

    private static void playAutumnLeaves() {
        String pattern = (
            "C5q F5q Bb4q Eb5q | Am4q D4q Gm4q C4h | " +
            "Dm4q G4q C4q F4q | Gm4q C4q F4q Bb4q | " +
            "C5q F5q Bb4q Eb5q | Am4q D4q Gm4q C4h"
        );
        repeatPattern(pattern, 3);  // Repeat to match length of a typical song
    }

    private static void playBohemianRhapsody() {
        String pattern = (
            "G4q C5q F4q Bb4q | C5q G4q F4q Bb4h | " +
            "Eb4q G4q Bb4q D5q | F4q A4q C5q Eb5h | " +
            "C5q D5q Bb4q G4q | F4q G4q Bb4q C5h"
        );
        repeatPattern(pattern, 3);  // Longer loop to match song duration
    }

    private static void playKeepDriving() {
        String pattern = (
            "F#4q A4q E4q D4q | F#4q A4q E4q D4q | C#4q D4q B3q E4q | F#4q E4q D4h | " +
            "E4q D4q C#4q B3q | A4q B4q C#5q D5h"
        );
        repeatPattern(pattern, 3);  // Loop enough times to extend song length
    }

    private static void playFineLine() {
        String pattern = (
            "C4q E4q G4q C5q | D4q F4q A4q D5q | E4q G4q B4q E5q | F4q A4q C5q F5q | " +
            "C4q E4q G4q C5q | D4q F4q A4q D5q"
        );
        repeatPattern(pattern, 3);  // Repeat to simulate longer duration
    }

    private static void playSignOfTheTimes() {
        String pattern = (
            "G3q B3q D4q G4q | A3q C4q E4q A4q | F3q A3q C4q F4q | G3q B3q D4q G4h | " +
            "E4q G4q B4q E5q | F4q A4q C5q F5h"
        );
        repeatPattern(pattern, 4);  // Increase repetitions for longer duration
    }

    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();
        Instrument piano = new Instrument("Piano");
        player.addInstrument(piano);
        player.setCurrentInstrument("Piano");

        player.playSong("Twinkle Twinkle Little Star");
        player.playSong("Bohemian Rhapsody");
        player.playSong("Keep Driving");
        player.playSong("Autumn Leaves");
        player.playSong("Fine Line");
        player.playSong("Sign of the Times");
    }
}

