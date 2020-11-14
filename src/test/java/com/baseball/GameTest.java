package com.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @DisplayName("세자리 숫자 랜덤 생성")
    @RepeatedTest(value = 10)
    void randomNumber() {
        Game game = new Game();
        Integer randomNumber = game.randomNumber();

        Integer n1 = randomNumber / 100;
        Integer n2 = randomNumber - (n1 * 100) / 10;
        Integer n3 = randomNumber % 10;

        // 1부터 9사이의 세자리 숫자로 생성되었는지 테스트

        assertTrue(randomNumber >= 111 && randomNumber <=  999);

        // 각 자리의 숫자가 서로 다른지 테스트

        assertTrue(n1 != n2);
        assertTrue(n2 != n3);
        assertTrue(n3 != n1);
    }

    @DisplayName("스트라이크 갯수 세기")
    @Test
    void countStrike() {
        Game game = new Game(1, 2, 3);  // 123

        assertEquals(1, game.countStrike(145));
        assertEquals(1, game.countStrike(724));
        assertEquals(1, game.countStrike(753));
        assertEquals(2, game.countStrike(125));
        assertEquals(2, game.countStrike(523));
        assertEquals(2, game.countStrike(163));
        assertEquals(3, game.countStrike(123));
    }
}