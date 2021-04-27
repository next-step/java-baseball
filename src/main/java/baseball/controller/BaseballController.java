package baseball.controller;

import baseball.domain.BallFactory;
import baseball.domain.Balls;
import baseball.domain.Referee;
import baseball.domain.ScoreBoard;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {

  public void gameStart() {
    Balls computerBalls = BallFactory.createComputerBalls();
    boolean numberMatched = true;

    do {
      Balls userBalls = InputView.inputNumbers();

      Referee referee = new Referee(computerBalls, userBalls);
      ScoreBoard scoreBoard = referee.judge();

      ResultView.printScore(scoreBoard);
      numberMatched = scoreBoard.isThreeStrike();
    } while (!numberMatched);
  }
}
