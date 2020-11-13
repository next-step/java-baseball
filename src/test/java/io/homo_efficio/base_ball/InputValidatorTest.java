package io.homo_efficio.base_ball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @RepeatedTest(1000)
    void check3Digits() {
        InputValidator.check3Digits(NumberGenerator.generate());
    }

    @Test
    void throw_IllegalArgumentException_when_not_digit() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.check3Digits("a12"))
                .withMessage("입력된 값은 숫자여야 합니다.");
    }

    @Test
    void throw_IllegalArgumentException_when_length_not_3() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.check3Digits("12"))
                .withMessage("숫자는 세 자리여야 합니다.");
    }
}
