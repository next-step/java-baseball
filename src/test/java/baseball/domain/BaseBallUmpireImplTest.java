package baseball.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.internal.BaseballUmpireImpl;

class BaseBallUmpireImplTest {

	@DisplayName("스트라이크 3개 검사")
	@Test
	void checkStrike() {
		Umpire umpire = new BaseballUmpireImpl();
		Map<BallNumber, Integer> mockDataMap = new HashMap<>();
		mockDataMap.put(new BallNumber(1), 0);
		mockDataMap.put(new BallNumber(2), 1);
		mockDataMap.put(new BallNumber(3), 2);

		Player p1 = new mockPlayer(mockDataMap);
		Player p2 = new mockPlayer(mockDataMap);

		Map<BallKind, Integer> expectedResultMap = new HashMap<>();
		expectedResultMap.put(BallKind.STRIKE, 3);
		expectedResultMap.put(BallKind.BALL, 0);
		expectedResultMap.put(BallKind.NOTHING, 0);

		GameResult expectedResult = new MockGameResult(expectedResultMap);

		GameResult result = umpire.judge(p1, p2);

		Assertions.assertEquals(result, expectedResult);

	}

	@DisplayName("ball 3개 검사")
	@Test
	void checkBall() {
		Umpire umpire = new BaseballUmpireImpl();

		Map<BallNumber, Integer> mockDataMapForP1 = new HashMap<>();
		mockDataMapForP1.put(new BallNumber(1), 0);
		mockDataMapForP1.put(new BallNumber(2), 1);
		mockDataMapForP1.put(new BallNumber(3), 2);

		Map<BallNumber, Integer> mockDataMapForP2 = new HashMap<>();
		mockDataMapForP2.put(new BallNumber(3), 0);
		mockDataMapForP2.put(new BallNumber(1), 1);
		mockDataMapForP2.put(new BallNumber(2), 2);

		Player p1 = new mockPlayer(mockDataMapForP1);
		Player p2 = new mockPlayer(mockDataMapForP2);

		Map<BallKind, Integer> expectedResultMap = new HashMap<>();
		expectedResultMap.put(BallKind.STRIKE, 0);
		expectedResultMap.put(BallKind.BALL, 3);
		expectedResultMap.put(BallKind.NOTHING, 0);

		GameResult expectedResult = new MockGameResult(expectedResultMap);

		GameResult result = umpire.judge(p1, p2);

		Assertions.assertEquals(result, expectedResult);

	}

	@DisplayName("낫싱 3개 검사")
	@Test
	void checkNothing() {
		Umpire umpire = new BaseballUmpireImpl();

		Map<BallNumber, Integer> mockDataMapForP1 = new HashMap<>();
		mockDataMapForP1.put(new BallNumber(4), 0);
		mockDataMapForP1.put(new BallNumber(5), 1);
		mockDataMapForP1.put(new BallNumber(6), 2);

		Map<BallNumber, Integer> mockDataMapForP2 = new HashMap<>();
		mockDataMapForP2.put(new BallNumber(3), 0);
		mockDataMapForP2.put(new BallNumber(1), 1);
		mockDataMapForP2.put(new BallNumber(2), 2);

		Player p1 = new mockPlayer(mockDataMapForP1);
		Player p2 = new mockPlayer(mockDataMapForP2);

		Map<BallKind, Integer> expectedResultMap = new HashMap<>();
		expectedResultMap.put(BallKind.STRIKE, 0);
		expectedResultMap.put(BallKind.BALL, 0);
		expectedResultMap.put(BallKind.NOTHING, 3);

		GameResult expectedResult = new MockGameResult(expectedResultMap);

		GameResult result = umpire.judge(p1, p2);

		Assertions.assertEquals(result, expectedResult);

	}

}