import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameResultTest {
	private GameResult gameResult;

	@BeforeEach
	void setUp() {
		gameResult = new GameResult();
	}

	@Test
	void setAndGetStrikeTest() {
		gameResult.setStrike(2);
		assertThat(gameResult.getStrike()).isEqualTo(2);
	}

	@Test
	void setAndGetBallTest() {
		gameResult.setBall(3);
		assertThat(gameResult.getBall()).isEqualTo(3);
	}

	@Test
	void isFourBallTest() {
		gameResult.setStrike(0);
		gameResult.setBall(0);
		boolean result = gameResult.isFourBall();
		assertThat(result).isEqualTo(true);

		gameResult.setStrike(1);
		gameResult.setBall(1);
		result = gameResult.isFourBall();
		assertThat(result).isEqualTo(false);
	}

	@Test
	void isStrikeOutTest() {
		gameResult.setStrike(3);
		boolean result = gameResult.isStrikeOut();
		assertThat(result).isEqualTo(true);

		gameResult.setStrike(1);
		result = gameResult.isStrikeOut();
		assertThat(result).isEqualTo(false);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:3개의 숫자를 모두 맞히셨습니다! 게임 종료"
		, "0:0:4볼"
		, "1:2:1 스트라이크 2볼"
		, "0:3:3볼"
	}, delimiter = ':')
	void printTest(Integer strike, Integer ball, String resultComment) {
		gameResult.setStrike(strike);
		gameResult.setBall(ball);
		assertThat(gameResult.print()).isEqualTo(resultComment);
	}
}
