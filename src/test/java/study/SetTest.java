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
	public static final int EXPECTED_SET_NUMBERS_SIZE = 3;
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
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
	void equalsSetSizeTest() {
		assertThat(numbers.size()).isEqualTo(EXPECTED_SET_NUMBERS_SIZE);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains() 메소드, @ParameterizedTest, @ValueSource 를 활용해 중복없이 1,2,3 의 값이 존재하는지 테스트")
	void containsSetTest(int param) {
		assertThat(numbers.contains(param)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set의 contains() 메소드, @ParameterizedTest, @CsvSource 를 활용해 중복없이 1,2,3 의 값이 존재하는지 && 4,5 값이 존재 안하는지 테스트")
	void containsSetDynamicTest(int param, boolean isNotEmpty) {
		assertThat(numbers.contains(param)).isEqualTo(isNotEmpty);
	}

}
