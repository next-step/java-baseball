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
}