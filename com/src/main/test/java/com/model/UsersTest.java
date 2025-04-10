package src.com.model;

import org.junit.Test;
import org.junit.Assert;
import com.model.*;

public class UsersTest {
    private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new User("asmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new User("bwhite", "Bob", "White", 23, "803-333-3544"));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		boolean hasAmy = users.haveUser("asmith");
		assertTrue(hasAmy);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		boolean hasBob = users.haveUser("bwhite");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveUserInValid() {
		boolean hasJoe = users.haveUser("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null);
		assertFalse(hasNull);
	}
}
