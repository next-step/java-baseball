package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallMachineTest {

    @Test
    public void generateRandomNumbersTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallNumbers baseBallNumbers = baseBallMachine.GenerateRandomNumbers();
        int first = baseBallNumbers.getFirst();
        int second = baseBallNumbers.getSecond();
        int third = baseBallNumbers.getThird();
        assertTrue(1 <= first && first <= 9);
        assertTrue(1 <= second && second <= 9);
        assertTrue(1 <= third && third <= 9);
    }
}