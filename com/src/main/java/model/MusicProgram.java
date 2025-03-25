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
    

        Song found = SongList.getInstance().getSong(songName);
        if (found != null) {
            StringBuilder pattern = new StringBuilder();
            for (Measure m : found.getMeasures()) {
                for (Chord c : m.getChords()) {
                   
                    pattern.append(c.getNotes().get(0)).append("q ");
                }
                pattern.append("| ");
            }
            Music.playPattern(pattern.toString());
            return;
        }
    
       
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

    private static void playTwinkle() {
        String pattern = "C5q C5q G5q G5q A5q A5q G5h | F5q F5q E5q E5q D5q D5q C5h";
        Music.playPattern(pattern);
    }

    private static void playAutumnLeaves() {
        String pattern = "C5q F5q Bb4q Eb5q | Am4q D4q Gm4q C4h";
        Music.playPattern(pattern);
    }

    private static void playBohemianRhapsody() {
        String pattern = "G4q C5q F4q Bb4q | C5q G4q F4q Bb4h";
        Music.playPattern(pattern);
    }

    private static void playKeepDriving() {
        String pattern = "F#4q A4q E4q D4q | F#4q A4q E4q D4q | C#4q D4q B3q E4q | F#4q E4q D4h";
        Music.playPattern(pattern);
    }

    private static void playFineLine() {
        String pattern = "C4q E4q G4q C5q | D4q F4q A4q D5q | E4q G4q B4q E5q | F4q A4q C5q F5q";
        Music.playPattern(pattern);
    }
    
    private static void playSignOfTheTimes() {
        String pattern = "G3q B3q D4q G4q | A3q C4q E4q A4q | F3q A3q C4q F4q | G3q B3q D4q G4h";
        Music.playPattern(pattern);
    }
    

   

    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();
        Instrument piano = new Instrument("Piano");
        player.addInstrument(piano);
        player.setCurrentInstrument("Piano");

        player.playSong("Twinkle Twinkle Little Star");
        player.playSong("Bohemian Rhapsody");
        player.playSong("Keep Driving");
    }
}
