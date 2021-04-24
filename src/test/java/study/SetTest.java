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
	@DisplayName("Set 의 size 메서드를 활용하여, Set 의 크기를 구한다")
	void canGetSizeOfSetWithSizeMethod() {
		// given

		// when
		int result = numbers.size();

		// then
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("Contains 메서드를 활용하여, Set 에 어떤 원소가 있는지 확인한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkWhetherElementExistUsingContainsMethod(int input) {
		// given

		// when

		// then
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("Set 에 원소가 있는 경우에는 True 를, 아닌 경우에는 False 를 반환한다")
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(int input, boolean expected) {
		// given

		// when

		// then
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
