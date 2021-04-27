package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다")
	void setSizeTest() {
		// given, when
		int size = numbers.size();

		// then
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다")
	void setContainsTest(int inputNumber) {
		assertThat(numbers.contains(inputNumber)).isTrue();
	}
}
