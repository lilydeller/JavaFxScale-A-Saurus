/*
 * @author lily
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * testing the unlocking behavior of our achievement class
 */
public class AchievementUnlockTests {

    private Achievement achievement;

    @BeforeEach
    public void setUp() {
        achievement = new Achievement("a1", "first Song", "create your first song");
    }

    @Test
    public void testAchievementStartsLocked() {
        assertFalse(achievement.isUnlocked(), "achievement should start locked by default");
    }

    @Test
    public void testUnlockAchievement() {
        achievement.unlock();
        assertTrue(achievement.isUnlocked(), "achievement should be unlocked after we're calling unlock()");
    }

    @Test
    public void testUnlockTwiceDoesNotCrashOrChangeState() {
        achievement.unlock();
        achievement.unlock();  
        assertTrue(achievement.isUnlocked(), "achievement should remain unlocked after we have the second unlock call");
    }

    @Test
    public void testToStringFormat() {
        String expected = "first Song - create your first song";
        assertEquals(expected, achievement.toString(), "toString output should match expected format");
    }
}
