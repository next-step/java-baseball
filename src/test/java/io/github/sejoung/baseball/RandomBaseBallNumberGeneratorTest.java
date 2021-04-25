package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBaseBallNumberGeneratorTest {

	@DisplayName("중복된 숫자 확인")
	@Test
	void duplicateNumberTest() {
		RandomBaseBallNumberGenerator generator = new RandomBaseBallNumberGenerator();
		List<Integer> numbers = generator.generateBaseBallNumbers();
		assertThat(Collections.frequency(numbers, numbers.get(0))).isOne();
		assertThat(Collections.frequency(numbers, numbers.get(1))).isOne();
		assertThat(Collections.frequency(numbers, numbers.get(2))).isOne();
	}

	@DisplayName("3자리의 수 확인")
	@Test
	void sizeTest() {
		RandomBaseBallNumberGenerator generator = new RandomBaseBallNumberGenerator();
		List<Integer> numbers = generator.generateBaseBallNumbers();
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("1부터 9까지 숫자 확인")
	@Test
	void minMaxNumberTest() {
		RandomBaseBallNumberGenerator generator = new RandomBaseBallNumberGenerator();
		List<Integer> numbers = generator.generateBaseBallNumbers();
		assertThat(Collections.frequency(numbers, 0)).isZero();
	}
}
