//package com.model;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    // private constucter
    private UserList() {
        users = new ArrayList<>();
    }

    // singleton pettern : get instance of UserList
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

   
    public void addUser(String firstName, String lastName, String userName, String password) {
 
    }

    public User getUser(String userName, String password) {

        return null;
    }

    public void editUser() {

    }

    public void saveUsers() {
  
    }
}
