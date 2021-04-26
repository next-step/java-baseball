package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallMachineTest {

    private BaseBallNumbers machineNumbers;
    private BaseBallNumbers threeStrikeNumbers;

    @BeforeEach
    public void setUp() {
        machineNumbers = new BaseBallNumbers();
        machineNumbers.setFirst(1);
        machineNumbers.setSecond(2);
        machineNumbers.setThird(3);

        threeStrikeNumbers = new BaseBallNumbers();
        threeStrikeNumbers.setFirst(1);
        threeStrikeNumbers.setSecond(2);
        threeStrikeNumbers.setThird(3);
    }
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

    @Test
    void selectThreeNumbersTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallNumbers baseBallNumbers = baseBallMachine.selectThreeNumbers();
        int first = baseBallNumbers.getFirst();
        int second = baseBallNumbers.getSecond();
        int third = baseBallNumbers.getThird();
        assertTrue(1 <= first && first <= 9);
        assertTrue(1 <= second && second <= 9);
        assertTrue(1 <= third && third <= 9);
    }

    @Test
    public void speakJudgementTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.speakJudgement(machineNumbers, threeStrikeNumbers);
        assertSame(3, baseBallJudgementStatus.getStrike());
    }
}