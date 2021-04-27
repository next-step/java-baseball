package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallGameTest {

    private List<Integer> computerNumbers = new ArrayList<>();

    @DisplayName(value = "게임 시작 번호")
    @BeforeEach
    void setup() {
        computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
    }

    @DisplayName(value = "2 Strike 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,4"})
    void playTwoStrike(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(0);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(2);
        assertFalse(baseballResult.isEndGame());
        assertFalse(baseballResult.isNothing());
    }

    @DisplayName(value = "2 Ball 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2,3,4"})
    void playTwoBall(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(2);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(0);
        assertFalse(baseballResult.isEndGame());
        assertFalse(baseballResult.isNothing());
    }

    @DisplayName(value = "1 Strike, 1 Ball 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,3,4"})
    void playOneStrikeOneBall(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(1);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(1);
        assertFalse(baseballResult.isEndGame());
        assertFalse(baseballResult.isNothing());
    }

    @DisplayName(value = "Nothing 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4,5,6"})
    void playNothing(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(0);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(0);
        assertFalse(baseballResult.isEndGame());
        assertTrue(baseballResult.isNothing());
    }

    @DisplayName(value = "Strike 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    void playStrike(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(0);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(3);
        assertTrue(baseballResult.isEndGame());
        assertFalse(baseballResult.isNothing());
    }

    @DisplayName(value = " 동일 수자 케이스에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1"})
    void playSame(String input) {
        List<Integer> playerInputNumbers = InputNumber.setBallNumber(input);
        BallGame ballGame = new BallGame();
        BaseballResult baseballResult = ballGame.getBallCount(new BaseballResult(), computerNumbers, playerInputNumbers);

        assertThat(baseballResult.getBallCount()).isEqualTo(2);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(1);
        assertFalse(baseballResult.isEndGame());
        assertFalse(baseballResult.isNothing());
    }
}
