package com.syl.game.baseball.application;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;

public class BaseballGameService {


    public BaseBallNumbers getThreeNumbers(BaseBallMachine machine) {
        BaseBallNumbers machineAnswers = machine.selectThreeNumbers();
        return machineAnswers;
    }

    public BaseBallNumbers inputThreeNumbers(BaseBallPerson person) {
        return person.inputThreeNumbers();
    }

    public BaseBallJudgementStatus judgement(BaseBallMachine machine, BaseBallNumbers machineAnswers, BaseBallNumbers inputNumbers) {
        BaseBallJudgementStatus judgement = machine.judgeStrike(machineAnswers ,inputNumbers);
        return judgement;
    }
}
