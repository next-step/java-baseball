import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRuleStrikeTest {

    @Test
    public void checkStrikeRuleRightAnswerTests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "123");

        assertThat(gameRuleStrike.isThreeStrike()).isEqualTo(true);
        assertThat(gameRuleStrike.getHint()).isEqualTo("");
    }

    @Test
    public void strike1Tests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "673");

        assertThat(gameRuleStrike.isThreeStrike()).isEqualTo(false);
        assertThat(gameRuleStrike.getHint()).isEqualTo("1 스트라이크");
    }

    @Test
    public void strike2Tests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "122");

        assertThat(gameRuleStrike.isThreeStrike()).isEqualTo(false);
        assertThat(gameRuleStrike.getHint()).isEqualTo("2 스트라이크");
    }

    @Test
    public void strikeNothingTests() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "231");

        assertThat(gameRuleStrike.isNothing()).isEqualTo(true);
        assertThat(gameRuleStrike.getHint()).isEqualTo("낫싱");
    }

    @Test
    void getHint() {
        GameRuleStrike gameRuleStrike = new GameRuleStrike("123", "456");

        assertThat(gameRuleStrike.getHint()).isEqualTo("낫싱");
    }
}