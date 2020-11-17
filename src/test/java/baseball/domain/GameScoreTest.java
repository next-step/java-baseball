package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 점수 테스트")
public class GameScoreTest {

	private GameScore gameScore;
	private String[] randomNumbers;

	@BeforeEach
	public void setUp() {
		randomNumbers = new String[] {"3", "1", "4"};
		gameScore = new GameScore();
	}

	@DisplayName("게임 성적 계산 > 성공")
	@Test
	public void checkGameScoreSuccess() {

		gameScore.checkGameScore(randomNumbers, "314");
		assertEquals(3, gameScore.getStrike());
		assertEquals(0, gameScore.getBall());

		gameScore.checkGameScore(randomNumbers, "312");
		assertEquals(2, gameScore.getStrike());
		assertEquals(0, gameScore.getBall());

		gameScore.checkGameScore(randomNumbers, "124");
		assertEquals(1, gameScore.getStrike());
		assertEquals(1, gameScore.getBall());
	}

	@DisplayName("게임 클리어 여부 체크 > 성공")
	@Test
	public void isGameClearSuccess() {
		gameScore.checkGameScore(randomNumbers, "314");
		assertEquals(true, gameScore.isGameClear());
	}

	@DisplayName("게임 스트라이크 카운트 존재여부 체크 > 성공")
	@Test
	public void isExistStrikeCountSuccess() {
		gameScore.checkGameScore(randomNumbers, "314");
		assertEquals(true, gameScore.isExistStrikeCount());
	}

	@DisplayName("게임 볼 카운트 존재여부 체크 > 성공")
	@Test
	public void isExistBallCountSuccess() {
		gameScore.checkGameScore(randomNumbers, "134");
		assertEquals(true, gameScore.isExistBallCount());
	}
}

