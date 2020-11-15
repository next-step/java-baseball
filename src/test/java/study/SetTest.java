package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트")
	public void size() {
		int size = numbers.size();

		assertThat(size).isEqualTo(3);
	}

	@Test
	@DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습 테스트")
	public void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드 제거")
	public void parameterizedTest(int num) {
		assertThat(numbers.contains(num)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("1,2,3 값은 contains 메소드 실행결과 true, 4,5 값을 넣으면 false 가 반환되는 테스 ")
	public void parameterizedTestWithCsv(int num, boolean expected) {
		assertThat(numbers.contains(num)).isEqualTo(expected);
	}


}
