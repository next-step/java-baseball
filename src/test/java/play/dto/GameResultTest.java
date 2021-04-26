package play.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {


	@DisplayName("게임 결과에 strike, ball 둘 다 존재할 경우")
	@Test
	void getResultMessageTest(){
		// given
		GameResult gameResult = new GameResult();
		gameResult.strike(); // strike 한 번
		gameResult.ball();
		gameResult.ball(); // ball 두 번

		// when
		String resultMessage = gameResult.getResultMessage();

		// then
		assertThat(resultMessage)
			.isNotEmpty()
			.isEqualTo("1 스트라이크 2볼");
	}

	@DisplayName("게임 결과에 strike만 존재할 경우")
	@Test
	void getResultMessageStrikeTest(){
		// given
		GameResult gameResult = new GameResult();
		gameResult.strike();
		gameResult.strike();
		gameResult.strike(); // strike 세 번

		// when
		String resultMessage = gameResult.getResultMessage();

		// then
		assertThat(resultMessage)
			.isNotEmpty()
			.isEqualTo("3 스트라이크 ");
	}

	@DisplayName("게임 결과에 ball만 존재할 경우")
	@Test
	void getResultMessageBallTest(){
		// given
		GameResult gameResult = new GameResult();
		gameResult.ball();
		gameResult.ball();
		gameResult.ball(); // ball 세 번

		// when
		String resultMessage = gameResult.getResultMessage();

		// then
		assertThat(resultMessage)
			.isNotEmpty()
			.isEqualTo("3볼");
	}

	@DisplayName("게임 결과에 strike, ball 전부 존재하지 않을 경우, 낫싱")
	@Test
	void getResultMessageNothingTest(){
		// given
		GameResult gameResult = new GameResult();

		// when
		String resultMessage = gameResult.getResultMessage();

		// then
		assertThat(resultMessage)
			.isNotEmpty()
			.isEqualTo("낫싱");
	}

	@DisplayName("3 strike면 finish가 true가 되는지 테스트")
	@Test
	void isFinishTest(){
		// given
		GameResult gameResult = new GameResult();
		gameResult.strike();
		gameResult.strike();
		gameResult.strike(); // 3 strike

		// when

		// then
		assertThat(gameResult.isFinish()).isTrue();
	}

	@DisplayName("3 strike가 아니면 finish가 false가 되는지 테스트")
	@Test
	void isFinishFalseTest(){
		// given
		GameResult gameResult = new GameResult();
		gameResult.strike();
		gameResult.strike(); // 2 strike
		gameResult.ball(); // 1 ball

		// when

		// then
		assertThat(gameResult.isFinish()).isFalse();
	}
}
