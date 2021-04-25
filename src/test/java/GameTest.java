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

}
