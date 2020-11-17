package com.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @DisplayName("세자리 숫자 랜덤 생성")
    @RepeatedTest(value = 10)
    void randomNumberTest() {
        Game game = new Game();
        Integer randomNumber = game.getRandomNumber();

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

    @DisplayName("세자리 숫자 확인")
    @Test
    void isThreeNumberTest() {
        Game game = new Game();

        game.inputNumber(1234);
        assertFalse(game.isThreeNumber());
        game.inputNumber(12);
        assertFalse(game.isThreeNumber());
        game.inputNumber(123);
        assertTrue(game.isThreeNumber());
    }

    @DisplayName("각자리 숫자가 다른지 확인")
    @Test
    void isDifferentNumberTest() {
        Game game = new Game();

        game.inputNumber(111);
        assertFalse(game.isDifferentNumber());
        game.inputNumber(112);
        assertFalse(game.isDifferentNumber());
        game.inputNumber(212);
        assertFalse(game.isDifferentNumber());
        game.inputNumber(123);
        assertTrue(game.isThreeNumber());
    }

    @DisplayName("스트라이크 갯수 세기")
    @Test
    void countStrikeTest() {
        Game game = new Game(1, 2, 3);  // 123

        game.inputNumber(145);
        assertEquals(1, game.getStrike());
        game.inputNumber(724);
        assertEquals(1, game.getStrike());
        game.inputNumber(753);
        assertEquals(1, game.getStrike());
        game.inputNumber(125);
        assertEquals(2, game.getStrike());
        game.inputNumber(523);
        assertEquals(2, game.getStrike());
        game.inputNumber(163);
        assertEquals(2, game.getStrike());
        game.inputNumber(123);
        assertEquals(3, game.getStrike());
    }

    @DisplayName("볼 갯수 세기")
    @Test
    void countBallTest() {
        Game game = new Game(1, 2, 3);  // 123

        game.inputNumber(415);
        assertEquals(1, game.getBall());
        game.inputNumber(264);
        assertEquals(1, game.getBall());
        game.inputNumber(735);
        assertEquals(1, game.getBall());
        game.inputNumber(315);
        assertEquals(2, game.getBall());
        game.inputNumber(251);
        assertEquals(2, game.getBall());
        game.inputNumber(431);
        assertEquals(2, game.getBall());
        game.inputNumber(231);
        assertEquals(3, game.getBall());
        game.inputNumber(312);
        assertEquals(3, game.getBall());
    }
}