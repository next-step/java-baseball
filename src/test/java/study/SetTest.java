package study;

import static org.assertj.core.api.Assertions.*;

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
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
	void checkSetSize() {
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest(name = "@ParameterizedTest를 활용하여 Set의 contains로 1,2,3의 값을 확인")
	@ValueSource(ints = {1, 2, 3})
	void checkContainNumber(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest(name = "입력값에 따라 결과값이 다른경우에 대응")
	@CsvSource(value = {
		"1, true",
		"2, true",
		"3, true",
		"4, false",
		"5, false"
	})
	void csvSourceTest(int input, boolean isTrue) {
		assertThat(isTrue).isEqualTo(numbers.contains(input));
	}
}
