package model;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
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
                playMidi("path/to/twinkle_twinkle.mid");
                break;
            case "autumn leaves":
                playMidi("path/to/autumn_leaves.mid");
                break;
            case "bohemian rhapsody":
                playMidi("path/to/bohemian_rhapsody.mid");
                break;
            case "keep driving":
                playMidi("path/to/keep_driving.mid");
                break;
            case "fine line":
                playMidi("path/to/fine_line.mid");
                break;
            case "sign of the times":
                playMidi("path/to/sign_of_the_times.mid");
                break;
            case "still dre":
                playMidi("path/to/still_dre.mid");
                break;
            default:
                System.out.println("Song not found!");
        }
    }

    private static void playMidi(String midiFilePath) {
        try {
            File midiFile = new File(midiFilePath);
            Sequence sequence = MidiSystem.getSequence(midiFile);
            Sequencer sequencer = MidiSystem.getSequencer();

            if (sequencer == null) {
                System.out.println("MIDI sequencer not available.");
                return;
            }

            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            System.out.println("Playing MIDI file: " + midiFilePath);

            // Wait for the sequencer to finish playing
            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }

            sequencer.close();
        } catch (InvalidMidiDataException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();
        Instrument piano = new Instrument("Piano");
        player.addInstrument(piano);
        player.setCurrentInstrument("Piano");

        // Play songs using their MIDI files
        player.playSong("Twinkle Twinkle Little Star");
        player.playSong("Bohemian Rhapsody");
        player.playSong("Keep Driving");
        player.playSong("Autumn Leaves");
        player.playSong("Fine Line");
        player.playSong("Sign of the Times");
        player.playSong("Still DRE");
    }
}

