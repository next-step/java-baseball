package baseball;

import baseball.domain.BaseBall;
import baseball.domain.RandomNumber;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Game {
    public static void main(String[] args) {
        do {
            start();
        } while (InputView.restartNumber() == 1);
    }

    private static void start() {
        BaseBall baseBall = BaseBall.of(new RandomNumber());
        int countStrike;
        do {
            BaseBall inputBaseBall = BaseBall.of(InputView.numbers());
            countStrike = baseBall.countStrike(inputBaseBall);
            int countBall = baseBall.countBall(inputBaseBall);
            ResultView.printScore(countStrike, countBall);
        } while (countStrike != 3);
    }
}
