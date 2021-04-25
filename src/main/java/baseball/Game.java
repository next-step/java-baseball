package baseball;

import baseball.domain.BaseBall;
import baseball.domain.RandomNumber;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Game {
    public static void main(String[] args) {
        BaseBall baseBall = BaseBall.ofRandom(new RandomNumber());
        BaseBall inputBaseBall = BaseBall.of(InputView.numbers());
        while (baseBall.countStrike(inputBaseBall) != 3) {
            ResultView.printScore(baseBall.countStrike(inputBaseBall), baseBall.countBall(inputBaseBall));
            inputBaseBall = BaseBall.of(InputView.numbers());
        }
    }
}
