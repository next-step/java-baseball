package com.syl.game.baseball.ui;

import com.syl.game.baseball.application.BaseballGameService;
import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;

import java.util.Scanner;

public class BaseBallGame {

    BaseBallMachine machine = new BaseBallMachine();
    BaseBallPerson person = new BaseBallPerson();
    BaseballGameService gameService = new BaseballGameService();

    /**
     * 게임 진행
     * @return
     */
    public void play() {
        BaseBallJudgementStatus judgement;
        BaseBallNumbers machineAnswers = gameService.getThreeNumbers(machine);
//        System.out.println(machineAnswers.toString());

        do {
            BaseBallNumbers inputNumbers = gameService.inputThreeNumbers(person);
            judgement = gameService.judgement(machine, machineAnswers, inputNumbers);
            System.out.println(judgement.toString());
        } while (!judgement.isThreeStrike());
    }

    /**
     * 재시작, 종료 상태값 알림, 입력 및 반환
     * @return
     */
    public boolean replay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() == 1;
    }

}
