package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    @BeforeEach
    void beforeEach() {
        computerNumbers = new ArrayList<>();
        userNumbers = new ArrayList<>();
    }

    @Test
    @DisplayName("모두 맞추지 못한 경우")
    void checkNothing() {
        int strike = 0;
        int ball = 0;

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        userNumbers.add(4);
        userNumbers.add(5);
        userNumbers.add(6);

        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            }

            if (computerNumbers.contains(userNumber)) {
                ball++;
            }
        }

        assertEquals(0, strike);
        assertEquals(0, ball);
    }

    @Test
    @DisplayName("모두 스트라이크인 경우")
    void checkStrikeCount() {
        int strike = 0;

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);

        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            }
        }

        assertEquals(3, strike);
    }

    @Test
    @DisplayName("1스트라이크 2볼인 경우")
    void checkStrikeAndBall() {
        int strike = 0;
        int ball = 0;

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        userNumbers.add(1);
        userNumbers.add(3);
        userNumbers.add(2);

        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            }

            if (computerNumbers.contains(userNumber)) {
                ball++;
            }
        }

        assertEquals(1, strike);
        assertEquals(2, ball - strike);
    }
}