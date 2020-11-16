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
	@DisplayName("요구사항1: Set의 size 확인 테스트")
	void checkSetSizeTest() {

		// Set 타입은 요쇼의 중복을 허용하지 않기 때문에 사이즈가 3이다.
		assertThat(numbers.size()).isEqualTo(3);
	}

	// 하나의 테스트 메소드로 여러 개의 파라미터에 대해서 테스트할 수 있다.
	@ParameterizedTest
	// 단일 인수만 사용 가능
	// 사용 가능 타입: short, byte, int, long, float, double, char, boolean, java.lang.String, java.lang.Class
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항2: Set의 요소 확인 테스트")
	void checkSetContains(int number) {

		// 중복 코드
		// assertThat(numbers.contains(1)).isTrue();
		// assertThat(numbers.contains(2)).isTrue();
		// assertThat(numbers.contains(3)).isTrue();

		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	// 여러개의 다양한 파라메터를 정의하여 원하는 타입으로 넣을 수 있다.
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void checkCvsSourceTest(int setValue, boolean result) {

		assertThat(numbers.contains(setValue)).isEqualTo(result);
	}
}
