package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@DisplayName("랜덤 넘버 생성 검증")
	@Test
	void generateRandomRightAnswer() throws Exception {
		// Given
		Game game = new Game(new GameNumberRandomGenerator());

		// When
		GameNumbers rightAnswer = game.getRightAnswer();

		// Then
		int count = 0;
		List<Integer> verificationList = new ArrayList<>();
		for (Integer integer : rightAnswer) {
			assertThat(verificationList).doesNotContain(integer);
			assertThat(integer).isBetween(1, 9);
			verificationList.add(integer);
			count++;
		}
		assertThat(count).isEqualTo(Game.MAX_GAME_NUMBER_LENGTH);
	}

	@DisplayName("유효하지 않은 값을 입력시 에러 발생")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "1", "1111"})
	void validateInput(String input) throws Exception {
		// Given
		Game game = new Game(new GameNumberTestGenerator());

		// When
		// Then
		assertThatExceptionOfType(InvalidGameInputException.class)
			.isThrownBy(() -> game.convertInputToGameNumbers(input));
	}

	private static class GameNumberTestGenerator implements GameNumberGenerator {
		@Override
		public GameNumbers generate(int length) {
			return new GameNumbers(Arrays.asList(1, 2, 3));
		}
	}
}
