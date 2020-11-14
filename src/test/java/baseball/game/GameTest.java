package baseball.game;

import static baseball.game.Game.*;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	Game dummyGame;

	@BeforeEach
	void setUp() {
		dummyGame = new Game(new OneTwoThreeNumbersGenerator());
	}

	@DisplayName("게임 생성 테스트")
	@Test
	void construct() {
		Game game = new Game();

		assertThat(game).isNotNull();
		assertThat(getNumbers(game).length).isEqualTo(BALL_COUNT);
	}

	private int[] getNumbers(Game game) {
		try {
			Field numbersField = game.getClass().getDeclaredField("numbers");
			numbersField.setAccessible(true);
			return (int[])numbersField.get(game);

		} catch (IllegalAccessException | NoSuchFieldException e ) {
			throw new RuntimeException(e);
		}
	}

	@DisplayName("게임 플레이 테스트")
	@Test
	void play() {
		GameScore score = dummyGame.play(new Balls("123"));

		assertThat(score).isNotNull();
	}
}
