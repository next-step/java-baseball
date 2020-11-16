package baseball.domain;

import baseball.exception.IncorrectNumbersException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {"112,중복", ",비었습니다", "1230,허용되지 않은 숫자"})
    void validateNumbersTest(String input, String expectedMsg) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IncorrectNumbersException.class)
                .hasMessageContaining(expectedMsg);
    }
}
