package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionTest {
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
	@DisplayName("Set 사이즈")
	void testSize() throws Exception {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("Set conatins")
	void testContains() throws Exception {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("CsvSource")
	void testCsvSource(String input, String expected) throws Exception {
		int parseNumber = Integer.parseInt(input);
		boolean parseBoolean = Boolean.parseBoolean(expected);

		assertEquals(numbers.contains(parseNumber), parseBoolean);
	}
}
