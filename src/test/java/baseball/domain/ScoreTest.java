package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    @DisplayName("스트라이크 개수를 갖는다.")
    public void 스트라이크_개수를_갖는다() {
        List<GameRule> gameRuleList = Arrays.asList(GameRule.STRIKE, GameRule.STRIKE);
        Score score = new Score(gameRuleList);

        assertThat(score.countOfStrike())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수를 갖는다.")
    public void 볼_개수를_갖는다() {
        List<GameRule> gameRuleList = Arrays.asList(GameRule.BALL, GameRule.BALL, GameRule.BALL);
        Score score = new Score(gameRuleList);

        assertThat(score.countOfBall())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("미싱 개수를 갖는다.")
    public void 미싱_개수를_갖는다() {
        List<GameRule> gameRuleList = Arrays.asList(GameRule.MISSING);
        Score score = new Score(gameRuleList);

        assertThat(score.countOfMissing())
                .isEqualTo(1);
    }
}
