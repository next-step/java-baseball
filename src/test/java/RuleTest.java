import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isValid_NullAndEmptyInput(int[] numList) {
        assertFalse(Rule.isValid(numList));
    }

    @Test
    void isValidWithInvalidLengthInput() {
        assertFalse(Rule.isValid(new int[] {1}));
        assertFalse(Rule.isValid(new int[] {1, 2}));
    }

    @Test
    void isValidWithDuplicatedInput() {
        assertFalse(Rule.isValid(new int[] {1, 1, 2}));
        assertFalse(Rule.isValid(new int[] {1, 2, 1}));
        assertFalse(Rule.isValid(new int[] {2, 1, 1}));
        assertFalse(Rule.isValid(new int[] {1, 1, 1}));
    }

    @Test
    void isValidWithValidInput() {
        assertTrue(Rule.isValid(new int[] {4, 7, 8}));
        assertTrue(Rule.isValid(new int[] {9, 7, 2}));
    }

    @Test
    void judge1Strike2Ball() {
        int[] dealerList = new int[] {3, 4, 5};
        int[] playerList = new int[] {3, 5, 4};
        Judge judge = Rule.judge(dealerList, playerList);

        assertEquals(1, judge.strike);
        assertEquals(2, judge.ball);
    }

    @Test
    void judge3Strike() {
        int[] dealerList = new int[] {7, 4, 6};
        int[] playerList = new int[] {7, 4, 6};
        Judge judge = Rule.judge(dealerList, playerList);

        assertEquals(3, judge.strike);
        assertEquals(0, judge.ball);
    }

    @Test
    void judge3Ball() {
        int[] dealerList = new int[] {9, 4, 5};
        int[] playerList = new int[] {4, 5, 9};
        Judge judge = Rule.judge(dealerList, playerList);

        assertEquals(0, judge.strike);
        assertEquals(3, judge.ball);
    }

    @Test
    void judgeNothing() {
        int[] dealerList = new int[] {6, 9, 8};
        int[] playerList = new int[] {3, 5, 4};
        Judge judge = Rule.judge(dealerList, playerList);

        assertEquals(0, judge.strike);
        assertEquals(0, judge.ball);
    }

    @Test
    void doesWin() {
        int[] dealerList = new int[] {3, 6, 9};
        int[] playerList = new int[] {3, 6, 9};

        Judge judge = Rule.judge(dealerList, playerList);
        assertTrue(Rule.doesWin(judge));
    }

    @Test
    void doesLose() {
        int[] dealerList = new int[] {3, 9, 6};
        int[] playerList = new int[] {3, 6, 9};

        Judge judge = Rule.judge(dealerList, playerList);
        assertFalse(Rule.doesWin(judge));
    }
}