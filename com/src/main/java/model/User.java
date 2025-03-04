package model;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.UUID; // import for generating unique UUIDs ? or think about json files here i think 
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9

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
<<<<<<< HEAD
    private ArrayList<User> friends; //add friends list to the uml 
=======
    private ArrayList<User> friends; // add friends list in uml
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9

    public User(String uuid, String username, String firstname, String lastname, String password, String email) {
        this.uuid = uuid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
<<<<<<< HEAD
        this.friends = new ArrayList<>(); // initialize friends list
=======
        this.friends = new ArrayList<>(); // iitialize friends list
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
        this.streak = 0;
        this.level = 1;
        this.rankings = 0;
    }

<<<<<<< HEAD
    // getter for username (needed for UserList) - add to uml 
=======
    // getter for username (needed for UserList)
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
    public String getUsername() {
        return username;
    }

<<<<<<< HEAD
=======
    // getter for password 
    public String getPassword() {
        return password;
    }

>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
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
<<<<<<< HEAD
            friend.friends.add(this); // mutual friendship
        }
    }
=======
            friend.friends.add(this); // friendship
        }
    } 
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9

    public int getLeaderboardRanking() {
        return rankings;
    }

    public void updateRanking() {
<<<<<<< HEAD
        rankings++; // placeholder logic needs to be based on score system
=======
        rankings++; // placeholder logic
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
    }

    public void displayLeaderboard() {
        System.out.println("Displaying leaderboard"); // placeholder
    }

    // adding UUID generation
    public static User register(String name, String email, String password) {
        return new User(UUID.randomUUID().toString(), name, "", "", password, email);
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
<<<<<<< HEAD
        return true; // placeholder method just assumes that our user took the quiz successful
=======
        return true; // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
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
<<<<<<< HEAD
        return new ArrayList<>(); // placeholder for leaderboard retrieval
=======
        return new ArrayList<>(); // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
    }

    public ArrayList<Achievement> viewAchievements() {
        return achievements;
    }

    public void startFlashcardSession() {
        System.out.println("Starting flashcard session.");
    }

    public boolean answerFlashcard(String flashcardID, String answer) {
<<<<<<< HEAD
        return true; // assumes answer is correct
=======
        return true; // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
    }
}
