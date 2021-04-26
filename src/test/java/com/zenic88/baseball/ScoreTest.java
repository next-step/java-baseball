package com.zenic88.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	@DisplayName("스트라이크 +1 테스트")
	public void addStrikeTest() {
		Score score = new Score();
		score.addStrike();

		assertEquals(1, score.getStrike());
	}

	@Test
	@DisplayName("볼 +1 테스트")
	public void addBallTest() {
		Score score = new Score();
		score.addBall();

		assertEquals(1, score.getBall());
	}
}
