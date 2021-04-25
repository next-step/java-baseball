import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void one_strike() {
        assertPlay(game.play(145), 1, 0);
    }

    private void assertPlay(Score score, int strike, int ball) {
        assertThat(score.getStrike()).isEqualTo(strike);
        assertThat(score.getBall()).isEqualTo(ball);
    }

}
