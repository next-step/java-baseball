package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallCountTest {

	@DisplayName("스트라이크 일때 볼카운트 증가 확인")
	@Test
	public void addStrike() {
		BallCount ballCount = new BallCount();
		ballCount.addStrike();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(1, 0));
		ballCount.addStrike();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(2, 0));
	}

	@DisplayName("볼 일때 볼카운트 증가 확인")
	@Test
	public void addBall() {
		BallCount ballCount = new BallCount();
		ballCount.addBall();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(0, 1));
		ballCount.addBall();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(0, 2));
	}

	@DisplayName("낫싱 인지 확인 테스트")
	@Test
	public void isNoting() {
		assertThat(new BallCount().isNoting()).isEqualTo(true);
		assertThat(new BallCount(1, 0).isNoting()).isEqualTo(false);
	}

	@DisplayName("게임이 끝났는지 확인 테스트")
	@Test
	public void isEndGame() {
		assertThat(new BallCount(3, 0).isEndGame()).isEqualTo(true);
		assertThat(new BallCount(0, 3).isEndGame()).isEqualTo(false);
	}
}
