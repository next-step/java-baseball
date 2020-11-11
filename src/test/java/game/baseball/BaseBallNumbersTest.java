package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallNumbersTest {

    @Test
    @DisplayName("직접 생성 시 0이 존재하면 예외 발생")
    void testHasZeroThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("109")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 같은 수가 존재하면 예외 발생")
    void testHasSameNumbersThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 3자리가 아닐 경우 예외 발생")
    void testOverLengthThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseBallNumbers("15")).isInstanceOf(IllegalArgumentException.class);
    }

}
