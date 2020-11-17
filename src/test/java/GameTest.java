import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    public void testGameIsInitialized() {
        Game game = Game.initialize(1);
        assertThat(game).isNotNull();
    }

}
