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
 * testing the loading of users via our DataLoader
 */
public class DataLoaderUserTest {

    private UserList userList = UserList.getInstance();
    private ArrayList<User> users;

    @BeforeEach
    public void setUp() {
        userList.getUsers().clear();
        userList.addUser(new User("lilydeller", "Lily", "Deller", "password123", "lily@email.com"));
        userList.addUser(new User("harryfan", "Harry", "Styles", "watermelon", "harry@email.com"));
        DataWriter.getInstance().saveUsers();
    }

    @AfterEach
    public void tearDown() {
        userList.getUsers().clear();
        DataWriter.getInstance().saveUsers();
    }

    @Test
    public void testGetUsersSize() {
        users = DataLoader.loadUsers();
        assertEquals(2, users.size(), "should load 2 users from JSON");
    }

    @Test
    public void testGetUserFirstUserName() {
        users = DataLoader.loadUsers();
        assertEquals("lilydeller", users.get(0).getUserName(), "first user's username should be 'lilydeller'");
    }

    @Test
    public void testGetUsersSizeZero() {
        userList.getUsers().clear();
        DataWriter.getInstance().saveUsers();
        users = DataLoader.loadUsers();
        assertEquals(0, users.size(), "should load 0 users after clearing user list");
    }
}
