package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.util.BaseBallGameManager;

import java.util.Scanner;

public abstract class BaseBallPlayer {

    // Select 3 numbers
    public BaseBallNumbers selectThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers();
        baseBallNumbers.setFirst(scanner.nextInt());
        baseBallNumbers.setSecond(scanner.nextInt());
        baseBallNumbers.setThird(scanner.nextInt());
        return baseBallNumbers;
    }

    // Input numbers
    public BaseBallNumbers inputThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers();
        baseBallNumbers.setFirst(scanner.nextInt());
        baseBallNumbers.setSecond(scanner.nextInt());
        baseBallNumbers.setThird(scanner.nextInt());
        return baseBallNumbers;
    }

    // return Strike / ball / nothing
    public BaseBallJudgementStatus speakJudgement(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        BaseBallJudgementStatus baseBallJudgementStatus = BaseBallGameManager.getInstance().judgeStrikeOrBallOrNothing(selectedNumbers, inputNumbers);
        return baseBallJudgementStatus;
    }
}
