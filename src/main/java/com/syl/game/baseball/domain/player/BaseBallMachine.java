package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

import java.util.Random;

public class BaseBallMachine extends BaseBallPlayer implements BaseBallAi {

    @Override
    public BaseBallNumbers selectThreeNumbers() {
        BaseBallNumbers baseBallNumbers = GenerateRandomNumbers();
        return baseBallNumbers;
    }

    @Override
    public BaseBallNumbers inputThreeNumbers() {
        return super.inputThreeNumbers();
    }

    @Override
    public BaseBallJudgementStatus speakJudgement(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        return super.speakJudgement(selectedNumbers, inputNumbers);
    }


    @Override
    public BaseBallNumbers GenerateRandomNumbers() {
        Random random = new Random();
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(random.nextInt(9) + 1, random.nextInt(9) + 1, random.nextInt(9) + 1);
        return baseBallNumbers;
    }
}
