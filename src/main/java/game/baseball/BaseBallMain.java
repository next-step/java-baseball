package game.baseball;

import game.baseball.command.BaseBallGameCommand;
import game.baseball.domain.BaseBallGame;

import static game.baseball.view.InputView.command;
import static game.baseball.view.InputView.numbers;
import static game.baseball.view.ResultView.printGameEnded;
import static game.baseball.view.ResultView.printHint;

public class BaseBallMain {
    public static void main(String[] args) {

        BaseBallGame baseBallGame = new BaseBallGame.Builder()
            .peekHint(printHint())
            .gameEnded(printGameEnded())
            .build();

        while (!baseBallGame.isOver()) {
            baseBallGame.start(numbers());
            BaseBallGameCommand.valueOf(command()).run(baseBallGame);
        }

    }
}
