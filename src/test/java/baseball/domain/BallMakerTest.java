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

    @DisplayName("랜덤하게 생성되는지 확인한다.")
    @Test
    void generate_repeat() {
        //given
        BallMaker ballMaker = new RandomBallMaker();

        //when
        Balls first = ballMaker.generate();
        Balls second = ballMaker.generate();

        //then
        assertThat(first.equals(second)).isFalse();
    }
}
