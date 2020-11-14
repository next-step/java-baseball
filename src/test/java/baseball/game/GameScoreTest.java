package baseball.game;

import static baseball.game.Game.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameScoreTest {

	@DisplayName("게임 스코어 생성 테스트")
	@Test
	void construct() {
		GameScore score = new GameScore();

		isInitialized(score);
	}

	private void isInitialized(GameScore score) {
		assertThat(score).isNotNull();
		assertThat(score.hasStrike()).isFalse();
		assertThat(score.getStrike()).isEqualTo(0);
		assertThat(score.hasBall()).isFalse();
		assertThat(score.getBall()).isEqualTo(0);
		assertThat(score.isCleared()).isFalse();
	}

	@DisplayName("스트라이크 테스트")
	@Test
	void strike() {
		GameScore score = new GameScore();

		isInitialized(score);
		for (int i = 0; i < BALL_COUNT; i++) {
			score.strike();
			assertThat(score.hasStrike()).isTrue();
			assertThat(score.getStrike()).isEqualTo(i + 1);
		}
		assertThatThrownBy(() -> score.strike()).isInstanceOf(RuntimeException.class);
	}

	@DisplayName("볼 테스트")
	@Test
	void ball() {
		GameScore score = new GameScore();

		isInitialized(score);
		for (int i = 0; i < BALL_COUNT; i++) {
			score.ball();
			assertThat(score.hasBall()).isTrue();
			assertThat(score.getBall()).isEqualTo(i + 1);
		}
		assertThatThrownBy(() -> score.ball()).isInstanceOf(RuntimeException.class);
	}

	@DisplayName("성공 여부 테스트")
	@Test
	void isCleared() {
		for (int i = 0; i <= BALL_COUNT; i++) {
			boolean expected = false;
			if (i == BALL_COUNT) {
				expected = true;
			}
			testIsCleared(new GameScore(), i, BALL_COUNT - i, expected);
		}
	}

	private void testIsCleared(GameScore score, int strike, int ball, boolean expected) {
		isInitialized(score);
		for (int i = 0; i < strike; i++) {
			score.strike();
		}
		for (int i = 0; i < ball; i++) {
			score.ball();
		}

		assertThat(score.isCleared()).isEqualTo(expected);
	}
}
