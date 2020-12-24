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

    @Test
    @DisplayName("사용자가 입력한 재시작 숫자의 유효성 탐지")
    void testValidRestartInput() {
        Assertions.assertThat(baseballController.isValidRestartInput("1")).isTrue();
        Assertions.assertThat(baseballController.isValidRestartInput("2")).isTrue();

        Assertions.assertThat(baseballController.isValidRestartInput("")).isFalse();
        Assertions.assertThat(baseballController.isValidRestartInput("0")).isFalse();
        Assertions.assertThat(baseballController.isValidRestartInput("a")).isFalse();
        Assertions.assertThat(baseballController.isValidRestartInput("12")).isFalse();
    }

    @Test
    @DisplayName("스트라이크 개수를 올바르게 구하는지 확인")
    void getStrikeCount() {
        Assertions.assertThat(baseballController.getStrikeCount("123", "123")).isEqualTo(3);
        Assertions.assertThat(baseballController.getStrikeCount("123", "124")).isEqualTo(2);
        Assertions.assertThat(baseballController.getStrikeCount("123", "132")).isEqualTo(1);
        Assertions.assertThat(baseballController.getStrikeCount("123", "111")).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 개수를 올바르게 구하는지 확인")
    void getBallCount() {
        Assertions.assertThat(baseballController.getBallCount("123", "123")).isEqualTo(0);
        Assertions.assertThat(baseballController.getBallCount("123", "124")).isEqualTo(0);
        Assertions.assertThat(baseballController.getBallCount("123", "132")).isEqualTo(2);
        Assertions.assertThat(baseballController.getBallCount("111", "123")).isEqualTo(2);
    }

}