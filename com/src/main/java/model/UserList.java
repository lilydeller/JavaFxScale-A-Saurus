package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    // Private constructor for singleton pattern
    private UserList() {
        users = new ArrayList<>();
    }

    // Singleton pattern: get instance of UserList
    public static synchronized UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
        DataWriter.getInstance().saveUsers();
    }

    public User getUser(String userName, String password) {
        User user = getUserByUsername(userName);
        if (user != null && user.login(userName, password)) {  // Use user's login method
            return user;
        }
        return null; // No matching user found or incorrect password
    }

    public void editUser(String userName, String newFirstName, String newLastName, String newEmail) {
        User user = getUserByUsername(userName);
        if (user != null) {
            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
            DataWriter.getInstance().saveUsers();
        }
    }

    public User getUserByUsername(String userName) {
        if (users == null) return null;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}