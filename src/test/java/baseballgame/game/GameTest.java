package baseballgame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("Game은 answerGameNumber를 갖는다.")
    @Test
    public void gameObjectAlwaysHasGameNumberTest() {
        // when
        final Game game = new Game();
        // then
        assertThat(game).extracting("answerGameNumber").isInstanceOf(GameNumber.class);
    }

}