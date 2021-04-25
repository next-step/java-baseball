package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberScoreTest {

    BaseballNumbers baseballNumbers;
    BaseballNumbers threeStrikeBaseballNumbers;

    @BeforeEach
    void setDefaultBaseballNumbers() {
        baseballNumbers = makeNormalBaseballNumber(1, 2, 3);
        threeStrikeBaseballNumbers = makeNormalBaseballNumber(1, 2, 3);
    }

    private BaseballNumbers makeNormalBaseballNumber(int number1, int number2, int number3) {
        List<Integer> initNumbers = new ArrayList<>(Arrays.asList(number1, number2, number3));
        return BaseballNumbers.create(initNumbers);
    }

    @DisplayName("3스트라이크 게임종료 테스트")
    @Test
    void judgeEndGameBaseballResult() {
        BaseballNumberScore baseballNumberScore = new BaseballNumberScore(baseballNumbers);
        BaseballResult result = baseballNumberScore.judge(threeStrikeBaseballNumbers);

        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertTrue(result.isEndGame());
    }

    @DisplayName("1스크라이크 2볼 테스트")
    @Test
    void oneStrikeTwoBallJudgeTest() {
        BaseballNumberScore baseballNumberScore = new BaseballNumberScore(baseballNumbers);
        BaseballResult result = baseballNumberScore.judge(makeNormalBaseballNumber(3, 2, 1));

        assertThat(result.getBallCount()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertFalse(result.isEndGame());
    }

    @DisplayName("3볼 테스트")
    @Test
    void threeBallJudgeTest() {
        BaseballNumberScore baseballNumberScore = new BaseballNumberScore(baseballNumbers);
        BaseballResult result = baseballNumberScore.judge(makeNormalBaseballNumber(3, 1, 2));

        assertThat(result.getBallCount()).isEqualTo(3);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertFalse(result.isEndGame());
    }

    @DisplayName("파울 테스트")
    @Test
    void foulJudgeTest() {
        BaseballNumberScore baseballNumberScore = new BaseballNumberScore(baseballNumbers);
        BaseballResult result = baseballNumberScore.judge(makeNormalBaseballNumber(4, 5, 6));

        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertTrue(result.isFoul());
        assertFalse(result.isEndGame());
    }
}
