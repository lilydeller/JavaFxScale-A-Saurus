// package com.model;

public class DataLoader {
    private static DataLoader instance;
    private UserList userList;
    private SongList songList;

    // priivate constructer
    private DataLoader() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    // singleton pattern to get instance of DataLoader
    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
    }


    public void loadUsers() {
      
    }

    public void loadSongs() {
      
    }
}
