package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallResultTest {

    private ComputerBallNumber computerBallNumber;

    @BeforeEach
    void init() {
        BaseBallNumberGenerator baseBallNumberGenerator = () -> {
            List<BaseBallNumber> baseBallNumbers = new ArrayList<>();
            baseBallNumbers.add(new BaseBallNumber(1));
            baseBallNumbers.add(new BaseBallNumber(2));
            baseBallNumbers.add(new BaseBallNumber(3));
            return baseBallNumbers;
        };

        this.computerBallNumber = new ComputerBallNumber(baseBallNumberGenerator);
    }

    @ParameterizedTest
    @DisplayName("야구게임 STRIKE 결과 테스트")
    @ValueSource(ints = {143, 163, 183})
    void strike_count_test(int input) {

        // given
        PlayerBallNumber playerBallNumber = new PlayerBallNumber(new PlayerNumberGenerator(input));

        // when
        BaseBallResult baseBallResult = new BaseBallResult(computerBallNumber, playerBallNumber);
        Strike strike = baseBallResult.getStrike();

        // then
        assertThat(strike.getStrikeCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("야구게임 BALL 결과 테스트")
    @ValueSource(ints = {317, 432, 132})
    void ball_count_test(int input) {

        // given
        PlayerBallNumber playerBallNumber = new PlayerBallNumber(new PlayerNumberGenerator(input));

        // when
        BaseBallResult baseBallResult = new BaseBallResult(computerBallNumber, playerBallNumber);
        Ball ball = baseBallResult.getBall();

        // then
        assertThat(ball.getBallCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("야구게임 숫자 3개 모두 일치한 결과 테스트")
    @ValueSource(ints = {123})
    void three_strike_test(int input) {

        // given
        PlayerBallNumber playerBallNumber = new PlayerBallNumber(new PlayerNumberGenerator(input));

        // when
        BaseBallResult baseBallResult = new BaseBallResult(computerBallNumber, playerBallNumber);

        // then
        assertThat(baseBallResult.isThreeStrike()).isTrue();
    }

}
