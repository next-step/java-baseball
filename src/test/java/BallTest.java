import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 1개 Ball 클래스 테스트")
class BallTest {

	@Test
	@DisplayName("ball과 strike를 변경하지 못하는 테스트")
	void changeScoreTest() {
		Ball ball = new Ball(0, 1);
		ball.ball();
		ball.strike();

		assertThat(ball.isStrike()).isFalse();
	}

	@Test
	@DisplayName("strike 테스트")
	void strikeScoreTest() {
		Ball ball1 = new Ball(0, 1);
		Ball ball2 = new Ball(0, 1);
		ball1.setScore(ball2);
		assertThat(ball1.isStrike()).isTrue();
	}

	@Test
	@DisplayName("ball 테스트")
	void ballScoreTest() {
		Ball ball1 = new Ball(0, 1);
		Ball ball2 = new Ball(1, 1);
		ball1.setScore(ball2);
		assertThat(ball1.isBall()).isTrue();
	}

}