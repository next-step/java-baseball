package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    private BaseballNumber baseballNumber;

    @BeforeEach
    void setUP() {
        baseballNumber = new BaseballNumber(new Order(0), 3);
    }

    @DisplayName("숫자가 1~9가 아닐 경우, Exception 발생")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void validateRangeNumber(Order order, int baseballNumber) {
        assertThatThrownBy(() -> new BaseballNumber(order, baseballNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 범위를 초과하였습니다.");
    }

    @DisplayName("같은 자리이면서 숫자도 같은 경우, 스트라이크 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"0:3"}, delimiter = ':')
    void compareNumber_STRIKE(int order, int number) {
        Score resultScore = baseballNumber.compareNumber(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.STRIKE);
    }

    @DisplayName("자리는 다르지만 숫자가 같은 경우, 볼 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:3"}, delimiter = ':')
    void compareNumber_BALL(int order, int number) {
        Score resultScore = baseballNumber.compareNumber(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.BALL);
    }

    @DisplayName("자리도 다르고 숫자도 다른 경우, 낫싱 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:9"}, delimiter = ':')
    void compareNumber_NOTHING(int order, int number) {
        Score resultScore = baseballNumber.compareNumber(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.NOTHING);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(new Order(0), 0),
                Arguments.of(new Order(1), 10)
        );
    }
}
