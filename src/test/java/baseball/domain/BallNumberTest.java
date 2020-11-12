package baseball.domain;

import baseball.exception.IllegalBallNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @DisplayName("공 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void constructor_success(int input) {
        new BallNumber(input);
    }

    @DisplayName("1~9 이의 공 번호만 생성 가능")
    @ParameterizedTest
    @ValueSource(ints = {-100, -50, -1, 0, 10, 20, 30, 100})
    public void constructor_fail(int input) {
        assertThatThrownBy(
                () -> new BallNumber(input)
        ).isInstanceOf(IllegalBallNumberException.class)
                .hasMessage("1~9 사이의 정수만 생성 가능");
    }
}
