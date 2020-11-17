package me.rn00n.baseball.pitcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PitcherTest {

    @Test
    @DisplayName("투수 생성 - 생성자 자릿수 없음")
    void createPitcher_NoArgsConstructor() {
        Pitcher pitcher = new Pitcher();

        assertNotNull(pitcher);
        assertEquals(pitcher.NUMBER_LENGTH, 3);
    }

    @Test
    @DisplayName("투수 생성 - 생성자 자릿수 있음")
    void createPitcher_ArgsConstructor() {
        int number = 5;
        Pitcher pitcher = new Pitcher(number);

        assertNotNull(pitcher);
        assertEquals(pitcher.NUMBER_LENGTH, number);
    }

    @Test
    @DisplayName("플레이어 숫자 설정")
    void setPitcherNumber() {
        Pitcher pitcher = new Pitcher();
        int number = 432;

        assertNotEquals(pitcher.getNumber(), number);

        pitcher.setNumber(number);
        assertEquals(pitcher.getNumber(), number);
    }

    @Test
    @DisplayName("예측 결과 확인 : 스트라이크")
    void resultPredict_Strike() {

        Pitcher pitcher = new Pitcher();
        pitcher.setNumber(123);

        int number1 = 145;
        int number2 = 125;
        int number3 = 123;
        int number4 = 924;
        int number5 = 923;
        int number6 = 983;
        int number7 = 456;

        assertEquals(pitcher.getStrike(number1), 1);
        assertEquals(pitcher.getStrike(number2), 2);
        assertEquals(pitcher.getStrike(number3), 3);
        assertEquals(pitcher.getStrike(number4), 1);
        assertEquals(pitcher.getStrike(number5), 2);
        assertEquals(pitcher.getStrike(number6), 1);
        assertEquals(pitcher.getStrike(number7), 0);
    }

    @Test
    @DisplayName("예측 결과 확인 : 볼")
    void resultPredict_Ball() {

        Pitcher pitcher = new Pitcher();
        pitcher.setNumber(123);

        int number1 = 918;
        int number2 = 912;
        int number3 = 312;
        int number4 = 123;
        int number5 = 456;
        int number6 = 321;

        assertEquals(pitcher.getBall(number1), 1);
        assertEquals(pitcher.getBall(number2), 2);
        assertEquals(pitcher.getBall(number3), 3);
        assertEquals(pitcher.getBall(number4), 0);
        assertEquals(pitcher.getBall(number5), 0);
        assertEquals(pitcher.getBall(number6), 2);
    }

    @Test
    @DisplayName("예측 결과 확인 : 낫싱")
    void resultPredict_Nothing() {

        Pitcher pitcher = new Pitcher();
        pitcher.setNumber(123);

        int number1 = 123;
        int number2 = 456;
        int number3 = 231;

        assertEquals(pitcher.isNothing(number1), false);
        assertEquals(pitcher.isNothing(number2), true);
        assertEquals(pitcher.isNothing(number3), false);
    }

}