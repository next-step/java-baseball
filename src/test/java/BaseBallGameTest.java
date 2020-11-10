import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {

    BaseBallGame game = new BaseBallGame();

    @Test
    void setNumberTest() {
        for (int i = 0; i < game.setNumber().length; i++) {
            assertThat(game.setNumber()[i]);
        }
    }
}