package baseball.controller;

import baseball.domain.BallFactory;
import baseball.domain.Balls;
import baseball.domain.Referee;
import baseball.domain.ScoreBoard;
import baseball.view.InputView;

public class BaseballController {

  public void gameStart() {
    Balls userBalls = InputView.inputNumbers();
    Balls computerBalls = BallFactory.createComputerBalls();

    //computerBalls.calculateScore(userBalls);
    Referee referee = new Referee(computerBalls, userBalls);
    ScoreBoard result = referee.judge();


  }
}
