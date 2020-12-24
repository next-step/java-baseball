import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballControllerTest {

    private final static BaseballController baseballController = new BaseballController();

    @Test
    @DisplayName("사용자가 입력한 야구 숫자의 유효성 탐지")
    void testValidBallInput() {
        Assertions.assertThat(baseballController.isValidBallInput("123")).isTrue();
        Assertions.assertThat(baseballController.isValidBallInput("217")).isTrue();

        Assertions.assertThat(baseballController.isValidBallInput("12a")).isFalse();
        Assertions.assertThat(baseballController.isValidBallInput("1234")).isFalse();
        Assertions.assertThat(baseballController.isValidBallInput("12")).isFalse();
        Assertions.assertThat(baseballController.isValidBallInput("91(")).isFalse();
        Assertions.assertThat(baseballController.isValidBallInput("abc")).isFalse();
    }
}