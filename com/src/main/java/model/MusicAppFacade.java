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

        return null;
    }

    public User signup(String username, String password) {

        return null;
    }

    public User addUserInfo(String firstName, String lastName) {
        return null;
    }

    public Song openSong(String songName) {
        return null;
    }

    public void addMeasure() {
 
    }

    public void playSong() {
 
    }

    public void selectMeasure(int measureNumber) {
  
    }

    public void stopSong() {

    }

    public void logout() {

    }
}
