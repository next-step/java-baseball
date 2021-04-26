package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자")
public class NumberBallTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,8,9})
    @DisplayName("범위는 1~9")
    public void numberBallRangeOneToNine(int number) throws Exception {
        NumberBall numberBall = new NumberBall(number);
        assertThat(numberBall.toInt()).isEqualTo(number);
    }


}
