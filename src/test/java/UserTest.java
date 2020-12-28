package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.User;

class UserTest {
	
	private User user;
	
	@BeforeEach
	void setUp() {
		user = new User();
	}

	@Test
	void testLengthIsThree() {
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("1234"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput(""));	
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("12"));
		
		assertEquals(user.checkValidInput("123"), true);
		
	}
	@Test
	void testNumberIsOneToNine() {
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("12a"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("012"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("ㄱ12"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("!12"));

		assertEquals(user.checkValidInput("456"), true);
		
	}
	@Test
	void testNumberIsNotDuplicate() {
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("111"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("122"));
		assertThrows(IllegalArgumentException.class, 
				() -> user.checkValidInput("311"));
		
		assertEquals(user.checkValidInput("789"), true);
	}

}
