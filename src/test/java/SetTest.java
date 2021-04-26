import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

	/*
	 * Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다
	 */
	@DisplayName("Set 사이즈 테스트")
	@Test
	public void setSizeTest() {
		assertThat(numbers).hasSize(3);
	}

	/*
	 * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다
	 * @param input
	 */
	@DisplayName("Set Contains Test 및 @ParameterizedTest를 활용한 중복 제거 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void setContainsTest(int input) {
		// assertThat(numbers.contains(1)).isTrue();
		// assertThat(numbers.contains(2)).isTrue();
		// assertThat(numbers.contains(3)).isTrue();
		
		assertTrue(numbers.contains(input));
	}

	/*
	 *  입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현한다
	 */
	@DisplayName("Set Contains Test 및 @CsvSource를 활용한 리턴 값 반환 테스트")
	@ParameterizedTest
	@CsvSource({"4,false", "5,false"})
	public void setContainsTestFalse(int input, boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}

}
