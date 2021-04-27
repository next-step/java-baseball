package baseball;

import baseball.judgment.Ball;
import baseball.judgment.JudgmentService;
import baseball.judgment.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {
    private BaseBallGame bbg;

    @BeforeEach
    public void init() {
        bbg = new BaseBallGame();
        bbg.setShuffledNumbers("123");
    }

    @Test
    public void isCorrectAnswerTest() {
        assertThat(bbg.isCorrectAnswer("123")).isTrue() ;
        assertThat(bbg.isCorrectAnswer("124")).isFalse() ;
    }

    @Test
    public void continueGameTest() {
        assertThat(bbg.isContinueGame("1")).isTrue();
        assertThat(bbg.isContinueGame("2")).isFalse();
        assertThat(bbg.isContinueGame("3")).isFalse();
    }

    @Test
    public void makeHintTest() {
        bbg.makeHint("123");
        bbg.makeHint("312");
        bbg.makeHint("213");
        bbg.makeHint("143");
        bbg.makeHint("426");
        bbg.makeHint("486");
        bbg.makeHint("412");
        bbg.makeHint("389");
    }
}
