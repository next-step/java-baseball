package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.exception.NoAllowNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    void equals() {
        assertThat(Ball.of(1)).isEqualTo(Ball.of("1"));
    }

    @Test
    @DisplayName("숫자는 1~9 사이어야 한다")
    void validNumber() {
        assertThatThrownBy(() -> Ball.of(10))
            .hasMessageMatching("숫자는 1~9 사이어야 합니다.")
            .isInstanceOf(NoAllowNumberException.class);
    }

    @Test
    void createRandomBall() {
        assertThatCode(() -> Ball.of(new RandomNumber())).doesNotThrowAnyException();
    }
}
