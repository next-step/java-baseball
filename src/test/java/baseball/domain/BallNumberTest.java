package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @DisplayName("볼 값 객체 생성 테스트 - 1 ~ 9 이내의 값으로 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 6, 8, 9})
    void createNumber(int number) {
        BallNumber actual = new BallNumber(number);

        assertThat(actual).isEqualTo(new BallNumber(number));
    }

    @DisplayName("볼 값 객체 생성 유효성 테스트 - 1 ~ 9 이외의 값이 들어오면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10})
    void validateNumber(int number) {
        assertThatThrownBy(() -> {
            new BallNumber(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자값은 1보다 작거나 9보다 클 수 없습니다.");
    }
}
