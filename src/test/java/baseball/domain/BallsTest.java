package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class BallsTest {
    @Test
    @DisplayName("공들을 생성할 때 공을 여러개 받을 수 있다")
    public void 공들을_생성할_때_공을_여러개_받을_수_있다() {
        assertThatNoException().isThrownBy(() -> new Balls(Ball.of(1), Ball.of(2), Ball.of(3)));
    }
}
