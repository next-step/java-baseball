package baseball.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.constants.GameConstants;

class GameTest {
	Game game;

	@BeforeEach
	void setUp() {
		game = Game.onGame();
	}

	@Test
	void validate_random_3_digit_number() {
		String number = game.getComputer().getNumber();
		assertTrue(Pattern.matches(GameConstants.REGEX_ALLOW_PLAYER_INPUT, number));
	}
}
