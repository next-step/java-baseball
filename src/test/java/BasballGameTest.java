package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.BaseballGame;

class gameTest {
	
	private BaseballGame game;
	
	@BeforeEach
	void setUp() {
		game = new BaseballGame();
	}

	@Test
	void testIsNewGame() {
		assertThrows(IllegalArgumentException.class, 
				() -> game.checkInput("1234"));
		assertThrows(IllegalArgumentException.class, 
				() -> game.checkInput(""));
		assertThrows(IllegalArgumentException.class, 
				() -> game.checkInput("ㄱ"));
		assertThrows(IllegalArgumentException.class, 
				() -> game.checkInput("a"));
		assertThrows(IllegalArgumentException.class, 
				() -> game.checkInput("!"));
		assertEquals(game.checkInput("1"), true);
		assertEquals(game.checkInput("2"), false);
	}
	
	@Test
	void testMatch() {
		assertEquals(game.match("123", "123"), false);
		assertEquals(game.match("123", "231"), true);
		assertEquals(game.match("123", "321"), true);
		assertEquals(game.match("123", "456"), true);
	}

}
