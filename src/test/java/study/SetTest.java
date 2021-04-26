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

	@DisplayName("1. numbers의 크기가 1이상인지 확인 하는 성공 테스트")
	@Test
	void check_size_of_set() {
		assertThat(numbers.size()).isNotZero();
	}

	@DisplayName("2. numbers에 1, 2, 3이 포함되어 있는지 확인하는 성공 테스트")
	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@DisplayName("3. Junit Parameterized를 활용해 2번 테스트의 중복코드를 제거하는 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains_with_junit_parameterized(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("4. CsvSource를 활용한 입력값에 따라 다른 결과값을 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains_with_csv_source(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
