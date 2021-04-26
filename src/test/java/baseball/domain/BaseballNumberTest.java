package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("객체 동등성 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void equals(int number) {
        // given
        BaseballNumber baseballNumber = BaseballNumber.from(number);

        // when
        BaseballNumber expectedBaseballNumber = BaseballNumber.from(number);

        // then
        assertThat(baseballNumber).isEqualTo(expectedBaseballNumber);
    }

    @DisplayName("유효 범위를 초과하는 숫자를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void invalid_number_exception(int number) {
        assertThatThrownBy(() -> BaseballNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능합니다.");
    }
}
