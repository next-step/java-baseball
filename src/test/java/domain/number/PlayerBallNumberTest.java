package domain.number;

import domain.generator.PlayerNumberGenerator;
import domain.number.BaseBallNumber;
import domain.number.BaseBallNumbers;
import domain.number.PlayerBallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerBallNumberTest {

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자의 야구볼 생성 테스트")
    @CsvSource(value = {"751=5", "892=9", "321=2"}, delimiter = '=')
    void player_ball_number_test(int input, int expected) {

        // given
        PlayerBallNumber playerBallNumber = new PlayerBallNumber(new PlayerNumberGenerator(input));

        // when
        BaseBallNumbers playerBallNumbers = playerBallNumber.getBallNumbers();

        // then
        assertThat(playerBallNumbers.getBaseBallNumber(1)).isEqualTo(new BaseBallNumber(expected));
    }

}
