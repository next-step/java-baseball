package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.util.BaseBallGameManager;

import java.util.Scanner;

public abstract class BaseBallPlayer {

    private Scanner scanner;
    private BaseBallNumbers baseBallNumbers;
    private BaseBallGameManager manager;

    /**
     * 임의의 수 3개 선택
     * @return
     */
    public BaseBallNumbers selectThreeNumbers() {
        return setNumbers();

    }

    /**
     * 임의의 수 3개 입력
     * @return
     */
    public BaseBallNumbers inputThreeNumbers() {
        return setNumbers();
    }

    /**
     * 스트라이크 / 볼 / 포볼 판정
     * @param answerNumbers
     * @param inputNumbers
     * @return
     */
    public BaseBallJudgementStatus judgeStrike(BaseBallNumbers answerNumbers, BaseBallNumbers inputNumbers) {
        manager = new BaseBallGameManager();
        return manager.judgeStrikeOrBallOrNothing(answerNumbers, inputNumbers);
    }

    /**
     * 숫자 세팅
     */
    private BaseBallNumbers setNumbers() {
        scanner = new Scanner(System.in);
        do {
            int numbers = scanner.nextInt();
            baseBallNumbers = new BaseBallNumbers(numbers);
        } while (!baseBallNumbers.isValidStatus());
        return baseBallNumbers;
    }
}
