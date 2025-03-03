package model;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    //prrivate constructor for singleton pattern
    private UserList() {
        users = new ArrayList<>();
    }

    // singleton pattern: get instance of UserList
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(String firstName, String lastName, String userName, String password, String email) {
        if (getUserByUsername(userName) == null) { // for no duplicates
            User newUser = new User(userName, firstName, lastName, password, email);
            users.add(newUser);
        }
    }

    public User getUser(String userName, String password) {
        User user = getUserByUsername(userName);
        if (user != null && user.login(userName, password)) {  // use user's login) method
            return user;
        }
        return null; // no matching user found or incorrect password
    }

    public void editUser(String userName, String newFirstName, String newLastName, String newEmail) {
        User user = getUserByUsername(userName);
        if (user != null) {
            user.updateProfile(newFirstName, newEmail);
        }
    }

    public void saveUsers() {
        // placeholder for JSON /  database writing logic
    }

    public User getUserByUsername(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
