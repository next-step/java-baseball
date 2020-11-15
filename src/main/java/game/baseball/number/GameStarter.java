package game.baseball.number;

import static game.baseball.number.input.HelperTexts.RESTART_OR_EXIT;
import static game.baseball.number.input.InputManager.input;
import static game.baseball.number.status.GameProgressStatus.checkProgressStatus;

import game.baseball.number.factory.GameFactory;

public class GameStarter {

    public static void main(String[] args) {
        do {
            GameFactory.newNumberBaseballGame().start();
        } while (checkProgressStatus(input(RESTART_OR_EXIT)));
    }
}