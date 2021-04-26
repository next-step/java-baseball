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
}
