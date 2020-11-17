package baseball;

import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.ArrayList;

/**
 * Java Baseball Game
 * MainApplication
 * 2020.11.15.
 * parksangdonews
 */
public class MainApplication {

    public static void main(String[] args) {

        do {
            baseBallGame();
        } while (InputView.restart());

    }

    private static void baseBallGame() {
        // dealer
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(new ArrayList<String>()));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);

        do {
            baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber())));
            ResultView.printBallCount(baseBallGame.getBallCount());
        } while (!baseBallGame.isFinish());
    }

}
