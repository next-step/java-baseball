package camp.nextstep.edu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("랜덤 숫자 생성 - 성공 테스트")
    void generateNumber_successTest(int bound) {
        // given & when
        int number = NumberUtil.generateNumber(bound);

        // then
        assertThat(number)
                .isNotNegative()
                .isLessThan(bound);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2", "-3", "-4", "-5"})
    @DisplayName("랜덤 숫자 생성 - 실패 테스트")
    void generateNumber_failureTest(int bound) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberUtil.generateNumber(bound))
                .withMessageContaining("bound must be positive");
    }
}
