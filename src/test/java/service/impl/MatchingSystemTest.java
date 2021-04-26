package service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.BallCount;
import service.IMatchingSystem;

class MatchingSystemTest {

	final static int MAX_DIGIT_NUMBER = 3;
	private final IMatchingSystem matchingSystem = new MatchingSystem(MAX_DIGIT_NUMBER);

	@Test
	@DisplayName("게임 매칭 결과 테스트")
	void testMatch() {

		/// region given
		final Map<Integer, Integer> givenComputerNumber = new HashMap<>();
		givenComputerNumber.put(1, 0);
		givenComputerNumber.put(2, 1);
		givenComputerNumber.put(3, 2);
		final int[] givenPlayerNumber = {1, 3, 4};
		final BallCount expectedBallCount = new BallCount();
		expectedBallCount.addBall();
		expectedBallCount.addStrike();
		/// endregion

		/// region when
		final BallCount actualBallCount = matchingSystem.match(givenComputerNumber, givenPlayerNumber);
		/// endregion

		/// region then
		assertNotNull(actualBallCount);
		assertEquals(expectedBallCount, actualBallCount);
		/// endregion
	}
}