
package model;

public class Achievement {
    private String id;
    private String name;
    private String description;
    private boolean isUnlocked;

    public Achievement(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUnlocked = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void unlock() {
        if (!isUnlocked) {
            isUnlocked = true;
            System.out.println("Achievement Unlocked: " + name);
        }
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
