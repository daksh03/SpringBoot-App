package entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.entity.User;

public class UserTest {
	
	@Test
	public void userTest() {
		User user = new User();
		user.setUsername("Daksh");
		user.setPassword("daksh1");
		
		Assertions.assertEquals("Daksh", user.getUsername());
		Assertions.assertEquals("daksh1", user.getPassword());
	}

}
