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

@DisplayName("학습 테스트 - Set")
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

	@DisplayName("Set 사이즈 확인 테스트")
	@Test
	public void checkSizeTest() {
		assertThat(3).isEqualTo(numbers.size());
	}

	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@DisplayName("ParameterizedTest를 활용한 중복코드 제거 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void containsTest2(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("ParameterizedTest를 활용한 결과 예상 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void expectedTest(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
