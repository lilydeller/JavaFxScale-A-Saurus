package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * {@code UserList} class manages the list of all users in the application.
 * It follows the singleton pattern to ensure a single shared instance throughout the program.
 * It supports user registration, retrieval, editing, and persistence via {@link DataWriter}.
 */
public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

   
    private UserList() {
        users = new ArrayList<>();
    }


    /**
     * returns the singleton instance of {@code UserList}.
     *
     * @return the single {@code UserList} instance
     */
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

    /**
     * returns a user matching the given username and password credentials.
     * uses the {@link User#login(String, String)} method for validation.
     *
     * @param userName the username to match
     * @param password the password to match
     * @return the matching {@code User}, or {@code null} if no match is found
     */
    public User getUser(String userName, String password) {
        User user = getUserByUsername(userName);
        if (user != null && user.login(userName, password)) {  
            return user;
        }
        return null; 
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

    /**
     * retrieves a user by their username.
     *
     * @param userName the username to search for
     * @return the {@code User} with the matching username, or {@code null} if not found
     */
    public User getUserByUsername(String userName) {
        if (users == null) return null;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String firstName, String lastName) {
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(firstName) &&
                user.getLastName().equalsIgnoreCase(lastName)) {
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