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
    void result(String player, String computer, int strike, int ball) {
        GameResult result = GameResult.of(BallNumbers.from(player), BallNumbers.from(computer));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(strike),
                () -> assertThat(result.getBall()).isEqualTo(ball)
        );
    }
}