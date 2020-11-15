package baseball.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.player.Computer;
import baseball.player.User;

class GameRuleTest {
	User user;
	Game game;
	GameRule gameRule;

	@BeforeEach
	void setUp() throws NoSuchFieldException, IllegalAccessException {
		game = Game.onGame();
		Field computerField = game.getClass().getDeclaredField("computer");
		computerField.setAccessible(true);
		computerField.set(game, new Computer("123"));

		user = game.getUser();

		gameRule = new GameRule(game);
		Field gameCountField = gameRule.getClass().getDeclaredField("gameCount");
		gameCountField.setAccessible(true);
		gameCountField.set(gameRule, new GameCount());
	}

	@Test
	void isThreeStrikeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		user.setNumber("123");
		Method isThreeStrike = gameRule.getClass().getDeclaredMethod("isThreeStrike");
		isThreeStrike.setAccessible(true);

		boolean result = (boolean)isThreeStrike.invoke(gameRule);
		assertTrue(result);
	}

	@Test
	void judgeGameCountTest() throws NoSuchFieldException, IllegalAccessException {
		user.setNumber("132");
		gameRule.judgeGameCount();

		Field gameCountField = gameRule.getClass().getDeclaredField("gameCount");
		gameCountField.setAccessible(true);
		GameCount gameCount = (GameCount)gameCountField.get(gameRule);

		assertEquals(1, gameCount.getStrikeCount());
		assertEquals(2, gameCount.getBallCount());
	}
}
