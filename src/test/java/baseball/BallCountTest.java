package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BallCountTest {

	@Test
	public void addStrike() {
		BallCount ballCount = new BallCount();
		ballCount.addStrike();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(1, 0));
		ballCount.addStrike();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(2, 0));
	}

	@Test
	public void addBall() {
		BallCount ballCount = new BallCount();
		ballCount.addBall();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(0, 1));
		ballCount.addBall();
		assertThat(ballCount).isEqualToComparingFieldByField(new BallCount(0, 2));
	}

	@Test
	public void isNoting() {
		assertThat(new BallCount().isNoting()).isEqualTo(true);
		assertThat(new BallCount(1, 0).isNoting()).isEqualTo(false);
	}

	@Test
	public void isEndGame() {
		assertThat(new BallCount(3, 0).isEndGame()).isEqualTo(true);
		assertThat(new BallCount(0, 3).isEndGame()).isEqualTo(false);
	}
}
