package baseball;

import baseball.domain.BaseBall;
import baseball.domain.RandomStrategy;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

  public static void main(String[] args) {
    do {
      playGame();
    } while (InputView.isWantReplay());
  }

  private static void playGame() {
    BaseBall baseball = BaseBall.createBaseball(new RandomStrategy());

    int strikeCount = 0;
    while (strikeCount != 3) {
      BaseBall playBall = BaseBall.createPlayBall(InputView.getNumbers());
      strikeCount = baseball.getStrikeCount(playBall);
      int ballCount = baseball.getBallCount(playBall);
      ResultView.print(strikeCount, ballCount);
    }
    ResultView.printEnd();
  }

}
