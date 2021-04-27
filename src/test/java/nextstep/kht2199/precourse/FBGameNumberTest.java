package nextstep.kht2199.precourse;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FBGameNumberTest {

	FBGameNumber number = new FBGameNumber();

	@RepeatedTest(10)
	@DisplayName("중복되지 않은 3자리 숫자를 생성")
	void generateNumber() {
		String s = String.valueOf(number.generateNumber());
		Set<Character> charSet = new HashSet<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			charSet.add(aChar);
		}
		assertThat(charSet.size())
			.isEqualTo(3)
		;
	}

	@ParameterizedTest
	@DisplayName("3자리 숫자 2개를 비교해 자리와 숫자가 일치하는 갯수 반환 (Strike)")
	@MethodSource("countStrikeSource")
	void countStrikeTest(int base, int target, int match) {
		assertThat(number.countStrike(base, target)).isEqualTo(match);
	}

	static Stream<Arguments> countStrikeSource() {
		return Stream.of(
			Arguments.of(123, 123, 3),
			Arguments.of(123, 124, 2),
			Arguments.of(123, 145, 1),
			Arguments.of(123, 234, 0)
		);
	}

}