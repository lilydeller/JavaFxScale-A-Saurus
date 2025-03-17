package model;

import music.Music;
import java.util.ArrayList;


public class MusicProgram {
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private Instrument currentInstrument;
    private SongList songList = SongList.getInstance();

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
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine3();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playLine2();
    }

    private void playAutumnLeaves() {
        playAutumnLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playAutumnLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private void playBohemianRhapsody() {
        playBohemianLine1();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        playBohemianLine2();
        try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Twinkle Twinkle Little Star
    private void playLine1() {
        playNote("C");
        playNote("C");
        playNote("G");
        playNote("G");
        playNote("A");
        playNote("A");
        playNote("G");
    }

    private void playLine2() {
        playNote("F");
        playNote("F");
        playNote("E");
        playNote("E");
        playNote("D");
        playNote("D");
        playNote("C");
    }

    private void playLine3() {
        playNote("F");
        playNote("F");
        playNote("E");
        playNote("E");
        playNote("D");
        playNote("D");
        playNote("C");
    }

    // Autumn Leaves
    private void playAutumnLine1() {
        playNote("C");
        playNote("F");
        playNote("Bb");
        playNote("Eb");
    }

    private void playAutumnLine2() {
        playNote("Amin");
        playNote("D7");
        playNote("Gm");
        playNote("C");
    }

    // Bohemian Rhapsody
    private void playBohemianLine1() {
        playNote("G");
        playNote("C");
        playNote("F");
        playNote("Bb");
    }

    private void playBohemianLine2() {
        playNote("C");
        playNote("G");
        playNote("F");
        playNote("Bb");
    }

    private void playNote(String note) {
        if (currentInstrument != null) {
            System.out.println("Playing " + note + " on " + currentInstrument.getName());
            Music.playNote(note);
        } else {
            System.out.println("No instrument selected. Playing " + note + " using default sound.");
            Music.playNote(note);
        }
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
