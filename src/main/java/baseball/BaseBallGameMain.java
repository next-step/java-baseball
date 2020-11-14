package baseball;

import baseball.domain.Balls;
import baseball.domain.BaseBallGame;
import baseball.domain.RandomBallMaker;
import baseball.domain.Status;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class BaseBallGameMain {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomBallMaker());
        boolean play = true;

        while(play) {
            baseBallGame.generateBalls();
            play(baseBallGame);

            play = InputView.isContinue();
        }
    }

    private static void play(BaseBallGame baseBallGame) {
        Balls balls;

        do {
            balls = InputView.balls();
            Map<Status, Integer> status = baseBallGame.play(balls);
            OutputView.printResult(status);
        } while (!isDone(baseBallGame, balls));
    }

    private static boolean isDone(BaseBallGame baseBallGame, Balls balls) {
        return baseBallGame.isDone(balls);
    }
}
