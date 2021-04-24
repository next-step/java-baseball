package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    @DisplayName("공들을 생성할 때 공을 여러개 받을 수 있다")
    public void 공들을_생성할_때_공을_여러개_받을_수_있다() {
        assertThatNoException().isThrownBy(() -> new Balls(Ball.of(1), Ball.of(2), Ball.of(3)));
    }

    @Test
    @DisplayName("공들안에는 같은 숫자가 존재해서는 안된다")
    public void 공들안에는_같은_숫자가_존재해서는_안된다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Balls(Ball.of(1), Ball.of(1)));
    }

    @Test
    @DisplayName("공들 안에 공의 위치를 알아 낼 수 있다.")
    public void 공들_안에_공의_위치를_알아_낼_수_있다() {
        Balls balls = new Balls(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(balls.findPositionByBall(Ball.of(1)))
                .isEqualTo(new Position(0));
        assertThat(balls.findPositionByBall(Ball.of(2)))
                .isEqualTo(new Position(1));
        assertThat(balls.findPositionByBall(Ball.of(3)))
                .isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("공들 안에 찾고자 하는 공이 없으면, NOT_FOUND을 반환한다")
    public void 공들_안에_찾고자_하는_공이_없으면_NOT_FOUND을_반환한다() {
        Balls balls = new Balls(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(balls.findPositionByBall(Ball.of(4)))
                .isEqualTo(Position.NOT_FOUND);
    }
}
