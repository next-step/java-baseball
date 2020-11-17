package me.lozm.baseball.service;

import me.lozm.baseball.entity.BaseballComputer;
import me.lozm.baseball.entity.BaseballResult;

import static me.lozm.baseball.common.CommonUtils.*;

public class BaseballGameService {

    private BaseballComputer computer;


    public BaseballGameService() {
        this.computer = new BaseballComputer();
    }

    public void run() {
        do {
            computer.createAnswer();
            System.out.println("Computer answer: " + computer.getAnswer());

            compareUserAnswerWithComputerAnswer();
        } while (restartAgain());
    }

    private void compareUserAnswerWithComputerAnswer() {
        BaseballResult result;
        do {
            result = new BaseballResult();
            String userAnswer = input(INPUT_MESSAGE_ANSWER, REG_EXP_ANSWER);
            result.checkAnswer(userAnswer, computer.getAnswer());
        } while (!result.isCorrect());
    }

    private boolean restartAgain() {
        String userAnswer = input(INPUT_MESSAGE_RESTART, REG_EXP_RESTART);
        return RESTART_YES.equals(userAnswer);
    }

}