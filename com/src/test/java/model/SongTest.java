package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SongTest {

    private Song song;

    @BeforeEach
    public void setUp() {
        
        ArrayList<Measure> measures = new ArrayList<>();
        song = new Song("1", "Sign of the Times", 5, "4:00", "Pop", measures, "sheetMusicContent", "tabsMusicContent", true, "Harry Styles");
    }

    @Test
    public void testGetSongId() {
        assertEquals("1", song.getSongId(), "The song ID should be '1'");
    }

    @Test
    public void testGetSongName() {
        assertEquals("Sign of the Times", song.getSongName(), "The song name should be 'Sign of the Times'");
    }

    @Test
    public void testGetArtist() {
        assertEquals("Harry Styles", song.getArtist(), "The artist should be 'Harry Styles'");
    }

    @Test
    public void testGetDifficulty() {
        assertEquals(5, song.getDifficulty(), "The song difficulty should be 5");
    }

    @Test
    public void testGetLength() {
        assertEquals("4:00", song.getLength(), "The song length should be '4:00'");
    }

    @Test
    public void testGetGenre() {
        assertEquals("Pop", song.getGenre(), "The genre should be 'Pop'");
    }

    @Test
    public void testToggleMetronome() {
        song.toggleMetronome();
        assertFalse(song.isMetronomeEnabled(), "The metronome should be disabled after toggle");
        song.toggleMetronome();
        assertTrue(song.isMetronomeEnabled(), "The metronome should be enabled after toggle");
    }


    @Test
    public void testSetArtist() {
        song.setArtist("Mac Miller");
        assertEquals("Mac Miller", song.getArtist(), "The artist should be updated to 'Mac Miller'");
    }

    @Test
    public void testToString() {
        String expected = "Song{id='1', name='Sign of the Times', artist='Harry Styles', difficulty=5, length='4:00', genre='Pop', measures=[]}";
        assertEquals(expected, song.toString(), "The string representation should match the expected output");
    }
}
