package machine;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {
	private static final int MAX_SIZE_OF_RANDOM = 987;

	@Test
	@DisplayName("생성한 숫자가 987보다 작다")
	void generateNumberShouldBeUnder987WhenItIsCreated() {
		// given
		RandomGenerator generator = new RandomGenerator();

		// when
		int result = generator.generate();

		// then
		assertThat(result).isLessThanOrEqualTo(MAX_SIZE_OF_RANDOM);
	}

	@Test
	@DisplayName("생성한 랜덤 넘버의 자릿수가 각각 달라야 한다")
	void generateNumberDigitShouldBeDifferentWhenItIsCreated() {
		// given
		RandomGenerator generator = new RandomGenerator();

		// when
		int result = generator.generate();

		// then
		Set<Character> notDuplicatedSet = new HashSet<>();
		for (char eachChar : Integer.toString(result).toCharArray()) {
			notDuplicatedSet.add(eachChar);
		}
		assertThat(notDuplicatedSet.size()).isEqualTo(3);
	}
}
