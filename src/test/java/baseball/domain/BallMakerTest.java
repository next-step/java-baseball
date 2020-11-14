package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallMakerTest {
    @DisplayName("1-9 사이 숫자 3개를 생성한다.")
    @Test
    void getThreeNumbers() {
        //given
        BallMaker ballMaker = new RandomBallMaker();

        //when
        Balls balls = ballMaker.generate();

        //then
        assertThat(balls).isNotNull();
    }
}
