package baseball.controller;

import baseball.domain.BallFactory;
import baseball.domain.Balls;
import baseball.view.InputView;

public class BaseballController {

  public void gameStart() {
    Balls userBalls = InputView.inputNumbers();
    Balls computerBalls = BallFactory.createComputerBalls();


  }
}
