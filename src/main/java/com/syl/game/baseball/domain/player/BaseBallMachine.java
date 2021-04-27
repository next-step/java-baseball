package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

import java.util.Random;

public class BaseBallMachine extends BaseBallPlayer implements BaseBallAi {

    /**
     * 임의의 수 3개 선택
     * @return
     */
    @Override
    public BaseBallNumbers selectThreeNumbers() {
        BaseBallNumbers baseBallNumbers = GenerateRandomNumbers();
        return baseBallNumbers;
    }

    /**
     * 임의의 수 3개 입력
     * @return
     */
    @Override
    public BaseBallNumbers inputThreeNumbers() {
        return super.inputThreeNumbers();
    }

    /**
     * 스트라이크 / 볼 / 포볼 판정
     * @param selectedNumbers
     * @param inputNumbers
     * @return
     */
    @Override
    public BaseBallJudgementStatus judgeStrike(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        return super.judgeStrike(selectedNumbers, inputNumbers);
    }

    /**
     * 임의의 수 3개 생성
     * @return
     */
    @Override
    public BaseBallNumbers GenerateRandomNumbers() {
        Random random = new Random();
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers();
        baseBallNumbers.setFirst(random.nextInt(9) + 1);
        while ( baseBallNumbers.setSecond(random.nextInt(9) + 1) );
        while ( baseBallNumbers.setThird(random.nextInt(9) + 1) );
        return baseBallNumbers;
    }
}
