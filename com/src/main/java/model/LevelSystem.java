package model;

/**
 * the {@code LevelSystem} class implements the {@link GamificationSystem} interface
 * to manage a user's level progression in the application.
*/
public class LevelSystem implements GamificationSystem {
    private int currentLevel;
    private int maxLevel;

    /**
     * constructs a {@code LevelSystem} with a specified maximum level
     * The user starts at level 1
     *
     * @param maxLevel the highest level the user can reach
     */
    public LevelSystem(int maxLevel) {
        this.currentLevel = 1;
        this.maxLevel = maxLevel;
    }

    public void increaseLevel() {
        if (currentLevel < maxLevel) {
            currentLevel++;
        } else {
            System.out.println("max level reached!");
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override 
    public void updateProgress() {
        System.out.println("kevel progress updated. current level: " + currentLevel);
    }

    @Override 
    public void displayRewards() {
        System.out.println("rewards for reaching level " + currentLevel + ": " + (currentLevel % 5 == 0 ? "special bonus!" : "keep leveling up!"));
    }
}
