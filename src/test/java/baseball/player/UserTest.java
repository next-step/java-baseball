package baseball.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 1:19 AM
 */

class UserTest {
	@DisplayName("유저의 선택된 볼이 잘 출력되는지 확인")
	@ParameterizedTest()
	@ValueSource(strings = {"123", "456", "789", "139", "942"})
	void validUserBalls(String number) {
		User user = new User();
		int[] userBalls = user.selectUserBalls(3, number);
		Assertions.assertThat(userBalls).hasSize(3);
	}

	@DisplayName("선택한볼이 3자리미만 혹은 4자리이상이어도 3자리로 나오는지 확인")
	@ParameterizedTest()
	@ValueSource(strings = {"12", "5", "20304", "35555"})
	void validUserBallsAbnormal(String number) {
		User user = new User();
		int[] userBalls = user.selectUserBalls(3, number);
		Assertions.assertThat(userBalls).hasSize(3);
	}
}
