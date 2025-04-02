/*
 * @author lily 
 */
package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UserListTests {
    
    private UserList userList;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
        userList.getUsers().clear();
    }

    @Test
    public void testAddUserValid() {
        User testUser = new User("lilyd", "Lily", "Deller", "lily@email.com", "password123");
        userList.addUser(testUser);
        
        User fetchedUser = userList.getUserByUsername("lilyd");

        assertNotNull(fetchedUser);
        assertEquals("Lily", fetchedUser.getFirstName());
        assertEquals("Deller", fetchedUser.getLastName());
        assertEquals("lily@email.com", fetchedUser.getEmail());
        assertEquals("lilyd", fetchedUser.getUserName());
    }
}
