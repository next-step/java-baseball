import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
    private BaseBallGame baseBallGame;

    @BeforeEach
    public void init() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    public void setAnswerTest() {
        baseBallGame.setAnswer();
        Assertions.assertThat(baseBallGame.getAnswerHundreds()).isNotEqualTo(baseBallGame.getAnswerTens());
        Assertions.assertThat(baseBallGame.getAnswerTens()).isNotEqualTo(baseBallGame.getAnswerOnes());
        Assertions.assertThat(baseBallGame.getAnswerOnes()).isNotEqualTo(baseBallGame.getAnswerHundreds());
    }
}
