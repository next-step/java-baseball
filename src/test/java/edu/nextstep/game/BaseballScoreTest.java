package edu.nextstep.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballScoreTest {

	@Test
	@DisplayName("addStrike : 기존 score에서 strike가 1 증가해야 함")
	void addStrike_ShouldIncreaseOneStrike() {
		// given
		int numberSize = 3;
		BaseballScore score = new BaseballScore(numberSize);
		int beforeStrike = score.getStrike();

		// when
		score.addStrike();
		int afterStrike = score.getStrike();

		// then
		assertEquals(afterStrike, beforeStrike + 1);
	}

	@Test
	@DisplayName("addBall : 기존 score에서 ball이 1 증가해야 함")
	void addBall_ShouldIncreaseOneBall() {
		// given
		int numberSize = 3;
		BaseballScore score = new BaseballScore(numberSize);
		int beforeBall = score.getBall();

		// when
		score.addBall();
		int afterBall = score.getBall();

		// then
		assertEquals(afterBall, beforeBall + 1);
	}

	@ParameterizedTest
	@DisplayName("toLocaleString : 정해진 형식의 메시지를 리턴해야 함")
	@CsvSource(value = {"2:0:2 스트라이크", "2:1:2 스트라이크 1볼", "0:2:2볼", "0:0:낫싱"}, delimiter = ':')
	void toLocaleString_ShouldReturnSpecifiedFormatMessage(int strike, int ball, String message) {
		// given
		int maxStrike = 3;
		BaseballScore score = new BaseballScore(maxStrike);

		// when
		for (int i = 0; i < strike; i++) {
			score.addStrike();
		}
		for (int i = 0; i < ball; i++) {
			score.addBall();
		}

		// then
		assertEquals(score.toLocaleString(), message);
	}
}