package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void setFinish() {
        Game game = new Game();

        game.setFinish(new MenuNumber("1"));
        Assertions.assertThat(game.isRunning()).isTrue();

        game.setFinish(new MenuNumber("2"));
        Assertions.assertThat(game.isRunning()).isFalse();
    }
}
