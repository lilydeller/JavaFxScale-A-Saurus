package model;

import java.util.ArrayList;

public class User {
    private String uuid;
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
    private ArrayList<User> friends; //add friends list to the uml 

    public User(String uuid, String username, String firstname, String lastname, String password, String email) {
        this.uuid = uuid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.friends = new ArrayList<>(); // initialize friends list
        this.streak = 0;
        this.level = 1;
        this.rankings = 0;
    }

    // getter for username (needed for UserList) - add to uml 
    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void increaseStreak() {
        streak++;
    }

    public void removeFriend(User friend) {
        if (friends.contains(friend)) {
            friends.remove(friend);
            friend.friends.remove(this); // remove mutual friendship
        }
    }

    public void addFriend(String username) {
        User friend = UserList.getInstance().getUserByUsername(username);
        if (friend != null && !friends.contains(friend)) {
            friends.add(friend);
            friend.friends.add(this); // mutual friendship
        }
    }

    public int getLeaderboardRanking() {
        return rankings;
    }

    public void updateRanking() {
        rankings++; // placeholder logic needs to be based on score system
    }

    public void displayLeaderboard() {
        System.out.println("Displaying leaderboard"); // placeholder
    }

    public static User register(String name, String email, String password) {
        return new User(name, "", "", password, email);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public void updateProfile(String name, String email) {
        this.firstname = name;
        this.email = email;
    }

    public void resumeLesson() {
        System.out.println("Resuming last lesson"); // placeholder
    }

    public boolean takeQuiz(String lessonID) {
        return true; // placeholder method just assumes that our user took the quiz successful
    }

    public void enableMetronome(int bpm) {
        System.out.println("Metronome enabled at " + bpm + " BPM.");
    }

    public void recordPracticeSession() {
        System.out.println("Recording practice session");
    }

    public void stopPracticeSession() {
        System.out.println("Practice session stopped.");
    }

    public ArrayList<User> viewLeaderBoard() {
        return new ArrayList<>(); // placeholder for leaderboard retrieval
    }

    public ArrayList<Achievement> viewAchievements() {
        return achievements;
    }

    public void startFlashcardSession() {
        System.out.println("Starting flashcard session.");
    }

    public boolean answerFlashcard(String flashcardID, String answer) {
        return true; // assumes answer is correct
    }
}
