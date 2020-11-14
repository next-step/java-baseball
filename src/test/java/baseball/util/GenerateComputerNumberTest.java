package baseball.util;

import static baseball.util.GenerateComputerNumber.*;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenerateComputerNumberTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new LinkedHashSet<>();
		numbers.add(6);
		numbers.add(6);
		numbers.add(5);
		numbers.add(9);
	}

	@Test
	void generateEachNumberTest() {
		assertThat(generateEachNumberBetweenMinAndMax(1, 2)).isGreaterThanOrEqualTo(1).isLessThan(2);
		assertThat(generateEachNumberBetweenMinAndMax(8, 10)).isGreaterThanOrEqualTo(8).isLessThan(10);
		assertThat(generateEachNumberBetweenMinAndMax(1, 10)).isGreaterThanOrEqualTo(1).isLessThan(10);
	}

	@Test
	void linkedHashSetTest() {
		assertThat(numbers).containsExactly(6, 5, 9);
	}

	@Test
	void generateComputerNumberTest() {
		assertThat(generateComputerNumber().size()).isEqualTo(3);
	}

}
