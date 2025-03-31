package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {

    private UserList userList = UserList.getInstance();
    private final String USER_FILE_NAME = "json/userlist.json";



    @AfterEach
    public void teardown() {
        userList.getUsers().clear();
        DataWriter.saveUsers(); 
    }

    @Test
    public void testSaveUsers_FileExists() {
        File file = new File(USER_FILE_NAME);
        assertTrue(file.exists(), "User JSON file should exist after saveUsers()");
    }

    @Test
    public void testSaveUsers_DataPersistence() {
        
        ArrayList<User> loadedUsers = DataLoader.loadUsers();
        assertEquals("lilydeller", loadedUsers.get(0).getUserName());
    }

    @Test
    public void testSaveUsers_JSONStructure() {
        try {
            JSONObject root = (JSONObject) new JSONParser().parse(new FileReader(USER_FILE_NAME));
            assertNotNull(root.get("users"));
        } catch (Exception e) {
            fail("Failed to read or parse saved user JSON file");
        }
    }

    @Test
    public void testSaveUsers_EmptyList() {
        userList.getUsers().clear();
        DataWriter.saveUsers();

        ArrayList<User> loadedUsers = DataLoader.loadUsers();
        assertEquals(0, loadedUsers.size());
    }
}
