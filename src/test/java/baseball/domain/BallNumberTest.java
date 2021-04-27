package baseball.domain;

import baseball.exceptions.InvalidBallNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BallNumberTest {

    @DisplayName("야구 숫자 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void createBallNumberTest(int input) {
        //when
        BallNumber createdBallNumber = new BallNumber(input);

        //then
        assertThat(createdBallNumber).isEqualTo(new BallNumber(input));
    }

    @DisplayName("야구 숫자 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void createBallNumberWithNullAndEmptyTest(int input) {
        //when, then
        assertThatThrownBy(() -> {
            BallNumber createdBallNumber = new BallNumber(input);
        }).isInstanceOf(InvalidBallNumberException.class)
                .hasMessage(InvalidBallNumberException.DEFAULT_MESSAGE);
    }
}
