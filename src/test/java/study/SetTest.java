package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

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
	void test_요구사항_1() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void test_요구사항_2(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true"}, delimiter = ':')
	void test_요구사항_3(int n, boolean bool) {
		assertThat(numbers.contains((n)))
			.isEqualTo((bool));
	}
}
