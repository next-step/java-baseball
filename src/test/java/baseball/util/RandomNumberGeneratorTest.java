package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	@DisplayName("중복되지 않은 세개의 숫자를 생성한다.")
	void generate() {
		final int NUMBER_SIZE = 3;
		final NumberGenerator generator = new RandomNumberGenerator();
		final List<Integer> generateNumbers = generator.generate(NUMBER_SIZE);

		final int generateSize = generateNumbers.size();
		final int convertSetSize = new HashSet<>(generateNumbers).size();
		assertThat(generateSize).isEqualTo(NUMBER_SIZE);
		assertThat(convertSetSize).isEqualTo(generateSize);
	}

}