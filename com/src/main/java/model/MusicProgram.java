package model;

import music.Music;
import java.util.ArrayList;


public class MusicProgram {
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private static Instrument currentInstrument;
    private SongList songList = SongList.getInstance();
    private static Thread currentSongThread; //control song playback 
    private static boolean isSongPlaying = false;

    public void addInstrument(Instrument instrument) {
        if (instrument != null) {
            instruments.add(instrument);
        }
    }

    public void displaySongs() {
        System.out.println("Available Songs:");
        songList.display(); // Uses songList to avoid "unused variable" warning
    }
    

    public void setCurrentInstrument(String instrumentName) {
        for (Instrument instrument : instruments) {
            if (instrument.getName().equalsIgnoreCase(instrumentName)) {
                this.currentInstrument = instrument;
                System.out.println("Current instrument set to: " + instrumentName);
                return;
            }
        }
        System.out.println("Instrument not found.");
    }

    public static void playSong(String songName) {
        try {
            if (currentInstrument == null) {
                System.out.println("No instrument selected, Defaulting to Piano.");
                currentInstrument = new Instrument("Piano");  
            }
    
            System.out.println("\n🎵 Now Playing: " + songName + " on " + currentInstrument.getName());
    
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
    public static void stopSong() {
        //check if song is playing 
        if (isSongPlaying) {
            currentSongThread.interrupt();
            System.out.println("Song stopped ");
            isSongPlaying = false;
        }
        else {
            System.out.println("no song is playing currently ");
        }
    }

    private static void playTwinkle() {
        playLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine3();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine2();
    }

    private static void playAutumnLeaves() {
        playAutumnLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playAutumnLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private static void playBohemianRhapsody() {
        playBohemianLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playBohemianLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Twinkle Twinkle Little Star
    private static void playLine1() {
        playNote("C");
        playNote("C");
        playNote("G");
        playNote("G");
        playNote("A");
        playNote("A");
        playNote("G");
    }

    private static void playLine2() {
        playNote("F");
        playNote("F");
        playNote("E");
        playNote("E");
        playNote("D");
        playNote("D");
        playNote("C");
    }

    private static void playLine3() {
        playNote("F");
        playNote("F");
        playNote("E");
        playNote("E");
        playNote("D");
        playNote("D");
        playNote("C");
    }

    // Autumn Leaves
    private static void playAutumnLine1() {
        playNote("C");
        playNote("F");
        playNote("Bb");
        playNote("Eb");
    }

    private static void playAutumnLine2() {
        playNote("Amin");
        playNote("D7");
        playNote("Gm");
        playNote("C");
    }

    // Bohemian Rhapsody
    private static void playBohemianLine1() {
        playNote("G");
        playNote("C");
        playNote("F");
        playNote("Bb");
    }

    private static void playBohemianLine2() {
        playNote("C");
        playNote("G");
        playNote("F");
        playNote("Bb");
    }

    private static void playNote(String note) {
        if (currentInstrument == null) {
            System.out.println("no instrument selected - defaulting to piano.");
            currentInstrument = new Instrument("Piano");
        }
    
        System.out.println("Playing " + note + " on " + currentInstrument.getName());
        Music.playNote(note);
    }
    

    public void startRecording() {
        if (currentInstrument != null) {
            currentInstrument.startRecording();
        } else {
            System.out.println("No instrument selected to record.");
        }
    }

    public void stopRecording() {
        if (currentInstrument != null) {
            currentInstrument.stopRecording();
        } else {
            System.out.println("No instrument selected to stop recording.");
        }
    }

    public void playRecording() {
        if (currentInstrument != null) {
            currentInstrument.playRecording();
        } else {
            System.out.println("No instrument selected to play recording.");
        }
    }

    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();

        // Adding Instruments
        Instrument piano = new Instrument("Piano");
        player.addInstrument(piano);
        player.setCurrentInstrument("Piano");

        // Playing Songs
        player.playSong("Twinkle Twinkle Little Star");
        player.playSong("Autumn Leaves");
        player.playSong("Bohemian Rhapsody");

        // Start and Stop Recording TTLS
        player.startRecording();
        player.playSong("Twinkle Twinkle Little Star");
        player.stopRecording();
        player.playRecording();

        // Start and Stop Recording AL
        player.startRecording();
        player.playSong("Autumn Leaves");
        player.stopRecording();
        player.playRecording();

        // Start and Stop Recording BR
        player.startRecording();
        player.playSong("Bohemian Rhapsody");
        player.stopRecording();
        player.playRecording();
    }
}
