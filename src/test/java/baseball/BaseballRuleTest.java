package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballRuleTest {

    @Test
    @DisplayName("스트라이크 갯수 반환")
    public void checkStrikeCountTest() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        computer.addAll(Arrays.asList(4, 9, 6));
        answer.addAll(Arrays.asList(1, 4, 6));
        BaseballRule baseballRule = new BaseballRule(computer);
        baseballRule.setAnswer(answer);
        baseballRule.checkNumbers();
        assertThat(baseballRule.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 갯수 반환")
    public void checkBallCountTest() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        computer.addAll(Arrays.asList(4, 9, 6));
        answer.addAll(Arrays.asList(6, 4, 1));
        BaseballRule baseballRule = new BaseballRule(computer);
        baseballRule.setAnswer(answer);
        baseballRule.checkNumbers();
        assertThat(baseballRule.getBall()).isEqualTo(2);
    }
}
