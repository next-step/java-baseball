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

    public void setAnswerForTest() {
        baseBallGame.setAnswerHundreds(3);
        baseBallGame.setAnswerTens(6);
        baseBallGame.setAnswerOnes(9);
    }

    @Test
    public void strikeTest() {
        setAnswerForTest();
        baseBallGame.checkNumber(369);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(3);

        baseBallGame.checkNumber(367);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(2);

        baseBallGame.checkNumber(269);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(2);

        baseBallGame.checkNumber(379);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(2);

        baseBallGame.checkNumber(312);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(1);

        baseBallGame.checkNumber(467);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(1);

        baseBallGame.checkNumber(579);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(1);

        baseBallGame.checkNumber(125);
        Assertions.assertThat(baseBallGame.getStrike()).isEqualTo(0);
    }

    @Test
    public void ballTest() {
        setAnswerForTest();
        baseBallGame.checkNumber(369);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(0);

        baseBallGame.checkNumber(123);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(1);

        baseBallGame.checkNumber(126);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(1);

        baseBallGame.checkNumber(912);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(1);

        baseBallGame.checkNumber(136);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(2);

        baseBallGame.checkNumber(296);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(2);

        baseBallGame.checkNumber(931);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(2);

        baseBallGame.checkNumber(936);
        Assertions.assertThat(baseBallGame.getBall()).isEqualTo(3);
    }
}
