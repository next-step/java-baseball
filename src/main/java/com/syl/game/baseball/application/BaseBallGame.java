package com.syl.game.baseball.application;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;
import com.syl.game.baseball.domain.util.BaseBallGameManager;

import java.util.Scanner;

public class BaseBallGame {

    private BaseBallGameManager manager;
    private BaseBallMachine machine;
    private BaseBallPerson person;

    public BaseBallGame(BaseBallGameManager manager, BaseBallMachine machine, BaseBallPerson person) {
        this.manager = manager;
        this.machine = machine;
        this.person = person;
    }

    /**
     * 게임 진행
     * @return
     */
    public void play() {
        boolean isThreeStrike = false;
        BaseBallNumbers machineAnswers = machine.selectThreeNumbers();
        System.out.println(machineAnswers.toString());

        while (isThreeStrike == false) {
            BaseBallNumbers inputNumbers = person.inputThreeNumbers();
            System.out.println(inputNumbers.toString());

            BaseBallJudgementStatus judgement = machine.speakJudgement(machineAnswers ,inputNumbers);
            System.out.println("스트라이크   " + judgement.getStrike());
            System.out.println("볼   " + judgement.getBall());
            System.out.println("낫싱  " + judgement.getNothing());
            System.out.println("판정  " + judgement.toString());

            isThreeStrike = manager.isThreeStrike(judgement.getStrike());
            System.out.println(isThreeStrike);
        }
    }


    /**
     * 재시작, 종료 상태값 반환.
     * @return
     */
    public boolean replay() {
        System.out.println("재시작 여부 : 1 or 2");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() == 1;
    }




}
