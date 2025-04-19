package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * MusicAppFacade manages frontend-facing operations like login,
 * song creation, and interaction with the UserList and SongList.
 */
public class MusicAppFacade {
    private static MusicAppFacade instance;
    private UserList userList;
    private SongList songList;
    private User currentUser;
    private Song currentSong;

   
    private MusicAppFacade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        currentUser = null;
        currentSong = null;
    }

    public static MusicAppFacade getInstance() {
        if (instance == null) {
            instance = new MusicAppFacade();
        }
        return instance;
    }

    // Login logic
    public User login(String username, String password) {
        currentUser = userList.getUser(username, password);
        return currentUser;
    }

    // Signup logic
    public User signup(String username, String email, String password) {
        if (userList.getUserByUsername(username) == null) {
            currentUser = new User(username, "", "", password, email);
            userList.addUser(currentUser);
            return currentUser;
        }
        return null;
    }

    // Set user info after signup
    public User addUserInfo(String firstName, String lastName) {
        if (currentUser != null) {
            currentUser.setFirstName(firstName);
            currentUser.setLastName(lastName);
            return currentUser;
        }
        return null;
    }

    public User searchUserByUsername(String username) {
        return UserList.getInstance().getUserByUsername(username);
    }
    
    public User searchUserByName(String firstName, String lastName) {
        return UserList.getInstance().getUserByName(firstName, lastName);
    }
    
    public boolean addFriendToCurrentUser(User friend) {
        if (currentUser != null && friend != null && !currentUser.getUserName().equals(friend.getUserName())) {
            currentUser.addFriend(friend);
            UserList.getInstance().saveUsers();
            return true;
        }
        return false;
    }

    public User getUserByUsername(String username) {
        return UserList.getInstance().getUserByUsername(username);
    }
    
    public User getUserByFullName(String firstName, String lastName) {
        for (User u : UserList.getInstance().getUsers()) {
            if (u.getFirstName().equalsIgnoreCase(firstName)
                    && u.getLastName().equalsIgnoreCase(lastName)) {
                return u;
            }
        }
        return null;
    }
    
    

    // Accessors
    public User getCurrentUser() {
        return currentUser;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    // Open a song by name
    public Song openSong(String songName) {
        currentSong = songList.getSong(songName);
        return currentSong;
    }

    // Add a new measure to current song
    public void addMeasure() {
        if (currentSong != null) {
            int newMeasureNumber = currentSong.getMeasures().size() + 1;
            Measure newMeasure = new Measure(newMeasureNumber, new ArrayList<>());
            currentSong.addMeasure(newMeasure);
            System.out.println("Added measure " + newMeasureNumber + " to " + currentSong.getSongName());
        } else {
            System.out.println("No song is currently open");
        }
    }

    // Play the current song
    public void playSong() {
        if (currentSong != null) {
            MusicProgram.playSong(currentSong.getSongName());
        } else {
            System.out.println("No song is selected.");
        }
    }

    public void createAndSaveSong(String name, String artist, int difficulty, String length, String genre, ArrayList<Measure> measures) {
        if (name == null || measures == null || measures.isEmpty()) {
            System.out.println("Song must have a name and at least one measure.");
            return;
        }
    
        String songId = UUID.randomUUID().toString();
        Song newSong = new Song(songId, name, difficulty, length, genre, measures, "", "", false, artist);
    
        songList.addSong(newSong);
        songList.saveSongs();
        currentSong = newSong;
    
        System.out.println("🎵 Song '" + name + "' by " + artist + " created and saved.");
    }
    
   

    // Save everything
    public void saveAll() {
        userList.saveUsers();
        songList.saveSongs();
    }

    
    public List<Song> filterSongs(String query, String artistRange, String genre, int difficultyRange) {
        return SongList.getInstance().filterSongs(query, artistRange, genre, difficultyRange);
    }
    
    

    // Logout current user
    public void logout() {
        if (currentUser != null) {
            saveAll();
            System.out.println("Logging out: " + currentUser.getUserName());
            currentUser = null;
            currentSong = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
}
