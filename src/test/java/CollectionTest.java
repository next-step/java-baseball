import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
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
	@DisplayName("Set Collection 학습 테스트 요구사항1 - Set의 크기를 확인")
	public void setSizeTest() {
		assertThat(numbers.size())
				.as("check number size : %s", numbers.size())
				.isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set Collection 학습 테스트 요구사항2 - Set의 contain을 이용 포함된 값 확인,"
			+ "ParameterizedTest 활용 중복코드 제거")
	public void setContainTest(int number) {
		assertThat(numbers.contains(number))
				.as("%s is not contain", number)
				.isTrue();
	}

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("Set Collection 학습 테스트 요구사항3 - Set의 contain을 이용 포함된 값 확인,"
			+ "CsvSource 활용 메소드 실행결과 true, false 를 반환하는 테스트")
	public void setContainFalseReturnTest(String number, String result) {
		assertThat(numbers.contains(Integer.parseInt(number)))
				.isEqualTo(Boolean.parseBoolean(result));
	}
}
