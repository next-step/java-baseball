package com.pavlo.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame game = new BaseballGame();

    @Test
    @DisplayName("자동생성된 난수값 길이 확인")
    void isComputerNumLength_3() {
        for (int i = 0; i < 100; i++) {
            String numString = game.makeComputerNumString();
            assertEquals(3, numString.length());
        }
    }


}