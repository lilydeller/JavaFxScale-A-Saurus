package model;

public class MusicAppFacade {
    private static MusicAppFacade instance;
    private UserList userList;
    private SongList songList;
    private User currentUser;
    private Song currentSong;

    // priv cnstructer
    private MusicAppFacade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        currentUser = null;
        currentSong = null;
    }

    // singleton pettern: to get instance of MusicAppFacade
    public static MusicAppFacade getInstance() {
        if (instance == null) {
            instance = new MusicAppFacade();
        }
        return instance;
    }


    public User login(String username, String password) {

        currentUser = userList.getUser(username, password);
        return currentUser;
        
    }

    public User signup(String username, String email, String password) {
        if (userList.getUserByUsername(username) == null) { //make sure user doesnt alread exist;
            currentUser = new User(username, "", "", password, ""); //call random UUID constructor 
            userList.addUser(currentUser);
            return currentUser;
        }
        return null; //user already exists
    }

    public User addUserInfo(String firstName, String lastName) {
        if (currentUser != null) { //make sure current user is already assigned 
            currentUser.setFirstName(firstName);
            currentUser.setLastName(lastName);
            return currentUser;
        }
        return null; //no current user exists 
    }

    public Song openSong(String songName) {
        currentSong = songList.getSong(songName);
        return currentSong;
    }

    public void addMeasure() {
        if (currentSong != null) {
            int newMeasureNumber = currentSong.getMeasures().size() + 1; //number of measures until append new measure
            Measure newMeasure = new Measure(newMeasureNumber);

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
            System.out.println("logging out: " + currentUser.getUserName());

            currentUser = null;
            currentSong = null;


        }
        else {
            System.out.println("No one is logged in");
        }
    }
}
