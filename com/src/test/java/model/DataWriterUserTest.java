/*
 * @author lily deller
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * testing writing and persistence of user data via  our DataWriter
 */
public class DataWriterUserTest {

    private UserList userList = UserList.getInstance();
    private ArrayList<User> users;

    @BeforeEach
    public void setUp() {
        userList.getUsers().clear();
        DataWriter.getInstance().saveUsers();
    }

    @AfterEach
    public void tearDown() {
        userList.getUsers().clear();
        DataWriter.getInstance().saveUsers();
    }

    @Test
    public void testWritingZeroUsers() {
        users = DataLoader.loadUsers();
        assertEquals(0, users.size(), "expected 0 users after clearing and saving an empty list");
    }

    @Test
    public void testWritingOneUser() {
        userList.addUser(new User("lilydeller", "Lily", "Deller", "piano123", "lily@email.com"));
        DataWriter.getInstance().saveUsers();
        users = DataLoader.loadUsers();
        assertEquals("lilydeller", users.get(0).getUserName(), "first saved username should be 'lilydeller'");
    }

    @Test
    public void testWritingFiveUsers() {
        for (int i = 1; i <= 5; i++) {
            userList.addUser(new User("user" + i, "First", "Last", "pass" + i, "user" + i + "@email.com"));
        }
        DataWriter.getInstance().saveUsers();
        users = DataLoader.loadUsers();
        assertEquals("user5", users.get(4).getUserName(), "fifth user should be 'user5'");
    }

    @Test
    public void testWritingEmptyUser() {
        userList.addUser(new User("", "", "", "", ""));
        DataWriter.getInstance().saveUsers();
        users = DataLoader.loadUsers();
        assertEquals("", users.get(0).getUserName(), "username should be empty string for blank user");
    }

    @Test
    public void testWritingNullUsername() {
        userList.addUser(new User(null, "First", "Last", "pass", "email@email.com"));
        DataWriter.getInstance().saveUsers();
        users = DataLoader.loadUsers();
        assertNull(users.get(0).getUserName(), "username should be null if written as null");
    }
}
