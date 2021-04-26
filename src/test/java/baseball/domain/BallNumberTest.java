package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class BallNumberTest {

    @DisplayName("볼 숫자는 1~9 사이에 있어야한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void testBallValidate(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BallNumber(number));
    }
}
