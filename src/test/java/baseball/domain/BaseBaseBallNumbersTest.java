package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseBaseBallNumbersTest {
    @DisplayName("1~9 사이의 서로 다른 수로 이루어진 임의의 세자리 문자열로 BallNumbers를 생성한다")
    @Test
    void create() {
        assertThat(BaseBallNumbers.from("123").getNumbers())
                .extracting(BaseBallNumber::getNumber)
                .isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("문자열이 세자리 수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"32", "4253"})
    void validateSizeThree(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseBallNumbers.from(input))
                .withMessage("세자리 수여야 합니다.");
    }

    @DisplayName("문자열에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseBallNumbers.from("311"))
                .withMessage("중복된 숫자는 허용되지 않습니다.");
    }

    @DisplayName("두 BallNumbers가 주어지면, 같은 수가 같은 자리에 위치하는 갯수를 구한다")
    @ParameterizedTest
    @CsvSource({"321,123,1", "123,123,3", "123,143,2", "123,312,0"})
    void countSameNumberAndDigit(String first, String second, int expected) {
        int result = BaseBallNumbers.from(first).countSameNumberAndPlaceWith(BaseBallNumbers.from(second));
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 BallNumbers가 주어지면, 중복되는 숫자의 갯수를 구한다")
    @ParameterizedTest
    @CsvSource({"321,123,3", "123,123,3", "123,421,2", "123,456,0"})
    void countDuplicateNumber(String first, String second, int expected) {
        int result = BaseBallNumbers.from(first).countSameNumberWith(BaseBallNumbers.from(second));
        assertThat(result).isEqualTo(expected);
    }
}
