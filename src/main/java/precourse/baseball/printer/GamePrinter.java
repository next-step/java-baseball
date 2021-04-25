package precourse.baseball.printer;

import precourse.baseball.referee.Point;

import java.util.List;
import java.util.Map;

import static precourse.baseball.printer.PrintMessage.BALL;
import static precourse.baseball.printer.PrintMessage.STRIKE;

public class GamePrinter {

  private final List<ResultMessageCondition> resultMessageConditions;

  public GamePrinter(List<ResultMessageCondition> conditions) {
    resultMessageConditions = conditions;
  }

  public void print(PrintMessage message) {
    System.out.print(message.getMessage());
  }

  public void print(Map<PrintMessage, Point> result) {
    Point strike = result.get(STRIKE);
    Point ball = result.get(BALL);

    for (ResultMessageCondition condition : resultMessageConditions) {
      if (condition.isSatisfiedBy(strike, ball)) {
        System.out.println(condition.getMessage(strike, ball));
        break;
      }
    }
  }
}
