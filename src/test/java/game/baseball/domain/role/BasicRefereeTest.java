package game.baseball.domain.role;

import game.baseball.domain.Ball;
import game.baseball.domain.Result;
import game.baseball.domain.rule.BaseballGameRule;
import game.baseball.domain.rule.NormalModeRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasicRefereeTest {

    private BaseballGameRule rule;
    private Referee referee;

    @BeforeEach
    private void setup() {
        this.rule = new NormalModeRule();
        this.referee = new BasicReferee(rule);
    }

    @Test
    @DisplayName("심판 : 결과 판단 테스트 > One Strike Two Ball")
    void judgeAllStrike() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(1, 3, 2);

        // when
        Result result = referee.judge(input, answer);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
        assertThat(result.isNothing()).isEqualTo(false);
        assertThat(result.isOut()).isEqualTo(false);
    }

    @Test
    @DisplayName("심판 : 결과 판단 테스트 > All Ball")
    void judgeAllBall() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(2, 3, 1);

        // when
        Result result = referee.judge(input, answer);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
        assertThat(result.isNothing()).isEqualTo(false);
        assertThat(result.isOut()).isEqualTo(false);
    }


    @Test
    @DisplayName("심판 : 결과 판단 테스트 > Nothing")
    void judgeNothing() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(4, 5, 6);

        // when
        Result result = referee.judge(input, answer);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.isNothing()).isEqualTo(true);
        assertThat(result.isOut()).isEqualTo(false);
    }

    @Test
    @DisplayName("심판 : 결과 판단 테스트 > Out(모든 숫자 맞춤)")
    void judgeOut() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(1, 2, 3);

        // when
        Result result = referee.judge(input, answer);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.isNothing()).isEqualTo(false);
        assertThat(result.isOut()).isEqualTo(true);

    }

    @Test
    @DisplayName("심판 : 스트라이크 판단 테스트")
    void judgeStrike() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        Ball strikeBall = new Ball(1, 0);

        // when
        referee.judgeStrike(strikeBall, answer);

        // then
        assertThat(referee.getResult().getStrikeCount()).isEqualTo(1);
        assertThat(referee.getResult().getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("심판 : 볼 판단 테스트")
    void judgeBall() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        Ball ball = new Ball(1, 1);

        // when
        referee.judgeBall(ball, answer);

        // then
        assertThat(referee.getResult().getStrikeCount()).isEqualTo(0);
        assertThat(referee.getResult().getBallCount()).isEqualTo(1);
    }
}