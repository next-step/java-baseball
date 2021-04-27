package com.baseball.domain.computer;

import com.baseball.domain.baseballnumber.BaseballNumber;
import com.baseball.domain.baseballnumber.BaseballNumberGenerator;
import com.baseball.domain.baseballnumber.BaseballNumberRandomGenerator;
import com.baseball.domain.judgement.Judgement;

public class Computer {

    private final BaseballNumber baseballNumber;

    public Computer(BaseballNumberGenerator baseballNumberGenerator) {
        baseballNumber = baseballNumberGenerator.generate();
    }

    public Judgement judge(BaseballNumber baseballNumberOfPlayer) {
        int equalCount = 0;
        int containCount = 0;

        for (int i = 0; i < baseballNumber.SIZE; i++) {
            equalCount += addEqualCount(baseballNumberOfPlayer.getBaseballNumberByIndex(i), i);
            containCount += addContainCount(baseballNumberOfPlayer.getBaseballNumberByIndex(i));
        }

        return makeJudgement(equalCount, containCount);
    }

    private int addEqualCount(int playerNumber, int i) {
        return baseballNumber.isSameNumberByIndex(playerNumber, i) ? 1 : 0;
    }

    private int addContainCount(int playerNumber) {
        return baseballNumber.contains(playerNumber) ? 1 : 0;
    }

    private Judgement makeJudgement(int equalCount, int containCount) {
        int strike = equalCount;
        int ball = containCount - equalCount;
        if (ball < 0) {
            ball = 0;
        }
        return new Judgement(strike, ball);
    }

}
