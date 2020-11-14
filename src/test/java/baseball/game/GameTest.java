package baseball.game;

import static baseball.game.Game.*;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
	@ParameterizedTest
	@MethodSource("play")
	void play(String number, boolean expected) {
		GameScore score = dummyGame.play(new Balls(number));

		assertThat(score).isNotNull();
		assertThat(score.isCleared()).isEqualTo(expected);
	}

	private static Stream<Arguments> play() {
		return Stream.of(
			Arguments.of("123", true),
			Arguments.of("123", true),
			Arguments.of("321", false),
			Arguments.of("124", false),
			Arguments.of("234", false),
			Arguments.of("987", false),
			Arguments.of("541", false)
		);
	}
}
