package model;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersTest {

    private User user;

    
    @BeforeEach
    public void setUp() {
        user = new User("lilydeller", "lily", "deller", "thousandoaks", "lily@email.com");
    }

    
    @Test
    public void testGetUserName() {
        assertEquals("lilydeller", user.getUserName(), "The username should be lilydeller");
    }

    
    @Test
    public void testGetEmail() {
        assertEquals("lily@email.com", user.getEmail(), "The email should be lily@email.com");
    }

    
    @Test
    public void testSetFirstName() {
        user.setFirstName("Quinn");
        assertEquals("Quinn", user.getFirstName(), "The first name should be updated to Quinn");
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(user.login("lilydeller", "thousandoaks"), "login should be successful with correct credentials");
    }

 
    @Test
    public void testLoginFailure() {
        assertFalse(user.login("lilydeller", "wrongpassword"), "Login should fail with the incorrect password");
    }

}
