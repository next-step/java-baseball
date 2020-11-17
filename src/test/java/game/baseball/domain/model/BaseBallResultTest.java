package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallResultTest {

	@ParameterizedTest
	@CsvSource({"1,1", "1,0", "3,0", "0,2"})
	@DisplayName("상태값에 맞게 값이 변하는지 확인한다.")
	void update_OneStrikeOneBall(int strike, int ball) {
		BaseBallResult result = new BaseBallResult();

		for (int i = 0; i < strike; i++) {
			result.update(BaseBallStatus.STRIKE);
		}

		for (int i = 0; i < ball; i++) {
			result.update(BaseBallStatus.BALL);
		}

		assertThat(result.getStrike())
			.isEqualTo(strike);
		assertThat(result.getBall())
			.isEqualTo(ball);
	}
}
