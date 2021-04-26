package domain;

import com.study.domain.BaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jaedoo Lee
 */
class BaseballGameTest {

    private BaseballGame game;

    @BeforeEach
    public void setUp() {
        game = new BaseballGame();
    }

    @Test
    public void 난수_생성_중복_글자_체크() {
        int answer = game.getAnswer();
        int tmp = answer % 10;

        for (int i = 0; i < 2; i++) {
            answer /= 10;
            assertNotEquals(tmp, answer % 10);
            tmp = answer % 10;
        }
    }

}
