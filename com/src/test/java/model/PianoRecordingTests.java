/*
 * @author lily
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * tests note recording behavior in the Piano class.
 */
public class PianoRecordingTests {

    private Piano piano;
    private Keys cKey;

    @BeforeEach
    public void setUp() {
        piano = new Piano();
        //cKey = new Keys("C");
    }

    @Test
    public void testNoteNotRecordedWhenRecordingOff() {
        piano.pressKey(cKey);
        //assertTrue(getRecordedNotes(piano).isEmpty(), "no notes should be recorded when recording is off");
    }

    @Test
    public void testNoteRecordedWhenRecordingOn() {
       // enableRecording(piano);
        piano.pressKey(cKey);
       // ArrayList<String> recorded = getRecordedNotes(piano);

       // assertEquals(1, recorded.size(), "one note should be recorded");
       // assertEquals("C", recorded.get(0), "the recorded note should be 'C'");
    }

    @Test
    public void testMultipleNotesRecordedInOrder() {
      //  enableRecording(piano);
       // piano.pressKey(new Keys("C"));
       // piano.pressKey(new Keys("E"));
       // piano.pressKey(new Keys("G"));

      //  ArrayList<String> recorded = getRecordedNotes(piano);

      //  assertEquals(3, recorded.size(), "three notes should be recorded");
      //  assertEquals("C", recorded.get(0));
       // assertEquals("E", recorded.get(1));
       // assertEquals("G", recorded.get(2));
    }
}
