package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("Ball 생성시 3개의 숫자를 갖는다")
    @Test
    void create() {
        List<BallNumber> ballNumber1 = Arrays.asList(new BallNumber(4), new BallNumber(5), new BallNumber(3));
        BallNumbers ballNumbers = new BallNumbers(ballNumber1);
        Ball ball = new Ball(ballNumbers);

        assertThat(ball.getBallList().size()).isEqualTo(3);
    }

}
