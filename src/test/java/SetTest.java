import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@DisplayName("Set의 사이즈를 체크. basic 3")
	void checkSizeFromNumbers() {
		assertEquals(numbers.size(), 3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	@DisplayName("ParameterizedTest를 통한 중복코드 제거")
	void containsFromNumbers_isTrue(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("CsvSource를 사용하여 true OR false를 체크")
	void containsFromNumbers_isBool(int number, boolean flag) {
		assertEquals(numbers.contains(number), flag);
	}
}
