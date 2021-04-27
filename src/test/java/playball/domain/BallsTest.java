package playball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class BallsTest {

    @DisplayName("랜덤한 3자리 PlayBall 생성하는 테스트")
    @Test
    public void createRandomBallTest() {
        Balls results = Balls.createRandomBalls();
        Assertions.assertThat(results.getBalls().size()).isEqualTo(3);
    }

    @DisplayName("랜덤한 3자리 PlayBall 중복이 안되는지 확인하는 테스트")
    @Test
    public void createRandomBallDuplicateTest() {
        Balls results = Balls.createRandomBalls();

        Set<Ball> balls = new HashSet<>(results.getBalls());
        Assertions.assertThat(balls.size()).isEqualTo(3);
    }
}
