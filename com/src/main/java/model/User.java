package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * user class represents a user in the music application, holding information such as
 * credentials, progress (level and streak), achievements, and social connections (friends)
 * Users can log in, unlock achievements, and track their musical learning progress.
 */
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
    private int points;
    private ArrayList<String> achievements;
    private ArrayList<String> leaderboardRanking;
    private ArrayList<User> friends;
    private ArrayList<Achievement> unlockedAchievements = new ArrayList<>();
    private ArrayList<String> completedChapters;
    private ArrayList<Song> savedSongs = new ArrayList<>();
    private String lastSong;


    /**
     * constructs a new {@code User} with a unique ID and initial values.
     *
     * @param userName  the user's username
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param password  the user's password
     * @param email     the user's email address
     */
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
        this.points = 0;
        this.completedChapters = new ArrayList<>();
    }

    /**
     * constructs a {@code User} from pre-loaded data, typically from JSON.
     *
     * @param id           the user's UUID
     * @param userName     the user's username
     * @param firstName    the user's first name
     * @param lastName     the user's last name
     * @param password     the user's password
     * @param email        the user's email address
     * @param streak       the user's current streak
     * @param level        the user's current level
     * @param achievements a list of achievement names the user has unlocked
     */
    public User(UUID id, String userName, String firstName, String lastName, String password, String email, int streak, int level, ArrayList<String> achievements, int points, ArrayList<String> completedChapters) {
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
        this.points = points;
        this.completedChapters =  completedChapters != null ? completedChapters : new ArrayList<>();
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

    public void setLastSong(String lastSong) {
        this.lastSong = lastSong;
    }

    public String getLastSong() {
        return lastSong;
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

    public int getPoints() {
        return points;
    }
    public void addPoints(int amount) {
        this.points += amount;
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

    public ArrayList<User> getFriends() {
        return friends;
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
    public boolean hasCompletedChapter(String chapter) {
        return completedChapters.contains(chapter);
    }

    public void markChapterComplete(String chapter) {
        if (!completedChapters.contains(chapter)) {
            completedChapters.add(chapter);
        }
    }

    public ArrayList<String> getCompletedChapters() {
        return completedChapters;
    }

    public ArrayList<Song> getSavedSongs() {
        return savedSongs;
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
