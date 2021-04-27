package baseball.service;

import baseball.domain.*;

import java.util.Scanner;

public class GameService {

    public void start() {
        Boolean runFlag = true;

        while (runFlag) {
            ComNumber comNum = new ComNumber();
            newGame(comNum);

            runFlag = finishGame();
        }
    }


    public void newGame(ComNumber comNum) {
        boolean continueFlag = true;
        while (continueFlag) {
            //사용자 입력
            UserNumber userNumber = new UserNumber();
            userNumber.UserNumber();

            JudgeGame judgeGame = new JudgeGame();
            judgeGame.compareNum(comNum.ball, userNumber.ball);

            continueFlag = judgeGame.chkFinishGame();
        }
    }


    public boolean finishGame() {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();

        boolean rtnFlag = JudgeGame.chkInputNum(inputNum);

        return rtnFlag;
    }
}
