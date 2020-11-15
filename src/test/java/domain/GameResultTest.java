package domain;

import org.junit.jupiter.api.*;

import static domain.BaseballCodeDefinition.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("게임결과 테스트")
class GameResultTest {

    @Test
    @Order(1)
    @DisplayName("1스트라이크")
    public void strike() {
        GameResult result = new GameResult(1, 0);
        assertEquals(String.format(STRIKE, 1), result.toString());
    }

    @Test
    @Order(2)
    @DisplayName("1볼")
    public void ball() {
        GameResult result = new GameResult(0, 1);
        assertEquals(String.format(BALL, 1), result.toString());
    }

    @Test
    @Order(3)
    @DisplayName("1스트라이크 1볼")
    public void strikeAndBall() {
        GameResult result = new GameResult(1, 1);
        assertEquals(String.format(STRIKE_AND_BALL, 1, 1), result.toString());
    }

    @Test
    @Order(4)
    @DisplayName("낫싱")
    public void nothing() {
        GameResult result = new GameResult(0, 0);
        assertEquals(NOTHING, result.toString());
    }
}