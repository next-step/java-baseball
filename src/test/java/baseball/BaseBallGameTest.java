package baseball;

import baseball.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseBallGameTest {

    private List<Integer> computedBallNumber = new ArrayList<>();
    private List<Integer> inputBallNumber = new ArrayList<>();

    @DisplayName(value = "컴퓨터 딜러의 설정 번호 임의 지정")
    @BeforeEach
    void setup() {
        computedBallNumber = new ArrayList<>();
        computedBallNumber.add(2);
        computedBallNumber.add(4);
        computedBallNumber.add(8);
    }

    @DisplayName(value = "같은 수 같은 자리 = STRIKE, 다른 자리 BALL, 없으면 4BALL/NOTHING 힌트 출력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    void play1(String input) {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(computedBallNumber));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);
        baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber(input))));

        assertThat(baseBallGame.getBallCount().getStrikeCount()).isEqualTo(0);
        assertThat(baseBallGame.getBallCount().getBallCount()).isEqualTo(1);
        assertThat(baseBallGame.getBallCount().isNothing()).isFalse();
        assertThat(baseBallGame.getBallCount().isThreeStrike()).isFalse();
    }

    @DisplayName(value = "4BALL, Nothing")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,7"})
    void playNothing(String input) {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(computedBallNumber));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);
        baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber(input))));

        assertThat(baseBallGame.getBallCount().getStrikeCount()).isEqualTo(0);
        assertThat(baseBallGame.getBallCount().getBallCount()).isEqualTo(0);
        assertThat(baseBallGame.getBallCount().isNothing()).isTrue();
        assertThat(baseBallGame.getBallCount().isThreeStrike()).isFalse();
    }

    @DisplayName(value = "3 STRIKE")
    @ParameterizedTest
    @ValueSource(strings = {"2,4,8"})
    void playAllStrike(String input) {

        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(computedBallNumber));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);
        baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber(input))));

        assertThat(baseBallGame.getBallCount().getStrikeCount()).isEqualTo(3);
        assertThat(baseBallGame.getBallCount().getBallCount()).isEqualTo(0);
        assertThat(baseBallGame.getBallCount().isNothing()).isFalse();
        assertThat(baseBallGame.getBallCount().isThreeStrike()).isTrue();
    }
}
