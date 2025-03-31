package model;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

    private UserList userList = UserList.getInstance();
    private SongList songList = SongList.getInstance();

    @BeforeEach
    public void setup() {
        userList.getUsers().clear();
        songList.getSongs().clear();
    }

    @AfterEach
    public void tearDown() {
        userList.getUsers().clear();
        songList.getSongs().clear();
    }

    @Test
    public void testLoadUsersSize() {
        ArrayList<User> users = DataLoader.loadUsers();
        assertNotNull(users);
        assertEquals(2, users.size()); 
    }

    @Test
    public void testLoadUsersFirstUserName() {
        ArrayList<User> users = DataLoader.loadUsers();
        assertNotNull(users);
        assertEquals("lilydeller", users.get(0).getUserName()); 
    }

    @Test
    public void testLoadSongsSize() {
        ArrayList<Song> songs = DataLoader.loadSongs();
        assertNotNull(songs);
        assertEquals(2, songs.size());
    }

    @Test
    public void testLoadSongsFirstSongName() {
        ArrayList<Song> songs = DataLoader.loadSongs();
        assertNotNull(songs);
        assertEquals("Sign of the times", songs.get(0).getSongName()); 
    }

    @Test
    public void testAchievementsLoad() {
        DataLoader.loadAchievements();
        ArrayList<Achievement> achievements = DataLoader.getAchievements();
        assertNotNull(achievements);
        assertTrue(achievements.size() > 0); 
    }
}
