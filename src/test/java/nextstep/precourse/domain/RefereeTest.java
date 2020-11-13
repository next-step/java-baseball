package nextstep.precourse.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static nextstep.precourse.domain.BallNumberTest.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    //TODO: 반복 코드 Refactoring

    @Test
    @DisplayName("Strike 여부를 판정한다.")
    void isStrike() {
        Set<BallNumber> computerBallNumberList = new HashSet<>();
        computerBallNumberList.add(BALLNUMBER_ONE);
        computerBallNumberList.add(BALLNUMBER_TWO);
        computerBallNumberList.add(BALLNUMBER_THREE);
        BallNumbers computerBallNumbers = new BallNumbers(computerBallNumberList);

        Set<BallNumber> userBallNumberList = new HashSet<>();
        userBallNumberList.add(BALLNUMBER_ONE);
        userBallNumberList.add(BALLNUMBER_SAME_POSITION);
        userBallNumberList.add(BALLNUMBER_SAME_NUMBER);
        BallNumbers userBallNumbers = new BallNumbers(userBallNumberList);

        assertThat(Referee.isStrike(computerBallNumbers, userBallNumbers, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("Ball 여부를 판정한다.")
    void isBall() {
        Set<BallNumber> computerBallNumberList = new HashSet<>();
        computerBallNumberList.add(BALLNUMBER_ONE);
        computerBallNumberList.add(BALLNUMBER_TWO);
        computerBallNumberList.add(BALLNUMBER_THREE);
        BallNumbers computerBallNumbers = new BallNumbers(computerBallNumberList);

        Set<BallNumber> userBallNumberList = new HashSet<>();
        userBallNumberList.add(BALLNUMBER_ONE);
        userBallNumberList.add(BALLNUMBER_SAME_POSITION);
        userBallNumberList.add(BALLNUMBER_SAME_NUMBER);
        BallNumbers userBallNumbers = new BallNumbers(userBallNumberList);

        assertThat(Referee.isBall(computerBallNumbers, userBallNumbers, 3)).isEqualTo(1);
    }

    /**
     * (123, 142) -> 1Strike, 1ball
     */
    @Test
    @DisplayName("BallNumber 두 쌍을 입력받아 결과를 도출한다.")
    void judge() {
        Set<BallNumber> computerBallNumberList = new HashSet<>();
        computerBallNumberList.add(BALLNUMBER_ONE);
        computerBallNumberList.add(BALLNUMBER_TWO);
        computerBallNumberList.add(BALLNUMBER_THREE);
        BallNumbers computerBallNumbers = new BallNumbers(computerBallNumberList);

        Set<BallNumber> userBallNumberList = new HashSet<>();
        userBallNumberList.add(BALLNUMBER_ONE);
        userBallNumberList.add(BALLNUMBER_SAME_POSITION);
        userBallNumberList.add(BALLNUMBER_SAME_NUMBER);
        BallNumbers userBallNumbers = new BallNumbers(userBallNumberList);

        GameResult result = Referee.judge(computerBallNumbers, userBallNumbers);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.isFourBall()).isFalse();
    }

    /**
     * (123, 456) -> four ball
     */
    @Test
    void judge_fourball() {
        Set<BallNumber> computerBallNumberList = new HashSet<>();
        computerBallNumberList.add(BALLNUMBER_ONE);
        computerBallNumberList.add(BALLNUMBER_TWO);
        computerBallNumberList.add(BALLNUMBER_THREE);
        BallNumbers computerBallNumbers = new BallNumbers(computerBallNumberList);

        Set<BallNumber> userBallNumberList = new HashSet<>();
        userBallNumberList.add(BALLNUMBER_FOUR);
        userBallNumberList.add(BALLNUMBER_FIVE);
        userBallNumberList.add(BALLNUMBER_SIX);
        BallNumbers userBallNumbers = new BallNumbers(userBallNumberList);

        GameResult result = Referee.judge(computerBallNumbers, userBallNumbers);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isFourBall()).isTrue();
    }
}
