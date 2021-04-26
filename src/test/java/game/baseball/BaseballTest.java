package game.baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {
    static Baseball baseball;

    @BeforeAll
    public static void initial() {
        baseball = new Baseball();
    }

    @DisplayName("컴퓨터 숫자가 3자리 인지 확인")
    @Test
    public void valid_computer_numbers_length() {
        assertEquals(baseball.computerNumbers.length, BaseballConstants.BASEBALL_COUNT);
    }

    @DisplayName("컴퓨터 숫자가 서로 다른 수 인지 확인")
    @Test
    public void valid_computer_numbers_unique() {
        boolean isUnique = true;
        for (int i = 0; i < baseball.computerNumbers.length - 1; i++) {
            if (baseball.computerNumbers[i] == baseball.computerNumbers[i + 1]) {
                isUnique = false;
                break;
            }
        }
        assertTrue(isUnique);
    }

    @DisplayName("각 자리 수가 한자리 숫자인지 확인")
    @Test
    public void valid_player_numbers_under_10() {
        boolean isUnder10 = true;
        baseball.makePlayerNumbers(456);
        for (int i = 0; i < baseball.playerNumbers.length; i++) {
            if (baseball.playerNumbers[i] >= 10) {
                isUnder10 = false;
            }
        }
        assertTrue(isUnder10);
    }

    @DisplayName("strike & ball 판단")
    @Test
    public void check_strike_and_ball_count() {
        for (int i = 0; i < baseball.computerNumbers.length; i++) {
            baseball.playerNumbers[i] = baseball.computerNumbers[i];
        }

        baseball.checkStrikeAndBallCount();

        assertEquals(baseball.strikeCount, BaseballConstants.BASEBALL_COUNT);
        assertEquals(baseball.ballCount, 0);

        for (int i = 0; i < baseball.computerNumbers.length; i++) {
            if (i == 0) {
                baseball.playerNumbers[i] = baseball.computerNumbers[baseball.computerNumbers.length - 1];
            } else {
                baseball.playerNumbers[i] = baseball.computerNumbers[i - 1];
            }
        }

        baseball.checkStrikeAndBallCount();

        assertEquals(baseball.ballCount, BaseballConstants.BASEBALL_COUNT);
        assertEquals(baseball.strikeCount, 0);
    }
}
