package me.rn00n.baseball;

import me.rn00n.baseball.pitcher.Pitcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    @Test
    @DisplayName("입력 숫자 중복검사")
    void validateInputNumber() {
        Baseball baseball = new Baseball();

        assertEquals(baseball.validateInputNumber(0), true);

        assertEquals(baseball.validateInputNumber(111), true);
        assertEquals(baseball.validateInputNumber(112), true);
        assertEquals(baseball.validateInputNumber(113), true);
        assertEquals(baseball.validateInputNumber(122), true);
        assertEquals(baseball.validateInputNumber(123), false);
        assertEquals(baseball.validateInputNumber(131), true);
        assertEquals(baseball.validateInputNumber(132), false);
        assertEquals(baseball.validateInputNumber(133), true);

        assertEquals(baseball.validateInputNumber(211), true);
        assertEquals(baseball.validateInputNumber(212), true);
        assertEquals(baseball.validateInputNumber(213), false);
        assertEquals(baseball.validateInputNumber(221), true);
        assertEquals(baseball.validateInputNumber(222), true);
        assertEquals(baseball.validateInputNumber(223), true);
        assertEquals(baseball.validateInputNumber(231), false);
        assertEquals(baseball.validateInputNumber(232), true);
        assertEquals(baseball.validateInputNumber(233), true);

        assertEquals(baseball.validateInputNumber(311), true);
        assertEquals(baseball.validateInputNumber(312), false);
        assertEquals(baseball.validateInputNumber(313), true);
        assertEquals(baseball.validateInputNumber(321), false);
        assertEquals(baseball.validateInputNumber(322), true);
        assertEquals(baseball.validateInputNumber(323), true);
        assertEquals(baseball.validateInputNumber(331), true);
        assertEquals(baseball.validateInputNumber(332), true);
        assertEquals(baseball.validateInputNumber(333), true);

    }

    @Test
    @DisplayName("입력 숫자 - 잘못된 길이")
    void validateInputNumber_Wrong_Length() {
        Baseball baseball = new Baseball(4);

        assertEquals(baseball.validateInputNumber(1), true);
        assertEquals(baseball.validateInputNumber(12), true);
        assertEquals(baseball.validateInputNumber(123), true);

        assertEquals(baseball.validateInputNumber(12345), true);
    }


    @Test
    @DisplayName("결과 확인, 힌트 출력")
    void resultTurn() {
        int numberLength = 3;

        Pitcher pitcher = new Pitcher(numberLength);
        pitcher.setNumber(456);

        Baseball baseball = new Baseball(numberLength);
        baseball.setPitcher(pitcher);

        assertEquals(baseball.getResult(123), ResultStatus.NOTHING); // 낫싱
        assertEquals(baseball.getResult(147), ResultStatus.STRIKE_BALL); // 1볼
        assertEquals(baseball.getResult(145), ResultStatus.STRIKE_BALL); // 2볼
        assertEquals(baseball.getResult(645), ResultStatus.STRIKE_BALL); // 3볼
        assertEquals(baseball.getResult(478), ResultStatus.STRIKE_BALL); // 1스트라이크
        assertEquals(baseball.getResult(458), ResultStatus.STRIKE_BALL); // 2스트라이크
        assertEquals(baseball.getResult(456), ResultStatus.WIN); // 승리

    }
}