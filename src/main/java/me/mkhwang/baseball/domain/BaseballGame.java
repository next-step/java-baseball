package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.type.GameType;

import java.util.Scanner;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BaseballGame {

    private User user;
    private Computer computer;
    private GameType status;

    public BaseballGame() {
        this.user = new User();
        this.computer = new Computer();
        this.status = GameType.GAME_START;
    }

    public void round(){
        user.insertBallNumberForUser();
        BallCounter counter = new BallCounter(user.getBallNumber(), computer.getBallNumber());
        counter.printMessage();
        restartGame(counter);
    }

    public void restartGame(BallCounter counter) {
        if(!counter.isFinish()) return;
        getUserRestartFlag();
    }

    private void getUserRestartFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        Integer restartFlag = scanner.nextInt();
        if(restartFlag == GameType.GAME_START.getType()){
            this.computer = new Computer();
            return;
        }

        endGame();
    }

    public void endGame() {
        this.status = GameType.GAME_END;
    }

    public GameType getStatus() {
        return status;
    }
}
