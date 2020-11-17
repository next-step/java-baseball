package org.dhlee.game.utils.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

	@Test
	@DisplayName("랜덤 숫자 테스트")
	public void generateTest() {
		Integer[] numbers;
		numbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int range = 3;
		List<Integer> generateValues = RandomNumbersGenerator.generate(numbers, 3);

		assertEquals(range, generateValues.size());
		assertFalse(generateValues.get(0).equals(generateValues.get(1)));
		assertFalse(generateValues.get(0).equals(generateValues.get(2)));
		assertFalse(generateValues.get(1).equals(generateValues.get(2)));
	}
}
