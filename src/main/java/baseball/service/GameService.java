package baseball.service;

import baseball.domain.*;

public class GameService {

    public void start(){
        Boolean runFlag = true;

        while(runFlag){
            ComNumber comNum = new ComNumber();
            newGame(comNum);

            runFlag = JudgeGame.chkContinueGame();
        }
    }


    public void newGame(ComNumber comNum){
        boolean continueFlag = true;
        while(continueFlag){
            //사용자 입력
            UserNumber userNumber = new UserNumber();
            userNumber.UserNumber();

            JudgeGame judgeGame = new JudgeGame();
            judgeGame.compareNum(comNum.ball, userNumber.ball);
            judgeGame.resultMsg();

            continueFlag = judgeGame.chkFinishGame();
        }
    }


}
