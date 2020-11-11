package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberHintTest {

    @Test
    @DisplayName("볼 힌트 생성")
    void testBallHint() {
        // given
        int count = 1;
        // when
        BallHint ballHint = new BallHint(count);
        // then
        assertThat(ballHint.getCount()).isEqualTo(count);
        assertThat(ballHint.getMarking()).isEqualTo(count + BallHint.BALL_MARKING);
    }

    @Test
    @DisplayName("스트라이크 힌트")
    void testStrikeHint() {
        // given
        int count = 1;
        // when
        StrikeHint strikeHint = new StrikeHint(count);
        // then
        assertThat(strikeHint.getCount()).isEqualTo(count);
        assertThat(strikeHint.getMarking()).isEqualTo(count + StrikeHint.STRIKE_MARKING);
    }
}
