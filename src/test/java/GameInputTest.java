import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameInputTest {

    GameInput gameInput;
    @BeforeEach
    void prepare() {
        gameInput =GameInput.getInstance();
        gameInput.setGameLength(3);
        gameInput.setUpperBound(9);
        gameInput.setLowerBound(1);
    }

    @Test
    @DisplayName("입력값이 3글자인지, '1'~'9' 사이 값인지 확인한다.")
    void isGameInputValid_shouldCheckInvalidInput() {
        assertFalse(gameInput.isGameInputValid("abc"));
        assertFalse(gameInput.isGameInputValid("012"));
        assertFalse(gameInput.isGameInputValid("1234"));
        assertTrue(gameInput.isGameInputValid("426"));
    }

    @Test
    @DisplayName("입력값이 1글자인지, '1','2' 값인지 확인한다.")
    void isControlInputValid_shouldCheckInvalidInput() {
        assertFalse(gameInput.isControlInputValid("abc"));
        assertFalse(gameInput.isControlInputValid("0"));
        assertTrue(gameInput.isControlInputValid("1"));
        assertTrue(gameInput.isControlInputValid("2"));
    }

}
