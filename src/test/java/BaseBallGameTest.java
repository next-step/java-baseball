import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    BaseBallGame game = new BaseBallGame();

    @Test
    void setNumberTest() {
        for (int i = 0; i < game.setNumber().length; i++) {
            assertThat("컴퓨터 입력" + game.setNumber()[i]);
        }
    }

    @Test
    void inputNumberTest() throws Exception {
        for (int i = 0; i < game.inputNumber().length; i++) {
            assertThat("유저 입력 : " + game.inputNumber()[i]);
        }
    }

    @Test
    void checkNumberTest() {
        assertTrue(game.checkNumber("123"));
        assertTrue(game.checkNumber("456"));
        assertFalse(game.checkNumber("12345"));
        assertFalse(game.checkNumber("qwef"));
        assertFalse(game.checkNumber("12f"));
    }
}