package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

public class BaseBallPerson extends BaseBallPlayer {

    @Override
    public BaseBallNumbers selectThreeNumbers() {
        return super.selectThreeNumbers();
    }

    @Override
    public BaseBallNumbers inputThreeNumbers() {
        return super.inputThreeNumbers();
    }

    @Override
    public BaseBallJudgementStatus speakJudgement(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        return super.speakJudgement(selectedNumbers, inputNumbers);
    }
}
