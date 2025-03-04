package model;

import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.UUID; // import for generating unique UUIDs ? or think about json files here i think 
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
import java.util.UUID;
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f

public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private ArrayList<Lesson> lessons;
    private int level;
    private ArrayList<Achievement> achievements;
    private int rankings;
<<<<<<< HEAD
<<<<<<< HEAD
    private ArrayList<User> friends; //add friends list to the uml 
=======
    private ArrayList<User> friends; // add friends list in uml
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
    private ArrayList<User> friends;
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f

    public User(String userName, String firstName, String lastName, String password, String email) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.lessons = new ArrayList<>();
        this.achievements = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< HEAD
        this.friends = new ArrayList<>(); // initialize friends list
=======
        this.friends = new ArrayList<>(); // iitialize friends list
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
        this.streak = 0;
=======
        this.friends = new ArrayList<>();
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
        this.level = 1;
        this.rankings = 0;
    }

<<<<<<< HEAD
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
=======
    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
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

    public boolean login(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }

    public void addFriend(String userName) {
        // Implementation logic to find and add a friend
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }

<<<<<<< HEAD
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
=======
    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f

    public int getLeaderboardRanking() {
        return rankings;
    }

    public void updateRanking() {
<<<<<<< HEAD
<<<<<<< HEAD
        rankings++; // placeholder logic needs to be based on score system
=======
        rankings++; // placeholder logic
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
        // Logic to update rankings
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
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

    public void updateProfile(String name, String email) {
        this.userName = name;
        this.email = email;
    }

    public void resumeLesson() {
        // Logic to resume a lesson
    }

    public boolean takeQuiz(String lessonID) {
<<<<<<< HEAD
<<<<<<< HEAD
        return true; // placeholder method just assumes that our user took the quiz successful
=======
        return true; // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
        // Logic for taking a quiz
        return true;
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
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
<<<<<<< HEAD
<<<<<<< HEAD
        return new ArrayList<>(); // placeholder for leaderboard retrieval
=======
        return new ArrayList<>(); // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
        return new ArrayList<>(); // Placeholder
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
    }

    public ArrayList<Achievement> viewAchievements() {
        return achievements;
    }

    public void startFlashcardSession() {
        // Logic to start a flashcard session
    }

    public boolean answerFlashcard(String flashcardID, String answer) {
<<<<<<< HEAD
<<<<<<< HEAD
        return true; // assumes answer is correct
=======
        return true; // placeholder
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
        // Logic for answering a flashcard
        return true;
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
    }
}
