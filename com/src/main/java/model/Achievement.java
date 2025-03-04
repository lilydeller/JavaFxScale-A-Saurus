package model;

public class Achievement {
    private String name;
    private String description;
    private boolean isUnlocked;

    public Achievement(String name, String description) {
        this.name = name;
        this.description = description;
        this.isUnlocked = false;
    }

    public void unlock() {
        isUnlocked = true;
<<<<<<< HEAD
    }

    public void displayAchievement() {
        System.out.println("Achievement: " + name + " - " + description + " (Unlocked: " + isUnlocked + ")");
=======
        System.out.println("Achievement Unlocked: " + name);
    }

    public void displayAchievement() {
        System.out.println("Achievement: " + name + " - " + description + " (Unlocked: " + (isUnlocked ? "Yes" : "No") + ")");
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
    }
}
