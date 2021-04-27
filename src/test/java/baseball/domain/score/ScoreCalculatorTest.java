package baseball.domain.score;

import baseball.domain.Ball;
import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;
import baseball.domain.Bat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {
    private ScoreCalculator scoreCalculator;
    private Bat bat;
    private Ball ball;

    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
    }

    @DisplayName("스트라이크를 모두 맞추면 승리 상태를 리턴한다.")
    @Test
    void getWinState() {
        List<BallNumber> threeMatch1 = Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(3));
        List<BallNumber> threeMatch2 = Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(3));
        bat = new Bat(threeMatch1);
        ball = new Ball(new BallNumbers(threeMatch2));

        scoreCalculator.calculateScore(bat, ball);

        assertThat(scoreCalculator.getScore()).isInstanceOf(Win.class);
    }

    @DisplayName("스트라이크이나 볼이 있으면 일반 상태을 리턴한다.")
    @Test
    void getNormalState() {
        List<BallNumber> oneMatch1 = Arrays.asList(new BallNumber(4), new BallNumber(9), new BallNumber(6));
        List<BallNumber> oneMatch2 = Arrays.asList(new BallNumber(4), new BallNumber(2), new BallNumber(3));
        Bat bat = new Bat(oneMatch1);
        BallNumbers ballNumbers = new BallNumbers(oneMatch2);
        Ball ball = new Ball(ballNumbers);

        scoreCalculator.calculateScore(bat, ball);

        assertThat(scoreCalculator.getScore()).isInstanceOf(Normal.class);
    }

    @DisplayName("맞은것이 없으면 낫싱 상태을 리턴한다.")
    @Test
    void getNothingState() {
        List<BallNumber> noMatch1 = Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(3));
        List<BallNumber> noMatch2 = Arrays.asList(new BallNumber(4), new BallNumber(5), new BallNumber(6));
        Bat bat = new Bat(noMatch1);
        BallNumbers ballNumbers = new BallNumbers(noMatch2);
        Ball ball = new Ball(ballNumbers);

        scoreCalculator.calculateScore(bat, ball);

        assertThat(scoreCalculator.getScore()).isInstanceOf(Nothing.class);
    }
}
