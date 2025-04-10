/*
 * @author lily deller
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * testing behavior of setting the current instrument in the MusicProgram class
 */
public class MusicProgramInstrumentSelectionTest {

    private MusicProgram musicProgram;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        musicProgram = new MusicProgram();
        musicProgram.addInstrument(new Instrument("piano"));
        musicProgram.addInstrument(new Instrument("guitar"));
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSetValidInstrument() {
        musicProgram.setCurrentInstrument("piano");

        String output = outContent.toString().trim();
        assertTrue(output.contains("current instrument set to: Piano"),
                "eexpected confirmation message for valid instrument selection.");
    }

    @Test
    public void testSetInvalidInstrument() {
        musicProgram.setCurrentInstrument("Flute");

        String output = outContent.toString().trim();
        assertTrue(output.contains("instrument not found."),
                "ecpected warning message for invalid instrument.");
    }
}
