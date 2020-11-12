package nextstep.precourse.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    void isFourBall() {
        GameResult gameResultFalse = new GameResult(1, 1);
        GameResult gameResultTrue = new GameResult(0, 0);

        assertThat(gameResultFalse.isFourBall()).isFalse();
        assertThat(gameResultTrue.isFourBall()).isTrue();
    }
}
