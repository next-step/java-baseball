package baseball;

import baseball.baseballgamemachine.BaseballGameMachine;
import baseball.opponent.Opponent;

/**
 * 애플리케이션 엔드포인트
 *
 * @author 김민
 */
public class Application {

    public static void main(String[] args) {
        BaseballGameMachine gameMachine = new BaseballGameMachine(new Opponent());

        while (true)
            gameMachine.startGame();
    }
}