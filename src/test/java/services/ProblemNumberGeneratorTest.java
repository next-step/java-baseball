package services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemNumberGeneratorTest {
	private final ProblemNumberGenerator problemNumberGenerator = new ProblemNumberGenerator();

	@Test
	@DisplayName("size of generated problem number must be 3")
	void sizeTest() {
		List<Integer> actual = problemNumberGenerator.generate();
		assertThat(actual.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("range of each number of problem number must be 1~9")
	void rangeTest(int index) {
		List<Integer> actual = problemNumberGenerator.generate();
		assertThat(actual.get(index)).isBetween(1, 9);
	}
}
