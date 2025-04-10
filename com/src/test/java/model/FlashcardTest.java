package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlashcardTest {

    private Flashcard flashcard;

    @BeforeEach
    public void setUp() {
        flashcard = new Flashcard("What notes are in a C major chord?", "C E G");
    }

    @Test
    public void testGetQuestion() {
        assertEquals("What notes are in a C major chord?", flashcard.getQuestion(), "The question should be 'What notes are in a C major chord?'");
    }

    @Test
    public void testGetAnswer() {
        assertEquals("C E G", flashcard.getAnswer(), "The answer should be 'C E G'");
    }

    @Test
    public void testGetFlashcardID() {
        assertNotNull(flashcard.getFlashcardID(), "The flashcard ID should not be null");
    }

    @Test
    public void testSetQuestion() {
        flashcard.setQuestion("What is the relative minor of C major?");
        assertEquals("What is the relative minor of C major?", flashcard.getQuestion(), "The question should be updated to 'What is the relative minor of C major?'");
    }

    @Test
    public void testSetAnswer() {
        flashcard.setAnswer("A minor");
        assertEquals("A minor", flashcard.getAnswer(), "The answer should be updated to 'A minor'");
    }

    @Test
    public void testAnswerFlashcardCorrect() {
        assertTrue(flashcard.answerFlashcard(flashcard.getFlashcardID().toString(), "C E G"), "The answer should be correct");
    }

    @Test
    public void testAnswerFlashcardIncorrect() {
        assertFalse(flashcard.answerFlashcard(flashcard.getFlashcardID().toString(), "C F G"), "The answer should be incorrect");
    }

    @Test
    public void testAnswerFlashcardEmptyAnswer() {
        assertFalse(flashcard.answerFlashcard(flashcard.getFlashcardID().toString(), ""), "The answer should be invalid when the user provides an empty answer");
    }

    @Test
    public void testAnswerFlashcardNullAnswer() {
        assertFalse(flashcard.answerFlashcard(flashcard.getFlashcardID().toString(), null), "The answer should be invalid when the user provides a null answer");
    }
}
