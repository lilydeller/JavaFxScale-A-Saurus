package model;

public class DataWriter {
    private static DataWriter instance;
    private UserList userList;
    private SongList songList;

    // priivate constructor
    private DataWriter() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    // singleton pettern to get instance of DataWriter
    public static DataWriter getInstance() {
        if (instance == null) {
            instance = new DataWriter();
        }
        return instance;
    }


    public void saveUsers() {
   
    }

    public void saveSongs() {
     
    }

    public void saveUserData(User user) {

    }
/* 
    public void saveFlashcardProgress(User user, String lessonID, ProgressData progressData) {
    
    }
    */
}
