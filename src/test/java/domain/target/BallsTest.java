package domain.target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
	private Balls balls;

	@BeforeEach
	public void setUp() {
		balls = Balls.newBalls();
	}

	@Test
	@DisplayName("정답의 자릿수가 3자릿수 인지 테스트")
	public void ballsSize_ShouldBe_Three() {
		assertThat(balls.getBallList()).hasSize(3);
	}

	@RepeatedTest(10)
	@DisplayName("정답의 각 자릿수가 모두 다른 숫자인지 테스트")
	public void ballsElement_ShouldBe_Distinct() {
		//given
		List<Ball> ballList = balls.getBallList();
		Ball firstBall = ballList.get(0);

		//when, then
		assertThat(firstBall)
			.isNotEqualTo(ballList.get(1))
			.isNotEqualTo(ballList.get(2));
	}
}
