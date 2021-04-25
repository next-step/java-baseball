package precourse.baseball.printer;

import precourse.baseball.referee.Point;

import static precourse.baseball.printer.PrintMessage.NOTHING;

public class Nothing implements ResultMessageCondition {

  @Override
  public Boolean isSatisfiedBy(Point strike, Point ball) {
    return !strike.atLeastOnce() && !ball.atLeastOnce();
  }

  @Override
  public String getMessage(Point strike, Point ball) {
    return NOTHING.getMessage();
  }
}
