package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

import java.util.Scanner;

public abstract class BaseBallPlayer {

    private Scanner scanner;
    private BaseBallNumbers baseBallNumbers;

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
    public BaseBallJudgementStatus judgeStrikeOrBallOrNothing(BaseBallNumbers answerNumbers, BaseBallNumbers inputNumbers) {
        int strike = answerNumbers.countStrike(inputNumbers);
        int ball = answerNumbers.countBall(inputNumbers);
        int nothing = answerNumbers.countNothing(inputNumbers);
        return new BaseBallJudgementStatus(strike, ball, nothing);
    }

    /**
     * 숫자 세팅
     */
    private BaseBallNumbers setNumbers() {
        scanner = new Scanner(System.in);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            int numbers = scanner.nextInt();
            baseBallNumbers = new BaseBallNumbers(numbers);
        } while (!baseBallNumbers.isValidStatus());
        return baseBallNumbers;
    }
}
