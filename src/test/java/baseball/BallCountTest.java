package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallCountTest {

	@Test
	@DisplayName("BallCount 클래스 생성자")
	void ballCount() {
		assertThat(new BallCount()).extracting("strike", "ball").containsExactly(0, 0);
		assertThat(new BallCount(1, 2)).extracting("strike", "ball").containsExactly(1, 2);
	}

	@Test
	@DisplayName("BallCount 클래스 strike 멤버변수 setter")
	void setStrike() {
		BallCount ballCount = new BallCount();
		ballCount.setStrike(1);
		assertThat(ballCount).extracting("strike", "ball").containsExactly(1, 0);
		ballCount.setStrike(2);
		assertThat(ballCount).extracting("strike", "ball").containsExactly(2, 0);
	}

	@Test
	@DisplayName("BallCount 클래스 strike 멤버변수 getter")
	void getStrike() {
		BallCount ballCount = new BallCount(1, 2);
		assertThat(ballCount.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("BallCount 클래스 ball 멤버변수 setter")
	void setBall() {
		BallCount ballCount = new BallCount();
		ballCount.setBall(1);
		assertThat(ballCount).extracting("strike", "ball").containsExactly(0, 1);
		ballCount.setBall(2);
		assertThat(ballCount).extracting("strike", "ball").containsExactly(0, 2);
	}

	@Test
	@DisplayName("BallCount 클래스 ball 멤버변수 getter")
	void getBall() {
		BallCount ballCount = new BallCount(1, 2);
		assertThat(ballCount.getBall()).isEqualTo(2);
	}

	@Test
	@DisplayName("BallCount 인스턴스 간의 더하기 연산")
	void add() {
		BallCount ballCount = new BallCount();
		assertThat(ballCount).extracting("strike", "ball").containsExactly(0, 0);
		ballCount.add(new BallCount(1, 0));
		assertThat(ballCount).extracting("strike", "ball").containsExactly(1, 0);
		ballCount.add(new BallCount(1, 0));
		assertThat(ballCount).extracting("strike", "ball").containsExactly(2, 0);
		ballCount.add(new BallCount(0, 1));
		assertThat(ballCount).extracting("strike", "ball").containsExactly(2, 1);
	}
}
