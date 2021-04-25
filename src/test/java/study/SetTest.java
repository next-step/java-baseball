package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
	@DisplayName("Set의 size()를 통해 크기를 확인")
	public void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	@DisplayName("Set의 contains()를 통해 1,2,3 값의 존재를 확인")
	public void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
	@DisplayName("입력값에 따라 결과 값이 다른 경우 테스트")
	public void containsAll(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
