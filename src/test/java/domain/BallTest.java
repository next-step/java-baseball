package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("볼 생성 시 정상 생성 확인한다.")
    public void test(int position) {
        for (int number = BallNumber.MIN_BALL_NUMBER; number < BallNumber.MAX_BALL_NUMBER; number++) {
            BallNumber ballNumber = BallNumber.valueOf(number);
            BallPosition ballPosition = BallPosition.valueOf(position);

            Ball ball = new Ball(ballNumber, ballPosition);

            assertThat(ball.number()).isEqualTo(number);
            assertThat(ball.position()).isEqualTo(position);
        }
    }
}
