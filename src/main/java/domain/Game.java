package domain;

import exception.BallException;

public class Game {

    private boolean gameStatus = true;

    public void start() {
        while(gameStatus){
            Catcher catcher = new Catcher();
            startGame(catcher);
        }
    }

    private void startGame(Catcher catcher){
        Boolean isCorrect = false;
        Player player = new Player();

        while (!isCorrect) {
            player.inputBall();
            isCorrect = Judgment.judge(catcher.ball, player.ball);
        }

        gameStatus = finishGame(player.getFinishNumber());
    }

    private boolean finishGame(String restartNum){
        if("2".equals(restartNum)){
            return false;
        }
        if("1".equals(restartNum)){
            return true;
        }
        throw new BallException("1 또는 2를 입력해주세요.");
    }
}