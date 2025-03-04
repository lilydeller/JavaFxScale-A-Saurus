package model;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    // Private constructor for singleton pattern
    private UserList() {
        users = new ArrayList<>();
    }

    // Singleton pattern: get instance of UserList
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
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
            user.updateProfile(newFirstName, newEmail);
            saveUsers();
        }
    }

    public void saveUsers() {
        DataWriter.saveUsers(users);
    }

    public User getUserByUsername(String userName) {
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