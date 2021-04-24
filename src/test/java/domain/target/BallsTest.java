package domain.target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {
	private Balls balls;

	@BeforeEach
	public void setUp() {
		balls = Balls.createNewTargetBalls();
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

	@Test
	@DisplayName("생성자에 입력한 ballList 의 길이가 BALL_COUNT 보다 클시 IllegalArgumentException 을 던지는지 테스트 ")
	public void inpuntBallsSize_OverThanBALL_COUNT_Throws_IllegalArgumentexception() {
		// given
		List<Ball> inputBalls = new ArrayList<>();
		inputBalls.add(new Ball(1));
		inputBalls.add(new Ball(2));
		inputBalls.add( new Ball(3));
		inputBalls.add( new Ball(4));

		//when, then
		assertThatThrownBy(() -> new Balls(inputBalls))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("Balls 의 크기는" + Balls.BALL_COUNT + "이어야 합니다.");
	}
}
