import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballCalculatorTest {
	@DisplayName("Get randomly generated answer with non-duplicate numbers successfully")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void getRandomAnswerTest(int maxDigit) {
		String result = BaseballCalculator.getRandomAnswer(maxDigit);
		assertThat(result.length()).isEqualTo(maxDigit);
		assertThat(result).containsOnlyDigits();
		assertThat(result).doesNotContain("0");

		Set<String> set = new HashSet<>();
		Collections.addAll(set, result.split(""));
		assertThat(set.size()).isEqualTo(maxDigit);
	}

	@DisplayName("Get strike count successfully")
	@ParameterizedTest
	@MethodSource("provideArgumentsForGetStrikeCountTest")
	void getStrikeCountTest(String answer, String input, int expectedCount) {
		int result = BaseballCalculator.getStrikeCount(answer, input);
		assertThat(result).isEqualTo(expectedCount);
	}

	// a static method that returns a Stream of Arguments for getStrikeCountTest
	private static Stream<Arguments> provideArgumentsForGetStrikeCountTest() {
		return Stream.of(
			Arguments.of("123", "231", 0),
			Arguments.of("123", "132", 1),
			Arguments.of("123", "124", 2),
			Arguments.of("123", "123", 3)
		);
	}

	@DisplayName("Get ball count successfully")
	@ParameterizedTest
	@MethodSource("provideArgumentsForGetBallCountTest")
	void getBallCountTest(String answer, String input, int expectedCount) {
		int result = BaseballCalculator.getBallCount(answer, input);
		assertThat(result).isEqualTo(expectedCount);
	}

	// a static method that returns a Stream of Arguments for getBallCountTest
	private static Stream<Arguments> provideArgumentsForGetBallCountTest() {
		return Stream.of(
			Arguments.of("123", "231", 3),
			Arguments.of("123", "132", 2),
			Arguments.of("123", "124", 0),
			Arguments.of("123", "123", 0),
			Arguments.of("123", "134", 1)
		);
	}
}
