package precourse.baseball.referee;

import precourse.baseball.printer.PrintMessage;

import java.util.HashMap;
import java.util.Set;

import static precourse.baseball.printer.PrintMessage.BALL;
import static precourse.baseball.printer.PrintMessage.STRIKE;

public class Referee {

  private final Point strike;
  private final Point ball;

  public Referee(Point strike, Point ball) {
    this.strike = strike;
    this.ball = ball;
  }

  public HashMap<PrintMessage, Point> judge(int[] expect, Set<Integer> answer) {
    init();
    calculate(expect, answer);

    return new HashMap<PrintMessage, Point>() {{
      put(STRIKE, strike);
      put(BALL, ball);
    }};
  }

  private void calculate(int[] expect, Set<Integer> answer) {
    int index = 0;
    for (int answerNumber : answer) {
      int expectNumber = expect[index++];
      if (isStrike(answerNumber, expectNumber)) {
        continue;
      }
      isBall(expectNumber, answer);
    }
  }

  private Boolean isStrike(int answerNumber, int expectNumber) {
    if (answerNumber == expectNumber) {
      strike.increment();
      return true;
    }

    return false;
  }

  private void isBall(int expectNumber, Set<Integer> answer) {
    if (answer.contains(expectNumber)) {
      ball.increment();
    }
  }

  private void init() {
    strike.init();
    ball.init();
  }

  public boolean isStrikeThreeTimes() {
    return strike.threeTimes();
  }
}
