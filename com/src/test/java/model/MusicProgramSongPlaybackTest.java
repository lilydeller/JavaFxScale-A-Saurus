
/*
 * @author lily deller
 */

package model;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * testing the playSong behavior in MusicProgram like the defaults and messages
 */
public class MusicProgramSongPlaybackTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPlaySong_DefaultsToPianoWhenNoInstrumentSet() {
        MusicProgram.playSong("Twinkle Twinkle Little Star");
        String out = output.toString();
        assertTrue(out.contains("No instrument selected, defaulting to Piano."), 
                   "Should default to Piano if no instrument is set");
    }

    @Test
    public void testPlaySong_RecognizedPredefinedSong() {
        MusicProgram.playSong("Twinkle Twinkle Little Star");
        String out = output.toString();
        assertTrue(out.contains("🎵 Now Playing: Twinkle Twinkle Little Star"),
                   "Should show now playing message for predefined song");
        assertTrue(out.contains("C5q C5q G5q G5q"), 
                   "Should output Twinkle Twinkle pattern");
    }

    @Test
    public void testPlaySong_UnrecognizedSongPrintsError() {
        MusicProgram.playSong("Nonexistent Song");
        String out = output.toString();
        assertTrue(out.contains("Song not found!"), 
                   "Should display error for unknown song name");
    }
}
