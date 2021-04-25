package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1 - size test")
	void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
		assertTrue(numbers.size() == 3);
		assertEquals(numbers.size(), 3);
	}

	@Test
	@DisplayName("요구사항 2 - contains test")
	void containsTest() {
		assertThat(numbers).contains(3, 1, 2);
		assertThat(numbers).containsExactly(1, 2, 3);
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2 - parameterizedTest")
	void containsParameterizedTest(int input) {
		assertTrue(numbers.contains(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false", "6:false"}, delimiter = ':')
	void containsParameterizedTest(String input, String expected) {
		assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.parseBoolean(expected));
	}

}
