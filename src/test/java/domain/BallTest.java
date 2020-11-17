package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("BALL 없는 경우 테스트")
    @Test
    void ball_no_matching_test() {

        // given
        int matchingCount = 0;
        Ball ball = new Ball(matchingCount);

        // when & then
        assertThat(ball.isNoMatching()).isTrue();

    }

    @DisplayName("BALL 존재 여부 테스트")
    @Test
    void ball_exist_test() {

        // given
        int matchingCount = 2;
        Ball ball = new Ball(matchingCount);

        // when & then
        assertThat(ball.isExistMatching()).isTrue();
    }

}

