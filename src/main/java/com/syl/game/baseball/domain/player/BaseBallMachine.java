package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallNumbers;

import java.util.Random;

public class BaseBallMachine extends BaseBallPlayer implements BaseBallAi {

    @Override
    public BaseBallNumbers GenerateRandomNumbers() {
        Random random = new Random();
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(random.nextInt(9) + 1, random.nextInt(9) + 1, random.nextInt(9) + 1);
        return baseBallNumbers;
    }
}
