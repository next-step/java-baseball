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
}