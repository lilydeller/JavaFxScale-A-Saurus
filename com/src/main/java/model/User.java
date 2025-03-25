package model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private ArrayList<Lesson> lessons;
    private int level;
    private int streak;
    private ArrayList<String> achievements;
    private ArrayList<String> leaderboardRanking;
    private ArrayList<User> friends;
    private ArrayList<Achievement> unlockedAchievements = new ArrayList<>();

    // Constructor for new users
    public User(String userName, String firstName, String lastName, String password, String email) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.leaderboardRanking = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.level = 1;
        this.streak = 0;
    }

    // Constructor for loading from JSON
    public User(UUID id, String userName, String firstName, String lastName, String password, String email, int streak, int level, ArrayList<String> achievements) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.streak = streak;
        this.level = level;
        this.achievements = achievements != null ? achievements : new ArrayList<>();
        this.leaderboardRanking = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public boolean login(String userName, String password) {
        return this.userName != null && this.password != null &&
               this.userName.equals(userName) &&
               this.password.equals(password);
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<String> achievements) {
        this.achievements = achievements;
    }

    public ArrayList<String> getLeaderboardRanking() {
        return leaderboardRanking;
    }

    public void setLeaderboardRanking(ArrayList<String> leaderboardRanking) {
        this.leaderboardRanking = leaderboardRanking;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }

    public void addAchievement(String achievement) {
        achievements.add(achievement);
    }

    public void unlockAchievement(String achievementName) {
        for (Achievement achievement : DataLoader.getAchievements()) {
            if (achievement.getName().equals(achievementName) && !hasAchievement(achievementName)) {
                unlockedAchievements.add(achievement);
                achievements.add(achievementName); 
                achievement.unlock();
                System.out.println("Unlocked Achievement: " + achievementName);
            }
        }
    }
    
    private boolean hasAchievement(String name) {
        return achievements.contains(name);
    }
    

    public ArrayList<Achievement> viewAchievements() {
        if (unlockedAchievements.isEmpty()) {
            for (String name : achievements) {
                for (Achievement a : DataLoader.getAchievements()) {
                    if (a.getName().equals(name)) {
                        unlockedAchievements.add(a);
                        break;
                    }
                }
            }
        }
        return unlockedAchievements;
    }
    

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", streak=" + streak +
                ", level=" + level +
                ", achievements=" + achievements +
                '}';
    }
}
