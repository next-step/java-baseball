import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRuleStrikeTest {

    @Test
    public void checkStrikeRuleRightAnswerTests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "123");

        assertThat(gameRuleStrike.isThreeStrike()).isEqualTo(true);
    }

    @Test
    public void strike2Tests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "122");

        assertThat(gameRuleStrike.isThreeStrike()).isEqualTo(false);
    }

    @Test
    public void strikeNothingTests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "231");

        assertThat(gameRuleStrike.isNothing()).isEqualTo(true);
    }
}