package model;

import java.util.ArrayList;
/*
 * operates the frontend actions a use can do 
 */
public class MusicAppFacade {
    private static MusicAppFacade instance;
    private UserList userList;
    private SongList songList;
    private User currentUser;
    private Song currentSong;

    /*
     * construct singleton instance of facade 
     */
    private MusicAppFacade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        currentUser = null;
        currentSong = null;
    }

    /*
     * getter method for facade instance 
     * @return instance of facade 
     */
    public static MusicAppFacade getInstance() {
        if (instance == null) {
            instance = new MusicAppFacade();
        }
        return instance;
    }

    /*
     * logs in the user 
     * @param username 
     * @param password
     * @return the current logged in user 
     */
    public User login(String username, String password) {
        UserList userlist = UserList.getInstance();
        currentUser = userList.getUser(username, password);
        return currentUser;
        
    }
    
    /*
     * creates new account for user to log into 
     * @param username
     * @param email
     * @param password
     * @return the new user, if already exists return null
     */
    public User signup(String username, String email, String password) {
        if (userList.getUserByUsername(username) == null) { //make sure user doesnt alread exist;
            currentUser = new User(username, "", "", password, ""); //call random UUID constructor 
            userList.addUser(currentUser);
            return currentUser;
        }
        return null; //user already exists
    }

    /*
     * update users info 
     * @param firstName
     * @param lastName
     * @return currentUser , if user does not exist return null
     */
    public User addUserInfo(String firstName, String lastName) {
        if (currentUser != null) { //make sure current user is already assigned 
            currentUser.setFirstName(firstName);
            currentUser.setLastName(lastName);
            return currentUser;
        }
        return null; //no current user exists 
    }

    /*
     * opens a song
     * @param songName 
     * @RETURN currentSong
     */
    public Song openSong(String songName) {
        currentSong = songList.getSong(songName);
        return currentSong;
    }

    public void addMeasure() {
        if (currentSong != null) {
            int newMeasureNumber = currentSong.getMeasures().size() + 1; //number of measures until append new measure
            Measure newMeasure = new Measure(newMeasureNumber, new ArrayList<>());

            currentSong.addMeasure(newMeasure); //append measure to song 
            System.out.println("Added measure " + newMeasureNumber + " to song: " + currentSong.getSongName());
        }
        else {
            System.out.println("no song is currently open");
        }
    }

    public void playSong() {
        if (currentSong != null) {
            MusicProgram.playSong(currentSong.getSongName());
        }
        else {
            System.out.println("no song is currently selected");
        }
    }
/*

    public void selectMeasure(int measureNumber) {
  
    }
 */
  

    public void stopSong() {
        MusicProgram.stopSong();
    }

    public void logout() {
        if (currentUser != null) {
            saveAll();
            System.out.println("logging out: " + currentUser.getUserName());

            currentUser = null;
            currentSong = null;


        }
        else {
            System.out.println("No one is logged in");
        }
    }

    public void saveAll() {
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        userList.saveUsers();
        songList.saveSongs();
    }
    public static void main(String[] args) {
        MusicAppFacade facade = MusicAppFacade.getInstance();

        // Test Sign-up and Login
        System.out.println("Testing Sign-up:");
        User user = facade.signup("testUser", "test@example.com", "password123");
        if (user != null) {
            System.out.println("User signed up successfully: " + user.getUserName());
        } else {
            System.out.println("User already exists.");
        }

        System.out.println("\nTesting Login:");
        user = facade.login("testUser", "password123");
        if (user != null) {
            System.out.println("User logged in successfully: " + user.getUserName());
        } else {
            System.out.println("Login failed.");
        }

        // Add user info
        facade.addUserInfo("John", "Doe");
        System.out.println("User info updated: " + user.getFirstName() + " " + user.getLastName());

        // Test opening a song
        System.out.println("\nTesting Open Song:");
        Song song = facade.openSong("MySong");
        if (song != null) {
            System.out.println("Opened song: " + song.getSongName());
        } else {
            System.out.println("Song not found.");
        }

        // Test adding measures
        System.out.println("\nTesting Add Measure:");
        facade.addMeasure();
        facade.addMeasure();

        // Test playing and stopping song
        System.out.println("\nTesting Play Song:");
        facade.playSong();

        System.out.println("\nTesting Stop Song:");
        facade.stopSong();

        // Test logout
        System.out.println("\nTesting Logout:");
        facade.logout();
    }
}
