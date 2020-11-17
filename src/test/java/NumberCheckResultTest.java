import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import result.Ball;
import result.Strike;

import static org.assertj.core.api.Assertions.*;

public class NumberCheckResultTest {

    private NumberCheckResult correctCheckResult;
    private NumberCheckResult allWrongCheckResult;
    private NumberCheckResult twoBallCheckResult;
    private NumberCheckResult mixedCheckResult;

    @BeforeEach
    public void setUp() {
        correctCheckResult = new NumberCheckResult(3);
        correctCheckResult.add(new Strike());
        correctCheckResult.add(new Strike());
        correctCheckResult.add(new Strike());

        allWrongCheckResult = new NumberCheckResult(3);

        twoBallCheckResult = new NumberCheckResult(3);
        twoBallCheckResult.add(new Ball());
        twoBallCheckResult.add(new Ball());

        mixedCheckResult = new NumberCheckResult(3);
        mixedCheckResult.add(new Ball());
        mixedCheckResult.add(new Strike());
        mixedCheckResult.add(new Strike());
    }

    @Test
    public void testCorrect() {
        assertThat(correctCheckResult.correct()).isTrue();
        assertThat(allWrongCheckResult.correct()).isFalse();
        assertThat(twoBallCheckResult.correct()).isFalse();
        assertThat(mixedCheckResult.correct()).isFalse();
    }

    @Test
    public void testToString() {
        assertThat(correctCheckResult.toString()).isEqualTo("모두 맞추셨습니다");
        assertThat(allWrongCheckResult.toString()).isEqualTo("아무것도 맞추지 못하셧습니다");
        assertThat(twoBallCheckResult.toString()).isEqualTo("2 볼 ");
        assertThat(mixedCheckResult.toString()).isEqualTo("1 볼 2 스트라이크 ");
    }

}
