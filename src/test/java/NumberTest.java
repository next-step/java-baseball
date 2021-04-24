import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "123456"})
    @DisplayName("입력한 숫자의 개수가 3개가 아닌 경우 예외처리한다.")
    void validateInputNumberSize(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input))
        .withMessageContaining("입력한 숫자의 길이는 3자리이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "999"})
    @DisplayName("입력한 숫자가 서로 다른 임의의 수가 아닌 경우 예외처리한다.")
    void validateDuplicate(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input))
        .withMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }
}
