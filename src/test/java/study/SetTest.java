package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("Set size() 테스트")
	void setSizeTest() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest
	@DisplayName("Set contains() @ValueSource 테스트")
	@ValueSource(ints = { 1, 2, 3 })
	void setContainsValueSourceTest(int number) {
		assertThat(numbers.contains(number)).isEqualTo(true);
	}

	@ParameterizedTest
	@DisplayName("Set contains() @CsvSource 테스트")
	@CsvSource({ "1,true", "2,true", "3,true", "4,false", "5,false" })
	void setContainsCsvSourceTest(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}

}
