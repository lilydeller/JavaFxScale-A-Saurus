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
            System.out.println("No instrument selected. Defaulting to Piano.");
            currentInstrument = new Instrument("Piano");
        }

        System.out.println("\n🎵 Now Playing: " + songName + " on " + currentInstrument.getName());

        switch (songName.toLowerCase()) {
            case "twinkle twinkle little star":
                playPattern("Cq Cq Gq Gq Aq Aq Gh | Fq Fq Eq Eq Dq Dq Ch");
                break;
            case "autumn leaves":
                playPattern("Cm7q F7q BbM7q EbM7q | Am7q D7q Gm7q C7h");
                break;
            case "bohemian rhapsody":
                playPattern("Gq Cq Fq Bbq | Cq Gq Fq Bbh");
                break;
            case "keep driving":
                playPattern("F#mq Aq Eq Dq | F#mq Aq Eq Dq | C#mq Dq Bmq Eq | F#mq Eq Dq");
                break;
            default:
                System.out.println("Song not found.");
        }
    }

    // Helper to send full musical pattern to player
    private static void playPattern(String pattern) {
        Music.playNote(pattern);
    }

    // ----------- Recording Support -----------
    public void startRecording() {
        if (currentInstrument != null) currentInstrument.startRecording();
        else System.out.println("No instrument selected to record.");
    }

    public void stopRecording() {
        if (currentInstrument != null) currentInstrument.stopRecording();
        else System.out.println("No instrument selected to stop recording.");
    }

    public void playRecording() {
        if (currentInstrument != null) currentInstrument.playRecording();
        else System.out.println("No instrument selected to play recording.");
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
