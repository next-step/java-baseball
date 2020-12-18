package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumberTest {
    @DisplayName("1~9 사이의 숫자로 BallNumber를 생성한다")
    @Test
    void create() {
        BallNumber ballNumber = new BallNumber(1);

        assertThat(ballNumber.getNumber()).isEqualTo(1);
    }

    @DisplayName("BallNumber 생성 시, 1~9 이외의 숫자일 경우 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"-1", "0", "10"})
    void validateNumber(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(input))
                .withMessage("1~9 사이의 숫자만 허용됩니다.");
    }
}