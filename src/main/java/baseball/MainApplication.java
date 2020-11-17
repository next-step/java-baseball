package baseball;

import java.util.ArrayList;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbersPlayerInputStrategy;
import baseball.domain.BallNumbersRandomStrategy;
import baseball.exception.DifferentThreeNumberRequiredException;
import baseball.exception.NumberOnlyException;
import baseball.view.InputView;
import baseball.view.ResultView;


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
        // to Test
        // System.out.println(dealersNumber);
        try {
            playerBidding(baseBallGame);
        } catch (NumberOnlyException numberOnlyException) {
            System.out.println(numberOnlyException.getMessage());
        } catch (DifferentThreeNumberRequiredException differentThreeNumberRequiredException) {
            System.out.println(differentThreeNumberRequiredException.getMessage());
        }
    }

    private static void playerBidding(BaseBallGame baseBallGame) throws NumberOnlyException, DifferentThreeNumberRequiredException {
        do {
            // player
            BallNumber plyaerBallNumber = new BallNumber(new BallNumbersPlayerInputStrategy(InputView.setBallNumber()));
            baseBallGame.play(plyaerBallNumber);
            ResultView.printBallCount(baseBallGame.getBallCount());
        } while (!baseBallGame.isFinish());
    }

}
