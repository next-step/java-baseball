package com.precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
	private final NumberGenerator numberGenerator = new NumberGenerator();

	@Test
	@DisplayName("3개의 수를 반환")
	public void testGenerate() {
		List<Integer> numbers = numberGenerator.generate();
		assertThat(numbers.size()).isEqualTo(3);

	}

	@Test
	@DisplayName("생성되는 숫자의 범위(1-9)확인")
	public void testGenerateNumber() {
		List<Integer> numbers = numberGenerator.generate();
		for (int number : numbers) {
			assertThat(number).isBetween(1, 9);
		}
	}

	@Test
	@DisplayName("중복되지 않는 숫자 반환")
	public void testUniqueNumber() {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 1; i < 9; i++) {
			numbers.add(i);
		}
		int number = numberGenerator.getUniqueNumber(numbers);
		assertThat(number).isEqualTo(9);
	}

}
