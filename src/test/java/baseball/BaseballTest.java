package baseball;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballTest {
    private int[] computerNumber = {7, 1, 3};

    @Test
    void input123() {
        Baseball baseball = new Baseball();
        assertEquals(baseball.getCount(computerNumber, "123"), new Point(1, 1));
    }

    @Test
    void input145() {
        Baseball baseball = new Baseball();
        assertEquals(baseball.getCount(computerNumber, "145"), new Point(0, 1));
    }

    @Test
    void input671() {
        Baseball baseball = new Baseball();
        assertEquals(baseball.getCount(computerNumber, "671"), new Point(0, 2));
    }

    @Test
    void input216() {
        Baseball baseball = new Baseball();
        assertEquals(baseball.getCount(computerNumber, "216"), new Point(1, 0));
    }

    @Test
    void input713() {
        Baseball baseball = new Baseball();
        assertEquals(baseball.getCount(computerNumber, "713"), new Point(3, 0));
    }
}