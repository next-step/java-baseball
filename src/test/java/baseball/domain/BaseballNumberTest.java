package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumberTest {

	@Test
	@DisplayName("서로다른 3자리숫자 생성 테스트")
	public void randomNumberGenerate() {
		int ballCount = 3;
		BaseballNumber numbers = new BaseballNumber(ballCount);
		Set<Integer> ballNumberSet = new HashSet<>(numbers.getNumbers());

		// 1-9 서로다른 3자리 숫자
		assertThat(ballNumberSet)
			.hasSize(ballCount)
			.allMatch(ballNumber -> ballNumber <= BaseballNumber.BALL_MAX_VALUE
				&& ballNumber >= BaseballNumber.BALL_MIN_VALUE);

	}

	@Test
	@DisplayName("9자리 서로다른 3자리숫자 생성 테스트")
	public void randomNumberGenerateLongerThree() {
		int ballCount = 9;
		BaseballNumber numbers = new BaseballNumber(ballCount);
		Set<Integer> ballNumberSet = new HashSet<>(numbers.getNumbers());

		// 9자리 1-9다른 숫자이므로 1-9모두 포함
		assertThat(ballNumberSet)
			.hasSize(ballCount)
			.allMatch(ballNumber -> ballNumber <= BaseballNumber.BALL_MAX_VALUE
				&& ballNumber >= BaseballNumber.BALL_MIN_VALUE);
	}
}
