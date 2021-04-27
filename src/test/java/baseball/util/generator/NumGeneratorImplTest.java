package baseball.util.generator;

// import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.BallNumber;

class NumGeneratorImplTest {

	@DisplayName("숫자의 갯수 확인")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void checkNumsSize(String input) {

		//given
		NumGenerator ballNumGenerator = new NumGeneratorImpl(input);

		//when
		Map<BallNumber, Integer> ballNumMap = ballNumGenerator.generate();

		//then
		Assertions.assertTrue(ballNumMap.size() == 3);
	}

	@DisplayName("생성한 숫자들의 인덱스 확인")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void checkNumsIndex(String input) {
		int[] indexArr = new int[] {0, 1, 2};
		//given
		NumGenerator ballNumGenerator = new NumGeneratorImpl(input);

		//when
		Map<BallNumber, Integer> ballNumMap = ballNumGenerator.generate();

		//then
		Assertions.assertArrayEquals(ballNumMap.values().stream().sorted().mapToInt(Integer::intValue).toArray(),
			indexArr);
	}
}