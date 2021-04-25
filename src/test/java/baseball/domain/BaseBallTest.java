package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallTest {
    @Test
    void equals() {
        assertThat(BaseBall.of(Arrays.asList(Ball.of(1), Ball.of(5), Ball.of(9)))).isEqualTo(BaseBall.of("159"));
    }

    @Test
    void createRandom() {
        assertThatCode(() -> BaseBall.ofRandom(new RandomNumber())).doesNotThrowAnyException();
    }

    @Test
    void validDuplicateBall() {
        assertThatThrownBy(() -> BaseBall.of("119"))
            .hasMessageMatching("숫자는 중복되지 않아야 합니다.")
            .isInstanceOf(DuplicatedNumberException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 1, 2, 3, 3"
        , "1, 2, 3, 1, 2, 4, 2", "1, 2, 3, 4, 2, 3, 2", "1, 2, 3, 1, 4, 3, 2"
        , "1, 2, 3, 1, 4, 5, 1", "1, 2, 3, 4, 5, 6, 0"})
    void countStrike(int number1, int number2, int number3, int input1, int input2, int input3, int strikeCount) {
        BaseBall baseBall = BaseBall.of(Arrays.asList(Ball.of(number1), Ball.of(number2), Ball.of(number3)));
        BaseBall inputBaseBall = BaseBall.of(Arrays.asList(Ball.of(input1), Ball.of(input2), Ball.of(input3)));

        assertThat(baseBall.countStrike(inputBaseBall)).isEqualTo(strikeCount);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 3, 1, 2, 3"
        , "1, 2, 3, 4, 1, 2, 2", "1, 2, 3, 2, 3, 4, 2", "1, 2, 3, 3, 4, 1, 2"
        , "1, 2, 3, 4, 1, 5, 1", "1, 2, 3, 4, 5, 6, 0"})
    void countBall(int number1, int number2, int number3, int input1, int input2, int input3, int strikeCount) {
        BaseBall baseBall = BaseBall.of(Arrays.asList(Ball.of(number1), Ball.of(number2), Ball.of(number3)));
        BaseBall inputBaseBall = BaseBall.of(Arrays.asList(Ball.of(input1), Ball.of(input2), Ball.of(input3)));

        assertThat(baseBall.countBall(inputBaseBall)).isEqualTo(strikeCount);
    }
}
