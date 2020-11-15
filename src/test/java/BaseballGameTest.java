import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private BaseballGame game;
    private Computer computer;
    private Player player;

    @BeforeEach
    void setUp() {
        game = new BaseballGame();

        computer = new Computer();
        computer.initNumbers();
        computer.setCheckNumbers(new ArrayList<>(Arrays.asList(1,3,5)));

        player = new Player();
    }

    @Test
    @DisplayName("Player 가 입력한 123 숫자의 각 index 위치에 있는 숫자 타입(스트라이크, 볼, 낫싱) 체크")
    void checkBallCount() {
        player.convertNumberToList(123);
        BaseballGame.CountType type = game.calcBallCount(computer, player, 0);
        assertEquals(type, BaseballGame.CountType.STRIKE);

        type = game.calcBallCount(computer, player, 1);
        assertEquals(type, BaseballGame.CountType.NOTHING);

        type = game.calcBallCount(computer, player, 2);
        assertEquals(type, BaseballGame.CountType.BALL);
    }

}