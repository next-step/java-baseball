package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    @DisplayName("공은 생성이 불가능하며, static method로 객체를 전달해줄 수 있다.")
    public void 공은_생성이_불가능하며_static_method로_객체를_전달해줄_수_있다() {
        Ball ball = Ball.of(3);

        assertThat(ball.getNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("같은 번호의 공은 같은 공이다")
    public void 같은_번호의_공은_같은_공이다() {
        assertThat(Ball.of(3)).isEqualTo(Ball.of(3));
    }
}
