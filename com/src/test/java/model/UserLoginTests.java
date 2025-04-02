/*
 * @author lily 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests login functionality for the User class
 */
public class UserLoginTests {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("lilydeller", "Lily", "Deller", "thousandoaks", "lily@email.com");
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        assertTrue(user.login("lilydeller", "thousandoaks"), "Login should succeed with correct username and password");
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        assertFalse(user.login("lilydeller", "wrongpassword"), "Login should fail with incorrect password");
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        assertFalse(user.login("wrongusername", "thousandoaks"), "Login should fail with incorrect username");
    }
}
