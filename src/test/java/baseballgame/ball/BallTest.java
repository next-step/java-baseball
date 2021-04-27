package baseballgame.ball;

import baseballgame.constant.BallCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("공의 범위에 맞는 1개를 생성한다.")
    void createBall_inRange_true(int number) {
        Ball ball = Ball.createBall(number);
        assertThat(ball.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {99999,8657,34124})
    @DisplayName("공의 범위에 맞지 않는 1개를 생성한다.")
    void createBall_outOfRange_fail(int number) {
        assertThatThrownBy(() -> {
            Ball ball = Ball.createBall(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자야구 규칙에 정해진 개수의 공만큼 랜덤 생성한다.")
    void createBalls_random_success(){
        BallsFactory ballsFactory = new RandomBallsFactory();
        LinkedHashSet<Ball> balls = ballsFactory.createBalls();
        assertThat(balls.size()).isEqualTo(BallCount.COUNT);
    }

    @Test
    @DisplayName("숫자야구 규칙에 정해진 개수의 공을 선택하여 생성한다.")
    void createBalls_select_success(){
        Integer[] numbers = {1,2,3};
        BallsFactory ballsFactory = new SelectBallsFactory(numbers);
        LinkedHashSet<Ball> balls = ballsFactory.createBalls();
        assertThat(balls.size()).isEqualTo(BallCount.COUNT);
    }

    @Test
    @DisplayName("숫자야구 규칙에 정해진 개수의 공을 중복되게 선택하여 생성한다.")
    void createBalls_selectDuplicate_fail(){
        Integer[] numbers = {1,2,2};
        BallsFactory ballsFactory = new SelectBallsFactory(numbers);
        assertThatThrownBy(() -> {
            LinkedHashSet<Ball> balls = ballsFactory.createBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}