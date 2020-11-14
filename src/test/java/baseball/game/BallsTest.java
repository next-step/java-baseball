package baseball.game;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

	@DisplayName("볼 생성 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void construct(String numbers) {
		Balls balls = new Balls(numbers);

		assertThat(balls).isNotNull();
		testNumbers(balls, numbers);
	}

	private void testNumbers(Balls balls, String numbers) {
		int[] ballNumbers = getNumbers(balls);

		assertThat(ballNumbers.length).isEqualTo(numbers.length());
		assertThat(convertToString(ballNumbers)).isEqualTo(numbers);
	}

	private int[] getNumbers(Balls balls) {
		try {
			Field numbersField = balls.getClass().getDeclaredField("numbers");
			numbersField.setAccessible(true);
			return (int[])numbersField.get(balls);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private String convertToString(int[] numbers) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i : numbers) {
			stringBuilder.append(i);
		}
		return stringBuilder.toString();
	}

	@DisplayName("잘못된 문자열 사이즈로 생성 테스트")
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {" ", "1", "12", "1234"})
	void construct_ShouldThrowExceptionByWrongSize(String numbers) {
		assertThatThrownBy(() -> new Balls(numbers))
			.isInstanceOf(InvalidBallNumbersException.class);
	}

	@DisplayName("숫자가 아닌 문자를 포함한 생성 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"a12", "!@#", "b 1", "abc"})
	void construct_ShouldThrowExceptionByNonNumeric(String numbers) {
		assertThatThrownBy(() -> new Balls(numbers))
			.isInstanceOf(InvalidBallNumbersException.class);
	}

	@DisplayName("중복된 숫자를 포함한 생성 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"111", "112", "121", "122"})
	void construct_ShouldThrowExceptionByDuplicated(String numbers) {
		assertThatThrownBy(() -> new Balls(numbers))
			.isInstanceOf(InvalidBallNumbersException.class);
	}

	@DisplayName("허용되지 않는 숮자를 포함한 생성 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"011", "102", "120"})
	void construct_ShouldThrowExceptionByInvalidNumeric(String numbers) {
		assertThatThrownBy(() -> new Balls(numbers))
			.isInstanceOf(InvalidBallNumbersException.class);
	}
}