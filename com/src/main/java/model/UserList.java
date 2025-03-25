package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    // private constructor for singleton pattern
    private UserList() {
        users = new ArrayList<>();
    }

    // singleton pattern to get instance of UserList
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
        if (user != null && user.login(userName, password)) {  //  user's login method
            return user;
        }
        return null; // no matching user found or  like incorrect password
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

    public boolean isUsernameTaken(String username) {
        return users.stream().anyMatch(u -> u.getUserName().equalsIgnoreCase(username));
    }
    


    public void saveUsers() {
        DataWriter.saveUsers();
    }
}