<<<<<<< HEAD

=======
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
package model;

public class StreakSystem implements GamificationSystem {
    private int streakCount;

    public StreakSystem() {
        this.streakCount = 0;
    }

    public void increaseStreak() {
        streakCount++;
    }

    public void updateStreakCount() {
        System.out.println("current streak: " + streakCount);
    }

    public void resetStreak() {
        streakCount = 0;
    }

    @Override 
    public void updateProgress() {
        System.out.println("progress updated for streak system. current streak: " + streakCount);
    }

    @Override 
    public void displayRewards() {
        System.out.println("rewards for maintaining streak: " + (streakCount > 5 ? "bonus unlocked!" : "keep going!"));
    }
}
