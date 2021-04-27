package com.baseball.domain.player;

import com.baseball.domain.baseballnumber.BaseBallNumberInputGenerator;
import com.baseball.domain.baseballnumber.BaseballNumber;
import com.baseball.domain.baseballnumber.BaseballNumberGenerator;
import com.baseball.domain.computer.Computer;
import com.baseball.domain.judgement.Judgement;

import java.util.ArrayList;

public class Player {

    private final BaseballNumber baseballNumber;

    public Player(BaseballNumberGenerator baseballNumberGenerator) {
        baseballNumber = baseballNumberGenerator.generate();
    }

    public Judgement pitch(Computer computer) {
        return computer.judge(baseballNumber);
    }
}
