/*
 * @author lily deller 
 */
// package com.model;
import java.util.ArrayList;


public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private ArrayList<Lesson> lessons;
    private int streak;
    private int level;
    private ArrayList<Achievement> achievements;
    private int rankings;

    public User(String username, String firstname, String lastname, String password, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.streak = 0;
        this.level = 1;
        this.rankings = 0;
    }

    public boolean login(String username, String password) {
        return false; // Stub 
    }

    public void increaseStreak() {
        // Stub 
    }

    public void removeFriend(User friend) {
        // Stub 
    }

    public void addFriend(String userName) {
        // Stub 
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public int getLeaderboardRanking() {
        return rankings;
    }

    public void updateRanking() {
        // Stub 
    }

    public void displayLeaderboard() {
        // Stub 
    }

    public static User register(String name, String email, String password) {
        return new User(name, "", "", password, email);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        return false; // Stub 
    }

    public void updateProfile(String name, String email) {
        this.firstname = name;
        this.email = email;
    }

    public void resumeLesson() {
        // Stub 
    }

    public boolean takeQuiz(String lessonID) {
        return false; // Stub 
    }

    public void enableMetronome(int bpm) {
        // Stub 
    }

    public void recordPracticeSession() {
        // Stub 
    }

    public void stopPracticeSession() {
        // Stub 
    }

    public ArrayList<User> viewLeaderBoard() {
        return new ArrayList<>(); // Stub 
    }

    public ArrayList<Achievement> viewAchievements() {
        return achievements;
    }

    public void startFlashcardSession() {
        // Stub 
    }

    public boolean answerFlashcard(String flashcardID, String answer) {
        return false; // Stub
    }
}