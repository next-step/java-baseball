package model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import view.InputView;

public class RandomBallNumbersTest {

	public static final int RANDOM_BALL_NUMBER_SIZE = 3;

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	@DisplayName("서로 1부터 9까지 서로다른 임의의 수 3자리 생성 테스트")
	void createRandomBallNumberTest(String randomBallNumber) {
		RandomBallNumbers randomBallNumbers = createRandomBallNumbers(randomBallNumber);

		int distinctNumberSize = new HashSet<>(randomBallNumbers.getRandomBallNumbers()).size();

		assertThat(randomBallNumbers.getRandomBallNumbers().size()).isEqualTo(distinctNumberSize);
		assertThat(randomBallNumbers.getRandomBallNumbers().size()).isEqualTo(RANDOM_BALL_NUMBER_SIZE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "1234"})
	@DisplayName("3자리 정수가 아닌 N자리 정수가 생성된 경우 테스트")
	void notEqualLengthRandomBallNumberTest(String randomBallNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createRandomBallNumbers(randomBallNumber);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"112", "122", "121", "111"})
	@DisplayName("중복된 임의의 수가 생성된 경우 테스트")
	void duplicateRandomBallNumberTest(String randomBallNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createRandomBallNumbers(randomBallNumber);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"120", "012", "102", "가12", "a12", "!12"})
	@DisplayName("서로 다른 3자리 임의의 수가 1부터 9까지 정수가 아닐 경우 테스트")
	void notEqualRangeRandomBallNumberTest(String randomBallNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createRandomBallNumbers(randomBallNumber);
		});
	}

	private RandomBallNumbers createRandomBallNumbers(String randomBallNumber) {
		return new RandomBallNumbers(InputView.stringToListConvert(randomBallNumber));
	}
}
