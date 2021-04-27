package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BatterTest {
	Batter batter = new Batter();

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
			Arguments.of("123", Arrays.asList(1, 2, 3)),
			Arguments.of("456", Arrays.asList(4, 5, 6)),
			Arguments.of("789", Arrays.asList(7, 8, 9)),
			Arguments.of("534", Arrays.asList(5, 3, 4)),
			Arguments.of("987", Arrays.asList(9, 8, 7))
		);
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void testSwing(String input, List<Integer> expected) {
		List<Integer> swings = batter.swingBat(input);

		assertThat(swings).isEqualTo(expected);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"111", "012", "999", "1234", "9876", "12", "0"})
	void testSwingIllegalArgumentException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> batter.swingBat(input));
	}
}

