package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreTest {
	@Test
	void getScoreMessage() {
		Score score0 = new Score(0, 0);
		assertThat(score0.getScoreMessage()).isEqualTo("포볼");

		Score score1 = new Score(1, 0);
		assertThat(score1.getScoreMessage()).isEqualTo("1 스트라이크");

		Score score2 = new Score(0, 1);
		assertThat(score2.getScoreMessage()).isEqualTo("1볼");

		Score score3 = new Score(1, 1);
		assertThat(score3.getScoreMessage()).isEqualTo("1 스트라이크 1볼");
	}
}
