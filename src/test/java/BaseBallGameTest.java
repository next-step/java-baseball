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

    @Test
    void isStrikeTest() {
        assertEquals(1, game.isStrike(0, 3, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(1, 3, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(2, 3, new int[] {3,6,8}));

        assertEquals(0, game.isStrike(0, 6, new int[] {3,6,8}));
        assertEquals(1, game.isStrike(1, 6, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(2, 8, new int[] {3,6,8}));

        assertEquals(0, game.isStrike(0, 8, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(1, 8, new int[] {3,6,8}));
        assertEquals(1, game.isStrike(2, 8, new int[] {3,6,8}));

        assertEquals(0, game.isStrike(0, 5, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(1, 5, new int[] {3,6,8}));
        assertEquals(0, game.isStrike(2, 5, new int[] {3,6,8}));
    }

    @Test
    void isBallTest() {
        assertEquals(0, game.isBall(0, 3, new int[] {3,6,8}));
        assertEquals(1, game.isBall(1, 3, new int[] {3,6,8}));
        assertEquals(1, game.isBall(2, 3, new int[] {3,6,8}));

        assertEquals(1, game.isBall(0, 6, new int[] {3,6,8}));
        assertEquals(0, game.isBall(1, 6, new int[] {3,6,8}));
        assertEquals(1, game.isBall(2, 8, new int[] {3,6,8}));

        assertEquals(1, game.isBall(0, 8, new int[] {3,6,8}));
        assertEquals(1, game.isBall(1, 8, new int[] {3,6,8}));
        assertEquals(0, game.isBall(2, 8, new int[] {3,6,8}));

        assertEquals(0, game.isBall(0, 5, new int[] {3,6,8}));
        assertEquals(0, game.isBall(1, 5, new int[] {3,6,8}));
        assertEquals(0, game.isBall(2, 5, new int[] {3,6,8}));
    }

    @Test
    void isNothingTest() {
        assertEquals(0, game.isNothing(3, new int[] {3,6,8}));
        assertEquals(0, game.isNothing(6, new int[] {3,6,8}));
        assertEquals(0, game.isNothing(8, new int[] {3,6,8}));

        assertEquals(1, game.isNothing(1, new int[] {3,6,8}));
        assertEquals(1, game.isNothing(4, new int[] {3,6,8}));
        assertEquals(1, game.isNothing(7, new int[] {3,6,8}));
    }

    @Test
    void executionTest() {
        assertEquals(3, game.execution(new int[] {1,2,3}, new int[] {2,3,4}));
        assertEquals(3, game.execution(new int[] {3,6,8}, new int[] {8,6,3}));
        assertEquals(3, game.execution(new int[] {3,6,8}, new int[] {6,3,1}));
        assertEquals(3, game.execution(new int[] {1,2,3}, new int[] {4,5,6}));
        assertEquals(2, game.execution(new int[] {1,2,3}, new int[] {1,2,3}));
        assertEquals(2, game.execution(new int[] {3,6,8}, new int[] {3,6,8}));
    }
}