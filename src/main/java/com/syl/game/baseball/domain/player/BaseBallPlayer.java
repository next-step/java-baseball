package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.util.BaseBallGameManager;

import java.util.Scanner;

public abstract class BaseBallPlayer {

    /**
     * 임의의 수 3개 선택
     * @return
     */
    public BaseBallNumbers selectThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers();
        baseBallNumbers.setFirst(scanner.nextInt());
        baseBallNumbers.setSecond(scanner.nextInt());
        baseBallNumbers.setThird(scanner.nextInt());
        return baseBallNumbers;
    }

    /**
     * 임의의 수 3개 입력
     * @return
     */
    public BaseBallNumbers inputThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers();
        baseBallNumbers.setFirst(scanner.nextInt());
        baseBallNumbers.setSecond(scanner.nextInt());
        baseBallNumbers.setThird(scanner.nextInt());
        return baseBallNumbers;
    }

    /**
     * 스트라이크 / 볼 / 포볼 판정
     * @param selectedNumbers
     * @param inputNumbers
     * @return
     */
    public BaseBallJudgementStatus speakJudgement(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(selectedNumbers, inputNumbers);
        return baseBallJudgementStatus;
    }
}
