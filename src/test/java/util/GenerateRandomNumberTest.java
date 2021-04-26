package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GenerateRandomNumberTest {

	private final int range = 10;

	@DisplayName("난수 생성 배열 검사, 정상 테스트")
	@ParameterizedTest
	@ValueSource(ints = {
		1, 2, 3, 4, 5, 6, 7, 8, 9
	})
	void generateTest(int pickSize){
		// given

		// when
		List<Integer> resultArray = GenerateRandomNumber.generate(this.range, pickSize);

		// then
		assertThat(resultArray).isNotEmpty() // 빈 결과값이면 안되고
							   .hasSize(pickSize) // 사이즈는 parameter와 같아야하고
							   .doesNotHaveDuplicates(); // 중복되면 안된다.
	}

	@DisplayName("랜덤 숫자 범위보다 뽑으려는 숫자가 큰 경우, 빈 결과값 리턴")
	@ParameterizedTest
	@ValueSource(ints = {
		11, 12, 300
	})
	void generateOverSizeFailedTest(int pickSize){
		// given

		// when
		List<Integer> resultArray = GenerateRandomNumber.generate(this.range, pickSize);

		// then
		assertThat(resultArray).isEmpty();
	}

	@DisplayName("뽑으려는 숫자가 1보다 작을 경우, 빈 결과값 리턴")
	@ParameterizedTest
	@ValueSource(ints = {
		-1, 0, -100
	})
	void generateLeastSizeFailedTest(int pickSize){
		// given

		// when
		List<Integer> resultArray = GenerateRandomNumber.generate(this.range, pickSize);

		// then
		assertThat(resultArray).isEmpty();
	}

}
