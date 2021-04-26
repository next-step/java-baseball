import baseball.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import baseball.service.Game;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(123);
    }

    @Test
    void create_game_and_random_three_digits() {
        Game game = new Game();
        for (int i = 0; i <100000; i++) {
            assertThat(String.valueOf(game.getOpponent())).hasSize(3);
        }
    }

    @Test
    void all_strike() {
        assertPlay(game.play(123), 3, 0);
    }

    @Test
    void some_strike() {
        assertPlay(game.play(145), 1, 0);
        assertPlay(game.play(125), 2, 0);
    }

    @Test
    void nothing() {
        assertPlay(game.play(456), 0, 4);
    }

    @Test
    void one_ball() {
        assertPlay(game.play(451), 0, 1);
    }

    @Test
    void many_ball() {
        assertPlay(game.play(431), 0, 2);
        assertPlay(game.play(231), 0, 3);
    }

    @Test
    void one_strike_two_ball() {
        assertPlay(game.play(132), 1, 2);
    }

    private void assertPlay(Score score, int strike, int ball) {
        assertThat(score.getStrike()).isEqualTo(strike);
        assertThat(score.getBall()).isEqualTo(ball);
    }

}
