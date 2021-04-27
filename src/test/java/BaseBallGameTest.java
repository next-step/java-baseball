import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {
	@Test
	@DisplayName("1 ~ 9 까지 랜덤 수 생성 테스트 1")
	void generateRandomNumber1() {
		int number = BaseBallGame.getRandomNumber();
		assertThat(number)
			.as("랜덤 숫자는 %d", number)
			.isBetween(1, 9);
	}

	@Test
	@DisplayName("1 ~ 9 까지 랜덤 수 생성 테스트 2")
	void generateRandomNumber2() {
		int number = BaseBallGame.getRandomNumber();

		// 주어진 랜덤 숫자는 양수이고, 0보다 크며, 10보다 작습니다.
		assertThat(number)
			.as("랜덤 숫자는 %d", number)
			.isPositive()
			.isGreaterThan(0)
			.isLessThan(10);
	}

	@Test
	@DisplayName("세자리 랜덤 수 생성 테스트")
	void generateRandomNumber3Length() {
		int[] target = BaseBallGame.getRandomNumber3Length();

		assertThat(target)
			.as("getRandomNumber3Length 배열 길이 %d", target.length)
			.hasSize(3);
		assertThat(target[0])
			.as("0번째 자리 숫자 %d", target[0])
			.isNotEqualTo(target[1])
			.isNotEqualTo(target[2]);
		assertThat(target[1])
			.as("1번째 자리 숫자 %d", target[1])
			.isNotEqualTo(target[0])
			.isNotEqualTo(target[2]);
		assertThat(target[2])
			.as("2번째 자리 숫자 %d", target[2])
			.isNotEqualTo(target[0])
			.isNotEqualTo(target[1]);
	}

	@Test
	@DisplayName("스트라이크 확인")
	void checkStrike() {
		int[] target = {1, 2, 3};
		int[] userInputs = {1, 2, 3};

		int strike = BaseBallGame.getStrikeCount(target, userInputs);

		assertThat(strike)
			.as("Strike: %d", strike)
			.isEqualTo(3);
	}

	@Test
	@DisplayName("볼 확인")
	void checkBall() {
		int[] target = {1, 2, 3};
		int[] userInputs = {3, 2, 1};

		int ball = BaseBallGame.getBallCount(target, userInputs);

		assertThat(ball)
			.as("Ball: %d", ball)
			.isEqualTo(2);
	}
}