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

}