package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    void create() {
        assertThatCode(() -> Ball.of(0)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("숫자는 0~9 사이어야 한다")
    void validNumber() {
        assertThatThrownBy(() -> Ball.of(10))
            .hasMessageMatching("숫자는 0~9 사이어야 합니다.")
            .isInstanceOf(NoAllowNumber.class);
    }
}
