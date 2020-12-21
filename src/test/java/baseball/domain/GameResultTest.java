package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {
    @DisplayName("두 BallNumbers가 주어지면 알맞은 결과(strike, ball 갯수)를 구한다.")
    @ParameterizedTest
    @CsvSource({"123,123,3,0", "425,123,1,0", "425,521,1,1", "425,789,0,0", "425,524,1,2", "425,426,2,0"})
    void result(String numbers, String compared, int strike, int ball) {
        GameResult result = GameResult.of(BaseBallNumbers.from(numbers), BaseBallNumbers.from(compared));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(strike),
                () -> assertThat(result.getBall()).isEqualTo(ball)
        );
    }

    @DisplayName("두 BallNumbers에 같은 수가 없으면 낫싱이다.")
    @ParameterizedTest
    @CsvSource({"123,456,true", "123,245,false", "123,145,false"})
    void isNothing(String numbers, String compared, boolean expected) {
        GameResult result = GameResult.of(BaseBallNumbers.from(numbers), BaseBallNumbers.from(compared));

        assertThat(result.isNothing()).isEqualTo(expected);
    }

    @DisplayName("두 BallNumbers가 같으면 3 스트라이크이다.")
    @ParameterizedTest
    @CsvSource({"123,123,true", "123,245,false", "123,145,false"})
    void isThreeStrike(String numbers, String compared, boolean expected) {
        GameResult result = GameResult.of(BaseBallNumbers.from(numbers), BaseBallNumbers.from(compared));

        assertThat(result.isThreeStrike()).isEqualTo(expected);
    }
}
