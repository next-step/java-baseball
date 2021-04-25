package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumbersTest {

    @DisplayName("결과값은 3자리 숫자인지 테스트 - 볼 각각의 값 합쳐서 3자리")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "956", "136"})
    void createNumbers(String input) {
        BallNumbers ballNumbers = new BallNumbers(input);

        assertThat(ballNumbers).isEqualTo(new BallNumbers(input));
    }

    @DisplayName("결과값은 [중복되지 않은] 3자리 숫자가 아닐 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "13", "3", "133", "911", "222"})
    void validateNumbers(String input) {
        assertThatThrownBy(() -> {
            new BallNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복되지 않은 3자리 숫자여야 합니다.");
    }
}
