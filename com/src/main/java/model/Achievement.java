
package model;
/*
 * Achievements for when user reaches milestones
 */
public class Achievement {
    private String id;
    private String name;
    private String description;
    private boolean isUnlocked;

    /*
     * creates an achievement
     * @param id
     * @param name
     * @param description
     */
    public Achievement(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUnlocked = false;
    }

    /*
     * getter method
     * @return id
     */
    public String getId() {
        return id;
    }

    /*
     * getter method
     * @return name
     */
    public String getName() {
        return name;
    }

    /*
     * getter method
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /*
     * checks if unlocked
     * @return isUnlocked
     */
    public boolean isUnlocked() {
        return isUnlocked;
    }

    /*
     * unlocks an acheivement
     */
    public void unlock() {
        if (!isUnlocked) {
            isUnlocked = true;
            System.out.println("Achievement Unlocked: " + name);
        }
    }

    /*
     * toString method 
     */
    @Override
    public String toString() {
        return name + " - " + description;
    }
}
