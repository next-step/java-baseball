package domain;

import domain.exceptions.InvalidBaseballResultParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballResultTests {
    @DisplayName("포볼 결과를 생성할 수 있다.")
    @Test
    void createFourBallTest() {
        BaseballResult baseballResult = BaseballResult.makeFourBall();

        assertThat(baseballResult).isEqualTo(new BaseballResult(0, 0, true));
    }

    @DisplayName("포볼 여부를 알려줄 수 있다.")
    @Test
    void isFourBallTest() {
        assertThat(BaseballResult.makeFourBall().isFourBall()).isTrue();
    }

    @DisplayName("볼, 스트라이크가 섞인 결과를 생성할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:1", "1:0", "0:1"}, delimiter = ':')
    void createBallStrikeResultTest(int ballCount, int strikeCount) {

        BaseballResult baseballResult = BaseballResult.of(ballCount, strikeCount);

        assertThat(baseballResult).isEqualTo(new BaseballResult(ballCount, strikeCount, false));
    }

    @DisplayName("포볼 상태일 때 스트라이크나 볼 값을 0 외에 가질 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "2:1:true", "1:0:true", "0:1:true"}, delimiter = ':')
    void fourBallValidationTest(int ballCount, int strikeCount, boolean fourBall) {
        assertThatThrownBy(() -> new BaseballResult(ballCount, strikeCount, fourBall))
                .isInstanceOf(InvalidBaseballResultParameterException.class);
    }

    @DisplayName("음수로 볼이나 스트라이크 결과를 만들 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"-1:-1", "-2:0", "0:-2"}, delimiter = ':')
    void validateBallStrikeTest(int ballCount, int strikeCount) {
        assertThatThrownBy(() -> BaseballResult.of(ballCount, strikeCount))
                .isInstanceOf(InvalidBaseballResultParameterException.class);
    }

    @DisplayName("볼과 스트라이트의 총합이 3을 넘을 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"4:0", "0:4", "1:3", "3:1"}, delimiter = ':')
    void validateMaxCount(int ballCount, int strikeCount) {
        assertThatThrownBy(() -> BaseballResult.of(ballCount, strikeCount))
                .isInstanceOf(InvalidBaseballResultParameterException.class);
    }
}
