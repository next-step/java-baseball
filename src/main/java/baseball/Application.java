package baseball;

import baseball.baseballgamemachine.BaseballGameMachine;
import baseball.opponent.Opponent;

public class Application {

    public static void main(String[] args) {
        BaseballGameMachine gameMachine = new BaseballGameMachine(new Opponent());

        while (true)
            gameMachine.startGame();
    }
}