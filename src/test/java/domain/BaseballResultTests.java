package domain;

import domain.exceptions.InvalidFourBallStatusException;
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
                .isInstanceOf(InvalidFourBallStatusException.class);
    }
}
