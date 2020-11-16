import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRuleBallTest {

    @Test
    public void ball0Tests() {
        GameRuleBall gameRuleBall = new GameRuleBall("123", "123");

        assertThat(gameRuleBall.getHint()).isEqualTo("");
    }

    @Test
    public void ball1Tests() {
        GameRuleBall gameRuleBall = new GameRuleBall("123", "415");

        assertThat(gameRuleBall.getHint()).isEqualTo("1 볼");
    }

    @Test
    public void ball2Tests() {
        GameRuleBall gameRuleBall = new GameRuleBall("123", "236");

        assertThat(gameRuleBall.getHint()).isEqualTo("2 볼");
    }

    @Test
    public void ball3Tests() {
        GameRuleBall gameRuleBall = new GameRuleBall("123", "312");

        assertThat(gameRuleBall.getHint()).isEqualTo("3 볼");
    }
}