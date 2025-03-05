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
    private int rankings;
    private ArrayList<User> friends;

    // Constructor with auto-generated UUID
    public User(String userName, String firstName, String lastName, String password, String email) {
        this.id = UUID.randomUUID();  // Automatically generate UUID
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.level = 1;
        this.streak = 0;
        this.rankings = 0;
    }

    // Constructor with all fields (including UUID passed in)
    public User(UUID id, String userName, String firstName, String lastName, String password, String email, int streak, int level, ArrayList<String> achievements) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.streak = streak;
        this.level = level;
        this.achievements = achievements;
        this.friends = new ArrayList<>();
    }

    // Getters and Setters
    public UUID getId() {
        return id;
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

    public boolean login(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
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

    public int getLeaderboardRanking() {
        return rankings;
    }

    public void setLeaderboardRanking(int rankings) {
        this.rankings = rankings;
    }

    public void updateRanking() {
        // Logic to update rankings
    }

    public void displayLeaderboard() {
        // Logic to display leaderboard
    }

    public User register(String name, String email, String password) {
        return new User(name, "", "", password, email);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public void updateProfile(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void resumeLesson() {
        // Logic to resume a lesson
    }

    public boolean takeQuiz(String lessonID) {
        // Logic for taking a quiz
        return true;
    }

    public void enableMetronome(int bpm) {
        // Logic for enabling metronome
    }

    public void recordPracticeSession() {
        // Logic to record a practice session
    }

    public void stopPracticeSession() {
        // Logic to stop a practice session
    }

    public ArrayList<User> viewLeaderBoard() {
        return new ArrayList<>(); // Placeholder
    }

    public ArrayList<String> viewAchievements() {
        return achievements;
    }

    public void startFlashcardSession() {
        // Logic to start a flashcard session
    }

    public boolean answerFlashcard(String flashcardID, String answer) {
        // Logic for answering a flashcard
        return true;
    }
}
