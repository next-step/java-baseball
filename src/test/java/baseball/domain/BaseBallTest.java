package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.exception.DuplicatedNumberException;
import baseball.domain.exception.NoThreeDigitException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallTest {
    @Test
    void create() {
        assertThatCode(() -> BaseBall.of(new RandomNumber())).doesNotThrowAnyException();
        assertThat(BaseBall.of(new IncrementsNumber())).isEqualTo(BaseBall.of("123"));
    }

    @Test
    void validThreeDigit() {
        assertThatThrownBy(() -> BaseBall.of("15"))
            .hasMessageMatching("세자리 숫자를 입력해주세요.")
            .isInstanceOf(NoThreeDigitException.class);
    }

    @Test
    void validDuplicateBall() {
        assertThatThrownBy(() -> BaseBall.of("119"))
            .hasMessageMatching("숫자는 중복되지 않아야 합니다.")
            .isInstanceOf(DuplicatedNumberException.class);
    }

    @ParameterizedTest
    @CsvSource({"123, 123, 3"
        , "123, 124, 2", "123, 423, 2", "123, 143, 2"
        , "123, 145, 1", "123, 456, 0"})
    void countStrike(String numbers, String inputNumbers, int strikeCount) {
        BaseBall baseBall = BaseBall.of(numbers);
        BaseBall inputBaseBall = BaseBall.of(inputNumbers);

        assertThat(baseBall.countStrike(inputBaseBall)).isEqualTo(strikeCount);
    }

    @ParameterizedTest
    @CsvSource({"123, 312, 3"
        , "123, 412, 2", "123, 234, 2", "123, 341, 2", "123, 213, 2"
        , "123, 415, 1", "123, 456, 0"})
    void countBall(String numbers, String inputNumbers, int ballCount) {
        BaseBall baseBall = BaseBall.of(numbers);
        BaseBall inputBaseBall = BaseBall.of(inputNumbers);

        assertThat(baseBall.countBall(inputBaseBall)).isEqualTo(ballCount);
    }
}
