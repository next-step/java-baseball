package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallNumberTest {

    @Test
    @DisplayName("정상 생성")
    void testBaseBallNumber() {
        int number = 5;
        assertThat(BaseBallNumber.of(number).getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("0으로 생성 시 예외")
    void testZeroNumberThrowException() {
        assertThatThrownBy(() -> BaseBallNumber.of(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
