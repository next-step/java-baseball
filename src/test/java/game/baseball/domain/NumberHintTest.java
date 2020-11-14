package game.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static game.baseball.domain.Decision.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberHintTest {

    @Test
    @DisplayName("낫싱")
    void testNothing() {
        NumberHint hint = new NumberHint(Arrays.asList(NONE, NONE, NONE));
        assertNumberHint(hint, false, true, 0, 0);
    }

    @Test
    @DisplayName("3스트라이크")
    void testThreeStrike() {
        NumberHint hint = new NumberHint(Arrays.asList(STRIKE, STRIKE, STRIKE));
        assertNumberHint(hint, true, false, 3, 0);
    }

    @Test
    @DisplayName("3볼")
    void testThreeBall() {
        NumberHint hint = new NumberHint(Arrays.asList(BALL, BALL, BALL));
        assertNumberHint(hint, false, false, 0, 3);
    }

    @Test
    @DisplayName("2스트라이크 1볼")
    void testTwoStrikeAndOneBall() {
        NumberHint hint = new NumberHint(Arrays.asList(STRIKE, STRIKE, BALL));
        assertNumberHint(hint, false, false, 2, 1);
    }

    private void assertNumberHint(NumberHint hint,
                                  boolean threeStrike,
                                  boolean nothing,
                                  int strikeCount,
                                  int ballCount) {
        assertThat(hint.isThreeStrike()).isEqualTo(threeStrike);
        assertThat(hint.isNothing()).isEqualTo(nothing);
        assertThat(hint.strikeCount()).isEqualTo(strikeCount);
        assertThat(hint.ballCount()).isEqualTo(ballCount);
    }
}
