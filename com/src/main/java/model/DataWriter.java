package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
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
        User users = users.getInstace();
        ArrayList<User> userList = users.getUser();

        JSONArray jsonUsers = new JSONArray();

        //create json objects 
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));

        }
        //write json
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } 
        //catch {
        //    e.printStackTrace();
        //}
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject
    }

    public void saveSongs() {
     
    }

    public void saveUserData(User user) {

    }

    public void saveFlashcardProgress(User user, String lessonID, ProgressData progressData) {
    
    }
    
}
