package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자볼")
public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,8,9})
    @DisplayName("범위는 1~9")
    public void ballRangeOneToNine(int number) throws Exception {
        Ball ball = new Ball(number);
        assertThat(ball.toInt()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("범위는 1~9 벗어나면 에러")
    public void ballRangeError(int number) throws Exception {
        assertThatThrownBy(() -> new Ball(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
