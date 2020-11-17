package domain.number;

import domain.generator.BaseBallNumberGenerator;
import domain.generator.PlayerNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallNumbersTest {

    private BaseBallNumbers computerBaseBallNumbers;

    @BeforeEach
    void init() {
        BaseBallNumberGenerator baseBallNumberGenerator = () -> {
            List<BaseBallNumber> baseBallNumbers = new ArrayList<>();
            baseBallNumbers.add(new BaseBallNumber(1));
            baseBallNumbers.add(new BaseBallNumber(2));
            baseBallNumbers.add(new BaseBallNumber(3));
            return baseBallNumbers;
        };

        this.computerBaseBallNumbers = new BaseBallNumbers(baseBallNumberGenerator);
    }


    @ParameterizedTest
    @DisplayName("야구게임 STRIKE 갯수 카운팅 테스트")
    @ValueSource(ints = {153, 173, 193})
    void find_strike_count_test(int input) {

        // given
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(new PlayerNumberGenerator(input));

        // when
        int strikeCount = BaseBallNumbers.findStrikeCount(computerBaseBallNumbers, playerBaseBallNumbers);

        // then
        assertThat(strikeCount).isEqualTo(2);
    }


    @ParameterizedTest
    @DisplayName("야구게임 BALL 갯수 카운팅 테스트")
    @ValueSource(ints = {315, 237, 412})
    void find_ball_count_test(int input) {

        // given
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(new PlayerNumberGenerator(input));

        // when
        int ballCount = BaseBallNumbers.findBallCount(computerBaseBallNumbers, playerBaseBallNumbers);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

}
