package com.syl.game.baseball.domain.util;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

public class BaseBallGameManager {

    /**
     * 스트라이크, 볼, 포볼을 판단한다.
     * @param selectedNumbers
     * @param inputNumbers
     * @return 판정 상태값
     */
    public BaseBallJudgementStatus judgeStrikeOrBallOrNothing(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        int strike = selectedNumbers.countStrike(inputNumbers);
        int ball = selectedNumbers.countBall(inputNumbers);
        int nothing = selectedNumbers.countNothing(inputNumbers);
        return new BaseBallJudgementStatus(strike, ball, nothing);
    }

    /**
     * 3 스트라이크 확인.
     * @param strikeCnt
     * @return
     */
    public boolean isThreeStrike(int strikeCnt) {
        return strikeCnt == 3;
    }

}
