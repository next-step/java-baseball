package javabaseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballRefereeTest {

	private final BaseballReferee referee = BaseballReferee.of();

	@DisplayName("정상적인 숫자를 입력받았을 때 true 리턴")
	@Test
	void isFare_shouldReturnTrue() {
		// given
		String normalNumberString = "123";

		// when
		boolean isFare = referee.isFair(normalNumberString);

		// then
		assertEquals(3, normalNumberString.length());
		assertTrue(isFare);
	}

	@DisplayName("숫자의 길이가 3이상일 때 false 리턴")
	@Test
	void isFare_shouldReturnFalse_whenUnExpectedLength1() {
		// given
		String longerLengthString = "1234";

		// when
		boolean longIsFare = referee.isFair(longerLengthString);

		// then
		assertNotEquals(3, longerLengthString.length());
		assertFalse(longIsFare);
	}

	@DisplayName("숫자의 길이가 3이하일 때 false 리턴")
	@Test
	void isFare_shouldReturnFalse_whenUnExpectedLength2() {
		// given
		String shorterLengthString = "12";

		// when
		boolean shortIsFare = referee.isFair(shorterLengthString);

		// then
		assertNotEquals(3, shorterLengthString.length());
		assertFalse(shortIsFare);
	}

	@DisplayName("각자리의 숫자가 1 ~ 9 가 아닐 경우 false 리턴")
	@ParameterizedTest
	@ValueSource(strings = {"012", "102", "120", "abc", "1ab", "a1b", "ab1", "+-+", "..."})
	void isFare_shouldReturnFalse_hasInvalidRangeNumber(String numberString) {
		// given value source

		// when
		boolean isFare = referee.isFair(numberString);

		// then
		assertEquals(3, numberString.length());
		assertFalse(isFare);
	}

	@DisplayName("중복된 숫자가 포함될 경우 false 리턴")
	@ParameterizedTest
	@ValueSource(strings = {"111", "112", "122", "313"})
	void isFare_shouldReturnFalse_hasDuplicatedNumber(String numberString) {
		// given value source

		// when
		boolean isFare = referee.isFair(numberString);

		// then
		assertEquals(3, numberString.length());
		assertFalse(isFare);
	}

	@DisplayName("정상적으로 스트라이크, 볼 판단")
	@ParameterizedTest
	// slash separated ball counts: ${strike}/${ball}
	@CsvSource({"456, 0/0", "154, 1/0", "234, 0/2", "312, 0/3", "523, 2/0", "213, 1/2", "123, 3/0"})
	void decideBalls_shouldReturnCorrect(
		String candidate, @ConvertWith(SlashBallCountConverter.class) BallCounts expectedBallCounts) {
		// given
		String target = "123";

		// when
		BallCounts decidedBallCounts = referee.decideBalls(candidate, target);

		// then
		assertTrue(decidedBallCounts.getBallCount() + decidedBallCounts.getStrikeCount() <= 3);
		assertEquals(expectedBallCounts, decidedBallCounts);
	}

	static class SlashBallCountConverter implements ArgumentConverter {

		@Override
		public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
			if (!(source instanceof String)) {
				throw new IllegalArgumentException("The argument should be a string: " + source);
			}
			try {
				String[] parts = ((String)source).split("/");
				int strikeCount = Integer.parseInt(parts[0]);
				int ballCount = Integer.parseInt(parts[1]);

				return BallCounts.of(strikeCount, ballCount);
			} catch (Exception e) {
				throw new IllegalArgumentException("Failed to convert", e);
			}
		}
	}
}