package edu.nextstep.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}