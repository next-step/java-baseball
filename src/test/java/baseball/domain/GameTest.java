package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
	@DisplayName("게임 초기화시 정답 생성")
	@Test
	void generateRightAnswer() throws Exception {
		// Given
		Game game = new Game(new GameNumberTestGenerator());

		// When
		GameNumbers rightAnswer = game.getRightAnswer();

		// Then
		GameNumbers input = new GameNumbers(Arrays.asList(1, 2, 3));
		assertThat(rightAnswer.equals(input)).isTrue();
	}

	@DisplayName("입력이 정답이면 게임은 종료된다.")
	@Test
	void isInputRightAnswer() throws Exception {
	    // Given
		Game game = new Game(new GameNumberTestGenerator());

	    // When
		game.play("123");

	    // Then
		assertThat(game.isFinished()).isTrue();
	}

	@DisplayName("입력이 정답이 아니라면 게임은 계속 진행된다.")
	@Test
	void isInputWrongAnswer() throws Exception {
	    // Given
		Game game = new Game(new GameNumberTestGenerator());

	    // When
		game.play("456");

	    // Then
		assertThat(game.isFinished()).isFalse();
	}

	@DisplayName("입력이 정답이 아니라면 게임 힌트를 받는다.")
	@Test
	void checkHint() throws Exception {
	    // Given
		Game game = new Game(new GameNumberTestGenerator());

	    // When
		GameHint gameHint = game.play("456");

		// Then
		assertThat(gameHint.countStrike()).isEqualTo(0);
		assertThat(gameHint.countBall()).isEqualTo(0);
		assertThat(gameHint.isNothing()).isTrue();
	}


	private static class GameNumberTestGenerator implements GameNumberGenerator {
		@Override
		public GameNumbers generate(int length) {
			return new GameNumbers(Arrays.asList(1, 2, 3));
		}
	}
}
