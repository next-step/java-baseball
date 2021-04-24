package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRulesTest {
    @Test
    @DisplayName("스트라이크 개수를 갖는다.")
    public void 스트라이크_개수를_갖는다() {
        List<GameRule> gameRuleList = Arrays.asList(GameRule.STRIKE, GameRule.STRIKE);
        GameRules gameRules = new GameRules(gameRuleList);

        assertThat(gameRules.countOfStrike())
                .isEqualTo(2);
    }
}
