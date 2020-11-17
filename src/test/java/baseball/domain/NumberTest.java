package baseball.domain;

import baseball.exception.IncorrectNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("숫자 입력값 검증이 정상 작동하는 지 Exception과 메세지로 체크")
    @ParameterizedTest
    @CsvSource(value = {"112,중복", ",비었습니다", "1230,허용되지 않은 숫자"})
    void validateNumbersTest(String input, String expectedMsg) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IncorrectNumbersException.class)
                .hasMessageContaining(expectedMsg);
    }
}
