import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void create_game_and_random_three_digits() {
        Game game = new Game();
        for (int i = 0; i <100000; i++) {
            assertThat(String.valueOf(game.getOpponent())).hasSize(3);
        }
    }

    @Test
    void all_strike() {
        Game game = new Game(123);
        Score score = game.play(123);
        assertThat(score.getStrike()).isEqualTo(3);
        assertThat(score.getBall()).isEqualTo(0);
    }

    @Test
    void one_strike() {
        Game game = new Game(123);
        Score score = game.play(145);
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(0);
    }

}
