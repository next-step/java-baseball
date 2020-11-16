package baseball;

import baseball.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName(value = "같은 수 같은 자리 = STRIKE n개 , 다른 자리 BALL n개")
    @ParameterizedTest
    @CsvSource(value = {"'1,2,3',0,1,false,false", "'4,7,9',0,1,false,false", "'2,4,5',2,0,false,false", "'2,4,8',3,0,false,true"}, delimiter = ',')
    void play(String input, int strikeCount, int ballCount, boolean isNothing, boolean isThreeStrike) {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(computedBallNumber));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);
        baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber(input))));

        assertThat(baseBallGame.getBallCount().getStrikeCount()).isEqualTo(strikeCount);
        assertThat(baseBallGame.getBallCount().getBallCount()).isEqualTo(ballCount);
        assertThat(baseBallGame.getBallCount().isNothing()).isEqualTo(isNothing);
        assertThat(baseBallGame.getBallCount().isThreeStrike()).isEqualTo(isThreeStrike);
    }

    @DisplayName(value = "4BALL, Nothing")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,7", "1,3,5", "6,7,9", "3,7,9"})
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
