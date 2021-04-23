package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

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
}
