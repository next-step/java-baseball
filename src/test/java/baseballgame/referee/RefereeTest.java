package baseballgame.referee;

import baseballgame.ball.Ball;
import baseballgame.ball.SelectBallsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
class RefereeTest {
    private LinkedHashSet<Ball> playerBalls;
    private LinkedHashSet<Ball> computerBalls;
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("심판이 플레이어와 컴퓨터에게 공을 받아 스트라이크 개수를 확인한다.")
    void judgementStrike_twoStrike_2() {
        Integer[] playerNumbers = new Integer[]{9, 5, 2};
        Integer[] computerNumbers = new Integer[]{9, 5, 3};
        playerBalls = new SelectBallsFactory(playerNumbers).createBalls();
        computerBalls = new SelectBallsFactory(computerNumbers).createBalls();
        int count = referee.judgeStrike(playerBalls, computerBalls);
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("심판이 플레이어와 컴퓨터에게 공을 받아 볼의 개수를 확인한다.")
    void judgementBall_twoBall_2() {
        Integer[] playerNumbers = new Integer[]{3, 2, 5};
        Integer[] computerNumbers = new Integer[]{9, 5, 3};
        playerBalls = new SelectBallsFactory(playerNumbers).createBalls();
        computerBalls = new SelectBallsFactory(computerNumbers).createBalls();
        int count = referee.judgeBall(playerBalls, computerBalls);
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("심판이 플레이어와 컴퓨터에게 공을 받아 게임결과를 확인한다. -> 올 스트라이크 게임이 끝남")
    void judgement_allStrike_o() {
        Integer[] playerNumbers = new Integer[]{4, 5, 6};
        Integer[] computerNumbers = new Integer[]{4, 5, 6};
        playerBalls = new SelectBallsFactory(playerNumbers).createBalls();
        computerBalls = new SelectBallsFactory(computerNumbers).createBalls();
        assertThat(referee.judgementGame(playerBalls, computerBalls)).isEqualTo(true);
    }

    @Test
    @DisplayName("심판이 플레이어와 컴퓨터에게 공을 받아 게임결과를 확인한다. -> 올 스트라이크x 게임 끝나지 않음")
    void judgement_allStrike_x() {
        Integer[] playerNumbers = new Integer[]{1, 2, 3};
        Integer[] computerNumbers = new Integer[]{4, 5, 6};
        playerBalls = new SelectBallsFactory(playerNumbers).createBalls();
        computerBalls = new SelectBallsFactory(computerNumbers).createBalls();
        assertThat(referee.judgementGame(playerBalls, computerBalls)).isEqualTo(false);
    }
}