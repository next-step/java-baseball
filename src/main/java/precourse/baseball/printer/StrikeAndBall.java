package precourse.baseball.printer;

import precourse.baseball.referee.Point;

import static precourse.baseball.printer.PrintMessage.BALL;
import static precourse.baseball.printer.PrintMessage.STRIKE;

public class StrikeAndBall implements ResultMessageCondition {

  @Override
  public Boolean isSatisfiedBy(Point strike, Point ball) {
    return strike.atLeastOnce() && ball.atLeastOnce();
  }

  @Override
  public String getMessage(Point strike, Point ball) {
    return strike.getCnt() + " " + STRIKE.getMessage() + " " + ball.getCnt() + " " + BALL.getMessage();
  }
}
