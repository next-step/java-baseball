package precourse.baseball.printer;

import precourse.baseball.referee.Point;

public interface ResultMessageCondition {

  Boolean isSatisfiedBy(Point strike, Point ball);

  String getMessage(Point strike, Point ball);
}
