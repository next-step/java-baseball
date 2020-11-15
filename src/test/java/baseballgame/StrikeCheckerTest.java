package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeCheckerTest {
    StrikeChecker strikeChecker = new StrikeChecker();

    @Test
    @DisplayName("두 숫자의 자릿수가 모두 다를 경우 0스트라이크")
    void check_zero_strike() {
        RandomNumber testRandomNumber = new RandomNumber(1, 2, 3);
        InputNumber testInpunNumber = new InputNumber(9, 8, 7);

        Integer result = strikeChecker.check(testRandomNumber, testInpunNumber);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("두 숫자가 한자리 수만 같을 경우 1스트라이크")
    void check_one_strike() {
        RandomNumber testRandomNumber = new RandomNumber(1, 2, 3);
        InputNumber testInpunNumber = new InputNumber(9, 2, 8);

        Integer result = strikeChecker.check(testRandomNumber, testInpunNumber);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자가 자리 수만 같을 경우 2스트라이크")
    void check_two_strike() {
        RandomNumber testRandomNumber = new RandomNumber(1, 2, 3);
        InputNumber testInpunNumber = new InputNumber(1, 2, 8);

        Integer result = strikeChecker.check(testRandomNumber, testInpunNumber);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자가 세자리 모두 같을 경우 3스트라이크")
    void check_three_strike() {
        RandomNumber testRandomNumber = new RandomNumber(1, 2, 3);
        InputNumber testInpunNumber = new InputNumber(1, 2, 3);

        Integer result = strikeChecker.check(testRandomNumber, testInpunNumber);

        assertThat(result).isEqualTo(3);
    }
}