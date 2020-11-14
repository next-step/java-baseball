package baseball.view;

import static baseball.view.GameScoreMessageGenerator.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.game.GameScore;

class GameScoreMessageGeneratorTest {

	@DisplayName("게임 스코어 출력 메시지 생성 테스트")
	@ParameterizedTest
	@MethodSource("getResultMessage")
	void getResultMessage(int strike, int ball, String expected) {
		GameScore score = makeGameScore(strike, ball);

		assertThat(GameScoreMessageGenerator.getResultMessage(score)).isEqualTo(expected);
	}

	private GameScore makeGameScore(int strike, int ball) {
		GameScore score = new GameScore();
		for (int i = 0; i < strike; i++) {
			score.strike();
		}
		for (int i = 0; i < ball; i++) {
			score.ball();
		}
		return score;
	}

	private static Stream<Arguments> getResultMessage() {
		return Stream.of(
			Arguments.of(0, 0, NOTHING),
			Arguments.of(1, 0, "1 " + STRIKE),
			Arguments.of(3, 0, "3 " + STRIKE),
			Arguments.of(0, 2, "2 " + BALL),
			Arguments.of(1, 1, "1 " + STRIKE + " 1 " + BALL),
			Arguments.of(2, 1, "2 " + STRIKE + " 1 " + BALL)
		);
	}
}