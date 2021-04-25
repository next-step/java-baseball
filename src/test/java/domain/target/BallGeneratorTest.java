package domain.target;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BallGeneratorTest {

	@RepeatedTest(value = 10)
	@DisplayName("BallGenerator 가 MIN ~ MAX 사이 수만 반환하는지 테스트")
	public void ballGenerator_ShouldReturn_GreaterThanBallMin_LessThanBallMax() {
		//given, when
		int number = BallGenerator.generateRandomBall().getNumber();

		//then
		assertThat(number)
			.isGreaterThanOrEqualTo(Ball.MIN_NUMBER_OF_BALL)
			.isLessThanOrEqualTo(Ball.MAX_NUMBER_OF_BALL);
	}

	@Test
	@DisplayName("BallGenerator 가 입력받은 숫자대로 Ball을 제대로 생성하는지 테스트")
	public void ballGenerator_ShouldReturn_InputNumberOfBalls_PreferOrder() {
		Balls balls = BallGenerator.generateBallsByNumber(123);
		List<Ball> ballList = balls.getBallList();
		assertAll(
			() -> assertThat(ballList.get(0).getNumber()).isEqualTo(1),
			() -> assertThat(ballList.get(1).getNumber()).isEqualTo(2),
			() -> assertThat(ballList.get(2).getNumber()).isEqualTo(3)
		);
	}
}
