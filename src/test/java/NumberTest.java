import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "123456"})
    @DisplayName("입력한 숫자의 개수가 3개가 아닌 경우 예외처리한다.")
    void validateInputNumberSize(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }
}
