package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.shared.BaseBallStatus;

class BaseBallResultTest {

	@ParameterizedTest
	@CsvSource({"1,1", "1,0", "3,0", "0,2", "0,0"})
	@DisplayName("update()에 의해 상태값 맞게 값이 변하는지 확인한다")
	void updateTest(int strike, int ball) {
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

	@ParameterizedTest
	@CsvSource({"1,1", "1,0", "3,0", "0,2"})
	@DisplayName("toString()에 의해 스트라이크와 볼 일때 해당 문자열을 생성한다")
	void toString_StringAndBall(int strike, int ball) {
		BaseBallResult result = new BaseBallResult();

		for (int i = 0; i < strike; i++) {
			result.update(BaseBallStatus.STRIKE);
		}

		for (int i = 0; i < ball; i++) {
			result.update(BaseBallStatus.BALL);
		}

		if (strike > 0) {
			assertThat(result.toString())
				.startsWith(strike + " 스트라이크");
		}
		if (ball > 0) {
			assertThat(result.toString())
				.endsWith(ball + " 볼");
		}
	}

	@Test
	@DisplayName("toString()에 의해 스트라이크와 볼이 아닐때 해당 문자열을 생성한다")
	void toString_Notting() {
		BaseBallResult result = BaseBallResult.generateNotting();
		assertThat(result.toString())
			.isEqualTo("낫싱");
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("3 스트라이크가 아니면 isWin()은 false를 반환한다")
	void isWin_ReturnFalseWhenNotThreeStrike(int strike) {
		BaseBallResult result = BaseBallResult.generateNotting();

		for (int i = 0; i < strike; i++) {
			result.update(BaseBallStatus.STRIKE);
		}

		assertThat(result.isContinue())
			.isTrue();
		assertThat(result.isWin())
			.isFalse();
	}

	@Test
	@DisplayName("3 스트라이크면 isWin()은 true를 반환한")
	void isWin_ReturnTrueWhenThreeStrike() {
		BaseBallResult result = BaseBallResult.generateNotting();
		result.update(BaseBallStatus.STRIKE);
		result.update(BaseBallStatus.STRIKE);
		result.update(BaseBallStatus.STRIKE);

		assertThat(result.isContinue())
			.isFalse();
		assertThat(result.isWin())
			.isTrue();
	}
}
