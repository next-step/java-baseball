package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

	private BaseballService baseballService;

	@BeforeEach
	void initBaseballService() {
		baseballService = new BaseballService();
	}

	@DisplayName("입력받은스코어사이즈체크")
	@Test
	void isValidInputScore() {
		String inputScore = "123";
		assertTrue(baseballService.isValidInputScore(inputScore));

		String invalidInputScore = "123456";
		assertFalse(baseballService.isValidInputScore(invalidInputScore));
	}

	@DisplayName("스코어전체랜덤숫자발급확인")
	@Test
	void generateGameMasterScoreTest() {
		baseballService.generateGameMasterScore();
		int[] masterScore = baseballService.getGameMasterScore();

		assertTrue(masterScore[0] >= BaseballService.SCORE_MIN_NUM && masterScore[0] <= BaseballService.SCORE_MAX_NUM);
		assertTrue(masterScore[1] >= BaseballService.SCORE_MIN_NUM && masterScore[1] <= BaseballService.SCORE_MAX_NUM);
		assertTrue(masterScore[2] >= BaseballService.SCORE_MIN_NUM && masterScore[2] <= BaseballService.SCORE_MAX_NUM);
	}

	@DisplayName("스코어결과확인")
	@Test
	void getScoreResultMessageTest() {
		Map<Enum, Integer> scoreMap = baseballService.getScoreMap();

		scoreMap.put(BaseballCount.STRIKE, 2);
		scoreMap.put(BaseballCount.BALL, 1);
		assertEquals("2스트라이크1볼", baseballService.getScoreResultMessage());

		scoreMap.put(BaseballCount.STRIKE, 3);
		scoreMap.put(BaseballCount.BALL, 0);
		assertEquals("3스트라이크", baseballService.getScoreResultMessage());

		scoreMap.put(BaseballCount.STRIKE, 0);
		scoreMap.put(BaseballCount.BALL, 3);
		assertEquals("3볼", baseballService.getScoreResultMessage());

		scoreMap.put(BaseballCount.STRIKE, 0);
		scoreMap.put(BaseballCount.BALL, 0);
		assertEquals("낫싱", baseballService.getScoreResultMessage());
	}
}
