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
}