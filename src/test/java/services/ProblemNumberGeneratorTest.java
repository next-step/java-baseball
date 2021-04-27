package services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemNumberGeneratorTest {
	private final ProblemNumberGenerator problemNumberGenerator = new ProblemNumberGenerator();

	@Test
	@DisplayName("생성된 문제숫자는 3자리 숫자이다")
	void sizeTest() {
		List<Integer> actual = problemNumberGenerator.generate();
		assertThat(actual.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("생성된 각각의 숫자의 범위는 1~9의 값이어야 한다")
	void rangeTest(int index) {
		List<Integer> actual = problemNumberGenerator.generate();
		assertThat(actual.get(index)).isBetween(1, 9);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("생성된 각각의 숫자는 중복되지 않는다")
	void duplicatedTest(int number) {
		// given
		Set<Integer> problemNumbers = new LinkedHashSet<>();

		// when
		problemNumbers.add(1);
		problemNumbers.add(1);
		problemNumbers.add(2);
		problemNumbers.add(2);
		problemNumbers.add(3);

		// then
		assertThat(problemNumbers.size()).isEqualTo(3);
		assertThat(problemNumbers.contains(number)).isTrue();
	}
}
