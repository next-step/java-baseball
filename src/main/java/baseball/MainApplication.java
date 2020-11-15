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
        // dealer
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(new ArrayList<Integer>()));
        BaseBallGame baseBallGame = new BaseBallGame(dealersNumber);
        baseBallGame.play(new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber())));
        ResultView.printBallCount(baseBallGame.getBallCount());

    }

}
