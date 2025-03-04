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

<<<<<<< HEAD
<<<<<<< HEAD
   
=======
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
    public void addUser(User user) {
<<<<<<< HEAD
 
=======
    public void addUser(String firstName, String lastName, String userName, String password, String email) {
        if (getUserByUsername(userName) == null) { // for no duplicates
            User newUser = new User(userName, firstName, lastName, password, email);
            users.add(newUser);
        }
>>>>>>> 350befe01d2f69b773e3da440f4ccfba6bd3c08b
=======
        users.add(user);
<<<<<<< HEAD
>>>>>>> 6560787b0b92bac136d87ada52ee114856c7fbe9
=======
        saveUsers();
>>>>>>> 8ab49ce595d7133e1eff94d24e2bc567d777d34f
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