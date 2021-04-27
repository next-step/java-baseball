package baseball.util.generator;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.BallNumber;

class RandomNumGeneratorImplTest {

	@DisplayName("랜덤으로 생성한 숫자의 갯수 확인")
	@Test
	void checkRandomNumsSize() {

		//given
		NumGenerator randomNumGenerator = new RandomNumGeneratorImpl();

		//when
		Map<BallNumber, Integer> randomNums = randomNumGenerator.generate();

		//then
		Assertions.assertTrue(randomNums.size() == 3);
	}

	@DisplayName("랜덤으로 생성한 숫자들의 인덱스 확인")
	@Test
	void checkRandomNumsIndex() {
		int[] indexArr = new int[] {0, 1, 2};
		//given
		NumGenerator randomNumGenerator = new RandomNumGeneratorImpl();

		//when
		Map<BallNumber, Integer> randomNums = randomNumGenerator.generate();

		//then
		Assertions.assertArrayEquals(randomNums.values().stream().sorted().mapToInt(Integer::intValue).toArray(),
			indexArr);
	}
}